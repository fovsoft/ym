package cn.com.fovsoft.ym.bean;/*
 * @Author:tpc
 * @Date: 2019/12/17 17:16
 * 功能描述:
 * @version:
 */

import java.io.Serializable;

public class YmIncomeSum implements Serializable {
    private String id           ;//   '主键',
    private String jtbh         ;//'家庭编号，对应家庭表',
    private String rks          ;//人口数',
    private String sum_nf       ;//'年份',
    private String sum_produce  ;//'生产收入综合',
    private String sum_produce1 ;//'生产支出综合',
    private String sum_salary   ;//'工资收入综合',
    private String sum_property ;//'财产收入综合',
    private String sum_transfer ;//'转移性收入综合',
    private String sum_poverty  ;//'不计入收入综合'


    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getJtbh() {
        return jtbh;
    }

    public void setJtbh(String jtbh) {
        this.jtbh = jtbh;
    }

    public String getRks() {
        return rks;
    }

    public void setRks(String rks) {
        this.rks = rks;
    }

    public String getSum_nf() {
        return sum_nf;
    }

    public void setSum_nf(String sum_nf) {
        this.sum_nf = sum_nf;
    }

    public String getSum_produce() {
        return sum_produce;
    }

    public void setSum_produce(String sum_produce) {
        this.sum_produce = sum_produce;
    }

    public String getSum_produce1() {
        return sum_produce1;
    }

    public void setSum_produce1(String sum_produce1) {
        this.sum_produce1 = sum_produce1;
    }

    public String getSum_salary() {
        return sum_salary;
    }

    public void setSum_salary(String sum_salary) {
        this.sum_salary = sum_salary;
    }

    public String getSum_property() {
        return sum_property;
    }

    public void setSum_property(String sum_property) {
        this.sum_property = sum_property;
    }

    public String getSum_transfer() {
        return sum_transfer;
    }

    public void setSum_transfer(String sum_transfer) {
        this.sum_transfer = sum_transfer;
    }

    public String getSum_poverty() {
        return sum_poverty;
    }

    public void setSum_poverty(String sum_poverty) {
        this.sum_poverty = sum_poverty;
    }
}
