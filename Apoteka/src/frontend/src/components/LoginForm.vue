<template>
  <!-- Default form login -->
  <form class="text-center border border-light p-5" style="width: 400px; position: sticky; left: 555px;" action="#!">

    <p class="h4 mb-4">Sign in</p>

    <!-- Email -->
    <input type="text" name="username" id="username" v-model="username" class="form-control mb-4" placeholder="Username">

    <!-- Password -->
    <input type="password" name="password" id="password" v-model="password" class="form-control mb-4" placeholder="Password">

    <div class="d-flex justify-content-around">
      <div>
        <!-- Remember me -->
        <div class="custom-control custom-checkbox">
          <input type="checkbox" class="custom-control-input" id="defaultLoginFormRemember">
          <label class="custom-control-label" for="defaultLoginFormRemember">Remember me</label>
        </div>
      </div>
      <div>
        <!-- Forgot password -->
        <a href="">Forgot password?</a>
      </div>
    </div>

    <!-- Sign in button -->
    <input class="btn btn-info btn-block my-4" id="login" name="login" type="button" @click="loggin_event" value="Sign in"/>

    <!-- Register -->
    <p>Not a member?
      <a href="">Register</a>
    </p>

    <!-- Social login -->
<!--    <p>or sign in with:</p>

    <a href="#" class="mx-2" role="button"><i class="fab fa-facebook-f light-blue-text"></i></a>
    <a href="#" class="mx-2" role="button"><i class="fab fa-twitter light-blue-text"></i></a>
    <a href="#" class="mx-2" role="button"><i class="fab fa-linkedin-in light-blue-text"></i></a>
    <a href="#" class="mx-2" role="button"><i class="fab fa-github light-blue-text"></i></a>-->

  </form>
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
