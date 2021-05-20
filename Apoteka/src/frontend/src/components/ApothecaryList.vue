<template>
  <div>
    <input class="btn btn-info btn-block my-4" id="sortAddresses" name="sortAddresses" type="button" @click="sortBy('address')" value="Sort by Address"/>
    <input class="btn btn-info btn-block my-4" id="sortNames" name="sortNames" type="button" @click="sortBy('name')" value="Sort by Name"/>
  </div>
  <ol class="list-group list-group-numbered">
    <li class="list-group-item d-flex justify-content-between align-items-start" v-for="apothecary in apothecaryList.data" :key="apothecary.name">
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
  name: "ApothecaryList",

  data(){
    return{
      apothecaryList : [],
    }
  },

  methods: {
    sortBy(prop) {
      this.apothecaryList.data.sort((a, b) => a[prop] < b[prop] ? -1 : 1)
    }
  },

  mounted() {
    axios
        .get("/api/apotecary/list")
        .then(response => this.apothecaryList = response)
  },
}
</script>

<style scoped>

</style>