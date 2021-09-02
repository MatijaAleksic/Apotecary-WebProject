<template>
<div>
        <v-btn>Medication Table</v-btn>
        <v-btn>Calendar</v-btn>
        <v-btn>Dermatologists</v-btn>
        <v-btn>Pharmacists</v-btn>

        <component v-on:refresh-component="refreshComponent" :apotecaryID ="{userId : userId, apotecary_id : this.selectApotecary}" v-bind:is="component"> </component>
</div>
</template>

<script>

import UnsignedMedicationTable from '@/components/Tables/UnsignedMedicationTable.vue';

//import axios from "axios";
// <v-btn v-on:click="component ='apotecary-table'">Apotecary Table</v-btn>

export default {
  name: "ApotecaryPatientProfile",

    props: {
        patiINFO: Object
    },

  components:{
    'medication-table' : UnsignedMedicationTable,
  },


  data(){
    return{
      component: null,

      userId : Number,
      selectedApotecary : null
      
    }
  },

  mounted() {
    this.userId = this.patiINFO.userId;
    this.selectedApotecary = this.patiInfo.apotecary_id;
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