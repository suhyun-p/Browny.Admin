package Browny.Admin.Controller;

import Browny.Admin.Model.ApiResponse.ClassDetail;
import Browny.Admin.Model.ApiResponse.ClassSimple;
import Browny.Admin.Model.ApiResponse.ClubResponse;
import Browny.Admin.Model.ApiResponse.UserSimple;
import Browny.Admin.Model.ClassDetailM;
import Browny.Admin.Model.ClassSimpleM;
import Browny.Admin.Model.ClubM;
import Browny.Admin.Model.UserSimpleM;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.client.RestTemplate;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping(value = "/")
public class AdminController {
    private String BrownyApi = "http://ec2-13-124-26-162.ap-northeast-2.compute.amazonaws.com:8080/api";

    @RequestMapping(value = "/")
    public String Index(Model model) { return "index"; }

    @RequestMapping(value = "/getClassSimpleList", method = RequestMethod.POST)
    @ResponseBody
    public List<ClassSimpleM> GetClassSimpleList(@RequestBody Map<String, Object> params) {
        Map<String, Object> resultMap = new HashMap<String, Object>();
        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<ClassSimple[]> ret = restTemplate.postForEntity(String.format("%s/class/getClassSimpleList", BrownyApi), params, ClassSimple[].class);

        List<ClassSimpleM> models = new ArrayList<>();
        for(ClassSimple  classSimple : ret.getBody()) {
            models.add(new ClassSimpleM(classSimple));
        }

        return models;
    }

    @RequestMapping(value = "/getInstructorList", method = RequestMethod.GET)
    @ResponseBody
    public List<UserSimpleM> GetInstructorList(HttpServletRequest httpServletRequest, Model model) {

        RestTemplate restTemplate = new RestTemplate();
        String url = String.format("%s/user/getUserSimpleList?instructor=true", BrownyApi);
        ResponseEntity<UserSimple[]> ret = restTemplate.getForEntity(url, UserSimple[].class);

        List<UserSimpleM> models = new ArrayList<>();
        for(UserSimple user : ret.getBody()) {
            models.add(new UserSimpleM(user));
        }

        return models;
    }

    @RequestMapping(value = "/getInstructor", method = RequestMethod.GET)
    @ResponseBody
    public UserSimpleM GetInstructor(HttpServletRequest httpServletRequest, Model model) {

        RestTemplate restTemplate = new RestTemplate();
        String userNo = httpServletRequest.getParameter("userNo");
        String url = String.format("%s/user/getUserDetail?userNo=%s", BrownyApi, userNo);
        ResponseEntity<UserSimple> ret = restTemplate.getForEntity(url, UserSimple.class);

        return new UserSimpleM(ret.getBody());
    }

    @RequestMapping(value = "/getClubList", method = RequestMethod.GET)
    @ResponseBody
    public List<ClubM> GetClubList(HttpServletRequest httpServletRequest, Model model) {

        RestTemplate restTemplate = new RestTemplate();
        String url = String.format("%s/club/getClubList", BrownyApi);
        ResponseEntity<ClubResponse[]> ret = restTemplate.getForEntity(url, ClubResponse[].class);

        List<ClubM> models = new ArrayList<>();
        for(ClubResponse club : ret.getBody()) {
            models.add(new ClubM(club));
        }

        return models;
    }

    @RequestMapping(value = "/getClassDetail", method = RequestMethod.GET)
    @ResponseBody
    public ClassDetailM GetClassDetail(HttpServletRequest httpServletRequest, Model model) {

        RestTemplate restTemplate = new RestTemplate();
        String classNo = httpServletRequest.getParameter("classNo");
        String url = String.format("%s/class/getClassDetail?classNo=%s", BrownyApi, classNo);
        ResponseEntity<ClassDetail> ret = restTemplate.getForEntity(url, ClassDetail.class);

        return new ClassDetailM(ret.getBody());
    }
}
