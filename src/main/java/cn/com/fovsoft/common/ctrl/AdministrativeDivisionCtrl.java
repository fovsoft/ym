package cn.com.fovsoft.common.ctrl;/*
 * Author:tpc
 * Date:2019-11-11 15:10
 * 功能描述: 行政区划代码控制类
 * version:
 */

import cn.com.fovsoft.common.bean.AdministrativeDivision;
import cn.com.fovsoft.common.constant.VarConstant;
import cn.com.fovsoft.common.dto.AdminDivisionTreeDto;
import cn.com.fovsoft.common.service.AdministrativeDivisionService;
import cn.com.fovsoft.common.util.DateUtil;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
public class AdministrativeDivisionCtrl {


    //注入服务对象
    @Autowired
    private AdministrativeDivisionService administrativeDivisionService;


    @Autowired
    private ObjectMapper objectMapper;


    /*
     * Author:tpc
     * Date: 2019/11/11 15:25
     * Param:
     * Return:
     * 功能描述:  展示行政区划代码管理页面
     */
    @RequestMapping("/admin/dept")
    public ModelAndView listAdministrativeDivision(HttpServletRequest request){

        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("administrative-division");
        modelAndView.addObject("rootSysMenuList",request.getSession().getAttribute(VarConstant.SESSION_MENU));
        return modelAndView;

    }


    /*
     * Author:tpc
     * Date: 2019/11/11 16:41
     * Param: [request, response]
     * Return: void
     * 功能描述: 获取树根节点信息，并返回给前端
     */
    @RequestMapping(value = "/dept/rootAdminDivision")
    @ResponseBody
    public void listRootAdminDivision(HttpServletRequest request, HttpServletResponse response) throws IOException {

        //根据上级行政区划代码为0拿到根节点
        List<AdministrativeDivision> rootAdAdministrativeDivisionList = administrativeDivisionService.findChildAdministrativeDivision("0");
        //用来封装行政区划树的list
        List<AdminDivisionTreeDto> adminDivisionTreeDtoList = new ArrayList<>();

        for(AdministrativeDivision administrativeDivision:rootAdAdministrativeDivisionList){
            AdminDivisionTreeDto adminDivisionTreeDto = new AdminDivisionTreeDto();
            adminDivisionTreeDto.setNodeid(administrativeDivision.getId());
            adminDivisionTreeDto.setText(administrativeDivision.getXzqhmz());
            adminDivisionTreeDto.setNodes(new ArrayList<>());
            adminDivisionTreeDtoList.add(adminDivisionTreeDto);
        }


        //返回结果
        Map<String,Object> map = new HashMap<>();

        map.put("rootNodes",adminDivisionTreeDtoList);

        map.put("result","success");

        response.setContentType("application/json;charset=utf-8");
        //map.put("ymPerson_data",ymPersonList);
        response.getWriter().write(objectMapper.writeValueAsString(map));
        System.out.println(objectMapper.writeValueAsString(map));
        response.getWriter().flush();
        response.getWriter().close();

    }


    /*
     * Author:tpc
     * Date: 2019/11/11 16:55
     * Param: [request, response]
     * Return: void
     * 功能描述: 获取行政区划树当前节点的子节点
     */
    @RequestMapping("/dept/childAdminDivision")
    @ResponseBody
    public void getChildAdminDivision(HttpServletRequest request, HttpServletResponse response) throws IOException {
        //获取id
        String id = request.getParameter("id");
        //通过行政区划id查找当前节点的子节点
        List<AdministrativeDivision> administrativeDivisionList = administrativeDivisionService.findChildAdministrativeDivisionById(id);

        //封装树节点
        List<AdminDivisionTreeDto> childNodes = new ArrayList<>();
        for(AdministrativeDivision administrativeDivision:administrativeDivisionList){
            AdminDivisionTreeDto adminDivisionTreeDto = new AdminDivisionTreeDto();
            adminDivisionTreeDto.setNodeid(administrativeDivision.getId());
            adminDivisionTreeDto.setText(administrativeDivision.getXzqhmz());
            adminDivisionTreeDto.setNodes(new ArrayList<>());
            childNodes.add(adminDivisionTreeDto);
        }

        //返回结果
        Map<String,Object> map = new HashMap<>();

        map.put("childNodes",childNodes);

        map.put("result","success");

        response.setContentType("application/json;charset=utf-8");
        //map.put("ymPerson_data",ymPersonList);
        response.getWriter().write(objectMapper.writeValueAsString(map));
        System.out.println(objectMapper.writeValueAsString(map));
        response.getWriter().flush();
        response.getWriter().close();

    }



    /**
     * @author: tpc
     * @date: 2019/11/11 21:12
     * @description: 当点击一个区划节点时，后台返回数据，填充右边表单
     */
    @RequestMapping(value = "/dept/oneAdminDivision")
    @ResponseBody
    public Map<String,Object> getOneAdminDivision(HttpServletRequest request){

        //获取前台传过来的id
        String id = request.getParameter("id");


        //用来返回前端的信息
        Map<String,Object> map = new HashMap<>();
        int status = 0;
        String result = "error";

        //后台取取到相应节点信息
        AdministrativeDivision administrativeDivision = administrativeDivisionService.findAdministrativeDivisionById(id);
        if(administrativeDivision !=null){
            status = 1;
            result = "success";
        }
        map.put("adminDivision",administrativeDivision);
        map.put("status",status);
        map.put("result",result);

        return map;
    }


    @RequestMapping("/dept/add")
    @ResponseBody
    public Map<String,Object> addAdminDivision(HttpServletRequest request){
        //获取前端参数
        String xzqhdm   = request.getParameter("xzqhdm");
        String xzqhmz   = request.getParameter("xzqhmz");
        String xxxzqhmz = request.getParameter("xxxzqhmz");
        String xxxzqhmz1 = request.getParameter("xxxzqhmz1");
        String sjxzqhdm = request.getParameter("sjxzqhdm");
        String xzqhcj   = request.getParameter("xzqhcj");
        String fzjg     = request.getParameter("fzjg");
        String xzqhlb   = request.getParameter("xzqhlb");
        String yzbm     = request.getParameter("yzbm");


        System.out.println("xzqhdm    "+xzqhdm     );
        System.out.println("xzqhmz    "+xzqhmz     );
        System.out.println("xxxzqhmz1  "+xxxzqhmz1   );
        System.out.println("xxxzqhmz  "+xxxzqhmz   );
        System.out.println("sjxzqhdm  "+sjxzqhdm   );
        System.out.println("xzqhcj    "+xzqhcj     );
        System.out.println("fzjg      "+fzjg       );
        System.out.println("xzqhlb    "+xzqhlb     );
        System.out.println("yzbm      "+yzbm       );

        //封装参数，写入数据库
        AdministrativeDivision administrativeDivision = new AdministrativeDivision();
        administrativeDivision.setXzqhdm(xzqhdm);
        administrativeDivision.setXzqhmz(xzqhmz);
        administrativeDivision.setXxxzqhmz(xxxzqhmz1+xxxzqhmz);
        administrativeDivision.setSjxzqhdm(sjxzqhdm);
        administrativeDivision.setXzqhcj(xzqhcj);
        administrativeDivision.setFzjg(fzjg);
        administrativeDivision.setXzqhlb(xzqhlb);
        administrativeDivision.setYzbm(yzbm);
        administrativeDivision.setCjsj(DateUtil.getStringDate());
        administrativeDivision.setGxsj(DateUtil.getStringDate());

        //返回前端的参数
        Map<String,Object> map = new HashMap<>();

        //写入信息
        int status = administrativeDivisionService.addAdministrativeDivision(administrativeDivision);
        if(status<1){
            map.put("status",0);
            map.put("result","error");
        }else {
            map.put("status",1);
            map.put("result","success");
        }

        return map;
    }


    @RequestMapping("/dept/edit")
    @ResponseBody
    public Map<String,Object> editAdminDivision(HttpServletRequest request){
        //获取前端参数
        String id       = request.getParameter("id");
        String xzqhdm   = request.getParameter("xzqhdm");
        String xzqhmz   = request.getParameter("xzqhmz");
        String xxxzqhmz = request.getParameter("xxxzqhmz");
        String xxxzqhmz1 = request.getParameter("xxxzqhmz1");
        String sjxzqhdm = request.getParameter("sjxzqhdm");
        String xzqhcj   = request.getParameter("xzqhcj");
        String fzjg     = request.getParameter("fzjg");
        String xzqhlb   = request.getParameter("xzqhlb");
        String yzbm     = request.getParameter("yzbm");


        System.out.println("xzqhdm    "+xzqhdm     );
        System.out.println("xzqhmz    "+xzqhmz     );
        System.out.println("xxxzqhmz1  "+xxxzqhmz1   );
        System.out.println("xxxzqhmz  "+xxxzqhmz   );
        System.out.println("sjxzqhdm  "+sjxzqhdm   );
        System.out.println("xzqhcj    "+xzqhcj     );
        System.out.println("fzjg      "+fzjg       );
        System.out.println("xzqhlb    "+xzqhlb     );
        System.out.println("yzbm      "+yzbm       );

        //封装参数，写入数据库
        AdministrativeDivision administrativeDivision = new AdministrativeDivision();
        administrativeDivision.setId(id);
        administrativeDivision.setXzqhdm(xzqhdm);
        administrativeDivision.setXzqhmz(xzqhmz);
        administrativeDivision.setXxxzqhmz(xxxzqhmz1+xxxzqhmz);
        administrativeDivision.setSjxzqhdm(sjxzqhdm);
        administrativeDivision.setXzqhcj(xzqhcj);
        administrativeDivision.setFzjg(fzjg);
        administrativeDivision.setXzqhlb(xzqhlb);
        administrativeDivision.setYzbm(yzbm);
        administrativeDivision.setGxsj(DateUtil.getStringDate());

        //返回前端的参数
        Map<String,Object> map = new HashMap<>();

        //写入信息
        int status = administrativeDivisionService.updateAdministrativeDivisionById(administrativeDivision);
        if(status<1){
            map.put("status",0);
            map.put("result","error");
        }else {
            map.put("status",1);
            map.put("result","success");
        }

        return map;
    }



    /*
     * Author:tpc
     * Date: 2019/11/12 10:56
     * Param: [request]
     * Return: java.util.Map<java.lang.String,java.lang.Object>
     * 功能描述: 删除行政区划，并删除及子行政区划
     */
    @RequestMapping("/dept/delete")
    @ResponseBody
    public Map<String,Object> deleteAdminDivision(HttpServletRequest request){
        //获取前端参数
        String id       = request.getParameter("id");

        //返回前端的参数
        Map<String,Object> map = new HashMap<>();

        //写入信息
        int status = administrativeDivisionService.deleteAdministrativeDivisionById(id);
        if(status<1){
            map.put("status",0);
            map.put("result","error");
        }else {
            map.put("status",1);
            map.put("result","success");
        }

        return map;
    }



}
