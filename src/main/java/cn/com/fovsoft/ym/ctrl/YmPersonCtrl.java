package cn.com.fovsoft.ym.ctrl;

import cn.com.fovsoft.common.bean.SysMenu;
import cn.com.fovsoft.common.constant.VarConstant;
import cn.com.fovsoft.ym.bean.YmFamily;
import cn.com.fovsoft.ym.bean.YmFamilyStatus;
import cn.com.fovsoft.ym.bean.YmPerson;
import cn.com.fovsoft.ym.service.*;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @Author by tpc
 * @Date 2019/10/20 16:21
 * description: 贫困人员控制类
 **/

@Controller
public class YmPersonCtrl {


    //注入贫困人员服务类
    @Autowired
    private YmPersonService ymPersonService;


    @Autowired
    private ObjectMapper objectMapper;

    @Autowired
    private YmProduceIncomeService ymProduceIncomeService;

    @Autowired
    private YmSalaryIncomeService ymSalaryIncomeService;

    @Autowired
    private YmPropertyIncomeService ymPropertyIncomeService;
    @Autowired
    private YmTransferIncomeService ymTransferIncomeService;
    @Autowired
    private YmOutPovertyIncomeService ymOutPovertyIncomeService;

    @Autowired
    private YmFamilyStatusService ymFamilyStatusService;
    @Autowired
    private YmFamilyService ymFamilyService;

    /*
     * @author: tpc
     * @date: 2019/10/20 16:39
     * @description: 响应前端页面的贫困人员信息展示按钮，列出所有贫困人员信息
     */
    @RequestMapping(value = "/ym/all",method = RequestMethod.POST)
    @ResponseBody
    public void FindPerson(HttpServletRequest request,HttpServletResponse response) throws IOException {
        //前端获取到的页码数
        int pageNum = Integer.parseInt(request.getParameter("page"));
        //前端获取到的显示每页的数量
        int pageSize = Integer.parseInt(request.getParameter("rows"));
        //分页获取到所有用户信息
        PageHelper.startPage(pageNum,pageSize);
        List<YmPerson> ymPersonList = ymPersonService.findAllYmPerson();
        PageInfo<YmPerson> pageInfo = new PageInfo<YmPerson>(ymPersonList);
        //获得总记录数
        long records = pageInfo.getTotal();
        //默认当前页码
        int page = pageInfo.getPageNum();
        //获得总页数
        int total = pageInfo.getPages();
        //用来序列化json数据的map
        Map<String,Object> map=new HashMap<>();
        //设置json格式写出
        map.put("rows",ymPersonList);
        map.put("page",page);
        map.put("total",total);
        map.put("records",records);

       // modelAndView.addObject("rows",objectMapper.writeValueAsString(ymPersonList));
        response.setContentType("application/json;charset=utf-8");
        //map.put("ymPerson_data",ymPersonList);
        response.getWriter().write(objectMapper.writeValueAsString(map));
        response.getWriter().flush();
        response.getWriter().close();
//        return modelAndView;
    }

    @RequestMapping(value="/ym/add")
    public ModelAndView listPersonHtml(HttpServletRequest request,HttpServletResponse response) throws IOException{

        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("list-person");
        modelAndView.addObject("rootSysMenuList",request.getSession().getAttribute(VarConstant.SESSION_MENU));

        modelAndView.addObject("sessionUser",request.getSession().getAttribute(VarConstant.SESSION_USER));
        for(SysMenu sysMenu:(List<SysMenu>) request.getSession().getAttribute("rootSysMenuList")){
            System.out.println(sysMenu.getMenuName());
        }

        return modelAndView;
    }


    /*
     * 功能描述: 用来跳转到贫困人员信息采集界面
     * @author by tpc
     * @date 2019/10/22 11:44
     * @param [request]
     * @return org.springframework.web.servlet.ModelAndView
     */
    @RequestMapping(value="/ym/mgr")
    public ModelAndView addYmInformation(HttpServletRequest request){
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("add-ym-information");
        modelAndView.addObject("rootSysMenuList",request.getSession().getAttribute(VarConstant.SESSION_MENU));
        modelAndView.addObject("sessionUser",request.getSession().getAttribute(VarConstant.SESSION_USER));

        return modelAndView;
    }



    /*
     * Author:tpc
     * Date: 2019/11/25 10:08
     * Param: [request, response]
     * Return: void
     * 功能描述: 查找贫困用户的方法
     */
    @RequestMapping("/person/search")
    @ResponseBody
    public void getPersonByMoreCondition(HttpServletRequest request,HttpServletResponse response) throws IOException{

        String xm = request.getParameter("xm");
        String sfzmhm = request.getParameter("sfzmhm");
        String lxdh = request.getParameter("lxdh");
        String csrq = request.getParameter("csrq");
        //前端获取到的页码数
        int pageNum = Integer.parseInt(request.getParameter("page"));
        //前端获取到的显示每页的数量
        int pageSize = Integer.parseInt(request.getParameter("rows"));
        //分页获取到所有用户信息
        PageHelper.startPage(pageNum,pageSize);
        List<YmPerson> ymPersonList = ymPersonService.findYmPersonByMoreCondition(xm,sfzmhm,lxdh,csrq);
        PageInfo<YmPerson> pageInfo = new PageInfo<YmPerson>(ymPersonList);
        //获得总记录数
        long records = pageInfo.getTotal();
        //默认当前页码
        int page = pageInfo.getPageNum();
        //获得总页数
        int total = pageInfo.getPages();
        //用来序列化json数据的map
        Map<String,Object> map=new HashMap<>();
        //设置json格式写出
        map.put("rows",ymPersonList);
        map.put("page",page);
        map.put("total",total);
        map.put("records",records);

        response.setContentType("application/json;charset=utf-8");
        //map.put("ymPerson_data",ymPersonList);
        response.getWriter().write(objectMapper.writeValueAsString(map));
        response.getWriter().flush();
        response.getWriter().close();
    }



    @RequestMapping("/person/listMember")
    @ResponseBody
    public  void getPersonByFamily(HttpServletRequest request,HttpServletResponse response) throws IOException{
        String jtbh = request.getParameter("jtbh");


        //前端获取到的页码数
        int pageNum = Integer.parseInt(request.getParameter("page"));
        //前端获取到的显示每页的数量
        int pageSize = Integer.parseInt(request.getParameter("rows"));
        //分页获取到所有用户信息
        PageHelper.startPage(pageNum,pageSize);
        List<YmPerson> ymPersonList = ymPersonService.getYmPersonByJtbh(jtbh);
        PageInfo<YmPerson> pageInfo = new PageInfo<YmPerson>(ymPersonList);

        //获得总记录数
        long records = pageInfo.getTotal();
        //默认当前页码
        int page = pageInfo.getPageNum();
        //获得总页数
        int total = pageInfo.getPages();
        //用来序列化json数据的map
        Map<String,Object> map=new HashMap<>();
        //设置json格式写出
        map.put("rows",ymPersonList);
        map.put("page",page);
        map.put("total",total);
        map.put("records",records);

        response.setContentType("application/json;charset=utf-8");
        //map.put("ymPerson_data",ymPersonList);
        response.getWriter().write(objectMapper.writeValueAsString(map));
        response.getWriter().flush();
        response.getWriter().close();

    }

    @RequestMapping("/person/delete")
    @ResponseBody
    public Map<String,Object> deletePerson(HttpServletRequest request){
        String idArr = request.getParameter("idArr");
        String[] personArray = idArr.substring(0,idArr.length()-1).split(",");
        for(String personStr1:personArray){
            String[] proArray = personStr1.split("-");
            //如果是户主，将删除所有家庭信息
            if(proArray[2].equals("本人")){
                //先删除收入信息
                ymProduceIncomeService.deleteYmProduceIncomeByJtbh(proArray[1]);
                ymSalaryIncomeService.deleteYmSalaryIncomeByJtbh(proArray[1]);
                ymPropertyIncomeService.deleteYmPropertyIncomeByJtbh(proArray[1]);
                ymTransferIncomeService.deleteYmTransferIncomeByJtbh(proArray[1]);
                ymOutPovertyIncomeService.deleteYmOutPovertyIncomeByJtbh(proArray[1]);
                //删除人员信息
                ymPersonService.deleteYmPersonByJtbh(proArray[1]);
                //删除家庭条件信息
                ymFamilyStatusService.deleteYmFamilyStatusByJtbh(proArray[1]);
                ymFamilyService.deleteYmFamilyByJtbh(proArray[1]);
            }else{//不是户主，就只删除人员信息
                ymPersonService.deleteYmPersonByRybh(proArray[0]);
            }
        }

        Map<String,Object> map = new HashMap<>();
        map.put("status",1);
        map.put("result","success");
        return map;
    }


    @RequestMapping("/person/edit")
    public ModelAndView editPerson(HttpServletRequest request){

        String rybh = request.getParameter("rybh");
        String jtbh = request.getParameter("jtbh");
        //获取家庭信息
        YmFamily ymFamily = ymFamilyService.getYmFamilyByJtbh(jtbh);
        //获取家庭状况信息
        YmFamilyStatus ymFamilyStatus  = ymFamilyStatusService.getYmFamilyStatusByJtbh(jtbh);



        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("edit-ym-information");

        modelAndView.addObject("rootSysMenuList",request.getSession().getAttribute(VarConstant.SESSION_MENU));
        modelAndView.addObject("sessionUser",request.getSession().getAttribute(VarConstant.SESSION_USER));

        //写出对象
        modelAndView.addObject("ymFamily",ymFamily);
        modelAndView.addObject("ymFamilyStatus",ymFamilyStatus);

        return modelAndView;
    }


}
