<template>
  <div class="container">
    <h1 class="text-primary"><span class="glyphicon glyphicon-user"></span>Change Password</h1>
    <hr>
    <div class="row">
      <!-- left column -->
      <div class="col-md-3">
        <div class="text-center">
          <i class="fas fa-shield-alt fa-7x mt-5"></i>
          <!--          <img src="//placehold.it/100" class="avatar img-circle" alt="avatar">-->
        </div>
      </div>
      <div class="col-md-9 personal-info">
        <div class="alert alert-info alert-dismissible">
          <a class="panel-close close" data-dismiss="alert">×</a>
          <i class="fa fa-coffee"></i>
          You're able to <strong>change</strong> your password on this page.
        </div>
        <h3>Password</h3>

        <form class="form-horizontal" role="form">
          <div class="form-group">
            <label class="col-lg-3 control-label">Id:</label>
            <div class="col-lg-8">
              <input class="form-control" type="number" name="id" id="id" v-model="id"/>
            </div>
          </div>
          <div class="form-group">
            <label class="col-lg-3 control-label">New password:</label>
            <div class="col-lg-8">
              <input class="form-control" type="password" name="newPassword" id="newPassword" v-model="newPassword"/>
            </div>
          </div>
          <div class="form-group">
            <label class="col-lg-3 control-label">Repeat password:</label>
            <div class="col-lg-8">
              <input class="form-control" type="password" name="repeatPassword" id="repeatPassword" v-model="repeatPassword"/>
            </div>
          </div>
          <input class="btn btn-primary" type="button" @click="submit" value="Save" />
        </form>
      </div>
    </div>
    <div class="alert alert-success" role="alert">
      {{ msg }}
    </div>
  </div>
  <hr>
</template>

<script>
import axios from "axios";
export default {
  name: "PatientChangePassword",
  data() {
    return {
      msg: '',
      newPassword:'',
      repeatPassword: '',
    }
  },

  methods: {
    submit() {
      if(this.repeatPassword == this.newPassword){
        axios.post("/api/patient/change-password", {id : this.id, newPassword: this.newPassword})
            .then((response) => {
              this.msg = response.data;
            });
      }else{
        alert("Passwords don't match!")
      }
    }
  }
}
</script>

<style scoped>

</style>