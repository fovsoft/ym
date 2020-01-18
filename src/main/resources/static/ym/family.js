$(document).ready(function () {
    family.onload();
});

let family = (function () {

    layui.use(['table','form','element'], function () {
        let form = layui.form;
        let element = layui.element;
        let table = layui.table;

        // 首次更新标志
        let initTab1 = 0;
        let initTab2 = 0;
        let initTab3 = 0;
        let initTab4 = 0;

        $.ajax({
            url: '/query/getBase',
            data: {id: $("#baseid").val()},
            async: false,
            success: function (res) {
                let resData = res.data;
                form.val('form1', {
                    'tel': resData.lxdh,
                    'dpst_bk': resData.khyh,
                    'bk_num': resData.yhkh,
                    'family_attr': resData.pkhsx,
                    'poverty_relief_tm': resData.jhtpnd,
                    'poverty_rtn_tm': resData.fpnd,
                    'poverty_rtn_rsn': resData.fpyy,
                    'is_martyrsfamily': resData.sfjls,
                    'is_relocated': resData.sfydfpbqh,
                    'relocated_way': resData.bqfs,
                    'relocated_addr': resData.bqdz
                });
                form.render();
            }
        });

        /* ***** tab切换事件开始 **** */
        element.on('tab(addBaseInfo)', function(data){
            let fid = $("#baseid").val();
            // 家庭成员
            if(data.index == 1) {
                if(initTab1 == 0) {
                    table.reload('tableMember', {
                        where: {
                            fid: fid
                        }
                    });
                    initTab1 = 1;
                }
            }
            // 致贫原因
            if(data.index == 2) {
                if(initTab2 == 0) {
                    $.ajax({
                        url : '/query/getAddition',
                        data : {fid : fid},
                        dataType: 'JSON',
                        success : function(res) {
                            form.val('form3', {
                                'poverty_causes1' : res.data.zpyy1,
                                'poverty_causes2' : res.data.zpyy2,
                                'poverty_causes3' : res.data.zpyy3,
                                'household_num_Jan' : res.data.ncjtrks,
                                'household_num_Dec' : res.data.ndjtrks
                            });
                            form.render();
                        }
                    });
                    initTab2 = 1;
                }
            }
            // 生产生活条件
            if(data.index == 3) {
                if(initTab3 == 0) {
                    $.ajax({
                        url : '/query/getCondition',
                        data : {fid : fid},
                        dataType: 'JSON',
                        success : function(res) {
                            form.val('form4', {
                                'area_cultivated' : res.data.gdmj,
                                'area_woodland' : res.data.ldmj,  //
                                'yxggmj' : res.data.yxggmj,  //
                                'area_turninto' : res.data.tghlmj,
                                'area_fruit' : res.data.lgmj,
                                'area_foragegrass' : res.data.mcdmj,
                                'area_waters' : res.data.smmj,
                                'is_cooperative' : res.data.sfjrnmzyhzs,  // 是否加入农民专业合作社
                                'get_leaded' : res.data.sfyltqydd,  // 龙头
                                'get_pioneer' : res.data.sfycyzfdtrdd,       //是否有创业致富带头人带动
                                'sftscyd' : res.data.sftscyd,
                                'get_electric' : res.data.sftshyd,
                                'get_television' : res.data.sftgbds,
                                'yssfkn' : res.data.yssfkn,
                                'get_potablewater' : res.data.yssfaq,
                                'get_toilet' : res.data.ywwscs,
                                'distance_mainroad' : res.data.yczgljl,
                                'type_road' : res.data.rhllx,
                                'area_housing' : res.data.zfmj,
                                'is_dilapidated' : res.data.sfwfh,
                                'level_dilapidated' : res.data.wfdj,
                                'year_reform' : res.data.wgnd,
                                'type_fuel' : res.data.zyrllx,
                                'type_fuel_other' : res.data.type_fuel_other,
                            });
                            form.render();
                        }
                    });
                    initTab3 = 1;
                }
            }

            if(data.index == 4) {
                if(initTab4 == 0) {
                    $.ajax({
                        url : '/query/getHouseHold',
                        data : {fid : fid},
                        dataType: 'JSON',
                        success : function(res) { console.log(res.data);
                            form.val('form5', {
                                'ldfh' : res.data.ldfh,
                                'ndfqrw' : res.data.ndfqrw,
                                'bqlx' : res.data.bqlx,
                                'qcdsj' : res.data.qcdsj,
                                'qcdxj' : res.data.qcdxj,
                                'qcdxxdz' : res.data.qcdxxdz,
                                'qcdlx' : res.data.qcdlx,
                                'jtsyhrk' : res.data.jtsyhrk,
                                'zfmj' : res.data.zfmj,
                                'zczj' : res.data.zczj,
                                'bqrzsj' : res.data.bqrzsj,
                                'sjrzsj' : res.data.sjrzsj,
                                'sfsjrzmln' : res.data.sfsjrzmln,
                                'yyzf' : res.data.yyzf,
                                'yzfmj' : res.data.yzfmj,
                                'ccjf' : res.data.ccjf,
                                'bhzfzl' : res.data.bhzfzl,
                                'ccsj' : res.data.ccsj,
                                'ccjfmj' : res.data.ccjfmj,
                                'dxcfjl' : res.data.dxcfjl,
                                'fkfl' : res.data.fkfl,
                                'fkflmj' : res.data.fkflmj,
                                'cyfcxm' : res.data.cyfcxm,
                                'nnhdcyfczj' : res.data.nnhdcyfczj
                            });
                            form.render();
                        }
                    });
                    initTab4 = 1;
                }
            }

            // console.log(this); //当前Tab标题所在的原始DOM元素
            // console.log(data.index); //得到当前Tab的所在下标
            // console.log(data.elem); //得到当前的Tab大容器
            // console.log($("#"))
        });
        /* ***** tab切换事件结束 **** */



        /**
         * 家庭成员列表
         */
        table.render({
            elem: '#tableMember'
            , url: '/query/getMemberList'
            , toolbar: '#tableMemberToolbar' //开启头部工具栏，并为其绑定左侧模板
            // , defaultToolbar: ['filter', 'exports', 'print', { //自定义头部工具栏右侧图标。如无需自定义，去除该参数即可
            //     title: '提示'
            //     , layEvent: 'LAYTABLE_TIPS'
            //     , icon: 'layui-icon-tips'
            // }]
            , title: '家庭成员表'
            , cols: [[
                {field: 'xm', title: '姓名',minWidth:100}
                , {field: 'xb', title: '性别'}
                , {field: 'sfzmhm', title: '证件号码', minWidth:180}
                , {field: 'yhzgx', title: '与户主关系'}
                , {field: 'nl', title: '年龄'}
                , {field: 'sfsyrk', title: '是否受益人口'}
                , {field: 'mz', title: '民族'}
                , {field: 'zzmm', title: '政治面貌'}
                , {field: 'whcd', title: '文化程度'}
                , {field: 'zxsqk', title: '在校生情况'}
                , {field: 'sxhcxyy', title: '失学或辍学原因'}
                , {field: 'jkqk', title: '健康状况'}
                , {field: 'ldjn', title: '劳动技能'}
                , {field: 'sfhjpth', title: '是否会讲普通话'}
                , {field: 'sfxyjr', title: '是否现役军人'}
                , {field: 'sfcjylbx1', title: '是否参加城乡居民医疗保险'}
                , {field: 'sfcjsybx', title: '是否参加商业补充医疗保险'}
                , {field: 'sfxsdb', title: '是否享受农村居民最低生活保障'}
                , {field: 'sfcjylbx2', title: '是否参加农村居民基本养老保险'}
                , {field: 'sfxsywbxbt', title: '是否享受人身意外保险补贴'}
                , {field: 'lxdh', title: '联系电话',minWidth:130}
            ]]
            , page: false
            , done: function (res, curr, count) {
            }
        });
    });

    return {
        onload: function () {

        }
    };
})();