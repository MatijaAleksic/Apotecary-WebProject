<template>
    
    <form>
        <h1>Apotecary Information</h1>
        <div>
            <label> <h4>Name:</h4>  {{name}} </label>
        </div>
        <div>
            <label> <h4>Address:</h4>         {{adress}} </label>
        </div>  
        <div>
            <label><h4>Description:</h4>          {{description}} </label>
        </div>

        <div>
            <label><h4>Average Rating:</h4>          {{rating}} </label>
        </div>

    </form>

    <div>
        <button v-on:refresh-component="refresh" v-on:click="component ='change-apotecary-info'">Change Apotecary Info</button> 
    </div>

    <div >
        <button v-on:click="component ='add-new-medication'">Add new Medication</button> 
        <button v-on:click="component ='register-new-administrator'">Register new Administrator</button>
        <button v-on:click="component ='register-new-dermatologist'">Register new Dermatologist</button>
        <button v-on:click="component ='register-new-pharmacist'">Register new Pharmacist</button>
        <button v-on:click="component ='pharmacist-table'">Pharmacist Table</button>
        <button v-on:click="component ='dermatologist-table'">Dermatologist Table</button>
        <button v-on:click="component ='medication-table'">Medication Table</button>
        <button v-on:click="component ='pharmacist-vacation-table'">Pharmacist Vacation Table</button>
        <button v-on:click="component ='dermatologist-vacation-table'">Dermatologist Vacation Table</button>
      </div>

    <component v-on:refresh-component="refreshComponent" :adminINF ="{userId : userId, apotecary_id : apotecary_id}" v-bind:is="component"> </component>

</template>

<script>

import AddNewMedication from '@/components/Administrator/AddNewMedication.vue'
import AddNewAdministrator from '@/components/Administrator/AddNewAdministrator.vue'
import AddNewDermatologist from '@/components/Administrator/AddNewDermatologist.vue'
import AddNewPharmacist from '@/components/Administrator/AddNewPharmacist.vue'
import AdminPharmacistTable from '@/components/Tables/AdminPharmacistTable.vue'
import AdminDermatologistTable from '@/components/Tables/AdminDermatologistTable.vue'
import AdminMedicationTable from '@/components/Tables/AdminMedicationTable.vue'
import AdminPharmacistVacationTableVue from '@/components/Tables/AdminPharmacistVacationTable.vue';
import AdminDermatologistVacationTableVue from '@/components/Tables/AdminDermatologistVacationTable.vue';

import ChangeApotecaryInfo from '@/components/Administrator/ChangeApotecaryInfo.vue';

import axios from "axios";
export default {
  name: "ApotecaryProfile",

    props: {
        adminINFO: Object
    },

  components:{
    'add-new-medication': AddNewMedication,
    'register-new-administrator' : AddNewAdministrator,
    'register-new-dermatologist' : AddNewDermatologist,
    'register-new-pharmacist' : AddNewPharmacist,
    'change-apotecary-info' : ChangeApotecaryInfo,

    'pharmacist-table' : AdminPharmacistTable,
    'dermatologist-table' : AdminDermatologistTable,
    'medication-table' : AdminMedicationTable,

    'pharmacist-vacation-table' : AdminPharmacistVacationTableVue,
    'dermatologist-vacation-table' : AdminDermatologistVacationTableVue
  },


  data(){
    return{
      name: null,
      adress: null,
      description: null,
      rating: null,

      component: null,

      userId : Number,
      apotecary_id : null,
    }
  },

  mounted() {
    this.userId = this.adminINFO.userId;
    this.apotecary_id = this.adminINFO.apotecary_id;

    axios.post("/api/apotecary/get-info", {id : this.apotecary_id})
            .then(response => {
                this.name = response.data.name;
                this.adress= response.data.adress;
                this.description= response.data.description;
                this.rating= response.data.rating;
            })
    },

    methods: {

        refresh(){
            axios.post("/api/apotecary/get-info", {id : this.apotecary_id})
            .then(response => {
                this.name = response.data.name;
                this.adress= response.data.adress;
                this.description= response.data.description;
                this.rating= response.data.rating;

                this.refresh();
            })
        },

        refreshComponent(){
            this.component = null;
            this.refresh();
        }
    }
}
</script>

<style scoped>

label{
    font-size: 18px;
    height: 50px;
    width: 300px;
    padding: 20px 20px;
    justify-content: left;
    display: inline-block;
    text-align: left;
    color: Black;
}

h4 {
    margin: 8px 5px;
    text-align: left;
    justify-content: left;
    display: inline-block;
    box-sizing: border-box;
}

form {
     margin: 10px 10px;
}
</style>