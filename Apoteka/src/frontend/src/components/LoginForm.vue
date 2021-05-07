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
        <div>
          <h1>{{ logged_user }}</h1>
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
      logged_user: '',
      oldPassword: '',
      newPassword: ''
    }
  },
  methods:{
    loggin_event : function(){
      axios.post("/api/unsigned/login", {username: this.username, password: this.password})
          .then((response) => //{this.logged_user = response.data;this.$emit('userlogged', this.logged_user);}
          { 
            this.logged_user = response.data;
            //self.emit_login(response.data);
          }
          );
    },
    emit_login : function(value){
          self.$emit('userlogged', value);
    }
  }
}
</script>
