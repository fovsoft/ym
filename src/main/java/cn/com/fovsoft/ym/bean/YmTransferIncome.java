package cn.com.fovsoft.ym.bean;/*
 * @Author:tpc
 * @Date: 2019/11/26 15:59
 * 功能描述:转移性财产实体类
 * @version:
 */

import java.io.Serializable;

public class YmTransferIncome implements Serializable {
    private String tra_bh   ;//'转移性收入编号',
    private String jtbh     ;//'家庭编号，对应家庭表',
    private String tra_xtlb ;//'转移性财产类别:01，计划生育金；0201，低保金A；0202，低保金B；0203，低保金C；03,特困供养金；04，养老保险金；05，生态补偿金（林业补贴）；06，困难残疾人生活补贴和重度残疾人护理补贴；07，农业补贴；08，高龄补贴；09，水库移民补贴；10，其他长期性的政策性补贴',
    private String tra_nf   ;//'年份',
    private String tra_yf1  ;//'1月的收入或者其他信息',
    private String tra_yf2  ;//'2月的收入或者其他信息',
    private String tra_yf3  ;//'3月的收入或者其他信息',
    private String tra_yf4  ;//'4月的收入或者其他信息',
    private String tra_yf5  ;//'5月的收入或者其他信息',
    private String tra_yf6  ;//'6月的收入或者其他信息',
    private String tra_yf7  ;//'7月的收入或者其他信息',
    private String tra_yf8  ;//'8月的收入或者其他信息',
    private String tra_yf9  ;//'9月的收入或者其他信息',
    private String tra_yf10 ;//'10月的收入或者其他信息',
    private String tra_yf11 ;//'11月的收入或者其他信息',
    private String tra_yf12 ;//'12月的收入或者其他信息'

    public String getTra_bh() {
        return tra_bh;
    }

    public void setTra_bh(String tra_bh) {
        this.tra_bh = tra_bh;
    }

    public String getJtbh() {
        return jtbh;
    }

    public void setJtbh(String jtbh) {
        this.jtbh = jtbh;
    }

    public String getTra_xtlb() {
        return tra_xtlb;
    }

    public void setTra_xtlb(String tra_xtlb) {
        this.tra_xtlb = tra_xtlb;
    }

    public String getTra_nf() {
        return tra_nf;
    }

    public void setTra_nf(String tra_nf) {
        this.tra_nf = tra_nf;
    }

    public String getTra_yf1() {
        return tra_yf1;
    }

    public void setTra_yf1(String tra_yf1) {
        this.tra_yf1 = tra_yf1;
    }

    public String getTra_yf2() {
        return tra_yf2;
    }

    public void setTra_yf2(String tra_yf2) {
        this.tra_yf2 = tra_yf2;
    }

    public String getTra_yf3() {
        return tra_yf3;
    }

    public void setTra_yf3(String tra_yf3) {
        this.tra_yf3 = tra_yf3;
    }

    public String getTra_yf4() {
        return tra_yf4;
    }

    public void setTra_yf4(String tra_yf4) {
        this.tra_yf4 = tra_yf4;
    }

    public String getTra_yf5() {
        return tra_yf5;
    }

    public void setTra_yf5(String tra_yf5) {
        this.tra_yf5 = tra_yf5;
    }

    public String getTra_yf6() {
        return tra_yf6;
    }

    public void setTra_yf6(String tra_yf6) {
        this.tra_yf6 = tra_yf6;
    }

    public String getTra_yf7() {
        return tra_yf7;
    }

    public void setTra_yf7(String tra_yf7) {
        this.tra_yf7 = tra_yf7;
    }

    public String getTra_yf8() {
        return tra_yf8;
    }

    public void setTra_yf8(String tra_yf8) {
        this.tra_yf8 = tra_yf8;
    }

    public String getTra_yf9() {
        return tra_yf9;
    }

    public void setTra_yf9(String tra_yf9) {
        this.tra_yf9 = tra_yf9;
    }

    public String getTra_yf10() {
        return tra_yf10;
    }

    public void setTra_yf10(String tra_yf10) {
        this.tra_yf10 = tra_yf10;
    }

    public String getTra_yf11() {
        return tra_yf11;
    }

    public void setTra_yf11(String tra_yf11) {
        this.tra_yf11 = tra_yf11;
    }

    public String getTra_yf12() {
        return tra_yf12;
    }

    public void setTra_yf12(String tra_yf12) {
        this.tra_yf12 = tra_yf12;
    }
}
