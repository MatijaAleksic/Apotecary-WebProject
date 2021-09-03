<template>
<div>
    <h3> Patient Events </h3>

    <input type="text" v-model="searchName" placeholder="Name"/>
    <input type="text" v-model="searchLastname" placeholder="Lastname"/>

    <table>
        <tr bgcolor='lightgrey'>
            <th><div @click="sortBy('id')" class="sortBy">ID</div></th>
            <th><div @click="sortBy('startDate')" class="sortBy">Start Date</div></th>
            <th><div @click="sortBy('startTime')" class="sortBy">Start Time</div></th>
            <th><div @click="sortBy('duration')" class="sortBy">Duration</div></th>
            <th><div @click="sortBy('price')" class="sortBy">Price</div></th>
            <th><div @click="sortBy('report')" class="sortBy">Report</div></th>
            <th><div @click="sortBy('firstname')" class="sortBy">Firstname</div></th>
            <th><div @click="sortBy('lastname')" class="sortBy">Lastname</div></th>
            <th><div @click="sortBy('category')" class="sortBy">Category</div></th>
        </tr>

        <tr v-for="event in fillteredEvents"  v-bind:key="event.id"> 
            <td> {{event.id}}</td>
            <td> {{event.startDate}}</td>
            <td> {{event.startTime}}</td>
            <td> {{event.duration}}</td>
            <td> {{event.price}}</td>
            <td> {{event.report}}</td>
            <td> {{event.firstname}}</td>
            <td> {{event.lastname}}</td>
            <td> {{event.category}}</td>
        </tr>
    </table>

    <div>
          <h5>{{ msg }}</h5>
    </div>
</div>
</template>

<script>


import axios from "axios";

export default {
    name: "PatientEventTable",

    data(){
        return{
        events : [],

        searchName: "",
        searchLastname: "",

        msg: "",

        userId : null,

        accessToken : null
        }
    },

    props: { 
        apotecaryID: Object
    },

    mounted() {

        this.userId = this.apotecaryID.userId;
        this.accessToken = this.apotecaryID.accessToken;

        axios.post("/api/patient/get-events", {id : this.userId},
          {
            headers: {
              'Authorization': `Bearer ${this.accessToken}`
            },
          })
            .then(response => {
                this.events = response.data;
            })
    },

    methods: {
        sortBy(prop) {
            this.events.sort((a, b) => a[prop] < b[prop] ? -1 : 1)
        },

    },

    computed: {
        fillteredEvents: function() {
            return this.events.filter( (elem) => {
                return elem.firstname.toLowerCase().match(this.searchName.toLowerCase()) && elem.lastname.toLowerCase().match(this.searchLastname.toLowerCase())
        });
    }

  }
}
</script>

<style scoped>
</style>