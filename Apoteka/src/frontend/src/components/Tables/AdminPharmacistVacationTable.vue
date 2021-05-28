<template>
    <h3> Pharmacist Vacations </h3>

    <table>
        <tr bgcolor='lightgrey'>
            <th><div @click="sortBy('id')" class="sortBy">ID</div></th>
            <th><div @click="sortBy('startDate')" class="sortBy">Start Date</div></th>
            <th><div @click="sortBy('finishDate')" class="sortBy">End Date</div></th>
            <th><div @click="sortBy('description')" class="sortBy">Description</div></th>
            <th><div @click="sortBy('pharmacist_id')" class="sortBy">PharmacistID</div></th>
            <th><div @click="sortBy('approdved')" class="sortBy">Odobren</div></th>
        </tr>

        <tr v-for="vacation in vacations"  v-bind:key="vacation.id"> 
            <td> {{vacation.id}}</td>
            <td> {{vacation.startDate}}</td>
            <td> {{vacation.finishDate}}</td>
            <td> {{vacation.description}}</td>
            <td> {{vacation.pharmacist_id}}</td>
            <td> {{vacation.approdved}}</td>
            <td><button @click="Accept(vacation.id)">Accept</button></td>
            <td><button @click="Decline(vacation.id)">Decline</button></td>

        </tr>
    </table>
    <div>
        <h5>{{ msg }}</h5>
    </div>

</template>

<script>

import axios from "axios";
export default {
    name: "AdminPharmacistVacationTable",

    data(){
        return{
        vacations : [],

        searchName: "",

        apotecary_id : null,
        medication_id: null,

        medInfoId: null,

        msg: "",
        component:null
        }
    },

    props: {
        adminINFO: Object
    },

    mounted() {
        this.apotecary_id = this.adminINFO.apotecary_id;

        axios.post("/api/pharmacist-vacation/get-all-admin", {id : this.apotecary_id})
            .then(response => {
                this.vacations = response.data;
            })
    },


    methods: {

        Accept(vacID)
        {
            alert("Accept!" + vacID);
        },

        Decline(vacID)
        {
           alert("Decline!" + vacID);
            
        },

        refresh(){
            axios.post("/api/pharmacist-vacation/get-all-admin", {id : this.apotecary_id})
            .then(response => {
                this.vacations = response.data;
            })
        },

        sortBy(prop) {
            this.medications.sort((a, b) => a[prop] < b[prop] ? -1 : 1)
        },

    },
}
</script>

<style scoped>
</style>