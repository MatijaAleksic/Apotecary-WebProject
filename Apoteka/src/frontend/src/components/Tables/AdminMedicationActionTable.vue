<template>
    <div>
    <h3> Actions </h3>

    <input type="text" v-model="searchName" placeholder="Name"/>

    <table>
        <tr bgcolor='lightgrey'>
            <th><div @click="sortBy('id')" class="sortBy">ID</div></th>
            <th><div @click="sortBy('type')" class="sortBy">Type</div></th>
            <th><div @click="sortBy('name')" class="sortBy">Name</div></th>
            <th><div @click="sortBy('inStorage')" class="sortBy">In Storage</div></th>
            <th><div @click="sortBy('price')" class="sortBy">Price</div></th>
            <th><div @click="sortBy('apotecary_id')" class="sortBy">ApotecaryID</div></th>
            <th><div @click="sortBy('actionStartDate')" class="sortBy">Action Start Date</div></th>
            <th><div @click="sortBy('actionStartTime')" class="sortBy">Action Start Time</div></th>
            <th><div @click="sortBy('actionEndDate')" class="sortBy">Action End Date</div></th>
            <th><div @click="sortBy('actionEndTime')" class="sortBy">Action End Time</div></th>
            <th><div @click="sortBy('procentage')" class="sortBy">Procentage</div></th>
        </tr>

        <tr v-for="medication in fillteredActions"  v-bind:key="medication.id"> 
            <td> {{medication.id}}</td>
            <td> {{medication.type}}</td>
            <td> {{medication.name}}</td>
            <td> {{medication.inStorage}}</td>
            <td> {{medication.price}}</td>
            <td> {{medication.apotecary_id}}</td>
            <td> {{medication.actionStartDate}}</td>
            <td> {{medication.actionStartTime}}</td>
            <td> {{medication.actionEndDate}}</td>
            <td> {{medication.actionEndTime}}</td>
            <td> {{medication.procentage}}%</td>

            <td><button @click="Edit(medication.id)">Edit Action</button></td>
            <td><button @click="Delete(medication.id)">Delete Action</button></td>

        </tr>
    </table>
    <div>
        <h5>{{ msg }}</h5>
    </div>
          
    <component v-on:close-component="closeComponet" :apotecaryID ="{apotecary_id : apotecary_id,medication_id : medication_id }" v-bind:is="component"> </component>
</div>
</template>

<script>

import EditMedicationAction from '@/components/Administrator/EditMedicationAction.vue'

import axios from "axios";
export default {
    name: "AdminMedicationActionTable",

    components: {
        'edit-action':EditMedicationAction
    },

    data(){
        return{
        medications : [],
        searchName: "",

        apotecary_id : null,
        medication_id: null,

        medInfoId: null,

        msg: "",
        component:null
        }
    },

    props: {
        adminINF: Object
    },

    mounted() {
        this.apotecary_id = this.adminINF.apotecary_id;

        axios.post("/api/medication-info/get-all-admin-actions", {id : this.apotecary_id})
            .then(response => {
                this.medications = response.data;
            })
    },


    methods: {

        Edit(medId)
        {
            alert("Edit" + medId)
            //this.medication_id = medId;
            //this.component ='edit-action'; 
        },

        Delete(medId)
        {
            alert("Delete" + medId)
            /*this.medication_id = medId;

            axios.post("/api/medication-info/get", {apotecary_id : this.apotecary_id, medication_id: this.medication_id})
            .then(response => {
                this.medInfoId = response.data.id;

                if(this.medInfoId != null)
                {
                    axios.post("/api/medication-info/delete", {id : this.medInfoId})
                        .then(response => {
                            this.msg = response.data;
                            this.refresh();
                    })
                }
                else{
                    this.refresh();
                }
            })*/
            
        },

        refresh(){
            axios.post("/api/medication-info/get-all-admin-actions", {id : this.apotecary_id})
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
        fillteredActions: function() {
            return this.medications.filter( (elem) => {
                return elem.name.toLowerCase().match(this.searchName.toLowerCase())
            });
        }
    }
}
</script>

<style scoped>
</style>