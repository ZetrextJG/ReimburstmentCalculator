<template>
    <div class="dialog-box">
        <div class="milage-box">
            <p>Milage</p>
            <input v-model="milage" placeholder="Miles driven">
        </div>
        <div class="allowance-box">
            <p>Allowance</p>
            <input v-model="allowance" placeholder="Days of allowance">
        </div>
    </div>    
</template>
<script>
export default {
    name: "InputBox",
    setup() {
        
    },
}
</script>
<style scoped>
input {
    width: 80%;
}
.dialog-box {
    padding-bottom: 10px;
    display: flex;
    flex-flow: row;
    justify-content: space-evenly;
    height: 10vh;
    width: 70%;
    border-top: solid 3px black;
    border-left: dotted 2px black;
    border-right: dotted 2px black;
}
</style>
