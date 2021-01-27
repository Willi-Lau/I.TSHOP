<template>
    <div class="form_register">

        <el-form :model="ruleForm" :rules="rules" ref="ruleForm" label-width="100px" class="demo-ruleForm">
            <el-form-item label="注册账号" prop="username">
                <el-input v-model="ruleForm.username"></el-input>
            </el-form-item>
            <el-form-item label="密码" prop="password">
                <el-input type="password" v-model="ruleForm.password" ></el-input>
            </el-form-item>
            <el-form-item label="确认密码" prop="sure_password">
                <el-input type="password" v-model="ruleForm.sure_password" ></el-input>
            </el-form-item>
            <el-form-item label="真实姓名" prop="name">
                <el-input v-model="ruleForm.name"></el-input>
            </el-form-item>
            <el-form-item label="出生日期" required>
                <el-col :span="11">
                    <el-form-item prop="birthday">
                        <el-date-picker type="date" placeholder="选择日期" v-model="ruleForm.birthday" style="width: 100%;"></el-date-picker>
                    </el-form-item>
                </el-col>
            </el-form-item>
            <el-form-item label="性别" prop="sex">
                <el-radio-group v-model="ruleForm.sex" class="sex">
                    <el-radio label="男"></el-radio>
                    <el-radio label="女"></el-radio>
                </el-radio-group>
            </el-form-item>
            <el-form-item label="电话号码" prop="phone">
                <el-input v-model="ruleForm.phone"></el-input>
            </el-form-item>
            <el-form-item label="所在城市" prop="address" >
                <el-select v-model="ruleForm.address" placeholder="请选择活动区域" class="address">
                    <el-option label="沈阳" value="沈阳"></el-option>
                    <el-option label="大连" value="大连"></el-option>
                    <el-option label="鞍山" value="鞍山"></el-option>
                    <el-option label="锦州" value="锦州"></el-option>
                    <el-option label="盘锦" value="盘锦"></el-option>
                    <el-option label="葫芦岛" value="葫芦岛"></el-option>
                    <el-option label="丹东" value="丹东"></el-option>
                    <el-option label="阜新" value="阜新"></el-option>
                    <el-option label="朝阳" value="朝阳"></el-option>
                    <el-option label="抚顺" value="抚顺"></el-option>
                </el-select>
            </el-form-item>
            <el-form-item label="电子邮箱" prop="email">
                <el-input v-model="ruleForm.email"></el-input>
            </el-form-item>

            <el-form-item>
                <el-button type="primary" @click="submitForm('ruleForm')">立即创建</el-button>
                <el-button @click="resetForm('ruleForm')">重置</el-button>
                <el-button @click="returnoff()">返回</el-button>
            </el-form-item>
        </el-form>
    </div>
</template>

<script>

    export default {
        name:'Register',
        data() {

            {
                var validatePass = (rule, value, callback) => {
            if (value === '') {
                callback(new Error('请输入密码'));
            } else {
                if (this.ruleForm.sure_password !== '') {
                    this.$refs.ruleForm.validateField('sure_password');
                }
                callback();
            }
            };

            var validatePass2 = (rule, value, callback) => {
                if (value === '') {
                    callback(new Error('请再次输入密码'));
                } else if (value !== this.ruleForm.password) {
                    callback(new Error('两次输入密码不一致!'));
                } else {
                    callback();
                }
            };


            var checkphone = function (phone) {
                var pattern =  /^([1]\d{10}|([\(（]?0[0-9]{2,3}[）\)]?[-]?)?([2-9][0-9]{6,7})+(\-[0-9]{1,4})?)$/;   //验证手机号
                if (!pattern.test(phone)) {
                        return false;
                    }
                    else {
                        return true;
                    }
                }
            //验证手机
            var validatePhone =(rule, value, callback)=>{
                if (value === '') {
                    callback(new Error('请输入电话号码'));
                }
                else if(checkphone(value) === false){
                    callback(new Error('电话号码格式错误!'));
                }
                else{
                    callback();
                }
            };
                var checkemail = function(email) {
                    var pattern =   /^([A-Za-z0-9_\-\.])+\@([A-Za-z0-9_\-\.])+\.([A-Za-z]{2,4})$/;   //验证邮箱
                    if (!pattern.test(email)) {
                        return false;
                    }
                    else {
                        return true;
                    }
                }

            var validateEmail =(rule, value, callback)=>{
                    if (value === '') {
                        callback(new Error('请输入邮箱地址'));
                    }
                    else if(checkemail(value) === false){
                        callback(new Error('邮箱格式错误!'));
                    }
                    else{
                        callback();
                    }
                };
        }

            return {
                ruleForm: {
                    username:'',
                    password:'',
                    sure_password:'',
                    name:'',
                    birthday:'',
                    sex:'',
                    phone:'',
                    address:'',
                    email:''
                },
                inf:'',

                rules: {
                    username: [
                        { required: true, message: '请输入注册账号', trigger: 'blur' },
                        { min: 5, max: 15, message: '长度在 5 到 15 个字符', trigger: 'blur' }
                    ],
                    password: [
                        { validator: validatePass, trigger: 'blur' }
                    ],
                    sure_password: [
                        { validator: validatePass2, trigger: 'blur' }
                    ],
                    name: [
                        { required: true, message: '请输入姓名', trigger: 'blur' },
                        { min: 2, max: 4, message: '长度在 2 到 4 个汉字', trigger: 'blur' }
                    ],
                    date1: [
                        { type: 'date', required: true, message: '请选择出生日期', trigger: 'change' }
                    ],
                    sex: [
                        { required: true, message: '请选择性别', trigger: 'change' }
                    ],
                    phone: [
                        { validator: validatePhone, trigger: 'blur' }
                    ],
                    address: [
                        { required: true, message: '请选择所在城市', trigger: 'blur' }
                    ],
                    email: [
                        { validator: validateEmail, trigger: 'blur' }
                    ],

                }
            };
        },
        methods: {
            submitForm(formName) {
                this.$refs[formName].validate((valid) => {
                    if (valid) {
                        //执行正确操作

                        this.$axios.post('UserController/adduserinformation',   //URL首字母必须是大写不然会出错
                            // this.$qs.stringify({       //传参部分 使用q
                                // 'form':this.ruleForm
                                this.ruleForm
                            // }
                    // )
                    ).then(response=>{      //返回值部分
                            console.log(response.data)
                        }).catch(error=>{
                            console.log(error)
                        })

                        //弹窗
                        this.$alert('', '创建成功', {
                            confirmButtonText: '确定',
                            callback: action => {
                                this.$message({
                                    type: 'info',
                                    message: `Create User Success`
                                });
                            }
                        });

                        this.$router.push({path:'/'});


                    } else {
                        this.$notify.error({
                            title: '错误',
                            message: '请正确填写信息'
                        });
                        return false;
                    }
                });
            },
            resetForm(formName) {
                this.$refs[formName].resetFields();
            },
            returnoff(){
                this.$router.go(-1);
            }
        }
    }
</script>


<style scoped>
@import '../css/Register.css';
</style>

