<template>
<v-app>
  <v-row class="fill-height">
    <v-col>
      <v-sheet height="64">
        <v-toolbar flat>
          <v-btn
            class="mr-4"
            color="blue"
            @click="component = 'add-visit'"
          >
            Add Consultation
          </v-btn>
          <v-btn
            outlined
            class="mr-4"
            color="grey darken-2"
            @click="setToday"
          >
            Today
          </v-btn>
          <v-btn
            fab
            text
            small
            color="grey darken-2"
            @click="prev"
          >
            <v-icon small>
              mdi-chevron-left
            </v-icon>
          </v-btn>
          <v-btn
            fab
            text
            small
            color="grey darken-2"
            @click="next"
          >
            <v-icon small>
              mdi-chevron-right
            </v-icon>
          </v-btn>
          <v-toolbar-title v-if="$refs.calendar">
            {{ $refs.calendar.title }}
          </v-toolbar-title>
          <v-spacer></v-spacer>
          <v-menu
            bottom
            right
          >
            <template v-slot:activator="{ on, attrs }">
              <v-btn
                outlined
                color="grey darken-2"
                v-bind="attrs"
                v-on="on"
              >
                <span>{{ typeToLabel[type] }}</span>
                <v-icon right>
                  mdi-menu-down
                </v-icon>
              </v-btn>
            </template>
            <v-list>
              <v-list-item @click="type = 'day'">
                <v-list-item-title>Day</v-list-item-title>
              </v-list-item>
              <v-list-item @click="type = 'week'">
                <v-list-item-title>Week</v-list-item-title>
              </v-list-item>
              <v-list-item @click="type = 'month'">
                <v-list-item-title>Month</v-list-item-title>
              </v-list-item>
              <v-list-item @click="type = '4day'">
                <v-list-item-title>4 days</v-list-item-title>
              </v-list-item>
            </v-list>
          </v-menu>
        </v-toolbar>
      </v-sheet>
      <v-sheet height="600">
        <v-calendar
          ref="calendar"
          v-model="focus"
          color="primary"
          :events="events"
          :event-color="getEventColor"
          :type="type"
          @click:event="showEvent"
          @click:more="viewDay"
          @click:date="viewDay"
        ></v-calendar>
        <v-menu
          v-model="selectedOpen"
          :close-on-content-click="false"
          :activator="selectedElement"
          offset-x
        >
          <v-card
            color="grey lighten-4"
            min-width="350px"
            flat
          >
            <v-toolbar
              :color="selectedEvent.color"
              dark
            >

              <v-toolbar-title v-html="selectedEvent.name"></v-toolbar-title>
              <v-spacer></v-spacer>

              <v-btn
                class="ma-1"
                color="error"
                plain
                @click="removeVisit()"
              >
                Delete
              </v-btn>

            </v-toolbar>

            <v-card-text>
              Start: <span v-html="new Date(selectedEvent.start).toLocaleString()"></span>
              <v-spacer></v-spacer>
              End: <span v-html="new Date(selectedEvent.end).toLocaleString()"></span>
              <v-spacer></v-spacer>
              Duration: <span v-html="selectedEvent.duration"></span> min
              <v-spacer></v-spacer>
              Price: <span v-html="selectedEvent.price"></span> din
              <v-spacer></v-spacer>
              Status: <span v-html="this.status"></span>
              <v-spacer></v-spacer>
              Staff: <span v-html="new String(this.selected_staff.firstname + ' ' + this.selected_staff.lastname)"></span>
            </v-card-text>

            
            <v-card-actions>
              <v-btn
                text
                color="secondary"
                @click="selectedOpen = false"
              >
                Cancel
              </v-btn>
            </v-card-actions>
          </v-card>
        </v-menu>
      </v-sheet>
    </v-col>
  </v-row>

  <component :adminINF ="{userId : user_id, apotecary_id : apotecary_id}"  v-bind:is="component" v-on:refresh="refreshCalendar"> </component>

</v-app>
</template>

<script>

import axios from "axios";

import AddNewVisit from "@/components/Administrator/AddNewVisit";

export default ({
  components: {
    'add-visit' : AddNewVisit,
  },

    name: 'Calendar',

    data: () => ({
        mode: 'stack',
        modes: ['stack', 'column'],
        weekday: [0, 1, 2, 3, 4, 5, 6],
        weekdays: [
        { text: 'Sun - Sat', value: [0, 1, 2, 3, 4, 5, 6] },
        { text: 'Mon - Sun', value: [1, 2, 3, 4, 5, 6, 0] },
        { text: 'Mon - Fri', value: [1, 2, 3, 4, 5] },
        { text: 'Mon, Wed, Fri', value: [1, 3, 5] },
        ],
        value: '',
        events: [],
        colors: ['blue', 'orange'],
        names: ['Meeting', 'Holiday', 'PTO', 'Travel', 'Event', 'Birthday', 'Conference', 'Party'],

        today: new Date().toISOString().substr(0,10),
        focus: new Date().toISOString().substr(0,10),
        type: "month",
        typeToLabel: {
            month: "Month",
            week: "Week",
            day: "Day",
            "4day": "4 Days"
        },
        
        name: null,
        details: null,
        start: null,
        end: null,
        color: "#1976D1",
        currenlyEditing: null,
        selectedEvent: {},
        selectedElement: null,
        selectedOpen: false,
        event: [],
        dialog: false,

        visits : [],
        consultations : [],

        dermatologists: [],
        pharmacists: [],

        component: '',

        user_id : Number,
        apotecary_id : Number,

        selected_staff: '',
        status: ''

    }),
    props: {
      adminINF: Object
    },

    mounted(){

      this.apotecary_id = this.adminINF.apotecary_id;
      this.user_id = this.adminINF.userId;

      axios.post("/api/consultation/get-all-consultations", {id: 10})
          .then((response) => {
            this.consultations = response.data;

            axios.post("/api/visit/get-all-visits", {id: 10})
              .then((response) => {
                this.visits = response.data;

                for (let consultation of this.consultations) {

                  let startDate = new Date(consultation.startDate + ' ' +  consultation.startTime);
                  let endDate = new Date(startDate);
                  endDate.setMinutes(startDate.getMinutes() + consultation.duration);

                  this.events.push({
                    name: "Konsultacija",
                    start: startDate,
                    end: endDate,
                    color: "blue",
                    timed: 60,
                    category: "Konsultacija",
                    duration: consultation.duration,
                    price: consultation.price,
                    status: consultation.status,
                    staff_id: consultation.pharmacist_id
                  })
                }

                for (let visit of this.visits) {

                  let startDate = new Date(visit.startDate + ' ' +  visit.startTime);
                  let endDate = new Date(startDate);
                  endDate.setMinutes(startDate.getMinutes() + visit.duration);

                  this.events.push({
                    name: "Poseta",
                    start: startDate,
                    end: endDate,
                    color: "red",
                    timed: 60,
                    category: "Poseta",
                    duration: visit.duration,
                    price: visit.price,
                    status: visit.status,
                    staff_id: visit.dermatologis_id
                  })
                }
              });
          });
    },
    methods:{

      refreshCalendar(){
        this.event = [];
        alert("refresh")
        axios.post("/api/consultation/get-all-consultations", {id: this.apotecary_id})
          .then((response) => {
            this.consultations = response.data;

            axios.post("/api/visit/get-all-visits", {id: this.apotecary_id})
              .then((response) => {
                this.visits = response.data;

                for (let consultation of this.consultations) {

                  let startDate = new Date(consultation.startDate + ' ' +  consultation.startTime);
                  let endDate = new Date(startDate);
                  endDate.setMinutes(startDate.getMinutes() + consultation.duration);

                  this.events.push({
                    id: consultation.id,
                    name: "Konsultacija",
                    start: startDate,
                    end: endDate,
                    color: "blue",
                    timed: 60,
                    category: "Konsultacija",
                    duration: consultation.duration,
                    price: consultation.price,
                    status: consultation.status,
                    staff_id: consultation.pharmacist_id
                  })
                }

                for (let visit of this.visits) {

                  let startDate = new Date(visit.startDate + ' ' +  visit.startTime);
                  let endDate = new Date(startDate);
                  endDate.setMinutes(startDate.getMinutes() + visit.duration);

                  this.events.push({
                    id: visit.id,
                    name: "Poseta",
                    start: startDate,
                    end: endDate,
                    color: "red",
                    timed: 60,
                    category: "Poseta",
                    duration: visit.duration,
                    price: visit.price,
                    status: visit.status,
                    staff_id: visit.dermatologis_id
                  })
                }
              });
          });
      },

      removeVisit(){
        axios.post("/api/visit/delete", {id: this.selectedEvent.id})
          .then(() => {
            
            for (let visit of this.events) {

              if(visit == this.selectedEvent.id){
                this.events = this.events.filter(obj => obj !== visit);
              }
            }

            }).catch(err => {
              if (err.response.status === 406) {
                alert("Removing visit not possible!");
              }
            })
      },

      setToday () {
        this.focus = ''
      },
      prev () {
        this.$refs.calendar.prev()
      },
      next () {
        this.$refs.calendar.next()
      },

      showEvent({nativeEvent, event}){
        const open = () => {
          this.selectedEvent = event;
          this.selectedElement = nativeEvent.target;
          setTimeout(() => this.selectedOpen = true,10);
        }
          if(this.selectedOpen) {
            this.selectedOpen = false;
            setTimeout(open,10);
          }
          else{
            open();
          }

          if(this.selectedEvent.name == "Konsultacija"){
            axios.post("/api/pharmacist/get-one", {id : this.selectedEvent.staff_id})
                        .then(response => {
                            this.selected_staff = response.data;
                        })
        }else if(this.selectedEvent.name == "Poseta"){
            axios.post("/api/dermatologist/get-one", {id : this.selectedEvent.staff_id})
                  .then(response => {
                        this.selected_staff = response.data;
                      })     
        }

        let temp = new Number(this.selectedEvent.status);

        if(temp == 0){
          this.status = "Pending"
        }
        else if (temp == 1){
          this.status = "Accepted"
        }
        else if (temp == 3){
          this.status = "Delined"
        }

          nativeEvent.stopPropagation();
        
      },


      rnd (a, b) {
        return Math.floor((b - a + 1) * Math.random()) + a
      },

      getEventColor (event) {
        return event.color
      },

      viewDay ({ date }) {
        this.focus = date
        this.type = 'day'
      },
}
})
</script>
