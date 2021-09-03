<template>
  <div id="container"><div id="container-inner">
    <h1>Change Information</h1>
    <form>
      <fieldset>
        <div>
          <label for="name">First Name</label>
          <input  type="text" name="name" id="name" v-model="name" />
        </div>
        <div>
          <label for="lastname">Last Name</label>
          <input type="text" name="lastName" id="lastName" v-model="lastName"/>
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
          <input id="submit" name="submit" type="submit" @click="submit" value="Change info" />
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
  name: 'ChangeInformationPharmacist',
  el: '#app',
  data() {
    return {
      msg: '',
      name: null,
      lastName: null,
      phone: null,
      address: null,
      city: null,
      country: null,

      userId : null,
      errors: [],
      accessToken: null
    }
  },

  props: {
    adminINF: Object
  },

  mounted() {
    this.userId = this.adminINF.userId;
    this.accessToken = this.adminINF.accessToken;
  },

  methods:{
    submit(){
      axios.post("/api/dermatologist/change-information", {id: this.userId, name: this.name, lastName: this.lastName,
        address: this.address, city: this.city, country: this.country, phone: this.phone},
          {
            headers: {
              'Authorization': `Bearer ${this.accessToken}`
            },
          })
          .then((response) => {
            this.msg = response.data;
            this.$emit('refresh-component');
          });
    },

    checkForm: function (e) {
      this.errors = [];

      if (!this.name) {
        this.errors.push("Name required.");
      }
      if (!this.lastName) {
        this.errors.push('lastName required.');
      }
      if (!this.phone) {
        this.errors.push("phone required.");
      }
      if (!this.address) {
        this.errors.push('address required.');
      }
      if (!this.city) {
        this.errors.push("city required.");
      }
      if (!this.country) {
        this.errors.push('country required.');
      }

      if (!this.errors.length) {
        return true;
      }

      e.preventDefault();
    },
  }}
</script>