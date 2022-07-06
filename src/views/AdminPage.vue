<template>
  <div class="calc_form">
    <h2>Admin Page</h2>
    <div class="separator"></div>
    <AdminList></AdminList>
  </div>
</template>

<script>
import AdminList from "@/components/AdminList.vue"
export default {
    name: "AdminPage",
    setup() {
        
    },
    components: {
        AdminList
    }
}
</script>   

<!-- Add "scoped" attribute to limit CSS to this component only -->
<style scoped>
.simple-text {
    color: black;
    font-size: 20px;
    font-weight: bold;
}
.separator {
    height: 5px;
    border: none;
    border-radius: 3px;
    width: 70%;
    background-color: #aaa;
    margin-bottom: 20px;
}
.clear-button {
    margin-left: auto;
}
.toplayer {
    align-items: center;
    width: 70%;
    display: flex;
}
.calc_form {
    background-color: #faf7e5;
    margin: 10px;
    height: 100%;
    width: min(600px, 80%);
    display: flex;
    align-items: center;
    flex-flow: column;
}
</style>
