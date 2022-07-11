<template>
    <div class="list-container">
        <div class="button-container">
            <div class="input-container">
                <input class="stp" v-model="type_entry" placeholder="Add new type">
                <input class="stp" v-model="value_entry" placeholder="Set value">
            </div>
            <BasicButton class="new-type-button"
            text="Add new type"
            color="#2274a5"
            :fontSize="14"
            :func="addNewReceipt"
            >
            </BasicButton>
        </div>
        <div class="recipt-item" v-for="item in items" :key=item.type>
            <p class="type-text">{{ item.type }}</p>
            <p class="type-text">{{ item.value }}</p>
            <BasicButton class="remove-item-button"
            text="Remove"
            color="#cc2936"
            :fontSize="14"
            :func="() => removeFromItems(item)"
            >
            </BasicButton>
        </div>
    </div>
</template>
<script>
import { ref } from "vue";

import BasicButton from './BasicButton.vue'
export default {
    name: 'AdminList',
    components: {
        BasicButton
    },
    props: {
        items: {
            type: Array,
            required: true
        }
    },
    setup() {
        const type_entry = ref("");
        const value_entry = ref("");
        return {
            type_entry,
            value_entry
        };
    },
    methods: {
        addNewReceipt() {
            if (this.type_entry && this.value_entry){
                if (/[\d\\.]*\d+/.test(this.value_entry))
                this.$props.items.push(
                    {type: this.type_entry, value: parseFloat(this.value_entry)}
                );
            }
        },
        removeFromItems(value) {
            const index = this.items.indexOf(value);
            if (index > -1) {
                this.$props.items.splice(index, 1);
            }
        },
    }
}
</script>
<style scoped>
.new-type-button {
    width: 75%;
}
.list-container {
    margin-top: 10px;
    height: auto;
    width: 75%;
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
    align-items: center;
    justify-content: space-around;
    border-bottom: solid 3px black;
    padding-top: 10px;
    padding-bottom: 10px;
    padding-right: 5px;
    padding-left: 5px;
}
.type-text {
    font-weight: bold;
}
.input-container {
    display: flex;
    flex-flow: row;
    justify-content: space-evenly;
}
.stp {
    width: 45%;
    margin-left: 5px;
    margin-right: 5px;
    height: min-content;
}
</style>
