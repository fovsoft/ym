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


}
