package cn.com.fovsoft.az.bean;/*
 * @Author:tpc
 * @Date: 2019/11/29 17:25
 * 功能描述:安置户信息表实体类
 * @version:
 */

import java.io.Serializable;

public class AzSettlementHousehold implements Serializable {
    private String id        ;//         '主键值',
    private String azdbh     ;//         '安置点编号',
    private String jtbh      ;//         '家庭编号',
    private String hz        ;//         '户主',
    private String ldfh      ;//         '楼栋房号',
    private String ndfqrw    ;//         '年度搬迁任务',
    private String bqlx      ;//         '搬迁类型：1，建档立卡贫困户；2，同步搬迁户',
    private String qcdsj     ;//         '迁出底市级',
    private String qcdxj     ;//         '迁出地县级',
    private String qcdxxdz   ;//         '迁出地详细地址',
    private String qcdlx     ;//     '迁出地类型：1，一类；2，二类；3，三类；4，四类',
    private String jtsyhrk   ;// '家庭受益户人口',
    private String zfmj      ;//   '住房面积',
    private String zczj      ;// '自筹资金',
    private String bqrzsj    ;//  '搬迁入住时间',
    private String sjrzsj    ;//  '实际入住时间',
    private String sfsjrzmln ;//     '是否实际入住满两年',
    private String yyzf      ;//         '原有住房',
    private String yzfmj     ;//   '原住房面积',
    private String ccjf      ;//         '拆除旧房',
    private String bhzfzl    ;//         '保护住房种类',
    private String ccsj      ;//  '拆除时间',
    private String ccjfmj    ;//   '拆除旧房面积',
    private String dxcfjl    ;//         '兑现拆房奖励',
    private String fkfl      ;//         '复垦复绿',
    private String fkflmj    ;//   '复垦复绿面积',
    private String cyfcxm    ;//         '产业扶持项目',
    private String nnhdcyfczj;// '年内获得产业扶持资金',
    private String tpqk      ;//         '脱贫情况',
    private String hkqy      ;//     '户口迁移',
    private String fczbl     ;//     '房子证办理',
    private String lxdh      ;//         '联系电话'


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

    public String getJtbh() {
        return jtbh;
    }

    public void setJtbh(String jtbh) {
        this.jtbh = jtbh;
    }

    public String getHz() {
        return hz;
    }

    public void setHz(String hz) {
        this.hz = hz;
    }

    public String getLdfh() {
        return ldfh;
    }

    public void setLdfh(String ldfh) {
        this.ldfh = ldfh;
    }

    public String getNdfqrw() {
        return ndfqrw;
    }

    public void setNdfqrw(String ndfqrw) {
        this.ndfqrw = ndfqrw;
    }

    public String getBqlx() {
        return bqlx;
    }

    public void setBqlx(String bqlx) {
        this.bqlx = bqlx;
    }

    public String getQcdsj() {
        return qcdsj;
    }

    public void setQcdsj(String qcdsj) {
        this.qcdsj = qcdsj;
    }

    public String getQcdxj() {
        return qcdxj;
    }

    public void setQcdxj(String qcdxj) {
        this.qcdxj = qcdxj;
    }

    public String getQcdxxdz() {
        return qcdxxdz;
    }

    public void setQcdxxdz(String qcdxxdz) {
        this.qcdxxdz = qcdxxdz;
    }

    public String getQcdlx() {
        return qcdlx;
    }

    public void setQcdlx(String qcdlx) {
        this.qcdlx = qcdlx;
    }

    public String getJtsyhrk() {
        return jtsyhrk;
    }

    public void setJtsyhrk(String jtsyhrk) {
        this.jtsyhrk = jtsyhrk;
    }

    public String getZfmj() {
        return zfmj;
    }

    public void setZfmj(String zfmj) {
        this.zfmj = zfmj;
    }

    public String getZczj() {
        return zczj;
    }

    public void setZczj(String zczj) {
        this.zczj = zczj;
    }

    public String getBqrzsj() {
        return bqrzsj;
    }

    public void setBqrzsj(String bqrzsj) {
        this.bqrzsj = bqrzsj;
    }

    public String getSjrzsj() {
        return sjrzsj;
    }

    public void setSjrzsj(String sjrzsj) {
        this.sjrzsj = sjrzsj;
    }

    public String getSfsjrzmln() {
        return sfsjrzmln;
    }

    public void setSfsjrzmln(String sfsjrzmln) {
        this.sfsjrzmln = sfsjrzmln;
    }

    public String getYyzf() {
        return yyzf;
    }

    public void setYyzf(String yyzf) {
        this.yyzf = yyzf;
    }

    public String getYzfmj() {
        return yzfmj;
    }

    public void setYzfmj(String yzfmj) {
        this.yzfmj = yzfmj;
    }

    public String getCcjf() {
        return ccjf;
    }

    public void setCcjf(String ccjf) {
        this.ccjf = ccjf;
    }

    public String getBhzfzl() {
        return bhzfzl;
    }

    public void setBhzfzl(String bhzfzl) {
        this.bhzfzl = bhzfzl;
    }

    public String getCcsj() {
        return ccsj;
    }

    public void setCcsj(String ccsj) {
        this.ccsj = ccsj;
    }

    public String getCcjfmj() {
        return ccjfmj;
    }

    public void setCcjfmj(String ccjfmj) {
        this.ccjfmj = ccjfmj;
    }

    public String getDxcfjl() {
        return dxcfjl;
    }

    public void setDxcfjl(String dxcfjl) {
        this.dxcfjl = dxcfjl;
    }

    public String getFkfl() {
        return fkfl;
    }

    public void setFkfl(String ffl) {
        this.fkfl = ffl;
    }

    public String getFkflmj() {
        return fkflmj;
    }

    public void setFkflmj(String fkflmj) {
        this.fkflmj = fkflmj;
    }

    public String getCyfcxm() {
        return cyfcxm;
    }

    public void setCyfcxm(String cyfcxm) {
        this.cyfcxm = cyfcxm;
    }

    public String getNnhdcyfczj() {
        return nnhdcyfczj;
    }

    public void setNnhdcyfczj(String nnhdcyfczj) {
        this.nnhdcyfczj = nnhdcyfczj;
    }

    public String getTpqk() {
        return tpqk;
    }

    public void setTpqk(String tpqk) {
        this.tpqk = tpqk;
    }

    public String getHkqy() {
        return hkqy;
    }

    public void setHkqy(String hkqy) {
        this.hkqy = hkqy;
    }

    public String getFczbl() {
        return fczbl;
    }

    public void setFczbl(String fczbl) {
        this.fczbl = fczbl;
    }

    public String getLxdh() {
        return lxdh;
    }

    public void setLxdh(String lxdh) {
        this.lxdh = lxdh;
    }
}
