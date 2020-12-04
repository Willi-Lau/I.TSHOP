

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
                        this.$qs.stringify({       //传参部分 使用q
                            'form':this.ruleForm
                        })).then(response=>{      //返回值部分
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
