<template>
  <div id="container"><div id="container-inner">
    <form style="width: 300px; position:absolute; top: 200px; left: 600px" >
      <fieldset>
        <!-- Your current password -->
        <h1 style="position: relative; left: 95px">Login</h1>
        <div>
          <label for="username">Username</label>
          <input style=" margin: 10px;" type="text" name="username" id="username" v-model="username"/> <br/>
        </div>


        <!-- Your new password -->
        <div>
          <label for="password">Password </label>
          <input style=" margin: 10px;" type="password" name="password" id="password" v-model="password"/>
        </div>

        <!-- Controls -->
        <div class="controls">
          <input style="position:relative; margin-top:15px; left:95px; width: 100px;" id="login" name="login" type="button" @click="loggin_event" value="Login" />
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
      username: '',
      password: ''
    }
  },
  methods:{
    loggin_event : function(){
      //axios.post("/api/auth/login", {username: this.username, password: this.password})
      axios.post("/api/unsigned/login", {username: this.username, password: this.password})
          .then((response) => //{this.logged_user = response.data;this.$emit('userlogged', this.logged_user);}
          { 
            this.$emit('update-logged-user', response.data);
          }
          );
    }

  }
}
</script>
