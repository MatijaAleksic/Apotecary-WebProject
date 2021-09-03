<template>
<div>
    <h3> Medications </h3>

    <input type="text" v-model="searchName" placeholder="Name"/>

    <table>
        <tr bgcolor='lightgrey'>
            <th><div @click="sortBy('id')" class="sortBy">ID</div></th>
            <th><div @click="sortBy('type')" class="sortBy">Type</div></th>
            <th><div @click="sortBy('name')" class="sortBy">Name</div></th>
            <th><div @click="sortBy('composition')" class="sortBy">Composition</div></th>
            <th><div @click="sortBy('contradiction')" class="sortBy">Contradiction</div></th>
            <th><div @click="sortBy('dailyIntake')" class="sortBy">Daily Intake</div></th>
            <th><div @click="sortBy('replacement')" class="sortBy">Replacement</div></th>
            <th><div @click="sortBy('inStorage')" class="sortBy">In Storage</div></th>
            <th><div @click="sortBy('price')" class="sortBy">Price</div></th>
            <th><div @click="sortBy('procentage')" class="sortBy">Action</div></th>
            <th><div @click="sortBy('apotecary_id')" class="sortBy">ApotecaryID</div></th>
            <th><div @click="sortBy('priceDurationEndDate')" class="sortBy">Price Duration EndDate</div></th>
            <th><div @click="sortBy('priceDurationEndTime')" class="sortBy">Price Duration EndTime</div></th>
        </tr>

        <tr v-for="medication in fillteredMedications"  v-bind:key="medication.id"> 
            <td> {{medication.id}}</td>
            <td> {{medication.type}}</td>
            <td> {{medication.name}}</td>
            <td> {{medication.composition}}</td>
            <td> {{medication.contradiction}}</td>
            <td> {{medication.dailyIntake}}</td>
            <td> {{medication.replacement}}</td>
            <td> {{medication.inStorage}}</td>
            <td> {{medication.price}}</td>
            <td> {{medication.procentage}} %</td>
            <td> {{medication.apotecary_id}}</td>
            <td> {{medication.priceDurationEndDate}}</td>
            <td> {{medication.priceDurationEndTime}}</td>
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
    name: "UnsignedMedicationTable",


    data(){
        return{
        medications : [],

        selectedPharmacist: {},
        searchField: "",

        searchName: "",

        apotecary_id : null,
        medication_id: null,

        medInfoId: null,

        msg: "",
        component:null
        }
    },

    props: {
        apotecaryID: Object
    },

    mounted() {
        this.apotecary_id = this.apotecaryID.apotecary_id;

        axios.post("/api/medication-info/get-all", {id : this.apotecary_id})
            .then(response => { 
                this.medications = response.data;
            })
    },


    methods: {


        sortBy(prop) {
            this.medications.sort((a, b) => a[prop] < b[prop] ? -1 : 1)
        },
    },

    computed: {
        fillteredMedications: function() {
            return this.medications.filter( (elem) => {
                return elem.name.toLowerCase().match(this.searchName.toLowerCase())
            });
        }
    }

}
</script>

<style scoped>
</style>