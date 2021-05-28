<template>
  <div>
    <div >
      <h1>Pharmacist homepage</h1>
      <button v-on:click="component ='pharmacist-profile'">Profile</button>
      <button v-on:click="component ='patient-table'">Patient table</button>
      <button v-on:click="component ='vacation'">Vacation</button>

    </div>
    <component v-if="component != null" :adminINFO ="{userId : userId, apotecary_id : apotecary_id}" v-bind:is="component"> </component>

  </div>

</template>

<script>
import axios from "axios";
import PharmacistProfilPage from "@/components/Pharmacist/PharmacistProfilPage";
import PharmacistPatientTable from "@/components/Tables/PharmacistPatientTable";
import PharmacistVacation from "@/components/Pharmacist/PharmacistVacation";
export default {
  name: "PharmacistHomePage",
  components: {
    'pharmacist-profile': PharmacistProfilPage,
    'patient-table': PharmacistPatientTable,
    'vacation': PharmacistVacation
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
    axios.post("/api/pharmacist/get-apotecary-id", {id : this.userId})
        .then((response) => {
          this.apotecary_id = response.data;
        });
  }
}
</script>

<style scoped>

</style>