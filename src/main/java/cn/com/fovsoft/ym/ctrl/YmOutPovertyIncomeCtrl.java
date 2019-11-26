package cn.com.fovsoft.ym.ctrl;

import cn.com.fovsoft.ym.service.YmOutPovertyIncomeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

/**
 * @Author by tpc
 * @Date 2019/11/26 22:04
 * description:不计入家庭脱贫收入控制类
 **/


@Controller
public class YmOutPovertyIncomeCtrl {

    @Autowired
    private YmOutPovertyIncomeService ymOutPovertyIncomeService;


}
