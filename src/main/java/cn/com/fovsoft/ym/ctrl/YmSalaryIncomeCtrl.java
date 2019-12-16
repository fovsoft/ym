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
        List<YmSalaryIncome> ymSalaryIncomeList = new ArrayList<>();

        String gz_xm1              = request.getParameter("gz_xm1");
        String gz_gz1              = request.getParameter("gz_gz1");
        String gz_dz1              = request.getParameter("gz_dz1");
        String gz_sj1              = request.getParameter("gz_sj1");
        String gz_dw1              = request.getParameter("gz_dw1");
        String salary_yf1_1        = request.getParameter("salary_yf1_1");
        String salary_yf2_1        = request.getParameter("salary_yf2_1");
        String salary_yf3_1        = request.getParameter("salary_yf3_1");
        String salary_yf4_1        = request.getParameter("salary_yf4_1");
        String salary_yf5_1        = request.getParameter("salary_yf5_1");
        String salary_yf6_1        = request.getParameter("salary_yf6_1");
        String salary_yf7_1        = request.getParameter("salary_yf7_1");
        String salary_yf8_1        = request.getParameter("salary_yf8_1");
        String salary_yf9_1        = request.getParameter("salary_yf9_1");
        String salary_yf10_1       = request.getParameter("salary_yf10_1");
        String salary_yf11_1       = request.getParameter("salary_yf11_1");
        String salary_yf12_1       = request.getParameter("salary_yf12_1");
        YmSalaryIncome ymSalaryIncome = new YmSalaryIncome();
        ymSalaryIncome.setJtbh(jtbh);
        ymSalaryIncome.setXm(gz_xm1);
        ymSalaryIncome.setWggz(gz_gz1);
        ymSalaryIncome.setWgdz(gz_dz1);
        ymSalaryIncome.setWgljsj(gz_sj1);
        ymSalaryIncome.setWgqymc(gz_dw1);
        ymSalaryIncome.setSalary_nf("2019");
        ymSalaryIncome.setSalary_yf1(salary_yf1_1);
        ymSalaryIncome.setSalary_yf2(salary_yf2_1);
        ymSalaryIncome.setSalary_yf3(salary_yf3_1);
        ymSalaryIncome.setSalary_yf4(salary_yf4_1);
        ymSalaryIncome.setSalary_yf5(salary_yf5_1);
        ymSalaryIncome.setSalary_yf6(salary_yf6_1);
        ymSalaryIncome.setSalary_yf7(salary_yf7_1);
        ymSalaryIncome.setSalary_yf8(salary_yf8_1);
        ymSalaryIncome.setSalary_yf9(salary_yf9_1);
        ymSalaryIncome.setSalary_yf10(salary_yf10_1);
        ymSalaryIncome.setSalary_yf11(salary_yf11_1);
        ymSalaryIncome.setSalary_yf12(salary_yf12_1);
        ymSalaryIncomeList.add(ymSalaryIncome);

        String gz_xm2              = request.getParameter("gz_xm2");
        String gz_gz2              = request.getParameter("gz_gz2");
        String gz_dz2              = request.getParameter("gz_dz2");
        String gz_sj2              = request.getParameter("gz_sj2");
        String gz_dw2              = request.getParameter("gz_dw2");
        String salary_yf1_2        = request.getParameter("salary_yf1_2");
        String salary_yf2_2        = request.getParameter("salary_yf2_2");
        String salary_yf3_2        = request.getParameter("salary_yf3_2");
        String salary_yf4_2        = request.getParameter("salary_yf4_2");
        String salary_yf5_2        = request.getParameter("salary_yf5_2");
        String salary_yf6_2        = request.getParameter("salary_yf6_2");
        String salary_yf7_2        = request.getParameter("salary_yf7_2");
        String salary_yf8_2        = request.getParameter("salary_yf8_2");
        String salary_yf9_2        = request.getParameter("salary_yf9_2");
        String salary_yf10_2       = request.getParameter("salary_yf10_2");
        String salary_yf11_2       = request.getParameter("salary_yf11_2");
        String salary_yf12_2       = request.getParameter("salary_yf12_2");
        ymSalaryIncome = new YmSalaryIncome();
        ymSalaryIncome.setJtbh(jtbh);
        ymSalaryIncome.setXm(gz_xm2);
        ymSalaryIncome.setWggz(gz_gz2);
        ymSalaryIncome.setWgdz(gz_dz2);
        ymSalaryIncome.setWgljsj(gz_sj2);
        ymSalaryIncome.setWgqymc(gz_dw2);
        ymSalaryIncome.setSalary_nf("2019");
        ymSalaryIncome.setSalary_yf1(salary_yf1_2);
        ymSalaryIncome.setSalary_yf2(salary_yf2_2);
        ymSalaryIncome.setSalary_yf3(salary_yf3_2);
        ymSalaryIncome.setSalary_yf4(salary_yf4_2);
        ymSalaryIncome.setSalary_yf5(salary_yf5_2);
        ymSalaryIncome.setSalary_yf6(salary_yf6_2);
        ymSalaryIncome.setSalary_yf7(salary_yf7_2);
        ymSalaryIncome.setSalary_yf8(salary_yf8_2);
        ymSalaryIncome.setSalary_yf9(salary_yf9_2);
        ymSalaryIncome.setSalary_yf10(salary_yf10_2);
        ymSalaryIncome.setSalary_yf11(salary_yf11_2);
        ymSalaryIncome.setSalary_yf12(salary_yf12_2);
        ymSalaryIncomeList.add(ymSalaryIncome);

        String gz_xm3              = request.getParameter("gz_xm3");
        String gz_gz3              = request.getParameter("gz_gz3");
        String gz_dz3              = request.getParameter("gz_dz3");
        String gz_sj3              = request.getParameter("gz_sj3");
        String gz_dw3              = request.getParameter("gz_dw3");
        String salary_yf1_3        = request.getParameter("salary_yf1_3");
        String salary_yf2_3        = request.getParameter("salary_yf2_3");
        String salary_yf3_3        = request.getParameter("salary_yf3_3");
        String salary_yf4_3        = request.getParameter("salary_yf4_3");
        String salary_yf5_3        = request.getParameter("salary_yf5_3");
        String salary_yf6_3        = request.getParameter("salary_yf6_3");
        String salary_yf7_3        = request.getParameter("salary_yf7_3");
        String salary_yf8_3        = request.getParameter("salary_yf8_3");
        String salary_yf9_3        = request.getParameter("salary_yf9_3");
        String salary_yf10_3       = request.getParameter("salary_yf10_3");
        String salary_yf11_3       = request.getParameter("salary_yf11_3");
        String salary_yf12_3       = request.getParameter("salary_yf12_3");
        ymSalaryIncome = new YmSalaryIncome();
        ymSalaryIncome.setJtbh(jtbh);
        ymSalaryIncome.setXm(gz_xm3);
        ymSalaryIncome.setWggz(gz_gz3);
        ymSalaryIncome.setWgdz(gz_dz3);
        ymSalaryIncome.setWgljsj(gz_sj3);
        ymSalaryIncome.setWgqymc(gz_dw3);
        ymSalaryIncome.setSalary_nf("2019");
        ymSalaryIncome.setSalary_yf1(salary_yf1_3);
        ymSalaryIncome.setSalary_yf2(salary_yf2_3);
        ymSalaryIncome.setSalary_yf3(salary_yf3_3);
        ymSalaryIncome.setSalary_yf4(salary_yf4_3);
        ymSalaryIncome.setSalary_yf5(salary_yf5_3);
        ymSalaryIncome.setSalary_yf6(salary_yf6_3);
        ymSalaryIncome.setSalary_yf7(salary_yf7_3);
        ymSalaryIncome.setSalary_yf8(salary_yf8_3);
        ymSalaryIncome.setSalary_yf9(salary_yf9_3);
        ymSalaryIncome.setSalary_yf10(salary_yf10_3);
        ymSalaryIncome.setSalary_yf11(salary_yf11_3);
        ymSalaryIncome.setSalary_yf12(salary_yf12_3);
        ymSalaryIncomeList.add(ymSalaryIncome);


        String gz_xm4              = request.getParameter("gz_xm4");
        String gz_gz4              = request.getParameter("gz_gz4");
        String gz_dz4              = request.getParameter("gz_dz4");
        String gz_sj4              = request.getParameter("gz_sj4");
        String gz_dw4              = request.getParameter("gz_dw4");
        String salary_yf1_4        = request.getParameter("salary_yf1_4");
        String salary_yf2_4        = request.getParameter("salary_yf2_4");
        String salary_yf3_4        = request.getParameter("salary_yf3_4");
        String salary_yf4_4        = request.getParameter("salary_yf4_4");
        String salary_yf5_4        = request.getParameter("salary_yf5_4");
        String salary_yf6_4        = request.getParameter("salary_yf6_4");
        String salary_yf7_4        = request.getParameter("salary_yf7_4");
        String salary_yf8_4        = request.getParameter("salary_yf8_4");
        String salary_yf9_4        = request.getParameter("salary_yf9_4");
        String salary_yf10_4       = request.getParameter("salary_yf10_4");
        String salary_yf11_4       = request.getParameter("salary_yf11_4");
        String salary_yf12_4       = request.getParameter("salary_yf12_4");
        ymSalaryIncome = new YmSalaryIncome();
        ymSalaryIncome.setJtbh(jtbh);
        ymSalaryIncome.setXm(gz_xm4);
        ymSalaryIncome.setWggz(gz_gz4);
        ymSalaryIncome.setWgdz(gz_dz4);
        ymSalaryIncome.setWgljsj(gz_sj4);
        ymSalaryIncome.setWgqymc(gz_dw4);
        ymSalaryIncome.setSalary_nf("2019");
        ymSalaryIncome.setSalary_yf1(salary_yf1_4);
        ymSalaryIncome.setSalary_yf2(salary_yf2_4);
        ymSalaryIncome.setSalary_yf3(salary_yf3_4);
        ymSalaryIncome.setSalary_yf4(salary_yf4_4);
        ymSalaryIncome.setSalary_yf5(salary_yf5_4);
        ymSalaryIncome.setSalary_yf6(salary_yf6_4);
        ymSalaryIncome.setSalary_yf7(salary_yf7_4);
        ymSalaryIncome.setSalary_yf8(salary_yf8_4);
        ymSalaryIncome.setSalary_yf9(salary_yf9_4);
        ymSalaryIncome.setSalary_yf10(salary_yf10_4);
        ymSalaryIncome.setSalary_yf11(salary_yf11_4);
        ymSalaryIncome.setSalary_yf12(salary_yf12_4);
        ymSalaryIncomeList.add(ymSalaryIncome);

        String gz_xm5              = request.getParameter("gz_xm5");
        String gz_gz5              = request.getParameter("gz_gz5");
        String gz_dz5              = request.getParameter("gz_dz5");
        String gz_sj5              = request.getParameter("gz_sj5");
        String gz_dw5              = request.getParameter("gz_dw5");
        String salary_yf1_5        = request.getParameter("salary_yf1_5");
        String salary_yf2_5        = request.getParameter("salary_yf2_5");
        String salary_yf3_5        = request.getParameter("salary_yf3_5");
        String salary_yf4_5        = request.getParameter("salary_yf4_5");
        String salary_yf5_5        = request.getParameter("salary_yf5_5");
        String salary_yf6_5        = request.getParameter("salary_yf6_5");
        String salary_yf7_5        = request.getParameter("salary_yf7_5");
        String salary_yf8_5        = request.getParameter("salary_yf8_5");
        String salary_yf9_5        = request.getParameter("salary_yf9_5");
        String salary_yf10_5       = request.getParameter("salary_yf10_5");
        String salary_yf11_5       = request.getParameter("salary_yf11_5");
        String salary_yf12_5       = request.getParameter("salary_yf12_5");
        ymSalaryIncome = new YmSalaryIncome();
        ymSalaryIncome.setJtbh(jtbh);
        ymSalaryIncome.setXm(gz_xm5);
        ymSalaryIncome.setWggz(gz_gz5);
        ymSalaryIncome.setWgdz(gz_dz5);
        ymSalaryIncome.setWgljsj(gz_sj5);
        ymSalaryIncome.setWgqymc(gz_dw5);
        ymSalaryIncome.setSalary_nf("2019");
        ymSalaryIncome.setSalary_yf1(salary_yf1_5);
        ymSalaryIncome.setSalary_yf2(salary_yf2_5);
        ymSalaryIncome.setSalary_yf3(salary_yf3_5);
        ymSalaryIncome.setSalary_yf4(salary_yf4_5);
        ymSalaryIncome.setSalary_yf5(salary_yf5_5);
        ymSalaryIncome.setSalary_yf6(salary_yf6_5);
        ymSalaryIncome.setSalary_yf7(salary_yf7_5);
        ymSalaryIncome.setSalary_yf8(salary_yf8_5);
        ymSalaryIncome.setSalary_yf9(salary_yf9_5);
        ymSalaryIncome.setSalary_yf10(salary_yf10_5);
        ymSalaryIncome.setSalary_yf11(salary_yf11_5);
        ymSalaryIncome.setSalary_yf12(salary_yf12_5);
        ymSalaryIncomeList.add(ymSalaryIncome);

        String salary_yf1_6        = request.getParameter("salary_yf1_6");
        String salary_yf2_6        = request.getParameter("salary_yf2_6");
        String salary_yf3_6        = request.getParameter("salary_yf3_6");
        String salary_yf4_6        = request.getParameter("salary_yf4_6");
        String salary_yf5_6        = request.getParameter("salary_yf5_6");
        String salary_yf6_6        = request.getParameter("salary_yf6_6");
        String salary_yf7_6        = request.getParameter("salary_yf7_6");
        String salary_yf8_6        = request.getParameter("salary_yf8_6");
        String salary_yf9_6        = request.getParameter("salary_yf9_6");
        String salary_yf10_6       = request.getParameter("salary_yf10_6");
        String salary_yf11_6       = request.getParameter("salary_yf11_6");
        String salary_yf12_6       = request.getParameter("salary_yf12_6");
        ymSalaryIncome = new YmSalaryIncome();
        ymSalaryIncome.setJtbh(jtbh);
        ymSalaryIncome.setXm("other");
        ymSalaryIncome.setWggz("other");
        ymSalaryIncome.setWgdz("other");
        ymSalaryIncome.setWgljsj("other");
        ymSalaryIncome.setWgqymc("other");
        ymSalaryIncome.setSalary_nf("2019");
        ymSalaryIncome.setSalary_yf1(salary_yf1_6);
        ymSalaryIncome.setSalary_yf2(salary_yf2_6);
        ymSalaryIncome.setSalary_yf3(salary_yf3_6);
        ymSalaryIncome.setSalary_yf4(salary_yf4_6);
        ymSalaryIncome.setSalary_yf5(salary_yf5_6);
        ymSalaryIncome.setSalary_yf6(salary_yf6_6);
        ymSalaryIncome.setSalary_yf7(salary_yf7_6);
        ymSalaryIncome.setSalary_yf8(salary_yf8_6);
        ymSalaryIncome.setSalary_yf9(salary_yf9_6);
        ymSalaryIncome.setSalary_yf10(salary_yf10_6);
        ymSalaryIncome.setSalary_yf11(salary_yf11_6);
        ymSalaryIncome.setSalary_yf12(salary_yf12_6);
        ymSalaryIncomeList.add(ymSalaryIncome);

        String salary_yf1_7        = request.getParameter("salary_yf1_7");
        String salary_yf2_7        = request.getParameter("salary_yf2_7");
        String salary_yf3_7        = request.getParameter("salary_yf3_7");
        String salary_yf4_7        = request.getParameter("salary_yf4_7");
        String salary_yf5_7        = request.getParameter("salary_yf5_7");
        String salary_yf6_7        = request.getParameter("salary_yf6_7");
        String salary_yf7_7        = request.getParameter("salary_yf7_7");
        String salary_yf8_7        = request.getParameter("salary_yf8_7");
        String salary_yf9_7        = request.getParameter("salary_yf9_7");
        String salary_yf10_7       = request.getParameter("salary_yf10_7");
        String salary_yf11_7       = request.getParameter("salary_yf11_7");
        String salary_yf12_7       = request.getParameter("salary_yf12_7");

        ymSalaryIncomeService.addYmSalaryIncomeMore(ymSalaryIncomeList);

        Map<String,Object> map = new HashMap<>();
        map.put("status",1);
        map.put("result","success");
        return map;
    }


}
