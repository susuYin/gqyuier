package com.tutu.projectjsp.user.service;

import com.tutu.projectjsp.common.page.Page;
import com.tutu.projectjsp.system.model.SysSystem;
import com.tutu.projectjsp.user.form.SysUserVo;
import com.tutu.projectjsp.user.model.SysUser;

/**
 * 
 * FileName:    SysUserService.java  
 * @author:     tutu 
 * @version:    1.0  
 * @date:   	2017年7月29日 下午11:26:07
 */
public interface SysUserService {
    public Page<SysUser> getPage(SysUserVo form);
    
    public SysUser getSysUser(Integer id);
    
    public SysUser getSysUser(String usercode);
    
    public void save(SysUserVo form);
    
    public void update(SysUserVo form);
    
    public void delete(Integer id);
    
    public SysSystem getQxSysSystem(String usercode,String syscode);
    
    public SysSystem getLoginSysSystem(String usercode,String syscode);
    
    public void doSetUserQx(SysUserVo form);
    
}
