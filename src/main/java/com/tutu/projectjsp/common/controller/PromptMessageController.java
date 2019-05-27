package com.tutu.projectjsp.common.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.tutu.projectjsp.base.controller.BasicController;
import com.tutu.projectjsp.common.constants.SysConstants;

/**
 * 提示消息
 * FileName:    PromptMessageController.java  
 * @author:     tutu 
 * @version:    1.0  
 * @date:   	2017年7月30日 上午10:25:52
 */
@Controller
@RequestMapping("/promptmessage")
public class PromptMessageController extends BasicController {
    
    /**
     * 清除提示消息
     * @param request
     * @author:	tutu
     * @date:	2017年6月14日 上午10:04:31
     */
    @RequestMapping("/removemessage")
    @ResponseBody
    public void removeflash() {
        HttpSession session = this.getSession();
        session.removeAttribute(SysConstants.FLASS_MESSAGE_KEY);
    }
}
