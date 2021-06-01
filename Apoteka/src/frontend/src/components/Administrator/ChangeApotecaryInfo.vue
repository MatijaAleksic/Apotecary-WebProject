<template>
  <div id="container"><div id="container-inner">
    <h1>Change Information</h1>
    <form >
      <fieldset>
        <div>
          <label for="name">Name</label>
          <input type="text" name="name" id="name" v-model="name"/>
        </div>
        <div>
          <label for="adress">Address</label>
          <input type="text" name="adress" id="adress" v-model="adress"/>
        </div>
        <div>
          <label for="description">Description</label>
          <input type="text" name="description" id="description" v-model="description"/>
        </div>

        <!-- Controls -->
        <div class="controls">
          <input id="submit" name="submit" type="button" @click="submit" value="Change info" />
        </div>
        <div>
          <h1>{{ msg }}</h1>
        </div>
      </fieldset>
    </form>

  </div></div>
</template>

<script>
import axios from "axios";

export default {
  name: 'ChangePersonalInformation',
  data() {
    return {
      msg: '',

      name: null,
      adress: null,
      description: null,

      userId : null
    }
  },

  props: {
    adminINF: Object
  },

  mounted() {
      this.userId = this.adminINF.userId;
      this.apotecary_id = this.adminINF.apotecary_id;
  },

  methods:{
    submit(){
      axios.post("/api/apotecary/change-information", {id: this.apotecary_id, name: this.name, adress: this.adress,
      description: this.description})
          .then((response) => {
            this.msg = response.data;
            this.$emit('refresh-component');
          });
    }
  }}
</script>