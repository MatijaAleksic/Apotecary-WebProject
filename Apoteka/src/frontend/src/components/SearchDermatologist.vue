<template>
  <div id="container"><div id="container-inner">
    <h1>Search Dermatologist</h1>
    <form >
      <fieldset>
        <div>
          <label for="firstname">Firstname</label>
          <input type="text" name="firstname" id="firstname" v-model="firstname"/>
        </div>
        <div>
          <label for="lastname">Lastname</label>
          <input type="text" name="lastname" id="lastname" v-model="lastname"/> 
        </div>
        

        <!-- Controls -->
        <div class="controls">
          <input id="submit" name="submit" type="button" @click="submit" value="Search" />
        </div>
        <div>
          <h1>{{ dermatologists }}</h1>
        </div>
      </fieldset>
    </form>

  </div></div>
</template>

<script>
import axios from "axios";
export default {
  name: 'Serach Dermatologist',
  data() {
    return {
      dermatologists: [],
      firstname: '',
      lastname: '',
    }
  },
  methods:{
    submit(){
      axios.get("/api/dermatologist/search/name=" + this.firstname + "&lastname=" + this.lastname)
          .then((response) => {
            this.dermatologists = response.data;
          });
    }
  }}
</script>