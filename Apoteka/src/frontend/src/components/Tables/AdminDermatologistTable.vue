<template>
<div>
    <h3> Dermatologist Table </h3>

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
            <th><div @click="sortBy('dermatologistRating')" class="sortBy">Rating</div></th>
        </tr>

        <tr v-for="derma in fillteredDermatologist"  v-bind:key="derma.id"> 
            <td> {{derma.id}}</td>
            <td> {{derma.firstname}}</td>
            <td> {{derma.lastname}}</td>
            <td> {{derma.username}}</td>
            <td> {{derma.email}}</td>
            <td> {{derma.adress}}</td>
            <td> {{derma.city}}</td>
            <td> {{derma.country}}</td>
            <td> {{derma.phone}}</td>
            <td> {{derma.startHours}}</td>
            <td> {{derma.endHours}}</td>
            <td> {{derma.apotecary_id}}</td>
            <td> {{derma.dermatologistRating}}</td>
            <td><button v-on:click="deleteDermatologist(derma.id)">Delete</button></td>
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
    name: "DermatologistTable",

    data(){
        return{
        dermatologists : [],

        mode: "BROWSE",
        selectedDermatologist: {},
        searchField: "",

        searchFirstname: "",
        searchLastname: "",

        apotecary_id : null,

        msg: "",
        accessToken : null
        }
    },

    props: {
        adminINF: Object
    },

    created() {

        this.apotecary_id = this.adminINF.apotecary_id;
        this.accessToken = this.adminINF.accessToken;
        axios.post("/api/dermatologist/get-all-admin", {id : this.apotecary_id}, 
    {
      headers: {
        'Authorization': `Bearer ${this.accessToken}`
      },
      })
            .then(response => {
                this.dermatologists = response.data;
            })
    },

    methods: {

        deleteDermatologist(identification){
            axios.post("/api/dermatologist/delete", {id: identification}, 
    {
      headers: {
        'Authorization': `Bearer ${this.accessToken}`
      },
      })
            .then(response => {
                this.msg = response.data;
                this.refresh();
            })
        },

        refresh(){
            axios.post("/api/dermatologist/get-all-admin", {id : this.apotecary_id}, 
    {
      headers: {
        'Authorization': `Bearer ${this.accessToken}`
      },
      })
            .then(response => {
                this.dermatologists = response.data;
            })
        },

        sortBy(prop) {
            this.dermatologists.sort((a, b) => a[prop] < b[prop] ? -1 : 1)
        },
    },

    computed: {
        fillteredDermatologist: function() {
            return this.dermatologists.filter( (elem) => {
                return elem.firstname.toLowerCase().match(this.searchFirstname.toLowerCase()) && elem.lastname.toLowerCase().match(this.searchLastname.toLowerCase())
        });
    }

  }
}
</script>

<style scoped>
</style>