<template>
<div>
    <h3> Medication Inquiry Table </h3>

    <table>
        <tr bgcolor='lightgrey'>
            <th><div @click="sortBy('id')" class="sortBy">ID</div></th>
            <th><div @click="sortBy('name')" class="sortBy">Name</div></th>
            <th><div @click="sortBy('quantity')" class="sortBy">Quantity</div></th>
            <th><div @click="sortBy('medication_id')" class="sortBy">MedicationID</div></th>
            <th><div @click="sortBy('apotecary_id')" class="sortBy">ApotecaryID</div></th>
        </tr>

        <tr v-for="medicationInquiry in medicationInquiries"  v-bind:key="medicationInquiry.id"> 
            <td> {{medicationInquiry.id}}</td>
            <td> {{medicationInquiry.name}}</td>
            <td> {{medicationInquiry.quantity}}</td>
            <td> {{medicationInquiry.medication_id}}</td>
            <td> {{medicationInquiry.apotecary_id}}</td>

            <td><button @click="Accept(medicationInquiry.id, medicationInquiry.medication_id, medicationInquiry.quantity)">Accept</button></td>
            <td><button @click="Decline(medicationInquiry.id)">Decline</button></td>

        </tr>
    </table>
    <div>
        <h5>{{ msg }}</h5>
    </div>
</div>
</template>

<script>

import axios from "axios";

export default {
    name: "AdminMedicationInquiryTable",

    data(){
        return{
        medicationInquiries : [],
        apotecary_id : null,
        msg: "",

        accessToken : null

        }
    },

    props: {
        adminINF: Object
    },

    mounted() {
        this.apotecary_id = this.adminINF.apotecary_id;
        this.accessToken = this.adminINF.accessToken;
        
        axios.get("/api/medication_inquiry/get-all", 
    {
      headers: {
        'Authorization': `Bearer ${this.accessToken}`
      },
      })
            .then(response => {
                this.medicationInquiries = response.data;
            })
    },


    methods: {

        Accept(medicationInquiry_id, medication_id, quantity)
        {
            axios.post("/api/medication_inquiry/accept", {id : medicationInquiry_id,  medication_id: medication_id, apotecary_id: this.apotecary_id, quantity: quantity }, 
    {
      headers: {
        'Authorization': `Bearer ${this.accessToken}`
      },
      })
            .then(response => {
                this.msg = response.data;
                this.refresh();
            })
        },

        Decline(medicationInquiry_id)
        {
           axios.post("/api/medication_inquiry/delete", {id : medicationInquiry_id}, 
    {
      headers: {
        'Authorization': `Bearer ${this.accessToken}`
      },
      })
            .then(response => {
                this.msg = response.data;
                this.refresh();
            })
        },

        refresh(){
            axios.get("/api/medication_inquiry/get-all", 
    {
      headers: {
        'Authorization': `Bearer ${this.accessToken}`
      },
      })

            .then(response => {
                this.medicationInquiries = response.data;
            })
        },

        sortBy(prop) {
            this.last_sort = prop;
            this.vacations.sort((a, b) => a[prop] < b[prop] ? -1 : 1)
        },

    },
}
</script>

<style scoped>
</style>