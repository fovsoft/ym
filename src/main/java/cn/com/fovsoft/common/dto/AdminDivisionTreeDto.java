package cn.com.fovsoft.common.dto;/*
 * Author:tpc
 * Date:2019-11-11 15:46
 * 功能描述: 行政区划代码树对应表
 * version:
 */

import java.util.List;
import java.util.Map;

public class AdminDivisionTreeDto {

    private String nodeid;
    private String text;
    private List<AdminDivisionTreeDto> nodes;

    public String getNodeid() {
        return nodeid;
    }

    public void setNodeid(String nodeid) {
        this.nodeid = nodeid;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }


    public List<AdminDivisionTreeDto> getNodes() {
        return nodes;
    }

    public void setNodes(List<AdminDivisionTreeDto> nodes) {
        this.nodes = nodes;
    }
}
