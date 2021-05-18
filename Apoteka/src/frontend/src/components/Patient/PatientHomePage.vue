<template>
  <div>
    <div>
      <h1>Patient homepage</h1>
      <input id="profile" type="button" name="profile" @click="component ='patient-profile'" value="User Profile" />
      <input id="profile-edit" type="button" name="profile-edit" @click="component ='patient-profile-edit'" value="Edit Profile" />
    </div>
    <div class="list">
      <ol>
        <li v-for="apothecary in apothecaryList" v-bind:key="apothecary">{{apothecary}}</li>
      </ol>
    </div>
    <component v-bind:is="component"> </component>
  </div>
</template>

<script>
import PatientProfileCard from "@/components/Patient/PatientProfileCard";
import axios from "axios";
import PatientProfileEdit from "@/components/Patient/PatientProfileEdit";

export default {
  name: "PatientHomePage",
  components:{
    'patient-profile': PatientProfileCard,
    'patient-profile-edit': PatientProfileEdit,
  },
  data(){
    return{
      component:null,
      apothecaryList : [],
    }
  },
  list() {
    axios.get("/api/apotecary/apothecary-list/")
        .then(response => this.apothecaryList = response.data);
  },
}
</script>

<style scoped>

</style>