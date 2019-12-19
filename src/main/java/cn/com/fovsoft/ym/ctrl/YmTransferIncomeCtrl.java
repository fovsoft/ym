package cn.com.fovsoft.ym.ctrl;

import cn.com.fovsoft.common.util.CommonUtil;
import cn.com.fovsoft.ym.bean.YmIncomeSum;
import cn.com.fovsoft.ym.bean.YmTransferIncome;
import cn.com.fovsoft.ym.service.YmIncomeSumService;
import cn.com.fovsoft.ym.service.YmTransferIncomeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.persistence.criteria.CriteriaBuilder;
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

    @Autowired
    private YmIncomeSumService ymIncomeSumService;


    @RequestMapping("/transferIncome/edit")
    @ResponseBody
    public Map<String,Object> editYmTransferIncomeMore(HttpServletRequest request){
        //获取家庭编号信息
        String jtbh = request.getParameter("jtbh");
        String year = request.getParameter("nf");
        List<YmTransferIncome> ymTransferIncomeList = getTransferList(request,jtbh,year);
        //返回信息
        Map<String,Object> map = new HashMap<>();
        int status = 1;
        String result = "success";
        //先删除信息，再写入信息
        ymTransferIncomeService.deleteYmTransferIncomeByJtbhAndYear(jtbh,year);
        ymTransferIncomeService.addYmTransferIncomeMore(ymTransferIncomeList);

        YmTransferIncome ymTransferIncome = ymTransferIncomeList.get(11);
        //获取小计总收入
        int sum_transfer = CommonUtil.getStringInt(ymTransferIncome.getTra_yf1()) + CommonUtil.getStringInt(ymTransferIncome.getTra_yf2()) + CommonUtil.getStringInt(ymTransferIncome.getTra_yf3())
                + CommonUtil.getStringInt(ymTransferIncome.getTra_yf4())+ CommonUtil.getStringInt(ymTransferIncome.getTra_yf5())+ CommonUtil.getStringInt(ymTransferIncome.getTra_yf6())+ CommonUtil.getStringInt(ymTransferIncome.getTra_yf7())
                + CommonUtil.getStringInt(ymTransferIncome.getTra_yf8())+ CommonUtil.getStringInt(ymTransferIncome.getTra_yf9())+ CommonUtil.getStringInt(ymTransferIncome.getTra_yf10())+ CommonUtil.getStringInt(ymTransferIncome.getTra_yf11())
                + CommonUtil.getStringInt(ymTransferIncome.getTra_yf12());
        //修改记录
        String sql = "update ym_income_sum set sum_transfer='"+sum_transfer+"' where jtbh='"+jtbh+"' and sum_nf='"+year+"' ";
        ymIncomeSumService.updateYmIncomeSumBySql(sql);
        map.put("status",status);
        map.put("result",result);
        return map;
    }


    @RequestMapping("/transferIncome/add")
    @ResponseBody
    public Map<String,Object> addYmTransferIncomeMore(HttpServletRequest request){

        String jtbh             = request.getParameter("jtbh");
        String year = request.getParameter("nf");
        String rks = request.getParameter("rks");


        List<YmTransferIncome> ymTransferIncomeList = getTransferList(request,jtbh,year);
        //返回信息
        Map<String,Object> map = new HashMap<>();
        int status = 1;
        String result = "success";

        int num = ymTransferIncomeService.getCountByJtbhAndYear(jtbh,year);

        if(num>0){
            status = 0;
            result = "haveData";
        }else {
            ymTransferIncomeService.addYmTransferIncomeMore(ymTransferIncomeList);
            YmIncomeSum ymIncomeSum = ymIncomeSumService.getYmIncomeSumByJtbhAndYear(jtbh,year);

            YmTransferIncome ymTransferIncome = ymTransferIncomeList.get(11);
            //获取小计总收入
            int sum_transfer = CommonUtil.getStringInt(ymTransferIncome.getTra_yf1()) + CommonUtil.getStringInt(ymTransferIncome.getTra_yf2()) + CommonUtil.getStringInt(ymTransferIncome.getTra_yf3())
                    + CommonUtil.getStringInt(ymTransferIncome.getTra_yf4())+ CommonUtil.getStringInt(ymTransferIncome.getTra_yf5())+ CommonUtil.getStringInt(ymTransferIncome.getTra_yf6())+ CommonUtil.getStringInt(ymTransferIncome.getTra_yf7())
                    + CommonUtil.getStringInt(ymTransferIncome.getTra_yf8())+ CommonUtil.getStringInt(ymTransferIncome.getTra_yf9())+ CommonUtil.getStringInt(ymTransferIncome.getTra_yf10())+ CommonUtil.getStringInt(ymTransferIncome.getTra_yf11())
                    + CommonUtil.getStringInt(ymTransferIncome.getTra_yf12());

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
                ymIncomeSum.setSum_transfer(Integer.toString(sum_transfer));
                ymIncomeSum.setSum_poverty("0");
                ymIncomeSumService.addYmIncomeSum(ymIncomeSum);
            }else{
                //修改记录
                String sql = "update ym_income_sum set sum_transfer='"+sum_transfer+"' where jtbh='"+jtbh+"' and sum_nf='"+year+"' ";
                ymIncomeSumService.updateYmIncomeSumBySql(sql);
            }
        }

        map.put("status",status);
        map.put("result",result);
        return map;
    }

    private List<YmTransferIncome> getTransferList(HttpServletRequest request,String jtbh,String year){
        //用来记录多个记录的list
        List<YmTransferIncome> ymTransferIncomeList = new ArrayList<>();
        String tra_yf1_1          = request.getParameter("tra_yf1_1");
        String tra_yf2_1          = request.getParameter("tra_yf2_1");
        String tra_yf3_1          = request.getParameter("tra_yf3_1");
        String tra_yf4_1          = request.getParameter("tra_yf4_1");
        String tra_yf5_1          = request.getParameter("tra_yf5_1");
        String tra_yf6_1          = request.getParameter("tra_yf6_1");
        String tra_yf7_1          = request.getParameter("tra_yf7_1");
        String tra_yf8_1          = request.getParameter("tra_yf8_1");
        String tra_yf9_1          = request.getParameter("tra_yf9_1");
        String tra_yf10_1         = request.getParameter("tra_yf10_1");
        String tra_yf11_1         = request.getParameter("tra_yf11_1");
        String tra_yf12_1         = request.getParameter("tra_yf12_1");
        YmTransferIncome ymTransferIncome = new YmTransferIncome();
        ymTransferIncome.setJtbh(jtbh);
        ymTransferIncome.setTra_xtlb("01");
        ymTransferIncome.setTra_nf(year);
        ymTransferIncome.setTra_yf1(tra_yf1_1);
        ymTransferIncome.setTra_yf2(tra_yf2_1);
        ymTransferIncome.setTra_yf3(tra_yf3_1);
        ymTransferIncome.setTra_yf4(tra_yf4_1);
        ymTransferIncome.setTra_yf5(tra_yf5_1);
        ymTransferIncome.setTra_yf6(tra_yf6_1);
        ymTransferIncome.setTra_yf7(tra_yf7_1);
        ymTransferIncome.setTra_yf8(tra_yf8_1);
        ymTransferIncome.setTra_yf9(tra_yf9_1);
        ymTransferIncome.setTra_yf10(tra_yf10_1);
        ymTransferIncome.setTra_yf11(tra_yf11_1);
        ymTransferIncome.setTra_yf12(tra_yf12_1);
        ymTransferIncomeList.add(ymTransferIncome);


        String tra_yf1_2          = request.getParameter("tra_yf1_2");
        String tra_yf2_2          = request.getParameter("tra_yf2_2");
        String tra_yf3_2          = request.getParameter("tra_yf3_2");
        String tra_yf4_2          = request.getParameter("tra_yf4_2");
        String tra_yf5_2          = request.getParameter("tra_yf5_2");
        String tra_yf6_2          = request.getParameter("tra_yf6_2");
        String tra_yf7_2          = request.getParameter("tra_yf7_2");
        String tra_yf8_2          = request.getParameter("tra_yf8_2");
        String tra_yf9_2          = request.getParameter("tra_yf9_2");
        String tra_yf10_2         = request.getParameter("tra_yf10_2");
        String tra_yf11_2         = request.getParameter("tra_yf11_2");
        String tra_yf12_2         = request.getParameter("tra_yf12_2");
        ymTransferIncome = new YmTransferIncome();
        ymTransferIncome.setJtbh(jtbh);
        ymTransferIncome.setTra_xtlb("0201");
        ymTransferIncome.setTra_nf(year);
        ymTransferIncome.setTra_yf1(tra_yf1_2);
        ymTransferIncome.setTra_yf2(tra_yf2_2);
        ymTransferIncome.setTra_yf3(tra_yf3_2);
        ymTransferIncome.setTra_yf4(tra_yf4_2);
        ymTransferIncome.setTra_yf5(tra_yf5_2);
        ymTransferIncome.setTra_yf6(tra_yf6_2);
        ymTransferIncome.setTra_yf7(tra_yf7_2);
        ymTransferIncome.setTra_yf8(tra_yf8_2);
        ymTransferIncome.setTra_yf9(tra_yf9_2);
        ymTransferIncome.setTra_yf10(tra_yf10_2);
        ymTransferIncome.setTra_yf11(tra_yf11_2);
        ymTransferIncome.setTra_yf12(tra_yf12_2);
        ymTransferIncomeList.add(ymTransferIncome);

        String tra_yf1_2b         = request.getParameter("tra_yf1_2b");
        String tra_yf2_2b         = request.getParameter("tra_yf2_2b");
        String tra_yf3_2b         = request.getParameter("tra_yf3_2b");
        String tra_yf4_2b         = request.getParameter("tra_yf4_2b");
        String tra_yf5_2b         = request.getParameter("tra_yf5_2b");
        String tra_yf6_2b         = request.getParameter("tra_yf6_2b");
        String tra_yf7_2b         = request.getParameter("tra_yf7_2b");
        String tra_yf8_2b         = request.getParameter("tra_yf8_2b");
        String tra_yf9_2b         = request.getParameter("tra_yf9_2b");
        String tra_yf10_2b        = request.getParameter("tra_yf10_2b");
        String tra_yf11_2b        = request.getParameter("tra_yf11_2b");
        String tra_yf12_2b        = request.getParameter("tra_yf12_2b");
        ymTransferIncome = new YmTransferIncome();
        ymTransferIncome.setJtbh(jtbh);
        ymTransferIncome.setTra_xtlb("0202");
        ymTransferIncome.setTra_nf(year);
        ymTransferIncome.setTra_yf1(tra_yf1_2b);
        ymTransferIncome.setTra_yf2(tra_yf2_2b);
        ymTransferIncome.setTra_yf3(tra_yf3_2b);
        ymTransferIncome.setTra_yf4(tra_yf4_2b);
        ymTransferIncome.setTra_yf5(tra_yf5_2b);
        ymTransferIncome.setTra_yf6(tra_yf6_2b);
        ymTransferIncome.setTra_yf7(tra_yf7_2b);
        ymTransferIncome.setTra_yf8(tra_yf8_2b);
        ymTransferIncome.setTra_yf9(tra_yf9_2b);
        ymTransferIncome.setTra_yf10(tra_yf10_2b);
        ymTransferIncome.setTra_yf11(tra_yf11_2b);
        ymTransferIncome.setTra_yf12(tra_yf12_2b);
        ymTransferIncomeList.add(ymTransferIncome);

        String tra_yf1_2c         = request.getParameter("tra_yf1_2c");
        String tra_yf2_2c         = request.getParameter("tra_yf2_2c");
        String tra_yf3_2c         = request.getParameter("tra_yf3_2c");
        String tra_yf4_2c         = request.getParameter("tra_yf4_2c");
        String tra_yf5_2c         = request.getParameter("tra_yf5_2c");
        String tra_yf6_2c         = request.getParameter("tra_yf6_2c");
        String tra_yf7_2c         = request.getParameter("tra_yf7_2c");
        String tra_yf8_2c         = request.getParameter("tra_yf8_2c");
        String tra_yf9_2c         = request.getParameter("tra_yf9_2c");
        String tra_yf10_2c        = request.getParameter("tra_yf10_2c");
        String tra_yf11_2c        = request.getParameter("tra_yf11_2c");
        String tra_yf12_2c        = request.getParameter("tra_yf12_2c");
        ymTransferIncome = new YmTransferIncome();
        ymTransferIncome.setJtbh(jtbh);
        ymTransferIncome.setTra_xtlb("0203");
        ymTransferIncome.setTra_nf(year);
        ymTransferIncome.setTra_yf1(tra_yf1_2c);
        ymTransferIncome.setTra_yf2(tra_yf2_2c);
        ymTransferIncome.setTra_yf3(tra_yf3_2c);
        ymTransferIncome.setTra_yf4(tra_yf4_2c);
        ymTransferIncome.setTra_yf5(tra_yf5_2c);
        ymTransferIncome.setTra_yf6(tra_yf6_2c);
        ymTransferIncome.setTra_yf7(tra_yf7_2c);
        ymTransferIncome.setTra_yf8(tra_yf8_2c);
        ymTransferIncome.setTra_yf9(tra_yf9_2c);
        ymTransferIncome.setTra_yf10(tra_yf10_2c);
        ymTransferIncome.setTra_yf11(tra_yf11_2c);
        ymTransferIncome.setTra_yf12(tra_yf12_2c);
        ymTransferIncomeList.add(ymTransferIncome);

        String tra_yf1_3          = request.getParameter("tra_yf1_3");
        String tra_yf2_3          = request.getParameter("tra_yf2_3");
        String tra_yf3_3          = request.getParameter("tra_yf3_3");
        String tra_yf4_3          = request.getParameter("tra_yf4_3");
        String tra_yf5_3          = request.getParameter("tra_yf5_3");
        String tra_yf6_3          = request.getParameter("tra_yf6_3");
        String tra_yf7_3          = request.getParameter("tra_yf7_3");
        String tra_yf8_3          = request.getParameter("tra_yf8_3");
        String tra_yf9_3          = request.getParameter("tra_yf9_3");
        String tra_yf10_3         = request.getParameter("tra_yf10_3");
        String tra_yf11_3         = request.getParameter("tra_yf11_3");
        String tra_yf12_3         = request.getParameter("tra_yf12_3");
        ymTransferIncome = new YmTransferIncome();
        ymTransferIncome.setJtbh(jtbh);
        ymTransferIncome.setTra_xtlb("03");
        ymTransferIncome.setTra_nf(year);
        ymTransferIncome.setTra_yf1(tra_yf1_3);
        ymTransferIncome.setTra_yf2(tra_yf2_3);
        ymTransferIncome.setTra_yf3(tra_yf3_3);
        ymTransferIncome.setTra_yf4(tra_yf4_3);
        ymTransferIncome.setTra_yf5(tra_yf5_3);
        ymTransferIncome.setTra_yf6(tra_yf6_3);
        ymTransferIncome.setTra_yf7(tra_yf7_3);
        ymTransferIncome.setTra_yf8(tra_yf8_3);
        ymTransferIncome.setTra_yf9(tra_yf9_3);
        ymTransferIncome.setTra_yf10(tra_yf10_3);
        ymTransferIncome.setTra_yf11(tra_yf11_3);
        ymTransferIncome.setTra_yf12(tra_yf12_3);
        ymTransferIncomeList.add(ymTransferIncome);

        String tra_yf1_4          = request.getParameter("tra_yf1_4");
        String tra_yf2_4          = request.getParameter("tra_yf2_4");
        String tra_yf3_4          = request.getParameter("tra_yf3_4");
        String tra_yf4_4          = request.getParameter("tra_yf4_4");
        String tra_yf5_4          = request.getParameter("tra_yf5_4");
        String tra_yf6_4          = request.getParameter("tra_yf6_4");
        String tra_yf7_4          = request.getParameter("tra_yf7_4");
        String tra_yf8_4          = request.getParameter("tra_yf8_4");
        String tra_yf9_4          = request.getParameter("tra_yf9_4");
        String tra_yf10_4         = request.getParameter("tra_yf10_4");
        String tra_yf11_4         = request.getParameter("tra_yf11_4");
        String tra_yf12_4         = request.getParameter("tra_yf12_4");
        ymTransferIncome = new YmTransferIncome();
        ymTransferIncome.setJtbh(jtbh);
        ymTransferIncome.setTra_xtlb("04");
        ymTransferIncome.setTra_nf(year);
        ymTransferIncome.setTra_yf1(tra_yf1_4);
        ymTransferIncome.setTra_yf2(tra_yf2_4);
        ymTransferIncome.setTra_yf3(tra_yf3_4);
        ymTransferIncome.setTra_yf4(tra_yf4_4);
        ymTransferIncome.setTra_yf5(tra_yf5_4);
        ymTransferIncome.setTra_yf6(tra_yf6_4);
        ymTransferIncome.setTra_yf7(tra_yf7_4);
        ymTransferIncome.setTra_yf8(tra_yf8_4);
        ymTransferIncome.setTra_yf9(tra_yf9_4);
        ymTransferIncome.setTra_yf10(tra_yf10_4);
        ymTransferIncome.setTra_yf11(tra_yf11_4);
        ymTransferIncome.setTra_yf12(tra_yf12_4);
        ymTransferIncomeList.add(ymTransferIncome);

        String tra_yf1_5          = request.getParameter("tra_yf1_5");
        String tra_yf2_5          = request.getParameter("tra_yf2_5");
        String tra_yf3_5          = request.getParameter("tra_yf3_5");
        String tra_yf4_5          = request.getParameter("tra_yf4_5");
        String tra_yf5_5          = request.getParameter("tra_yf5_5");
        String tra_yf6_5          = request.getParameter("tra_yf6_5");
        String tra_yf7_5          = request.getParameter("tra_yf7_5");
        String tra_yf8_5          = request.getParameter("tra_yf8_5");
        String tra_yf9_5          = request.getParameter("tra_yf9_5");
        String tra_yf10_5         = request.getParameter("tra_yf10_5");
        String tra_yf11_5         = request.getParameter("tra_yf11_5");
        String tra_yf12_5         = request.getParameter("tra_yf12_5");
        ymTransferIncome = new YmTransferIncome();
        ymTransferIncome.setJtbh(jtbh);
        ymTransferIncome.setTra_xtlb("05");
        ymTransferIncome.setTra_nf(year);
        ymTransferIncome.setTra_yf1(tra_yf1_5);
        ymTransferIncome.setTra_yf2(tra_yf2_5);
        ymTransferIncome.setTra_yf3(tra_yf3_5);
        ymTransferIncome.setTra_yf4(tra_yf4_5);
        ymTransferIncome.setTra_yf5(tra_yf5_5);
        ymTransferIncome.setTra_yf6(tra_yf6_5);
        ymTransferIncome.setTra_yf7(tra_yf7_5);
        ymTransferIncome.setTra_yf8(tra_yf8_5);
        ymTransferIncome.setTra_yf9(tra_yf9_5);
        ymTransferIncome.setTra_yf10(tra_yf10_5);
        ymTransferIncome.setTra_yf11(tra_yf11_5);
        ymTransferIncome.setTra_yf12(tra_yf12_5);
        ymTransferIncomeList.add(ymTransferIncome);

        String tra_yf1_6          = request.getParameter("tra_yf1_6");
        String tra_yf2_6          = request.getParameter("tra_yf2_6");
        String tra_yf3_6          = request.getParameter("tra_yf3_6");
        String tra_yf4_6          = request.getParameter("tra_yf4_6");
        String tra_yf5_6          = request.getParameter("tra_yf5_6");
        String tra_yf6_6          = request.getParameter("tra_yf6_6");
        String tra_yf7_6          = request.getParameter("tra_yf7_6");
        String tra_yf8_6          = request.getParameter("tra_yf8_6");
        String tra_yf9_6          = request.getParameter("tra_yf9_6");
        String tra_yf10_6         = request.getParameter("tra_yf10_6");
        String tra_yf11_6         = request.getParameter("tra_yf11_6");
        String tra_yf12_6         = request.getParameter("tra_yf12_6");
        ymTransferIncome = new YmTransferIncome();
        ymTransferIncome.setJtbh(jtbh);
        ymTransferIncome.setTra_xtlb("06");
        ymTransferIncome.setTra_nf(year);
        ymTransferIncome.setTra_yf1(tra_yf1_6);
        ymTransferIncome.setTra_yf2(tra_yf2_6);
        ymTransferIncome.setTra_yf3(tra_yf3_6);
        ymTransferIncome.setTra_yf4(tra_yf4_6);
        ymTransferIncome.setTra_yf5(tra_yf5_6);
        ymTransferIncome.setTra_yf6(tra_yf6_6);
        ymTransferIncome.setTra_yf7(tra_yf7_6);
        ymTransferIncome.setTra_yf8(tra_yf8_6);
        ymTransferIncome.setTra_yf9(tra_yf9_6);
        ymTransferIncome.setTra_yf10(tra_yf10_6);
        ymTransferIncome.setTra_yf11(tra_yf11_6);
        ymTransferIncome.setTra_yf12(tra_yf12_6);
        ymTransferIncomeList.add(ymTransferIncome);

        String tra_yf1_7          = request.getParameter("tra_yf1_7");
        String tra_yf2_7          = request.getParameter("tra_yf2_7");
        String tra_yf3_7          = request.getParameter("tra_yf3_7");
        String tra_yf4_7          = request.getParameter("tra_yf4_7");
        String tra_yf5_7          = request.getParameter("tra_yf5_7");
        String tra_yf6_7          = request.getParameter("tra_yf6_7");
        String tra_yf7_7          = request.getParameter("tra_yf7_7");
        String tra_yf8_7          = request.getParameter("tra_yf8_7");
        String tra_yf9_7          = request.getParameter("tra_yf9_7");
        String tra_yf10_7         = request.getParameter("tra_yf10_7");
        String tra_yf11_7         = request.getParameter("tra_yf11_7");
        String tra_yf12_7         = request.getParameter("tra_yf12_7");
        ymTransferIncome = new YmTransferIncome();
        ymTransferIncome.setJtbh(jtbh);
        ymTransferIncome.setTra_xtlb("07");
        ymTransferIncome.setTra_nf(year);
        ymTransferIncome.setTra_yf1(tra_yf1_7);
        ymTransferIncome.setTra_yf2(tra_yf2_7);
        ymTransferIncome.setTra_yf3(tra_yf3_7);
        ymTransferIncome.setTra_yf4(tra_yf4_7);
        ymTransferIncome.setTra_yf5(tra_yf5_7);
        ymTransferIncome.setTra_yf6(tra_yf6_7);
        ymTransferIncome.setTra_yf7(tra_yf7_7);
        ymTransferIncome.setTra_yf8(tra_yf8_7);
        ymTransferIncome.setTra_yf9(tra_yf9_7);
        ymTransferIncome.setTra_yf10(tra_yf10_7);
        ymTransferIncome.setTra_yf11(tra_yf11_7);
        ymTransferIncome.setTra_yf12(tra_yf12_7);
        ymTransferIncomeList.add(ymTransferIncome);

        String tra_yf1_8          = request.getParameter("tra_yf1_8");
        String tra_yf2_8          = request.getParameter("tra_yf2_8");
        String tra_yf3_8          = request.getParameter("tra_yf3_8");
        String tra_yf4_8          = request.getParameter("tra_yf4_8");
        String tra_yf5_8          = request.getParameter("tra_yf5_8");
        String tra_yf6_8          = request.getParameter("tra_yf6_8");
        String tra_yf7_8          = request.getParameter("tra_yf7_8");
        String tra_yf8_8          = request.getParameter("tra_yf8_8");
        String tra_yf9_8          = request.getParameter("tra_yf9_8");
        String tra_yf10_8         = request.getParameter("tra_yf10_8");
        String tra_yf11_8         = request.getParameter("tra_yf11_8");
        String tra_yf12_8         = request.getParameter("tra_yf12_8");
        ymTransferIncome = new YmTransferIncome();
        ymTransferIncome.setJtbh(jtbh);
        ymTransferIncome.setTra_xtlb("08");
        ymTransferIncome.setTra_nf(year);
        ymTransferIncome.setTra_yf1(tra_yf1_8);
        ymTransferIncome.setTra_yf2(tra_yf2_8);
        ymTransferIncome.setTra_yf3(tra_yf3_8);
        ymTransferIncome.setTra_yf4(tra_yf4_8);
        ymTransferIncome.setTra_yf5(tra_yf5_8);
        ymTransferIncome.setTra_yf6(tra_yf6_8);
        ymTransferIncome.setTra_yf7(tra_yf7_8);
        ymTransferIncome.setTra_yf8(tra_yf8_8);
        ymTransferIncome.setTra_yf9(tra_yf9_8);
        ymTransferIncome.setTra_yf10(tra_yf10_8);
        ymTransferIncome.setTra_yf11(tra_yf11_8);
        ymTransferIncome.setTra_yf12(tra_yf12_8);
        ymTransferIncomeList.add(ymTransferIncome);

        String tra_yf1_9          = request.getParameter("tra_yf1_9");
        String tra_yf2_9          = request.getParameter("tra_yf2_9");
        String tra_yf3_9          = request.getParameter("tra_yf3_9");
        String tra_yf4_9          = request.getParameter("tra_yf4_9");
        String tra_yf5_9          = request.getParameter("tra_yf5_9");
        String tra_yf6_9          = request.getParameter("tra_yf6_9");
        String tra_yf7_9          = request.getParameter("tra_yf7_9");
        String tra_yf8_9          = request.getParameter("tra_yf8_9");
        String tra_yf9_9          = request.getParameter("tra_yf9_9");
        String tra_yf10_9         = request.getParameter("tra_yf10_9");
        String tra_yf11_9         = request.getParameter("tra_yf11_9");
        String tra_yf12_9         = request.getParameter("tra_yf12_9");
        ymTransferIncome = new YmTransferIncome();
        ymTransferIncome.setJtbh(jtbh);
        ymTransferIncome.setTra_xtlb("0201");
        ymTransferIncome.setTra_nf(year);
        ymTransferIncome.setTra_yf1(tra_yf1_9);
        ymTransferIncome.setTra_yf2(tra_yf2_9);
        ymTransferIncome.setTra_yf3(tra_yf3_9);
        ymTransferIncome.setTra_yf4(tra_yf4_9);
        ymTransferIncome.setTra_yf5(tra_yf5_9);
        ymTransferIncome.setTra_yf6(tra_yf6_9);
        ymTransferIncome.setTra_yf7(tra_yf7_9);
        ymTransferIncome.setTra_yf8(tra_yf8_9);
        ymTransferIncome.setTra_yf9(tra_yf9_9);
        ymTransferIncome.setTra_yf10(tra_yf10_9);
        ymTransferIncome.setTra_yf11(tra_yf11_9);
        ymTransferIncome.setTra_yf12(tra_yf12_9);
        ymTransferIncomeList.add(ymTransferIncome);

        String tra_yf1_10         = request.getParameter("tra_yf1_10");
        String tra_yf2_10         = request.getParameter("tra_yf2_10");
        String tra_yf3_10         = request.getParameter("tra_yf3_10");
        String tra_yf4_10         = request.getParameter("tra_yf4_10");
        String tra_yf5_10         = request.getParameter("tra_yf5_10");
        String tra_yf6_10         = request.getParameter("tra_yf6_10");
        String tra_yf7_10         = request.getParameter("tra_yf7_10");
        String tra_yf8_10         = request.getParameter("tra_yf8_10");
        String tra_yf9_10         = request.getParameter("tra_yf9_10");
        String tra_yf10_10        = request.getParameter("tra_yf10_10");
        String tra_yf11_10        = request.getParameter("tra_yf11_10");
        String tra_yf12_10        = request.getParameter("tra_yf12_10");
        ymTransferIncome = new YmTransferIncome();
        ymTransferIncome.setJtbh(jtbh);
        ymTransferIncome.setTra_xtlb("10");
        ymTransferIncome.setTra_nf(year);
        ymTransferIncome.setTra_yf1(tra_yf1_10);
        ymTransferIncome.setTra_yf2(tra_yf2_10);
        ymTransferIncome.setTra_yf3(tra_yf3_10);
        ymTransferIncome.setTra_yf4(tra_yf4_10);
        ymTransferIncome.setTra_yf5(tra_yf5_10);
        ymTransferIncome.setTra_yf6(tra_yf6_10);
        ymTransferIncome.setTra_yf7(tra_yf7_10);
        ymTransferIncome.setTra_yf8(tra_yf8_10);
        ymTransferIncome.setTra_yf9(tra_yf9_10);
        ymTransferIncome.setTra_yf10(tra_yf10_10);
        ymTransferIncome.setTra_yf11(tra_yf11_10);
        ymTransferIncome.setTra_yf12(tra_yf12_10);
        ymTransferIncomeList.add(ymTransferIncome);

        String tra_yf1_11         = request.getParameter("tra_yf1_11");
        String tra_yf2_11         = request.getParameter("tra_yf2_11");
        String tra_yf3_11         = request.getParameter("tra_yf3_11");
        String tra_yf4_11         = request.getParameter("tra_yf4_11");
        String tra_yf5_11         = request.getParameter("tra_yf5_11");
        String tra_yf6_11         = request.getParameter("tra_yf6_11");
        String tra_yf7_11         = request.getParameter("tra_yf7_11");
        String tra_yf8_11         = request.getParameter("tra_yf8_11");
        String tra_yf9_11         = request.getParameter("tra_yf9_11");
        String tra_yf10_11        = request.getParameter("tra_yf10_11");
        String tra_yf11_11        = request.getParameter("tra_yf11_11");
        String tra_yf12_11        = request.getParameter("tra_yf12_11");
        ymTransferIncome = new YmTransferIncome();
        ymTransferIncome.setJtbh(jtbh);
        ymTransferIncome.setTra_xtlb("11");
        ymTransferIncome.setTra_nf(year);
        ymTransferIncome.setTra_yf1(tra_yf1_11);
        ymTransferIncome.setTra_yf2(tra_yf2_11);
        ymTransferIncome.setTra_yf3(tra_yf3_11);
        ymTransferIncome.setTra_yf4(tra_yf4_11);
        ymTransferIncome.setTra_yf5(tra_yf5_11);
        ymTransferIncome.setTra_yf6(tra_yf6_11);
        ymTransferIncome.setTra_yf7(tra_yf7_11);
        ymTransferIncome.setTra_yf8(tra_yf8_11);
        ymTransferIncome.setTra_yf9(tra_yf9_11);
        ymTransferIncome.setTra_yf10(tra_yf10_11);
        ymTransferIncome.setTra_yf11(tra_yf11_11);
        ymTransferIncome.setTra_yf12(tra_yf12_11);
        ymTransferIncomeList.add(ymTransferIncome);

        String tra_yf1_12         = request.getParameter("tra_yf1_12");
        String tra_yf2_12         = request.getParameter("tra_yf2_12");
        String tra_yf3_12         = request.getParameter("tra_yf3_12");
        String tra_yf4_12         = request.getParameter("tra_yf4_12");
        String tra_yf5_12         = request.getParameter("tra_yf5_12");
        String tra_yf6_12         = request.getParameter("tra_yf6_12");
        String tra_yf7_12         = request.getParameter("tra_yf7_12");
        String tra_yf8_12         = request.getParameter("tra_yf8_12");
        String tra_yf9_12         = request.getParameter("tra_yf9_12");
        String tra_yf10_12        = request.getParameter("tra_yf10_12");
        String tra_yf11_12        = request.getParameter("tra_yf11_12");
        String tra_yf12_12        = request.getParameter("tra_yf12_12");
        ymTransferIncome = new YmTransferIncome();
        ymTransferIncome.setJtbh(jtbh);
        ymTransferIncome.setTra_xtlb("12");
        ymTransferIncome.setTra_nf(year);
        ymTransferIncome.setTra_yf1(tra_yf1_12);
        ymTransferIncome.setTra_yf2(tra_yf2_12);
        ymTransferIncome.setTra_yf3(tra_yf3_12);
        ymTransferIncome.setTra_yf4(tra_yf4_12);
        ymTransferIncome.setTra_yf5(tra_yf5_12);
        ymTransferIncome.setTra_yf6(tra_yf6_12);
        ymTransferIncome.setTra_yf7(tra_yf7_12);
        ymTransferIncome.setTra_yf8(tra_yf8_12);
        ymTransferIncome.setTra_yf9(tra_yf9_12);
        ymTransferIncome.setTra_yf10(tra_yf10_12);
        ymTransferIncome.setTra_yf11(tra_yf11_12);
        ymTransferIncome.setTra_yf12(tra_yf12_12);
        ymTransferIncomeList.add(ymTransferIncome);

        return ymTransferIncomeList;
    }


}
