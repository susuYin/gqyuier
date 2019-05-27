package com.tutu.projectjsp.index.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.tutu.projectjsp.base.controller.BasicController;

/**
 * 
 * FileName:    IndexController.java  
 * @author:     tutu 
 * @version:    1.0  
 * @date:   	2017年7月29日 下午10:35:21
 */
@Controller
public class IndexController extends BasicController {
    private final String MAIN_PATH = "/pages/";
    private final String INDEX_PAGE = MAIN_PATH + "index";
    
    @RequestMapping("/")
    public String index() {
        
        return INDEX_PAGE;
    }
    
    @RequestMapping("/testDialog")
    public String testDialog() {
        
        return "/pages/testDialog";
    }
}
