
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
                id:''


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
