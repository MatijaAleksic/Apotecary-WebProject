<template>
    <h3> Apotecaries </h3>

    <input type="text" v-model="searchName" placeholder="Name"/>
    <input type="text" v-model="searchAdress" placeholder="Adress"/>

    <table>
        <tr bgcolor='lightgrey'>
            <th><div @click="sortBy('id')" class="sortBy">ID</div></th>
            <th><div @click="sortBy('name')" class="sortBy">Name</div></th>
            <th><div @click="sortBy('adress')" class="sortBy">Adress</div></th>
            <th><div @click="sortBy('description')" class="sortBy">Description</div></th>
        </tr>

        <tr @click="selectedApotecary(apotecary.id)" v-for="apotecary in fillteredApotecaries"  v-bind:key="apotecary.id"> 
            <td> {{apotecary.id}}</td>
            <td> {{apotecary.name}}</td>
            <td> {{apotecary.adress}}</td>
            <td> {{apotecary.description}}</td>
        </tr>
    </table>

    <div>
          <h5>{{ msg }}</h5>
    </div>

</template>

<script>


import axios from "axios";
export default {
    name: "ApotecariesTable",

    data(){
        return{
        apotecaries : [],

        selectedApotecaries: {},

        searchName: "",
        searchAdress: "",

        msg: ""
        }
    },

    /* props: { 
        adminINF: Object
    },*/

    created() {
        axios.get("/api/apotecary/get-all")
            .then(response => {
                this.apotecaries = response.data;
            })
    },

    methods: {

        /*deleteDermatologist(identification){
            axios.post("/api/dermatologist/delete", {id: identification})
            .then(response => {
                this.msg = response.data;
                this.refresh(); 
            })
        },*/

        refresh(){
            axios.get("/api/apotecary/get-all")
            .then(response => {
                this.apotecaries = response.data;
            })
        },

        sortBy(prop) {
            this.apotecaries.sort((a, b) => a[prop] < b[prop] ? -1 : 1)
        },

        selectedApotecary(apotecary){
            this.$emit('selected-apotecary', apotecary);
        }
    },

    computed: {
        fillteredApotecaries: function() {
            return this.apotecaries.filter( (elem) => {
                return elem.name.toLowerCase().match(this.searchName.toLowerCase()) && elem.adress.toLowerCase().match(this.searchAdress.toLowerCase())
        });
    }

  }
}
</script>

<style scoped>
</style>