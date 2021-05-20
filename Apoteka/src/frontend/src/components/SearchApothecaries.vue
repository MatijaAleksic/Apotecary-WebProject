<template>
  <div class="input-group rounded">
    <input type="search" class="form-control rounded" placeholder="Search" aria-label="Search"
           aria-describedby="search-addon" v-model = "search" />
    <span class="input-group-text border-0" id="search-addon">
    <i class="fas fa-search"></i>
  </span>
  </div>
  <ol class="list-group list-group-numbered">
    <li class="list-group-item d-flex justify-content-between align-items-start" v-for="apothecary in searchHandler" :key="apothecary.name">
      <div class="ms-2 me-auto">
        <div class="fw-bold"><strong>{{ apothecary.name }}</strong></div>
        {{apothecary.address}}
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
      apothecaryList : [],
      search: '',
    }
  },

  created() {
    axios
        .get("/api/apotecary/list")
        .then(response => this.apothecaryList = response.data)
  },

  computed: {
    searchHandler() {
      return this.apothecaryList.filter(elem => {
        return elem.name.toLowerCase().includes(this.search.toLowerCase())
      });
    }
  }
}
</script>

<style scoped>

</style>