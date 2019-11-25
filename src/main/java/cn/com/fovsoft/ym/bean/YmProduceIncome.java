package cn.com.fovsoft.ym.bean;/*
 * Author:tpc
 * Date:2019-11-25 16:04:05
 * 功能描述:
 * version:生产收入实体类
 */

import java.io.Serializable;

public class YmProduceIncome implements Serializable {

    private String ryscsrbh     ;// '人员生产收入编号',
    private String jtbh         ;// '家庭编号，对应家庭表',
    private String xtdl         ;//'类别大类：01为生产经营性收入,02为生产经营支出',
    private String xtxl1        ;//'类别小类：01为种植业，02为林业，03为养殖业，04为其他',
    private String xtxl2        ;//'类别小类：01为品种，02为数量，03为金额，04为其他',
    private String nf           ;//'年份',
    private String yf13         ;//'1-3月的收入或者其他信息',
    private String yf46         ;//'4-6月的收入或者其他信息',
    private String yf79         ;//'7-9月的收入或者其他信息',
    private String yf10         ;//'10月的收入或者其他信息',
    private String yf11         ;//'11月的收入或者其他信息',
    private String yf12         ;//'12月的收入或者其他信息'


    public String getRyscsrbh() {
        return ryscsrbh;
    }

    public void setRyscsrbh(String ryscsrbh) {
        this.ryscsrbh = ryscsrbh;
    }

    public String getJtbh() {
        return jtbh;
    }

    public void setJtbh(String jtbh) {
        this.jtbh = jtbh;
    }

    public String getXtdl() {
        return xtdl;
    }

    public void setXtdl(String xtdl) {
        this.xtdl = xtdl;
    }

    public String getXtxl1() {
        return xtxl1;
    }

    public void setXtxl1(String xtxl1) {
        this.xtxl1 = xtxl1;
    }

    public String getXtxl2() {
        return xtxl2;
    }

    public void setXtxl2(String xtxl2) {
        this.xtxl2 = xtxl2;
    }

    public String getNf() {
        return nf;
    }

    public void setNf(String nf) {
        this.nf = nf;
    }

    public String getYf13() {
        return yf13;
    }

    public void setYf13(String yf13) {
        this.yf13 = yf13;
    }

    public String getYf46() {
        return yf46;
    }

    public void setYf46(String yf46) {
        this.yf46 = yf46;
    }

    public String getYf79() {
        return yf79;
    }

    public void setYf79(String yf79) {
        this.yf79 = yf79;
    }

    public String getYf10() {
        return yf10;
    }

    public void setYf10(String yf10) {
        this.yf10 = yf10;
    }

    public String getYf11() {
        return yf11;
    }

    public void setYf11(String yf11) {
        this.yf11 = yf11;
    }

    public String getYf12() {
        return yf12;
    }

    public void setYf12(String yf12) {
        this.yf12 = yf12;
    }
}
