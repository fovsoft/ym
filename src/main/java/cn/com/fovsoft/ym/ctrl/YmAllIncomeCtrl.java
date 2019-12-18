package cn.com.fovsoft.ym.ctrl;/*
 * @Author:tpc
 * @Date: 2019/12/18 10:14
 * 功能描述:
 * @version:
 */

import cn.com.fovsoft.ym.bean.*;
import cn.com.fovsoft.ym.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
public class YmAllIncomeCtrl {

    @Autowired
    private YmProduceIncomeService ymProduceIncomeService;

    @Autowired
    private YmSalaryIncomeService ymSalaryIncomeService;

    @Autowired
    private YmPropertyIncomeService ymPropertyIncomeService;

    @Autowired
    private YmTransferIncomeService ymTransferIncomeService;

    @Autowired
    private YmOutPovertyIncomeService ymOutPovertyIncomeService;

    @Autowired
    private YmIncomeSumService ymIncomeSumService;


    @RequestMapping(value = "/allIncome/delete")
    @ResponseBody
    public Map<String,Object> deleteAllIncome(HttpServletRequest request){
        String jtbh = request.getParameter("jtbh");
        String year = request.getParameter("nf");
        ymProduceIncomeService.deleteYmProduceIncomeByJtbhAndYear(jtbh,year);
        ymSalaryIncomeService.deleteYmSalaryIncomeByJtbhAndYear(jtbh,year);
        ymPropertyIncomeService.deleteYmPropertyIncomeByJtbhAndYear(jtbh,year);
        ymTransferIncomeService.deleteYmTransferIncomeByJtbhAndYear(jtbh,year);
        ymOutPovertyIncomeService.deleteYmOutPovertyIncomeByJtbhAndYear(jtbh,year);

        YmIncomeSum ymIncomeSum = new YmIncomeSum();
        ymIncomeSum.setJtbh(jtbh);
        ymIncomeSum.setSum_nf(year);
        ymIncomeSum.setSum_produce("0");
        ymIncomeSum.setSum_produce1("0");
        ymIncomeSum.setSum_salary("0");
        ymIncomeSum.setSum_property("0");
        ymIncomeSum.setSum_transfer("0");
        ymIncomeSum.setSum_poverty("0");

        ymIncomeSumService.updateYmIncomeSumByJtbhAndYear(ymIncomeSum);

        Map<String,Object> map = new HashMap<>();
        int status = 1;
        String result = "success";
        map.put("status",status);
        map.put("result",result);
        return map;
    }



    @RequestMapping(value = "/allIncome/edit")
    @ResponseBody
    public Map<String,Object> viewPersonInfo(HttpServletRequest request){
        String jtbh = request.getParameter("jtbh");
        String year = request.getParameter("nf");
        //获取家庭指定年份的生产收入和支出记录
        List<YmProduceIncome> ymProduceIncomeList = ymProduceIncomeService.getProduceIncomeByJtbhAndYear(jtbh,year);
        //获取家庭指定年份工资收入记录
        List<YmSalaryIncome> ymSalaryIncomeList = ymSalaryIncomeService.getSalaryIncomeByJtbhAndYear(jtbh,year);
        //获取家庭指定年份财产收入记录
        List<YmPropertyIncome> ymPropertyIncomeList = ymPropertyIncomeService.getPropertyIncomeByJtbhAndYear(jtbh,year);
        //获取指定家庭年份转移收入记录
        List<YmTransferIncome> ymTransferIncomeList = ymTransferIncomeService.getTransferIncomeByJtbhAndYear(jtbh,year);
        //获取家庭指定年份不计入家庭收入记录
        List<YmOutPovertyIncome> ymOutPovertyIncomeList = ymOutPovertyIncomeService.getOutPovertyIncomeByJtbhAndYear(jtbh,year);

        Map<String,Object> map = new HashMap<>();
        int status = 1;
        String result = "success";
        map.put("ymProduceIncomeList",ymProduceIncomeList);
        map.put("ymSalaryIncomeList",ymSalaryIncomeList);
        map.put("ymPropertyIncomeList",ymPropertyIncomeList);
        map.put("ymTransferIncomeList",ymTransferIncomeList);
        map.put("ymOutPovertyIncomeList",ymOutPovertyIncomeList);
        map.put("status",status);
        map.put("result",result);
        return map;
    }
}
