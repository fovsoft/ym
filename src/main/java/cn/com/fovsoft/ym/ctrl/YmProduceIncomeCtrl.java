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

        String sr_zzy_1810pz = request.getParameter("sr-zzy-1810pz");
        String sr_zzy_1811pz = request.getParameter("sr-zzy-1811pz");
        String sr_zzy_1812pz = request.getParameter("sr-zzy-1812pz");
        String sr_zzy_1913pz = request.getParameter("sr-zzy-1913pz");
        String sr_zzy_1946pz = request.getParameter("sr-zzy-1946pz");
        String sr_zzy_1979pz = request.getParameter("sr-zzy-1979pz");
        String sr_zzy_1910pz = request.getParameter("sr-zzy-1910pz");
        String sr_zzy_1911pz = request.getParameter("sr-zzy-1911pz");
        String sr_zzy_1912pz = request.getParameter("sr-zzy-1912pz");
        String sr_zzy_1810sl = request.getParameter("sr-zzy-1810sl");
        String sr_zzy_1811sl = request.getParameter("sr-zzy-1811sl");
        String sr_zzy_1812sl = request.getParameter("sr-zzy-1812sl");
        String sr_zzy_1913sl = request.getParameter("sr-zzy-1913sl");
        String sr_zzy_1946sl = request.getParameter("sr-zzy-1946sl");
        String sr_zzy_1979sl = request.getParameter("sr-zzy-1979sl");
        String sr_zzy_1910sl = request.getParameter("sr-zzy-1910sl");
        String sr_zzy_1911sl = request.getParameter("sr-zzy-1911sl");
        String sr_zzy_1912sl = request.getParameter("sr-zzy-1912sl");
        String sr_zzy_1810je = request.getParameter("sr-zzy-1810je");
        String sr_zzy_1811je = request.getParameter("sr-zzy-1811je");
        String sr_zzy_1812je = request.getParameter("sr-zzy-1812je");
        String sr_zzy_1913je = request.getParameter("sr-zzy-1913je");
        String sr_zzy_1946je = request.getParameter("sr-zzy-1946je");
        String sr_zzy_1979je = request.getParameter("sr-zzy-1979je");
        String sr_zzy_1910je = request.getParameter("sr-zzy-1910je");
        String sr_zzy_1911je = request.getParameter("sr-zzy-1911je");
        String sr_zzy_1912je = request.getParameter("sr-zzy-1912je");
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
        //收入其他信息
        String sr_qt_1810je = request.getParameter("sr-qt-1810je");
        String sr_qt_1811je = request.getParameter("sr-qt-1811je");
        String sr_qt_1812je = request.getParameter("sr-qt-1812je");
        String sr_qt_1913je = request.getParameter("sr-qt-1913je");
        String sr_qt_1946je = request.getParameter("sr-qt-1946je");
        String sr_qt_1979je = request.getParameter("sr-qt-1979je");
        String sr_qt_1910je = request.getParameter("sr-qt-1910je");
        String sr_qt_1911je = request.getParameter("sr-qt-1911je");
        String sr_qt_1912je = request.getParameter("sr-qt-1912je");

        //获取家庭编号信息
        String jtbh = request.getParameter("jtbh");
        List<YmProduceIncome> ymProduceIncomeList = new ArrayList();

        //写入2018年收入种植业品种信息
        YmProduceIncome ymProduceIncome = setYmProduceIncomeProperty(jtbh,"01","01","01","2018","","","",sr_zzy_1810pz,sr_zzy_1811pz,sr_zzy_1812pz);
        ymProduceIncomeList.add(ymProduceIncome);
        //写入2019年收入种植业品种信息
        ymProduceIncome = setYmProduceIncomeProperty(jtbh,"01","01","01","2019",sr_zzy_1913pz,sr_zzy_1946pz,sr_zzy_1979pz,sr_zzy_1910pz,sr_zzy_1911pz,sr_zzy_1912pz);
        ymProduceIncomeList.add(ymProduceIncome);
        //写入2018年收入种植业数量信息
        ymProduceIncome = setYmProduceIncomeProperty(jtbh,"01","01","02","2018","","","",sr_zzy_1810sl,sr_zzy_1811sl,sr_zzy_1812sl);
        ymProduceIncomeList.add(ymProduceIncome);
        //写入2019年收入种植业数量信息
        ymProduceIncome = setYmProduceIncomeProperty(jtbh,"01","01","02","2019",sr_zzy_1913sl,sr_zzy_1946sl,sr_zzy_1979sl,sr_zzy_1910sl,sr_zzy_1911sl,sr_zzy_1912sl);
        ymProduceIncomeList.add(ymProduceIncome);
        //写入2018年收入种植业金额信息
        ymProduceIncome = setYmProduceIncomeProperty(jtbh,"01","01","03","2018","","","",sr_zzy_1810je,sr_zzy_1811je,sr_zzy_1812je);
        ymProduceIncomeList.add(ymProduceIncome);
        //写入2019年收入种植业金额信息
        ymProduceIncome = setYmProduceIncomeProperty(jtbh,"01","01","03","2019",sr_zzy_1913je,sr_zzy_1946je,sr_zzy_1979je,sr_zzy_1910je,sr_zzy_1911je,sr_zzy_1912je);
        ymProduceIncomeList.add(ymProduceIncome);

        //写入2018年收入林业品种信息
        ymProduceIncome = setYmProduceIncomeProperty(jtbh,"01","02","01","2018","","","",sr_ly_1810pz,sr_ly_1811pz,sr_ly_1812pz);
        ymProduceIncomeList.add(ymProduceIncome);
        //写入2019年收入林业品种信息
        ymProduceIncome = setYmProduceIncomeProperty(jtbh,"01","02","01","2019",sr_ly_1913pz,sr_ly_1946pz,sr_ly_1979pz,sr_ly_1910pz,sr_ly_1911pz,sr_ly_1912pz);
        ymProduceIncomeList.add(ymProduceIncome);
        //写入2018年收入林业数量信息
        ymProduceIncome = setYmProduceIncomeProperty(jtbh,"01","02","02","2018","","","",sr_ly_1810sl,sr_ly_1811sl,sr_ly_1812sl);
        ymProduceIncomeList.add(ymProduceIncome);
        //写入2019年收入林业数量信息
        ymProduceIncome = setYmProduceIncomeProperty(jtbh,"01","02","02","2019",sr_ly_1913sl,sr_ly_1946sl,sr_ly_1979sl,sr_ly_1910sl,sr_ly_1911sl,sr_ly_1912sl);
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

        //写入2018年收入其他金额信息
        ymProduceIncome = setYmProduceIncomeProperty(jtbh,"01","03","03","2018","","","",sr_qt_1810je,sr_qt_1811je,sr_qt_1812je);
        ymProduceIncomeList.add(ymProduceIncome);
        //写入2019年收入其他金额信息
        ymProduceIncome = setYmProduceIncomeProperty(jtbh,"01","03","03","2019",sr_qt_1913je,sr_qt_1946je,sr_qt_1979je,sr_qt_1910je,sr_qt_1911je,sr_qt_1912je);
        ymProduceIncomeList.add(ymProduceIncome);



        String zc_zzy_1810pz = request.getParameter("zc-zzy-1810pz");
        String zc_zzy_1811pz = request.getParameter("zc-zzy-1811pz");
        String zc_zzy_1812pz = request.getParameter("zc-zzy-1812pz");
        String zc_zzy_1913pz = request.getParameter("zc-zzy-1913pz");
        String zc_zzy_1946pz = request.getParameter("zc-zzy-1946pz");
        String zc_zzy_1979pz = request.getParameter("zc-zzy-1979pz");
        String zc_zzy_1910pz = request.getParameter("zc-zzy-1910pz");
        String zc_zzy_1911pz = request.getParameter("zc-zzy-1911pz");
        String zc_zzy_1912pz = request.getParameter("zc-zzy-1912pz");
        String zc_zzy_1810sl = request.getParameter("zc-zzy-1810sl");
        String zc_zzy_1811sl = request.getParameter("zc-zzy-1811sl");
        String zc_zzy_1812sl = request.getParameter("zc-zzy-1812sl");
        String zc_zzy_1913sl = request.getParameter("zc-zzy-1913sl");
        String zc_zzy_1946sl = request.getParameter("zc-zzy-1946sl");
        String zc_zzy_1979sl = request.getParameter("zc-zzy-1979sl");
        String zc_zzy_1910sl = request.getParameter("zc-zzy-1910sl");
        String zc_zzy_1911sl = request.getParameter("zc-zzy-1911sl");
        String zc_zzy_1912sl = request.getParameter("zc-zzy-1912sl");
        String zc_zzy_1810je = request.getParameter("zc-zzy-1810je");
        String zc_zzy_1811je = request.getParameter("zc-zzy-1811je");
        String zc_zzy_1812je = request.getParameter("zc-zzy-1812je");
        String zc_zzy_1913je = request.getParameter("zc-zzy-1913je");
        String zc_zzy_1946je = request.getParameter("zc-zzy-1946je");
        String zc_zzy_1979je = request.getParameter("zc-zzy-1979je");
        String zc_zzy_1910je = request.getParameter("zc-zzy-1910je");
        String zc_zzy_1911je = request.getParameter("zc-zzy-1911je");
        String zc_zzy_1912je = request.getParameter("zc-zzy-1912je");
        //收入林业信息
        String zc_ly_1810pz = request.getParameter("zc-ly-1810pz");
        String zc_ly_1811pz = request.getParameter("zc-ly-1811pz");
        String zc_ly_1812pz = request.getParameter("zc-ly-1812pz");
        String zc_ly_1913pz = request.getParameter("zc-ly-1913pz");
        String zc_ly_1946pz = request.getParameter("zc-ly-1946pz");
        String zc_ly_1979pz = request.getParameter("zc-ly-1979pz");
        String zc_ly_1910pz = request.getParameter("zc-ly-1910pz");
        String zc_ly_1911pz = request.getParameter("zc-ly-1911pz");
        String zc_ly_1912pz = request.getParameter("zc-ly-1912pz");
        String zc_ly_1810sl = request.getParameter("zc-ly-1810sl");
        String zc_ly_1811sl = request.getParameter("zc-ly-1811sl");
        String zc_ly_1812sl = request.getParameter("zc-ly-1812sl");
        String zc_ly_1913sl = request.getParameter("zc-ly-1913sl");
        String zc_ly_1946sl = request.getParameter("zc-ly-1946sl");
        String zc_ly_1979sl = request.getParameter("zc-ly-1979sl");
        String zc_ly_1910sl = request.getParameter("zc-ly-1910sl");
        String zc_ly_1911sl = request.getParameter("zc-ly-1911sl");
        String zc_ly_1912sl = request.getParameter("zc-ly-1912sl");
        String zc_ly_1810je = request.getParameter("zc-ly-1810je");
        String zc_ly_1811je = request.getParameter("zc-ly-1811je");
        String zc_ly_1812je = request.getParameter("zc-ly-1812je");
        String zc_ly_1913je = request.getParameter("zc-ly-1913je");
        String zc_ly_1946je = request.getParameter("zc-ly-1946je");
        String zc_ly_1979je = request.getParameter("zc-ly-1979je");
        String zc_ly_1910je = request.getParameter("zc-ly-1910je");
        String zc_ly_1911je = request.getParameter("zc-ly-1911je");
        String zc_ly_1912je = request.getParameter("zc-ly-1912je");

        //收入养殖业信息
        String zc_yzy_1810pz = request.getParameter("zc-yzy-1810pz");
        String zc_yzy_1811pz = request.getParameter("zc-yzy-1811pz");
        String zc_yzy_1812pz = request.getParameter("zc-yzy-1812pz");
        String zc_yzy_1913pz = request.getParameter("zc-yzy-1913pz");
        String zc_yzy_1946pz = request.getParameter("zc-yzy-1946pz");
        String zc_yzy_1979pz = request.getParameter("zc-yzy-1979pz");
        String zc_yzy_1910pz = request.getParameter("zc-yzy-1910pz");
        String zc_yzy_1911pz = request.getParameter("zc-yzy-1911pz");
        String zc_yzy_1912pz = request.getParameter("zc-yzy-1912pz");
        String zc_yzy_1810sl = request.getParameter("zc-yzy-1810sl");
        String zc_yzy_1811sl = request.getParameter("zc-yzy-1811sl");
        String zc_yzy_1812sl = request.getParameter("zc-yzy-1812sl");
        String zc_yzy_1913sl = request.getParameter("zc-yzy-1913sl");
        String zc_yzy_1946sl = request.getParameter("zc-yzy-1946sl");
        String zc_yzy_1979sl = request.getParameter("zc-yzy-1979sl");
        String zc_yzy_1910sl = request.getParameter("zc-yzy-1910sl");
        String zc_yzy_1911sl = request.getParameter("zc-yzy-1911sl");
        String zc_yzy_1912sl = request.getParameter("zc-yzy-1912sl");
        String zc_yzy_1810je = request.getParameter("zc-yzy-1810je");
        String zc_yzy_1811je = request.getParameter("zc-yzy-1811je");
        String zc_yzy_1812je = request.getParameter("zc-yzy-1812je");
        String zc_yzy_1913je = request.getParameter("zc-yzy-1913je");
        String zc_yzy_1946je = request.getParameter("zc-yzy-1946je");
        String zc_yzy_1979je = request.getParameter("zc-yzy-1979je");
        String zc_yzy_1910je = request.getParameter("zc-yzy-1910je");
        String zc_yzy_1911je = request.getParameter("zc-yzy-1911je");
        String zc_yzy_1912je = request.getParameter("zc-yzy-1912je");
        //收入其他信息
        String zc_qt_1810je = request.getParameter("zc-qt-1810je");
        String zc_qt_1811je = request.getParameter("zc-qt-1811je");
        String zc_qt_1812je = request.getParameter("zc-qt-1812je");
        String zc_qt_1913je = request.getParameter("zc-qt-1913je");
        String zc_qt_1946je = request.getParameter("zc-qt-1946je");
        String zc_qt_1979je = request.getParameter("zc-qt-1979je");
        String zc_qt_1910je = request.getParameter("zc-qt-1910je");
        String zc_qt_1911je = request.getParameter("zc-qt-1911je");
        String zc_qt_1912je = request.getParameter("zc-qt-1912je");


        //写入2018年支出种植业品种信息
        ymProduceIncome = setYmProduceIncomeProperty(jtbh,"01","01","01","2018","","","",zc_zzy_1810pz,zc_zzy_1811pz,zc_zzy_1812pz);
        ymProduceIncomeList.add(ymProduceIncome);
        //写入2019年支出种植业品种信息
        ymProduceIncome = setYmProduceIncomeProperty(jtbh,"01","01","01","2019",zc_zzy_1913pz,zc_zzy_1946pz,zc_zzy_1979pz,zc_zzy_1910pz,zc_zzy_1911pz,zc_zzy_1912pz);
        ymProduceIncomeList.add(ymProduceIncome);
        //写入2018年支出种植业数量信息
        ymProduceIncome = setYmProduceIncomeProperty(jtbh,"01","01","02","2018","","","",zc_zzy_1810sl,zc_zzy_1811sl,zc_zzy_1812sl);
        ymProduceIncomeList.add(ymProduceIncome);
        //写入2019年支出种植业数量信息
        ymProduceIncome = setYmProduceIncomeProperty(jtbh,"01","01","02","2019",zc_zzy_1913sl,zc_zzy_1946sl,zc_zzy_1979sl,zc_zzy_1910sl,zc_zzy_1911sl,zc_zzy_1912sl);
        ymProduceIncomeList.add(ymProduceIncome);
        //写入2018年支出种植业金额信息
        ymProduceIncome = setYmProduceIncomeProperty(jtbh,"01","01","03","2018","","","",zc_zzy_1810je,zc_zzy_1811je,zc_zzy_1812je);
        ymProduceIncomeList.add(ymProduceIncome);
        //写入2019年支出种植业金额信息
        ymProduceIncome = setYmProduceIncomeProperty(jtbh,"01","01","03","2019",zc_zzy_1913je,zc_zzy_1946je,zc_zzy_1979je,zc_zzy_1910je,zc_zzy_1911je,zc_zzy_1912je);
        ymProduceIncomeList.add(ymProduceIncome);

        //写入2018年支出林业品种信息
        ymProduceIncome = setYmProduceIncomeProperty(jtbh,"01","02","01","2018","","","",zc_ly_1810pz,zc_ly_1811pz,zc_ly_1812pz);
        ymProduceIncomeList.add(ymProduceIncome);
        //写入2019年支出林业品种信息
        ymProduceIncome = setYmProduceIncomeProperty(jtbh,"01","02","01","2019",zc_ly_1913pz,zc_ly_1946pz,zc_ly_1979pz,zc_ly_1910pz,zc_ly_1911pz,zc_ly_1912pz);
        ymProduceIncomeList.add(ymProduceIncome);
        //写入2018年支出林业数量信息
        ymProduceIncome = setYmProduceIncomeProperty(jtbh,"01","02","02","2018","","","",zc_ly_1810sl,zc_ly_1811sl,zc_ly_1812sl);
        ymProduceIncomeList.add(ymProduceIncome);
        //写入2019年支出林业数量信息
        ymProduceIncome = setYmProduceIncomeProperty(jtbh,"01","02","02","2019",zc_ly_1913sl,zc_ly_1946sl,zc_ly_1979sl,zc_ly_1910sl,zc_ly_1911sl,zc_ly_1912sl);
        ymProduceIncomeList.add(ymProduceIncome);
        //写入2018年支出林业金额信息
        ymProduceIncome = setYmProduceIncomeProperty(jtbh,"01","02","03","2018","","","",zc_ly_1810je,zc_ly_1811je,zc_ly_1812je);
        ymProduceIncomeList.add(ymProduceIncome);
        //写入2019年支出林业金额信息
        ymProduceIncome = setYmProduceIncomeProperty(jtbh,"01","02","03","2019",zc_ly_1913je,zc_ly_1946je,zc_ly_1979je,zc_ly_1910je,zc_ly_1911je,zc_ly_1912je);
        ymProduceIncomeList.add(ymProduceIncome);

        //写入2018年支出养殖业品种信息
        ymProduceIncome = setYmProduceIncomeProperty(jtbh,"01","03","01","2018","","","",zc_yzy_1810pz,zc_yzy_1811pz,zc_yzy_1812pz);
        ymProduceIncomeList.add(ymProduceIncome);
        //写入2019年支出养殖业品种信息
        ymProduceIncome = setYmProduceIncomeProperty(jtbh,"01","03","01","2019",zc_yzy_1913pz,zc_yzy_1946pz,zc_yzy_1979pz,zc_yzy_1910pz,zc_yzy_1911pz,zc_yzy_1912pz);
        ymProduceIncomeList.add(ymProduceIncome);
        //写入2018年支出养殖业数量信息
        ymProduceIncome = setYmProduceIncomeProperty(jtbh,"01","03","02","2018","","","",zc_yzy_1810sl,zc_yzy_1811sl,zc_yzy_1812sl);
        ymProduceIncomeList.add(ymProduceIncome);
        //写入2019年支出养殖业数量信息
        ymProduceIncome = setYmProduceIncomeProperty(jtbh,"01","03","02","2019",zc_yzy_1913sl,zc_yzy_1946sl,zc_yzy_1979sl,zc_yzy_1910sl,zc_yzy_1911sl,zc_yzy_1912sl);
        ymProduceIncomeList.add(ymProduceIncome);
        //写入2018年支出养殖业金额信息
        ymProduceIncome = setYmProduceIncomeProperty(jtbh,"01","03","03","2018","","","",zc_yzy_1810je,zc_yzy_1811je,zc_yzy_1812je);
        ymProduceIncomeList.add(ymProduceIncome);
        //写入2019年支出养殖业金额信息
        ymProduceIncome = setYmProduceIncomeProperty(jtbh,"01","03","03","2019",zc_yzy_1913je,zc_yzy_1946je,zc_yzy_1979je,zc_yzy_1910je,zc_yzy_1911je,zc_yzy_1912je);
        ymProduceIncomeList.add(ymProduceIncome);

        //写入2018年支出其他金额信息
        ymProduceIncome = setYmProduceIncomeProperty(jtbh,"01","03","03","2018","","","",zc_qt_1810je,zc_qt_1811je,zc_qt_1812je);
        ymProduceIncomeList.add(ymProduceIncome);
        //写入2019年支出其他金额信息
        ymProduceIncome = setYmProduceIncomeProperty(jtbh,"01","03","03","2019",zc_qt_1913je,zc_qt_1946je,zc_qt_1979je,zc_qt_1910je,zc_qt_1911je,zc_qt_1912je);
        ymProduceIncomeList.add(ymProduceIncome);


        //底层写入
        ymProduceIncomeService.addYmProduceIncomeMore(ymProduceIncomeList);

        //返回信息
        Map<String,Object> map = new HashMap<>();
        map.put("status",1);
        map.put("result","success");
        return map;
    }

    public YmProduceIncome setYmProduceIncomeProperty(String jtbh,String xtdl,String xtxl1,String xtxl2,String nf,String yf13,String yf46,String yf79,String yf10,String yf11,String yf12){
        YmProduceIncome ymProduceIncome = new YmProduceIncome();
        ymProduceIncome.setJtbh(jtbh);
        ymProduceIncome.setXtdl(xtdl);
        ymProduceIncome.setXtxl1(xtxl1);
        ymProduceIncome.setXtxl2(xtxl2);
        ymProduceIncome.setNf(nf);
        ymProduceIncome.setYf13(yf13);
        ymProduceIncome.setYf46(yf46);
        ymProduceIncome.setYf79(yf79);
        ymProduceIncome.setYf10(yf10);
        ymProduceIncome.setYf11(yf11);
        ymProduceIncome.setYf12(yf12);
        return ymProduceIncome;
    }
}
