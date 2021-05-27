<template>
    <h3> Dermatologist Table </h3>

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
        </tr>

        <tr v-for="derma in dermatologists"  v-bind:key="derma.id"> 
            <!-- v-on:click="selectPharmacist(p)" -->
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
            <td><button v-on:click="deleteDermatologist(derma.id)">Delete</button></td>
        </tr>
    </table>
    <div>
          <h5>{{ msg }}</h5>
        </div>
</template>

<script>


import axios from "axios";
export default {
    name: "DermatologistTable",

    data(){
        return{
        dermatologists : null,
        mode: "BROWSE",
        selectedDermatologist: {},
        searchField: "",

        msg: ""
        }
    },

    props: {
    user_id: Number
    },

    mounted() {
        axios.get("/api/dermatologist/get-all")
            .then(response => {
                this.dermatologists = response.data;
            })
   
    },

    methods: {
        selectDermatologist(dermatologist){
            if(this.mode == 'BROWSE'){
                this.selectedDermatologist = dermatologist;
            }
        },

        sortBy(prop) {
            this.dermatologists.sort((a, b) => a[prop] < b[prop] ? -1 : 1)
        },

        deleteDermatologist(identification){
            axios.post("/api/dermatologist/delete", {id: identification})
            .then(response => {
                this.msg = response.data;
                this.refresh();
            })
        },

        refresh(){
            axios.get("/api/dermatologist/get-all")
            .then(response => {
                this.dermatologists = response.data;
            })
        }
    }
}
</script>

<style scoped>
</style>