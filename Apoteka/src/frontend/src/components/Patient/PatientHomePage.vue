<template>
  <div>
    <header>
      <patient-nav-bar v-on:change-main-component="changeMainComponent"></patient-nav-bar>
    </header>

      <component :patiINFO ="{userId : this.userId}" v-bind:is="component"> </component>

  </div>
    
</template>

<script>

//import axios from "axios";

import PatientNavBar from "./PatientNavBar";
import PatientProfile from "@/components/Profiles/PatientProfile.vue";
import ApotecaryPatientProfile from "@/components/Profiles/ApotecaryPatientProfile.vue";

export default {
  name: "PatientHomePage",

  props: {
    userInfo: Object
  },

components:{
  'patient-nav-bar' : PatientNavBar,

  'patient-profile' : PatientProfile,
  'apotecary-profile' : ApotecaryPatientProfile,

},

 data(){
    return{
      userId : Number,

      component: '',
      
    }
  },

  mounted() {
    this.userId = this.userInfo.userId;
    this.component = 'apotecary-profile';
    /*axios.post("/api/administrator/get-apotecary-id", {id : this.userId})
          .then((response) => {
            this.apotecary_id = response.data;
            this.component = 'apotecary-profile';
          });*/
    },
    

  methods: {
    changeMainComponent(value)
    {
      if(value == 'profile')
      {
        this.component = 'patient-profile';
      }
      else{
        this.component = 'apotecary-profile';
      }
    },

    selectApotecary(value)
    {
      this.selectedApotecary = value;
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