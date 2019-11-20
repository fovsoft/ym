package cn.com.fovsoft.ym.ctrl;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.io.OutputStream;

/**
 * @author: by tpc
 * @date: 2019/10/25 16:30
 * @description:
 **/

@Controller
public class YmInformationCtrl {


    @RequestMapping(value = "/ym/add1")
    @ResponseBody
    public void addYmInformation(HttpServletRequest request){

        String xzqhdm       = request.getParameter("xzqhdm");            // '家庭地址代码，对应行政区划表',
        String xxxzqhmz      = request.getParameter("xxxzqhmz");           // '家庭地址，对应行政区划表',
        String lxdh      = request.getParameter("lxdh");           // '联系电话',
        String khyh      = request.getParameter("khyh");           // '开户银行（选填）',
        String yhkh      = request.getParameter("yhkh");           // '银行卡号（选填）',
        String pkhsx     = request.getParameter("pkhsx");          // '贫困户属性',
        String sfdnytp   = request.getParameter("sfdnytp");        // '是否当年预脱贫',
        String jhtpnd    = request.getParameter("jhtpnd");         // '计划脱贫年度',
        String fpnd      = request.getParameter("fpnd");           // '返贫年度',
        String fpyy      = request.getParameter("fpyy");           // '返贫原因',
        String sfjls     = request.getParameter("sfjls");          // '是否军烈属',
        String sfydfpbqh = request.getParameter("sfydfpbqh");      // '是否异地扶贫搬迁户',
        String bqfs      = request.getParameter("bqfs");           // '搬迁方式',
        String bqdz      = request.getParameter("bqdz");            // '搬迁地址'

        String ymPerson = request.getParameter("ym_person");
        String ymPersonNum = request.getParameter("ym_person_num");
        System.out.println(ymPerson);
        System.out.println(ymPersonNum);

    }
}
