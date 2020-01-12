package cn.com.fovsoft.ym.controller.rest;

import cn.com.fovsoft.common.util.JsonResult;
import cn.com.fovsoft.ym.entity.YmFamilyBase;
import cn.com.fovsoft.ym.entity.YmFamilyBaseAddition;
import cn.com.fovsoft.ym.entity.YmFamilyBaseCondition;
import cn.com.fovsoft.ym.entity.YmFamilyBaseMember;
import cn.com.fovsoft.ym.entity.holders.*;
import cn.com.fovsoft.ym.service.FamilySerivce;
import com.github.pagehelper.PageInfo;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/query")
public class QueryRestController {
    private final Log logger = LogFactory.getLog(this.getClass());
    @Autowired
    FamilySerivce familySerivce;

    @RequestMapping(value = "/getList",method = RequestMethod.POST, produces = "application/json;charset=UTF-8")
    public Object index(@RequestBody HashMap paramMap) {

        PageInfo pageInfo = familySerivce.getList(paramMap);
        Map result = new HashMap();
        result.put("data", pageInfo.getList());
        result.put("msg", "");
        result.put("count", pageInfo.getTotal());
        result.put("code", 0);
        return result;
    }

    @RequestMapping(value = "/getBase", method = RequestMethod.GET, produces = "application/json;charset=UTF-8")
    public JsonResult get(String id) {
        YmQueryFamilyBaseHolder ymFamilyBase = familySerivce.get(id);
        return new JsonResult(ymFamilyBase);
    }


    @RequestMapping(value = "/getMemberList",  produces = "application/json;charset=UTF-8")
    public JsonResult getMemberList(String fid) {
        List<YmQueryPersionHolder> list = familySerivce.getMemberList(fid);
        return new JsonResult(list);
    }


    @RequestMapping(value = "/getAddition",  produces = "application/json;charset=UTF-8")
    public JsonResult getAddiction(String fid) {
        YmQueryAdditionHolder ymFamilyBaseAddition = familySerivce.getAddiction(fid);
        return new JsonResult(ymFamilyBaseAddition);
    }

    @RequestMapping(value = "/getCondition",  produces = "application/json;charset=UTF-8")
    public JsonResult getCondition(String fid) {
        YmQueryConditionHolder ymFamilyBaseCondition = familySerivce.getCondition(fid);
        return new JsonResult(ymFamilyBaseCondition);
    }

    @RequestMapping(value = "/getHouseHold",  produces = "application/json;charset=UTF-8")
    public JsonResult getHouseHold(String fid) {
        YmQueryHouseHold houseHold = familySerivce.getHouseHold(fid);
        return new JsonResult(houseHold);
    }

}
