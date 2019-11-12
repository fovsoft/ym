package cn.com.fovsoft.common.bean;/*
 * Author:tpc
 * Date:2019-11-11 15:42
 * 功能描述:行政区划实体表
 * version:
 */

import java.util.Date;
import java.util.List;

public class AdministrativeDivision {


    private String id         ;   // 主键信息
    private String xzqhdm     ;   //'行政区划代码',
    private String xzqhmz     ;   //'行政区划名字',
    private String xxxzqhmz   ;   //'详细行政区划名字',
    private String sjxzqhdm   ;   //'上级行政区划代码',
    private String xzqhcj     ;   //行政区划层级
    private String fzjg       ;   //'发证机关',
    private String xzqhlb     ;   //'类别',
    private String yzbm       ;   //'邮政编码',
    private String cjsj       ;   // '创建时间',
    private String gxsj       ;   // '更新时间'


    private List<AdministrativeDivision> administrativeDivisionChildList; //用来存放子行政区划的列表


    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getXzqhdm() {
        return xzqhdm;
    }

    public void setXzqhdm(String xzqhdm) {
        this.xzqhdm = xzqhdm;
    }

    public String getXzqhmz() {
        return xzqhmz;
    }

    public void setXzqhmz(String xzqhmz) {
        this.xzqhmz = xzqhmz;
    }

    public String getXxxzqhmz() {
        return xxxzqhmz;
    }

    public void setXxxzqhmz(String xxxzqhmz) {
        this.xxxzqhmz = xxxzqhmz;
    }

    public String getSjxzqhdm() {
        return sjxzqhdm;
    }

    public void setSjxzqhdm(String sjxzqhdm) {
        this.sjxzqhdm = sjxzqhdm;
    }

    public String getFzjg() {
        return fzjg;
    }

    public void setFzjg(String fzjg) {
        this.fzjg = fzjg;
    }

    public String getXzqhlb() {
        return xzqhlb;
    }

    public void setXzqhlb(String xzqhlb) {
        this.xzqhlb = xzqhlb;
    }

    public String getYzbm() {
        return yzbm;
    }

    public void setYzbm(String yzbm) {
        this.yzbm = yzbm;
    }

    public String getCjsj() {
        return cjsj;
    }

    public void setCjsj(String cjsj) {
        this.cjsj = cjsj;
    }

    public String getGxsj() {
        return gxsj;
    }

    public void setGxsj(String gxsj) {
        this.gxsj = gxsj;
    }

    public String getXzqhcj() {
        return xzqhcj;
    }

    public void setXzqhcj(String xzqhcj) {
        this.xzqhcj = xzqhcj;
    }

    public List<AdministrativeDivision> getAdministrativeDivisionChildList() {
        return administrativeDivisionChildList;
    }

    public void setAdministrativeDivisionChildList(List<AdministrativeDivision> administrativeDivisionChildList) {
        this.administrativeDivisionChildList = administrativeDivisionChildList;
    }
}
