<template>
  <div>
    <header>
      <patient-nav-bar v-on:change-main-component="changeMainComponent"></patient-nav-bar>
    </header>

      <component v-on:refresh-component="refreshComponent" v-on:selected-apotecary="selectApotecary" :patiINFO ="{userId : this.userId, apotecary_id : this.selectedApotecary, accessToken : this.accessToken}" v-bind:is="component"> </component>

  </div>
    
</template>

<script>

//import axios from "axios";

import PatientNavBar from "./PatientNavBar";
import PatientProfile from "@/components/Profiles/PatientProfile.vue";
import ApotecaryPatientProfile from "@/components/Profiles/ApotecaryPatientProfile.vue";

import PatientApotecaryTable from '@/components/Tables/PatientApotecaryTable.vue';


export default {
  name: "PatientHomePage",

  props: {
    userInfo: Object
  },

components:{
  'patient-nav-bar' : PatientNavBar,
  'patient-profile' : PatientProfile,
  'apotecary-table' : PatientApotecaryTable,

  'apotecary-profile' : ApotecaryPatientProfile,

},

 data(){
    return{
      userId : Number,

      component: '',
      selectedApotecary: null,

      accessToken : null
      
    }
  },

  mounted() {
    this.userId = this.userInfo.userId;
    this.component = 'apotecary-table';
    this.accessToken = this.userInfo.accessToken;
    },
    

  methods: {
    changeMainComponent(value)
    {
      if(value == 'profile')
      {
        this.component = 'patient-profile';
      }
      else{
        this.component = 'apotecary-table';
      }
    },

    selectApotecary(value)
      {
        this.selectedApotecary = value;
        this.component = 'apotecary-profile'
      },

    refreshComponent(){
            this.component = null;
            this.refresh();
        },
  }
}

</script>

<style scoped>

* {
  margin: 0;
  padding: 0;
  box-sizing: border-box;
}

header{
  width: 100vw;
  background-color: #5f9ea0;
  padding: 15px;
}

</style>