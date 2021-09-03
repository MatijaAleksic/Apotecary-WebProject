<template>
<div>
  <h3> Visit Table </h3>

  <input type="text" v-model="searchFirstname" placeholder="Firstname"/>
  <input type="text" v-model="searchLastname" placeholder="Lastname"/>

  <table>
    <tr bgcolor='lightgrey'>
      <th><div @click="sortBy('id')" class="sortBy">ID</div></th>
      <th><div @click="sortBy('firstname')" class="sortBy">First Name</div></th>
      <th><div @click="sortBy('lastname')" class="sortBy">Last Name</div></th>
      <th><div @click="sortBy('startDate')" class="sortBy">startDate</div></th>
      <th><div @click="sortBy('startTime')" class="sortBy">startTime</div></th>
      <th><div @click="sortBy('duration')" class="sortBy">duration</div></th>
      <th><div @click="sortBy('price')" class="sortBy">price</div></th>
      <th><div @click="sortBy('status')" class="sortBy">status</div></th>
      <th><div @click="sortBy('report')" class="sortBy">report</div></th>
    </tr>

    <tr v-for="visit in fillteredDermatologist"  v-bind:key="visit.id">
      <td> {{visit.id}}</td>
      <td> {{visit.firstname}}</td>
      <td> {{visit.lastname}}</td>
      <td> {{visit.startDate}}</td>
      <td> {{visit.startTime}}</td>
      <td> {{visit.duration}}</td>
      <td> {{visit.price}}</td>
      <td> {{visit.status}}</td>
      <td> {{visit.report}}</td>
      <td><button v-on:click="selectedApotecary(visit.patientId,visit.id)">Start report</button></td>

    </tr>
    <component v-if="component != null" :adminINF ="{visitId: visitId ,userId : patientId, apotecary_id : apotecary_id}" v-bind:is="component"> </component>
  </table>
  <div>
    <h5>{{ msg }}</h5>
  </div>
  </div>
</template>

<script>
import axios from "axios";
import DermatologistCalendar from "@/components/Graphical/DermatologistCalendar";
import ReportVisit from "@/components/Dermatologist/ReportVisit";

export default {
  name: "DermatologistPatientTable",
  components:{
    'visits':ReportVisit,
    'calendar': DermatologistCalendar,
  },

  data(){
    return{
      visits : [],

      mode: "BROWSE",
      selectedPharmacist: {},
      searchField: "",

      searchFirstname: "",
      searchLastname: "",

      apotecary_id : null,
      userId : null,
      patientId : null,
      component:null,
      msg: "",

      visitId: null,
    }
  },

  props: {
    adminINF: Object
  },

  mounted() {
    this.apotecary_id = this.adminINF.apotecary_id;
    this.userId = this.adminINF.userId;


    axios.post("/api/dermatologist/get-all-visits-table", { apotecaryID:this.apotecary_id, dermaID :this.userId})
        .then(response => {
          this.visits = response.data;
        })

  },


  methods: {

    selectedApotecary(id, visitid){
      this.patientId = id;
      this.visitId = visitid;
      this.component = 'visits'

    },

    refresh(){
      axios.post("/api/dermatologist/get-all-visits-table", { apotecaryID:this.apotecary_id,dermaID :this.userId})
          .then(response => {
            this.visits = response.data;
          })
    },
    sortBy(prop) {
      this.visits.sort((a, b) => a[prop] < b[prop] ? -1 : 1)
    },
  },

  computed: {
    fillteredDermatologist: function() {
      return this.visits.filter( (elem) => {
        return elem.firstname.toLowerCase().match(this.searchFirstname) && elem.lastname.toLowerCase().match(this.searchLastname)
      });
    }

  }
}
</script>

<style scoped>

</style>