package cn.com.fovsoft.ym.ctrl;

import cn.com.fovsoft.ym.bean.YmTransferIncome;
import cn.com.fovsoft.ym.service.YmTransferIncomeService;
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
 * @Date 2019/11/26 22:03
 * description:转移性收入控制类
 **/


@Controller
public class YmTransferIncomeCtrl {

    @Autowired
    private YmTransferIncomeService ymTransferIncomeService;


    @RequestMapping("/transferIncome/add")
    @ResponseBody
    public Map<String,Object> addYmTransferIncomeMore(HttpServletRequest request){

        //用来记录多个记录的list
        List<YmTransferIncome> ymTransferIncomeList = new ArrayList<>();

        String jtbh             = request.getParameter("jtbh");
        String zy_1810je1       = request.getParameter("zy_1810je1");
        String zy_1811je1       = request.getParameter("zy_1811je1");
        String zy_1812je1       = request.getParameter("zy_1812je1");
        String zy_1913je1       = request.getParameter("zy_1913je1");
        String zy_1946je1       = request.getParameter("zy_1946je1");
        String zy_1979je1       = request.getParameter("zy_1979je1");
        String zy_1910je1       = request.getParameter("zy_1910je1");
        String zy_1911je1       = request.getParameter("zy_1911je1");
        String zy_1912je1       = request.getParameter("zy_1912je1");
        YmTransferIncome ymTransferIncome = new YmTransferIncome();
        ymTransferIncome.setJtbh(jtbh);
        ymTransferIncome.setTra_xtlb("01");
        ymTransferIncome.setTra_nf("2018");
        ymTransferIncome.setTra_yf13("");
        ymTransferIncome.setTra_yf46("");
        ymTransferIncome.setTra_yf79("");
        ymTransferIncome.setTra_yf10(zy_1810je1);
        ymTransferIncome.setTra_yf11(zy_1811je1);
        ymTransferIncome.setTra_yf12(zy_1812je1);
        ymTransferIncomeList.add(ymTransferIncome);

        ymTransferIncome = new YmTransferIncome();
        ymTransferIncome.setJtbh(jtbh);
        ymTransferIncome.setTra_xtlb("01");
        ymTransferIncome.setTra_nf("2019");
        ymTransferIncome.setTra_yf13(zy_1913je1);
        ymTransferIncome.setTra_yf46(zy_1946je1);
        ymTransferIncome.setTra_yf79(zy_1979je1);
        ymTransferIncome.setTra_yf10(zy_1910je1);
        ymTransferIncome.setTra_yf11(zy_1911je1);
        ymTransferIncome.setTra_yf12(zy_1912je1);
        ymTransferIncomeList.add(ymTransferIncome);

        String zy_1810je2A      = request.getParameter("zy_1810je2A");
        String zy_1811je2A      = request.getParameter("zy_1811je2A");
        String zy_1812je2A      = request.getParameter("zy_1812je2A");
        String zy_1913je2A      = request.getParameter("zy_1913je2A");
        String zy_1946je2A      = request.getParameter("zy_1946je2A");
        String zy_1979je2A      = request.getParameter("zy_1979je2A");
        String zy_1910je2A      = request.getParameter("zy_1910je2A");
        String zy_1911je2A      = request.getParameter("zy_1911je2A");
        String zy_1912je2A      = request.getParameter("zy_1912je2A");
        ymTransferIncome = new YmTransferIncome();
        ymTransferIncome.setJtbh(jtbh);
        ymTransferIncome.setTra_xtlb("0201");
        ymTransferIncome.setTra_nf("2018");
        ymTransferIncome.setTra_yf13("");
        ymTransferIncome.setTra_yf46("");
        ymTransferIncome.setTra_yf79("");
        ymTransferIncome.setTra_yf10(zy_1810je2A);
        ymTransferIncome.setTra_yf11(zy_1811je2A);
        ymTransferIncome.setTra_yf12(zy_1812je2A);
        ymTransferIncomeList.add(ymTransferIncome);

        ymTransferIncome = new YmTransferIncome();
        ymTransferIncome.setJtbh(jtbh);
        ymTransferIncome.setTra_xtlb("0201");
        ymTransferIncome.setTra_nf("2019");
        ymTransferIncome.setTra_yf13(zy_1913je2A);
        ymTransferIncome.setTra_yf46(zy_1946je2A);
        ymTransferIncome.setTra_yf79(zy_1979je2A);
        ymTransferIncome.setTra_yf10(zy_1910je2A);
        ymTransferIncome.setTra_yf11(zy_1911je2A);
        ymTransferIncome.setTra_yf12(zy_1912je2A);
        ymTransferIncomeList.add(ymTransferIncome);

        String zy_1810je2B      = request.getParameter("zy_1810je2B");
        String zy_1811je2B      = request.getParameter("zy_1811je2B");
        String zy_1812je2B      = request.getParameter("zy_1812je2B");
        String zy_1913je2B      = request.getParameter("zy_1913je2B");
        String zy_1946je2B      = request.getParameter("zy_1946je2B");
        String zy_1979je2B      = request.getParameter("zy_1979je2B");
        String zy_1910je2B      = request.getParameter("zy_1910je2B");
        String zy_1911je2B      = request.getParameter("zy_1911je2B");
        String zy_1912je2B      = request.getParameter("zy_1912je2B");
        ymTransferIncome = new YmTransferIncome();
        ymTransferIncome.setJtbh(jtbh);
        ymTransferIncome.setTra_xtlb("0202");
        ymTransferIncome.setTra_nf("2018");
        ymTransferIncome.setTra_yf13("");
        ymTransferIncome.setTra_yf46("");
        ymTransferIncome.setTra_yf79("");
        ymTransferIncome.setTra_yf10(zy_1810je2B);
        ymTransferIncome.setTra_yf11(zy_1811je2B);
        ymTransferIncome.setTra_yf12(zy_1812je2B);
        ymTransferIncomeList.add(ymTransferIncome);

        ymTransferIncome = new YmTransferIncome();
        ymTransferIncome.setJtbh(jtbh);
        ymTransferIncome.setTra_xtlb("0202");
        ymTransferIncome.setTra_nf("2019");
        ymTransferIncome.setTra_yf13(zy_1913je2B);
        ymTransferIncome.setTra_yf46(zy_1946je2B);
        ymTransferIncome.setTra_yf79(zy_1979je2B);
        ymTransferIncome.setTra_yf10(zy_1910je2B);
        ymTransferIncome.setTra_yf11(zy_1911je2B);
        ymTransferIncome.setTra_yf12(zy_1912je2B);
        ymTransferIncomeList.add(ymTransferIncome);

        String zy_1810je2C      = request.getParameter("zy_1810je2C");
        String zy_1811je2C      = request.getParameter("zy_1811je2C");
        String zy_1812je2C      = request.getParameter("zy_1812je2C");
        String zy_1913je2C      = request.getParameter("zy_1913je2C");
        String zy_1946je2C      = request.getParameter("zy_1946je2C");
        String zy_1979je2C      = request.getParameter("zy_1979je2C");
        String zy_1910je2C      = request.getParameter("zy_1910je2C");
        String zy_1911je2C      = request.getParameter("zy_1911je2C");
        String zy_1912je2C      = request.getParameter("zy_1912je2C");
        ymTransferIncome = new YmTransferIncome();
        ymTransferIncome.setJtbh(jtbh);
        ymTransferIncome.setTra_xtlb("0203");
        ymTransferIncome.setTra_nf("2018");
        ymTransferIncome.setTra_yf13("");
        ymTransferIncome.setTra_yf46("");
        ymTransferIncome.setTra_yf79("");
        ymTransferIncome.setTra_yf10(zy_1810je2C);
        ymTransferIncome.setTra_yf11(zy_1811je2C);
        ymTransferIncome.setTra_yf12(zy_1812je2C);
        ymTransferIncomeList.add(ymTransferIncome);

        ymTransferIncome = new YmTransferIncome();
        ymTransferIncome.setJtbh(jtbh);
        ymTransferIncome.setTra_xtlb("0203");
        ymTransferIncome.setTra_nf("2019");
        ymTransferIncome.setTra_yf13(zy_1913je2C);
        ymTransferIncome.setTra_yf46(zy_1946je2C);
        ymTransferIncome.setTra_yf79(zy_1979je2C);
        ymTransferIncome.setTra_yf10(zy_1910je2C);
        ymTransferIncome.setTra_yf11(zy_1911je2C);
        ymTransferIncome.setTra_yf12(zy_1912je2C);
        ymTransferIncomeList.add(ymTransferIncome);

        String zy_1810je3       = request.getParameter("zy_1810je3");
        String zy_1811je3       = request.getParameter("zy_1811je3");
        String zy_1812je3       = request.getParameter("zy_1812je3");
        String zy_1913je3       = request.getParameter("zy_1913je3");
        String zy_1946je3       = request.getParameter("zy_1946je3");
        String zy_1979je3       = request.getParameter("zy_1979je3");
        String zy_1910je3       = request.getParameter("zy_1910je3");
        String zy_1911je3       = request.getParameter("zy_1911je3");
        String zy_1912je3       = request.getParameter("zy_1912je3");
        ymTransferIncome = new YmTransferIncome();
        ymTransferIncome.setJtbh(jtbh);
        ymTransferIncome.setTra_xtlb("03");
        ymTransferIncome.setTra_nf("2018");
        ymTransferIncome.setTra_yf13("");
        ymTransferIncome.setTra_yf46("");
        ymTransferIncome.setTra_yf79("");
        ymTransferIncome.setTra_yf10(zy_1810je3);
        ymTransferIncome.setTra_yf11(zy_1811je3);
        ymTransferIncome.setTra_yf12(zy_1812je3);
        ymTransferIncomeList.add(ymTransferIncome);

        ymTransferIncome = new YmTransferIncome();
        ymTransferIncome.setJtbh(jtbh);
        ymTransferIncome.setTra_xtlb("03");
        ymTransferIncome.setTra_nf("2019");
        ymTransferIncome.setTra_yf13(zy_1913je3);
        ymTransferIncome.setTra_yf46(zy_1946je3);
        ymTransferIncome.setTra_yf79(zy_1979je3);
        ymTransferIncome.setTra_yf10(zy_1910je3);
        ymTransferIncome.setTra_yf11(zy_1911je3);
        ymTransferIncome.setTra_yf12(zy_1912je3);
        ymTransferIncomeList.add(ymTransferIncome);

        String zy_1810je4       = request.getParameter("zy_1810je4");
        String zy_1811je4       = request.getParameter("zy_1811je4");
        String zy_1812je4       = request.getParameter("zy_1812je4");
        String zy_1913je4       = request.getParameter("zy_1913je4");
        String zy_1946je4       = request.getParameter("zy_1946je4");
        String zy_1979je4       = request.getParameter("zy_1979je4");
        String zy_1910je4       = request.getParameter("zy_1910je4");
        String zy_1911je4       = request.getParameter("zy_1911je4");
        String zy_1912je4       = request.getParameter("zy_1912je4");
        ymTransferIncome = new YmTransferIncome();
        ymTransferIncome.setJtbh(jtbh);
        ymTransferIncome.setTra_xtlb("04");
        ymTransferIncome.setTra_nf("2018");
        ymTransferIncome.setTra_yf13("");
        ymTransferIncome.setTra_yf46("");
        ymTransferIncome.setTra_yf79("");
        ymTransferIncome.setTra_yf10(zy_1810je4);
        ymTransferIncome.setTra_yf11(zy_1811je4);
        ymTransferIncome.setTra_yf12(zy_1812je4);
        ymTransferIncomeList.add(ymTransferIncome);

        ymTransferIncome = new YmTransferIncome();
        ymTransferIncome.setJtbh(jtbh);
        ymTransferIncome.setTra_xtlb("04");
        ymTransferIncome.setTra_nf("2019");
        ymTransferIncome.setTra_yf13(zy_1913je4);
        ymTransferIncome.setTra_yf46(zy_1946je4);
        ymTransferIncome.setTra_yf79(zy_1979je4);
        ymTransferIncome.setTra_yf10(zy_1910je4);
        ymTransferIncome.setTra_yf11(zy_1911je4);
        ymTransferIncome.setTra_yf12(zy_1912je4);
        ymTransferIncomeList.add(ymTransferIncome);

        String zy_1810je5       = request.getParameter("zy_1810je5");
        String zy_1811je5       = request.getParameter("zy_1811je5");
        String zy_1812je5       = request.getParameter("zy_1812je5");
        String zy_1913je5       = request.getParameter("zy_1913je5");
        String zy_1946je5       = request.getParameter("zy_1946je5");
        String zy_1979je5       = request.getParameter("zy_1979je5");
        String zy_1910je5       = request.getParameter("zy_1910je5");
        String zy_1911je5       = request.getParameter("zy_1911je5");
        String zy_1912je5       = request.getParameter("zy_1912je5");
        ymTransferIncome = new YmTransferIncome();
        ymTransferIncome.setJtbh(jtbh);
        ymTransferIncome.setTra_xtlb("05");
        ymTransferIncome.setTra_nf("2018");
        ymTransferIncome.setTra_yf13("");
        ymTransferIncome.setTra_yf46("");
        ymTransferIncome.setTra_yf79("");
        ymTransferIncome.setTra_yf10(zy_1810je5);
        ymTransferIncome.setTra_yf11(zy_1811je5);
        ymTransferIncome.setTra_yf12(zy_1812je5);
        ymTransferIncomeList.add(ymTransferIncome);

        ymTransferIncome = new YmTransferIncome();
        ymTransferIncome.setJtbh(jtbh);
        ymTransferIncome.setTra_xtlb("05");
        ymTransferIncome.setTra_nf("2019");
        ymTransferIncome.setTra_yf13(zy_1913je5);
        ymTransferIncome.setTra_yf46(zy_1946je5);
        ymTransferIncome.setTra_yf79(zy_1979je5);
        ymTransferIncome.setTra_yf10(zy_1910je5);
        ymTransferIncome.setTra_yf11(zy_1911je5);
        ymTransferIncome.setTra_yf12(zy_1912je5);
        ymTransferIncomeList.add(ymTransferIncome);

        String zy_1810je6       = request.getParameter("zy_1810je6");
        String zy_1811je6       = request.getParameter("zy_1811je6");
        String zy_1812je6       = request.getParameter("zy_1812je6");
        String zy_1913je6       = request.getParameter("zy_1913je6");
        String zy_1946je6       = request.getParameter("zy_1946je6");
        String zy_1979je6       = request.getParameter("zy_1979je6");
        String zy_1910je6       = request.getParameter("zy_1910je6");
        String zy_1911je6       = request.getParameter("zy_1911je6");
        String zy_1912je6       = request.getParameter("zy_1912je6");
        ymTransferIncome = new YmTransferIncome();
        ymTransferIncome.setJtbh(jtbh);
        ymTransferIncome.setTra_xtlb("06");
        ymTransferIncome.setTra_nf("2018");
        ymTransferIncome.setTra_yf13("");
        ymTransferIncome.setTra_yf46("");
        ymTransferIncome.setTra_yf79("");
        ymTransferIncome.setTra_yf10(zy_1810je6);
        ymTransferIncome.setTra_yf11(zy_1811je6);
        ymTransferIncome.setTra_yf12(zy_1812je6);
        ymTransferIncomeList.add(ymTransferIncome);

        ymTransferIncome = new YmTransferIncome();
        ymTransferIncome.setJtbh(jtbh);
        ymTransferIncome.setTra_xtlb("06");
        ymTransferIncome.setTra_nf("2019");
        ymTransferIncome.setTra_yf13(zy_1913je6);
        ymTransferIncome.setTra_yf46(zy_1946je6);
        ymTransferIncome.setTra_yf79(zy_1979je6);
        ymTransferIncome.setTra_yf10(zy_1910je6);
        ymTransferIncome.setTra_yf11(zy_1911je6);
        ymTransferIncome.setTra_yf12(zy_1912je6);
        ymTransferIncomeList.add(ymTransferIncome);

        String zy_1810je7       = request.getParameter("zy_1810je7");
        String zy_1811je7       = request.getParameter("zy_1811je7");
        String zy_1812je7       = request.getParameter("zy_1812je7");
        String zy_1913je7       = request.getParameter("zy_1913je7");
        String zy_1946je7       = request.getParameter("zy_1946je7");
        String zy_1979je7       = request.getParameter("zy_1979je7");
        String zy_1910je7       = request.getParameter("zy_1910je7");
        String zy_1911je7       = request.getParameter("zy_1911je7");
        String zy_1912je7       = request.getParameter("zy_1912je7");
        ymTransferIncome = new YmTransferIncome();
        ymTransferIncome.setJtbh(jtbh);
        ymTransferIncome.setTra_xtlb("07");
        ymTransferIncome.setTra_nf("2018");
        ymTransferIncome.setTra_yf13("");
        ymTransferIncome.setTra_yf46("");
        ymTransferIncome.setTra_yf79("");
        ymTransferIncome.setTra_yf10(zy_1810je7);
        ymTransferIncome.setTra_yf11(zy_1811je7);
        ymTransferIncome.setTra_yf12(zy_1812je7);
        ymTransferIncomeList.add(ymTransferIncome);

        ymTransferIncome = new YmTransferIncome();
        ymTransferIncome.setJtbh(jtbh);
        ymTransferIncome.setTra_xtlb("07");
        ymTransferIncome.setTra_nf("2019");
        ymTransferIncome.setTra_yf13(zy_1913je7);
        ymTransferIncome.setTra_yf46(zy_1946je7);
        ymTransferIncome.setTra_yf79(zy_1979je7);
        ymTransferIncome.setTra_yf10(zy_1910je7);
        ymTransferIncome.setTra_yf11(zy_1911je7);
        ymTransferIncome.setTra_yf12(zy_1912je7);
        ymTransferIncomeList.add(ymTransferIncome);

        String zy_1810je8       = request.getParameter("zy_1810je8");
        String zy_1811je8       = request.getParameter("zy_1811je8");
        String zy_1812je8       = request.getParameter("zy_1812je8");
        String zy_1913je8       = request.getParameter("zy_1913je8");
        String zy_1946je8       = request.getParameter("zy_1946je8");
        String zy_1979je8       = request.getParameter("zy_1979je8");
        String zy_1910je8       = request.getParameter("zy_1910je8");
        String zy_1911je8       = request.getParameter("zy_1911je8");
        String zy_1912je8       = request.getParameter("zy_1912je8");
        ymTransferIncome = new YmTransferIncome();
        ymTransferIncome.setJtbh(jtbh);
        ymTransferIncome.setTra_xtlb("08");
        ymTransferIncome.setTra_nf("2018");
        ymTransferIncome.setTra_yf13("");
        ymTransferIncome.setTra_yf46("");
        ymTransferIncome.setTra_yf79("");
        ymTransferIncome.setTra_yf10(zy_1810je8);
        ymTransferIncome.setTra_yf11(zy_1811je8);
        ymTransferIncome.setTra_yf12(zy_1812je8);
        ymTransferIncomeList.add(ymTransferIncome);

        ymTransferIncome = new YmTransferIncome();
        ymTransferIncome.setJtbh(jtbh);
        ymTransferIncome.setTra_xtlb("08");
        ymTransferIncome.setTra_nf("2019");
        ymTransferIncome.setTra_yf13(zy_1913je8);
        ymTransferIncome.setTra_yf46(zy_1946je8);
        ymTransferIncome.setTra_yf79(zy_1979je8);
        ymTransferIncome.setTra_yf10(zy_1910je8);
        ymTransferIncome.setTra_yf11(zy_1911je8);
        ymTransferIncome.setTra_yf12(zy_1912je8);
        ymTransferIncomeList.add(ymTransferIncome);

        String zy_1810je9       = request.getParameter("zy_1810je9");
        String zy_1811je9       = request.getParameter("zy_1811je9");
        String zy_1812je9       = request.getParameter("zy_1812je9");
        String zy_1913je9       = request.getParameter("zy_1913je9");
        String zy_1946je9       = request.getParameter("zy_1946je9");
        String zy_1979je9       = request.getParameter("zy_1979je9");
        String zy_1910je9       = request.getParameter("zy_1910je9");
        String zy_1911je9       = request.getParameter("zy_1911je9");
        String zy_1912je9       = request.getParameter("zy_1912je9");
        ymTransferIncome = new YmTransferIncome();
        ymTransferIncome.setJtbh(jtbh);
        ymTransferIncome.setTra_xtlb("09");
        ymTransferIncome.setTra_nf("2018");
        ymTransferIncome.setTra_yf13("");
        ymTransferIncome.setTra_yf46("");
        ymTransferIncome.setTra_yf79("");
        ymTransferIncome.setTra_yf10(zy_1810je9);
        ymTransferIncome.setTra_yf11(zy_1811je9);
        ymTransferIncome.setTra_yf12(zy_1812je9);
        ymTransferIncomeList.add(ymTransferIncome);

        ymTransferIncome = new YmTransferIncome();
        ymTransferIncome.setJtbh(jtbh);
        ymTransferIncome.setTra_xtlb("09");
        ymTransferIncome.setTra_nf("2019");
        ymTransferIncome.setTra_yf13(zy_1913je9);
        ymTransferIncome.setTra_yf46(zy_1946je9);
        ymTransferIncome.setTra_yf79(zy_1979je9);
        ymTransferIncome.setTra_yf10(zy_1910je9);
        ymTransferIncome.setTra_yf11(zy_1911je9);
        ymTransferIncome.setTra_yf12(zy_1912je9);
        ymTransferIncomeList.add(ymTransferIncome);

        String zy_1810je10      = request.getParameter("zy_1810je10");
        String zy_1811je10      = request.getParameter("zy_1811je10");
        String zy_1812je10      = request.getParameter("zy_1812je10");
        String zy_1913je10      = request.getParameter("zy_1913je10");
        String zy_1946je10      = request.getParameter("zy_1946je10");
        String zy_1979je10      = request.getParameter("zy_1979je10");
        String zy_1910je10      = request.getParameter("zy_1910je10");
        String zy_1911je10      = request.getParameter("zy_1911je10");
        String zy_1912je10      = request.getParameter("zy_1912je10");
        ymTransferIncome = new YmTransferIncome();
        ymTransferIncome.setJtbh(jtbh);
        ymTransferIncome.setTra_xtlb("10");
        ymTransferIncome.setTra_nf("2018");
        ymTransferIncome.setTra_yf13("");
        ymTransferIncome.setTra_yf46("");
        ymTransferIncome.setTra_yf79("");
        ymTransferIncome.setTra_yf10(zy_1810je10);
        ymTransferIncome.setTra_yf11(zy_1811je10);
        ymTransferIncome.setTra_yf12(zy_1812je10);
        ymTransferIncomeList.add(ymTransferIncome);

        ymTransferIncome = new YmTransferIncome();
        ymTransferIncome.setJtbh(jtbh);
        ymTransferIncome.setTra_xtlb("10");
        ymTransferIncome.setTra_nf("2019");
        ymTransferIncome.setTra_yf13(zy_1913je10);
        ymTransferIncome.setTra_yf46(zy_1946je10);
        ymTransferIncome.setTra_yf79(zy_1979je10);
        ymTransferIncome.setTra_yf10(zy_1910je10);
        ymTransferIncome.setTra_yf11(zy_1911je10);
        ymTransferIncome.setTra_yf12(zy_1912je10);
        ymTransferIncomeList.add(ymTransferIncome);


        ymTransferIncomeService.addYmTransferIncomeMore(ymTransferIncomeList);

        Map<String,Object> map = new HashMap<>();
        map.put("status",1);
        map.put("result","success");
        return map;
    }


}
