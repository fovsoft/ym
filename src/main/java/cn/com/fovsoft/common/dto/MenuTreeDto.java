package cn.com.fovsoft.common.dto;/*
 * Author:tpc
 * Date:2019-11-07 17:32
 * 功能描述: 用来封装菜单树的对象
 * version:
 */

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MenuTreeDto {



    private String nodeid;
    private String text;
    private Map<String,Object> state;
    private List<MenuTreeDto> nodes;


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

    public List<MenuTreeDto> getNodes() {
        return nodes;
    }

    public void setNodes(List<MenuTreeDto> nodes) {
        this.nodes = nodes;
    }

    public Map<String, Object> getState() {
        return state;
    }

    public void setState(Map<String, Object> state) {
        this.state = state;
    }
}
