package cn.com.fovsoft.ym.controller;

import cn.com.fovsoft.ym.service.FamilySerivce;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class FamilyController {

    @Autowired
    FamilySerivce familySerivce;

    @RequestMapping(value = "/family")
    public String index() {
        return "family";
    }

    @RequestMapping(value = "/familyAdd")
    public String familyAdd() {
        return "family_add";
    }

    @RequestMapping(value = "/memberAdd")
    public String memberAdd() {
        return "member_add";
    }

    @RequestMapping(value = "/memberEdit")
    public String memberEdit() {
        return "member_edit";
    }

    @RequestMapping(value = "/edit")
    public String familyEdit() {
        return "family_edit";
    }
}
