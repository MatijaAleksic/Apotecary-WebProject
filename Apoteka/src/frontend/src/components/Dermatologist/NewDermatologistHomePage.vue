<template>
  <div>
    <div>
      <h1>Dermatologist homepage</h1>
      <button v-on:click="component ='dermatologist-profile'">Profile</button>
      <button v-on:click="component ='patient-table'">Patient table</button>
      <button v-on:click="component ='vacation'">Vacation</button>
    </div>
    <component v-if="component != null" :adminINFO ="{userId : userId, apotecary_id : apotecary_id}" v-bind:is="component"> </component>
  </div>

</template>

<script>
import DermatologistProfilePage from "@/components/Dermatologist/DermatologistProfilePage";
import DermatologistPatientTable from "@/components/Tables/DermatologistPatientTable";
import axios from "axios";
import DermatologistVacation from "@/components/Dermatologist/DermatologistVacation";

export default {
  name: "DermatologistHomePage",
  components:{
    'dermatologist-profile': DermatologistProfilePage,
    'patient-table': DermatologistPatientTable,
    'vacation': DermatologistVacation,
  },
  props: {
    userInfo: Object
  },
  data(){
    return{
      userId : Number,
      apotecary_id : null,

      component:null,
    }
  },

  mounted() {
    this.userId = this.userInfo.userId;
    alert(this.userId)
    axios.post("/api/dermatologist/get-apotecary-id", {id : this.userId})
        .then((response) => {
          this.apotecary_id = response.data;
        });
  }
}
</script>

<style scoped>

</style>