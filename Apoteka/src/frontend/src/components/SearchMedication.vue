<template>
  <div class="input-group rounded">
    <input type="search" class="form-control rounded" placeholder="Search" aria-label="Search"
           aria-describedby="search-addon" v-model = "search" />
    <span class="input-group-text border-0" id="search-addon">
    <i class="fas fa-search"></i>
  </span>
  </div>
  <ol class="list-group list-group-numbered">
    <li class="list-group-item d-flex justify-content-between align-items-start" v-for="med in searchHandler" :key="med.name">
      <div class="ms-2 me-auto">
        <div class="fw-bold"><strong>{{ med.name }}</strong></div>
        {{med.specification}}
      </div>
      <span class="badge bg-primary rounded-pill">14</span>
    </li>
  </ol>
</template>

<script>
import axios from "axios";

export default {
  name: "SearchApothecaries",

  data(){
    return{
      medicationList : [],
      search: '',
    }
  },

  created() {
    axios
        .get("/api/medication/list")
        .then(response => this.medicationList = response.data)
  },

  computed: {
    searchHandler() {
      return this.medicationList.filter(elem => {
        return (elem.name.toLowerCase().includes(this.search.toLowerCase()) || elem.specification.toLowerCase().includes(this.search.toLowerCase()))
      });
    }
  }
}
</script>

<style scoped>

</style>