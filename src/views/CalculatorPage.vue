<template>
  <div class="calc_form">
    <h2>Reimburstments Calculator</h2>
    <div class="separator"></div>
    <div class="toplayer">
        <p class="simple-text">Recipts: </p>
        <BasicButton class= "clear-button" text="Clear" color="#2274a5" fontSize="20px">
        </BasicButton>
    </div>
    <DisplayList></DisplayList>
    <InputBox></InputBox>
    <ResultBox></ResultBox>
  </div>
</template>

<script>
import BasicButton from '@/components/BasicButton.vue'
import DisplayList from '@/components/DisplayList.vue'
import InputBox from '@/components/InputBox.vue'
import ResultBox from '@/components/ResultBox.vue'
export default {
    name: "CalculatorPage",
    setup() {
        
    },
    components: {
        BasicButton,
        DisplayList,
        InputBox,
        ResultBox
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
