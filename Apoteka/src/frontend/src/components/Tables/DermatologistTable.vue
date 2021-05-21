<template>
    <h3> Dermatologist Table </h3>

    <table>
        <tr bgcolor='lightgrey'>
            <th>ID</th>
            <th>Firstname</th>
            <th>Lastname</th>
            <th>Username</th> 
            <th>email</th>           
            <th>Address</th>
            <th>City</th>
            <th>Country</th>
            <th>Phone</th>
            <th>Start Hours</th>
            <th>End Hours</th>
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