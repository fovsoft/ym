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
        String cc_1810je1    = request.getParameter("cc_1810je1");
        String cc_1811je1    = request.getParameter("cc_1811je1");
        String cc_1812je1    = request.getParameter("cc_1812je1");
        String cc_1913je1    = request.getParameter("cc_1913je1");
        String cc_1946je1    = request.getParameter("cc_1946je1");
        String cc_1979je1    = request.getParameter("cc_1979je1");
        String cc_1910je1    = request.getParameter("cc_1910je1");
        String cc_1911je1    = request.getParameter("cc_1911je1");
        String cc_1912je1    = request.getParameter("cc_1912je1");
        //用来记录多条记录的list
        List<YmPropertyIncome> ymPropertyIncomeList = new ArrayList<>();
        YmPropertyIncome ymPropertyIncome = new YmPropertyIncome();
        ymPropertyIncome.setJtbh(jtbh);
        ymPropertyIncome.setPro_xtlb("01");
        ymPropertyIncome.setPro_nf("2018");
        ymPropertyIncome.setPro_yf13("");
        ymPropertyIncome.setPro_yf46("");
        ymPropertyIncome.setPro_yf79("");
        ymPropertyIncome.setPro_yf10(cc_1810je1);
        ymPropertyIncome.setPro_yf11(cc_1811je1);
        ymPropertyIncome.setPro_yf12(cc_1812je1);
        ymPropertyIncomeList.add(ymPropertyIncome);

        ymPropertyIncome = new YmPropertyIncome();
        ymPropertyIncome.setJtbh(jtbh);
        ymPropertyIncome.setPro_xtlb("01");
        ymPropertyIncome.setPro_nf("2019");
        ymPropertyIncome.setPro_yf13(cc_1913je1);
        ymPropertyIncome.setPro_yf46(cc_1946je1);
        ymPropertyIncome.setPro_yf79(cc_1979je1);
        ymPropertyIncome.setPro_yf10(cc_1910je1);
        ymPropertyIncome.setPro_yf11(cc_1911je1);
        ymPropertyIncome.setPro_yf12(cc_1912je1);
        ymPropertyIncomeList.add(ymPropertyIncome);

        String cc_1810je2    = request.getParameter("cc_1810je2");
        String cc_1811je2    = request.getParameter("cc_1811je2");
        String cc_1812je2    = request.getParameter("cc_1812je2");
        String cc_1913je2    = request.getParameter("cc_1913je2");
        String cc_1946je2    = request.getParameter("cc_1946je2");
        String cc_1979je2    = request.getParameter("cc_1979je2");
        String cc_1910je2    = request.getParameter("cc_1910je2");
        String cc_1911je2    = request.getParameter("cc_1911je2");
        String cc_1912je2    = request.getParameter("cc_1912je2");

        ymPropertyIncome = new YmPropertyIncome();
        ymPropertyIncome.setJtbh(jtbh);
        ymPropertyIncome.setPro_xtlb("02");
        ymPropertyIncome.setPro_nf("2018");
        ymPropertyIncome.setPro_yf13("");
        ymPropertyIncome.setPro_yf46("");
        ymPropertyIncome.setPro_yf79("");
        ymPropertyIncome.setPro_yf10(cc_1810je2);
        ymPropertyIncome.setPro_yf11(cc_1811je2);
        ymPropertyIncome.setPro_yf12(cc_1812je2);
        ymPropertyIncomeList.add(ymPropertyIncome);

        ymPropertyIncome = new YmPropertyIncome();
        ymPropertyIncome.setJtbh(jtbh);
        ymPropertyIncome.setPro_xtlb("02");
        ymPropertyIncome.setPro_nf("2019");
        ymPropertyIncome.setPro_yf13(cc_1913je2);
        ymPropertyIncome.setPro_yf46(cc_1946je2);
        ymPropertyIncome.setPro_yf79(cc_1979je2);
        ymPropertyIncome.setPro_yf10(cc_1910je2);
        ymPropertyIncome.setPro_yf11(cc_1911je2);
        ymPropertyIncome.setPro_yf12(cc_1912je2);
        ymPropertyIncomeList.add(ymPropertyIncome);

        ymPropertyIncomeService.addYmPropertyIncomeMore(ymPropertyIncomeList);

        Map<String,Object> map = new HashMap<>();
        map.put("status",1);
        map.put("result","success");
        return map;
    }



}
