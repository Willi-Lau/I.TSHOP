<template>
    <div class="bossaddclothes">

        <el-form :model="ruleForm" :rules="rules" ref="ruleForm" label-width="100px" class="demo-ruleForm" enctype="multipart/form-data">
            <br>
            <span class="bossaddclothes_brand">品牌</span>
            <el-autocomplete
                    popper-class="my-autocomplete"
                    v-model="ruleForm.brand"
                    :fetch-suggestions="querySearch"
                    placeholder="请输入内容"
                    size="medium"
                    @select="handleSelect">
                <i
                        class="el-icon-edit el-input__icon"
                        slot="suffix"
                        @click="handleIconClick">
                </i>
                <template slot-scope="{ item }">
                    <div class="name">{{ item.value }}</div>

                </template>
            </el-autocomplete>
            <br><br>


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

            <el-upload
                    class="upload-demo"
                    ref="upload"
                    action="http://localhost:8080/AdminController/load"
                    :on-preview="handlePreview"
                    :on-remove="handleRemove"
                    :file-list="ruleForm.type"
                    :data="ruleForm"
                    name="uploadFile"
                    :auto-upload="false">
                <el-button slot="trigger" size="small" type="primary">选取文件</el-button>
              <el-button style="margin-left: 10px;" size="small" type="success" @click="submitUpload">上传到服务器</el-button>
                <div slot="tip" class="el-upload__tip">只能上传jpg文件，且不超过500kb</div>
            </el-upload>

<!--            <br>-->
<!--            <el-form-item>-->
<!--                <el-button type="primary" @click="change_sure('ruleForm')">确定修改</el-button>-->



<!--                <el-button @click="change_notsure">取消</el-button>-->

<!--            </el-form-item>-->
        </el-form>
        <Boss></Boss>

    </div>

</template>
<style scoped>
    @import "../css/BossAddClothes.css";
</style>
<script>
    import Boss from "../components/Boss";

    export default {
        data(){

            return{
                restaurants: [],
                jsonbrand:{},
                state: '',
                brand_clothes:{},
                allclothes:{},
                page:1,
                lastpage:'',
                clothes:'',
                index:'',
                ruleForm: {


                    num: 100,
                    money:10000,

                    brand:'',
                    info:'',
                    type:'',
                    // id:''


                },
                rules: {
                    brand: [

                        { min: 1, max: 50, message: '长度在 1 到 50 个字符', trigger: 'blur' }
                    ],
                    info: [

                        { min: 1, max: 50, message: '长度在 1 到 50 个字符', trigger: 'blur' }
                    ],type: [
                        { required: true, message: '请选择性别', trigger: 'change' }
                    ],
                }}
        },
        components :{
            Boss
        },
        methods:{
            submitUpload(){
                this.$refs.upload.submit();
                this.$alert('', '创建成功', {
                    confirmButtonText: '确定',
                    callback: action => { this.$router.go(0)
                        this.$message({
                            type: 'info',
                            message: `Create  Success`,

                        });
                    }
                });

            },
            change_sure(){
                this.$refs[formName].validate((valid) => {
                    if (valid) {
                        //执行正确操作

                        // this.$axios.post('AdminController/load',   //URL首字母必须是大写不然会出错
                        //     this.$qs.stringify({       //传参部分 使用q
                        //         'form':this.ruleForm
                        //     })).then(response=>{      //返回值部分
                        //     console.log(response.data)
                        // }).catch(error=>{
                        //     console.log(error)
                        // })
                        //提交文件
                        this.$refs.upload.submit();

                        //弹窗
                        this.$alert('', '创建成功', {
                            confirmButtonText: '确定',
                            callback: action => {
                                this.$message({
                                    type: 'info',
                                    message: `Create  Success`
                                });
                            }
                        });

                        this.$router.go(0);


                    } else {
                        this.$notify.error({
                            title: '错误',
                            message: '请正确填写信息'
                        });
                        return false;
                    }
                });

            },
            querySearch(queryString, cb) {
                var restaurants = this.restaurants;
                var results = queryString ? restaurants.filter(this.createFilter(queryString)) : restaurants;
                // 调用 callback 返回建议列表的数据
                cb(results);
            },
            createFilter(queryString) {
                return (restaurant) => {
                    return (restaurant.value.toLowerCase().indexOf(queryString.toLowerCase()) === 0);
                };
            },

            handleSelect(item) {
                console.log(item);
            },
            handleIconClick(ev) {
                console.log(ev);
            },
            loadAll(){
                var a = new Array();
                this.$axios.post('ClothesController/select_allclothesbrand',this.$qs.stringify(

                )).then(response=>{      //返回值部分
                    a = response.data;
                    console.log(response.data)
                }).catch(error=>{
                    console.log(error)
                });



                return [
                    { "value": "A BATHING APE®"},
                    { "value": "NEIGHBORHOOD"},
                    { "value": "VALENTINO"},
                    { "value": "JUNYA WATANABE"},
                    { "value": "OAMC"},
                    { "value": "MCQ"},
                    { "value": "Y-3"},
                    { "value": "MR. GENTLEMAN"},
                    { "value": "uniform experiment"},
                    { "value": "Mihara Yasuhiro"},
                    { "value": "CHILDREN"},
                    { "value": "SJYP"},
                    { "value": "MSGM"},
                    { "value": "D'DEMOO"},
                    { "value": "Zadig & Voltaire"},
                    { "value": "IRENE IS GOOD"},
                    { "value": "Tibi"},
                    { "value": "JUNYA WATANABE WOMEN"},
                    { "value": "roarguns"},
                    { "value": "PUSHBUTTON"},
                    { "value": "BAPY®"},
                    { "value": "Stella McCartney"},



                ];
            }
        },
        mounted() {
             this.restaurants = this.loadAll();

        }


    }
</script>