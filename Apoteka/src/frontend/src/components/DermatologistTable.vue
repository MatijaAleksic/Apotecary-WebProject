<template>
  <table class="table">
    <thead>
    <tr>
      <th scope="col">#</th>
      <th scope="col">First Name</th>
      <th scope="col">Last Name</th>
      <th scope="col">Phone</th>
      <th scope="col">Start - End</th>
    </tr>
    </thead>
    <tbody>
    <tr v-for="(dermatologist, index) in dermatologistList" :key="dermatologist.username">
      <th scope="row">{{index+1}}</th>
      <td>{{ dermatologist.firstname }}</td>
      <td>{{ dermatologist.lastname }}</td>
      <td>{{ dermatologist.phone }}</td>
      <td>{{ dermatologist.startHours }} - {{dermatologist.endHours}}</td>
    </tr>
    </tbody>
  </table>
</template>

<script>
import axios from "axios";

export default {
  name: "DermatologistTable",

  data(){
    return{
      dermatologistList : [],
    }
  },

  mounted() {
    axios
        .get("/api/dermatologist/list")
        .then(response => this.dermatologistList = response.data)
  },
}
</script>

<style scoped>

</style>