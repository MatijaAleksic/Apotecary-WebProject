<template>
  <div id="container"><div id="container-inner">
    <h1>Change Password</h1>
    <form >
      <fieldset>

        <div>
          <label for="newPassword">Your new password</label>
          <input type="text" name="newPassword" id="newPassword" v-model="newPassword"/>
        </div>

        <div>
          <label for="reNewPassword">Redo your password</label>
          <input type="text" name="reNewPassword" id="reNewPassword" v-model="reNewPassword"/>
        </div>

        <!-- Controls -->
        <div class="controls">
          <input id="submit" name="submit" type="button" @click="submit" value="Change Password" />
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
  name: 'ChangePatientPassword',
  data() {
    return {
      msg: '',
      newPassword: '',
      reNewPassword: '',

      userId: null,
      accessToken : null
    }
  },

  props: {
    patientINF: Object
  },

  mounted() {
      this.userId = this.patientINF.userId;
      this.accessToken = this.patientINF.accessToken;
  },

  methods:{
    submit(){
        if(this.reNewPassword == this.newPassword){
            axios.post("/api/patient/change-password", {id : this.userId, newPassword: this.newPassword},
          {
            headers: {
              'Authorization': `Bearer ${this.accessToken}`
            },
          })
                .then((response) => {
                    this.msg = response.data;
                });
        }else{
            alert("Passwords dont match!")
        }
    }
  }}
</script>