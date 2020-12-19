<template>
    <div>
        <Boss></Boss>
        <div class="small">


            <canvas id="myChart2" width="400px" height="400px"></canvas>

        </div>
        <div class="small">


            <canvas id="myChart" width="400px" height="400px"></canvas>
        </div>
<!--        <li v-for="(item,index) in data" class="cart_buy_all">-->
<!--            {{item}}-->
<!--        </li>-->
    </div>
</template>
<style scoped>
    #myChart{
        position: absolute;
        top: 200px;
        left: 900px;

    }
    #myChart2{
        position: absolute;
        top: 200px;
        left: 300px;

    }
</style>
<script>
    import Chart from 'chart.js';
    import Boss from '../components/Boss'



    export default {
        data() {
            return {
                labels:["一月","二月","三月","四月","五月","六月","七月","八月","九月","十月","十一月","十二月",],
                data: [558445,265974,725468,978422,625448,1254788,1125485,854584,1545485,1154854,1124555,555445],
                data2: [458445,665974,225468,178422,1125448,954788,925485,554584,645485,354854,524555,255445],

            }
        },
        created() {

        },
        components: {
            Boss
        },

        mounted() {
            var ctx = document.getElementById("myChart");
            var myRadarChart = new Chart(ctx, {
                type: "radar",
                 data: {
                 labels: ['A BATHING APE®','NEIGHBORHOOD', 'MR. GENTLEMAN', 'D\'DEMOO', 'Zadig & Voltaire','MCQ'],
                    datasets: [{
                    data: [120, 90, 14,99,25, 12],
                        backgroundColor: "rgba(204,225,240,0.8)",
                        borderColor: "rgba(54,162,235,0.8)",
                        label: "2018",
                },{
                        label: '2019',
                        data: [24, 138, 55, 93, 82, 23],
                        backgroundColor: 'rgba(54, 162, 235, 0.2)',
                        borderColor:'red',
                        borderWidth: 2,
                        lineTension:0,
                        fill:false
                    },{
                        label: '2020',
                        data: [100, 30, 80,93, 115, 124],
                        backgroundColor: 'rgba(54, 162, 235, 0.2)',
                        borderColor:'rgba(255, 206, 86, 0.9)',
                        borderWidth: 2,
                        fill:false,
                        borderDash:[5]
                    }]
            },
                options: this.options
            });

            var ctx2 = document.getElementById("myChart2");

            var myChart2 = new Chart(ctx2, {
                type: "bar",
                data: {
                    labels:this.labels,
                    datasets: [
                        {
                            label: "I.T",
                            backgroundColor: "rgba(225,10,10,0.3)",
                            borderColor: "rgba(225,103,110,1)",
                            borderWidth: 1,
                            pointStrokeColor: "#fff",
                            pointStyle: "crossRot",
                            data:this.data,
                            cubicInterpolationMode: "monotone",
                            spanGaps: "false",
                            fill: "false"
                        },
                        {
                            label: "i.t",
                            backgroundColor: "rgba(10,225,175,0.3)",
                            borderColor: "rgb(103,129,225)",
                            borderWidth: 1,
                            pointStrokeColor: "#fff",
                            pointStyle: "crossRot",
                            data:this.data2,
                            cubicInterpolationMode: "monotone",
                            spanGaps: "false",
                            fill: "false"
                        }

                    ]
                },
                options: {

                }

            });


        },
        methods: {

        }
    }
</script>
<style>
    .small {
        width: 500px;
        height: 500px;
    }
</style>