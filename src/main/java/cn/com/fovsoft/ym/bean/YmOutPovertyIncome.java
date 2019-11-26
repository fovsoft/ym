package cn.com.fovsoft.ym.bean;/*
 * @Author:tpc
 * @Date: 2019/11/26 16:07
 * 功能描述:不计入家庭脱贫应用项目
 * @version:
 */

public class YmOutPovertyIncome {
    private String    pov_bh   ;// '不计入家庭稳定脱贫收入编号',
    private String    jtbh     ;// '家庭编号，对应家庭表',
    private String    pov_xtlb ;// '转移性财产类别:01，教育保障类(雨露计划补助、"两后生"培训补助、教育助学金等)；02，医疗保障类(城乡居民基本医疗保险、大病保险、医疗救助、财政补助(补充商业医疗保险)等.需注明医疗费用总额及获得的报销和补助金额)；03,住房保障类(易地扶贫搬迁、危房改造等补助)；04，产业奖补类；05，金融类(扶贫小额贷款)）；06，社会保障类(临时救助金等)；07，保险赔付金；08，残疾人补贴(除困难残疾人生活补贴和重度残疾人护理补贴)；09，捐赠金、慰问金、短期性赡养金、抚养金等；10，短期性抚恤金、优待金、补助金、保健金、伤残治疗费、护理费、丧葬费；11，其他短期性(3年以下，含3年)的政策性补助',
    private String    pov_nf   ;// '年份',
    private String    pov_yf13 ;// '1-3月的收入或者其他信息',
    private String    pov_yf46 ;// '4-6月的收入或者其他信息',
    private String    pov_yf79 ;// '7-9月的收入或者其他信息',
    private String    pov_yf10 ;// '10月的收入或者其他信息',
    private String    pov_yf11 ;// '11月的收入或者其他信息',
    private String    pov_yf12 ;// '12月的收入或者其他信息'


    public String getPov_bh() {
        return pov_bh;
    }

    public void setPov_bh(String pov_bh) {
        this.pov_bh = pov_bh;
    }

    public String getJtbh() {
        return jtbh;
    }

    public void setJtbh(String jtbh) {
        this.jtbh = jtbh;
    }

    public String getPov_xtlb() {
        return pov_xtlb;
    }

    public void setPov_xtlb(String pov_xtlb) {
        this.pov_xtlb = pov_xtlb;
    }

    public String getPov_nf() {
        return pov_nf;
    }

    public void setPov_nf(String pov_nf) {
        this.pov_nf = pov_nf;
    }

    public String getPov_yf13() {
        return pov_yf13;
    }

    public void setPov_yf13(String pov_yf13) {
        this.pov_yf13 = pov_yf13;
    }

    public String getPov_yf46() {
        return pov_yf46;
    }

    public void setPov_yf46(String pov_yf46) {
        this.pov_yf46 = pov_yf46;
    }

    public String getPov_yf79() {
        return pov_yf79;
    }

    public void setPov_yf79(String pov_yf79) {
        this.pov_yf79 = pov_yf79;
    }

    public String getPov_yf10() {
        return pov_yf10;
    }

    public void setPov_yf10(String pov_yf10) {
        this.pov_yf10 = pov_yf10;
    }

    public String getPov_yf11() {
        return pov_yf11;
    }

    public void setPov_yf11(String pov_yf11) {
        this.pov_yf11 = pov_yf11;
    }

    public String getPov_yf12() {
        return pov_yf12;
    }

    public void setPov_yf12(String pov_yf12) {
        this.pov_yf12 = pov_yf12;
    }
}
