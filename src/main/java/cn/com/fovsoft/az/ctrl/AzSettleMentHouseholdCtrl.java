package cn.com.fovsoft.az.ctrl;/*
 * @Author:tpc
 * @Date: 2019/11/29 17:29
 * 功能描述:
 * @version:
 */

import cn.com.fovsoft.az.bean.AzSettlementHousehold;
import cn.com.fovsoft.az.service.AzSettlementHouseholdService;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
public class AzSettleMentHouseholdCtrl {


    @Autowired
    private AzSettlementHouseholdService azSettlementHouseholdService;

    @Autowired
    private ObjectMapper objectMapper;



    /**
     * @author: tpc
     * @date: 2019/12/2 23:19
     * @description: 当打开安置户管理页面时候，显示所有的安置户信息
     */
    @RequestMapping(value = "/settlementHousehold/listAll",method = RequestMethod.POST)
    @ResponseBody
    public void listAllAzSettlementHousehod(HttpServletRequest request, HttpServletResponse response) throws IOException{
        //前端获取到的页码数
        int pageNum = Integer.parseInt(request.getParameter("page"));
        //前端获取到的显示每页的数量
        int pageSize = Integer.parseInt(request.getParameter("rows"));
        //分页获取到所有安置户信息
        PageHelper.startPage(pageNum,pageSize);
        List<AzSettlementHousehold> azSettlementHouseholdList = azSettlementHouseholdService.findAllAzSettlementHousehold();
        PageInfo<AzSettlementHousehold> pageInfo = new PageInfo<AzSettlementHousehold>(azSettlementHouseholdList);

        //获得总记录数
        long records = pageInfo.getTotal();
        //默认当前页码
        int page = pageInfo.getPageNum();
        //获得总页数
        int total = pageInfo.getPages();
        //用来序列化json数据的map
        Map<String,Object> map=new HashMap<>();
        //设置json格式写出
        map.put("rows",azSettlementHouseholdList);
        map.put("page",page);
        map.put("total",total);
        map.put("records",records);

        response.setContentType("application/json;charset=utf-8");
        //map.put("ymPerson_data",ymPersonList);
        response.getWriter().write(objectMapper.writeValueAsString(map));
        response.getWriter().flush();
        response.getWriter().close();
    }


}
