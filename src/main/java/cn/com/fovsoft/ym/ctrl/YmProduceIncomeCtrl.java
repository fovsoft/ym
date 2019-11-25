package cn.com.fovsoft.ym.ctrl;/*
 * Author:tpc
 * Date:2019-11-25 16:17:52
 * 功能描述:生产收入和支出控制类
 * version:
 */


import cn.com.fovsoft.ym.bean.YmProduceIncome;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

@Controller
public class YmProduceIncomeCtrl {


    @RequestMapping("/produceIncome/add")
    @ResponseBody
    public void addYmProduceIncome(HttpServletRequest request){

        //收入林业信息
        String sr_ly_1810pz = request.getParameter("sr-ly-1810pz");
        String sr_ly_1811pz = request.getParameter("sr-ly-1811pz");
        String sr_ly_1812pz = request.getParameter("sr-ly-1812pz");
        String sr_ly_1913pz = request.getParameter("sr-ly-1913pz");
        String sr_ly_1946pz = request.getParameter("sr-ly-1946pz");
        String sr_ly_1979pz = request.getParameter("sr-ly-1979pz");
        String sr_ly_1910pz = request.getParameter("sr-ly-1910pz");
        String sr_ly_1911pz = request.getParameter("sr-ly-1911pz");
        String sr_ly_1912pz = request.getParameter("sr-ly-1912pz");
        String sr_ly_1810sl = request.getParameter("sr-ly-1810sl");
        String sr_ly_1811sl = request.getParameter("sr-ly-1811sl");
        String sr_ly_1812sl = request.getParameter("sr-ly-1812sl");
        String sr_ly_1913sl = request.getParameter("sr-ly-1913sl");
        String sr_ly_1946sl = request.getParameter("sr-ly-1946sl");
        String sr_ly_1979sl = request.getParameter("sr-ly-1979sl");
        String sr_ly_1910sl = request.getParameter("sr-ly-1910sl");
        String sr_ly_1911sl = request.getParameter("sr-ly-1911sl");
        String sr_ly_1912sl = request.getParameter("sr-ly-1912sl");
        String sr_ly_1810je = request.getParameter("sr-ly-1810je");
        String sr_ly_1811je = request.getParameter("sr-ly-1811je");
        String sr_ly_1812je = request.getParameter("sr-ly-1812je");
        String sr_ly_1913je = request.getParameter("sr-ly-1913je");
        String sr_ly_1946je = request.getParameter("sr-ly-1946je");
        String sr_ly_1979je = request.getParameter("sr-ly-1979je");
        String sr_ly_1910je = request.getParameter("sr-ly-1910je");
        String sr_ly_1911je = request.getParameter("sr-ly-1911je");
        String sr_ly_1912je = request.getParameter("sr-ly-1912je");

        //收入养殖业信息
        String sr_yzy_1810pz = request.getParameter("sr-yzy-1810pz");
        String sr_yzy_1811pz = request.getParameter("sr-yzy-1811pz");
        String sr_yzy_1812pz = request.getParameter("sr-yzy-1812pz");
        String sr_yzy_1913pz = request.getParameter("sr-yzy-1913pz");
        String sr_yzy_1946pz = request.getParameter("sr-yzy-1946pz");
        String sr_yzy_1979pz = request.getParameter("sr-yzy-1979pz");
        String sr_yzy_1910pz = request.getParameter("sr-yzy-1910pz");
        String sr_yzy_1911pz = request.getParameter("sr-yzy-1911pz");
        String sr_yzy_1912pz = request.getParameter("sr-yzy-1912pz");
        String sr_yzy_1810sl = request.getParameter("sr-yzy-1810sl");
        String sr_yzy_1811sl = request.getParameter("sr-yzy-1811sl");
        String sr_yzy_1812sl = request.getParameter("sr-yzy-1812sl");
        String sr_yzy_1913sl = request.getParameter("sr-yzy-1913sl");
        String sr_yzy_1946sl = request.getParameter("sr-yzy-1946sl");
        String sr_yzy_1979sl = request.getParameter("sr-yzy-1979sl");
        String sr_yzy_1910sl = request.getParameter("sr-yzy-1910sl");
        String sr_yzy_1911sl = request.getParameter("sr-yzy-1911sl");
        String sr_yzy_1912sl = request.getParameter("sr-yzy-1912sl");
        String sr_yzy_1810je = request.getParameter("sr-yzy-1810je");
        String sr_yzy_1811je = request.getParameter("sr-yzy-1811je");
        String sr_yzy_1812je = request.getParameter("sr-yzy-1812je");
        String sr_yzy_1913je = request.getParameter("sr-yzy-1913je");
        String sr_yzy_1946je = request.getParameter("sr-yzy-1946je");
        String sr_yzy_1979je = request.getParameter("sr-yzy-1979je");
        String sr_yzy_1910je = request.getParameter("sr-yzy-1910je");
        String sr_yzy_1911je = request.getParameter("sr-yzy-1911je");
        String sr_yzy_1912je = request.getParameter("sr-yzy-1912je");

        //获取家庭编号信息
        String jtbh = request.getParameter("jtbh");
        List<YmProduceIncome> ymProduceIncomeList = new ArrayList();

        //写入2018年收入林业品种信息
        YmProduceIncome ymProduceIncome = setYmProduceIncomeProperty(jtbh,"01","02","01","2018","","","",sr_ly_1810pz,sr_ly_1811pz,sr_ly_1812pz);
        ymProduceIncomeList.add(ymProduceIncome);
        //写入2019年收入林业品种信息
        ymProduceIncome = setYmProduceIncomeProperty(jtbh,"01","02","01","2019",sr_ly_1913pz,sr_ly_1946pz,sr_ly_1979pz,sr_ly_1910pz,sr_ly_1911pz,sr_ly_1912pz);
        ymProduceIncomeList.add(ymProduceIncome);
        //写入2018年收入林业数量信息
        ymProduceIncome = setYmProduceIncomeProperty(jtbh,"01","02","02","2018","","","",sr_ly_1810sl,sr_ly_1811sl,sr_ly_1812sl);
        ymProduceIncomeList.add(ymProduceIncome);
        //写入2019年收入林业数量信息
        ymProduceIncome = setYmProduceIncomeProperty(jtbh,"01","02","02","2019",sr_ly_1913sl,sr_yzy_1946sl,sr_ly_1979sl,sr_ly_1910sl,sr_ly_1911sl,sr_ly_1912sl);
        ymProduceIncomeList.add(ymProduceIncome);
        //写入2018年收入林业金额信息
        ymProduceIncome = setYmProduceIncomeProperty(jtbh,"01","02","03","2018","","","",sr_ly_1810je,sr_ly_1811je,sr_ly_1812je);
        ymProduceIncomeList.add(ymProduceIncome);
        //写入2019年收入林业金额信息
        ymProduceIncome = setYmProduceIncomeProperty(jtbh,"01","02","03","2019",sr_ly_1913je,sr_ly_1946je,sr_ly_1979je,sr_ly_1910je,sr_ly_1911je,sr_ly_1912je);
        ymProduceIncomeList.add(ymProduceIncome);

        //写入2018年收入养殖业品种信息
        ymProduceIncome = setYmProduceIncomeProperty(jtbh,"01","03","01","2018","","","",sr_yzy_1810pz,sr_yzy_1811pz,sr_yzy_1812pz);
        ymProduceIncomeList.add(ymProduceIncome);
        //写入2019年收入养殖业品种信息
        ymProduceIncome = setYmProduceIncomeProperty(jtbh,"01","03","01","2019",sr_yzy_1913pz,sr_yzy_1946pz,sr_yzy_1979pz,sr_yzy_1910pz,sr_yzy_1911pz,sr_yzy_1912pz);
        ymProduceIncomeList.add(ymProduceIncome);
        //写入2018年收入养殖业数量信息
        ymProduceIncome = setYmProduceIncomeProperty(jtbh,"01","03","02","2018","","","",sr_yzy_1810sl,sr_yzy_1811sl,sr_yzy_1812sl);
        ymProduceIncomeList.add(ymProduceIncome);
        //写入2019年收入养殖业数量信息
        ymProduceIncome = setYmProduceIncomeProperty(jtbh,"01","03","02","2019",sr_yzy_1913sl,sr_yzy_1946sl,sr_yzy_1979sl,sr_yzy_1910sl,sr_yzy_1911sl,sr_yzy_1912sl);
        ymProduceIncomeList.add(ymProduceIncome);
        //写入2018年收入养殖业金额信息
        ymProduceIncome = setYmProduceIncomeProperty(jtbh,"01","03","03","2018","","","",sr_yzy_1810je,sr_yzy_1811je,sr_yzy_1812je);
        ymProduceIncomeList.add(ymProduceIncome);
        //写入2019年收入养殖业金额信息
        ymProduceIncome = setYmProduceIncomeProperty(jtbh,"01","03","03","2019",sr_yzy_1913je,sr_yzy_1946je,sr_yzy_1979je,sr_yzy_1910je,sr_yzy_1911je,sr_yzy_1912je);
        ymProduceIncomeList.add(ymProduceIncome);
    }

    public YmProduceIncome setYmProduceIncomeProperty(String jtbh,String xtdl,String xtxl1,String xtxl2,String nf,String yf13,String yf46,String yf79,String yf10,String yf11,String yf12){
        YmProduceIncome ymProduceIncome = new YmProduceIncome();
        ymProduceIncome.setJtbh(jtbh);
        ymProduceIncome.setXtdl(xtdl);
        ymProduceIncome.setXtxl1(xtxl1);
        ymProduceIncome.setXtxl2(xtxl2);
        ymProduceIncome.setYf13(yf13);
        ymProduceIncome.setYf46(yf46);
        ymProduceIncome.setYf79(yf79);
        ymProduceIncome.setYf10(yf10);
        ymProduceIncome.setYf11(yf11);
        ymProduceIncome.setYf12(yf12);
        return ymProduceIncome;
    }
}
