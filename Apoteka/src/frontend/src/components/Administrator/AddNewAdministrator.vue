<template>
<div>
  <div id="container"><div id="container-inner">
    <h1>Register new Administrator</h1>
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

        <div>
          <label for="phone">Apotecary</label>
          <input type="number" name="apotecary_id" id="apotecary_id" v-model="apotecary_id"/>
        </div>

        <div class="controls">
          <input id="submit" name="submit" type="button" @click="submit" value="Create New Administrator" />
        </div>
        <div>
          <h1>{{ msg }}</h1>
        </div>
      </fieldset>
    </form>
  </div></div>
</div>
</template>

<script>

import axios from "axios";
export default {
  name: 'AddNewAdministrator',
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
      phone: '',
      apotecary_id: null,
      acessToken: null
    }
  },

   props: {
    adminINF: Object
  },

  mounted() {
      this.apotecary_id = this.adminINF.apotecary_id;
      this.accessToken = this.adminINF.accessToken;
  },

  methods:{
    submit(){
      axios.post("/api/auth/signup", {firstname: this.firstname, lastname: this.lastname,
      username: this.username, password: this.password, email: this.email, adress : this.adress,
       city: this.city,country: this.country, phone: this.phone, role: "admin", apotecary_id: this.apotecary_id}, 
    {
      headers: {
        'Authorization': `Bearer ${this.accessToken}`
      },
      })
          .then((response) => {
            this.msg = response.data;
          });
    }
  }
}
</script>