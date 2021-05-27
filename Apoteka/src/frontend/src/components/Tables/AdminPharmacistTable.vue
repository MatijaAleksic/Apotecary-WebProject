<template>
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
            <td><button v-on:click="deletePharmacist(pharma.id)">Delete</button></td>
        </tr>
    </table>
    <div>
          <h5>{{ msg }}</h5>
        </div>
</template>

<script>


import axios from "axios";
export default {
    name: "AdminPharmacistTable",

    data(){
        return{
        pharmacists : [],

        mode: "BROWSE",
        selectedPharmacist: {},
        searchField: "",

        searchFirstname: "",
        searchLastname: "",

        apotecary_id : null,

        msg: ""
        }
    },

    props: {
        adminINFO: Object
    },

    mounted() {
        this.apotecary_id = this.adminINFO.apotecary_id;

        axios.post("/api/pharmacist/get-all-admin", {id : this.apotecary_id})
            .then(response => {
                this.pharmacists = response.data;
            })
   
    },

    methods: {

        deletePharmacist(identification){
            axios.post("/api/pharmacist/delete", {id: identification})
            .then(response => {
                this.msg = response.data;
                this.refresh();
            })
        },

        refresh(){
            axios.post("/api/pharmacist/get-all-admin", {id : this.apotecary_id})
            .then(response => {
                this.pharmacists = response.data;
            })
        }
    },

    computed: {
        fillteredPharmacist: function() {
            return this.pharmacists.filter( (elem) => {
                return elem.firstname.match(this.searchFirstname) && elem.lastname.match(this.searchLastname)
            });
        }
    }
}
</script>

<style scoped>
</style>