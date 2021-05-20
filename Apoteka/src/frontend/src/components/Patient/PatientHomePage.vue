<template>
  <div>
    <div>
      <h1>Patient homepage</h1>
      <input id="profile" type="button" name="profile" @click="component ='patient-profile'" value="User Profile" />
      <input id="profile-edit" type="button" name="profile-edit" @click="component ='patient-profile-edit'" value="Edit Profile" />
      <input id="list" type="button" name="list" @click="component ='apothecaries'" value="List of Apothecaries" />
      <input id="search-apothecaries" type="button" name="search-apothecaries" @click="component ='search-apothecaries'" value="Search Apothecaries" />
      <input id="search-medication" type="button" name="search-medication" @click="component ='search-medication'" value="Search Medication" />
      <input id="tables" type="button" name="tables" @click="component ='tables'" value="Tables" />
    </div>
    <component v-bind:is="component"> </component>
  </div>
</template>

<script>
import PatientProfileCard from "@/components/Patient/PatientProfileCard";
import PatientProfileEdit from "@/components/Patient/PatientProfileEdit";
import ApothecaryList from "@/components/ApothecaryList";
import SearchApothecaries from "@/components/SearchApothecaries";
import SearchMedication from "@/components/SearchMedication";
import Tables from "@/components/Tables";

export default {
  name: "PatientHomePage",
  components:{
    'patient-profile': PatientProfileCard,
    'patient-profile-edit': PatientProfileEdit,
    'apothecaries': ApothecaryList,
    'search-apothecaries': SearchApothecaries,
    'search-medication': SearchMedication,
    'tables': Tables,
  },
  data(){
    return{
      component: null,
    }
  }
}
</script>

<style scoped>

</style>