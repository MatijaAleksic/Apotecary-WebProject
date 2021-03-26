<template>
  <div id="container"><div id="container-inner">
    <h1>Login</h1>
    <form >
      <fieldset>
        <div>
          <label for="username">Username</label>
          <input type="text" name="username" id="username" v-model="username"/>
        </div>
        <div>
          <label for="password">Password</label>
          <input type="password" name="password" id="password" v-model="password"/>
        </div>

        <!-- Controls -->
        <div class="controls">
          <input id="submit" name="submit" type="button" @click="submit" value="Login" />
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
  name: 'Login',
  data() {
    return {
      msg: '',
      username: '',
      password: ''
    }
  },
  methods:{
    submit(){
      axios.post("/api/unregistered/login", {username: this.username, password: this.password})
          .then((response) => {
            this.msg = response.data;
          });
    }
  }}
</script>