<template>
  <div>
    <header>
      <pharma-nav-bar v-on:change-main-component="changeMainComponent"></pharma-nav-bar>
    </header>

    <component :adminINF ="{userId : userId, apotecary_id : apotecary_id,accessToken: accessToken}" v-bind:is="component"> </component>
  </div>
</template>

<script>
import axios from "axios";

import PharmacistPatientTable from "@/components/Tables/PharmacistPatientTable";
import PharmacistVacation from "@/components/Pharmacist/PharmacistVacation";
import PharmacistNavBar from "@/components/Pharmacist/PharmacistNavBar";
import PharmacistProfile from "@/components/Profiles/PharmacistProfile";
import PharmacistCalendar from "@/components/Graphical/PharmacistCalendar";
export default {
  name: "PharmacistHomePage",
  components: {
    'pharmacist-profile': PharmacistProfile,
    'patient-table': PharmacistPatientTable,
    'vacation': PharmacistVacation,
    'pharma-nav-bar': PharmacistNavBar,
    'calendar': PharmacistCalendar,
  },
  props: {
    userInfo: Object
  },
  data(){
    return{
      userId : Number,
      apotecary_id : null,

      component:null,
      accessToken: null
    }
  },

  beforeMount() {
    this.userId = this.userInfo.userId;
    this.accessToken = this.userInfo.accessToken;
    axios.post("/api/pharmacist/get-apotecary-id", {id : this.userId},
        {
          headers: {
            'Authorization': `Bearer ${this.accessToken}`
          },
        })
        .then((response) => {
          this.apotecary_id = response.data;
        });
  },
  methods: {
    changeMainComponent(value) {
      if (value == 'profile') {
        this.component = 'pharmacist-profile';
      } else if (value == 'vacation') {
        this.component = 'vacation'
      }
      else if (value == 'calendar') {
        this.component = 'calendar';
      } else {
        this.component = 'patient-table';
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