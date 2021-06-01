<template>
  <div id="container"><div id="container-inner">
    <h1>Change Information</h1>
    <form >
      <fieldset>
        <div>
          <label for="name">First Name</label>
          <input type="text" name="firstname" id="firstname" v-model="firstname"/>
        </div>
        <div>
          <label for="lastname">Last Name</label>
          <input type="text" name="lastname" id="lastname" v-model="lastname"/>
        </div>

        <div>
          <label for="phone">Phone</label>
          <input type="text" name="phone" id="phone" v-model="phone"/>
        </div>
        <div>
          <label for="address">Address</label>
          <input type="text" name="address" id="address" v-model="address"/>
        </div>
        <div>
          <label for="city">City</label>
          <input type="text" name="city" id="city" v-model="city"/>
        </div>
        <div>
          <label for="country">Country</label>
          <input type="text" name="country" id="country" v-model="country"/>
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
      firstname: '',
      lastname: '',
      phone: '',
      address: '',
      city: '',
      country: '',

      userId : null
    }
  },

  props: {
    adminINF: Object
  },

  mounted() {
      this.userId = this.adminINF.userId;
  },

  methods:{
    submit(){
      axios.post("/api/administrator/change-information", {id: this.userId, firstname: this.firstname, lastname: this.lastname,
      address: this.address, city: this.city, country: this.country, phone: this.phone})
          .then((response) => {
            this.msg = response.data;
            this.$emit('refresh-component');
          });
    }
  }}
</script>