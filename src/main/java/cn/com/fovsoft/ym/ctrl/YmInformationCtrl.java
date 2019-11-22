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
        ymFamily.setJtbh(jtbh);
        ymFamily.setXzqhdm(xzqhdm);
        ymFamily.setXxxzqhmz(xxxzqhmz);
        ymFamily.setLxdh(lxdh);
        ymFamily.setKhyh(khyh);
        ymFamily.setYhkh(yhkh);
        if(pkhsx.equals("ybpkh")){
            ymFamily.setPkhsx("一般贫困户");
        }else if(pkhsx.equals("dbpkh")){
            ymFamily.setPkhsx("一般贫困户");
        }else if(pkhsx.equals("tkgypkh")){
            ymFamily.setPkhsx("特困供养贫困户");
        }else {
            ymFamily.setPkhsx("其他");
        }
        if(sfdnytp.equals("yes")){
            ymFamily.setSfdnytp("是");
        }else {
            ymFamily.setSfdnytp("否");
        }
        ymFamily.setJhtpnd(jhtpnd);
        ymFamily.setFpnd(fpnd);
        ymFamily.setFpyy(fpyy);
        if(sfjls.equals("yes")){
            ymFamily.setSfjls("是");
        }else {
            ymFamily.setSfjls("否");
        }
        if(sfydfpbqh.equals("yes")){
            ymFamily.setSfydfpbqh("有搬迁意愿");
        }else {
            ymFamily.setSfydfpbqh("无搬迁意愿");
        }
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

        System.out.println(ymPersonNum);
        //获取家庭人员个数
        int personNum = Integer.parseInt(ymPersonNum);
        for(int i=0;i<personNum;i++){
            YmPerson ymPerson = new YmPerson();
            //获取对象属性
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

            System.out.println(xm);
            //判断前端值，并设置对象属性
            ymPerson.setJtbh(jtbh);
            ymPerson.setXm(xm);
            if(xb.equalsIgnoreCase("man")){
                ymPerson.setXb("男");
            }else {
                ymPerson.setXb("女");
            }
            ymPerson.setSfzmhm(sfzmhm);
            ymPerson.setQfjg(qfjg);
            ymPerson.setSfzyxqs(DateUtil.strToDate(sfzyxqs));
            ymPerson.setSfzyxqz(DateUtil.strToDate(sfzyxqz));
            ymPerson.setYhzgx(yhzgx);
            ymPerson.setMz(mz);
            ymPerson.setCsrq(DateUtil.strToDate(csrq));
            ymPerson.setZzmm(zzmm);
            ymPerson.setWhcd(whcd);
            if(zxsqk.equals("fzxs")){
                ymPerson.setZxsqk("非在校生");
            }else if(zxsqk.equals("xqjy")){
                ymPerson.setZxsqk("学前教育");
            }else if(zxsqk.equals("xx")){
                ymPerson.setZxsqk("小学");
            }else if(zxsqk.equals("nj7")){
                ymPerson.setZxsqk("七年级");
            }else if(zxsqk.equals("nj8")){
                ymPerson.setZxsqk("八年级");
            }else if(zxsqk.equals("nj9")){
                ymPerson.setZxsqk("九年级");
            }else if(zxsqk.equals("g1")){
                ymPerson.setZxsqk("高一");
            }else if(zxsqk.equals("g2")){
                ymPerson.setZxsqk("高二");
            }else if(zxsqk.equals("g3")){
                ymPerson.setZxsqk("高三");
            }else if(zxsqk.equals("zz1")){
                ymPerson.setZxsqk("中职一");
            }else if(zxsqk.equals("zz2")){
                ymPerson.setZxsqk("中职二");
            }else if(zxsqk.equals("zz3")){
                ymPerson.setZxsqk("中职三");
            }else if(zxsqk.equals("gz1")){
                ymPerson.setZxsqk("高职一");
            }else if(zxsqk.equals("gz2")){
                ymPerson.setZxsqk("高职二");
            }else if(zxsqk.equals("gz3")){
                ymPerson.setZxsqk("高职三");
            }else if(zxsqk.equals("jg1")){
                ymPerson.setZxsqk("技工一");
            }else if(zxsqk.equals("jg2")){
                ymPerson.setZxsqk("技工二");
            }else if(zxsqk.equals("jg3")){
                ymPerson.setZxsqk("技工三");
            }else if(zxsqk.equals("jg4")){
                ymPerson.setZxsqk("技工四");
            }else if(zxsqk.equals("bk1")){
                ymPerson.setZxsqk("本科一");
            }else if(zxsqk.equals("bk2")){
                ymPerson.setZxsqk("本科二");
            }else if(zxsqk.equals("bk3")){
                ymPerson.setZxsqk("本科三");
            }else if(zxsqk.equals("bk4")){
                ymPerson.setZxsqk("本科四");
            }else if(zxsqk.equals("bk5")){
                ymPerson.setZxsqk("本科五");
            }else if(zxsqk.equals("ssjys")){
                ymPerson.setZxsqk("硕士及以上");
            }else {
                ymPerson.setZxsqk("其他");
            }
            if(sxhcxyy.equals("yb")){
                ymPerson.setSxhcxyy("因病");
            }else if(sxhcxyy.equals("yj")){
                ymPerson.setSxhcxyy("因疾");
            }else if(sxhcxyy.equals("yx")){
                ymPerson.setSxhcxyy("厌学");
            }else if(sxhcxyy.equals("qt")){
                ymPerson.setSxhcxyy("其他");
            }else {
                ymPerson.setSxhcxyy("其他");
            }
            if(jkqk.equals("jk")){
                ymPerson.setJkqk("健康");
            }else if(sxhcxyy.equals("cj")){
                ymPerson.setJkqk("残疾");
            }else if(sxhcxyy.equals("db")){
                ymPerson.setJkqk("大病");
            }else if(sxhcxyy.equals("cqmxb")){
                ymPerson.setJkqk("长期慢性病");
            }else {
                ymPerson.setJkqk("其他");
            }

            if(ldjn.equals("ptldl")){
                ymPerson.setLdjn("普通劳动力");
            }else if(ldjn.equals("jnldl")){
                ymPerson.setLdjn("技能劳动力");
            }else if(ldjn.equals("rldl")){
                ymPerson.setLdjn("弱劳动力或半劳动力");
            }else if(ldjn.equals("ssldl")){
                ymPerson.setLdjn("丧失劳动力");
            }else {
                ymPerson.setLdjn("无劳动力");
            }

            if(sfhjpth.equals("yes")){
                ymPerson.setSfhjpth("是");
            }else {
                ymPerson.setSfhjpth("否");
            }

            if(sfxyjr.equals("yes")){
                ymPerson.setSfxyjr("是");
            }else {
                ymPerson.setSfxyjr("否");
            }

            if(sfcjylbx1.equals("yes")){
                ymPerson.setSfcjylbx1("是");
            }else {
                ymPerson.setSfcjylbx1("否");
            }

            if(sfcjsybx.equals("yes")){
                ymPerson.setSfcjsybx("是");
            }else {
                ymPerson.setSfcjsybx("否");
            }

            if(sfxsdb.equals("yes")){
                ymPerson.setSfxsdb("是");
            }else {
                ymPerson.setSfxsdb("否");
            }

            if(sfcjylbx2.equals("yes")){
                ymPerson.setSfcjylbx2("是");
            }else {
                ymPerson.setSfcjylbx2("否");
            }

            if(sfxsywbxbt.equals("yes")){
                ymPerson.setSfxsywbxbt("是");
            }else {
                ymPerson.setSfxsywbxbt("否");
            }
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
        ymFamilyStatus.setZpyy1(getZpyy(zpyy1));
        ymFamilyStatus.setZpyy2(getZpyy(zpyy2));
        ymFamilyStatus.setZpyy3(getZpyy(zpyy3));

        ymFamilyStatus.setNcjtrks(getMj(ncjtrks));
        ymFamilyStatus.setNdjtrks(getMj(ndjtrks));

        ymFamilyStatus.setGdmj(getMj(gdmj));
        ymFamilyStatus.setYxggmj(getMj(yxggmj));
        ymFamilyStatus.setLdmj(getMj(ldmj));
        ymFamilyStatus.setTghlmj(getMj(tghlmj));
        ymFamilyStatus.setLgmj(getMj(lgmj));
        ymFamilyStatus.setSmmj(getMj(smmj));
        ymFamilyStatus.setMcdmj(getMj(mcdmj));
        if(sfycyzfdtrdd.equals("yes")){
            ymFamilyStatus.setSfyltqydd("是");
        }else {
            ymFamilyStatus.setSfyltqydd("否");
        }
        if(sfycyzfdtrdd.equals("yes")){
            ymFamilyStatus.setSfycyzfdtrdd("是");
        }else {
            ymFamilyStatus.setSfycyzfdtrdd("否");
        }

        if(sftscyd.equals("yes")){
            ymFamilyStatus.setSftscyd("是");
        }else {
            ymFamilyStatus.setSftscyd("否");
        }
        if(sftshyd.equals("yes")){
            ymFamilyStatus.setSftshyd("是");
        }else {
            ymFamilyStatus.setSftshyd("否");
        }
        if(sftgbds.equals("yes")){
            ymFamilyStatus.setSftgbds("是");
        }else {
            ymFamilyStatus.setSftgbds("否");
        }
        if(yssfkn.equals("yes")){
            ymFamilyStatus.setYssfkn("是");
        }else {
            ymFamilyStatus.setYssfkn("否");
        }

        if(yssfaq.equals("yes")){
            ymFamilyStatus.setYssfaq("是");
        }else {
            ymFamilyStatus.setYssfaq("否");
        }

        ymFamilyStatus.setZfmj(getMj(zfmj));
        if(ywwscs.equals("yes")){
            ymFamilyStatus.setYwwscs("是");
        }else {
            ymFamilyStatus.setYwwscs("否");
        }
        if(sfwfh.equals("yes")){
            ymFamilyStatus.setSfwfh("是");
        }else {
            ymFamilyStatus.setSfwfh("否");
        }
        ymFamilyStatus.setWfdj(wfdj);
        ymFamilyStatus.setWgnd(wgnd);
        ymFamilyStatus.setZfjg(zfjg);
        if(sfjrnmzyhzs.equals("yes")){
            ymFamilyStatus.setSfjrnmzyhzs("是");
        }else {
            ymFamilyStatus.setSfjrnmzyhzs("否");
        }

        ymFamilyStatus.setYczgljl(getMj(yczgljl));
        if(rhllx.equals("nt-road")){
            ymFamilyStatus.setRhllx("泥土路");
        }else if(rhllx.equals("ss-road")){
            ymFamilyStatus.setRhllx("沙石路");
        }else if(rhllx.equals("yh-road")){
            ymFamilyStatus.setRhllx("硬化路");
        }else if(rhllx.equals("other")){
            ymFamilyStatus.setRhllx("其他");
        }

        if(zyrllx.equals("cc")){
            ymFamilyStatus.setZyrllx("柴草");
        }else if(rhllx.equals("gcf")){
            ymFamilyStatus.setZyrllx("干畜粪");
        }else if(rhllx.equals("mt")){
            ymFamilyStatus.setZyrllx("煤炭");
        }else if(rhllx.equals("qjny")){
            ymFamilyStatus.setZyrllx("清洁能源");
        }else if(rhllx.equals("other")){
            ymFamilyStatus.setZyrllx("其他");
        }
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
     * Date: 2019/11/21 16:39
     * Param: [zpyy1]
     * Return: java.lang.String
     * 功能描述: 根据致贫原因代码，获取中文原因
     */
    public String getZpyy(String zpyy1){
        String resultStr = "";
        if(zpyy1.equals("for-sick")){
            resultStr = "因病";
        }else if(zpyy1.equals("for-disable")){
            resultStr = "因残";
        }else if(zpyy1.equals("for-study")){
            resultStr = "因学";
        }else if(zpyy1.equals("for-suffer")){
            resultStr = "因灾";
        }else if(zpyy1.equals("for-marry")){
            resultStr = "因婚";
        }else if(zpyy1.equals("less-land")){
            resultStr = "缺土地";
        }else if(zpyy1.equals("less-water")){
            resultStr = "缺水";
        }else if(zpyy1.equals("less-skill")){
            resultStr = "缺技术";
        }else if(zpyy1.equals("less-labor")){
            resultStr = "缺劳动力";
        }else if(zpyy1.equals("less-money")){
            resultStr = "缺资金";
        }else if(zpyy1.equals("traffic-behind")){
            resultStr = "交通条件落后";
        }else if(zpyy1.equals("less-self-power")){
            resultStr = "自身发展动力不足";
        }else if(zpyy1.equals("for-lose")){
            resultStr = "因丧";
        }else if(zpyy1.equals("other")){
            resultStr = "其他";
        }
        return resultStr;
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
