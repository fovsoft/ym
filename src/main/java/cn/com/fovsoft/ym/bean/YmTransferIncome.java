package cn.com.fovsoft.ym.bean;/*
 * @Author:tpc
 * @Date: 2019/11/26 15:59
 * 功能描述:转移性财产实体类
 * @version:
 */

public class YmTransferIncome {
    private String tra_bh   ;// '转移性收入编号',
    private String jtbh     ;//'家庭编号，对应家庭表',
    private String tra_xtlb ;// '转移性财产类别:01，计划生育金；0201，低保金A；0202，低保金B；0203，低保金C；03,特困供养金；04，养老保险金；05，生态补偿金（林业补贴）；06，困难残疾人生活补贴和重度残疾人护理补贴；07，农业补贴；08，高龄补贴；09，水库移民补贴；10，其他长期性的政策性补贴',
    private String tra_nf   ;//'年份',
    private String tra_yf13 ;//'1-3月的收入或者其他信息',
    private String tra_yf46 ;//'4-6月的收入或者其他信息',
    private String tra_yf79 ;//'7-9月的收入或者其他信息',
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

    public String getTra_yf13() {
        return tra_yf13;
    }

    public void setTra_yf13(String tra_yf13) {
        this.tra_yf13 = tra_yf13;
    }

    public String getTra_yf46() {
        return tra_yf46;
    }

    public void setTra_yf46(String tra_yf46) {
        this.tra_yf46 = tra_yf46;
    }

    public String getTra_yf79() {
        return tra_yf79;
    }

    public void setTra_yf79(String tra_yf79) {
        this.tra_yf79 = tra_yf79;
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
