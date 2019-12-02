package cn.com.fovsoft.az.ctrl;/*
 * @Author:tpc
 * @Date: 2019/12/2 11:40
 * 功能描述:安置点控制类
 * @version:
 */

import cn.com.fovsoft.az.bean.AzSettlement;
import cn.com.fovsoft.az.service.AzSettlementService;
import cn.com.fovsoft.common.util.DateUtil;
import cn.com.fovsoft.ym.util.UuidUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
public class AzSettlementCtrl {

    @Autowired
    private AzSettlementService azSettlementService;


    /*
     * Author:tpc
     * Date: 2019/12/2 11:51
     * Param: [request]
     * Return: java.util.Map<java.lang.String,java.lang.Object>
     * 功能描述: 安置点新增实现方法
     */
    @RequestMapping(value = "/settlement/add")
    @ResponseBody
    public Map<String,Object> addAzSettlement(HttpServletRequest request){
        //获取前端参数
        String xzqhdm  = request.getParameter("xzqhdm"  );//行政区划代码
        String azdmz   = request.getParameter("azdmz");//安置点名字
        String azfs    = request.getParameter("azfs"       );//安置方式

        //用来返回信息的封装对象
        Map<String,Object> map=new HashMap<>();
        //用来返回前端的信息
        int status = 0;
        String result = "";

        AzSettlement azSettlement = new AzSettlement();
        azSettlement.setAzdbh(UuidUtil.getRandomNum());//设置安置点编号
        azSettlement.setXzqhdm(xzqhdm);
        azSettlement.setAzdmz(azdmz);
        //判断安置方式
        if(azfs.equals("1")){
            azSettlement.setAzfs("集中安置");
        }else {
            azSettlement.setAzfs("分散安置");
        }
        azSettlement.setCjsj(DateUtil.getStringDate());
        azSettlement.setGxsj(DateUtil.getStringDate());

        //调用新增服务方法
        int resultNum = azSettlementService.addAzSettlement(azSettlement);

        if(resultNum<1) {
            status = 0;
            result = "error";
        }else {
            status = 1;
            result = "success";
        }
        //返回信息
        map.put("status",status);
        map.put("result",result);
        return map;
    }


    /*
     * Author:tpc
     * Date: 2019/12/2 16:17
     * Param: [request]
     * Return: java.util.Map<java.lang.String,java.lang.Object>
     * 功能描述: 获取单个安置点信息
     */
    @RequestMapping(value = "/settlement/getOneSettlement")
    @ResponseBody
    public Map<String,Object> getOneAzSettlement(HttpServletRequest request){
        String id = request.getParameter("id");
        //通过id查找
        AzSettlement azSettlement = azSettlementService.findAzSettlementById(id);
        //用来返回信息的封装对象
        Map<String,Object> map=new HashMap<>();
        //用来返回前端的信息
        map.put("azSettlement",azSettlement);
        return map;
    }


    /*
     * Author:tpc
     * Date: 2019/12/2 16:20
     * Param: [request]
     * Return: java.util.Map<java.lang.String,java.lang.Object>
     * 功能描述: 刷新安置点对应div
     */
    @RequestMapping(value = "/settlement/refreshDiv")
    @ResponseBody
    public Map<String,Object> refreshSettlementDiv(HttpServletRequest request){
        List<AzSettlement> azSettlementList = azSettlementService.findAllAzSettlement();
        //用来返回信息的封装对象
        Map<String,Object> map=new HashMap<>();
        //用来返回前端的信息
        map.put("azSettlementList",azSettlementList);
        return map;
    }


    @RequestMapping(value = "/settlement/edit")
    @ResponseBody
    public Map<String,Object> editAzSettlement(HttpServletRequest request){
        //获取前端参数
        String id = request.getParameter("id");
        String xzqhdm  = request.getParameter("xzqhdm"  );//行政区划代码
        String azdmz   = request.getParameter("azdmz");//安置点名字
        String azfs    = request.getParameter("azfs"       );//安置方式

        //用来返回信息的封装对象
        Map<String,Object> map=new HashMap<>();
        //用来返回前端的信息
        int status = 0;
        String result = "";

        AzSettlement azSettlement = new AzSettlement();
        azSettlement.setId(id);//设置安置点编号
        azSettlement.setXzqhdm(xzqhdm);
        azSettlement.setAzdmz(azdmz);
        //判断安置方式
        if(azfs.equals("1")){
            azSettlement.setAzfs("集中安置");
        }else {
            azSettlement.setAzfs("分散安置");
        }
        //azSettlement.setCjsj(DateUtil.getStringDate());
        azSettlement.setGxsj(DateUtil.getStringDate());

        //调用新增服务方法
        int resultNum = azSettlementService.updateAzSettlementById(azSettlement);

        if(resultNum<1) {
            status = 0;
            result = "error";
        }else {
            status = 1;
            result = "success";
        }
        //返回信息
        map.put("status",status);
        map.put("result",result);
        return map;
    }


    /*
     * Author:tpc
     * Date: 2019/12/2 17:15
     * Param: [request]
     * Return: java.util.Map<java.lang.String,java.lang.Object>
     * 功能描述: 响应前端删除安置点方法
     */
    @RequestMapping(value = "/settlement/delete")
    @ResponseBody
    public Map<String,Object> deleteAzSettlement(HttpServletRequest request){
        //获取前端参数
        String idArr = request.getParameter("idArr");
        idArr = idArr.substring(0,idArr.length()-1);
        if(idArr.length()>1){
            //直接删除
            azSettlementService.deleteAzSettlementById(idArr);
        }else {
            String[] idArray = idArr.split(",");
            for(String str:idArray){
                azSettlementService.deleteAzSettlementById(str);
            }
        }

        //返回信息
        //用来返回信息的封装对象
        Map<String,Object> map=new HashMap<>();
        map.put("status",1);
        map.put("result","success");
        return map;
    }



}
