<template>
    <div class="bosslogin">

        <Boss></Boss>
        <div class="boss_do">
            <br>
            <el-form :inline="true" :model="userinf" class="demo-form-inline">
                <el-form-item label="账号">
                    <el-input v-model="userinf.username" placeholder="账号"></el-input>
                </el-form-item>
                <el-form-item label="姓名">
                    <el-input v-model="userinf.name" placeholder="姓名"></el-input>
                </el-form-item>
                <el-form-item>
                    <el-button type="primary" @click="onSubmitUser">查询</el-button>
                </el-form-item>
            </el-form>

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
                        width="200"/>
                <el-table-column
                        prop="name"
                        label="真实姓名"
                        width="180"/>
                <el-table-column
                        prop="birthday"
                        label="生日"
                        width="240"/>
                <el-table-column
                        prop="sex"
                        label="性别"
                        width="80"/>
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
                <el-table-column
                        prop=""
                        label="是否禁用"
                        width="180">
                    <template slot-scope="scope">
                        <el-switch
                                v-model="scope.row.alive"
                                :active-value="1"
                                :inactive-value="0"
                                active-color="#13ce66"
                                inactive-color="#ff4949"
                                @change="switchalive($event,scope.row.username,scope.$index)"
                        >
                        </el-switch>
                        <!--                         获取索引-->
                        <!--                         {{scope.$index}}-->
                    </template>

                </el-table-column>




            </el-table>
            <br>
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
                userinf:{
                    username:'',
                    name:''
                },
                alluser:{

                },

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
            //条件查询
            onSubmitUser(){
                if(this.userinf.username == ''){
                    this.userinf.username = "全部"
                }
                if(this.userinf.name == ''){
                    this.userinf.name = "全部"
                }
                //进行条件查询
                this.$axios.post('AdminController/typeselectuser',this.$qs.stringify(
                    {
                        //刚开始查询第一页
                        'form':this.userinf
                    }
                )).then(response=>{      //返回值部分
                          this.alluser = response.data

                }).catch(error=>{
                    console.log(error)
                });




                if(this.userinf.username == "全部"){
                    this.userinf.username = ''
                }
                if(this.userinf.name == "全部"){
                    this.userinf.name = ''
                }

                this.page =1;



            },
            //改变存活状态
            switchalive(event,username,index){
                // alert(event)
                 //现在event 值是变化后的值
                this.$axios.post('AdminController/changealive',this.$qs.stringify(
                    {
                        //刚开始查询第一页
                        alive:event,
                        username:username
                    }
                )).then(response=>{      //返回值部分


                }).catch(error=>{
                    console.log(error)
                });
                //改变值
               this.alluser[index].alive = event;

            },
            gotoone(){
                if(this.userinf.username == ''){
                    this.userinf.username = "全部"
                }
                if(this.userinf.name == ''){
                    this.userinf.name = "全部"
                }
                //进行条件查询
                this.$axios.post('AdminController/typeselectuser',this.$qs.stringify(
                    {
                        //刚开始查询第一页
                        'form':this.userinf
                    }
                )).then(response=>{      //返回值部分
                    this.alluser = response.data

                }).catch(error=>{
                    console.log(error)
                });




                if(this.userinf.username == "全部"){
                    this.userinf.username = ''
                }
                if(this.userinf.name == "全部"){
                    this.userinf.name = ''
                }
                this.page=1;
            },
            gotobefore(){
                // this.$axios.post('AdminController/alluserinf',this.$qs.stringify(
                //     {
                //         //刚开始查询第一页
                //         pageNo:this.page-1
                //     }
                // )).then(response=>{      //返回值部分
                //     this.alluser = response.data;
                //
                // }).catch(error=>{
                //     console.log(error)
                // });
                if(this.userinf.username == ''){
                    this.userinf.username = "全部"
                }
                if(this.userinf.name == ''){
                    this.userinf.name = "全部"
                }
                //进行条件查询
                this.$axios.post('AdminController/typeselectuser',this.$qs.stringify(
                    {
                        //刚开始查询第一页
                        'form':this.userinf,
                        pageNo:this.page-1
                    }
                )).then(response=>{      //返回值部分
                    this.alluser = response.data

                }).catch(error=>{
                    console.log(error)
                });




                if(this.userinf.username == "全部"){
                    this.userinf.username = ''
                }
                if(this.userinf.name == "全部"){
                    this.userinf.name = ''
                }
                if(this.page >1){
                    this.page-=1;
                }
            },
            gotoafter(){
                // this.$axios.post('AdminController/alluserinf',this.$qs.stringify(
                //     {
                //         //刚开始查询第一页
                //         pageNo:this.page+1
                //     }
                // )).then(response=>{      //返回值部分
                //     this.alluser = response.data;
                //
                // }).catch(error=>{
                //     console.log(error)
                // });
                if(this.userinf.username == ''){
                    this.userinf.username = "全部"
                }
                if(this.userinf.name == ''){
                    this.userinf.name = "全部"
                }
                //进行条件查询
                this.$axios.post('AdminController/typeselectuser',this.$qs.stringify(
                    {
                        //刚开始查询第一页
                        'form':this.userinf,
                        pageNo:this.page+1
                    }
                )).then(response=>{      //返回值部分
                    this.alluser = response.data

                }).catch(error=>{
                    console.log(error)
                });




                if(this.userinf.username == "全部"){
                    this.userinf.username = ''
                }
                if(this.userinf.name == "全部"){
                    this.userinf.name = ''
                }
                if(this.page < this.lastpage){this.page+=1;}

            },
            gotofinal(){
                // this.$axios.post('AdminController/alluserinf',this.$qs.stringify(
                //     {
                //         //刚开始查询第一页
                //         pageNo:this.lastpage
                //     }
                // )).then(response=>{      //返回值部分
                //     this.alluser = response.data;
                //
                // }).catch(error=>{
                //     console.log(error)
                // });

                if(this.userinf.username == ''){
                    this.userinf.username = "全部"
                }
                if(this.userinf.name == ''){
                    this.userinf.name = "全部"
                }
                //查询多少个信息
                //查询一共有多少页
                this.$axios.post('AdminController/counttypeselectuser',this.$qs.stringify(
                    {
                        //刚开始查询第一页

                    }
                )).then(response=>{      //返回值部分
                    this.lastpage = response.data;
                    this.lastpage = Math.ceil( this.lastpage / 8) ;

                }).catch(error=>{
                    console.log(error)
                });
                //进行条件查询
                this.$axios.post('AdminController/typeselectuser',this.$qs.stringify(
                    {
                        //刚开始查询第一页
                        'form':this.userinf,
                        pageNo:this.lastpage
                    }
                )).then(response=>{      //返回值部分
                    this.alluser = response.data

                }).catch(error=>{
                    console.log(error)
                });


                if(this.userinf.username == "全部"){
                    this.userinf.username = ''
                }
                if(this.userinf.name == "全部"){
                    this.userinf.name = ''
                }
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