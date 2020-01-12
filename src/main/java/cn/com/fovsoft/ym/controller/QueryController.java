package cn.com.fovsoft.ym.controller;

import cn.com.fovsoft.ym.service.FamilySerivce;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class QueryController {

//    @Autowired
//    IncomeSerivce familySerivce;

    @RequestMapping(value = "/query")
    public String index() {
        return "/query/index";
    }

    @RequestMapping(value = "/query/family")
    public String family(ModelMap model, String jtbh) {
        model.addAttribute("id", jtbh);
        return "/query/family";
    }

}
