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

package com.gw.lf.base.shared;

import javax.servlet.http.HttpServletRequest;
import com.gw.lf.server.base.BaseSessionObject;

public class SessionUtil {
    private final static String zackage = SessionUtil.class.getPackage().toString();
    private final static String zlass = SessionUtil.class.getSimpleName();

    public final static String SESSION_KEY = "SESSION";

    public HttpServletRequest request;

    public void setRequest(HttpServletRequest request) throws Exception {
	this.request = request;
    }

    public void setSession(BaseSessionObject baseSessionObject) throws Exception {
	this.request.getSession().setAttribute(SessionUtil.SESSION_KEY, baseSessionObject);
    }

    public BaseSessionObject getSession() throws Exception {
	BaseSessionObject baseSessionObject = (BaseSessionObject) this.request.getSession().getAttribute(SessionUtil.SESSION_KEY);
	if (baseSessionObject != null) {
	    return baseSessionObject;
	}
	return new BaseSessionObject();
    }

    public boolean isLogin() throws Exception {
	BaseSessionObject baseSessionObject = (BaseSessionObject) this.request.getSession().getAttribute(SessionUtil.SESSION_KEY);
	if (baseSessionObject == null) {
	    return false;
	}
//	if (baseSessionObject.isLogin()) {
//	    return true;
//	}
	return false;
    }

    public void resetSession() throws Exception {
	this.request.getSession().setAttribute(SessionUtil.SESSION_KEY, null);
    }
}
