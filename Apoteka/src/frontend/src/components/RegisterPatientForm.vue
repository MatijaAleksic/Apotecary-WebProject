<template>
  <!-- Default form register -->
  <form class="text-center border border-light p-5" style="width: 500px; position: sticky; left: 520px;" action="#!">

    <p class="h4 mb-4">Sign up</p>

    <div class="form-row mb-4">
      <div class="col">
        <!-- First name -->
        <input type="text" name="firstname" id="firstname" v-model="firstname" class="form-control" placeholder="First name">
      </div>
      <div class="col">
        <!-- Last name -->
        <input type="text" name="lastname" id="lastname" v-model="lastname" class="form-control" placeholder="Last name">
      </div>
    </div>

    <!-- E-mail -->
    <input type="email" name="email" id="email" v-model="email" class="form-control mb-4" placeholder="E-mail">

    <!-- Username -->
    <input type="text" name="username" id="username" v-model="username" class="form-control mb-4" placeholder="Username">

    <!-- Password -->
    <input type="password" name="password" id="password" v-model="password" class="form-control" placeholder="Password" aria-describedby="defaultRegisterFormPasswordHelpBlock">
    <small id="defaultRegisterFormPasswordHelpBlock" class="form-text text-muted mb-4">
      At least 8 characters and 1 digit
    </small>

    <div class="form-row mb-4">
      <div class="col">
        <!-- Country -->
        <input type="text" name="country" id="country" v-model="country" class="form-control" placeholder="Country">
      </div>
      <div class="col">
        <!-- City -->
        <input type="text" name="city" id="city" v-model="city" class="form-control" placeholder="City">
      </div>
    </div>

    <!-- Address-->
    <input type="text" name="adress" id="adress" v-model="adress" class="form-control mb-4" placeholder="Address">

    <!-- Phone number -->
    <input type="text" name="phone" id="phone" min="1" max="5" v-model="phone" class="form-control" placeholder="Phone number" aria-describedby="defaultRegisterFormPhoneHelpBlock">
<!--    <small id="defaultRegisterFormPhoneHelpBlock" class="form-text text-muted mb-4">
      Optional - for two step authentication
    </small>-->
    <br>

    <!-- Newsletter -->
    <div class="custom-control custom-checkbox">
      <input type="checkbox" class="custom-control-input" id="defaultRegisterFormNewsletter">
      <label class="custom-control-label" for="defaultRegisterFormNewsletter">Subscribe to our newsletter</label>
    </div>

    <!-- Sign up button -->
    <input class="btn btn-info my-4 btn-block" id="submit" name="submit" type="button" @click="submit" value="Sign in"/>

    <!-- Social register -->
<!--    <p>or sign up with:</p>

    <a href="#" class="mx-2" role="button"><i class="fab fa-facebook-f light-blue-text"></i></a>
    <a href="#" class="mx-2" role="button"><i class="fab fa-twitter light-blue-text"></i></a>
    <a href="#" class="mx-2" role="button"><i class="fab fa-linkedin-in light-blue-text"></i></a>
    <a href="#" class="mx-2" role="button"><i class="fab fa-github light-blue-text"></i></a>-->

    <hr>

  </form>
</template>

<script>
import axios from "axios";
export default {
  name: 'Register',
  data() {
    return {
      firstname: '',
      lastname: '',
      username: '',
      password: '',
      email: '',
      adress: '',
      city: '',
      country: '',
      phone: '',

      status: ''
    }
  },
  methods:{
    submit(){
      axios.post("/api/unsigned/register", {firstname: this.firstname, lastname: this.lastname, username: this.username, password: this.password,
      email: this.email, address: this.adress, city: this.city, country: this.country, phone: this.phone})
          .then((response) => {
            self.status = response.data;
          });
    }
  }}
</script>
