package cn.com.fovsoft.ym.entity.holders;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class YmQueryFamilyHolder {

    @Id
    private String jtbh;
    private String xxxzqhmz;
    private String lxdh;
    private String xm;
    private String sfzmhm;
    private String yhzgx;
    private String jhtpnd;
    private String pkhsx;
    private String bqfs;
    private String sfydfpbqh;

    private String nl;

    public String getJtbh() {
        return jtbh;
    }

    public void setJtbh(String jtbh) {
        this.jtbh = jtbh;
    }


    public String getXxxzqhmz() {
        return xxxzqhmz;
    }

    public void setXxxzqhmz(String xxxzqhmz) {
        this.xxxzqhmz = xxxzqhmz;
    }

    public String getLxdh() {
        return lxdh;
    }

    public void setLxdh(String lxdh) {
        this.lxdh = lxdh;
    }

    public String getXm() {
        return xm;
    }

    public void setXm(String xm) {
        this.xm = xm;
    }

    public String getSfzmhm() {
        return sfzmhm;
    }

    public void setSfzmhm(String sfzmhm) {
        this.sfzmhm = sfzmhm;
    }

    public String getYhzgx() {
        return yhzgx;
    }

    public void setYhzgx(String yhzgx) {
        this.yhzgx = yhzgx;
    }

    public String getJhtpnd() {
        return jhtpnd;
    }

    public void setJhtpnd(String jhtpnd) {
        this.jhtpnd = jhtpnd;
    }

    public String getPkhsx() {
        return pkhsx;
    }

    public void setPkhsx(String pkhsx) {
        this.pkhsx = pkhsx;
    }

    public String getBqfs() {
        return bqfs;
    }

    public void setBqfs(String bqfs) {
        this.bqfs = bqfs;
    }

    public String getSfydfpbqh() {
        return sfydfpbqh;
    }

    public void setSfydfpbqh(String sfydfpbqh) {
        this.sfydfpbqh = sfydfpbqh;
    }

    public String getNl() {
        return nl;
    }

    public void setNl(String nl) {
        this.nl = nl;
    }
}
