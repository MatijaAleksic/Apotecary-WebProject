<template>
  <div class="container">
    <h1 class="text-primary"><span class="glyphicon glyphicon-user"></span>Edit Profile</h1>
    <hr>
    <div class="row">
      <!-- left column -->
      <div class="col-md-3">
        <div class="text-center">
          <i class="fas fa-user-tie fa-7x mt-5"></i>
<!--          <img src="//placehold.it/100" class="avatar img-circle" alt="avatar">-->
        </div>
      </div>

      <!-- edit form column -->
      <div class="col-md-9 personal-info">
        <div class="alert alert-info alert-dismissible">
          <a class="panel-close close" data-dismiss="alert">×</a>
          <i class="fa fa-coffee"></i>
          You're able to <strong>edit</strong> your personal information on this page.
        </div>
        <h3>Personal info</h3>

        <form class="form-horizontal" role="form">
          <div class="form-group">
            <label class="col-lg-3 control-label">Id:</label>
            <div class="col-lg-8">
              <input class="form-control" type="number" name="id" id="id" v-model="id"/>
            </div>
          </div>
          <div class="form-group">
            <label class="col-lg-3 control-label">First name:</label>
            <div class="col-lg-8">
              <input class="form-control" type="text" name="firstName" id="firstName" v-model="firstName">
            </div>
          </div>
          <div class="form-group">
            <label class="col-lg-3 control-label">Last name:</label>
            <div class="col-lg-8">
              <input class="form-control" type="text" name="lastName" id="lastName" v-model="lastName">
            </div>
          </div>
          <div class="form-group">
            <label class="col-lg-3 control-label">Username:</label>
            <div class="col-lg-8">
              <input class="form-control" type="text" name="username" id="username" v-model="username">
            </div>
          </div>
          <div class="form-group">
            <label class="col-lg-3 control-label">Address:</label>
            <div class="col-lg-8">
              <input class="form-control" type="text" name="address" id="address" v-model="address">
            </div>
          </div>
          <div class="form-group">
            <label class="col-lg-3 control-label">Phone number:</label>
            <div class="col-lg-8">
              <div class="ui-select">
                <input class="form-control" type="text" name="phoneNumber" id="phoneNumber" v-model="phoneNumber">
              </div>
            </div>
          </div>
          <input class="btn btn-primary" type="button" @click="submit" value="Save" />
        </form>
      </div>
    </div>
    <div class="alert alert-success" role="alert">
      {{ msg }}
    </div>
    <br>
    <change-password></change-password>
  </div>
  <hr>
</template>

<script>
import PatientChangePassword from "@/components/Patient/PatientChangePassword";
import axios from "axios";

export default {
  name: "PatientProfileEdit",
  components: {
    'change-password': PatientChangePassword,
  },
  data() {
    return{
      msg: '',
      firstName: '',
      lastName: '',
      username: '',
      address: '',
      phoneNumber: '',
    }
  },
  methods: {
    submit() {
      axios.post("api/patient/change-information", {id : this.id, firstName : this.firstName, lastName : this.lastName,
      username : this.username, address : this.address, phoneNumber : this.phoneNumber})
          .then((response) => {
            this.msg = response.data;
          });
    }
  }
}
</script>

<style scoped>

</style>