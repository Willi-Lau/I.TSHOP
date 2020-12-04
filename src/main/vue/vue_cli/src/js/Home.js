
// @ is an alias to /src
import HelloWorld from '@/components/HelloWorld.vue'

export default {
    name: 'Home',
    data() {
        return {
            // vaild:'false',
            form: {
                name: '',
                password: ''
            },
            form_suer:false,
            rules: {
                name: [
                    { required: true, message: '请填写账号', trigger: 'blur' },
                    { min: 5, max: 15, message: '长度在 5 到 15 个字符', trigger: 'blur' }
                ],
                password: [
                    { min: 1, max: 100, message: '', trigger: 'blur' },
                    { required: true, message: '请填写密码', trigger: 'blur' },
                ]

            }

        }

    },
    methods: {
        onSubmit() {

            if(this.form.name != '' && this.form.password != ''){
                this.$axios.post(
                    'UserController/checkupdate',
                    this.$qs.stringify(
                        {'form':this.form}
                    )
                ).then(reponse=>{
                    if(reponse.data === "yes"){
                        this.$notify({
                            title: '成功',
                            message: '登陆成功',
                            type: 'success'
                        });
                        this.$router.push({path:"/Index",
                            query:{
                                name:this.form.name
                            }}

                        );

                    }
                    else {
                        // this.$alert('请重新填写', '账号或密码错误', {
                        //   confirmButtonText: '确定',
                        //
                        // });
                        this.$notify.error({
                            title: '错误',
                            message: '账号或密码错误，请重新填写'
                        });
                        this.$alert('请重新登录', '登陆失败', {
                            confirmButtonText: '确定',
                            type:"error"
                        });


                    }
                }).catch(error=>{

                })
            }
            else {
                // this.$alert('请重新填写', '不能输入空的账号密码', {
                //   confirmButtonText: '确定',
                //
                // });
                this.$notify({
                    title: '警告',
                    message: '不要提交空值',
                    type: 'warning'
                });
            }


        },
        onRegister(){
            this.$router.push({path:'/Register'});

        }
    },
    components: {
        HelloWorld
    }
}
