<template>
    <div>
    <h3> Medication Table </h3>

    <input type="text" v-model="searchName" placeholder="Name"/>

    <table>
        <tr bgcolor='lightgrey'>
            <th><div @click="sortBy('id')" class="sortBy">ID</div></th>
            <th><div @click="sortBy('type')" class="sortBy">Type</div></th>
            <th><div @click="sortBy('name')" class="sortBy">Name</div></th>
            <th><div @click="sortBy('composition')" class="sortBy">Composition</div></th>
            <th><div @click="sortBy('contradiction')" class="sortBy">Contradiction</div></th>
            <th><div @click="sortBy('dailyIntake')" class="sortBy">Daily Intake</div></th>
            <th><div @click="sortBy('replacement')" class="sortBy">Replacement</div></th>
            <th><div @click="sortBy('inStorage')" class="sortBy">In Storage</div></th>
            <th><div @click="sortBy('price')" class="sortBy">Price</div></th>
            <th><div @click="sortBy('apotecary_id')" class="sortBy">ApotecaryID</div></th>
            <th><div @click="sortBy('priceDurationEndDate')" class="sortBy">Price Duration EndDate</div></th>
            <th><div @click="sortBy('priceDurationEndTime')" class="sortBy">Price Duration EndTime</div></th>
            <th><div @click="sortBy('procentage')" class="sortBy">Action</div></th>
        </tr>

        <tr v-for="medication in fillteredMedications"  v-bind:key="medication.id"> 
            <td> {{medication.id}}</td>
            <td> {{medication.type}}</td>
            <td> {{medication.name}}</td>
            <td> {{medication.composition}}</td>
            <td> {{medication.contradiction}}</td>
            <td> {{medication.dailyIntake}}</td>
            <td> {{medication.replacement}}</td>
            <td> {{medication.inStorage}}</td>
            <td> {{medication.price}}</td>
            <td> {{medication.apotecary_id}}</td>
            <td> {{medication.priceDurationEndDate}}</td>
            <td> {{medication.priceDurationEndTime}}</td>
            <td> {{medication.procentage}}%</td>
            <td><button @click="EditInfo(medication.id)">Edit</button></td>
            <td><button @click="Delete(medication.id)">Delete</button></td>

        </tr>
    </table>
    <div>
        <h5>{{ msg }}</h5>
    </div>
          
    <component v-on:close-component="closeComponet" :apotecaryID ="{apotecary_id : apotecary_id,medication_id : medication_id, accessToken: accessToken }" v-bind:is="component"> </component>
</div>
</template>

<script>

import EditMedicationInfo from '@/components/Administrator/EditMedicationInfo.vue'

import axios from "axios";
export default {
    name: "AdminMedicationTable",

    components: {
        'edit-medication':EditMedicationInfo
    },

    data(){
        return{
        medications : [],

        mode: "BROWSE",
        selectedPharmacist: {},
        searchField: "",

        searchName: "",

        apotecary_id : null,
        medication_id: null,

        medInfoId: null,

        msg: "",
        component:null,
        accessToken : null
        }
    },

    props: {
        adminINF: Object
    },

    mounted() {
        this.apotecary_id = this.adminINF.apotecary_id;
        this.accessToken = this.adminINF.accessToken;
        axios.post("/api/medication-info/get-all-admin", {id : this.apotecary_id}, 
    {
      headers: {
        'Authorization': `Bearer ${this.accessToken}`
      },
      })
            .then(response => {
                this.medications = response.data;
            })
    },


    methods: {

        EditInfo(medId)
        {
            this.medication_id = medId;
            this.component ='edit-medication'; 
        },

        Delete(medId)
        {
            this.medication_id = medId;

            axios.post("/api/medication-info/get", {apotecary_id : this.apotecary_id, medication_id: this.medication_id}, 
    {
      headers: {
        'Authorization': `Bearer ${this.accessToken}`
      },
      })
            .then(response => {
                this.medInfoId = response.data.id;

                if(this.medInfoId != null)
                {
                    axios.post("/api/medication-info/delete", {id : this.medInfoId}, 
    {
      headers: {
        'Authorization': `Bearer ${this.accessToken}`
      },
      })
                        .then(response => {
                            this.msg = response.data;
                            this.refresh();
                    })
                }
                else{
                    this.refresh();
                }
            })
            
        },

        refresh(){
            axios.post("/api/medication-info/get-all-admin", {id : this.apotecary_id}, 
    {
      headers: {
        'Authorization': `Bearer ${this.accessToken}`
      },
      })
            .then(response => {
                this.medications = response.data;
            })
        },

        sortBy(prop) {
            this.medications.sort((a, b) => a[prop] < b[prop] ? -1 : 1)
        },

        closeComponet(){
            this.component = null;
            this.refresh();
        }
    },

    computed: {
        fillteredMedications: function() {
            return this.medications.filter( (elem) => {
                return elem.name.toLowerCase().match(this.searchName.toLowerCase())
            });
        }
    }
}
</script>

<style scoped>
</style>