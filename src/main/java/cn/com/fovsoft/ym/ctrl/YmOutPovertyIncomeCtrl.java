package cn.com.fovsoft.ym.ctrl;

import cn.com.fovsoft.common.util.CommonUtil;
import cn.com.fovsoft.ym.bean.YmIncomeSum;
import cn.com.fovsoft.ym.bean.YmOutPovertyIncome;
import cn.com.fovsoft.ym.service.YmIncomeSumService;
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

    @Autowired
    private YmIncomeSumService ymIncomeSumService;


    @RequestMapping("/outPovertyIncome/edit")
    @ResponseBody
    public Map<String,Object> editYmOutPovertyIncomeMore(HttpServletRequest request){
        //获取家庭编号信息
        String jtbh = request.getParameter("jtbh");
        String year = request.getParameter("nf");
        List<YmOutPovertyIncome> ymOutPovertyIncomeList = getPovertyList(request,jtbh,year);
        //返回信息
        Map<String,Object> map = new HashMap<>();
        int status = 1;
        String result = "success";
        //先删除信息，再写入信息
        ymOutPovertyIncomeService.deleteYmOutPovertyIncomeByJtbhAndYear(jtbh,year);
        ymOutPovertyIncomeService.addYmOutPovertyIncomeMore(ymOutPovertyIncomeList);
        YmOutPovertyIncome ymOutPovertyIncome = ymOutPovertyIncomeList.get(11);
        int sum_poverty = CommonUtil.getStringInt(ymOutPovertyIncome.getPov_yf1()) + CommonUtil.getStringInt(ymOutPovertyIncome.getPov_yf2()) + CommonUtil.getStringInt(ymOutPovertyIncome.getPov_yf3())
                + CommonUtil.getStringInt(ymOutPovertyIncome.getPov_yf4())+ CommonUtil.getStringInt(ymOutPovertyIncome.getPov_yf5())+ CommonUtil.getStringInt(ymOutPovertyIncome.getPov_yf6())+ CommonUtil.getStringInt(ymOutPovertyIncome.getPov_yf7())
                + CommonUtil.getStringInt(ymOutPovertyIncome.getPov_yf8())+ CommonUtil.getStringInt(ymOutPovertyIncome.getPov_yf9())+ CommonUtil.getStringInt(ymOutPovertyIncome.getPov_yf10())+ CommonUtil.getStringInt(ymOutPovertyIncome.getPov_yf11())
                + CommonUtil.getStringInt(ymOutPovertyIncome.getPov_yf12());

        //修改记录
        String sql = "update ym_income_sum set sum_poverty='"+sum_poverty+"' where jtbh='"+jtbh+"' and sum_nf='"+year+"' ";
        ymIncomeSumService.updateYmIncomeSumBySql(sql);

        map.put("status",status);
        map.put("result",result);
        return map;
    }


    @RequestMapping("/outPovertyIncome/add")
    @ResponseBody
    public Map<String,Object> addYmOutPovertyIncomeMore(HttpServletRequest request){

        String jtbh           = request.getParameter("jtbh");
        String year           = request.getParameter("nf");

        List<YmOutPovertyIncome> ymOutPovertyIncomeList = getPovertyList(request,jtbh,year);


        String rks = request.getParameter("rks");

        //返回信息
        Map<String,Object> map = new HashMap<>();
        int status = 1;
        String result = "success";

        int num = ymOutPovertyIncomeService.getCountByJtbhAndYear(jtbh,year);

        if(num>0){
            status = 0;
            result = "haveData";
        }else {
            //底层写入
            ymOutPovertyIncomeService.addYmOutPovertyIncomeMore(ymOutPovertyIncomeList);
            YmIncomeSum ymIncomeSum = ymIncomeSumService.getYmIncomeSumByJtbhAndYear(jtbh,year);

            YmOutPovertyIncome ymOutPovertyIncome = ymOutPovertyIncomeList.get(11);
            int sum_poverty = CommonUtil.getStringInt(ymOutPovertyIncome.getPov_yf1()) + CommonUtil.getStringInt(ymOutPovertyIncome.getPov_yf2()) + CommonUtil.getStringInt(ymOutPovertyIncome.getPov_yf3())
                    + CommonUtil.getStringInt(ymOutPovertyIncome.getPov_yf4())+ CommonUtil.getStringInt(ymOutPovertyIncome.getPov_yf5())+ CommonUtil.getStringInt(ymOutPovertyIncome.getPov_yf6())+ CommonUtil.getStringInt(ymOutPovertyIncome.getPov_yf7())
                    + CommonUtil.getStringInt(ymOutPovertyIncome.getPov_yf8())+ CommonUtil.getStringInt(ymOutPovertyIncome.getPov_yf9())+ CommonUtil.getStringInt(ymOutPovertyIncome.getPov_yf10())+ CommonUtil.getStringInt(ymOutPovertyIncome.getPov_yf11())
                    + CommonUtil.getStringInt(ymOutPovertyIncome.getPov_yf12());

            //如果年度各项收入信息记录为空,则写入新记录，否则进行修改
            if(ymIncomeSum==null){
                ymIncomeSum = new YmIncomeSum();
                ymIncomeSum.setJtbh(jtbh);
                ymIncomeSum.setSum_nf(year);
                ymIncomeSum.setRks(rks);
                ymIncomeSum.setSum_produce("0");
                ymIncomeSum.setSum_produce1("0");
                ymIncomeSum.setSum_salary("0");
                ymIncomeSum.setSum_property("0");
                ymIncomeSum.setSum_transfer("0");
                ymIncomeSum.setSum_poverty(Integer.toString(sum_poverty));
                ymIncomeSumService.addYmIncomeSum(ymIncomeSum);
            }else{
                //修改记录
                String sql = "update ym_income_sum set sum_poverty='"+sum_poverty+"' where jtbh='"+jtbh+"' and sum_nf='"+year+"' ";
                ymIncomeSumService.updateYmIncomeSumBySql(sql);
            }

        }

        map.put("status",status);
        map.put("result",result);

        return map;
    }


    private List<YmOutPovertyIncome> getPovertyList(HttpServletRequest request,String jtbh,String year){
        //封装写入对象的list
        List<YmOutPovertyIncome> ymOutPovertyIncomeList = new ArrayList<>();
        String pov_yf1_1        = request.getParameter("pov_yf1_1");
        String pov_yf2_1        = request.getParameter("pov_yf2_1");
        String pov_yf3_1        = request.getParameter("pov_yf3_1");
        String pov_yf4_1        = request.getParameter("pov_yf4_1");
        String pov_yf5_1        = request.getParameter("pov_yf5_1");
        String pov_yf6_1        = request.getParameter("pov_yf6_1");
        String pov_yf7_1        = request.getParameter("pov_yf7_1");
        String pov_yf8_1        = request.getParameter("pov_yf8_1");
        String pov_yf9_1        = request.getParameter("pov_yf9_1");
        String pov_yf10_1       = request.getParameter("pov_yf10_1");
        String pov_yf11_1       = request.getParameter("pov_yf11_1");
        String pov_yf12_1       = request.getParameter("pov_yf12_1");
        YmOutPovertyIncome ymOutPovertyIncome = new YmOutPovertyIncome();
        ymOutPovertyIncome.setJtbh(jtbh);
        ymOutPovertyIncome.setPov_xtlb("01");
        ymOutPovertyIncome.setPov_nf(year);
        ymOutPovertyIncome.setPov_yf1(pov_yf1_1);
        ymOutPovertyIncome.setPov_yf2(pov_yf2_1);
        ymOutPovertyIncome.setPov_yf3(pov_yf3_1);
        ymOutPovertyIncome.setPov_yf4(pov_yf4_1);
        ymOutPovertyIncome.setPov_yf5(pov_yf5_1);
        ymOutPovertyIncome.setPov_yf6(pov_yf6_1);
        ymOutPovertyIncome.setPov_yf7(pov_yf7_1);
        ymOutPovertyIncome.setPov_yf8(pov_yf8_1);
        ymOutPovertyIncome.setPov_yf9(pov_yf9_1);
        ymOutPovertyIncome.setPov_yf10(pov_yf10_1);
        ymOutPovertyIncome.setPov_yf11(pov_yf11_1);
        ymOutPovertyIncome.setPov_yf12(pov_yf12_1);
        ymOutPovertyIncomeList.add(ymOutPovertyIncome);

        String pov_yf1_2        = request.getParameter("pov_yf1_2");
        String pov_yf2_2        = request.getParameter("pov_yf2_2");
        String pov_yf3_2        = request.getParameter("pov_yf3_2");
        String pov_yf4_2        = request.getParameter("pov_yf4_2");
        String pov_yf5_2        = request.getParameter("pov_yf5_2");
        String pov_yf6_2        = request.getParameter("pov_yf6_2");
        String pov_yf7_2        = request.getParameter("pov_yf7_2");
        String pov_yf8_2        = request.getParameter("pov_yf8_2");
        String pov_yf9_2        = request.getParameter("pov_yf9_2");
        String pov_yf10_2       = request.getParameter("pov_yf10_2");
        String pov_yf11_2       = request.getParameter("pov_yf11_2");
        String pov_yf12_2       = request.getParameter("pov_yf12_2");
        ymOutPovertyIncome = new YmOutPovertyIncome();
        ymOutPovertyIncome.setJtbh(jtbh);
        ymOutPovertyIncome.setPov_xtlb("02");
        ymOutPovertyIncome.setPov_nf(year);
        ymOutPovertyIncome.setPov_yf1(pov_yf1_2);
        ymOutPovertyIncome.setPov_yf2(pov_yf2_2);
        ymOutPovertyIncome.setPov_yf3(pov_yf3_2);
        ymOutPovertyIncome.setPov_yf4(pov_yf4_2);
        ymOutPovertyIncome.setPov_yf5(pov_yf5_2);
        ymOutPovertyIncome.setPov_yf6(pov_yf6_2);
        ymOutPovertyIncome.setPov_yf7(pov_yf7_2);
        ymOutPovertyIncome.setPov_yf8(pov_yf8_2);
        ymOutPovertyIncome.setPov_yf9(pov_yf9_2);
        ymOutPovertyIncome.setPov_yf10(pov_yf10_2);
        ymOutPovertyIncome.setPov_yf11(pov_yf11_2);
        ymOutPovertyIncome.setPov_yf12(pov_yf12_2);
        ymOutPovertyIncomeList.add(ymOutPovertyIncome);

        String pov_yf1_3        = request.getParameter("pov_yf1_3");
        String pov_yf2_3        = request.getParameter("pov_yf2_3");
        String pov_yf3_3        = request.getParameter("pov_yf3_3");
        String pov_yf4_3        = request.getParameter("pov_yf4_3");
        String pov_yf5_3        = request.getParameter("pov_yf5_3");
        String pov_yf6_3        = request.getParameter("pov_yf6_3");
        String pov_yf7_3        = request.getParameter("pov_yf7_3");
        String pov_yf8_3        = request.getParameter("pov_yf8_3");
        String pov_yf9_3        = request.getParameter("pov_yf9_3");
        String pov_yf10_3       = request.getParameter("pov_yf10_3");
        String pov_yf11_3       = request.getParameter("pov_yf11_3");
        String pov_yf12_3       = request.getParameter("pov_yf12_3");
        ymOutPovertyIncome = new YmOutPovertyIncome();
        ymOutPovertyIncome.setJtbh(jtbh);
        ymOutPovertyIncome.setPov_xtlb("03");
        ymOutPovertyIncome.setPov_nf(year);
        ymOutPovertyIncome.setPov_yf1(pov_yf1_3);
        ymOutPovertyIncome.setPov_yf2(pov_yf2_3);
        ymOutPovertyIncome.setPov_yf3(pov_yf3_3);
        ymOutPovertyIncome.setPov_yf4(pov_yf4_3);
        ymOutPovertyIncome.setPov_yf5(pov_yf5_3);
        ymOutPovertyIncome.setPov_yf6(pov_yf6_3);
        ymOutPovertyIncome.setPov_yf7(pov_yf7_3);
        ymOutPovertyIncome.setPov_yf8(pov_yf8_3);
        ymOutPovertyIncome.setPov_yf9(pov_yf9_3);
        ymOutPovertyIncome.setPov_yf10(pov_yf10_3);
        ymOutPovertyIncome.setPov_yf11(pov_yf11_3);
        ymOutPovertyIncome.setPov_yf12(pov_yf12_3);
        ymOutPovertyIncomeList.add(ymOutPovertyIncome);


        String pov_yf1_4        = request.getParameter("pov_yf1_4");
        String pov_yf2_4        = request.getParameter("pov_yf2_4");
        String pov_yf3_4        = request.getParameter("pov_yf3_4");
        String pov_yf4_4        = request.getParameter("pov_yf4_4");
        String pov_yf5_4        = request.getParameter("pov_yf5_4");
        String pov_yf6_4        = request.getParameter("pov_yf6_4");
        String pov_yf7_4        = request.getParameter("pov_yf7_4");
        String pov_yf8_4        = request.getParameter("pov_yf8_4");
        String pov_yf9_4        = request.getParameter("pov_yf9_4");
        String pov_yf10_4       = request.getParameter("pov_yf10_4");
        String pov_yf11_4       = request.getParameter("pov_yf11_4");
        String pov_yf12_4       = request.getParameter("pov_yf12_4");
        ymOutPovertyIncome = new YmOutPovertyIncome();
        ymOutPovertyIncome.setJtbh(jtbh);
        ymOutPovertyIncome.setPov_xtlb("01");
        ymOutPovertyIncome.setPov_nf(year);
        ymOutPovertyIncome.setPov_yf1(pov_yf1_4);
        ymOutPovertyIncome.setPov_yf2(pov_yf2_4);
        ymOutPovertyIncome.setPov_yf3(pov_yf3_4);
        ymOutPovertyIncome.setPov_yf4(pov_yf4_4);
        ymOutPovertyIncome.setPov_yf5(pov_yf5_4);
        ymOutPovertyIncome.setPov_yf6(pov_yf6_4);
        ymOutPovertyIncome.setPov_yf7(pov_yf7_4);
        ymOutPovertyIncome.setPov_yf8(pov_yf8_4);
        ymOutPovertyIncome.setPov_yf9(pov_yf9_4);
        ymOutPovertyIncome.setPov_yf10(pov_yf10_4);
        ymOutPovertyIncome.setPov_yf11(pov_yf11_4);
        ymOutPovertyIncome.setPov_yf12(pov_yf12_4);
        ymOutPovertyIncomeList.add(ymOutPovertyIncome);

        String pov_yf1_5        = request.getParameter("pov_yf1_5");
        String pov_yf2_5        = request.getParameter("pov_yf2_5");
        String pov_yf3_5        = request.getParameter("pov_yf3_5");
        String pov_yf4_5        = request.getParameter("pov_yf4_5");
        String pov_yf5_5        = request.getParameter("pov_yf5_5");
        String pov_yf6_5        = request.getParameter("pov_yf6_5");
        String pov_yf7_5        = request.getParameter("pov_yf7_5");
        String pov_yf8_5        = request.getParameter("pov_yf8_5");
        String pov_yf9_5        = request.getParameter("pov_yf9_5");
        String pov_yf10_5       = request.getParameter("pov_yf10_5");
        String pov_yf11_5       = request.getParameter("pov_yf11_5");
        String pov_yf12_5       = request.getParameter("pov_yf12_5");
        ymOutPovertyIncome = new YmOutPovertyIncome();
        ymOutPovertyIncome.setJtbh(jtbh);
        ymOutPovertyIncome.setPov_xtlb("05");
        ymOutPovertyIncome.setPov_nf(year);
        ymOutPovertyIncome.setPov_yf1(pov_yf1_5);
        ymOutPovertyIncome.setPov_yf2(pov_yf2_5);
        ymOutPovertyIncome.setPov_yf3(pov_yf3_5);
        ymOutPovertyIncome.setPov_yf4(pov_yf4_5);
        ymOutPovertyIncome.setPov_yf5(pov_yf5_5);
        ymOutPovertyIncome.setPov_yf6(pov_yf6_5);
        ymOutPovertyIncome.setPov_yf7(pov_yf7_5);
        ymOutPovertyIncome.setPov_yf8(pov_yf8_5);
        ymOutPovertyIncome.setPov_yf9(pov_yf9_5);
        ymOutPovertyIncome.setPov_yf10(pov_yf10_5);
        ymOutPovertyIncome.setPov_yf11(pov_yf11_5);
        ymOutPovertyIncome.setPov_yf12(pov_yf12_5);
        ymOutPovertyIncomeList.add(ymOutPovertyIncome);

        String pov_yf1_6        = request.getParameter("pov_yf1_6");
        String pov_yf2_6        = request.getParameter("pov_yf2_6");
        String pov_yf3_6        = request.getParameter("pov_yf3_6");
        String pov_yf4_6        = request.getParameter("pov_yf4_6");
        String pov_yf5_6        = request.getParameter("pov_yf5_6");
        String pov_yf6_6        = request.getParameter("pov_yf6_6");
        String pov_yf7_6        = request.getParameter("pov_yf7_6");
        String pov_yf8_6        = request.getParameter("pov_yf8_6");
        String pov_yf9_6        = request.getParameter("pov_yf9_6");
        String pov_yf10_6       = request.getParameter("pov_yf10_6");
        String pov_yf11_6       = request.getParameter("pov_yf11_6");
        String pov_yf12_6       = request.getParameter("pov_yf12_6");
        ymOutPovertyIncome = new YmOutPovertyIncome();
        ymOutPovertyIncome.setJtbh(jtbh);
        ymOutPovertyIncome.setPov_xtlb("06");
        ymOutPovertyIncome.setPov_nf(year);
        ymOutPovertyIncome.setPov_yf1(pov_yf1_6);
        ymOutPovertyIncome.setPov_yf2(pov_yf2_6);
        ymOutPovertyIncome.setPov_yf3(pov_yf3_6);
        ymOutPovertyIncome.setPov_yf4(pov_yf4_6);
        ymOutPovertyIncome.setPov_yf5(pov_yf5_6);
        ymOutPovertyIncome.setPov_yf6(pov_yf6_6);
        ymOutPovertyIncome.setPov_yf7(pov_yf7_6);
        ymOutPovertyIncome.setPov_yf8(pov_yf8_6);
        ymOutPovertyIncome.setPov_yf9(pov_yf9_6);
        ymOutPovertyIncome.setPov_yf10(pov_yf10_6);
        ymOutPovertyIncome.setPov_yf11(pov_yf11_6);
        ymOutPovertyIncome.setPov_yf12(pov_yf12_6);
        ymOutPovertyIncomeList.add(ymOutPovertyIncome);

        String pov_yf1_7        = request.getParameter("pov_yf1_7");
        String pov_yf2_7        = request.getParameter("pov_yf2_7");
        String pov_yf3_7        = request.getParameter("pov_yf3_7");
        String pov_yf4_7        = request.getParameter("pov_yf4_7");
        String pov_yf5_7        = request.getParameter("pov_yf5_7");
        String pov_yf6_7        = request.getParameter("pov_yf6_7");
        String pov_yf7_7        = request.getParameter("pov_yf7_7");
        String pov_yf8_7        = request.getParameter("pov_yf8_7");
        String pov_yf9_7        = request.getParameter("pov_yf9_7");
        String pov_yf10_7       = request.getParameter("pov_yf10_7");
        String pov_yf11_7       = request.getParameter("pov_yf11_7");
        String pov_yf12_7       = request.getParameter("pov_yf12_7");
        ymOutPovertyIncome = new YmOutPovertyIncome();
        ymOutPovertyIncome.setJtbh(jtbh);
        ymOutPovertyIncome.setPov_xtlb("07");
        ymOutPovertyIncome.setPov_nf(year);
        ymOutPovertyIncome.setPov_yf1(pov_yf1_7);
        ymOutPovertyIncome.setPov_yf2(pov_yf2_7);
        ymOutPovertyIncome.setPov_yf3(pov_yf3_7);
        ymOutPovertyIncome.setPov_yf4(pov_yf4_7);
        ymOutPovertyIncome.setPov_yf5(pov_yf5_7);
        ymOutPovertyIncome.setPov_yf6(pov_yf6_7);
        ymOutPovertyIncome.setPov_yf7(pov_yf7_7);
        ymOutPovertyIncome.setPov_yf8(pov_yf8_7);
        ymOutPovertyIncome.setPov_yf9(pov_yf9_7);
        ymOutPovertyIncome.setPov_yf10(pov_yf10_7);
        ymOutPovertyIncome.setPov_yf11(pov_yf11_7);
        ymOutPovertyIncome.setPov_yf12(pov_yf12_7);
        ymOutPovertyIncomeList.add(ymOutPovertyIncome);

        String pov_yf1_8        = request.getParameter("pov_yf1_8");
        String pov_yf2_8        = request.getParameter("pov_yf2_8");
        String pov_yf3_8        = request.getParameter("pov_yf3_8");
        String pov_yf4_8        = request.getParameter("pov_yf4_8");
        String pov_yf5_8        = request.getParameter("pov_yf5_8");
        String pov_yf6_8        = request.getParameter("pov_yf6_8");
        String pov_yf7_8        = request.getParameter("pov_yf7_8");
        String pov_yf8_8        = request.getParameter("pov_yf8_8");
        String pov_yf9_8        = request.getParameter("pov_yf9_8");
        String pov_yf10_8       = request.getParameter("pov_yf10_8");
        String pov_yf11_8       = request.getParameter("pov_yf11_8");
        String pov_yf12_8       = request.getParameter("pov_yf12_8");
        ymOutPovertyIncome = new YmOutPovertyIncome();
        ymOutPovertyIncome.setJtbh(jtbh);
        ymOutPovertyIncome.setPov_xtlb("08");
        ymOutPovertyIncome.setPov_nf(year);
        ymOutPovertyIncome.setPov_yf1(pov_yf1_8);
        ymOutPovertyIncome.setPov_yf2(pov_yf2_8);
        ymOutPovertyIncome.setPov_yf3(pov_yf3_8);
        ymOutPovertyIncome.setPov_yf4(pov_yf4_8);
        ymOutPovertyIncome.setPov_yf5(pov_yf5_8);
        ymOutPovertyIncome.setPov_yf6(pov_yf6_8);
        ymOutPovertyIncome.setPov_yf7(pov_yf7_8);
        ymOutPovertyIncome.setPov_yf8(pov_yf8_8);
        ymOutPovertyIncome.setPov_yf9(pov_yf9_8);
        ymOutPovertyIncome.setPov_yf10(pov_yf10_8);
        ymOutPovertyIncome.setPov_yf11(pov_yf11_8);
        ymOutPovertyIncome.setPov_yf12(pov_yf12_8);
        ymOutPovertyIncomeList.add(ymOutPovertyIncome);

        String pov_yf1_9        = request.getParameter("pov_yf1_9");
        String pov_yf2_9        = request.getParameter("pov_yf2_9");
        String pov_yf3_9        = request.getParameter("pov_yf3_9");
        String pov_yf4_9        = request.getParameter("pov_yf4_9");
        String pov_yf5_9        = request.getParameter("pov_yf5_9");
        String pov_yf6_9        = request.getParameter("pov_yf6_9");
        String pov_yf7_9        = request.getParameter("pov_yf7_9");
        String pov_yf8_9        = request.getParameter("pov_yf8_9");
        String pov_yf9_9        = request.getParameter("pov_yf9_9");
        String pov_yf10_9       = request.getParameter("pov_yf10_9");
        String pov_yf11_9       = request.getParameter("pov_yf11_9");
        String pov_yf12_9       = request.getParameter("pov_yf12_9");
        ymOutPovertyIncome = new YmOutPovertyIncome();
        ymOutPovertyIncome.setJtbh(jtbh);
        ymOutPovertyIncome.setPov_xtlb("09");
        ymOutPovertyIncome.setPov_nf(year);
        ymOutPovertyIncome.setPov_yf1(pov_yf1_9);
        ymOutPovertyIncome.setPov_yf2(pov_yf2_9);
        ymOutPovertyIncome.setPov_yf3(pov_yf3_9);
        ymOutPovertyIncome.setPov_yf4(pov_yf4_9);
        ymOutPovertyIncome.setPov_yf5(pov_yf5_9);
        ymOutPovertyIncome.setPov_yf6(pov_yf6_9);
        ymOutPovertyIncome.setPov_yf7(pov_yf7_9);
        ymOutPovertyIncome.setPov_yf8(pov_yf8_9);
        ymOutPovertyIncome.setPov_yf9(pov_yf9_9);
        ymOutPovertyIncome.setPov_yf10(pov_yf10_9);
        ymOutPovertyIncome.setPov_yf11(pov_yf11_9);
        ymOutPovertyIncome.setPov_yf12(pov_yf12_9);
        ymOutPovertyIncomeList.add(ymOutPovertyIncome);

        String pov_yf1_10       = request.getParameter("pov_yf1_10");
        String pov_yf2_10       = request.getParameter("pov_yf2_10");
        String pov_yf3_10       = request.getParameter("pov_yf3_10");
        String pov_yf4_10       = request.getParameter("pov_yf4_10");
        String pov_yf5_10       = request.getParameter("pov_yf5_10");
        String pov_yf6_10       = request.getParameter("pov_yf6_10");
        String pov_yf7_10       = request.getParameter("pov_yf7_10");
        String pov_yf8_10       = request.getParameter("pov_yf8_10");
        String pov_yf9_10       = request.getParameter("pov_yf9_10");
        String pov_yf10_10      = request.getParameter("pov_yf10_10");
        String pov_yf11_10      = request.getParameter("pov_yf11_10");
        String pov_yf12_10      = request.getParameter("pov_yf12_10");
        ymOutPovertyIncome = new YmOutPovertyIncome();
        ymOutPovertyIncome.setJtbh(jtbh);
        ymOutPovertyIncome.setPov_xtlb("10");
        ymOutPovertyIncome.setPov_nf(year);
        ymOutPovertyIncome.setPov_yf1(pov_yf1_10);
        ymOutPovertyIncome.setPov_yf2(pov_yf2_10);
        ymOutPovertyIncome.setPov_yf3(pov_yf3_10);
        ymOutPovertyIncome.setPov_yf4(pov_yf4_10);
        ymOutPovertyIncome.setPov_yf5(pov_yf5_10);
        ymOutPovertyIncome.setPov_yf6(pov_yf6_10);
        ymOutPovertyIncome.setPov_yf7(pov_yf7_10);
        ymOutPovertyIncome.setPov_yf8(pov_yf8_10);
        ymOutPovertyIncome.setPov_yf9(pov_yf9_10);
        ymOutPovertyIncome.setPov_yf10(pov_yf10_10);
        ymOutPovertyIncome.setPov_yf11(pov_yf11_10);
        ymOutPovertyIncome.setPov_yf12(pov_yf12_10);
        ymOutPovertyIncomeList.add(ymOutPovertyIncome);

        String pov_yf1_11       = request.getParameter("pov_yf1_11");
        String pov_yf2_11       = request.getParameter("pov_yf2_11");
        String pov_yf3_11       = request.getParameter("pov_yf3_11");
        String pov_yf4_11       = request.getParameter("pov_yf4_11");
        String pov_yf5_11       = request.getParameter("pov_yf5_11");
        String pov_yf6_11       = request.getParameter("pov_yf6_11");
        String pov_yf7_11       = request.getParameter("pov_yf7_11");
        String pov_yf8_11       = request.getParameter("pov_yf8_11");
        String pov_yf9_11       = request.getParameter("pov_yf9_11");
        String pov_yf10_11      = request.getParameter("pov_yf10_11");
        String pov_yf11_11      = request.getParameter("pov_yf11_11");
        String pov_yf12_11      = request.getParameter("pov_yf12_11");
        ymOutPovertyIncome = new YmOutPovertyIncome();
        ymOutPovertyIncome.setJtbh(jtbh);
        ymOutPovertyIncome.setPov_xtlb("11");
        ymOutPovertyIncome.setPov_nf(year);
        ymOutPovertyIncome.setPov_yf1(pov_yf1_11);
        ymOutPovertyIncome.setPov_yf2(pov_yf2_11);
        ymOutPovertyIncome.setPov_yf3(pov_yf3_11);
        ymOutPovertyIncome.setPov_yf4(pov_yf4_11);
        ymOutPovertyIncome.setPov_yf5(pov_yf5_11);
        ymOutPovertyIncome.setPov_yf6(pov_yf6_11);
        ymOutPovertyIncome.setPov_yf7(pov_yf7_11);
        ymOutPovertyIncome.setPov_yf8(pov_yf8_11);
        ymOutPovertyIncome.setPov_yf9(pov_yf9_11);
        ymOutPovertyIncome.setPov_yf10(pov_yf10_11);
        ymOutPovertyIncome.setPov_yf11(pov_yf11_11);
        ymOutPovertyIncome.setPov_yf12(pov_yf12_11);
        ymOutPovertyIncomeList.add(ymOutPovertyIncome);

        String pov_yf1_12       = request.getParameter("pov_yf1_12");
        String pov_yf2_12       = request.getParameter("pov_yf2_12");
        String pov_yf3_12       = request.getParameter("pov_yf3_12");
        String pov_yf4_12       = request.getParameter("pov_yf4_12");
        String pov_yf5_12       = request.getParameter("pov_yf5_12");
        String pov_yf6_12       = request.getParameter("pov_yf6_12");
        String pov_yf7_12       = request.getParameter("pov_yf7_12");
        String pov_yf8_12       = request.getParameter("pov_yf8_12");
        String pov_yf9_12       = request.getParameter("pov_yf9_12");
        String pov_yf10_12      = request.getParameter("pov_yf10_12");
        String pov_yf11_12      = request.getParameter("pov_yf11_12");
        String pov_yf12_12      = request.getParameter("pov_yf12_12");
        ymOutPovertyIncome = new YmOutPovertyIncome();
        ymOutPovertyIncome.setJtbh(jtbh);
        ymOutPovertyIncome.setPov_xtlb("12");
        ymOutPovertyIncome.setPov_nf(year);
        ymOutPovertyIncome.setPov_yf1(pov_yf1_12);
        ymOutPovertyIncome.setPov_yf2(pov_yf2_12);
        ymOutPovertyIncome.setPov_yf3(pov_yf3_12);
        ymOutPovertyIncome.setPov_yf4(pov_yf4_12);
        ymOutPovertyIncome.setPov_yf5(pov_yf5_12);
        ymOutPovertyIncome.setPov_yf6(pov_yf6_12);
        ymOutPovertyIncome.setPov_yf7(pov_yf7_12);
        ymOutPovertyIncome.setPov_yf8(pov_yf8_12);
        ymOutPovertyIncome.setPov_yf9(pov_yf9_12);
        ymOutPovertyIncome.setPov_yf10(pov_yf10_12);
        ymOutPovertyIncome.setPov_yf11(pov_yf11_12);
        ymOutPovertyIncome.setPov_yf12(pov_yf12_12);
        ymOutPovertyIncomeList.add(ymOutPovertyIncome);
        return ymOutPovertyIncomeList;
    }


}
