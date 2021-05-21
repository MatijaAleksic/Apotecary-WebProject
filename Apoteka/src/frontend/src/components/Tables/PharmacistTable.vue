<template>
    <h3> Pharmacist Table </h3>

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

        <tr v-for="pharma in pharmacists"  v-bind:key="pharma.id"> 
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
    name: "PharmacistTable",

    data(){
        return{
        pharmacists : null,
        mode: "BROWSE",
        selectedPharmacist: {},
        searchField: "",

        msg: ""
        }
    },

    props: {
    user_id: Number
    },

    mounted() {
        axios.get("/api/pharmacist/get-all")
            .then(response => {
                this.pharmacists = response.data;
            })
   
    },

    methods: {
        selectPharmacist(pharmacist){
            if(this.mode == 'BROWSE'){
                this.selectedPharmacist = pharmacist;
            }
        },

        deletePharmacist(identification){
            axios.post("/api/pharmacist/delete", {id: identification})
            .then(response => {
                this.msg = response.data;
                this.refresh();
            })
        },

        refresh(){
            axios.get("/api/pharmacist/get-all")
            .then(response => {
                this.pharmacists = response.data;
            })
        }
    }
}
</script>

<style scoped>
</style>