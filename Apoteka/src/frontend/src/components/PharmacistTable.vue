<template>
  <table class="table">
    <thead>
    <tr>
      <th scope="col">#</th>
      <th scope="col">First Name</th>
      <th scope="col">Last Name</th>
      <th scope="col">Phone</th>
    </tr>
    </thead>
    <tbody>
    <tr v-for="pharmacist in pharmacistList" :key="pharmacist.id">
      <th scope="row">{{pharmacist.id}}</th>
      <td>{{ pharmacist.name }}</td>
      <td>{{ pharmacist.lastName }}</td>
      <td>{{ pharmacist.phone }}</td>
    </tr>
    </tbody>
  </table>
</template>

<script>
import axios from "axios";

export default {
  name: "PharmacistTable",

  data(){
    return{
      pharmacistList : [],
    }
  },

  mounted() {
    axios
        .get("/api/pharmacist/list")
        .then(response => this.pharmacistList = response.data)
  },
}
</script>

<style scoped>

</style>