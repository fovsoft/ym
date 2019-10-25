package cn.com.fovsoft.ym.ctrl;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.io.OutputStream;

/**
 * @author: by tpc
 * @date: 2019/10/25 16:30
 * @description:
 **/

@Controller
public class YmInformationCtrl {


    @RequestMapping(value = "/ym/add1")
    @ResponseBody
    public void addYmInformation(HttpServletRequest request){

        System.out.println(request.getParameter("szs"));
    }
}
