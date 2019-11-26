package cn.com.fovsoft.ym.ctrl;/*
 * Author:tpc
 * Date:2019-11-26 15:10:32
 * 功能描述:
 * version:
 */

import cn.com.fovsoft.ym.bean.YmSalaryIncome;
import cn.com.fovsoft.ym.service.YmSalaryIncomeService;
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
public class YmSalaryIncomeCtrl {

    @Autowired
    private YmSalaryIncomeService ymSalaryIncomeService;

    @RequestMapping("/salaryIncome/add")
    @ResponseBody
    public Map<String,Object> addYmProduceIncomeMore(HttpServletRequest request){

        //获取表格数据
        String jtbh=request.getParameter("jtbh");

        String gz_xm1=request.getParameter("gz_xm1");
        String gz_gz1=request.getParameter("gz_gz1");
        String gz_dz1=request.getParameter("gz_dz1");
        String gz_sj1=request.getParameter("gz_sj1");
        String gz_dw1=request.getParameter("gz_dw1");
        String gz_1810je1=request.getParameter("gz_1810je1");
        String gz_1811je1=request.getParameter("gz_1811je1");
        String gz_1812je1=request.getParameter("gz_1812je1");
        String gz_1913je1=request.getParameter("gz_1913je1");
        String gz_1946je1=request.getParameter("gz_1946je1");
        String gz_1979je1=request.getParameter("gz_1979je1");
        String gz_1910je1=request.getParameter("gz_1910je1");
        String gz_1911je1=request.getParameter("gz_1911je1");
        String gz_1912je1=request.getParameter("gz_1912je1");

        //用来记录多条记录的list
        List<YmSalaryIncome> ymSalaryIncomeList = new ArrayList<>();
        YmSalaryIncome ymSalaryIncome = new YmSalaryIncome();
        ymSalaryIncome.setJtbh(jtbh);
        ymSalaryIncome.setXm(gz_xm1);
        ymSalaryIncome.setWgdz(gz_dz1);
        ymSalaryIncome.setWggz(gz_gz1);
        ymSalaryIncome.setWgljsj(gz_sj1);
        ymSalaryIncome.setWgqymc(gz_dw1);
        ymSalaryIncome.setSa_nf("2018");
        ymSalaryIncome.setSa_yf13("");
        ymSalaryIncome.setSa_yf46("");
        ymSalaryIncome.setSa_yf79("");
        ymSalaryIncome.setSa_yf10(gz_1810je1);
        ymSalaryIncome.setSa_yf11(gz_1811je1);
        ymSalaryIncome.setSa_yf12(gz_1812je1);
        ymSalaryIncomeList.add(ymSalaryIncome);

        ymSalaryIncome = new YmSalaryIncome();
        ymSalaryIncome.setJtbh(jtbh);
        ymSalaryIncome.setXm(gz_xm1);
        ymSalaryIncome.setWgdz(gz_dz1);
        ymSalaryIncome.setWggz(gz_gz1);
        ymSalaryIncome.setWgljsj(gz_sj1);
        ymSalaryIncome.setWgqymc(gz_dw1);
        ymSalaryIncome.setSa_nf("2019");
        ymSalaryIncome.setSa_yf13(gz_1913je1);
        ymSalaryIncome.setSa_yf46(gz_1946je1);
        ymSalaryIncome.setSa_yf79(gz_1979je1);
        ymSalaryIncome.setSa_yf10(gz_1910je1);
        ymSalaryIncome.setSa_yf11(gz_1911je1);
        ymSalaryIncome.setSa_yf12(gz_1912je1);
        ymSalaryIncomeList.add(ymSalaryIncome);

        String gz_xm2=request.getParameter("gz_xm2");
        String gz_gz2=request.getParameter("gz_gz2");
        String gz_dz2=request.getParameter("gz_dz2");
        String gz_sj2=request.getParameter("gz_sj2");
        String gz_dw2=request.getParameter("gz_dw2");
        String gz_1810je2=request.getParameter("gz_1810je2");
        String gz_1811je2=request.getParameter("gz_1811je2");
        String gz_1812je2=request.getParameter("gz_1812je2");
        String gz_1913je2=request.getParameter("gz_1913je2");
        String gz_1946je2=request.getParameter("gz_1946je2");
        String gz_1979je2=request.getParameter("gz_1979je2");
        String gz_1910je2=request.getParameter("gz_1910je2");
        String gz_1911je2=request.getParameter("gz_1911je2");
        String gz_1912je2=request.getParameter("gz_1912je2");
        if(!gz_xm2.equals("")){
            ymSalaryIncome = new YmSalaryIncome();
            ymSalaryIncome.setJtbh(jtbh);
            ymSalaryIncome.setXm(gz_xm2);
            ymSalaryIncome.setWgdz(gz_dz2);
            ymSalaryIncome.setWggz(gz_gz2);
            ymSalaryIncome.setWgljsj(gz_sj2);
            ymSalaryIncome.setWgqymc(gz_dw2);
            ymSalaryIncome.setSa_nf("2018");
            ymSalaryIncome.setSa_yf13("");
            ymSalaryIncome.setSa_yf46("");
            ymSalaryIncome.setSa_yf79("");
            ymSalaryIncome.setSa_yf10(gz_1810je2);
            ymSalaryIncome.setSa_yf11(gz_1811je2);
            ymSalaryIncome.setSa_yf12(gz_1812je2);
            ymSalaryIncomeList.add(ymSalaryIncome);

            ymSalaryIncome = new YmSalaryIncome();
            ymSalaryIncome.setJtbh(jtbh);
            ymSalaryIncome.setXm(gz_xm2);
            ymSalaryIncome.setWgdz(gz_dz2);
            ymSalaryIncome.setWggz(gz_gz2);
            ymSalaryIncome.setWgljsj(gz_sj2);
            ymSalaryIncome.setWgqymc(gz_dw2);
            ymSalaryIncome.setSa_nf("2019");
            ymSalaryIncome.setSa_yf13(gz_1913je2);
            ymSalaryIncome.setSa_yf46(gz_1946je2);
            ymSalaryIncome.setSa_yf79(gz_1979je2);
            ymSalaryIncome.setSa_yf10(gz_1910je2);
            ymSalaryIncome.setSa_yf11(gz_1911je2);
            ymSalaryIncome.setSa_yf12(gz_1912je2);
            ymSalaryIncomeList.add(ymSalaryIncome);
        }


        String gz_xm3=request.getParameter("gz_xm3");
        String gz_gz3=request.getParameter("gz_gz3");
        String gz_dz3=request.getParameter("gz_dz3");
        String gz_sj3=request.getParameter("gz_sj3");
        String gz_dw3=request.getParameter("gz_dw3");
        String gz_1810je3=request.getParameter("gz_1810je3");
        String gz_1811je3=request.getParameter("gz_1811je3");
        String gz_1812je3=request.getParameter("gz_1812je3");
        String gz_1913je3=request.getParameter("gz_1913je3");
        String gz_1946je3=request.getParameter("gz_1946je3");
        String gz_1979je3=request.getParameter("gz_1979je3");
        String gz_1910je3=request.getParameter("gz_1910je3");
        String gz_1911je3=request.getParameter("gz_1911je3");
        String gz_1912je3=request.getParameter("gz_1912je3");
        if(!gz_xm3.equals("")){
            ymSalaryIncome = new YmSalaryIncome();
            ymSalaryIncome.setJtbh(jtbh);
            ymSalaryIncome.setXm(gz_xm3);
            ymSalaryIncome.setWgdz(gz_dz3);
            ymSalaryIncome.setWggz(gz_gz3);
            ymSalaryIncome.setWgljsj(gz_sj3);
            ymSalaryIncome.setWgqymc(gz_dw3);
            ymSalaryIncome.setSa_nf("2018");
            ymSalaryIncome.setSa_yf13("");
            ymSalaryIncome.setSa_yf46("");
            ymSalaryIncome.setSa_yf79("");
            ymSalaryIncome.setSa_yf10(gz_1810je3);
            ymSalaryIncome.setSa_yf11(gz_1811je3);
            ymSalaryIncome.setSa_yf12(gz_1812je3);
            ymSalaryIncomeList.add(ymSalaryIncome);

            ymSalaryIncome = new YmSalaryIncome();
            ymSalaryIncome.setJtbh(jtbh);
            ymSalaryIncome.setXm(gz_xm3);
            ymSalaryIncome.setWgdz(gz_dz3);
            ymSalaryIncome.setWggz(gz_gz3);
            ymSalaryIncome.setWgljsj(gz_sj3);
            ymSalaryIncome.setWgqymc(gz_dw3);
            ymSalaryIncome.setSa_nf("2019");
            ymSalaryIncome.setSa_yf13(gz_1913je3);
            ymSalaryIncome.setSa_yf46(gz_1946je3);
            ymSalaryIncome.setSa_yf79(gz_1979je3);
            ymSalaryIncome.setSa_yf10(gz_1910je3);
            ymSalaryIncome.setSa_yf11(gz_1911je3);
            ymSalaryIncome.setSa_yf12(gz_1912je3);
            ymSalaryIncomeList.add(ymSalaryIncome);
        }

        String gz_xm4=request.getParameter("gz_xm4");
        String gz_gz4=request.getParameter("gz_gz4");
        String gz_dz4=request.getParameter("gz_dz4");
        String gz_sj4=request.getParameter("gz_sj4");
        String gz_dw4=request.getParameter("gz_dw4");
        String gz_1810je4=request.getParameter("gz_1810je4");
        String gz_1811je4=request.getParameter("gz_1811je4");
        String gz_1812je4=request.getParameter("gz_1812je4");
        String gz_1913je4=request.getParameter("gz_1913je4");
        String gz_1946je4=request.getParameter("gz_1946je4");
        String gz_1979je4=request.getParameter("gz_1979je4");
        String gz_1910je4=request.getParameter("gz_1910je4");
        String gz_1911je4=request.getParameter("gz_1911je4");
        String gz_1912je4=request.getParameter("gz_1912je4");
        if (!gz_xm4.equals("")) {
            ymSalaryIncome = new YmSalaryIncome();
            ymSalaryIncome.setJtbh(jtbh);
            ymSalaryIncome.setXm(gz_xm4);
            ymSalaryIncome.setWgdz(gz_dz4);
            ymSalaryIncome.setWggz(gz_gz4);
            ymSalaryIncome.setWgljsj(gz_sj4);
            ymSalaryIncome.setWgqymc(gz_dw4);
            ymSalaryIncome.setSa_nf("2018");
            ymSalaryIncome.setSa_yf13("");
            ymSalaryIncome.setSa_yf46("");
            ymSalaryIncome.setSa_yf79("");
            ymSalaryIncome.setSa_yf10(gz_1810je4);
            ymSalaryIncome.setSa_yf11(gz_1811je4);
            ymSalaryIncome.setSa_yf12(gz_1812je4);
            ymSalaryIncomeList.add(ymSalaryIncome);

            ymSalaryIncome = new YmSalaryIncome();
            ymSalaryIncome.setJtbh(jtbh);
            ymSalaryIncome.setXm(gz_xm4);
            ymSalaryIncome.setWgdz(gz_dz4);
            ymSalaryIncome.setWggz(gz_gz4);
            ymSalaryIncome.setWgljsj(gz_sj4);
            ymSalaryIncome.setWgqymc(gz_dw4);
            ymSalaryIncome.setSa_nf("2019");
            ymSalaryIncome.setSa_yf13(gz_1913je4);
            ymSalaryIncome.setSa_yf46(gz_1946je4);
            ymSalaryIncome.setSa_yf79(gz_1979je4);
            ymSalaryIncome.setSa_yf10(gz_1910je4);
            ymSalaryIncome.setSa_yf11(gz_1911je4);
            ymSalaryIncome.setSa_yf12(gz_1912je4);
            ymSalaryIncomeList.add(ymSalaryIncome);
        }

        String gz_xm5=request.getParameter("gz_xm5");
        String gz_gz5=request.getParameter("gz_gz5");
        String gz_dz5=request.getParameter("gz_dz5");
        String gz_sj5=request.getParameter("gz_sj5");
        String gz_dw5=request.getParameter("gz_dw5");
        String gz_1810je5=request.getParameter("gz_1810je5");
        String gz_1811je5=request.getParameter("gz_1811je5");
        String gz_1812je5=request.getParameter("gz_1812je5");
        String gz_1913je5=request.getParameter("gz_1913je5");
        String gz_1946je5=request.getParameter("gz_1946je5");
        String gz_1979je5=request.getParameter("gz_1979je5");
        String gz_1910je5=request.getParameter("gz_1910je5");
        String gz_1911je5=request.getParameter("gz_1911je5");
        String gz_1912je5=request.getParameter("gz_1912je5");
        if(!gz_xm5.equals("")){
            ymSalaryIncome = new YmSalaryIncome();
            ymSalaryIncome.setJtbh(jtbh);
            ymSalaryIncome.setXm(gz_xm5);
            ymSalaryIncome.setWgdz(gz_dz5);
            ymSalaryIncome.setWggz(gz_gz5);
            ymSalaryIncome.setWgljsj(gz_sj5);
            ymSalaryIncome.setWgqymc(gz_dw5);
            ymSalaryIncome.setSa_nf("2018");
            ymSalaryIncome.setSa_yf13("");
            ymSalaryIncome.setSa_yf46("");
            ymSalaryIncome.setSa_yf79("");
            ymSalaryIncome.setSa_yf10(gz_1810je5);
            ymSalaryIncome.setSa_yf11(gz_1811je5);
            ymSalaryIncome.setSa_yf12(gz_1812je5);
            ymSalaryIncomeList.add(ymSalaryIncome);

            ymSalaryIncome = new YmSalaryIncome();
            ymSalaryIncome.setJtbh(jtbh);
            ymSalaryIncome.setXm(gz_xm5);
            ymSalaryIncome.setWgdz(gz_dz5);
            ymSalaryIncome.setWggz(gz_gz5);
            ymSalaryIncome.setWgljsj(gz_sj5);
            ymSalaryIncome.setWgqymc(gz_dw5);
            ymSalaryIncome.setSa_nf("2019");
            ymSalaryIncome.setSa_yf13(gz_1913je5);
            ymSalaryIncome.setSa_yf46(gz_1946je5);
            ymSalaryIncome.setSa_yf79(gz_1979je5);
            ymSalaryIncome.setSa_yf10(gz_1910je5);
            ymSalaryIncome.setSa_yf11(gz_1911je5);
            ymSalaryIncome.setSa_yf12(gz_1912je5);
            ymSalaryIncomeList.add(ymSalaryIncome);
        }


        String gz_1810je6=request.getParameter("gz_1810je6");
        String gz_1811je6=request.getParameter("gz_1811je6");
        String gz_1812je6=request.getParameter("gz_1812je6");
        String gz_1913je6=request.getParameter("gz_1913je6");
        String gz_1946je6=request.getParameter("gz_1946je6");
        String gz_1979je6=request.getParameter("gz_1979je6");
        String gz_1910je6=request.getParameter("gz_1910je6");
        String gz_1911je6=request.getParameter("gz_1911je6");
        String gz_1912je6=request.getParameter("gz_1912je6");
        ymSalaryIncome = new YmSalaryIncome();
        ymSalaryIncome.setJtbh(jtbh);
        ymSalaryIncome.setXm("other");
        ymSalaryIncome.setWgdz("other");
        ymSalaryIncome.setWggz("other");
        ymSalaryIncome.setWgljsj("other");
        ymSalaryIncome.setWgqymc("other");
        ymSalaryIncome.setSa_nf("2018");
        ymSalaryIncome.setSa_yf13("");
        ymSalaryIncome.setSa_yf46("");
        ymSalaryIncome.setSa_yf79("");
        ymSalaryIncome.setSa_yf10(gz_1810je6);
        ymSalaryIncome.setSa_yf11(gz_1811je6);
        ymSalaryIncome.setSa_yf12(gz_1812je6);
        ymSalaryIncomeList.add(ymSalaryIncome);

        ymSalaryIncome = new YmSalaryIncome();
        ymSalaryIncome.setJtbh(jtbh);
        ymSalaryIncome.setXm("other");
        ymSalaryIncome.setWgdz("other");
        ymSalaryIncome.setWggz("other");
        ymSalaryIncome.setWgljsj("other");
        ymSalaryIncome.setWgqymc("other");
        ymSalaryIncome.setSa_nf("2019");
        ymSalaryIncome.setSa_yf13(gz_1913je6);
        ymSalaryIncome.setSa_yf46(gz_1946je6);
        ymSalaryIncome.setSa_yf79(gz_1979je6);
        ymSalaryIncome.setSa_yf10(gz_1910je6);
        ymSalaryIncome.setSa_yf11(gz_1911je6);
        ymSalaryIncome.setSa_yf12(gz_1912je6);
        ymSalaryIncomeList.add(ymSalaryIncome);

        ymSalaryIncomeService.addYmSalaryIncomeMore(ymSalaryIncomeList);

        Map<String,Object> map = new HashMap<>();
        map.put("status",1);
        map.put("result","success");
        return map;
    }


}
