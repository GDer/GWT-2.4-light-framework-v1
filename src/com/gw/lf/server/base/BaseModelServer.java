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

package com.gw.lf.server.base;

import com.gw.lf.base.shared.ConsoleLog4jUtil;
import com.gw.lf.base.shared.EntryUtil;
import com.gw.lf.base.shared.SessionUtil;

import com.gw.lf.client.base.BaseLocale;
import com.gw.lf.client.base.BaseObject;

import com.google.gwt.user.server.rpc.RemoteServiceServlet;

import javax.servlet.http.HttpServletRequest;

@SuppressWarnings("serial")
public abstract class BaseModelServer extends RemoteServiceServlet implements BaseServer {

    private final static String zackage = BaseModelServer.class.getPackage().toString();
    private final static String zlass = BaseModelServer.class.getSimpleName();

    public ConsoleLog4jUtil log4j;
    public EntryUtil entryUtil;
    public SessionUtil sessionUtil;
    public BaseSessionObject baseSessionObject;
    
    public HttpServletRequest getRequest() { /* gwt request */
	return getThreadLocalRequest();
    }

    public abstract BaseObject serverModel(BaseObject baseObject) throws Exception; /* abstract function */

    public BaseObject server(BaseObject baseObject) {
	try {
	    this.log4j = new ConsoleLog4jUtil(this.getRequest(),
		    baseObject.getProperties("FileSize"),
		    baseObject.getProperties("FileCount"),
		    ConsoleLog4jUtil.STATUS_LOG_MILLISECONDE);
	    this.entryUtil = new EntryUtil();
	    this.sessionUtil = new SessionUtil();
	    this.baseSessionObject = new BaseSessionObject();

	    this.sessionUtil.setRequest(this.getRequest());
	    this.baseSessionObject = (BaseSessionObject) this.sessionUtil.getSession();
	    
	    this.trace(baseObject);
	    baseObject = this.serverModel(baseObject);
	    
	} catch (Exception ex) {
	    this.log4j.error(String.format(ConsoleLog4jUtil.TRACE_FORMAT, zackage, zlass, "server.catch **", "#"), ex);
	    this.log4j.appendFile();
	    baseObject.setForward(baseObject.RESULT_SYSTEM_ERROR);
	    baseObject.setResult(baseObject.RESULT_SYSTEM_ERROR);
	}
	
	this.log4j.appendFile();
	return baseObject;
    }

    public BaseObject controller(BaseObject baseObject, BaseSessionObject baseSessionObject) throws Exception {
	this.log4j.trace(String.format(ConsoleLog4jUtil.TRACE_FORMAT, zackage, zlass, "controller", "sessionUser.getResult()"), baseSessionObject.getResult());
	this.log4j.trace(String.format(ConsoleLog4jUtil.TRACE_FORMAT, zackage, zlass, "controller", "sessionUser.getForward()"), baseSessionObject.getForward());
	baseObject.setResult(baseSessionObject.getResult());
	baseObject.setForward(baseSessionObject.getForward());
	String redirectUrl = String.format("%s%s%s%s%s",
                                		baseObject.getProperties("ContextPath"),
                                		baseObject.getForward(), 
                                		BaseLocale.html, 
                                		BaseLocale.locale,
                                		baseObject.getProperties("locale"));
	baseObject.setRedirectUrl(redirectUrl);
	this.sessionUtil.setSession(baseSessionObject);
	return baseObject;
    }

    public void trace(BaseObject baseObject) throws Exception {
	this.log4j.trace(String.format(ConsoleLog4jUtil.TRACE_FORMAT, zackage, zlass, "server", ""), "#");
	this.log4j.trace(String.format(ConsoleLog4jUtil.TRACE_FORMAT, zackage, zlass, "", "FileSize"), baseObject.getProperties("FileSize"));
	this.log4j.trace(String.format(ConsoleLog4jUtil.TRACE_FORMAT, zackage, zlass, "", "log"), baseObject.getLog());
    }
}