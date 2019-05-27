package com.tutu.projectjsp.base.form;

import com.tutu.projectjsp.common.page.PageQueryInfo;

/**
 * 
 * Filename:    BaseVo.java  
 * Description: 
 * Company:     tutu.com
 * @author:     tutu 
 * Create at:   2017年6月9日 上午9:48:37
 */
public class BasicVo extends PageQueryInfo {
    //
    String jsonstring;

    public String getJsonstring() {
        return jsonstring;
    }

    public void setJsonstring(String jsonstring) {
        this.jsonstring = jsonstring;
    }
    
}
