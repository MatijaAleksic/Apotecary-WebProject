<template>
<div>
    <h3> Pharmacist Table </h3>

    <input type="text" v-model="searchFirstname" placeholder="Firstname"/>
    <input type="text" v-model="searchLastname" placeholder="Lastname"/>

    <table>
        <tr bgcolor='lightgrey'>
            <th><div @click="sortBy('id')" class="sortBy">ID</div></th>
            <th><div @click="sortBy('firstname')" class="sortBy">Firstname</div></th>
            <th><div @click="sortBy('lastname')" class="sortBy">Lastname</div></th>
            <th><div @click="sortBy('username')" class="sortBy">Username</div></th>
            <th><div @click="sortBy('email')" class="sortBy">Email</div></th>
            <th><div @click="sortBy('adress')" class="sortBy">Address</div></th>
            <th><div @click="sortBy('city')" class="sortBy">City</div></th>
            <th><div @click="sortBy('country')" class="sortBy">Country</div></th>
            <th><div @click="sortBy('phone')" class="sortBy">Phone</div></th>
            <th><div @click="sortBy('startHours')" class="sortBy">Start Hours</div></th>
            <th><div @click="sortBy('endHours')" class="sortBy">End Hours</div></th>
            <th><div @click="sortBy('apotecary_id')" class="sortBy">Apotecary ID</div></th>
            <th><div @click="sortBy('pharmacistRating')" class="sortBy">Rating</div></th>
        </tr>

        <tr v-for="pharma in fillteredPharmacist"  v-bind:key="pharma.id"> 
            <!-- v-on:click="selectPharmacist(p)" -->
            <td> {{pharma.id}}</td>
            <td> {{pharma.firstname}}</td>
            <td> {{pharma.lastname}}</td>
            <td> {{pharma.username}}</td>
            <td> {{pharma.email}}</td>
            <td> {{pharma.adress}}</td>
            <td> {{pharma.city}}</td>
            <td> {{pharma.country}}</td>
            <td> {{pharma.phone}}</td>
            <td> {{pharma.startHours}}</td>
            <td> {{pharma.endHours}}</td>
            <td> {{pharma.apotecary_id}}</td>
            <td> {{pharma.pharmacistRating}}</td>
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
    name: "PharmacistTable",

    data(){
        return{
        pharmacists : [],

        selectedPharmacist: {},
        searchField: "",

        searchFirstname: "",
        searchLastname: "",

        apotecary_id : null,

        msg: "",

        accessToken : null
        }
    },

    props: {
        apotecaryID: Object
    },

    mounted() {
        this.apotecary_id = this.apotecaryID.apotecary_id;
        this.accessToken = this.apotecaryID.accessToken;

        axios.post("/api/pharmacist/get-all-admin", {id : this.apotecary_id},
          {
            headers: {
              'Authorization': `Bearer ${this.accessToken}`
            },
          })
            .then(response => {
                this.pharmacists = response.data;
            })
   
    },

    methods: {

        refresh(){
            axios.post("/api/pharmacist/get-all-admin", {id : this.apotecary_id},
          {
            headers: {
              'Authorization': `Bearer ${this.accessToken}`
            },
          })
            .then(response => {
                this.pharmacists = response.data;
            })
        },

        sortBy(prop) {
            this.pharmacists.sort((a, b) => a[prop] < b[prop] ? -1 : 1)
        },
    },

    computed: {
        fillteredPharmacist: function() {
            return this.pharmacists.filter( (elem) => {
                return elem.firstname.toLowerCase().match(this.searchFirstname.toLowerCase()) && elem.lastname.toLowerCase().match(this.searchLastname.toLowerCase())
            });
        }
    }
}
</script>

<style scoped>
</style>