package cn.com.fovsoft.ym.ctrl;/*
 * Author:tpc
 * Date:2019-11-26 15:10:32
 * 功能描述:
 * version:
 */

import cn.com.fovsoft.common.util.CommonUtil;
import cn.com.fovsoft.ym.bean.YmIncomeSum;
import cn.com.fovsoft.ym.bean.YmSalaryIncome;
import cn.com.fovsoft.ym.service.YmIncomeSumService;
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

    @Autowired
    private YmIncomeSumService ymIncomeSumService;



    @RequestMapping("/salaryIncome/edit")
    @ResponseBody
    public Map<String,Object> editYmProduceIncomeMore(HttpServletRequest request){
        //获取家庭编号信息
        String jtbh = request.getParameter("jtbh");
        String year = request.getParameter("nf");
        List<YmSalaryIncome> ymSalaryIncomeList = getSalaryList(request,jtbh,year);
        //返回信息
        Map<String,Object> map = new HashMap<>();
        int status = 1;
        String result = "success";
        //先删除信息，再写入信息
        ymSalaryIncomeService.deleteYmSalaryIncomeByJtbhAndYear(jtbh,year);
        ymSalaryIncomeService.addYmSalaryIncomeMore(ymSalaryIncomeList);

        int index = ymSalaryIncomeList.size() -1;
        YmSalaryIncome ymSalaryIncome = ymSalaryIncomeList.get(index);
        int salary_count = CommonUtil.getStringInt(ymSalaryIncome.getSalary_yf1()) + CommonUtil.getStringInt(ymSalaryIncome.getSalary_yf2()) + CommonUtil.getStringInt(ymSalaryIncome.getSalary_yf3())
                + CommonUtil.getStringInt(ymSalaryIncome.getSalary_yf4())+ CommonUtil.getStringInt(ymSalaryIncome.getSalary_yf5())+ CommonUtil.getStringInt(ymSalaryIncome.getSalary_yf6())+ CommonUtil.getStringInt(ymSalaryIncome.getSalary_yf7())
                + CommonUtil.getStringInt(ymSalaryIncome.getSalary_yf8())+ CommonUtil.getStringInt(ymSalaryIncome.getSalary_yf9())+ CommonUtil.getStringInt(ymSalaryIncome.getSalary_yf10())+ CommonUtil.getStringInt(ymSalaryIncome.getSalary_yf11())
                + CommonUtil.getStringInt(ymSalaryIncome.getSalary_yf12());
        //修改记录
        String sql = "update ym_income_sum set sum_salary='"+salary_count+"' where jtbh='"+jtbh+"' and sum_nf='"+year+"' ";
        ymIncomeSumService.updateYmIncomeSumBySql(sql);

        map.put("status",status);
        map.put("result",result);
        return map;
    }




        @RequestMapping("/salaryIncome/add")
    @ResponseBody
    public Map<String,Object> addYmProduceIncomeMore(HttpServletRequest request){

        //获取表格数据
        String jtbh=request.getParameter("jtbh");
        String year = request.getParameter("nf");
        String rks = request.getParameter("rks");

        List<YmSalaryIncome> ymSalaryIncomeList = getSalaryList(request,jtbh,year);
        //返回信息
        Map<String,Object> map = new HashMap<>();
        int status = 1;
        String result = "success";

        int num = ymSalaryIncomeService.getCountByJtbhAndYear(jtbh,year);

        if(num>0){
            status = 0;
            result = "haveData";
        }else {
            ymSalaryIncomeService.addYmSalaryIncomeMore(ymSalaryIncomeList);

            //记录各个收入的记录
            YmIncomeSum ymIncomeSum = ymIncomeSumService.getYmIncomeSumByJtbhAndYear(jtbh,year);
            int index = ymSalaryIncomeList.size() -1;
            YmSalaryIncome ymSalaryIncome = ymSalaryIncomeList.get(index);
            int salary_count = CommonUtil.getStringInt(ymSalaryIncome.getSalary_yf1()) + CommonUtil.getStringInt(ymSalaryIncome.getSalary_yf2()) + CommonUtil.getStringInt(ymSalaryIncome.getSalary_yf3())
                    + CommonUtil.getStringInt(ymSalaryIncome.getSalary_yf4())+ CommonUtil.getStringInt(ymSalaryIncome.getSalary_yf5())+ CommonUtil.getStringInt(ymSalaryIncome.getSalary_yf6())+ CommonUtil.getStringInt(ymSalaryIncome.getSalary_yf7())
                    + CommonUtil.getStringInt(ymSalaryIncome.getSalary_yf8())+ CommonUtil.getStringInt(ymSalaryIncome.getSalary_yf9())+ CommonUtil.getStringInt(ymSalaryIncome.getSalary_yf10())+ CommonUtil.getStringInt(ymSalaryIncome.getSalary_yf11())
                    + CommonUtil.getStringInt(ymSalaryIncome.getSalary_yf12());

            //如果没有记录，则写入记录
            if(ymIncomeSum==null){
                ymIncomeSum = new YmIncomeSum();
                ymIncomeSum.setJtbh(jtbh);
                ymIncomeSum.setSum_nf(year);
                ymIncomeSum.setRks(rks);
                ymIncomeSum.setSum_produce("0");
                ymIncomeSum.setSum_produce1("0");
                ymIncomeSum.setSum_salary(Integer.toString(salary_count));
                ymIncomeSum.setSum_property("0");
                ymIncomeSum.setSum_transfer("0");
                ymIncomeSum.setSum_poverty("0");
                ymIncomeSumService.addYmIncomeSum(ymIncomeSum);
            }else{
                //修改记录
                String sql = "update ym_income_sum set sum_salary='"+salary_count+"' where jtbh='"+jtbh+"' and sum_nf='"+year+"' ";
                ymIncomeSumService.updateYmIncomeSumBySql(sql);
            }

        }

        map.put("status",status);
        map.put("result",result);
        return map;
    }

    private List<YmSalaryIncome> getSalaryList(HttpServletRequest request,String jtbh,String year){
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
        YmSalaryIncome ymSalaryIncome = null;
        if(!gz_xm1.equals("")){
            ymSalaryIncome = new YmSalaryIncome();
            ymSalaryIncome.setJtbh(jtbh);
            ymSalaryIncome.setXm(gz_xm1);
            ymSalaryIncome.setWggz(gz_gz1);
            ymSalaryIncome.setWgdz(gz_dz1);
            ymSalaryIncome.setWgljsj(gz_sj1);
            ymSalaryIncome.setWgqymc(gz_dw1);
            ymSalaryIncome.setSalary_nf(year);
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
        }


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
        if(!gz_xm2.equals("")){
            ymSalaryIncome = new YmSalaryIncome();
            ymSalaryIncome.setJtbh(jtbh);
            ymSalaryIncome.setXm(gz_xm2);
            ymSalaryIncome.setWggz(gz_gz2);
            ymSalaryIncome.setWgdz(gz_dz2);
            ymSalaryIncome.setWgljsj(gz_sj2);
            ymSalaryIncome.setWgqymc(gz_dw2);
            ymSalaryIncome.setSalary_nf(year);
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
        }


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
        if(!gz_xm3.equals("")){
            ymSalaryIncome = new YmSalaryIncome();
            ymSalaryIncome.setJtbh(jtbh);
            ymSalaryIncome.setXm(gz_xm3);
            ymSalaryIncome.setWggz(gz_gz3);
            ymSalaryIncome.setWgdz(gz_dz3);
            ymSalaryIncome.setWgljsj(gz_sj3);
            ymSalaryIncome.setWgqymc(gz_dw3);
            ymSalaryIncome.setSalary_nf(year);
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
        }



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
        if(!gz_xm4.equals("")){
            ymSalaryIncome = new YmSalaryIncome();
            ymSalaryIncome.setJtbh(jtbh);
            ymSalaryIncome.setXm(gz_xm4);
            ymSalaryIncome.setWggz(gz_gz4);
            ymSalaryIncome.setWgdz(gz_dz4);
            ymSalaryIncome.setWgljsj(gz_sj4);
            ymSalaryIncome.setWgqymc(gz_dw4);
            ymSalaryIncome.setSalary_nf(year);
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
        }

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
        if(!gz_xm5.equals("")){
            ymSalaryIncome = new YmSalaryIncome();
            ymSalaryIncome.setJtbh(jtbh);
            ymSalaryIncome.setXm(gz_xm5);
            ymSalaryIncome.setWggz(gz_gz5);
            ymSalaryIncome.setWgdz(gz_dz5);
            ymSalaryIncome.setWgljsj(gz_sj5);
            ymSalaryIncome.setWgqymc(gz_dw5);
            ymSalaryIncome.setSalary_nf(year);
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
        }


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
        ymSalaryIncome.setSalary_nf(year);
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
        ymSalaryIncome = new YmSalaryIncome();
        ymSalaryIncome.setJtbh(jtbh);
        ymSalaryIncome.setXm("00");
        ymSalaryIncome.setWggz("00");
        ymSalaryIncome.setWgdz("00");
        ymSalaryIncome.setWgljsj("00");
        ymSalaryIncome.setWgqymc("00");
        ymSalaryIncome.setSalary_nf(year);
        ymSalaryIncome.setSalary_yf1(salary_yf1_7);
        ymSalaryIncome.setSalary_yf2(salary_yf2_7);
        ymSalaryIncome.setSalary_yf3(salary_yf3_7);
        ymSalaryIncome.setSalary_yf4(salary_yf4_7);
        ymSalaryIncome.setSalary_yf5(salary_yf5_7);
        ymSalaryIncome.setSalary_yf6(salary_yf6_7);
        ymSalaryIncome.setSalary_yf7(salary_yf7_7);
        ymSalaryIncome.setSalary_yf8(salary_yf8_7);
        ymSalaryIncome.setSalary_yf9(salary_yf9_7);
        ymSalaryIncome.setSalary_yf10(salary_yf10_7);
        ymSalaryIncome.setSalary_yf11(salary_yf11_7);
        ymSalaryIncome.setSalary_yf12(salary_yf12_7);
        ymSalaryIncomeList.add(ymSalaryIncome);

        return ymSalaryIncomeList;
    }


}
