<template>
<div>
            <v-btn v-on:click="component ='apotecary-table'">Apotecary Table</v-btn>

        <component v-on:refresh-component="refreshComponent" :adminINF ="{userId : userId, apotecary_id : apotecary_id}" v-bind:is="component"> </component>
</div>
</template>

<script>

import ApotecaryTable from '@/components/Tables/ApotecaryTable.vue';


//import axios from "axios";

export default {
  name: "ApotecaryPatientProfile",

    props: {
        adminINFO: Object
    },

  components:{
    'apotecary-table': ApotecaryTable,
  },


  data(){
    return{
      component: null,

      userId : Number,
    }
  },

  mounted() {
    this.userId = this.patiINFO.userId;
    },

    methods: {

        refresh(){
            alert("refresh!")
        },

        refreshComponent(){
            this.component = null;
            this.refresh();
        }
    }
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