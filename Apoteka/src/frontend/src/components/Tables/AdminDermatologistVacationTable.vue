<template>
    <h3> Dermatologist Vacations </h3>

    <table>
        <tr bgcolor='lightgrey'>
            <th><div @click="sortBy('id')" class="sortBy">ID</div></th>
            <th><div @click="sortBy('startDate')" class="sortBy">Start Date</div></th>
            <th><div @click="sortBy('finishDate')" class="sortBy">End Date</div></th>
            <th><div @click="sortBy('description')" class="sortBy">Description</div></th>
            <th><div @click="sortBy('dermatologist_id')" class="sortBy">DermatologistID</div></th>
            <th><div @click="sortBy('approdved')" class="sortBy">Status</div></th>
        </tr>

        <tr v-for="vacation in vacations"  v-bind:key="vacation.id"> 
            <td> {{vacation.id}}</td>
            <td> {{vacation.startDate}}</td>
            <td> {{vacation.finishDate}}</td>
            <td> {{vacation.description}}</td>
            <td> {{vacation.dermatologist_id}}</td>
            <td> {{vacation.approdved}}</td>
            <td><button @click="Answer(vacation.id)">Answer</button></td>

        </tr>
    </table>
    <div>
        <h5>{{ msg }}</h5>
    </div>

    <component v-on:close-component="closeComponet"  v-bind:is="component"> </component>


</template>

<script>

import axios from "axios";

import AnswerToVacation from "@/components/Administrator/AnswerToVacation.vue"

export default {
    name: "AdminDermatologistVacationTable",

    components: {
        'answer-vacation': AnswerToVacation,
    },

    data(){
        return{
        vacations : [],
        apotecary_id : null,

        medInfoId: null,

        msg: "",
        component:null,

        reason: null,
        vacation_id: null,

        last_sort : null
        }
    },

    props: {
        adminINF: Object
    },

    mounted() {
        this.apotecary_id = this.adminINF.apotecary_id;
        axios.post("/api/dermatologist-vacation/get-all-admin", {id : this.apotecary_id})
            .then(response => {
                this.vacations = response.data;
            })
    },


    methods: {

        Accept()
        {
            axios.post("/api/dermatologist-vacation/vacation-response", {answer: true, reason: this.reason, vacation_id : this.vacation_id})
            .then(response => {
                this.msg = response.data;
                this.refresh();
            })
        },

        Decline()
        {
           axios.post("/api/dermatologist-vacation/vacation-response", {answer: false, reason: this.reason, vacation_id : this.vacation_id})
            .then(response => {
                this.msg = response.data;
                this.refresh();
            })
        },

        Answer(vacId)
        {
            this.vacation_id = vacId;
            this.component ='answer-vacation';
        },

        closeComponet(value){
            this.reason = value.answer;

            if(value.decision == true){
                this.Accept();
            }
            else{
                this.Decline();
            }

            this.component = null;
        },

        refresh(){
            axios.post("/api/dermatologist-vacation/get-all-admin", {id : this.apotecary_id})
            .then(response => {
                this.vacations = response.data;
                this.sortBy(this.last_sort);
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