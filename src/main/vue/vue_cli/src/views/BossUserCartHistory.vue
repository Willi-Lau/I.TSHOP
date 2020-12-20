<template>
    <div class="bosslogin">

        <Boss></Boss>
        <div class="boss_do">
            <br>
            所有库存信息
            <div class="block">

                <div class="radio">
                    排序：
                    <el-radio-group v-model="reverse">
                        <el-radio :label="true">倒序</el-radio>
                        <el-radio :label="false">正序</el-radio>
                    </el-radio-group>
                </div>

                <br>


                <el-timeline class="carthistory" :reverse="reverse">

                        <el-timeline-item  :timestamp="item.day" placement="top" style="width: 1200px" color="#0bbd87" v-for="(item,index) in carthistory">
                            <el-card>
                                <div class="carthistory01">
                                    <span>用户名:</span><span>{{item.username}}</span>  &nbsp;&nbsp;&nbsp;&nbsp;
                                    <span>id:</span><span>{{item.id}}</span>&nbsp;&nbsp;&nbsp;&nbsp;
                                    <span>数量</span><span>{{item.num}}</span>&nbsp;&nbsp;&nbsp;&nbsp;
                                    <span>价格:</span><span>{{item.money}}</span>&nbsp;&nbsp;&nbsp;&nbsp;
                                    <span>日期:</span><span>{{item.day}}</span>&nbsp;&nbsp;&nbsp;&nbsp;
                                </div>

                                <div class="carthistory02">

                                </div>
                                <div class="carthistory03">
                                    <img :src="item.src" style="width: 100px">
                                </div>



                            </el-card>
                        </el-timeline-item>

                </el-timeline>
            </div>

        </div>


    </div>

</template>
<style scoped>
    @import "../css/BossLogin.css";
    .carthistory{
        border: none;
        background-color: #DFFFF5;
        font-family: "Adobe 黑体 Std R";
        font-size: 15px;

    }
    .bosslogin{
            background-color: #DFFFF5;
    }
    .carthistory01{
        position: relative;
        left:-200px;
        top: 60px;
    }
    .carthistory02{
        position: relative;
        left:-200px;
    }
    .carthistory03{
        position: relative;
        left: 200px;
        top: -10px;
    }
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