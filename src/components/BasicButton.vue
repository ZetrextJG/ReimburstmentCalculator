<template>
    <div class="conatiner">
        <button class="button" 
        @click="func"
        :style="{
        'background-color': color,
        'font-size': fontSize
        }">
            {{ text }}
        </button>
    </div>
</template>
<script>
export default {
    name: "BasicButton",
    props: {
        text: String,
        color: String,
        fontSize: String,
        func: Function
    },
    setup(props) {
        console.log(props.text);
    },
}
</script>
<style scoped>
.container{
    display: flex;    
    align-items: center;
    justify-content: center;
}
.button{
    border: none;
    border-radius: 20px;
    color: white;
    padding: 0.5em 1.3em;
    text-align: center;
    text-decoration: none;
    display: inline-block;
    margin: 4px 6px;
    cursor: pointer;
}
</style>
