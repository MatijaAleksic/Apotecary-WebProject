<template>
  <table class="table">
    <thead>
    <tr>
      <th scope="col">#</th>
      <th scope="col">Name</th>
      <th scope="col">Address</th>
    </tr>
    </thead>
    <tbody>
    <tr v-for="(apothecary, index) in apothecaryList" :key="apothecary.name">
      <th scope="row">{{index+1}}</th>
      <td>{{ apothecary.name }}</td>
      <td>{{ apothecary.address }}</td>
    </tr>
    </tbody>
  </table>
</template>

<script>
import axios from "axios";

export default {
  name: "ApothecaryTable",

  data(){
    return{
      apothecaryList : [],
    }
  },

  mounted() {
    axios
        .get("/api/apotecary/list")
        .then(response => this.apothecaryList = response.data)
  },
}
</script>

<style scoped>

</style>