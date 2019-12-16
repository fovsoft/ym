package cn.com.fovsoft.ym.ctrl;

import cn.com.fovsoft.ym.bean.YmOutPovertyIncome;
import cn.com.fovsoft.ym.service.YmOutPovertyIncomeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @Author by tpc
 * @Date 2019/11/26 22:04
 * description:不计入家庭脱贫收入控制类
 **/


@Controller
public class YmOutPovertyIncomeCtrl {

    @Autowired
    private YmOutPovertyIncomeService ymOutPovertyIncomeService;


    @RequestMapping("/outPovertyIncome/add")
    @ResponseBody
    public Map<String,Object> addYmOutPovertyIncomeMore(HttpServletRequest request){

        //封装写入对象的list
//        List<YmOutPovertyIncome> ymOutPovertyIncomeList = new ArrayList<>();
//
//        String jtbh           = request.getParameter("jtbh");
//        String op_1810je1     = request.getParameter("op_1810je1");
//        String op_1811je1     = request.getParameter("op_1811je1");
//        String op_1812je1     = request.getParameter("op_1812je1");
//        String op_1913je1     = request.getParameter("op_1913je1");
//        String op_1946je1     = request.getParameter("op_1946je1");
//        String op_1979je1     = request.getParameter("op_1979je1");
//        String op_1910je1     = request.getParameter("op_1910je1");
//        String op_1911je1     = request.getParameter("op_1911je1");
//        String op_1912je1     = request.getParameter("op_1912je1");
//        YmOutPovertyIncome ymOutPovertyIncome = new YmOutPovertyIncome();
//        ymOutPovertyIncome.setJtbh(jtbh);
//        ymOutPovertyIncome.setPov_xtlb("01");
//        ymOutPovertyIncome.setPov_nf("2018");
//        ymOutPovertyIncome.setPov_yf13("");
//        ymOutPovertyIncome.setPov_yf46("");
//        ymOutPovertyIncome.setPov_yf79("");
//        ymOutPovertyIncome.setPov_yf10(op_1810je1);
//        ymOutPovertyIncome.setPov_yf11(op_1811je1);
//        ymOutPovertyIncome.setPov_yf12(op_1812je1);
//        ymOutPovertyIncomeList.add(ymOutPovertyIncome);
//
//        ymOutPovertyIncome = new YmOutPovertyIncome();
//        ymOutPovertyIncome.setJtbh(jtbh);
//        ymOutPovertyIncome.setPov_xtlb("01");
//        ymOutPovertyIncome.setPov_nf("2019");
//        ymOutPovertyIncome.setPov_yf13(op_1913je1);
//        ymOutPovertyIncome.setPov_yf46(op_1946je1);
//        ymOutPovertyIncome.setPov_yf79(op_1979je1);
//        ymOutPovertyIncome.setPov_yf10(op_1910je1);
//        ymOutPovertyIncome.setPov_yf11(op_1911je1);
//        ymOutPovertyIncome.setPov_yf12(op_1912je1);
//        ymOutPovertyIncomeList.add(ymOutPovertyIncome);
//
//
//        String op_1810je2     = request.getParameter("op_1810je2");
//        String op_1811je2     = request.getParameter("op_1811je2");
//        String op_1812je2     = request.getParameter("op_1812je2");
//        String op_1913je2     = request.getParameter("op_1913je2");
//        String op_1946je2     = request.getParameter("op_1946je2");
//        String op_1979je2     = request.getParameter("op_1979je2");
//        String op_1910je2     = request.getParameter("op_1910je2");
//        String op_1911je2     = request.getParameter("op_1911je2");
//        String op_1912je2     = request.getParameter("op_1912je2");
//        ymOutPovertyIncome = new YmOutPovertyIncome();
//        ymOutPovertyIncome.setJtbh(jtbh);
//        ymOutPovertyIncome.setPov_xtlb("02");
//        ymOutPovertyIncome.setPov_nf("2018");
//        ymOutPovertyIncome.setPov_yf13("");
//        ymOutPovertyIncome.setPov_yf46("");
//        ymOutPovertyIncome.setPov_yf79("");
//        ymOutPovertyIncome.setPov_yf10(op_1810je2);
//        ymOutPovertyIncome.setPov_yf11(op_1811je2);
//        ymOutPovertyIncome.setPov_yf12(op_1812je2);
//        ymOutPovertyIncomeList.add(ymOutPovertyIncome);
//
//        ymOutPovertyIncome = new YmOutPovertyIncome();
//        ymOutPovertyIncome.setJtbh(jtbh);
//        ymOutPovertyIncome.setPov_xtlb("02");
//        ymOutPovertyIncome.setPov_nf("2019");
//        ymOutPovertyIncome.setPov_yf13(op_1913je2);
//        ymOutPovertyIncome.setPov_yf46(op_1946je2);
//        ymOutPovertyIncome.setPov_yf79(op_1979je2);
//        ymOutPovertyIncome.setPov_yf10(op_1910je2);
//        ymOutPovertyIncome.setPov_yf11(op_1911je2);
//        ymOutPovertyIncome.setPov_yf12(op_1912je2);
//        ymOutPovertyIncomeList.add(ymOutPovertyIncome);
//
//        String op_1810je3     = request.getParameter("op_1810je3");
//        String op_1811je3     = request.getParameter("op_1811je3");
//        String op_1812je3     = request.getParameter("op_1812je3");
//        String op_1913je3     = request.getParameter("op_1913je3");
//        String op_1946je3     = request.getParameter("op_1946je3");
//        String op_1979je3     = request.getParameter("op_1979je3");
//        String op_1910je3     = request.getParameter("op_1910je3");
//        String op_1911je3     = request.getParameter("op_1911je3");
//        String op_1912je3     = request.getParameter("op_1912je3");
//        ymOutPovertyIncome = new YmOutPovertyIncome();
//        ymOutPovertyIncome.setJtbh(jtbh);
//        ymOutPovertyIncome.setPov_xtlb("03");
//        ymOutPovertyIncome.setPov_nf("2018");
//        ymOutPovertyIncome.setPov_yf13("");
//        ymOutPovertyIncome.setPov_yf46("");
//        ymOutPovertyIncome.setPov_yf79("");
//        ymOutPovertyIncome.setPov_yf10(op_1810je3);
//        ymOutPovertyIncome.setPov_yf11(op_1811je3);
//        ymOutPovertyIncome.setPov_yf12(op_1812je3);
//        ymOutPovertyIncomeList.add(ymOutPovertyIncome);
//
//        ymOutPovertyIncome = new YmOutPovertyIncome();
//        ymOutPovertyIncome.setJtbh(jtbh);
//        ymOutPovertyIncome.setPov_xtlb("03");
//        ymOutPovertyIncome.setPov_nf("2019");
//        ymOutPovertyIncome.setPov_yf13(op_1913je3);
//        ymOutPovertyIncome.setPov_yf46(op_1946je3);
//        ymOutPovertyIncome.setPov_yf79(op_1979je3);
//        ymOutPovertyIncome.setPov_yf10(op_1910je3);
//        ymOutPovertyIncome.setPov_yf11(op_1911je3);
//        ymOutPovertyIncome.setPov_yf12(op_1912je3);
//        ymOutPovertyIncomeList.add(ymOutPovertyIncome);
//
//        String op_1810je4     = request.getParameter("op_1810je4");
//        String op_1811je4     = request.getParameter("op_1811je4");
//        String op_1812je4     = request.getParameter("op_1812je4");
//        String op_1913je4     = request.getParameter("op_1913je4");
//        String op_1946je4     = request.getParameter("op_1946je4");
//        String op_1979je4     = request.getParameter("op_1979je4");
//        String op_1910je4     = request.getParameter("op_1910je4");
//        String op_1911je4     = request.getParameter("op_1911je4");
//        String op_1912je4     = request.getParameter("op_1912je4");
//        ymOutPovertyIncome = new YmOutPovertyIncome();
//        ymOutPovertyIncome.setJtbh(jtbh);
//        ymOutPovertyIncome.setPov_xtlb("04");
//        ymOutPovertyIncome.setPov_nf("2018");
//        ymOutPovertyIncome.setPov_yf13("");
//        ymOutPovertyIncome.setPov_yf46("");
//        ymOutPovertyIncome.setPov_yf79("");
//        ymOutPovertyIncome.setPov_yf10(op_1810je4);
//        ymOutPovertyIncome.setPov_yf11(op_1811je4);
//        ymOutPovertyIncome.setPov_yf12(op_1812je4);
//        ymOutPovertyIncomeList.add(ymOutPovertyIncome);
//
//        ymOutPovertyIncome = new YmOutPovertyIncome();
//        ymOutPovertyIncome.setJtbh(jtbh);
//        ymOutPovertyIncome.setPov_xtlb("04");
//        ymOutPovertyIncome.setPov_nf("2019");
//        ymOutPovertyIncome.setPov_yf13(op_1913je4);
//        ymOutPovertyIncome.setPov_yf46(op_1946je4);
//        ymOutPovertyIncome.setPov_yf79(op_1979je4);
//        ymOutPovertyIncome.setPov_yf10(op_1910je4);
//        ymOutPovertyIncome.setPov_yf11(op_1911je4);
//        ymOutPovertyIncome.setPov_yf12(op_1912je4);
//        ymOutPovertyIncomeList.add(ymOutPovertyIncome);
//
//        String op_1810je5     = request.getParameter("op_1810je5");
//        String op_1811je5     = request.getParameter("op_1811je5");
//        String op_1812je5     = request.getParameter("op_1812je5");
//        String op_1913je5     = request.getParameter("op_1913je5");
//        String op_1946je5     = request.getParameter("op_1946je5");
//        String op_1979je5     = request.getParameter("op_1979je5");
//        String op_1910je5     = request.getParameter("op_1910je5");
//        String op_1911je5     = request.getParameter("op_1911je5");
//        String op_1912je5     = request.getParameter("op_1912je5");
//        ymOutPovertyIncome = new YmOutPovertyIncome();
//        ymOutPovertyIncome.setJtbh(jtbh);
//        ymOutPovertyIncome.setPov_xtlb("05");
//        ymOutPovertyIncome.setPov_nf("2018");
//        ymOutPovertyIncome.setPov_yf13("");
//        ymOutPovertyIncome.setPov_yf46("");
//        ymOutPovertyIncome.setPov_yf79("");
//        ymOutPovertyIncome.setPov_yf10(op_1810je5);
//        ymOutPovertyIncome.setPov_yf11(op_1811je5);
//        ymOutPovertyIncome.setPov_yf12(op_1812je5);
//        ymOutPovertyIncomeList.add(ymOutPovertyIncome);
//
//        ymOutPovertyIncome = new YmOutPovertyIncome();
//        ymOutPovertyIncome.setJtbh(jtbh);
//        ymOutPovertyIncome.setPov_xtlb("05");
//        ymOutPovertyIncome.setPov_nf("2019");
//        ymOutPovertyIncome.setPov_yf13(op_1913je5);
//        ymOutPovertyIncome.setPov_yf46(op_1946je5);
//        ymOutPovertyIncome.setPov_yf79(op_1979je5);
//        ymOutPovertyIncome.setPov_yf10(op_1910je5);
//        ymOutPovertyIncome.setPov_yf11(op_1911je5);
//        ymOutPovertyIncome.setPov_yf12(op_1912je5);
//        ymOutPovertyIncomeList.add(ymOutPovertyIncome);
//
//        String op_1810je6     = request.getParameter("op_1810je6");
//        String op_1811je6     = request.getParameter("op_1811je6");
//        String op_1812je6     = request.getParameter("op_1812je6");
//        String op_1913je6     = request.getParameter("op_1913je6");
//        String op_1946je6     = request.getParameter("op_1946je6");
//        String op_1979je6     = request.getParameter("op_1979je6");
//        String op_1910je6     = request.getParameter("op_1910je6");
//        String op_1911je6     = request.getParameter("op_1911je6");
//        String op_1912je6     = request.getParameter("op_1912je6");
//        ymOutPovertyIncome = new YmOutPovertyIncome();
//        ymOutPovertyIncome.setJtbh(jtbh);
//        ymOutPovertyIncome.setPov_xtlb("06");
//        ymOutPovertyIncome.setPov_nf("2018");
//        ymOutPovertyIncome.setPov_yf13("");
//        ymOutPovertyIncome.setPov_yf46("");
//        ymOutPovertyIncome.setPov_yf79("");
//        ymOutPovertyIncome.setPov_yf10(op_1810je6);
//        ymOutPovertyIncome.setPov_yf11(op_1811je6);
//        ymOutPovertyIncome.setPov_yf12(op_1812je6);
//        ymOutPovertyIncomeList.add(ymOutPovertyIncome);
//
//        ymOutPovertyIncome = new YmOutPovertyIncome();
//        ymOutPovertyIncome.setJtbh(jtbh);
//        ymOutPovertyIncome.setPov_xtlb("06");
//        ymOutPovertyIncome.setPov_nf("2019");
//        ymOutPovertyIncome.setPov_yf13(op_1913je6);
//        ymOutPovertyIncome.setPov_yf46(op_1946je6);
//        ymOutPovertyIncome.setPov_yf79(op_1979je6);
//        ymOutPovertyIncome.setPov_yf10(op_1910je6);
//        ymOutPovertyIncome.setPov_yf11(op_1911je6);
//        ymOutPovertyIncome.setPov_yf12(op_1912je6);
//        ymOutPovertyIncomeList.add(ymOutPovertyIncome);
//
//        String op_1810je7     = request.getParameter("op_1810je7");
//        String op_1811je7     = request.getParameter("op_1811je7");
//        String op_1812je7     = request.getParameter("op_1812je7");
//        String op_1913je7     = request.getParameter("op_1913je7");
//        String op_1946je7     = request.getParameter("op_1946je7");
//        String op_1979je7     = request.getParameter("op_1979je7");
//        String op_1910je7     = request.getParameter("op_1910je7");
//        String op_1911je7     = request.getParameter("op_1911je7");
//        String op_1912je7     = request.getParameter("op_1912je7");
//        ymOutPovertyIncome = new YmOutPovertyIncome();
//        ymOutPovertyIncome.setJtbh(jtbh);
//        ymOutPovertyIncome.setPov_xtlb("07");
//        ymOutPovertyIncome.setPov_nf("2018");
//        ymOutPovertyIncome.setPov_yf13("");
//        ymOutPovertyIncome.setPov_yf46("");
//        ymOutPovertyIncome.setPov_yf79("");
//        ymOutPovertyIncome.setPov_yf10(op_1810je7);
//        ymOutPovertyIncome.setPov_yf11(op_1811je7);
//        ymOutPovertyIncome.setPov_yf12(op_1812je7);
//        ymOutPovertyIncomeList.add(ymOutPovertyIncome);
//
//        ymOutPovertyIncome = new YmOutPovertyIncome();
//        ymOutPovertyIncome.setJtbh(jtbh);
//        ymOutPovertyIncome.setPov_xtlb("07");
//        ymOutPovertyIncome.setPov_nf("2019");
//        ymOutPovertyIncome.setPov_yf13(op_1913je7);
//        ymOutPovertyIncome.setPov_yf46(op_1946je7);
//        ymOutPovertyIncome.setPov_yf79(op_1979je7);
//        ymOutPovertyIncome.setPov_yf10(op_1910je7);
//        ymOutPovertyIncome.setPov_yf11(op_1911je7);
//        ymOutPovertyIncome.setPov_yf12(op_1912je7);
//        ymOutPovertyIncomeList.add(ymOutPovertyIncome);
//
//        String op_1810je8     = request.getParameter("op_1810je8");
//        String op_1811je8     = request.getParameter("op_1811je8");
//        String op_1812je8     = request.getParameter("op_1812je8");
//        String op_1913je8     = request.getParameter("op_1913je8");
//        String op_1946je8     = request.getParameter("op_1946je8");
//        String op_1979je8     = request.getParameter("op_1979je8");
//        String op_1910je8     = request.getParameter("op_1910je8");
//        String op_1911je8     = request.getParameter("op_1911je8");
//        String op_1912je8     = request.getParameter("op_1912je8");
//        ymOutPovertyIncome = new YmOutPovertyIncome();
//        ymOutPovertyIncome.setJtbh(jtbh);
//        ymOutPovertyIncome.setPov_xtlb("08");
//        ymOutPovertyIncome.setPov_nf("2018");
//        ymOutPovertyIncome.setPov_yf13("");
//        ymOutPovertyIncome.setPov_yf46("");
//        ymOutPovertyIncome.setPov_yf79("");
//        ymOutPovertyIncome.setPov_yf10(op_1810je8);
//        ymOutPovertyIncome.setPov_yf11(op_1811je8);
//        ymOutPovertyIncome.setPov_yf12(op_1812je8);
//        ymOutPovertyIncomeList.add(ymOutPovertyIncome);
//
//        ymOutPovertyIncome = new YmOutPovertyIncome();
//        ymOutPovertyIncome.setJtbh(jtbh);
//        ymOutPovertyIncome.setPov_xtlb("08");
//        ymOutPovertyIncome.setPov_nf("2019");
//        ymOutPovertyIncome.setPov_yf13(op_1913je8);
//        ymOutPovertyIncome.setPov_yf46(op_1946je8);
//        ymOutPovertyIncome.setPov_yf79(op_1979je8);
//        ymOutPovertyIncome.setPov_yf10(op_1910je8);
//        ymOutPovertyIncome.setPov_yf11(op_1911je8);
//        ymOutPovertyIncome.setPov_yf12(op_1912je8);
//        ymOutPovertyIncomeList.add(ymOutPovertyIncome);
//
//        String op_1810je9     = request.getParameter("op_1810je9");
//        String op_1811je9     = request.getParameter("op_1811je9");
//        String op_1812je9     = request.getParameter("op_1812je9");
//        String op_1913je9     = request.getParameter("op_1913je9");
//        String op_1946je9     = request.getParameter("op_1946je9");
//        String op_1979je9     = request.getParameter("op_1979je9");
//        String op_1910je9     = request.getParameter("op_1910je9");
//        String op_1911je9     = request.getParameter("op_1911je9");
//        String op_1912je9     = request.getParameter("op_1912je9");
//        ymOutPovertyIncome = new YmOutPovertyIncome();
//        ymOutPovertyIncome.setJtbh(jtbh);
//        ymOutPovertyIncome.setPov_xtlb("09");
//        ymOutPovertyIncome.setPov_nf("2018");
//        ymOutPovertyIncome.setPov_yf13("");
//        ymOutPovertyIncome.setPov_yf46("");
//        ymOutPovertyIncome.setPov_yf79("");
//        ymOutPovertyIncome.setPov_yf10(op_1810je9);
//        ymOutPovertyIncome.setPov_yf11(op_1811je9);
//        ymOutPovertyIncome.setPov_yf12(op_1812je9);
//        ymOutPovertyIncomeList.add(ymOutPovertyIncome);
//
//        ymOutPovertyIncome = new YmOutPovertyIncome();
//        ymOutPovertyIncome.setJtbh(jtbh);
//        ymOutPovertyIncome.setPov_xtlb("09");
//        ymOutPovertyIncome.setPov_nf("2019");
//        ymOutPovertyIncome.setPov_yf13(op_1913je9);
//        ymOutPovertyIncome.setPov_yf46(op_1946je9);
//        ymOutPovertyIncome.setPov_yf79(op_1979je9);
//        ymOutPovertyIncome.setPov_yf10(op_1910je9);
//        ymOutPovertyIncome.setPov_yf11(op_1911je9);
//        ymOutPovertyIncome.setPov_yf12(op_1912je9);
//        ymOutPovertyIncomeList.add(ymOutPovertyIncome);
//
//        String op_1810je10    = request.getParameter("op_1810je10");
//        String op_1811je10    = request.getParameter("op_1811je10");
//        String op_1812je10    = request.getParameter("op_1812je10");
//        String op_1913je10    = request.getParameter("op_1913je10");
//        String op_1946je10    = request.getParameter("op_1946je10");
//        String op_1979je10    = request.getParameter("op_1979je10");
//        String op_1910je10    = request.getParameter("op_1910je10");
//        String op_1911je10    = request.getParameter("op_1911je10");
//        String op_1912je10    = request.getParameter("op_1912je10");
//        ymOutPovertyIncome = new YmOutPovertyIncome();
//        ymOutPovertyIncome.setJtbh(jtbh);
//        ymOutPovertyIncome.setPov_xtlb("10");
//        ymOutPovertyIncome.setPov_nf("2018");
//        ymOutPovertyIncome.setPov_yf13("");
//        ymOutPovertyIncome.setPov_yf46("");
//        ymOutPovertyIncome.setPov_yf79("");
//        ymOutPovertyIncome.setPov_yf10(op_1810je10);
//        ymOutPovertyIncome.setPov_yf11(op_1811je10);
//        ymOutPovertyIncome.setPov_yf12(op_1812je10);
//        ymOutPovertyIncomeList.add(ymOutPovertyIncome);
//
//        ymOutPovertyIncome = new YmOutPovertyIncome();
//        ymOutPovertyIncome.setJtbh(jtbh);
//        ymOutPovertyIncome.setPov_xtlb("10");
//        ymOutPovertyIncome.setPov_nf("2019");
//        ymOutPovertyIncome.setPov_yf13(op_1913je10);
//        ymOutPovertyIncome.setPov_yf46(op_1946je10);
//        ymOutPovertyIncome.setPov_yf79(op_1979je10);
//        ymOutPovertyIncome.setPov_yf10(op_1910je10);
//        ymOutPovertyIncome.setPov_yf11(op_1911je10);
//        ymOutPovertyIncome.setPov_yf12(op_1912je10);
//        ymOutPovertyIncomeList.add(ymOutPovertyIncome);
//
//        String op_1810je11    = request.getParameter("op_1810je11");
//        String op_1811je11    = request.getParameter("op_1811je11");
//        String op_1812je11    = request.getParameter("op_1812je11");
//        String op_1913je11    = request.getParameter("op_1913je11");
//        String op_1946je11    = request.getParameter("op_1946je11");
//        String op_1979je11    = request.getParameter("op_1979je11");
//        String op_1910je11    = request.getParameter("op_1910je11");
//        String op_1911je11    = request.getParameter("op_1911je11");
//        String op_1912je11    = request.getParameter("op_1912je11");
//        ymOutPovertyIncome = new YmOutPovertyIncome();
//        ymOutPovertyIncome.setJtbh(jtbh);
//        ymOutPovertyIncome.setPov_xtlb("11");
//        ymOutPovertyIncome.setPov_nf("2018");
//        ymOutPovertyIncome.setPov_yf13("");
//        ymOutPovertyIncome.setPov_yf46("");
//        ymOutPovertyIncome.setPov_yf79("");
//        ymOutPovertyIncome.setPov_yf10(op_1810je11);
//        ymOutPovertyIncome.setPov_yf11(op_1811je11);
//        ymOutPovertyIncome.setPov_yf12(op_1812je11);
//        ymOutPovertyIncomeList.add(ymOutPovertyIncome);
//
//        ymOutPovertyIncome = new YmOutPovertyIncome();
//        ymOutPovertyIncome.setJtbh(jtbh);
//        ymOutPovertyIncome.setPov_xtlb("11");
//        ymOutPovertyIncome.setPov_nf("2019");
//        ymOutPovertyIncome.setPov_yf13(op_1913je11);
//        ymOutPovertyIncome.setPov_yf46(op_1946je11);
//        ymOutPovertyIncome.setPov_yf79(op_1979je11);
//        ymOutPovertyIncome.setPov_yf10(op_1910je11);
//        ymOutPovertyIncome.setPov_yf11(op_1911je11);
//        ymOutPovertyIncome.setPov_yf12(op_1912je11);
//        ymOutPovertyIncomeList.add(ymOutPovertyIncome);
//
//        ymOutPovertyIncomeService.addYmOutPovertyIncomeMore(ymOutPovertyIncomeList);

        Map<String,Object> map = new HashMap<>();
        map.put("status",1);
        map.put("result","success");
        return map;
    }


}
