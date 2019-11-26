package cn.com.fovsoft.ym.bean;/*
 * @Author:tpc
 * @Date: 2019/11/26 15:52
 * 功能描述:财产收入实体类
 * @version:
 */

public class YmPropertyIncome {

    private String    pro_bh        ;//财产性收入编号
    private String    jtbh          ;//家庭编号，对应家庭表
    private String    pro_xtlb      ;//财产收入类别：01，财产收益扶贫分红收入，02，其他
    private String    pro_nf        ;//年份
    private String    pro_yf13      ;//1-3月的收入或者其他信息
    private String    pro_yf46      ;//4-6月的收入或者其他信息
    private String    pro_yf79      ;//7-9月的收入或者其他信息
    private String    pro_yf10      ;//10月的收入或者其他信息
    private String    pro_yf11      ;//11月的收入或者其他信息
    private String    pro_yf12      ;//12月的收入或者其他信息


    public String getPro_bh() {
        return pro_bh;
    }

    public void setPro_bh(String pro_bh) {
        this.pro_bh = pro_bh;
    }

    public String getJtbh() {
        return jtbh;
    }

    public void setJtbh(String jtbh) {
        this.jtbh = jtbh;
    }

    public String getPro_xtlb() {
        return pro_xtlb;
    }

    public void setPro_xtlb(String pro_xtlb) {
        this.pro_xtlb = pro_xtlb;
    }

    public String getPro_nf() {
        return pro_nf;
    }

    public void setPro_nf(String pro_nf) {
        this.pro_nf = pro_nf;
    }

    public String getPro_yf13() {
        return pro_yf13;
    }

    public void setPro_yf13(String pro_yf13) {
        this.pro_yf13 = pro_yf13;
    }

    public String getPro_yf46() {
        return pro_yf46;
    }

    public void setPro_yf46(String pro_yf46) {
        this.pro_yf46 = pro_yf46;
    }

    public String getPro_yf79() {
        return pro_yf79;
    }

    public void setPro_yf79(String pro_yf79) {
        this.pro_yf79 = pro_yf79;
    }

    public String getPro_yf10() {
        return pro_yf10;
    }

    public void setPro_yf10(String pro_yf10) {
        this.pro_yf10 = pro_yf10;
    }

    public String getPro_yf11() {
        return pro_yf11;
    }

    public void setPro_yf11(String pro_yf11) {
        this.pro_yf11 = pro_yf11;
    }

    public String getPro_yf12() {
        return pro_yf12;
    }

    public void setPro_yf12(String pro_yf12) {
        this.pro_yf12 = pro_yf12;
    }
}
