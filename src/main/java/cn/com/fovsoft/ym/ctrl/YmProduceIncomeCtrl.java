package cn.com.fovsoft.ym.ctrl;/*
 * Author:tpc
 * Date:2019-11-25 16:17:52
 * 功能描述:生产收入和支出控制类
 * version:
 */


import cn.com.fovsoft.ym.bean.YmProduceIncome;
import cn.com.fovsoft.ym.service.YmProduceIncomeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
public class YmProduceIncomeCtrl {


    @Autowired
    private YmProduceIncomeService ymProduceIncomeService;


    @RequestMapping("/produceIncome/add")
    @ResponseBody
    public Map<String,Object> addYmProduceIncome(HttpServletRequest request){


        //获取家庭编号信息
        String jtbh = request.getParameter("jtbh");
        List<YmProduceIncome> ymProduceIncomeList = new ArrayList();

        String produce_yf1_1      = request.getParameter("produce_yf1_1");
        String produce_yf2_1      = request.getParameter("produce_yf2_1");
        String produce_yf3_1      = request.getParameter("produce_yf3_1");
        String produce_yf4_1      = request.getParameter("produce_yf4_1");
        String produce_yf5_1      = request.getParameter("produce_yf5_1");
        String produce_yf6_1      = request.getParameter("produce_yf6_1");
        String produce_yf7_1      = request.getParameter("produce_yf7_1");
        String produce_yf8_1      = request.getParameter("produce_yf8_1");
        String produce_yf9_1      = request.getParameter("produce_yf9_1");
        String produce_yf10_1     = request.getParameter("produce_yf10_1");
        String produce_yf11_1     = request.getParameter("produce_yf11_1");
        String produce_yf12_1     = request.getParameter("produce_yf12_1");
        YmProduceIncome ymProduceIncome = new YmProduceIncome();
        ymProduceIncome.setJtbh(jtbh);
        ymProduceIncome.setProduce_xtdl("01");
        ymProduceIncome.setProduce_xtxl1("01");
        ymProduceIncome.setProduce_xtxl2("01");
        ymProduceIncome.setProduce_nf("2019");
        ymProduceIncome.setProduce_yf1(produce_yf1_1);
        ymProduceIncome.setProduce_yf2(produce_yf2_1);
        ymProduceIncome.setProduce_yf3(produce_yf3_1);
        ymProduceIncome.setProduce_yf4(produce_yf4_1);
        ymProduceIncome.setProduce_yf5(produce_yf5_1);
        ymProduceIncome.setProduce_yf6(produce_yf6_1);
        ymProduceIncome.setProduce_yf7(produce_yf7_1);
        ymProduceIncome.setProduce_yf8(produce_yf8_1);
        ymProduceIncome.setProduce_yf9(produce_yf9_1);
        ymProduceIncome.setProduce_yf10(produce_yf10_1);
        ymProduceIncome.setProduce_yf11(produce_yf11_1);
        ymProduceIncome.setProduce_yf12(produce_yf12_1);
        ymProduceIncomeList.add(ymProduceIncome);

        String produce_yf1_2      = request.getParameter("produce_yf1_2");
        String produce_yf2_2      = request.getParameter("produce_yf2_2");
        String produce_yf3_2      = request.getParameter("produce_yf3_2");
        String produce_yf4_2      = request.getParameter("produce_yf4_2");
        String produce_yf5_2      = request.getParameter("produce_yf5_2");
        String produce_yf6_2      = request.getParameter("produce_yf6_2");
        String produce_yf7_2      = request.getParameter("produce_yf7_2");
        String produce_yf8_2      = request.getParameter("produce_yf8_2");
        String produce_yf9_2      = request.getParameter("produce_yf9_2");
        String produce_yf10_2     = request.getParameter("produce_yf10_2");
        String produce_yf11_2     = request.getParameter("produce_yf11_2");
        String produce_yf12_2     = request.getParameter("produce_yf12_2");
        //种植业数量
        ymProduceIncome = new YmProduceIncome();
        ymProduceIncome.setJtbh(jtbh);
        ymProduceIncome.setProduce_xtdl("01");
        ymProduceIncome.setProduce_xtxl1("01");
        ymProduceIncome.setProduce_xtxl2("02");
        ymProduceIncome.setProduce_nf("2019");
        ymProduceIncome.setProduce_yf1(produce_yf1_2);
        ymProduceIncome.setProduce_yf2(produce_yf2_2);
        ymProduceIncome.setProduce_yf3(produce_yf3_2);
        ymProduceIncome.setProduce_yf4(produce_yf4_2);
        ymProduceIncome.setProduce_yf5(produce_yf5_2);
        ymProduceIncome.setProduce_yf6(produce_yf6_2);
        ymProduceIncome.setProduce_yf7(produce_yf7_2);
        ymProduceIncome.setProduce_yf8(produce_yf8_2);
        ymProduceIncome.setProduce_yf9(produce_yf9_2);
        ymProduceIncome.setProduce_yf10(produce_yf10_2);
        ymProduceIncome.setProduce_yf11(produce_yf11_2);
        ymProduceIncome.setProduce_yf12(produce_yf12_2);
        ymProduceIncomeList.add(ymProduceIncome);


        String produce_yf1_3      = request.getParameter("produce_yf1_3");
        String produce_yf2_3      = request.getParameter("produce_yf2_3");
        String produce_yf3_3      = request.getParameter("produce_yf3_3");
        String produce_yf4_3      = request.getParameter("produce_yf4_3");
        String produce_yf5_3      = request.getParameter("produce_yf5_3");
        String produce_yf6_3      = request.getParameter("produce_yf6_3");
        String produce_yf7_3      = request.getParameter("produce_yf7_3");
        String produce_yf8_3      = request.getParameter("produce_yf8_3");
        String produce_yf9_3      = request.getParameter("produce_yf9_3");
        String produce_yf10_3     = request.getParameter("produce_yf10_3");
        String produce_yf11_3     = request.getParameter("produce_yf11_3");
        String produce_yf12_3     = request.getParameter("produce_yf12_3");
        //种植业金额
        ymProduceIncome = new YmProduceIncome();
        ymProduceIncome.setJtbh(jtbh);
        ymProduceIncome.setProduce_xtdl("01");
        ymProduceIncome.setProduce_xtxl1("01");
        ymProduceIncome.setProduce_xtxl2("03");
        ymProduceIncome.setProduce_nf("2019");
        ymProduceIncome.setProduce_yf1(produce_yf1_3);
        ymProduceIncome.setProduce_yf2(produce_yf2_3);
        ymProduceIncome.setProduce_yf3(produce_yf3_3);
        ymProduceIncome.setProduce_yf4(produce_yf4_3);
        ymProduceIncome.setProduce_yf5(produce_yf5_3);
        ymProduceIncome.setProduce_yf6(produce_yf6_3);
        ymProduceIncome.setProduce_yf7(produce_yf7_3);
        ymProduceIncome.setProduce_yf8(produce_yf8_3);
        ymProduceIncome.setProduce_yf9(produce_yf9_3);
        ymProduceIncome.setProduce_yf10(produce_yf10_3);
        ymProduceIncome.setProduce_yf11(produce_yf11_3);
        ymProduceIncome.setProduce_yf12(produce_yf12_3);
        ymProduceIncomeList.add(ymProduceIncome);

        String produce_yf1_4      = request.getParameter("produce_yf1_4");
        String produce_yf2_4      = request.getParameter("produce_yf2_4");
        String produce_yf3_4      = request.getParameter("produce_yf3_4");
        String produce_yf4_4      = request.getParameter("produce_yf4_4");
        String produce_yf5_4      = request.getParameter("produce_yf5_4");
        String produce_yf6_4      = request.getParameter("produce_yf6_4");
        String produce_yf7_4      = request.getParameter("produce_yf7_4");
        String produce_yf8_4      = request.getParameter("produce_yf8_4");
        String produce_yf9_4      = request.getParameter("produce_yf9_4");
        String produce_yf10_4     = request.getParameter("produce_yf10_4");
        String produce_yf11_4     = request.getParameter("produce_yf11_4");
        String produce_yf12_4     = request.getParameter("produce_yf12_4");
        //种植业金额
        ymProduceIncome = new YmProduceIncome();
        ymProduceIncome.setJtbh(jtbh);
        ymProduceIncome.setProduce_xtdl("01");
        ymProduceIncome.setProduce_xtxl1("02");
        ymProduceIncome.setProduce_xtxl2("01");
        ymProduceIncome.setProduce_nf("2019");
        ymProduceIncome.setProduce_yf1(produce_yf1_4);
        ymProduceIncome.setProduce_yf2(produce_yf2_4);
        ymProduceIncome.setProduce_yf3(produce_yf3_4);
        ymProduceIncome.setProduce_yf4(produce_yf4_4);
        ymProduceIncome.setProduce_yf5(produce_yf5_4);
        ymProduceIncome.setProduce_yf6(produce_yf6_4);
        ymProduceIncome.setProduce_yf7(produce_yf7_4);
        ymProduceIncome.setProduce_yf8(produce_yf8_4);
        ymProduceIncome.setProduce_yf9(produce_yf9_4);
        ymProduceIncome.setProduce_yf10(produce_yf10_4);
        ymProduceIncome.setProduce_yf11(produce_yf11_4);
        ymProduceIncome.setProduce_yf12(produce_yf12_4);
        ymProduceIncomeList.add(ymProduceIncome);

        String produce_yf1_5      = request.getParameter("produce_yf1_5");
        String produce_yf2_5      = request.getParameter("produce_yf2_5");
        String produce_yf3_5      = request.getParameter("produce_yf3_5");
        String produce_yf4_5      = request.getParameter("produce_yf4_5");
        String produce_yf5_5      = request.getParameter("produce_yf5_5");
        String produce_yf6_5      = request.getParameter("produce_yf6_5");
        String produce_yf7_5      = request.getParameter("produce_yf7_5");
        String produce_yf8_5      = request.getParameter("produce_yf8_5");
        String produce_yf9_5      = request.getParameter("produce_yf9_5");
        String produce_yf10_5     = request.getParameter("produce_yf10_5");
        String produce_yf11_5     = request.getParameter("produce_yf11_5");
        String produce_yf12_5     = request.getParameter("produce_yf12_5");
        //种植业金额
        ymProduceIncome = new YmProduceIncome();
        ymProduceIncome.setJtbh(jtbh);
        ymProduceIncome.setProduce_xtdl("01");
        ymProduceIncome.setProduce_xtxl1("02");
        ymProduceIncome.setProduce_xtxl2("02");
        ymProduceIncome.setProduce_nf("2019");
        ymProduceIncome.setProduce_yf1(produce_yf1_5);
        ymProduceIncome.setProduce_yf2(produce_yf2_5);
        ymProduceIncome.setProduce_yf3(produce_yf3_5);
        ymProduceIncome.setProduce_yf4(produce_yf4_5);
        ymProduceIncome.setProduce_yf5(produce_yf5_5);
        ymProduceIncome.setProduce_yf6(produce_yf6_5);
        ymProduceIncome.setProduce_yf7(produce_yf7_5);
        ymProduceIncome.setProduce_yf8(produce_yf8_5);
        ymProduceIncome.setProduce_yf9(produce_yf9_5);
        ymProduceIncome.setProduce_yf10(produce_yf10_5);
        ymProduceIncome.setProduce_yf11(produce_yf11_5);
        ymProduceIncome.setProduce_yf12(produce_yf12_5);
        ymProduceIncomeList.add(ymProduceIncome);

        String produce_yf1_6      = request.getParameter("produce_yf1_6");
        String produce_yf2_6      = request.getParameter("produce_yf2_6");
        String produce_yf3_6      = request.getParameter("produce_yf3_6");
        String produce_yf4_6      = request.getParameter("produce_yf4_6");
        String produce_yf5_6      = request.getParameter("produce_yf5_6");
        String produce_yf6_6      = request.getParameter("produce_yf6_6");
        String produce_yf7_6      = request.getParameter("produce_yf7_6");
        String produce_yf8_6      = request.getParameter("produce_yf8_6");
        String produce_yf9_6      = request.getParameter("produce_yf9_6");
        String produce_yf10_6     = request.getParameter("produce_yf10_6");
        String produce_yf11_6     = request.getParameter("produce_yf11_6");
        String produce_yf12_6     = request.getParameter("produce_yf12_6");
        //种植业金额
        ymProduceIncome = new YmProduceIncome();
        ymProduceIncome.setJtbh(jtbh);
        ymProduceIncome.setProduce_xtdl("01");
        ymProduceIncome.setProduce_xtxl1("02");
        ymProduceIncome.setProduce_xtxl2("03");
        ymProduceIncome.setProduce_nf("2019");
        ymProduceIncome.setProduce_yf1(produce_yf1_6);
        ymProduceIncome.setProduce_yf2(produce_yf2_6);
        ymProduceIncome.setProduce_yf3(produce_yf3_6);
        ymProduceIncome.setProduce_yf4(produce_yf4_6);
        ymProduceIncome.setProduce_yf5(produce_yf5_6);
        ymProduceIncome.setProduce_yf6(produce_yf6_6);
        ymProduceIncome.setProduce_yf7(produce_yf7_6);
        ymProduceIncome.setProduce_yf8(produce_yf8_6);
        ymProduceIncome.setProduce_yf9(produce_yf9_6);
        ymProduceIncome.setProduce_yf10(produce_yf10_6);
        ymProduceIncome.setProduce_yf11(produce_yf11_6);
        ymProduceIncome.setProduce_yf12(produce_yf12_6);
        ymProduceIncomeList.add(ymProduceIncome);

        String produce_yf1_7      = request.getParameter("produce_yf1_7");
        String produce_yf2_7      = request.getParameter("produce_yf2_7");
        String produce_yf3_7      = request.getParameter("produce_yf3_7");
        String produce_yf4_7      = request.getParameter("produce_yf4_7");
        String produce_yf5_7      = request.getParameter("produce_yf5_7");
        String produce_yf6_7      = request.getParameter("produce_yf6_7");
        String produce_yf7_7      = request.getParameter("produce_yf7_7");
        String produce_yf8_7      = request.getParameter("produce_yf8_7");
        String produce_yf9_7      = request.getParameter("produce_yf9_7");
        String produce_yf10_7     = request.getParameter("produce_yf10_7");
        String produce_yf11_7     = request.getParameter("produce_yf11_7");
        String produce_yf12_7     = request.getParameter("produce_yf12_7");
        //种植业金额
        ymProduceIncome = new YmProduceIncome();
        ymProduceIncome.setJtbh(jtbh);
        ymProduceIncome.setProduce_xtdl("01");
        ymProduceIncome.setProduce_xtxl1("03");
        ymProduceIncome.setProduce_xtxl2("01");
        ymProduceIncome.setProduce_nf("2019");
        ymProduceIncome.setProduce_yf1(produce_yf1_7);
        ymProduceIncome.setProduce_yf2(produce_yf2_7);
        ymProduceIncome.setProduce_yf3(produce_yf3_7);
        ymProduceIncome.setProduce_yf4(produce_yf4_7);
        ymProduceIncome.setProduce_yf5(produce_yf5_7);
        ymProduceIncome.setProduce_yf6(produce_yf6_7);
        ymProduceIncome.setProduce_yf7(produce_yf7_7);
        ymProduceIncome.setProduce_yf8(produce_yf8_7);
        ymProduceIncome.setProduce_yf9(produce_yf9_7);
        ymProduceIncome.setProduce_yf10(produce_yf10_7);
        ymProduceIncome.setProduce_yf11(produce_yf11_7);
        ymProduceIncome.setProduce_yf12(produce_yf12_7);
        ymProduceIncomeList.add(ymProduceIncome);

        String produce_yf1_8      = request.getParameter("produce_yf1_8");
        String produce_yf2_8      = request.getParameter("produce_yf2_8");
        String produce_yf3_8      = request.getParameter("produce_yf3_8");
        String produce_yf4_8      = request.getParameter("produce_yf4_8");
        String produce_yf5_8      = request.getParameter("produce_yf5_8");
        String produce_yf6_8      = request.getParameter("produce_yf6_8");
        String produce_yf7_8      = request.getParameter("produce_yf7_8");
        String produce_yf8_8      = request.getParameter("produce_yf8_8");
        String produce_yf9_8      = request.getParameter("produce_yf9_8");
        String produce_yf10_8     = request.getParameter("produce_yf10_8");
        String produce_yf11_8     = request.getParameter("produce_yf11_8");
        String produce_yf12_8     = request.getParameter("produce_yf12_8");
        //种植业金额
        ymProduceIncome = new YmProduceIncome();
        ymProduceIncome.setJtbh(jtbh);
        ymProduceIncome.setProduce_xtdl("01");
        ymProduceIncome.setProduce_xtxl1("03");
        ymProduceIncome.setProduce_xtxl2("02");
        ymProduceIncome.setProduce_nf("2019");
        ymProduceIncome.setProduce_yf1(produce_yf1_8);
        ymProduceIncome.setProduce_yf2(produce_yf2_8);
        ymProduceIncome.setProduce_yf3(produce_yf3_8);
        ymProduceIncome.setProduce_yf4(produce_yf4_8);
        ymProduceIncome.setProduce_yf5(produce_yf5_8);
        ymProduceIncome.setProduce_yf6(produce_yf6_8);
        ymProduceIncome.setProduce_yf7(produce_yf7_8);
        ymProduceIncome.setProduce_yf8(produce_yf8_8);
        ymProduceIncome.setProduce_yf9(produce_yf9_8);
        ymProduceIncome.setProduce_yf10(produce_yf10_8);
        ymProduceIncome.setProduce_yf11(produce_yf11_8);
        ymProduceIncome.setProduce_yf12(produce_yf12_8);
        ymProduceIncomeList.add(ymProduceIncome);

        String produce_yf1_9      = request.getParameter("produce_yf1_9");
        String produce_yf2_9      = request.getParameter("produce_yf2_9");
        String produce_yf3_9      = request.getParameter("produce_yf3_9");
        String produce_yf4_9      = request.getParameter("produce_yf4_9");
        String produce_yf5_9      = request.getParameter("produce_yf5_9");
        String produce_yf6_9      = request.getParameter("produce_yf6_9");
        String produce_yf7_9      = request.getParameter("produce_yf7_9");
        String produce_yf8_9      = request.getParameter("produce_yf8_9");
        String produce_yf9_9      = request.getParameter("produce_yf9_9");
        String produce_yf10_9     = request.getParameter("produce_yf10_9");
        String produce_yf11_9     = request.getParameter("produce_yf11_9");
        String produce_yf12_9     = request.getParameter("produce_yf12_9");
        //种植业金额
        ymProduceIncome = new YmProduceIncome();
        ymProduceIncome.setJtbh(jtbh);
        ymProduceIncome.setProduce_xtdl("01");
        ymProduceIncome.setProduce_xtxl1("03");
        ymProduceIncome.setProduce_xtxl2("03");
        ymProduceIncome.setProduce_nf("2019");
        ymProduceIncome.setProduce_yf1(produce_yf1_9);
        ymProduceIncome.setProduce_yf2(produce_yf2_9);
        ymProduceIncome.setProduce_yf3(produce_yf3_9);
        ymProduceIncome.setProduce_yf4(produce_yf4_9);
        ymProduceIncome.setProduce_yf5(produce_yf5_9);
        ymProduceIncome.setProduce_yf6(produce_yf6_9);
        ymProduceIncome.setProduce_yf7(produce_yf7_9);
        ymProduceIncome.setProduce_yf8(produce_yf8_9);
        ymProduceIncome.setProduce_yf9(produce_yf9_9);
        ymProduceIncome.setProduce_yf10(produce_yf10_9);
        ymProduceIncome.setProduce_yf11(produce_yf11_9);
        ymProduceIncome.setProduce_yf12(produce_yf12_9);
        ymProduceIncomeList.add(ymProduceIncome);

        String produce_yf1_10     = request.getParameter("produce_yf1_10");
        String produce_yf2_10     = request.getParameter("produce_yf2_10");
        String produce_yf3_10     = request.getParameter("produce_yf3_10");
        String produce_yf4_10     = request.getParameter("produce_yf4_10");
        String produce_yf5_10     = request.getParameter("produce_yf5_10");
        String produce_yf6_10     = request.getParameter("produce_yf6_10");
        String produce_yf7_10     = request.getParameter("produce_yf7_10");
        String produce_yf8_10     = request.getParameter("produce_yf8_10");
        String produce_yf9_10     = request.getParameter("produce_yf9_10");
        String produce_yf10_10    = request.getParameter("produce_yf10_10");
        String produce_yf11_10    = request.getParameter("produce_yf11_10");
        String produce_yf12_10    = request.getParameter("produce_yf12_10");
        //种植业金额
        ymProduceIncome = new YmProduceIncome();
        ymProduceIncome.setJtbh(jtbh);
        ymProduceIncome.setProduce_xtdl("01");
        ymProduceIncome.setProduce_xtxl1("04");
        ymProduceIncome.setProduce_xtxl2("03");
        ymProduceIncome.setProduce_nf("2019");
        ymProduceIncome.setProduce_yf1(produce_yf1_10);
        ymProduceIncome.setProduce_yf2(produce_yf2_10);
        ymProduceIncome.setProduce_yf3(produce_yf3_10);
        ymProduceIncome.setProduce_yf4(produce_yf4_10);
        ymProduceIncome.setProduce_yf5(produce_yf5_10);
        ymProduceIncome.setProduce_yf6(produce_yf6_10);
        ymProduceIncome.setProduce_yf7(produce_yf7_10);
        ymProduceIncome.setProduce_yf8(produce_yf8_10);
        ymProduceIncome.setProduce_yf9(produce_yf9_10);
        ymProduceIncome.setProduce_yf10(produce_yf10_10);
        ymProduceIncome.setProduce_yf11(produce_yf11_10);
        ymProduceIncome.setProduce_yf12(produce_yf12_10);
        ymProduceIncomeList.add(ymProduceIncome);

        String produce_yf1_11     = request.getParameter("produce_yf1_11");
        String produce_yf2_11     = request.getParameter("produce_yf2_11");
        String produce_yf3_11     = request.getParameter("produce_yf3_11");
        String produce_yf4_11     = request.getParameter("produce_yf4_11");
        String produce_yf5_11     = request.getParameter("produce_yf5_11");
        String produce_yf6_11     = request.getParameter("produce_yf6_11");
        String produce_yf7_11     = request.getParameter("produce_yf7_11");
        String produce_yf8_11     = request.getParameter("produce_yf8_11");
        String produce_yf9_11     = request.getParameter("produce_yf9_11");
        String produce_yf10_11    = request.getParameter("produce_yf10_11");
        String produce_yf11_11    = request.getParameter("produce_yf11_11");
        String produce_yf12_11    = request.getParameter("produce_yf12_11");


        String produce_yf1_21     = request.getParameter("produce_yf1_21");
        String produce_yf2_21     = request.getParameter("produce_yf2_21");
        String produce_yf3_21     = request.getParameter("produce_yf3_21");
        String produce_yf4_21     = request.getParameter("produce_yf4_21");
        String produce_yf5_21     = request.getParameter("produce_yf5_21");
        String produce_yf6_21     = request.getParameter("produce_yf6_21");
        String produce_yf7_21     = request.getParameter("produce_yf7_21");
        String produce_yf8_21     = request.getParameter("produce_yf8_21");
        String produce_yf9_21     = request.getParameter("produce_yf9_21");
        String produce_yf10_21    = request.getParameter("produce_yf10_21");
        String produce_yf11_21    = request.getParameter("produce_yf11_21");
        String produce_yf12_21    = request.getParameter("produce_yf12_21");
        //种植业金额
        ymProduceIncome = new YmProduceIncome();
        ymProduceIncome.setJtbh(jtbh);
        ymProduceIncome.setProduce_xtdl("02");
        ymProduceIncome.setProduce_xtxl1("01");
        ymProduceIncome.setProduce_xtxl2("01");
        ymProduceIncome.setProduce_nf("2019");
        ymProduceIncome.setProduce_yf1(produce_yf1_21);
        ymProduceIncome.setProduce_yf2(produce_yf2_21);
        ymProduceIncome.setProduce_yf3(produce_yf3_21);
        ymProduceIncome.setProduce_yf4(produce_yf4_21);
        ymProduceIncome.setProduce_yf5(produce_yf5_21);
        ymProduceIncome.setProduce_yf6(produce_yf6_21);
        ymProduceIncome.setProduce_yf7(produce_yf7_21);
        ymProduceIncome.setProduce_yf8(produce_yf8_21);
        ymProduceIncome.setProduce_yf9(produce_yf9_21);
        ymProduceIncome.setProduce_yf10(produce_yf10_21);
        ymProduceIncome.setProduce_yf11(produce_yf11_21);
        ymProduceIncome.setProduce_yf12(produce_yf12_21);
        ymProduceIncomeList.add(ymProduceIncome);

        String produce_yf1_22     = request.getParameter("produce_yf1_22");
        String produce_yf2_22     = request.getParameter("produce_yf2_22");
        String produce_yf3_22     = request.getParameter("produce_yf3_22");
        String produce_yf4_22     = request.getParameter("produce_yf4_22");
        String produce_yf5_22     = request.getParameter("produce_yf5_22");
        String produce_yf6_22     = request.getParameter("produce_yf6_22");
        String produce_yf7_22     = request.getParameter("produce_yf7_22");
        String produce_yf8_22     = request.getParameter("produce_yf8_22");
        String produce_yf9_22     = request.getParameter("produce_yf9_22");
        String produce_yf10_22    = request.getParameter("produce_yf10_22");
        String produce_yf11_22    = request.getParameter("produce_yf11_22");
        String produce_yf12_22    = request.getParameter("produce_yf12_22");
        //种植业金额
        ymProduceIncome = new YmProduceIncome();
        ymProduceIncome.setJtbh(jtbh);
        ymProduceIncome.setProduce_xtdl("02");
        ymProduceIncome.setProduce_xtxl1("01");
        ymProduceIncome.setProduce_xtxl2("02");
        ymProduceIncome.setProduce_nf("2019");
        ymProduceIncome.setProduce_yf1(produce_yf1_22);
        ymProduceIncome.setProduce_yf2(produce_yf2_22);
        ymProduceIncome.setProduce_yf3(produce_yf3_22);
        ymProduceIncome.setProduce_yf4(produce_yf4_22);
        ymProduceIncome.setProduce_yf5(produce_yf5_22);
        ymProduceIncome.setProduce_yf6(produce_yf6_22);
        ymProduceIncome.setProduce_yf7(produce_yf7_22);
        ymProduceIncome.setProduce_yf8(produce_yf8_22);
        ymProduceIncome.setProduce_yf9(produce_yf9_22);
        ymProduceIncome.setProduce_yf10(produce_yf10_22);
        ymProduceIncome.setProduce_yf11(produce_yf11_22);
        ymProduceIncome.setProduce_yf12(produce_yf12_22);
        ymProduceIncomeList.add(ymProduceIncome);

        String produce_yf1_23     = request.getParameter("produce_yf1_23");
        String produce_yf2_23     = request.getParameter("produce_yf2_23");
        String produce_yf3_23     = request.getParameter("produce_yf3_23");
        String produce_yf4_23     = request.getParameter("produce_yf4_23");
        String produce_yf5_23     = request.getParameter("produce_yf5_23");
        String produce_yf6_23     = request.getParameter("produce_yf6_23");
        String produce_yf7_23     = request.getParameter("produce_yf7_23");
        String produce_yf8_23     = request.getParameter("produce_yf8_23");
        String produce_yf9_23     = request.getParameter("produce_yf9_23");
        String produce_yf10_23    = request.getParameter("produce_yf10_23");
        String produce_yf11_23    = request.getParameter("produce_yf11_23");
        String produce_yf12_23    = request.getParameter("produce_yf12_23");
        //种植业金额
        ymProduceIncome = new YmProduceIncome();
        ymProduceIncome.setJtbh(jtbh);
        ymProduceIncome.setProduce_xtdl("02");
        ymProduceIncome.setProduce_xtxl1("01");
        ymProduceIncome.setProduce_xtxl2("03");
        ymProduceIncome.setProduce_nf("2019");
        ymProduceIncome.setProduce_yf1(produce_yf1_23);
        ymProduceIncome.setProduce_yf2(produce_yf2_23);
        ymProduceIncome.setProduce_yf3(produce_yf3_23);
        ymProduceIncome.setProduce_yf4(produce_yf4_23);
        ymProduceIncome.setProduce_yf5(produce_yf5_23);
        ymProduceIncome.setProduce_yf6(produce_yf6_23);
        ymProduceIncome.setProduce_yf7(produce_yf7_23);
        ymProduceIncome.setProduce_yf8(produce_yf8_23);
        ymProduceIncome.setProduce_yf9(produce_yf9_23);
        ymProduceIncome.setProduce_yf10(produce_yf10_23);
        ymProduceIncome.setProduce_yf11(produce_yf11_23);
        ymProduceIncome.setProduce_yf12(produce_yf12_23);
        ymProduceIncomeList.add(ymProduceIncome);

        String produce_yf1_24     = request.getParameter("produce_yf1_24");
        String produce_yf2_24     = request.getParameter("produce_yf2_24");
        String produce_yf3_24     = request.getParameter("produce_yf3_24");
        String produce_yf4_24     = request.getParameter("produce_yf4_24");
        String produce_yf5_24     = request.getParameter("produce_yf5_24");
        String produce_yf6_24     = request.getParameter("produce_yf6_24");
        String produce_yf7_24     = request.getParameter("produce_yf7_24");
        String produce_yf8_24     = request.getParameter("produce_yf8_24");
        String produce_yf9_24     = request.getParameter("produce_yf9_24");
        String produce_yf10_24    = request.getParameter("produce_yf10_24");
        String produce_yf11_24    = request.getParameter("produce_yf11_24");
        String produce_yf12_24    = request.getParameter("produce_yf12_24");
        //种植业金额
        ymProduceIncome = new YmProduceIncome();
        ymProduceIncome.setJtbh(jtbh);
        ymProduceIncome.setProduce_xtdl("02");
        ymProduceIncome.setProduce_xtxl1("02");
        ymProduceIncome.setProduce_xtxl2("01");
        ymProduceIncome.setProduce_nf("2019");
        ymProduceIncome.setProduce_yf1(produce_yf1_24);
        ymProduceIncome.setProduce_yf2(produce_yf2_24);
        ymProduceIncome.setProduce_yf3(produce_yf3_24);
        ymProduceIncome.setProduce_yf4(produce_yf4_24);
        ymProduceIncome.setProduce_yf5(produce_yf5_24);
        ymProduceIncome.setProduce_yf6(produce_yf6_24);
        ymProduceIncome.setProduce_yf7(produce_yf7_24);
        ymProduceIncome.setProduce_yf8(produce_yf8_24);
        ymProduceIncome.setProduce_yf9(produce_yf9_24);
        ymProduceIncome.setProduce_yf10(produce_yf10_24);
        ymProduceIncome.setProduce_yf11(produce_yf11_24);
        ymProduceIncome.setProduce_yf12(produce_yf12_24);
        ymProduceIncomeList.add(ymProduceIncome);

        String produce_yf1_25     = request.getParameter("produce_yf1_25");
        String produce_yf2_25     = request.getParameter("produce_yf2_25");
        String produce_yf3_25     = request.getParameter("produce_yf3_25");
        String produce_yf4_25     = request.getParameter("produce_yf4_25");
        String produce_yf5_25     = request.getParameter("produce_yf5_25");
        String produce_yf6_25     = request.getParameter("produce_yf6_25");
        String produce_yf7_25     = request.getParameter("produce_yf7_25");
        String produce_yf8_25     = request.getParameter("produce_yf8_25");
        String produce_yf9_25     = request.getParameter("produce_yf9_25");
        String produce_yf10_25    = request.getParameter("produce_yf10_25");
        String produce_yf11_25    = request.getParameter("produce_yf11_25");
        String produce_yf12_25    = request.getParameter("produce_yf12_25");
        //种植业金额
        ymProduceIncome = new YmProduceIncome();
        ymProduceIncome.setJtbh(jtbh);
        ymProduceIncome.setProduce_xtdl("02");
        ymProduceIncome.setProduce_xtxl1("02");
        ymProduceIncome.setProduce_xtxl2("02");
        ymProduceIncome.setProduce_nf("2019");
        ymProduceIncome.setProduce_yf1(produce_yf1_25);
        ymProduceIncome.setProduce_yf2(produce_yf2_25);
        ymProduceIncome.setProduce_yf3(produce_yf3_25);
        ymProduceIncome.setProduce_yf4(produce_yf4_25);
        ymProduceIncome.setProduce_yf5(produce_yf5_25);
        ymProduceIncome.setProduce_yf6(produce_yf6_25);
        ymProduceIncome.setProduce_yf7(produce_yf7_25);
        ymProduceIncome.setProduce_yf8(produce_yf8_25);
        ymProduceIncome.setProduce_yf9(produce_yf9_25);
        ymProduceIncome.setProduce_yf10(produce_yf10_25);
        ymProduceIncome.setProduce_yf11(produce_yf11_25);
        ymProduceIncome.setProduce_yf12(produce_yf12_25);
        ymProduceIncomeList.add(ymProduceIncome);

        String produce_yf1_26     = request.getParameter("produce_yf1_26");
        String produce_yf2_26     = request.getParameter("produce_yf2_26");
        String produce_yf3_26     = request.getParameter("produce_yf3_26");
        String produce_yf4_26     = request.getParameter("produce_yf4_26");
        String produce_yf5_26     = request.getParameter("produce_yf5_26");
        String produce_yf6_26     = request.getParameter("produce_yf6_26");
        String produce_yf7_26     = request.getParameter("produce_yf7_26");
        String produce_yf8_26     = request.getParameter("produce_yf8_26");
        String produce_yf9_26     = request.getParameter("produce_yf9_26");
        String produce_yf10_26    = request.getParameter("produce_yf10_26");
        String produce_yf11_26    = request.getParameter("produce_yf11_26");
        String produce_yf12_26    = request.getParameter("produce_yf12_26");
        //种植业金额
        ymProduceIncome = new YmProduceIncome();
        ymProduceIncome.setJtbh(jtbh);
        ymProduceIncome.setProduce_xtdl("02");
        ymProduceIncome.setProduce_xtxl1("02");
        ymProduceIncome.setProduce_xtxl2("03");
        ymProduceIncome.setProduce_nf("2019");
        ymProduceIncome.setProduce_yf1(produce_yf1_26);
        ymProduceIncome.setProduce_yf2(produce_yf2_26);
        ymProduceIncome.setProduce_yf3(produce_yf3_26);
        ymProduceIncome.setProduce_yf4(produce_yf4_26);
        ymProduceIncome.setProduce_yf5(produce_yf5_26);
        ymProduceIncome.setProduce_yf6(produce_yf6_26);
        ymProduceIncome.setProduce_yf7(produce_yf7_26);
        ymProduceIncome.setProduce_yf8(produce_yf8_26);
        ymProduceIncome.setProduce_yf9(produce_yf9_26);
        ymProduceIncome.setProduce_yf10(produce_yf10_26);
        ymProduceIncome.setProduce_yf11(produce_yf11_26);
        ymProduceIncome.setProduce_yf12(produce_yf12_26);
        ymProduceIncomeList.add(ymProduceIncome);

        String produce_yf1_27     = request.getParameter("produce_yf1_27");
        String produce_yf2_27     = request.getParameter("produce_yf2_27");
        String produce_yf3_27     = request.getParameter("produce_yf3_27");
        String produce_yf4_27     = request.getParameter("produce_yf4_27");
        String produce_yf5_27     = request.getParameter("produce_yf5_27");
        String produce_yf6_27     = request.getParameter("produce_yf6_27");
        String produce_yf7_27     = request.getParameter("produce_yf7_27");
        String produce_yf8_27     = request.getParameter("produce_yf8_27");
        String produce_yf9_27     = request.getParameter("produce_yf9_27");
        String produce_yf10_27    = request.getParameter("produce_yf10_27");
        String produce_yf11_27    = request.getParameter("produce_yf11_27");
        String produce_yf12_27    = request.getParameter("produce_yf12_27");
        //种植业金额
        ymProduceIncome = new YmProduceIncome();
        ymProduceIncome.setJtbh(jtbh);
        ymProduceIncome.setProduce_xtdl("02");
        ymProduceIncome.setProduce_xtxl1("03");
        ymProduceIncome.setProduce_xtxl2("01");
        ymProduceIncome.setProduce_nf("2019");
        ymProduceIncome.setProduce_yf1(produce_yf1_27);
        ymProduceIncome.setProduce_yf2(produce_yf2_27);
        ymProduceIncome.setProduce_yf3(produce_yf3_27);
        ymProduceIncome.setProduce_yf4(produce_yf4_27);
        ymProduceIncome.setProduce_yf5(produce_yf5_27);
        ymProduceIncome.setProduce_yf6(produce_yf6_27);
        ymProduceIncome.setProduce_yf7(produce_yf7_27);
        ymProduceIncome.setProduce_yf8(produce_yf8_27);
        ymProduceIncome.setProduce_yf9(produce_yf9_27);
        ymProduceIncome.setProduce_yf10(produce_yf10_27);
        ymProduceIncome.setProduce_yf11(produce_yf11_27);
        ymProduceIncome.setProduce_yf12(produce_yf12_27);
        ymProduceIncomeList.add(ymProduceIncome);

        String produce_yf1_28     = request.getParameter("produce_yf1_28");
        String produce_yf2_28     = request.getParameter("produce_yf2_28");
        String produce_yf3_28     = request.getParameter("produce_yf3_28");
        String produce_yf4_28     = request.getParameter("produce_yf4_28");
        String produce_yf5_28     = request.getParameter("produce_yf5_28");
        String produce_yf6_28     = request.getParameter("produce_yf6_28");
        String produce_yf7_28     = request.getParameter("produce_yf7_28");
        String produce_yf8_28     = request.getParameter("produce_yf8_28");
        String produce_yf9_28     = request.getParameter("produce_yf9_28");
        String produce_yf10_28    = request.getParameter("produce_yf10_28");
        String produce_yf11_28    = request.getParameter("produce_yf11_28");
        String produce_yf12_28    = request.getParameter("produce_yf12_28");
        //种植业金额
        ymProduceIncome = new YmProduceIncome();
        ymProduceIncome.setJtbh(jtbh);
        ymProduceIncome.setProduce_xtdl("02");
        ymProduceIncome.setProduce_xtxl1("03");
        ymProduceIncome.setProduce_xtxl2("02");
        ymProduceIncome.setProduce_nf("2019");
        ymProduceIncome.setProduce_yf1(produce_yf1_28);
        ymProduceIncome.setProduce_yf2(produce_yf2_28);
        ymProduceIncome.setProduce_yf3(produce_yf3_28);
        ymProduceIncome.setProduce_yf4(produce_yf4_28);
        ymProduceIncome.setProduce_yf5(produce_yf5_28);
        ymProduceIncome.setProduce_yf6(produce_yf6_28);
        ymProduceIncome.setProduce_yf7(produce_yf7_28);
        ymProduceIncome.setProduce_yf8(produce_yf8_28);
        ymProduceIncome.setProduce_yf9(produce_yf9_28);
        ymProduceIncome.setProduce_yf10(produce_yf10_28);
        ymProduceIncome.setProduce_yf11(produce_yf11_28);
        ymProduceIncome.setProduce_yf12(produce_yf12_28);
        ymProduceIncomeList.add(ymProduceIncome);

        String produce_yf1_29     = request.getParameter("produce_yf1_29");
        String produce_yf2_29     = request.getParameter("produce_yf2_29");
        String produce_yf3_29     = request.getParameter("produce_yf3_29");
        String produce_yf4_29     = request.getParameter("produce_yf4_29");
        String produce_yf5_29     = request.getParameter("produce_yf5_29");
        String produce_yf6_29     = request.getParameter("produce_yf6_29");
        String produce_yf7_29     = request.getParameter("produce_yf7_29");
        String produce_yf8_29     = request.getParameter("produce_yf8_29");
        String produce_yf9_29     = request.getParameter("produce_yf9_29");
        String produce_yf10_29    = request.getParameter("produce_yf10_29");
        String produce_yf11_29    = request.getParameter("produce_yf11_29");
        String produce_yf12_29    = request.getParameter("produce_yf12_29");
        //种植业金额
        ymProduceIncome = new YmProduceIncome();
        ymProduceIncome.setJtbh(jtbh);
        ymProduceIncome.setProduce_xtdl("02");
        ymProduceIncome.setProduce_xtxl1("03");
        ymProduceIncome.setProduce_xtxl2("03");
        ymProduceIncome.setProduce_nf("2019");
        ymProduceIncome.setProduce_yf1(produce_yf1_29);
        ymProduceIncome.setProduce_yf2(produce_yf2_29);
        ymProduceIncome.setProduce_yf3(produce_yf3_29);
        ymProduceIncome.setProduce_yf4(produce_yf4_29);
        ymProduceIncome.setProduce_yf5(produce_yf5_29);
        ymProduceIncome.setProduce_yf6(produce_yf6_29);
        ymProduceIncome.setProduce_yf7(produce_yf7_29);
        ymProduceIncome.setProduce_yf8(produce_yf8_29);
        ymProduceIncome.setProduce_yf9(produce_yf9_29);
        ymProduceIncome.setProduce_yf10(produce_yf10_29);
        ymProduceIncome.setProduce_yf11(produce_yf11_29);
        ymProduceIncome.setProduce_yf12(produce_yf12_29);
        ymProduceIncomeList.add(ymProduceIncome);

        String produce_yf1_30     = request.getParameter("produce_yf1_30");
        String produce_yf2_30     = request.getParameter("produce_yf2_30");
        String produce_yf3_30     = request.getParameter("produce_yf3_30");
        String produce_yf4_30     = request.getParameter("produce_yf4_30");
        String produce_yf5_30     = request.getParameter("produce_yf5_30");
        String produce_yf6_30     = request.getParameter("produce_yf6_30");
        String produce_yf7_30     = request.getParameter("produce_yf7_30");
        String produce_yf8_30     = request.getParameter("produce_yf8_30");
        String produce_yf9_30     = request.getParameter("produce_yf9_30");
        String produce_yf10_30    = request.getParameter("produce_yf10_30");
        String produce_yf11_30    = request.getParameter("produce_yf11_30");
        String produce_yf12_30    = request.getParameter("produce_yf12_30");
        //种植业金额
        ymProduceIncome = new YmProduceIncome();
        ymProduceIncome.setJtbh(jtbh);
        ymProduceIncome.setProduce_xtdl("02");
        ymProduceIncome.setProduce_xtxl1("04");
        ymProduceIncome.setProduce_xtxl2("03");
        ymProduceIncome.setProduce_nf("2019");
        ymProduceIncome.setProduce_yf1(produce_yf1_30);
        ymProduceIncome.setProduce_yf2(produce_yf2_30);
        ymProduceIncome.setProduce_yf3(produce_yf3_30);
        ymProduceIncome.setProduce_yf4(produce_yf4_30);
        ymProduceIncome.setProduce_yf5(produce_yf5_30);
        ymProduceIncome.setProduce_yf6(produce_yf6_30);
        ymProduceIncome.setProduce_yf7(produce_yf7_30);
        ymProduceIncome.setProduce_yf8(produce_yf8_30);
        ymProduceIncome.setProduce_yf9(produce_yf9_30);
        ymProduceIncome.setProduce_yf10(produce_yf10_30);
        ymProduceIncome.setProduce_yf11(produce_yf11_30);
        ymProduceIncome.setProduce_yf12(produce_yf12_30);
        ymProduceIncomeList.add(ymProduceIncome);

        String produce_yf1_31     = request.getParameter("produce_yf1_31");
        String produce_yf2_31     = request.getParameter("produce_yf2_31");
        String produce_yf3_31     = request.getParameter("produce_yf3_31");
        String produce_yf4_31     = request.getParameter("produce_yf4_31");
        String produce_yf5_31     = request.getParameter("produce_yf5_31");
        String produce_yf6_31     = request.getParameter("produce_yf6_31");
        String produce_yf7_31     = request.getParameter("produce_yf7_31");
        String produce_yf8_31     = request.getParameter("produce_yf8_31");
        String produce_yf9_31     = request.getParameter("produce_yf9_31");
        String produce_yf10_31    = request.getParameter("produce_yf10_31");
        String produce_yf11_31    = request.getParameter("produce_yf11_31");
        String produce_yf12_31    = request.getParameter("produce_yf12_31");


        //底层写入
        ymProduceIncomeService.addYmProduceIncomeMore(ymProduceIncomeList);

        //返回信息
        Map<String,Object> map = new HashMap<>();
        map.put("status",1);
        map.put("result","success");
        return map;
    }


}
