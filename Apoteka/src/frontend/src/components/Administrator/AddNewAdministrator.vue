<template>
  <div id="container"><div id="container-inner">
    <h1>Register new dermathologist</h1>
    <form>
      <fieldset>
        <div>
          <label for="firstname">First Name</label>
          <input type="text" name="firstname" id="firstname" v-model="firstname"/>
        </div>

        <div>
          <label for="lastname">Last Name</label>
          <input type="text" name="lastname" id="lastname" v-model="lastname"/>
        </div>

        <div>
          <label for="username">Username</label>
          <input type="text" name="username" id="username" v-model="username"/>
        </div>

        <div>
          <label for="password">Password</label>
          <input type="text" name="password" id="password" v-model="password"/>
        </div>

        <div>
          <label for="email">Email</label>
          <input type="text" name="email" id="email" v-model="email"/>
        </div>

        <div>
          <label for="adress">Address</label>
          <input type="text" name="adress" id="adress" v-model="adress"/>
        </div>

        <div>
          <label for="city">City</label>
          <input type="text" name="city" id="city" v-model="city"/>
        </div>

        <div>
          <label for="country">Country</label>
          <input type="text" name="country" id="country" v-model="country"/>
        </div>

        <div>
          <label for="phone">Phone</label>
          <input type="text" name="phone" id="phone" v-model="phone"/>
        </div>

        <div class="controls">
          <input id="submit" name="submit" type="button" @click="submit" value="Register Dermatologist" />
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
  name: 'RegisterDermatologist',
  data() {
    return {
      msg: '',
      firstname: '',
      lastname: '',
      username: '',
      password: '',
      email: '',
      adress: '',
      city: '',
      country: '',
      phone: ''
    }
  },
  methods:{
    submit(){
      axios.post("/api/dermatologist/register-new", {firstname: this.firstname, lastname: this.lastname,
      username: this.username, password: this.password, email: this.email, adress : this.adress, city: this.city,
       country: this.country, phone: this.phone})
          .then((response) => {
            this.msg = response.data;
          });
    }
  }
}
</script>