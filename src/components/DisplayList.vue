<template>
    <div class="list-container">
        <div class="receipt-item" v-for="(item, index) in valueList" :key="index">
            <p class="receipt-type">{{ item  }}</p>
        </div>
        <div class="new-receipt-container"></div> <div class="button-container">
            <BasicButton class="new-receipt-button"
            text="Create new receipt"
            color="#2274a5"
            :fontSize="14"
            :func="createFunc"
            >
            </BasicButton>
        </div>
    </div>
</template>
<script>
import BasicButton from './BasicButton.vue'
export default {
    name: 'DisplayList',
    props: {
        valueList: {
            type: Array,
            required: true
        },
        createFunc: {
            type: Function,
            required: true
        }
    },
    components: {
        BasicButton
    },
    setup() {
    }
}
</script>
<style scoped>
.list-container {
    margin-top: 10px;
    height: auto;
    width: 75%;
    border: dotted 2px black;
    border-bottom: none;
}
.receipt-item {
    display: flex;
    justify-content: space-evenly;
    border-bottom: solid 2px lightgray;
}
.receipt-type {
    font-weight: bold;
}
.new-receipt-conatiner {
    display: flex;
    justify-content: center;
    align-items: center;
}
.new-receipt-button {
    margin: 15px;
}
</style>
