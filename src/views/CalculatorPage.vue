<template>
  <div class="calc_form">
    <router-link to="/admin">Go to Admin</router-link>
    <h2>Reimburstments Calculator</h2>
    <Popup
        v-if="popupTrigger"
        :PopupToggle="popupToggle">
        <h2>Select type of receipt</h2>
        <select v-if="!possibleTypes.isEmpty" v-model="selected">
            <option 
                v-for="(type, index) in possibleTypes" 
                v-bind:key="index" 
                v-bind:value="{text: type}">{{ type }}</option>
        </select>
        <BasicButton 
            class= "clear-button" 
            text="Add" 
            color="#81e979" 
            :func="addToTypesList"
            fontSize="20px" >
        </BasicButton>
        <BasicButton 
            class= "clear-button" 
            text="Cancle" 
            color="#cc2936" 
            :func="popupToggle"
            fontSize="20px" >
        </BasicButton>
    </Popup>
    <div class="separator"></div>
    <div class="toplayer">
        <p class="simple-text">Receipts: </p>
        <BasicButton 
            class= "clear-button" 
            text="Clear" 
            color="#cc2936" 
            :func="clearList"
            fontSize="20px" >
        </BasicButton>
    </div>
    <DisplayList v-model:valueList="receiptList" :createFunc="popupToggle"></DisplayList>
    <InputBox v-model:miles="userValues.miles" v-model:days="userValues.days"></InputBox>
    <ResultBox :total="total" :func="calculateTotal"></ResultBox>
  </div> 
</template>
<script>
import { ref, reactive } from "vue";

import BasicButton from '@/components/BasicButton.vue'
import Popup from "@/components/PopUp.vue"
import DisplayList from '@/components/DisplayList.vue'
import InputBox from '@/components/InputBox.vue'
import ResultBox from '@/components/ResultBox.vue'
export default {
    name: "CalculatorPage",
    setup() {
        const receiptList = ref([
            "taxi"
        ]);
        const userValues = reactive({
            miles: null,
            days: null
        })
        const popupTrigger = ref(false);
        const clearList = () => {
            receiptList.value = [];
        }
        const possibleTypes = ref([]);
        const selected = ref("");
        const total = ref(null);
        return {
            popupTrigger,
            receiptList,
            userValues,
            clearList,
            possibleTypes,
            selected,
            total
        }
    },
    methods: {
        fetchPossibleTypes() {
            const requestOptions = {
                method: "GET",
                headers: { 
                    "Content-Type": "application/json",
                    "Accept": "application/json"
                }
            };
            fetch("http://localhost:9000/fetch", requestOptions)
                .then(res =>  res.json())
                .then(data => this.possibleTypes = data);
        },
        addToTypesList() {
            if (this.selected){
                this.receiptList.push(this.selected.text);
                this.popupToggle();
            }
        },
        calculateTotal() {
            if (!this.userValues.miles) return ;
            if (!this.userValues.days) return ;
            const requestOptions = {
                method: "POST",
                headers: { 
                    "Content-Type": "application/json",
                    "Accept": "application/json"
                },
                body: JSON.stringify({
                    "days": this.userValues.days,
                    "miles": this.userValues.miles,
                    "receiptList": this.receiptList
                })
            };
            fetch("http://localhost:9000/calculate", requestOptions)
                .then(res => res.json())
                .then(data => this.total = data.value);
        },
        popupToggle() {
            if(!this.popupTrigger){
                console.log("TEST");
                this.fetchPossibleTypes();
            }
            this.popupTrigger= !this.popupTrigger;
        }
    },
    mounted() {
        this.fetchPossibleTypes();
    },
    components: {
        BasicButton,
        DisplayList,
        InputBox,
        ResultBox,
        Popup
    }
}
</script>   

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
    width: 75%;
    background-color: #aaa;
    margin-bottom: 20px;
}
.clear-button {
    margin-left: auto;
}
.toplayer {
    align-items: center;
    width: 75%;
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
select {
    margin: 20px;
}
</style>
