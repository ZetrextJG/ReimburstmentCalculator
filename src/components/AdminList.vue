<template>
    <div class="list-container">
        <div class="button-container">
            <input v-model="type_entry" placeholder="Add new type">
            <BasicButton class="new-type-button"
            text="Add new type"
            color="#2274a5"
            :fontSize="14"
            >
            </BasicButton>
        </div>
        <div class="recipt-item" v-for="(item, index) in items" :key=index>
            <p class="recipt-type">{{ item.value }}</p>
            <p class="recipt-type">{{ index }}</p>
            <BasicButton class="remove-item-button"
            text="Remove"
            color="#cc2936"
            :fontSize="14"
            >
            </BasicButton>
        </div>
        <div class="new-recipt-container"></div>
    </div>
</template>
<script>
import BasicButton from './BasicButton.vue'
export default {
    name: 'AdminList',
    data() {
        return {
            items: [
                { value: "Foo"},
                { value: "Bar"},
                { value: "Bar"}
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
    flex-flow: row;
    align-items: center;
    justify-content: space-evenly;
    border-bottom: solid 2px lightgray;
}
.button-container {
    display: flex;
    flex-flow: row;
    justify-content: space-around;
    border-bottom: solid 3px black;
    padding-top: 10px;
    padding-bottom: 10px;
    padding-right: 5px;
    padding-left: 5px;
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
