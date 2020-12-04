
import radio_group from "../components/radio_group";
import Gotop from "../components/Gotop";

export default {
    inject:['reload'],
    data(){

        return{
            name:this.$route.query.name,
            youcartclothes:{},
            cartallmoney:0
        }
    },
    components :{
        radio_group,
        Gotop
    },
    created() {
        //根据用户的name进行查询购物车的货物情况
        this.$axios.post('CartController/selectcartclothes',this.$qs.stringify(
            {
                name:this.name
            }
        )).then(response=>{      //返回值部分
            this.youcartclothes = response.data;
            //把拿到的每个图片的格式转换为VUE可识别正确格式
            for(let i=0;i<this.youcartclothes.length;i++){
                this.youcartclothes[i].clothes_src = require("../assets/clothes/"+this.youcartclothes[i].clothes_src);
                console.log(this.youcartclothes[i].clothes_src)
                //购物车总价格
                this.cartallmoney += this.youcartclothes[i].cart_num * this.youcartclothes[i].clothes_money;
            }
        }).catch(error=>{
            console.log(error)
        });
    },
    methods:{
        removecart(clothes_id,index){


            //每日此点击从数据库减少值
            //根据用户的name进行查询购物车的货物情况
            this.$axios.post('CartController/changecartclothes',this.$qs.stringify(
                {
                    name:this.name,
                    clothes_id:clothes_id,
                    num:-this.youcartclothes[index].cart_num
                }
            )).then(response=>{      //返回值部分

            }).catch(error=>{
                console.log(error)
            });
            //移除购物车
            this.youcartclothes.splice(index,1)
        },
        cutcartmun(clothes_id,index){


            if(this.youcartclothes[index].cart_num>0){
                //每日此点击从数据库减少值
                //根据用户的name进行查询购物车的货物情况
                this.$axios.post('CartController/changecartclothes',this.$qs.stringify(
                    {
                        name:this.name,
                        clothes_id:clothes_id,
                        num:-1
                    }
                )).then(response=>{      //返回值部分

                }).catch(error=>{
                    console.log(error)
                });

                this.youcartclothes[index].cart_num -= 1;

                this.cartallmoney -= this.youcartclothes[index].clothes_money;
            }

            if(this.youcartclothes[index].cart_num === 0){
                this.youcartclothes.splice(index,1)
            }

        },
        addcartmun(clothes_id,index){

            //每日此点击从数据库减少值
            //根据用户的name进行查询购物车的货物情况
            this.$axios.post('CartController/changecartclothes',this.$qs.stringify(
                {
                    name:this.name,
                    clothes_id:clothes_id,
                    num:1
                }
            )).then(response=>{      //返回值部分

            }).catch(error=>{
                console.log(error)
            });
            this.youcartclothes[index].cart_num += 1;
            this.cartallmoney += this.youcartclothes[index].clothes_money;

        },
        paymoney(){

            //向后台发送用户名，清空该用户的购物车信息
            this.$axios.post('CartController/paycartclothes',this.$qs.stringify(
                {
                    name:this.name,

                }
            )).then(response=>{      //返回值部分

            }).catch(error=>{
                console.log(error)
            });


            this.$alert('恭喜您消费CNY:'+this.cartallmoney+'元，欢迎下次光临I.T旗舰店', '购买成功', {
                confirmButtonText: '确定',

            });
            //跳转到主界面
            this.$router.push({
                path:'/Index',
                query:{
                    name:this.name
                }
            })



        }
    }
}
