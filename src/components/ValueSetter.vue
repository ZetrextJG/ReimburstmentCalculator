<template>
    <div class="dialog-box">
        <div class="milage-box">
            <p>Dollar per mile</p>
            <input 
                :value="mileRate"
                @input="updateMileRate($event.target.value)"
                placeholder="Mile rate">
        </div>
        <div class="allowance-box">
            <p>Allowance per day</p>
            <input 
                :value="allowance"
                @input="updateAllowance($event.target.value)"
                placeholder="Allowance rate">
        </div>
    </div>    
</template>
<script>
export default {
    name: "ValueSetter",
    props: {
        mileRate: {
            type: Number,
            required: true
        },
        allowance: {
            type: Number,
            required: true
        }
    },
    setup() {
        
    },
    methods: {
        updateAllowance(value) {
            if (/^[\d+\\.]*\d+/.test(value)){
                this.$emit('update:allowance', parseFloat(value))
            }
        },
        updateMileRate(value) {
            if (/^[\d\\.]*\d+/.test(value)){
                this.$emit('update:mileRate', parseFloat(value))
            }
        }
    }
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
