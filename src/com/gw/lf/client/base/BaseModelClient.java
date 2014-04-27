/*
 * Copyright (C) 2013 GDer
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.gw.lf.client.base;

import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.core.client.GWT;

import com.gw.lf.base.shared.ConsoleGWTLogUtil;
import com.gw.lf.base.shared.EntryUtil;

import com.gw.lf.client.base.BaseObject;
import com.gw.lf.properties.base.BaseProperties;

public abstract class BaseModelClient implements EntryPoint {

    protected static String zackage = "com.test.client.base";
    protected static String zlass = "BaseModelClient";
    protected static String concreteZackage = "com.test.client";

    public abstract void setFormBean() throws Exception;
    public abstract void setEntryPoint() throws Exception;
    public abstract void setBaseTools() throws Exception;
    public abstract void setProperties() throws Exception;
    
    public abstract void setRPC() throws Exception;
    public abstract void setAuthenticateUser() throws Exception;
    
    public abstract void validateAuthenticateUser() throws Exception;

    public BaseObject baseObject = new BaseObject();
    public BaseLocale baseLocale;
    public BaseProperties baseProperties;
    
    protected ConsoleGWTLogUtil log = new ConsoleGWTLogUtil();
    protected EntryUtil entryUtil = new EntryUtil();

    public void onModuleLoad() {
	try {
	    log.trace(zackage, zlass, "onModuleLoad", "", "#");
	    this.setFormBean();
	    this.setEntryPoint();
	    this.setUrl();
	    this.setBaseTools();
	    this.baseLocale.setLocale();
	    this.baseProperties.setProperties(this.baseLocale.urlLocale);
	    this.setProperties();
	    
	    this.entryUtil.removeRootLayoutPanel(this.baseObject.getUrl(), this.baseObject.getEntryPoint());
	    if (!this.entryUtil.isEntryPoint) { // Control multiple entry point
		log.appendConsole();
		return;
	    }
	    
	    log.trace(zackage, zlass, "onModuleLoad", "", "#1");
	    this.setRPC();// run rpc
	    this.setAuthenticateUser();
	    this.validateAuthenticateUser();
	    log.appendConsole();

	} catch (Exception ex) {
	    log.error(zackage, zlass, "onModuleLoad.Exception", ex);
	    log.trace(zackage, zlass, "onModuleLoad.Exception", "", ex.getMessage());
	    log.appendConsole();
	}
    }

    public void setUrl() throws Exception {
    	log.trace(zackage, zlass, "setUrl", "", "#");
		String contextPath = this.baseObject.properties.get("ContextPath");
		String hostpageBaseUrl = GWT.getHostPageBaseURL(); 			
	//	baseObject.setUrl(hostpageBaseUrl + contextPath);
		baseObject.setUrl(hostpageBaseUrl + "");
		log.trace(zackage, zlass, "onModuleLoad", "hostpageBaseUrl.contextPath", hostpageBaseUrl + contextPath);
    }
}
