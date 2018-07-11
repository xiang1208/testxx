package com.ssm.controller;

import java.util.ArrayList;
import java.util.List;
import javax.annotation.Resource;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;


/**
 * user控制器
 * 
 * @author YaoQi
 */

@Controller
@RequestMapping("/U")
public class UserController {
    @ResponseBody
    @RequestMapping("/")
    public String test() {
        return "successGGG";
    }
    
}