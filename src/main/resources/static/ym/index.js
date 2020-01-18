$(document).ready(function () {
    index.onload();
});

let index = (function () {

    layui.use('table', function () {
        var table = layui.table;
        queryData();


        //工具栏事件
        table.on('toolbar(userList)', function (obj) {
            let checkStatus = table.checkStatus(obj.config.id);
            switch (obj.event) {
                case 'query':
                    queryData();
                    break;
            }
        });

        //监听工具条
        table.on('tool(userList)', function (obj) {
            var data = obj.data;
            if (obj.event === 'detail') {
                layer.open({
                    title: '查看家庭信息',
                    type: 2,
                    // skin: 'layui-layer-rim', //加上边框
                    area: ['70%', '60%'], //宽高
                    content: '/query/family?jtbh=' + data.jtbh,
                });
            }
        });

        // 表格数据加载函数
        function queryData() {
            let condition = {'sfzhm' : $("#sfzhm").val(), 'xm' : $("#xm").val()};
            table.render({
                elem: '#familyListTable',
                url: '/query/getList',
                contentType: 'application/json; charset=UTF-8',
                where: condition,
                page: true,
                toolbar: '#toolbarDemo',
                limits: [10, 15, 20, 25],
                method : 'POST',
                limit: 10,
                even: true,
                title: '贫困户家庭基本情况',
                cols: [[
                    {type: 'checkbox'}
                    // , {field: 'jtbh', title: 'ID', width: 80, unresize: true, sort: true}
                    , {field: 'xm', title: '户主姓名', width: 120}
                    , {field: 'sfzmhm', title: '身份证号'}
                    , {field: 'xxxzqhmz', title: '详细行政区划名字'}
                    , {field: 'lxdh', title: '联系电话'}
                    , {field: 'pkhsx', title: '贫困户属性'}
                    , {field: 'jhtpnd', title: '计划脱贫年度'}
                    , {field: 'sfydfpbqh', title: '是否异地扶贫搬迁户',}
                    , {field: 'bqfs', title: '搬迁方式'}
                    , {title: '操作', toolbar: '#barDemo', fixed: 'right', width: 160}
                ]],
                done: function (res, curr, count) {
                    // $(".layui-table-box").find("[data-field='jtbh']").css("display", "none");



                    $("[data-field='pkhsx']").children().each(function () {
                        if ($(this).text() == 1) {
                            $(this).text("一般贫困户")
                        } else if ($(this).text() == 2) {
                            $(this).text("低保贫困户")
                        } else if ($(this).text() == 3) {
                            $(this).text("特困供养贫困户");
                        }
                    });
                    $("[data-field='sfydbqh']").children().each(function () {
                        if ($(this).text() == 1) {
                            $(this).text("是")
                        } else if ($(this).text() == 0) {
                            $(this).text("否")
                        }
                    });
                },
                skin: 'row'
            });
        }

    });

    return {
        onload: function () {

        }
    };
})();