<template>
  <div>
    <div>
      <h1>Patient homepage</h1>
      <input id="profile" type="button" name="profile" @click="component ='patient-profile'" value="User Profile" />
      <input id="profile-edit" type="button" name="profile-edit" @click="component ='patient-profile-edit'" value="Edit Profile" />
      <input id="list" type="button" name="list" @click="component ='apothecaries'" value="List of Apothecaries" />
    </div>
    <component v-bind:is="component"> </component>
  </div>
</template>

<script>
import PatientProfileCard from "@/components/Patient/PatientProfileCard";
import PatientProfileEdit from "@/components/Patient/PatientProfileEdit";
import ApothecaryList from "@/components/ApothecaryList";

export default {
  name: "PatientHomePage",
  components:{
    'patient-profile': PatientProfileCard,
    'patient-profile-edit': PatientProfileEdit,
    'apothecaries': ApothecaryList,
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