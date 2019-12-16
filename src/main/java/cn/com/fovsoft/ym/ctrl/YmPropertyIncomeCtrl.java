package cn.com.fovsoft.ym.ctrl;

import cn.com.fovsoft.ym.bean.YmPropertyIncome;
import cn.com.fovsoft.ym.service.YmPropertyIncomeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @Author by tpc
 * @Date 2019/11/26 22:27
 * description:财产收入控制类
 **/

public class YmPropertyIncomeCtrl {

    @Autowired
    private YmPropertyIncomeService ymPropertyIncomeService;


    @RequestMapping("/propertyIncome/add")
    @ResponseBody
    public Map<String,Object> addYmPropertyIncomeMore(HttpServletRequest request){


        String jtbh          = request.getParameter("jtbh");
        List<YmPropertyIncome> ymPropertyIncomeList = new ArrayList<>();

        String property_yf1_1           = request.getParameter("property_yf1_1");
        String property_yf2_1           = request.getParameter("property_yf2_1");
        String property_yf3_1           = request.getParameter("property_yf3_1");
        String property_yf4_1           = request.getParameter("property_yf4_1");
        String property_yf5_1           = request.getParameter("property_yf5_1");
        String property_yf6_1           = request.getParameter("property_yf6_1");
        String property_yf7_1           = request.getParameter("property_yf7_1");
        String property_yf8_1           = request.getParameter("property_yf8_1");
        String property_yf9_1           = request.getParameter("property_yf9_1");
        String property_yf10_1          = request.getParameter("property_yf10_1");
        String property_yf11_1          = request.getParameter("property_yf11_1");
        String property_yf12_1          = request.getParameter("property_yf12_1");
        YmPropertyIncome ymPropertyIncome = new YmPropertyIncome();
        ymPropertyIncome.setJtbh(jtbh);
        ymPropertyIncome.setProperty_xtlb("01");
        ymPropertyIncome.setProperty_nf("2019");
        ymPropertyIncome.setProperty_yf1(property_yf1_1);
        ymPropertyIncome.setProperty_yf2(property_yf2_1);
        ymPropertyIncome.setProperty_yf3(property_yf3_1);
        ymPropertyIncome.setProperty_yf4(property_yf4_1);
        ymPropertyIncome.setProperty_yf5(property_yf5_1);
        ymPropertyIncome.setProperty_yf6(property_yf6_1);
        ymPropertyIncome.setProperty_yf7(property_yf7_1);
        ymPropertyIncome.setProperty_yf8(property_yf8_1);
        ymPropertyIncome.setProperty_yf9(property_yf9_1);
        ymPropertyIncome.setProperty_yf10(property_yf10_1);
        ymPropertyIncome.setProperty_yf11(property_yf11_1);
        ymPropertyIncome.setProperty_yf12(property_yf12_1);
        ymPropertyIncomeList.add(ymPropertyIncome);

        String property_yf1_2           = request.getParameter("property_yf1_2");
        String property_yf2_2           = request.getParameter("property_yf2_2");
        String property_yf3_2           = request.getParameter("property_yf3_2");
        String property_yf4_2           = request.getParameter("property_yf4_2");
        String property_yf5_2           = request.getParameter("property_yf5_2");
        String property_yf6_2           = request.getParameter("property_yf6_2");
        String property_yf7_2           = request.getParameter("property_yf7_2");
        String property_yf8_2           = request.getParameter("property_yf8_2");
        String property_yf9_2           = request.getParameter("property_yf9_2");
        String property_yf10_2          = request.getParameter("property_yf10_2");
        String property_yf11_2          = request.getParameter("property_yf11_2");
        String property_yf12_2          = request.getParameter("property_yf12_2");

        ymPropertyIncome = new YmPropertyIncome();
        ymPropertyIncome.setJtbh(jtbh);
        ymPropertyIncome.setProperty_xtlb("02");
        ymPropertyIncome.setProperty_nf("2019");
        ymPropertyIncome.setProperty_yf1(property_yf1_2);
        ymPropertyIncome.setProperty_yf2(property_yf2_2);
        ymPropertyIncome.setProperty_yf3(property_yf3_2);
        ymPropertyIncome.setProperty_yf4(property_yf4_2);
        ymPropertyIncome.setProperty_yf5(property_yf5_2);
        ymPropertyIncome.setProperty_yf6(property_yf6_2);
        ymPropertyIncome.setProperty_yf7(property_yf7_2);
        ymPropertyIncome.setProperty_yf8(property_yf8_2);
        ymPropertyIncome.setProperty_yf9(property_yf9_2);
        ymPropertyIncome.setProperty_yf10(property_yf10_2);
        ymPropertyIncome.setProperty_yf11(property_yf11_2);
        ymPropertyIncome.setProperty_yf12(property_yf12_2);
        ymPropertyIncomeList.add(ymPropertyIncome);

        String property_yf1_3           = request.getParameter("property_yf1_3");
        String property_yf2_3           = request.getParameter("property_yf2_3");
        String property_yf3_3           = request.getParameter("property_yf3_3");
        String property_yf4_3           = request.getParameter("property_yf4_3");
        String property_yf5_3           = request.getParameter("property_yf5_3");
        String property_yf6_3           = request.getParameter("property_yf6_3");
        String property_yf7_3           = request.getParameter("property_yf7_3");
        String property_yf8_3           = request.getParameter("property_yf8_3");
        String property_yf9_3           = request.getParameter("property_yf9_3");
        String property_yf10_3          = request.getParameter("property_yf10_3");
        String property_yf11_3          = request.getParameter("property_yf11_3");
        String property_yf12_3          = request.getParameter("property_yf12_3");



        ymPropertyIncomeService.addYmPropertyIncomeMore(ymPropertyIncomeList);
        Map<String,Object> map = new HashMap<>();
        map.put("status",1);
        map.put("result","success");
        return map;
    }



}
