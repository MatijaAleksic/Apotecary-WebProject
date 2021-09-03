<template>
  <div id="container"><div id="container-inner">
    <form style="width: 300px; position:absolute; top: 200px; left: 600px">
      <fieldset>
        <!-- Your new password -->
        <div>
          <label for="new_password">Enter password</label>
          <input type="password" name="new_password" id="new_password" v-model="new_password"/>
        </div>

        <div>
          <label for="re_new_password">Redo-password</label>
          <input type="password" name="re_new_password" id="re_new_password" v-model="re_new_password"/>
        </div>

        <!-- Controls -->
        <div class="controls">
          <input style="position:relative; margin-top:15px; left:95px; width: 100px;" id="submit" name="submit" type="button" @click="submit" value="Save Password" />
        </div>

      </fieldset>
    </form>

  </div></div>
</template>

<script>
import axios from "axios";
export default {
  name: 'FirstLogIn',

  props: {
    userInfo: Object
  },


  data() {
    return {
      msg: '',
      new_password: '',
      re_new_password: '',
      userType: '',
      userId: Number,

      accessToken : null
    }
  },
  methods:{

    submit(){

      this.userType = this.userInfo.logged_user;
      this.userId = this.userInfo.userId;
      this.accessToken = this.userInfo.accessToken;

      if(this.new_password != '' && this.re_new_password != '')
      {
        if(this.new_password != this.re_new_password)
        {
          alert("Passwordi se ne poklapaju!")
        }
        else{
            axios.post("/api/auth/first-login", {userId : this.userId, userType: this.userType, newPassword: this.new_password},
          {
            headers: {
              'Authorization': `Bearer ${this.accessToken}`
            },
          })
                .then((response) => {
                  this.msg = response.data;
                  this.$emit('updateinfo', 'false');
                });
          }
          
      }
    }
  }
}
</script>