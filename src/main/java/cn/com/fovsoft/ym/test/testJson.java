package cn.com.fovsoft.ym.test;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @Author by tpc
 * @Date 2019/10/20 20:28
 * description:
 **/

public class testJson {

    public static void main(String[] args) throws JsonProcessingException {

        //用来序列化json数据的map
        Map<String,Object> map=new HashMap<>();
        ObjectMapper objectMapper = new ObjectMapper();
        List list1 = new ArrayList<>();
        map.put("tpc","tpc");
        map.put("1989",1989);
        list1.add("abc");
        list1.add("def");
        map.put("list1",list1);
        System.out.println(objectMapper.writeValueAsString(map));

    }
}
