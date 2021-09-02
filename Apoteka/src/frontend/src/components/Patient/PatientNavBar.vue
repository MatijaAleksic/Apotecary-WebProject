<template>
<div>
    <nav>
        <h3 class="title"> Patient Homepage </h3>
        <div class="menu-item"><a @click="ChangeComponent('profile')">Profile</a></div>
        <div class="menu-item"><a @click="ChangeComponent('apotecary')">Apotecary</a></div>
    </nav>
</div>
</template>

<script>
//import { defineComponent } from '@vue/composition-api'


export default {
    name: 'AdminNavBar',

    methods:{

        ChangeComponent(value){
            this.$emit('change-main-component', value);
        }


    }

}

</script>

<style scoped>
nav{
    height: 15px;
    display: flex;
    align-items: center;    
}

nav .menu-item{

    color: #FFF;
    padding: 15px 15px;
    position: relative;
    text-align: center;
    border-bottom: 3-x solid transparent;
    display: flex;
    transition: 0.4s;
}

nav .menu-item a {
    color: inherit;
    text-decoration: none;
}

nav .title {
    padding: 10px 10px;
    justify-content: center;
    text-align: left;
    color: white;
}
</style>
