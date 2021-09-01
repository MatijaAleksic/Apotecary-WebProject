<template>
  <div>
    <header>
      <derma-nav-bar v-on:change-main-component="changeMainComponent"></derma-nav-bar>
    </header>

    <component :adminINF ="{userId : userId, apotecary_id : apotecary_id}" v-bind:is="component"> </component>
  </div>
</template>

<script>
import DermatologistNavBar from "@/components/Dermatologist/DermatologistNavBar";
import DermatologistVacation from "@/components/Dermatologist/DermatologistVacation";
import DermatologistPatientTable from "@/components/Tables/DermatologistPatientTable";
import DermatologistProfile from "@/components/Profiles/DermatologistProfile";
import DermatologistCalendar from "@/components/Graphical/DermatologistCalendar";
import axios from "axios";
import Calendar from "@/components/Graphical/Calendar";

export default {
  name: "DermatologistHomePage",

  props: {
    userInfo: Object
  },

  components:{
    'derma-nav-bar': DermatologistNavBar,
    'vacation': DermatologistVacation,
    'patients': DermatologistPatientTable,
    'derma-profile' : DermatologistProfile,
    'calendar':DermatologistCalendar,
    'calendar2':Calendar,
  },

  data(){
    return{
      userId : Number,
      apotecary_id : Number,

      component: '',
    }
  },

  mounted() {

    this.userId = this.userInfo.userId;
    axios.post("/api/dermatologist/get-apotecary-id", {id : this.userId})
        .then((response) => {
          this.apotecary_id = response.data;
        });


  },

  methods: {
    changeMainComponent(value) {
      if (value == 'profile') {
        this.component = 'derma-profile';
      } else if (value == 'vacation') {
        this.component = 'vacation'
      }
      else if (value == 'calendar') {
          this.component = 'calendar';
      } else {
        this.component = 'patients';
      }
    },
  }
}
</script>

<style scoped>

* {
  margin: 0;
  padding: 0;
  box-sizing: border-box;
}

header{
  width: 100vw;
  background-color: #5f9ea0;
  padding: 15px;
}

</style>