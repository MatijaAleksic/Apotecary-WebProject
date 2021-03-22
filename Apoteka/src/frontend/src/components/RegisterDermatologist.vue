<template>
  <div id="container"><div id="container-inner">
    <h1>Register new dermathologist</h1>
    <form>
      <fieldset>
        <div>
          <label for="first_name">First Name</label>
          <input type="text" name="first_name" id="first_name" v-model="first_name"/>
        </div>

        <div>
          <label for="last_name">Last Name</label>
          <input type="text" name="last_name" id="last_name" v-model="last_name"/>
        </div>

        <div>
          <label for="username">Username</label>
          <input type="text" name="username" id="username" v-model="username"/>
        </div>

        <div>
          <label for="password">Password</label>
          <input type="text" name="password" id="password" v-model="password"/>
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
      first_name: '',
      last_name: '',
      username: '',
      password: '',
    }
  },
  methods:{
    submit(){
      axios.post("/api/dermatologist/register-new", {first_name: this.first_name, last_name: this.last_name,username: this.username, password: this.password})
          .then((response) => {
            this.msg = response.data;
          });
    }
  }
}
</script>