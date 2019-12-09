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
import org.springframework.web.bind.annotation.*;

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


    /**
     * @author: tpc
     * @date: 2019/12/3 23:14
     * @description: 给点条件的任意组合的条件查询实现
     */
    @RequestMapping(value = "/settlementHousehold/searchByMore",method = RequestMethod.POST)
    @ResponseBody
    public void searchAzSettlementHousehodByMore(HttpServletRequest request, HttpServletResponse response) throws IOException{
        //前端获取参数
        String azdmz = request.getParameter("azdmz");
        String hz = request.getParameter("hz");
        String lxdh = request.getParameter("lxdh");
        String ldfh = request.getParameter("ldfh");
        //前端获取到的页码数
        int pageNum = Integer.parseInt(request.getParameter("page"));
        //前端获取到的显示每页的数量
        int pageSize = Integer.parseInt(request.getParameter("rows"));
        //分页获取到所有安置户信息
        PageHelper.startPage(pageNum,pageSize);
        List<AzSettlementHousehold> azSettlementHouseholdList = azSettlementHouseholdService.findAzSettlementHouseholdByMoreCondition(azdmz,hz,lxdh,ldfh);
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



    /*
     * Author:tpc
     * Date: 2019/12/3 11:38
     * Param: [request]
     * Return: java.util.Map<java.lang.String,java.lang.Object>
     * 功能描述: 新增安置户
     */
    @RequestMapping(value = "/settlementHousehold/add")
    @ResponseBody
    public Map<String,Object> addAzSettlementHousehold(HttpServletRequest request){

        int resultNum = insertAzSettlementHousehold(request);

        //用来返回结果的信息
        int status = 1;
        String result = "success";
        //判断写入情况
        if(resultNum<1){
            status = 0;
            result = "error";
        }
        Map<String,Object> map = new HashMap<>();
        map.put("status",status);
        map.put("result",result);
        return map;
    }


    public int insertAzSettlementHousehold(HttpServletRequest request){
        //获取前端参数
        String azdbh          = request.getParameter("azdbh")      ;
        String hz             = request.getParameter("hz")         ;
        String jtbh           = request.getParameter("jtbh")       ;
        String ldfh           = request.getParameter("ldfh")       ;
        String ndfqrw         = request.getParameter("ndfqrw")     ;
        String bqlx           = request.getParameter("bqlx")       ;
        String qcdsj          = request.getParameter("qcdsj")      ;
        String qcdxj          = request.getParameter("qcdxj")      ;
        String qcdxxdz        = request.getParameter("qcdxxdz")    ;
        String qcdlx          = request.getParameter("qcdlx")      ;
        String jtsyhrk        = request.getParameter("jtsyhrk")    ;
        String zfmj           = request.getParameter("zfmj")       ;
        String zczj           = request.getParameter("zczj")       ;
        String bqrzsj         = request.getParameter("bqrzsj")     ;
        String sjrzsj         = request.getParameter("sjrzsj")     ;
        String sfsjrzmln      = request.getParameter("sfsjrzmln")  ;
        String yyzf           = request.getParameter("yyzf")       ;
        String yzfmj          = request.getParameter("yzfmj")      ;
        String ccjf           = request.getParameter("ccjf")       ;
        String bhzfzl         = request.getParameter("bhzfzl")     ;
        String ccsj           = request.getParameter("ccsj")       ;
        String ccjfmj         = request.getParameter("ccjfmj")     ;
        String dxcfjl         = request.getParameter("dxcfjl")     ;
        String fkfl           = request.getParameter("fkfl")       ;
        String fkflmj         = request.getParameter("fkflmj")     ;
        String cyfcxm         = request.getParameter("cyfcxm")     ;
        String nnhdcyfczj     = request.getParameter("nnhdcyfczj") ;
        String tpqk           = request.getParameter("tpqk")       ;
        String hkqy           = request.getParameter("hkqy")       ;
        String fczbl          = request.getParameter("fczbl")      ;
        String lxdh           = request.getParameter("lxdh")       ;

        AzSettlementHousehold azSettlementHousehold = new AzSettlementHousehold();
        azSettlementHousehold.setAzdbh(azdbh);
        azSettlementHousehold.setHz(hz);
        azSettlementHousehold.setJtbh(jtbh);
        azSettlementHousehold.setLdfh(ldfh);
        azSettlementHousehold.setNdfqrw(ndfqrw);
        if(bqlx.equals("1")){
            azSettlementHousehold.setBqlx("建档立卡贫困户");
        }else if(bqlx.equals("2")){
            azSettlementHousehold.setBqlx("同步搬迁户");
        }else {
            azSettlementHousehold.setBqlx("其他");
        }
        azSettlementHousehold.setQcdsj(qcdsj);
        azSettlementHousehold.setQcdxj(qcdxj);
        azSettlementHousehold.setQcdxxdz(qcdxxdz);
        if(qcdlx.equals("1")){
            azSettlementHousehold.setQcdlx("一类");
        }else if(qcdlx.equals("2")){
            azSettlementHousehold.setQcdlx("二类");
        }else if(qcdlx.equals("3")){
            azSettlementHousehold.setQcdlx("三类");
        }else if(qcdlx.equals("4")){
            azSettlementHousehold.setQcdlx("四类");
        }else{
            azSettlementHousehold.setQcdlx("其他");
        }
        azSettlementHousehold.setJtsyhrk(jtsyhrk);
        azSettlementHousehold.setZfmj(zfmj);
        azSettlementHousehold.setZczj(zczj);
        azSettlementHousehold.setBqrzsj(bqrzsj);
        azSettlementHousehold.setSjrzsj(sjrzsj);
        if(sfsjrzmln.equals("yes")){
            azSettlementHousehold.setSfsjrzmln("是");
        }else{
            azSettlementHousehold.setSfsjrzmln("否");
        }

        if(yyzf.equals("1")){
            azSettlementHousehold.setYyzf("无房户");
        }else if(yyzf.equals("2")){
            azSettlementHousehold.setYyzf("保护性住房");
        }else if(yyzf.equals("3")){
            azSettlementHousehold.setYyzf("连体房");
        }else if(yyzf.equals("4")){
            azSettlementHousehold.setYyzf("自建独立房");
        }else{
            azSettlementHousehold.setYyzf("其他");
        }
        azSettlementHousehold.setYzfmj(yzfmj);
        if(ccjf.equals("1")){
            azSettlementHousehold.setCcjf("已拆除");
        }else if(ccjf.equals("2")){
            azSettlementHousehold.setCcjf("未拆除");
        }else {
            azSettlementHousehold.setCcjf("其他");
        }
        if(bhzfzl.equals("1")){
            azSettlementHousehold.setBhzfzl("传统保护村落");
        }else if(bhzfzl.equals("2")){
            azSettlementHousehold.setBhzfzl("少数民族特色村落");
        }else if(bhzfzl.equals("3")){
            azSettlementHousehold.setBhzfzl("国家乡村旅游扶贫重点村");
        }else if(bhzfzl.equals("4")){
            azSettlementHousehold.setBhzfzl("重点文化旅游村落");
        }else{
            azSettlementHousehold.setBhzfzl("其他");
        }
        azSettlementHousehold.setCcsj(ccsj);
        azSettlementHousehold.setCcjfmj(ccjfmj);
        azSettlementHousehold.setDxcfjl(dxcfjl);
        if(fkfl.equals("1")){
            azSettlementHousehold.setFkfl("未复垦复绿");
        }else if(fkfl.equals("2")){
            azSettlementHousehold.setFkfl("已复垦");
        }else if(fkfl.equals("3")){
            azSettlementHousehold.setFkfl("已复绿");
        }else{
            azSettlementHousehold.setFkfl("其他");
        }
        azSettlementHousehold.setFkflmj(fkflmj);
        azSettlementHousehold.setCyfcxm(cyfcxm);
        azSettlementHousehold.setNnhdcyfczj(nnhdcyfczj);
        azSettlementHousehold.setTpqk(tpqk);
        if(hkqy.equals("yes")){
            azSettlementHousehold.setHkqy("是");
        }else{
            azSettlementHousehold.setHkqy("否");
        }
        if(fczbl.equals("yes")){
            azSettlementHousehold.setFczbl("是");
        }else {
            azSettlementHousehold.setFczbl("否");
        }
        azSettlementHousehold.setLxdh(lxdh);

        int resultNum = azSettlementHouseholdService.addAzSettlementHousehold(azSettlementHousehold);
        return resultNum;
    }


    @RequestMapping(value = "/settlementHousehold/edit",method=RequestMethod.POST, produces = "application/json;charset=UTF-8")
    @ResponseBody
    public Map<String,Object> editAzSettlementHousehold(@RequestBody AzSettlementHousehold azSettlementHousehold){


        //先删除原来的，然后再进行写入
        //String id = request.getParameter("id");
//        azSettlementHouseholdService.deleteAzSettlementHouseholdById(id);
        //写入数据
//        int resultNum = insertAzSettlementHousehold(request);
        int resultNum = azSettlementHouseholdService.updateAzSettlementHouseholdById(azSettlementHousehold);

        //用来返回结果的信息
        int status = 1;
        String result = "success";
        //判断写入情况
        if(resultNum<1){
            status = 0;
            result = "error";
        }
        Map<String,Object> map = new HashMap<>();
        map.put("status",status);
        map.put("result",result);
        return map;

    }





    /**
     * @author: tpc
     * @date: 2019/12/3 22:33
     * @description: 安置户信息的删除
     */
    @RequestMapping(value = "/settlementHousehold/delete")
    @ResponseBody
    public Map<String,Object> deleteAzSettlementHousehold(HttpServletRequest request){
        String idArr = request.getParameter("idArr");
        idArr = idArr.substring(0,idArr.length()-1);
        if(idArr.length()==1){
            //直接删除
            azSettlementHouseholdService.deleteAzSettlementHouseholdById(idArr);
        }else {
            String[] idArray = idArr.split(",");
            for(String id:idArray){
                azSettlementHouseholdService.deleteAzSettlementHouseholdById(id);
            }
        }
        //用来返回信息的封装对象
        Map<String,Object> map=new HashMap<>();
        map.put("status",1);
        map.put("result","success");
        return map;
    }


    @RequestMapping(value = "/settlementHousehold/deleteOne")
    @ResponseBody
    public Map<String,Object> deleteAzSettlementHouseholdOne(HttpServletRequest request){
        String id = request.getParameter("id");

        azSettlementHouseholdService.deleteAzSettlementHouseholdById(id);

        //用来返回信息的封装对象
        Map<String,Object> map=new HashMap<>();
        map.put("status",1);
        map.put("result","success");
        return map;
    }




}
