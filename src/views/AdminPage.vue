<template>
    <div class="calc_form">
        <router-link to="/">Go to Home</router-link>
        <h2>Admin Page</h2>
        <div class="separator"></div>
        <AdminList v-model:items="stored_items" ></AdminList>
        <ValueSetter 
            v-model:mileRate="stored_values.mileRate"
            v-model:allowance="stored_values.allowance">
        </ValueSetter>
        <AdminResultBox
             :func="updateBackend"
             :message="message">
        </AdminResultBox>
    </div>
</template>

<script>
import { ref, reactive } from "vue";

import AdminList from "@/components/AdminList.vue"
import ValueSetter from "@/components/ValueSetter.vue"
import AdminResultBox from "@/components/AdminResultBox.vue"
export default {
    name: "AdminPage",
    setup() {
        const stored_items = ref([
                { type: "taxi", value: 10},
                { type: "hotel", value: 60},
                { type: "air ticket", value: 50},
                { type: "train", value: 30}
        ]);

        const stored_values = reactive({
            mileRate: 0.3,
            allowance: 15
        });

        const message = ref("Not done");

        return {
            stored_items,
            stored_values,
            message
        };
    },
    methods: {
        updateBackend() {
            var parsedData = new Object();
            this.stored_items.forEach((x) => parsedData[x.type] = x.value);
            const requestOptions = {
                method: "POST",
                headers: { 
                    "Content-Type": "application/json"
                },
                body: JSON.stringify({
                    "mileRate": this.stored_values.mileRate,
                    "allowance": this.stored_values.allowance,
                    "receipts": parsedData
                })
            }
            fetch("http://localhost:9000/update", requestOptions)
                .then(response => {
                    console.log(response);
                    this.message= "Updated";
                })

        }
    },
    components: {
        AdminList,
        ValueSetter,
        AdminResultBox
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
</style>
