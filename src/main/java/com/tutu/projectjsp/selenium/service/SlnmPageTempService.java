package com.tutu.projectjsp.selenium.service;

import java.util.List;

import com.tutu.projectjsp.common.page.Page;
import com.tutu.projectjsp.selenium.form.SlnmLocatorTempVo;
import com.tutu.projectjsp.selenium.form.SlnmPageTempVo;
import com.tutu.projectjsp.selenium.model.SlnmLocatorTemp;
import com.tutu.projectjsp.selenium.model.SlnmPageTemp;

public interface SlnmPageTempService {
    public Page<SlnmPageTemp> getPage(SlnmPageTempVo form);
    
    public SlnmPageTemp getSlnmPageTemp(Integer id);
    
    public SlnmPageTemp getSlnmPageTemp(String pagecode);
    
    public SlnmPageTemp getSlnmPageTemp(String casecode,String pagename);
    
    public List<SlnmPageTemp> getSlnmPageTempList();
    
    public void save(SlnmPageTempVo form);
    
    public void update(SlnmPageTempVo form);
    
    public void delete(Integer id);
    
    public void doCopyPage(SlnmPageTempVo form);
    
    public void changePageOrder(Integer id,Integer changedid);
    
    public SlnmLocatorTemp getSlnmLocatorTemp(Integer id);
    
    public SlnmLocatorTemp getSlnmLocatorTemp(String pagecode,String locatorname);
    
    public List<SlnmLocatorTemp> getSlnmLocatorTempList(String pagecode);
    
    public void doAddLocator(SlnmLocatorTempVo form);
    
    public void doUpdateLocator(SlnmLocatorTempVo form);
    
    public void doCopyLocator(SlnmLocatorTempVo form);
    
    public void doMoveLocator(SlnmLocatorTempVo form);
    
    public void doDeleteLocator(Integer id);
    
    public void changeLocatorOrder(Integer id,Integer changedid);
    
}
