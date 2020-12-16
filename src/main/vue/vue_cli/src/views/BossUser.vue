<template>
    <div class="bosslogin">

        <Boss></Boss>
        <div class="boss_do">
            <br>
            所有库存信息


        </div>

        <!--        获取所有服装信息-->
        <div class="boss_all_clothes">
            <el-table
                    :data="alluser"
                    stripe
                    style="width: 100%">

                <el-table-column
                        prop="username"
                        label="账号"
                        width="280"/>
                <el-table-column
                        prop="name"
                        label="真实姓名"
                        width="180"/>
                <el-table-column
                        prop="birthday"
                        label="生日"
                        width="180"/>
                <el-table-column
                        prop="sex"
                        label="性别"
                        width="180"/>
                <el-table-column
                        prop="address"
                        label="所在城市"
                        width="180"/>
                <el-table-column
                        prop="email"
                        label="email"
                        width="180"/>
                <el-table-column
                        prop="grossmoney"
                        label="总消费"
                        width="180"/>





            </el-table>
            <br> <br> <br>
            <div>
                <el-button @click="gotoone">到第一页</el-button>
                <el-button @click="gotobefore">向前一页</el-button>
                {{this.page}}
                <el-button @click="gotoafter">向后一页</el-button>
                <el-button @click="gotofinal">到最后一页</el-button>
            </div>
            <br> <br>

        </div>
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
                alluser:{},
                page:1,
                lastpage:'',
                clothes:'',
                index:'',
                ruleForm: {


                    num: 1,
                    money:1,

                    brand:'',
                    info:'',
                    type:'',
                    id:''


                },
                }
        },
        components :{
            Boss
        },
        methods:{
            gotoone(){
                //    获取所有的用户信息
                this.$axios.post('AdminController/alluserinf',this.$qs.stringify(
                    {
                        //刚开始查询第一页
                        pageNo:1
                    }
                )).then(response=>{      //返回值部分
                    this.alluser = response.data;

                }).catch(error=>{
                    console.log(error)
                });
                this.page=1;
            },
            gotobefore(){
                this.$axios.post('AdminController/alluserinf',this.$qs.stringify(
                    {
                        //刚开始查询第一页
                        pageNo:this.page-1
                    }
                )).then(response=>{      //返回值部分
                    this.alluser = response.data;

                }).catch(error=>{
                    console.log(error)
                });
                if(this.page >1){
                    this.page-=1;
                }
            },
            gotoafter(){
                this.$axios.post('AdminController/alluserinf',this.$qs.stringify(
                    {
                        //刚开始查询第一页
                        pageNo:this.page+1
                    }
                )).then(response=>{      //返回值部分
                    this.alluser = response.data;

                }).catch(error=>{
                    console.log(error)
                });
                if(this.page < this.lastpage){this.page+=1;}

            },
            gotofinal(){
                this.$axios.post('AdminController/alluserinf',this.$qs.stringify(
                    {
                        //刚开始查询第一页
                        pageNo:this.lastpage
                    }
                )).then(response=>{      //返回值部分
                    this.alluser = response.data;

                }).catch(error=>{
                    console.log(error)
                });
                if(this.page < this.lastpage){this.page+=1;}
                this.page = this.lastpage
            },
        }
        ,
        created() {
            //    获取所有的用户信息
            this.$axios.post('AdminController/alluserinf',this.$qs.stringify(
                {
                    //刚开始查询第一页
                    pageNo:1
                }
            )).then(response=>{      //返回值部分
                this.alluser = response.data;

            }).catch(error=>{
                console.log(error)
            });
            //查询一共有多少页
            this.$axios.post('AdminController/countuser',this.$qs.stringify(
                {
                    //刚开始查询第一页

                }
            )).then(response=>{      //返回值部分
                this.lastpage = response.data;
                this.lastpage = Math.ceil( this.lastpage / 8) ;

            }).catch(error=>{
                console.log(error)
            });
        }
    }
</script>