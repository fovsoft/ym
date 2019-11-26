package cn.com.fovsoft.ym.ctrl;

import cn.com.fovsoft.ym.service.YmTransferIncomeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

/**
 * @Author by tpc
 * @Date 2019/11/26 22:03
 * description:转移性收入控制类
 **/


@Controller
public class YmTransferIncomeCtrl {

    @Autowired
    private YmTransferIncomeService ymTransferIncomeService;


}
