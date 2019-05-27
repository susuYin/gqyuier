package com.tutu.projectjsp.base.controller;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.io.UnsupportedEncodingException;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.beanutils.BeanUtils;
import org.apache.commons.beanutils.ConvertUtils;
import org.apache.commons.beanutils.converters.IntegerConverter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.ModelAttribute;

import com.tutu.projectjsp.base.form.BasicVo;
import com.tutu.projectjsp.common.bean.PromptMessage;
import com.tutu.projectjsp.common.constants.SysConstants;
import com.tutu.projectjsp.common.page.Page;

/**
 * 
 * FileName:    BasicController.java  
 * @author:     tutu 
 * @version:    1.0  
 * @date:   	2017年7月29日 下午6:07:16
 */
public abstract class BasicController {
    protected Logger logger = LoggerFactory.getLogger(this.getClass());
    
    @Autowired
    private HttpServletRequest request;
    @Autowired
    private HttpServletResponse response;
    
    protected final String SYSTEM_ERROR = "系统错误，请重新操作!";
    /**
     * 操作成功页面
     */
    protected final String OPT_SUCCESS = "/pages/opt_success";
    
    /**
     * 在controller每个方法执行前被执行
     * @author:	tutu
     * @date:	2017年6月9日 上午10:16:09
     */
    @ModelAttribute
    public void execute(){
        //访问路径
        String path = request.getServletPath();
        //当前访问路径
        request.setAttribute("currPath", path);
    }
    
    /**
     * 实现表单数据到JavaBean数据之间的封装
     * @param c
     * @return
     * @author:	tutu
     * @date:	2017年6月8日 上午10:08:01
     */
    protected <T> T getFormValues(Class<T> c) {
        try {
            //得到要转换Bean的类型
            T bean = c.newInstance();
            //获取表单参数
            Map map = request.getParameterMap(); 
            ConvertUtils.register(new IntegerConverter(null), Integer.class); 
            //构建Bean
            BeanUtils.populate(bean, map);
            
            return bean;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * 获取单个表单参数
     * @param name
     * @return
     * @author: tutu
     * @date:   2017年6月16日 上午11:05:48
     */
    protected String getParameter(String name) {
        return request.getParameter(name);
    }

    /**
     * 
     * @return
     * @author:	tutu
     * @date:	2017年7月29日 下午6:17:10
     */
    protected HttpSession getSession() {
        return request.getSession();
    }
    
    /**
     * 获取登录用户
     * @return
     * @author: tutu
     * @date:   2017年6月13日 上午9:13:40
     */
    protected Object getSysUser(){
        HttpSession session = request.getSession();
        Object sysOperator = session.getAttribute(SysConstants.USER_SESSION_KEY);
        
        return sysOperator;
    }
    
    /**
     * 
     * @param name
     * @param objvalue
     * @author:	tutu
     * @date:	2017年6月16日 下午5:48:02
     */
    protected void setBeanValue(String name, Object objvalue){
        request.setAttribute(name, objvalue);        
    }
    
    /**
     * 保存分页信息
     * @param page
     * @param form
     */
    protected void savePageInfo(Page page,BasicVo form){
        request.setAttribute("page", page);
        request.setAttribute("query", form);
    }
    
   /**
    * 操作成功提示消息
    * @param msg
    * @author:	tutu
    * @date:	2017年7月29日 下午6:22:36
    */
    protected void setSuccess(String msg){
        PromptMessage flashMessage = new PromptMessage();
        flashMessage.setSuccess(msg);
        HttpSession session = request.getSession();
        session.setAttribute(SysConstants.FLASS_MESSAGE_KEY, flashMessage);
    }
    
    /**
     * 操作失败提示消息
     * @param msg
     * @author:	tutu
     * @date:	2017年7月29日 下午6:22:44
     */
    protected void setError(String msg){
        PromptMessage flashMessage = new PromptMessage();
        flashMessage.setError(msg);
        HttpSession session = request.getSession();
        session.setAttribute(SysConstants.FLASS_MESSAGE_KEY, flashMessage);
    }
    
    protected void download(String filepath,String filename) {
        response.setHeader("content-type", "application/octet-stream");  
        response.setContentType("application/octet-stream");
        
        //中文编码
        String as = filename;
        try {
            filename = new String(as.getBytes("GB2312"), "ISO_8859_1");
        } catch (UnsupportedEncodingException e1) {
            e1.printStackTrace();
        } 
        as = filename;
        response.setHeader("Content-Disposition", "attachment;filename=" + as);
        
        File file=new File(filepath);  
        BufferedInputStream fis = null;
        OutputStream fos = null;
        try {
            fis = new BufferedInputStream(new FileInputStream(file));
            fos = response.getOutputStream();
            byte[] temp = new byte[1024];
            while (true) {
                if (fis.available() < 1024) {
                    int remain;
                    while ((remain = fis.read()) != -1) {
                        fos.write(remain);
                    }
                    break;
                } else {
                    fis.read(temp);
                    //将阵列资料写入目的档案 
                    fos.write(temp);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (fis != null) {
                try {
                    fis.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if (fos != null) {
                try {
                    fos.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
    
    public HttpServletRequest getRequest() {
        return request;
    }
    
}
