package cn.com.fovsoft.ym.ctrl;/*
 * @Author:tpc
 * @Date: 2019/12/17 17:32
 * 功能描述:
 * @version:
 */


import cn.com.fovsoft.ym.bean.YmIncomeSum;
import cn.com.fovsoft.ym.service.YmIncomeSumService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Map;

@Controller
public class YmIncomeSumCtrl {
    @Autowired
    private YmIncomeSumService ymIncomeSumService;


    @RequestMapping(value = "/incomeSum/list")
    @ResponseBody
    public Map<String,Object> viewPersonInfo(HttpServletRequest request){
        String jtbh = request.getParameter("jtbh");

        Map<String,Object> map = new HashMap<>();
        int status = 1;
        String result = "success";


        //再通过家庭编号区查找信息
        YmIncomeSum ymIncomeSum = ymIncomeSumService.getYmIncomeSumByJtbh(jtbh);
        if(ymIncomeSum == null){
            status = 0;
            result = "noData";
        }else {
            map.put("ymIncomeSum",ymIncomeSum);
        }
        map.put("status",status);
        map.put("result",result);

        return map;
    }
}
