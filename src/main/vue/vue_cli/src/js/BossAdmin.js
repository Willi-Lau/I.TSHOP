
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
            this.$axios.post('AdminController/alladmininf',this.$qs.stringify(
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
            this.$axios.post('AdminController/alladmininf',this.$qs.stringify(
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
            this.$axios.post('AdminController/alladmininf',this.$qs.stringify(
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
            this.$axios.post('AdminController/alladmininf',this.$qs.stringify(
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
        this.$axios.post('AdminController/alladmininf',this.$qs.stringify(
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
        this.$axios.post('AdminController/countadmin',this.$qs.stringify(
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
