package Browny.Admin.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping(value = "/")
public class AdminController {
    private String BrownyApi = "http://ec2-13-124-26-162.ap-northeast-2.compute.amazonaws.com:8080/api";

    @RequestMapping(value = "/")
    public String Index(Model model) { return "index"; }
}
