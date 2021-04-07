package com.std.aqs.api;

import com.std.aqs.common.interceptor.CurrentUser;
import com.std.aqs.common.interceptor.LoginUser;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class IndexController {

    @GetMapping("/")
    public String index(@LoginUser CurrentUser user) {
        return "index";
    }
}
