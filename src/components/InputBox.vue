<template>
    <div class="dialog-box">
        <div class="milage-box">
            <p>Milage</p>
            <input
                placeholder="Miles driven"
                :value="miles"
                @input="updateMiles($event.target.value)">
        </div>
        <div class="allowance-box">
            <p>Days of allowance</p>
            <input 
                placeholder="Number of days"
                :value="days"
                @input="updateDays($event.target.value)">
        </div>
    </div>    
</template>
<script>
export default {
    name: "InputBox",
    props: {
        days: {
            type: Number,
            required: true
        },
        miles: {
            type: Number,
            required: true
        },
    },
    methods: {
        updateMiles(value) {
            if (/^[\d+\\.]*\d+/.test(value)){
                this.$emit('update:miles', parseFloat(value))
            }
        },
        updateDays(value) {
            if (/^[\d+\\.]*\d+/.test(value)){
                this.$emit('update:days', parseFloat(value))
            }
        },
    },
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
    width: 75%;
    border-top: solid 3px black;
    border-left: dotted 2px black;
    border-right: dotted 2px black;
}
</style>
