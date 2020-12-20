<template>
    <div class="bosslogin">

        <Boss></Boss>



    </div>

</template>
<style scoped>
    @import "../css/BossLogin.css";

</style>
<script>
    import Boss from '../components/Boss'
    import $ from 'jquery'
    export default {
        data(){

            return{
                reverse: true,
                carthistory:{}
            }
        },
        components :{
            Boss
        },
        methods:{

        },
        created() {
            //    selectallcarthistory
            //进行条件查询
            this.$axios.post('AdminController/selectallcarthistory',this.$qs.stringify(
                {

                }
            )).then(response=>{      //返回值部分
                this.carthistory = response.data
                for(let i=0;i<this.carthistory.length;i++){
                    this.carthistory[i].src = require("../assets/clothes/"+this.carthistory[i].src);

                }

            }).catch(error=>{
                console.log(error)
            });
        }
    }
</script>