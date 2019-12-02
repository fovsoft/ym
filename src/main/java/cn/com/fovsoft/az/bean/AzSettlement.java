package cn.com.fovsoft.az.bean;/*
 * @Author:tpc
 * @Date: 2019/12/2 10:10
 * 功能描述:安置点实体类
 * @version:
 */

import java.io.Serializable;

public class AzSettlement implements Serializable {

    private String id          ;
    private String azdbh       ;
    private String xzqhdm      ;
    private String azdmz       ;
    private String azfs        ;
    private String cjsj        ;
    private String gxsj        ;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getAzdbh() {
        return azdbh;
    }

    public void setAzdbh(String azdbh) {
        this.azdbh = azdbh;
    }

    public String getXzqhdm() {
        return xzqhdm;
    }

    public void setXzqhdm(String xzqhdm) {
        this.xzqhdm = xzqhdm;
    }

    public String getAzdmz() {
        return azdmz;
    }

    public void setAzdmz(String azdmz) {
        this.azdmz = azdmz;
    }

    public String getAzfs() {
        return azfs;
    }

    public void setAzfs(String azfs) {
        this.azfs = azfs;
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
}
