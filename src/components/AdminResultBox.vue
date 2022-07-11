<template>
    <div class="result-container">
        <span class="result-span">
            <p class="result-text">Status: </p>
            <p class="result-message">{{ message }}</p>
        </span>
        <div class="button-container">
            <BasicButton class="new-recipt-button"
            text="Update"
            color="#2274a5"
            fontSize="20px"
            :func="func"
            ></BasicButton>
        </div>
    </div>
</template>
<script>
import BasicButton from './BasicButton.vue'
export default {
    name: "ResultBox",
    props:{
        message: String,
        func: Function
    },
    components: {
        BasicButton
    },
    setup() {

        
    },
}
</script>
<style scoped>
.result-text {
    font-size: 20px;
    font-weight: bold;
    padding-right: 10px;
}
.result-message {
    text-decoration: underline;
    font-size: 20px;
    font-weight: bold;
}
.result-container {
    border-top: solid 3px black;
    border-left: dotted 2px black;
    border-right: dotted 2px black;
    border-bottom: dotted 2px black;
    display: flex;     
    flex-flow: row;
    width: 75%;
    justify-content: space-evenly;
    margin-bottom: 20px;
}
.result-span {
    display: flex;
    flex-flow: row;
}
.button-container {
    display: flex;
    align-items: center;
    justify-content: center;
}
</style>
