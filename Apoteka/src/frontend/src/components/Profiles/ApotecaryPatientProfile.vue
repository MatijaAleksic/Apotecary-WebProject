<template>
<div>
        <v-btn @click="component = 'medication-table'">Medication Table</v-btn>
        <v-btn @click="component = 'calendar'">Calendar</v-btn>
        <v-btn @click="component ='dermatologist-table'"> Dermatologists</v-btn>
        <v-btn @click="component ='pharmacist-table'">Pharmacists</v-btn>
        <v-btn @click="component = 'event-table'"> My Events </v-btn>

        <component v-on:refresh-component="refreshComponent" :apotecaryID ="{userId : this.userId, apotecary_id : this.selectedApotecary, accessToken : this.accessToken}" v-bind:is="component"> </component>
</div>
</template>

<script>

import UnsignedMedicationTable from '@/components/Tables/UnsignedMedicationTable.vue';
import PatientDermatologistTable from '@/components/Tables/PatientDermatologistTable.vue';
import PatientPharmacistTable from '@/components/Tables/PatientPharmacistTable.vue';
import Calendar from '@/components/Graphical/PatientCalendar.vue';
import PatientEventTable from '@/components/Tables/PatientEventTable.vue';

//import axios from "axios";
// <v-btn v-on:click="component ='apotecary-table'">Apotecary Table</v-btn>

export default {
  name: "ApotecaryPatientProfile",

    props: {
        patiINFO: Object
    },

  components:{
    'medication-table' : UnsignedMedicationTable,
    'dermatologist-table' : PatientDermatologistTable,
    'pharmacist-table' :PatientPharmacistTable,
    'calendar' : Calendar,
    'event-table' : PatientEventTable
  },


  data(){
    return{
      component: null,

      userId : Number,
      selectedApotecary : null,
      accessToken : null
      
    }
  },

  mounted() {
    this.userId = this.patiINFO.userId;
    this.selectedApotecary = this.patiINFO.apotecary_id;
    this.accessToken = this.patiINFO.accessToken;
    },

    methods: {

        refresh(){
            alert("refresh!")
        },

        refreshComponent(){
            this.component = null;
            this.refresh();
        },
        selectApotecary(value)
      {
        this.selectedApotecary = value;
        this.component = 'medication-table'
      }
    },
}
</script>

<style scoped>

label{
    font-size: 18px;
    height: 50px;
    width: 300px;
    padding: 20px 20px;
    justify-content: left;
    display: inline-block;
    text-align: left;
    color: Black;
}

h4 {
    margin: 8px 5px;
    text-align: left;
    justify-content: left;
    display: inline-block;
    box-sizing: border-box;
}

form {
     margin: 10px 10px;
}
</style>