package cn.com.fovsoft.ym.ctrl;

import cn.com.fovsoft.common.util.DateUtil;
import cn.com.fovsoft.ym.bean.YmFamily;
import cn.com.fovsoft.ym.bean.YmFamilyStatus;
import cn.com.fovsoft.ym.bean.YmPerson;
import cn.com.fovsoft.ym.service.YmFamilyService;
import cn.com.fovsoft.ym.service.YmFamilyStatusService;
import cn.com.fovsoft.ym.service.YmPersonService;
import cn.com.fovsoft.ym.util.UuidUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.io.OutputStream;
import java.util.HashMap;
import java.util.Map;

/**
 * @author: by tpc
 * @date: 2019/10/25 16:30
 * @description:
 **/

@Controller
public class YmInformationCtrl {

    @Autowired
    YmFamilyService ymFamilyService;

    @Autowired
    YmPersonService ymPersonService;

    @Autowired
    YmFamilyStatusService ymFamilyStatusService;


    @RequestMapping(value = "/ym/add1")
    @ResponseBody
    public Map<String,Object> addYmInformation(HttpServletRequest request){



        //获取家庭基本信息
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

        //写入家庭基本信息对象
        YmFamily ymFamily = new YmFamily();

        String jtbh = UuidUtil.getRandomNum();
        String jtbh1 = request.getParameter("jtbh");

        //获取前端是新增还是修改信息
        String myMethod = request.getParameter("myMethod");
        //如果是修改，就先删除信息，然后进行写入
        if(myMethod.equals("edit")){
            ymFamilyStatusService.deleteYmFamilyStatusByJtbh(jtbh1);
            ymPersonService.deleteYmPersonByJtbh(jtbh1);
            ymFamilyService.deleteYmFamilyByJtbh(jtbh1);
            jtbh=jtbh1;

        }

        ymFamily.setJtbh(jtbh);
        ymFamily.setXzqhdm(xzqhdm);
        ymFamily.setXxxzqhmz(xxxzqhmz);
        ymFamily.setLxdh(lxdh);
        ymFamily.setKhyh(khyh);
        ymFamily.setYhkh(yhkh);
        ymFamily.setPkhsx(pkhsx);
        ymFamily.setSfdnytp(sfdnytp);
        ymFamily.setJhtpnd(jhtpnd);
        ymFamily.setFpnd(fpnd);
        ymFamily.setFpyy(fpyy);
        ymFamily.setSfjls(sfjls);
        ymFamily.setSfydfpbqh(sfydfpbqh);
        ymFamily.setBqfs(bqfs);
        ymFamily.setBqdz(bqdz);

        //写入家庭信息
        int return_num = ymFamilyService.addYmFamily(ymFamily);

        //用来返回结果的信息
        int status = 1;
        String result = "success";
        //判断写入情况
        if(return_num<1){
            status = 0;
            result = "error";
        }
        return_num = 0;

        //String ymPerson = request.getParameter("ym_person");
        String ymPersonNum = request.getParameter("ym_person_num");

        //获取家庭人员个数
        int personNum = Integer.parseInt(ymPersonNum);
        for(int i=0;i<personNum;i++){
            YmPerson ymPerson = new YmPerson();
            //获取对象属性
            String rybh      = request.getParameter("ym_person["+i+"][rybh]");
            String jtbh2     = request.getParameter("ym_person["+i+"][jtbh]");
            String xm        = request.getParameter("ym_person["+i+"][xm]");
            String xb        = request.getParameter("ym_person["+i+"][xb]");
            String sfzmhm    = request.getParameter("ym_person["+i+"][sfzmhm]");
            String qfjg      = request.getParameter("ym_person["+i+"][qfjg]");
            String sfzyxqs   = request.getParameter("ym_person["+i+"][sfzyxqs]");
            String sfzyxqz   = request.getParameter("ym_person["+i+"][sfzyxqz]");
            String yhzgx     = request.getParameter("ym_person["+i+"][yhzgx]");
            String mz        = request.getParameter("ym_person["+i+"][mz]");
            String csrq      = request.getParameter("ym_person["+i+"][csrq]");
            String zzmm      = request.getParameter("ym_person["+i+"][zzmm]");
            String whcd      = request.getParameter("ym_person["+i+"][whcd]");
            String zxsqk     = request.getParameter("ym_person["+i+"][zxsqk]");
            String sxhcxyy   = request.getParameter("ym_person["+i+"][sxhcxyy]");
            String jkqk      = request.getParameter("ym_person["+i+"][jkqk]");
            String ldjn      = request.getParameter("ym_person["+i+"][ldjn]");
            String sfhjpth   = request.getParameter("ym_person["+i+"][sfhjpth]");
            String sfxyjr    = request.getParameter("ym_person["+i+"][sfxyjr]");
            String sfcjylbx1 = request.getParameter("ym_person["+i+"][sfcjylbx1]");
            String sfcjsybx  = request.getParameter("ym_person["+i+"][sfcjsybx]");
            String sfxsdb    = request.getParameter("ym_person["+i+"][sfxsdb]");
            String sfcjylbx2 = request.getParameter("ym_person["+i+"][sfcjylbx2]");
            String sfxsywbxbt= request.getParameter("ym_person["+i+"][sfxsywbxbt]");
            String lxdh2      = request.getParameter("ym_person["+i+"][lxdh]");

            //判断前端值，并设置对象属性
            ymPerson.setJtbh(jtbh);
            ymPerson.setXm(xm);
            ymPerson.setXb(xb);
            ymPerson.setSfzmhm(sfzmhm);
            ymPerson.setQfjg(qfjg);
            ymPerson.setSfzyxqs(DateUtil.strToDate(sfzyxqs));
            ymPerson.setSfzyxqz(DateUtil.strToDate(sfzyxqz));
            ymPerson.setYhzgx(yhzgx);
            ymPerson.setMz(mz);
            ymPerson.setCsrq(DateUtil.strToDate(csrq));
            ymPerson.setZzmm(zzmm);
            ymPerson.setWhcd(whcd);
            ymPerson.setZxsqk(zxsqk);
            ymPerson.setSxhcxyy(sxhcxyy);
            ymPerson.setJkqk(jkqk);
            ymPerson.setLdjn(ldjn);
            ymPerson.setSfhjpth(sfhjpth);
            ymPerson.setSfxyjr(sfxyjr);
            ymPerson.setSfcjylbx1(sfcjylbx1);
            ymPerson.setSfcjsybx(sfcjsybx);
            ymPerson.setSfcjylbx2(sfcjylbx2);
            ymPerson.setSfxsdb(sfxsdb);
            ymPerson.setSfxsywbxbt(sfxsywbxbt);


            ymPerson.setLxdh(lxdh2);
            //写入家庭人员信息
            return_num = ymPersonService.addYmPerson(ymPerson);
        }

        //判断写入情况
        if(return_num<1){
            status = 0;
            result = "error";
        }
        return_num = 0;

        //获取家庭基本生活条件信息
        String zpyy1        = request.getParameter("zpyy1");
        String zpyy2        = request.getParameter("zpyy2");
        String zpyy3        = request.getParameter("zpyy3");
        String ncjtrks      = request.getParameter("ncjtrks");
        String ndjtrks      = request.getParameter("ndjtrks");
        String gdmj         = request.getParameter("gdmj");
        String yxggmj       = request.getParameter("yxggmj");
        String ldmj         = request.getParameter("ldmj");
        String tghlmj       = request.getParameter("tghlmj");
        String lgmj         = request.getParameter("lgmj");
        String smmj         = request.getParameter("smmj");
        String mcdmj        = request.getParameter("mcdmj");
        String sfyltqydd    = request.getParameter("sfyltqydd");
        String sfycyzfdtrdd = request.getParameter("sfycyzfdtrdd");
        String sftscyd      = request.getParameter("sftscyd");
        String sftshyd      = request.getParameter("sftshyd");
        String sftgbds      = request.getParameter("sftgbds");
        String yssfkn       = request.getParameter("yssfkn");
        String yssfaq       = request.getParameter("yssfaq");
        String zfmj         = request.getParameter("zfmj");
        String ywwscs       = request.getParameter("ywwscs");
        String sfwfh        = request.getParameter("sfwfh");
        String wfdj         = request.getParameter("wfdj");
        String wgnd         = request.getParameter("wgnd");
        String zfjg         = request.getParameter("zfjg");
        String sfjrnmzyhzs  = request.getParameter("sfjrnmzyhzs");
        String yczgljl      = request.getParameter("yczgljl");
        String rhllx        = request.getParameter("rhllx");
        String zyrllx       = request.getParameter("zyrllx");
        String bgqksm       = request.getParameter("bgqksm");

        //设置实体对象属性
        YmFamilyStatus ymFamilyStatus = new YmFamilyStatus();

        ymFamilyStatus.setJtbh(jtbh);
        ymFamilyStatus.setZpyy1(zpyy1);
        ymFamilyStatus.setZpyy2(zpyy2);
        ymFamilyStatus.setZpyy3(zpyy3);

        ymFamilyStatus.setNcjtrks(getMj(ncjtrks));
        ymFamilyStatus.setNdjtrks(getMj(ndjtrks));

        ymFamilyStatus.setGdmj(getMj(gdmj));
        ymFamilyStatus.setYxggmj(getMj(yxggmj));
        ymFamilyStatus.setLdmj(getMj(ldmj));
        ymFamilyStatus.setTghlmj(getMj(tghlmj));
        ymFamilyStatus.setLgmj(getMj(lgmj));
        ymFamilyStatus.setSmmj(getMj(smmj));
        ymFamilyStatus.setMcdmj(getMj(mcdmj));
        ymFamilyStatus.setSfyltqydd(sfyltqydd);
        ymFamilyStatus.setSfycyzfdtrdd(sfycyzfdtrdd);
        ymFamilyStatus.setSftscyd(sftscyd);
        ymFamilyStatus.setSftshyd(sftshyd);
        ymFamilyStatus.setSftgbds(sftgbds);
        ymFamilyStatus.setYssfkn(yssfkn);
        ymFamilyStatus.setYssfaq(yssfaq);
        ymFamilyStatus.setZfmj(getMj(zfmj));
        ymFamilyStatus.setYwwscs(ywwscs);
        ymFamilyStatus.setSfwfh(sfwfh);
        ymFamilyStatus.setWfdj(wfdj);
        ymFamilyStatus.setWgnd(wgnd);
        ymFamilyStatus.setZfjg(zfjg);
        ymFamilyStatus.setSfjrnmzyhzs(sfjrnmzyhzs);
        ymFamilyStatus.setYczgljl(getMj(yczgljl));
        ymFamilyStatus.setRhllx(rhllx);
        ymFamilyStatus.setZyrllx(zyrllx);
        ymFamilyStatus.setBgqksm(bgqksm);

        return_num = ymFamilyStatusService.addYmFamilyStatus(ymFamilyStatus);

        //判断写入情况
        if(return_num<1){
            status = 0;
            result = "error";
        }
        return_num = 0;
        Map<String,Object> map = new HashMap<>();
        map.put("status",status);
        map.put("result",result);
        return map;
    }

    /*
     * Author:tpc
     * Date: 2019/11/21 16:41
     * Param: [mj]
     * Return: java.lang.String
     * 功能描述: 根据前端获取的面积值是否为空，来设置面积值是否为0
     */
    public String getMj(String mj){
        if(mj.equals("")){
            mj = "0";
        }
        return mj;
    }






}
