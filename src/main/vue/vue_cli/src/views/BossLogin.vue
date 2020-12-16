<template>
    <div class="bosslogin">

        <Boss></Boss>
        <div class="boss_do">
            <br>
            所有库存信息


        </div>
<!--        更改界面-->
        <div class="boss_change">
            <div class="boss_change_inf">
                <el-form :model="ruleForm" :rules="rules" ref="ruleForm" label-width="100px" class="demo-ruleForm" enctype="multipart/form-data">

                    <el-form-item label="品牌" prop="brand" >
                        <el-input v-model="ruleForm.brand"></el-input>
                    </el-form-item>
                    <el-form-item label="介绍" prop="info">
                        <el-input v-model="ruleForm.info"></el-input>
                    </el-form-item>
                    <el-form-item label="价格" prop="name">
                        <el-input-number v-model="ruleForm.money" @change="handleChangemoney" :min="1" :max="99999" label="描述文字"></el-input-number>
                    </el-form-item>
                    <el-form-item label="库存数量" prop="name">
                        <el-input-number v-model="ruleForm.num" @change="handleChange" :min="1" :max="99999" label="描述文字"></el-input-number>
                    </el-form-item>

                    <el-form-item label="种类" prop="type">
                        <el-radio-group v-model="ruleForm.type">
                            <el-radio label="男"></el-radio>
                            <el-radio label="女"></el-radio>
                            <el-radio label="童"></el-radio>
                        </el-radio-group>
                    </el-form-item>

<!--                    <el-upload-->
<!--                            class="upload-demo"-->
<!--                            drag-->
<!--                            action="http://localhost:8080/"-->
<!--                            multiple>-->
<!--                        <i class="el-icon-upload"></i>-->
<!--                        <div class="el-upload__text">将文件拖到此处，或<em>点击上传</em></div>-->
<!--                        <div class="el-upload__tip" slot="tip">只能上传jpg/png文件，且不超过500kb</div>-->
<!--                    </el-upload>-->
                    <br>
                    <el-form-item>
                        <el-button type="primary" @click="change_sure('ruleForm')">确定修改</el-button>



                            <el-button @click="change_notsure">取消</el-button>

                    </el-form-item>
                </el-form>
            </div>



        </div>
<!--        获取所有服装信息-->
         <div class="boss_all_clothes">
             <el-table
                     :data="allclothes"
                     stripe
                     style="width: 100%">
                 <el-table-column prop="id" label="id值" width="80"/>
                 <el-table-column
                         prop="type"
                         label="种类"
                         width="80"/>
                 <el-table-column
                         prop="brand"
                         label="品牌"
                         width="240"/>
                 <el-table-column
                         prop="info"
                         label="介绍"
                         width="240"/>
                 <el-table-column
                         prop="money"
                         label="价格"
                         width="180"/>
                 <el-table-column
                         prop="num"
                         label="库存数量"
                         width="140"/>
                 <el-table-column
                         prop=""
                         label="图片"
                         width="150">
                     <template slot-scope="scope">
                        <img :src="scope.row.src" style="width: 60px">

                     </template>
                     </el-table-column>
                 <el-table-column
                         prop=""
                         label="操作"
                         width="180">
                     <template slot-scope="scope">
                         <el-button type="primary" size="min" plain @click="bosschange(scope.row.id,scope.$index)">编辑</el-button>
                         <el-button type="danger" size="min"  plain @click="bossdel(scope.row.id,scope.$index)">删除</el-button>
<!--                         获取索引-->
<!--                         {{scope.$index}}-->
                     </template>

                 </el-table-column>



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
                 allclothes:{},
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
                rules: {
                    brand: [

                        { min: 1, max: 50, message: '长度在 1 到 50 个字符', trigger: 'blur' }
                    ],
                    info: [

                        { min: 1, max: 50, message: '长度在 1 到 50 个字符', trigger: 'blur' }
                    ],
            }}
        },
        components :{
            Boss
        },
        methods:{
            bossdel(id,index){
                //弹窗
                this.$alert('', '是否删除', {
                    confirmButtonText: '确定',
                    callback: action => {

                        this.$axios.post('AdminController/deleteclothes',   //URL首字母必须是大写不然会出错
                            this.$qs.stringify({       //传参部分 使用q
                                id:id
                            })).then(response=>{      //返回值部分
                            console.log(response.data)
                        }).catch(error=>{
                            console.log(error)
                        })
                        this.$delete(this.allclothes,[index])

                        this.$message({
                            type: 'info',
                            message: `delete Success`
                        });
                    }
                });

            },
            change_sure(formName){
                this.$refs[formName].validate((valid) => {
                    if (valid) {
                        var page1 = this.page
                        //执行正确操作

                        this.$axios.post('AdminController/modifyclothes',   //URL首字母必须是大写不然会出错
                            this.$qs.stringify({       //传参部分 使用q
                                'form':this.ruleForm
                            })).then(response=>{      //返回值部分
                            console.log(response.data)
                        }).catch(error=>{
                            console.log(error)
                        })

                        //弹窗
                        this.$alert('', '修改成功', {
                            confirmButtonText: '确定',
                            callback: action => {
                                this.$message({
                                    type: 'info',
                                    message: `Modify User Success`
                                });
                            }
                        });
                        this.change_notsure();
                        //使用this.$set 改变Vue不能实时监听list arr 的问题
                        this.$set(this.allclothes[this.index],"type",this.ruleForm.type)
                        this.$set(this.allclothes[this.index],"num",this.ruleForm.num)
                        this.$set(this.allclothes[this.index],"money",this.ruleForm.money)
                        this.$set(this.allclothes[this.index],"info",this.ruleForm.info)
                        this.$set(this.allclothes[this.index],"brand",this.ruleForm.brand)





                    } else {
                        this.$notify.error({
                            title: '错误',
                            message: '请正确填写信息'
                        });
                        return false;
                    }
                });
            },
            handleChangemoney(value) {
                console.log(value);
            },
            handleChange(value) {
                console.log(value);
            },
            change_notsure(){
                $(".boss_change").css("display","none").siblings().css({"pointer-events":"auto","opacity":"1"})
            },
            //根据指定id查询信息
            bosschange(id1,index){
                this.index = index
                $(".boss_change").css("display","block").siblings().css({"pointer-events":"none","opacity":"0.2"})

                this.$axios.post('AdminController/selectbyid',this.$qs.stringify(
                    {
                        //刚开始查询第一页
                        id:id1
                    }
                )).then(response=>{      //返回值部分

                    this.ruleForm = response.data
                }).catch(error=>{
                    console.log(error)
                });
            },
            gotoone(){
                //    获取所有的用户信息
                this.$axios.post('AdminController/selectallclothes',this.$qs.stringify(
                    {
                        //刚开始查询第一页
                        pageNo:1
                    }
                )).then(response=>{      //返回值部分
                    this.allclothes = response.data;
                    for(let i=0;i<this.allclothes.length;i++){
                        this.allclothes[i].src = require("../assets/clothes/"+this.allclothes[i].src);
                        console.log(this.allclothes[i].src)
                    }
                }).catch(error=>{
                    console.log(error)
                });
                this.page=1;
            },
            gotobefore(){
                //    获取所有的用户信息
                this.$axios.post('AdminController/selectallclothes',this.$qs.stringify(
                    {
                        //刚开始查询第一页
                        pageNo:this.page-1
                    }
                )).then(response=>{      //返回值部分
                    this.allclothes = response.data;
                    for(let i=0;i<this.allclothes.length;i++){
                        this.allclothes[i].src = require("../assets/clothes/"+this.allclothes[i].src);
                        console.log(this.allclothes[i].src)
                    }

                }).catch(error=>{
                    console.log(error)
                });
                if(this.page >1){
                this.page-=1;
                }
            },
            gotoafter(){
                //    获取所有的用户信息
                this.$axios.post('AdminController/selectallclothes',this.$qs.stringify(
                    {
                        //刚开始查询第一页
                        pageNo:this.page+1
                    }
                )).then(response=>{      //返回值部分
                    this.allclothes = response.data;
                    for(let i=0;i<this.allclothes.length;i++){
                        this.allclothes[i].src = require("../assets/clothes/"+this.allclothes[i].src);
                        console.log(this.allclothes[i].src)
                    }
                }).catch(error=>{
                    console.log(error)
                });
                if(this.page < this.lastpage){this.page+=1;}

            },
            gotofinal(){
                //    获取所有的用户信息
                this.$axios.post('AdminController/selectallclothes',this.$qs.stringify(
                    {
                        //刚开始查询第一页
                        pageNo:this.lastpage
                    }
                )).then(response=>{      //返回值部分
                    this.allclothes = response.data;
                    for(let i=0;i<this.allclothes.length;i++){
                        this.allclothes[i].src = require("../assets/clothes/"+this.allclothes[i].src);
                        console.log(this.allclothes[i].src)
                    }
                }).catch(error=>{
                    console.log(error)
                });
                 this.page = this.lastpage
            },
        }
        ,
        created() {
        //    获取所有的用户信息
            this.$axios.post('AdminController/selectallclothes',this.$qs.stringify(
                {
                    //刚开始查询第一页
                      pageNo:1
                }
            )).then(response=>{      //返回值部分
                this.allclothes = response.data;
                for(let i=0;i<this.allclothes.length;i++){
                    this.allclothes[i].src = require("../assets/clothes/"+this.allclothes[i].src);
                    console.log(this.allclothes[i].src)
                }
            }).catch(error=>{
                console.log(error)
            });
            //查询一共有多少页
            this.$axios.post('AdminController/countclothes',this.$qs.stringify(
                {
                    //刚开始查询第一页

                }
            )).then(response=>{      //返回值部分
                this.lastpage = response.data;
                this.lastpage = Math.ceil( this.lastpage / 6) ;

            }).catch(error=>{
                console.log(error)
            });
        }
    }
</script>