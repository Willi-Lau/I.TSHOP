<template>
    <div class="bosslogin">

        <Boss></Boss>
        <div class="boss_do">
            <br>

<!--            条件查询界面-->
            <el-form :inline="true" :model="formInline" class="demo-form-inline">
                <el-form-item label="id">
                    <el-input v-model="formInline.id" placeholder="id"></el-input>
                </el-form-item>
                <el-form-item label="种类">
                    <el-select v-model="formInline.type" placeholder="衣服种类">
                        <el-option label="全部" value="全部"></el-option>
                        <el-option label="男" value="男"></el-option>
                        <el-option label="女" value="女"></el-option>
                        <el-option label="童" value="童"></el-option>
                    </el-select>
                </el-form-item>
                <el-form-item label="品牌">
                    <el-select v-model="formInline.brand" placeholder="活动区域">
                        <el-option label="全部" value="全部"></el-option>
<!--                        循环出全部的品牌-->
                        <ul v-for="(item,index) in brand_clothes" >

                            <el-option :label="item" :value="item"></el-option>


                        </ul>

                    </el-select>
                </el-form-item>
                <el-form-item>
                    <el-button type="primary" @click="onSubmitInline">查询</el-button>
                </el-form-item>
            </el-form>
            <div>
                <span style="margin-right: 50px">注意：编辑修改时请关闭排序功能 </span>
                <span style="margin-right: 30px">
                    库存低于150/80/30/10会有不同颜色提示</span>
                    <el-color-picker v-model="color1" show-alpha size="small"></el-color-picker>
                <el-color-picker v-model="color2" show-alpha size="small"></el-color-picker>
                <el-color-picker v-model="color3" show-alpha size="small"></el-color-picker>
                <el-color-picker v-model="color4" show-alpha size="small"></el-color-picker>

            </div>


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
                     :row-class-name="tableRowClassName"

                     style="width: 100%">
                 <el-table-column prop="id"
                                  label="id值"
                                  width="80"
                                  sortable
                 />
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
                         sortable
                         prop="money"
                         label="价格"
                         width="180"/>
                 <el-table-column

                         sortable
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
<!--             <div>-->
<!--                 <el-button @click="gotoone">到第一页</el-button>-->
<!--                 <el-button @click="gotobefore">向前一页</el-button>-->
<!--                  {{this.page}}-->
<!--                 <el-button @click="gotoafter">向后一页</el-button>-->
<!--                 <el-button @click="gotofinal">到最后一页</el-button>-->
<!--             </div>-->
             <div class="block">
                 <span class="demonstration"></span>
                 <el-pagination
                         @size-change="handleSizeChange"
                         @current-change="handleCurrentChange"
                         :current-page="currentPage4"
                         :page-sizes="pagesizes"
                         :page-size="pageSize"
                         layout="total, sizes, prev, pager, next, jumper"
                         :total="total">
                 </el-pagination>
             </div>
             <br> <br>

         </div>
    </div>

</template>
<style scoped>
    @import "../css/BossLogin.css";

</style>
<script>
    import { Notification } from 'element-ui';
    import Boss from '../components/Boss'
    import $ from 'jquery'

    export default {
        data(){

            return{
                color4:'#470303',
                color3:'#8d0e0e',
                color2:'#e06a6a',
                color1:'rgba(229, 166, 166, 0.63)',
                pagesizes:[5,6,10],
                pageSize:6,
                total:1,
                currentPage4:1,
                brand_clothes:{},
                formInline: {
                    id: '',
                    brand: '全部',
                    type:'全部'
                },
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
            tableRowClassName({row, rowIndex}) {
                if (row.num < 10) {
                    return 'warning-row4';
                }
                else if (row.num < 30) {
                    return 'warning-row3';
                }
                else if (row.num < 80) {
                    return 'warning-row2';
                }
                else if (row.num < 150) {
                    return 'warning-row1';
                }
                return '';
            },
            //分页
            handleSizeChange(val) {
                this.pageSize = val;

                if(this.formInline.id == ''){
                    this.formInline.id = 0
                }
                if(this.formInline.type == ''){
                    this.formInline.type = "全部"
                }

                if(this.formInline.brand == ''){
                    this.formInline.brand = "全部"
                }

                this.$axios.post('AdminController/typeselectclothes',   //URL首字母必须是大写不然会出错
                    this.$qs.stringify({       //传参部分 使用q
                        'form':this.formInline,
                        pageNo:1,
                        pageSize:this.pageSize
                    })).then(response=>{      //返回值部分  返回查询到的结果集
                    //首先删除 allclothes 里面的所有东西


                    this.allclothes = response.data
                    for(let i=0;i<this.allclothes.length;i++){
                        this.allclothes[i].src = require("../assets/clothes/"+this.allclothes[i].src);
                        console.log(this.allclothes[i].src)
                    }
                    console.log(response.data)
                }).catch(error=>{
                    console.log(error)
                })
                this.currentPage4 = 1;
                if(this.formInline.id == 0){this.formInline.id = '';}
            },
            handleCurrentChange(val) {
                this.currentPage4 =  val;

                if(this.formInline.id == ''){
                    this.formInline.id = 0
                }
                if(this.formInline.type == ''){
                    this.formInline.type = "全部"
                }

                if(this.formInline.brand == ''){
                    this.formInline.brand = "全部"
                }

                this.$axios.post('AdminController/typeselectclothes',   //URL首字母必须是大写不然会出错
                    this.$qs.stringify({       //传参部分 使用q
                        'form':this.formInline,
                        pageNo:this.currentPage4 ,
                        pageSize:this.pageSize


                    })).then(response=>{      //返回值部分  返回查询到的结果集
                    //首先删除 allclothes 里面的所有东西

                    // alert(456)
                    this.allclothes = response.data
                    for(let i=0;i<this.allclothes.length;i++){
                        this.allclothes[i].src = require("../assets/clothes/"+this.allclothes[i].src);
                        console.log(this.allclothes[i].src)
                    }
                    console.log(response.data)
                }).catch(error=>{
                    console.log(error)
                })
                if(this.formInline.id == 0){this.formInline.id = '';}
                // alert(`当前页: ${val}`);
            },
            //条件查询
            onSubmitInline(){

                //首先根据条件进行查询
                //对form的数据进行包装 如果是空就替换成0
                if(this.formInline.id == ''){
                    this.formInline.id = 0
                }
                if(this.formInline.type == ''){
                    this.formInline.type = "全部"
                }

                if(this.formInline.brand == ''){
                    this.formInline.brand = "全部"
                }


                this.$axios.post('AdminController/typeselectclothes',   //URL首字母必须是大写不然会出错
                    this.$qs.stringify({       //传参部分 使用q
                        'form':this.formInline,
                        pageNo:1,
                        pageSize:this.pageSize

                    })).then(response=>{      //返回值部分  返回查询到的结果集
                        //首先删除 allclothes 里面的所有东西


                    this.allclothes = response.data
                    for(let i=0;i<this.allclothes.length;i++){
                        this.allclothes[i].src = require("../assets/clothes/"+this.allclothes[i].src);
                        console.log(this.allclothes[i].src)
                    }
                    console.log(response.data)
                }).catch(error=>{
                    console.log(error)
                })

                //查询一共有多少页
                this.$axios.post('AdminController/counttypeselectclothes',this.$qs.stringify(
                    {
                        'form':this.formInline,

                    }
                )).then(response=>{      //返回值部分
                    // this.lastpage = response.data;
                    this.total = response.data;
                    // this.lastpage = Math.ceil( this.lastpage / 6) ;

                }).catch(error=>{
                    console.log(error)
                });

                if(this.formInline.id == 0){this.formInline.id = '';}
                //回到第一页
                // this.page=1;
                this.currentPage4 = 1;
            },
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
                        this.$delete(this.allclothes,index)

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
                            // this.$qs.stringify(
                            //     {       //传参部分 使用q
                            //     'form':this.ruleForm
                            // })
                            this.ruleForm
                        ).then(response=>{      //返回值部分
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
            // gotoone(){
            //     // //    获取所有的用户信息
            //     // this.$axios.post('AdminController/selectallclothes',this.$qs.stringify(
            //     //     {
            //     //         //刚开始查询第一页
            //     //         pageNo:1
            //     //     }
            //     // )).then(response=>{      //返回值部分
            //     //     this.allclothes = response.data;
            //     //     for(let i=0;i<this.allclothes.length;i++){
            //     //         this.allclothes[i].src = require("../assets/clothes/"+this.allclothes[i].src);
            //     //         console.log(this.allclothes[i].src)
            //     //     }
            //     // }).catch(error=>{
            //     //     console.log(error)
            //     // });
            //     if(this.formInline.id == ''){
            //         this.formInline.id = 0
            //     }
            //     if(this.formInline.type == ''){
            //         this.formInline.type = "全部"
            //     }
            //
            //     if(this.formInline.brand == ''){
            //         this.formInline.brand = "全部"
            //     }
            //     this.$axios.post('AdminController/typeselectclothes',   //URL首字母必须是大写不然会出错
            //         this.$qs.stringify({       //传参部分 使用q
            //             'form':this.formInline,
            //             pageNo:1
            //         })).then(response=>{      //返回值部分  返回查询到的结果集
            //         //首先删除 allclothes 里面的所有东西
            //
            //
            //         this.allclothes = response.data
            //         for(let i=0;i<this.allclothes.length;i++){
            //             this.allclothes[i].src = require("../assets/clothes/"+this.allclothes[i].src);
            //             console.log(this.allclothes[i].src)
            //         }
            //         console.log(response.data)
            //     }).catch(error=>{
            //         console.log(error)
            //     })
            //     if(this.formInline.id == 0){this.formInline.id = '';}
            //     this.page=1;
            // },
            // gotobefore(){
            //     // //    获取所有的用户信息
            //     // this.$axios.post('AdminController/selectallclothes',this.$qs.stringify(
            //     //     {
            //     //         //刚开始查询第一页
            //     //         pageNo:this.page-1
            //     //     }
            //     // )).then(response=>{      //返回值部分
            //     //     this.allclothes = response.data;
            //     //     for(let i=0;i<this.allclothes.length;i++){
            //     //         this.allclothes[i].src = require("../assets/clothes/"+this.allclothes[i].src);
            //     //         console.log(this.allclothes[i].src)
            //     //     }
            //     //
            //     // }).catch(error=>{
            //     //     console.log(error)
            //     // });
            //     if(this.formInline.id == ''){
            //         this.formInline.id = 0
            //     }
            //     if(this.formInline.type == ''){
            //         this.formInline.type = "全部"
            //     }
            //
            //     if(this.formInline.brand == ''){
            //         this.formInline.brand = "全部"
            //     }
            //     this.$axios.post('AdminController/typeselectclothes',   //URL首字母必须是大写不然会出错
            //         this.$qs.stringify({       //传参部分 使用q
            //             'form':this.formInline,
            //             pageNo:this.page-1
            //         })).then(response=>{      //返回值部分  返回查询到的结果集
            //         //首先删除 allclothes 里面的所有东西
            //
            //
            //         this.allclothes = response.data
            //         for(let i=0;i<this.allclothes.length;i++){
            //             this.allclothes[i].src = require("../assets/clothes/"+this.allclothes[i].src);
            //             console.log(this.allclothes[i].src)
            //         }
            //         console.log(response.data)
            //     }).catch(error=>{
            //         console.log(error)
            //     })
            //     if(this.formInline.id == 0){this.formInline.id = '';}
            //     if(this.page >1){
            //     this.page-=1;
            //     }
            // },
            // gotoafter(){
            //     // //    获取所有的用户信息
            //     // this.$axios.post('AdminController/selectallclothes',this.$qs.stringify(
            //     //     {
            //     //         //刚开始查询第一页
            //     //         pageNo:this.page+1
            //     //     }
            //     // )).then(response=>{      //返回值部分
            //     //     this.allclothes = response.data;
            //     //     for(let i=0;i<this.allclothes.length;i++){
            //     //         this.allclothes[i].src = require("../assets/clothes/"+this.allclothes[i].src);
            //     //         console.log(this.allclothes[i].src)
            //     //     }
            //     // }).catch(error=>{
            //     //     console.log(error)
            //     // });
            //     if(this.formInline.id == ''){
            //         this.formInline.id = 0
            //     }
            //     if(this.formInline.type == ''){
            //         this.formInline.type = "全部"
            //     }
            //
            //     if(this.formInline.brand == ''){
            //         this.formInline.brand = "全部"
            //     }
            //     this.$axios.post('AdminController/typeselectclothes',   //URL首字母必须是大写不然会出错
            //         this.$qs.stringify({       //传参部分 使用q
            //             'form':this.formInline,
            //             pageNo:this.page+1
            //         })).then(response=>{      //返回值部分  返回查询到的结果集
            //         //首先删除 allclothes 里面的所有东西
            //
            //
            //         this.allclothes = response.data
            //         for(let i=0;i<this.allclothes.length;i++){
            //             this.allclothes[i].src = require("../assets/clothes/"+this.allclothes[i].src);
            //             console.log(this.allclothes[i].src)
            //         }
            //         console.log(response.data)
            //     }).catch(error=>{
            //         console.log(error)
            //     })
            //     if(this.page < this.lastpage){this.page+=1;}
            //     if(this.formInline.id == 0){this.formInline.id = '';}
            //
            // },
            // gotofinal(){
            //     // //    获取所有的用户信息
            //     // this.$axios.post('AdminController/selectallclothes',this.$qs.stringify(
            //     //     {
            //     //         //刚开始查询第一页
            //     //         pageNo:this.lastpage
            //     //     }
            //     // )).then(response=>{      //返回值部分
            //     //     this.allclothes = response.data;
            //     //     for(let i=0;i<this.allclothes.length;i++){
            //     //         this.allclothes[i].src = require("../assets/clothes/"+this.allclothes[i].src);
            //     //         console.log(this.allclothes[i].src)
            //     //     }
            //     // }).catch(error=>{
            //     //     console.log(error)
            //     // });
            //     if(this.formInline.id == ''){
            //         this.formInline.id = 0
            //     }
            //     if(this.formInline.type == ''){
            //         this.formInline.type = "全部"
            //     }
            //
            //     if(this.formInline.brand == ''){
            //         this.formInline.brand = "全部"
            //     }
            //     this.$axios.post('AdminController/typeselectclothes',   //URL首字母必须是大写不然会出错
            //         this.$qs.stringify({       //传参部分 使用q
            //             'form':this.formInline,
            //             pageNo:this.lastpage
            //         })).then(response=>{      //返回值部分  返回查询到的结果集
            //         //首先删除 allclothes 里面的所有东西
            //
            //
            //         this.allclothes = response.data
            //         for(let i=0;i<this.allclothes.length;i++){
            //             this.allclothes[i].src = require("../assets/clothes/"+this.allclothes[i].src);
            //             console.log(this.allclothes[i].src)
            //         }
            //         console.log(response.data)
            //     }).catch(error=>{
            //         console.log(error)
            //     })
            //      this.page = this.lastpage
            //     if(this.formInline.id == 0){this.formInline.id = '';}
            // },
        }
        ,
        created() {
            if(this.formInline.id == ''){
                this.formInline.id = 0
            }
            if(this.formInline.type == ''){
                this.formInline.type = "全部"
            }

            if(this.formInline.brand == ''){
                this.formInline.brand = "全部"
            }
            //所有的衣服品牌
            this.$axios.post('ClothesController/select_allclothesbrand',this.$qs.stringify(

            )).then(response=>{      //返回值部分
                this.brand_clothes = response.data;
                console.log(response.data)
            }).catch(error=>{
                console.log(error)
            });
        //    获取所有的用户信息
        //     this.$axios.post('AdminController/selectallclothes',this.$qs.stringify(
        //         {
        //             //刚开始查询第一页
        //               pageNo:1
        //         }
        //     )).then(response=>{      //返回值部分
        //         this.allclothes = response.data;
        //         for(let i=0;i<this.allclothes.length;i++){
        //             this.allclothes[i].src = require("../assets/clothes/"+this.allclothes[i].src);
        //             console.log(this.allclothes[i].src)
        //         }
        //     }).catch(error=>{
        //         console.log(error)
        //     });
            this.$axios.post('AdminController/typeselectclothes',   //URL首字母必须是大写不然会出错
                this.$qs.stringify({       //传参部分 使用q
                    'form':this.formInline,
                    pageNo:1,
                    pageSize:this.pageSize
                })).then(response=>{      //返回值部分  返回查询到的结果集
                //首先删除 allclothes 里面的所有东西


                this.allclothes = response.data
                for(let i=0;i<this.allclothes.length;i++){
                    this.allclothes[i].src = require("../assets/clothes/"+this.allclothes[i].src);
                    console.log(this.allclothes[i].src)
                }
                console.log(response.data)
            }).catch(error=>{
                console.log(error)
            })
            //查询一共有多少页
            this.$axios.post('AdminController/counttypeselectclothes',this.$qs.stringify(
                {
                    'form':this.formInline,

                }
            )).then(response=>{      //返回值部分
                this.lastpage = response.data;
                // this.lastpage = Math.ceil( this.lastpage / 6) ;
                this.total = response.data;
                this.pagesizes.push(response.data)


            }).catch(error=>{
                console.log(error)
            });
            if(this.formInline.id == 0){this.formInline.id = '';}


            // this.$axios.post('AdminController/countclothes',this.$qs.stringify(
            //     {
            //         //刚开始查询第一页
            //
            //     }
            // )).then(response=>{      //返回值部分
            //     this.lastpage = response.data;
            //     this.lastpage = Math.ceil( this.lastpage / 6) ;
            //
            // }).catch(error=>{
            //     console.log(error)
            // });
        }
    }
</script>