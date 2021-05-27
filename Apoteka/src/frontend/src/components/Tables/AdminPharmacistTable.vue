<template>
    <h3> Pharmacist Table </h3>

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
    name: "AdminPharmacistTable",

    data(){
        return{
        pharmacists : null,
        mode: "BROWSE",
        selectedPharmacist: {},
        searchField: "",

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

        sortBy(prop) {
            this.pharmacists.sort((a, b) => a[prop] < b[prop] ? -1 : 1)
        },

        refresh(){
            axios.post("/api/pharmacist/get-all-admin", {id : this.apotecary_id})
            .then(response => {
                this.pharmacists = response.data;
            })
        }
    }
}
</script>

<style scoped>
</style>