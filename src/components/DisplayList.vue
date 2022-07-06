<template>
    <div class="list-container">
        <div class="recipt-item" v-for="item in items" :key="item.type">
            <p class="recipt-type">{{ item.type }}</p>
            <p class="recipt-value">$ {{ item.value }} </p>
        </div>
        <div class="new-recipt-container"></div>
        <div class="button-container">
            <BasicButton class="new-recipt-button"
            text="Create new recipt"
            color="#2274a5"
            :fontSize="14"
            >
            </BasicButton>
        </div>
    </div>
</template>
<script>
import BasicButton from './BasicButton.vue'
export default {
    name: 'DisplayList',
    data() {
        return {
            items: [
                { type: "Foo", value: 14},
                { type: "Bar", value: 50},
                { type: "Bar", value: 50},
                { type: "Bar", value: 50},
                { type: "Bar", value: 50},
                { type: "Bar", value: 50},
            ]
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
    height: 50vh;
    width: 70%;
    border: dotted 2px black;
    border-bottom: none;
}
.recipt-item {
    display: flex;
    justify-content: space-evenly;
    border-bottom: solid 2px lightgray;
}
.recipt-type {
    font-weight: bold;
}
.new-recipt-conatiner {
    display: flex;
    justify-content: center;
    align-items: center;
}
.new-recipt-button {
    margin: 15px;
}
</style>
