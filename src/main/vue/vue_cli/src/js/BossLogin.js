
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
