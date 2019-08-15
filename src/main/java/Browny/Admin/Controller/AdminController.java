package Browny.Admin.Controller;

import Browny.Admin.Model.ApiResponse.ClassSimple;
import Browny.Admin.Model.ClassSimpleM;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.client.RestTemplate;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping(value = "/")
public class AdminController {
    private String BrownyApi = "http://ec2-13-124-26-162.ap-northeast-2.compute.amazonaws.com:8080/api";

    @RequestMapping(value = "/")
    public String Index(Model model) { return "index"; }

    @RequestMapping(value = "/getClassSimpleList", method = RequestMethod.GET)
    @ResponseBody
    public List<ClassSimpleM> GetClassSimpleList(HttpServletRequest httpServletRequest, Model model) {

        RestTemplate restTemplate = new RestTemplate();
        String type = httpServletRequest.getParameter("type");
        String value = httpServletRequest.getParameter("value");
        String url = String.format("%s/class/getClassSimpleList?type=%s&value=%s", BrownyApi, type, value);
        ResponseEntity<ClassSimple[]> ret = restTemplate.getForEntity(url, ClassSimple[].class);

        List<ClassSimpleM> models = new ArrayList<>();
        for(ClassSimple  classSimple : ret.getBody()) {
            models.add(new ClassSimpleM(classSimple));
        }

        return models;
    }
}
