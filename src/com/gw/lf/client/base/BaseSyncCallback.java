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

import com.google.gwt.user.client.ui.Composite;
import com.gw.lf.base.shared.ConsoleGWTLogUtil;
import com.gw.lf.base.shared.EntryUtil;
import com.gw.lf.base.shared.SyncCallback;
import com.gw.lf.properties.base.BaseProperties;
import com.gw.lf.client.base.BaseObject;

public abstract class BaseSyncCallback 
	extends Composite 
	implements SyncCallback {

    private final String zackage = "com.test.client.base";
    private final String zlass = "BaseSyncCallback";

    public BaseObject baseObject = new BaseObject();
    
    public ConsoleGWTLogUtil log = new ConsoleGWTLogUtil();
    
    public BaseProperties baseProperties;
    public BaseLocale baseLocale; 
    
    public EntryUtil entryUtil = new EntryUtil();

    public BaseSyncCallback(BaseObject baseObject) throws Exception {
	super();
	log.info(zackage, zlass, "BaseSyncCallback", "", "#");
	this.baseObject = baseObject;
    }

    public void callbackService() {
	log.trace(zackage, zlass, "callbackService", "", "#");
	try {
	    this.syncCallbackFormBinder();
	    this.syncCallbackValidationForm();
	    this.baseObject.setLog(log.toString());
	    this.syncCallbackService();
	    log.appendConsole();
	} catch (Exception e) {

	}
    }

    public void callbackSuccess(BaseObject baseObject) {
	log.trace(zackage, zlass, "callbackSuccess", "", "#");
	try {
	    this.syncCallbackServiceSuccess(baseObject);
	    this.syncCallbackServiceTrace();
	    this.syncCallbackServiceRedirect();
	    log.appendConsole();
	} catch (Exception e) {

	}
    }

    public void callbackFail() {
	log.trace(zackage, zlass, "callbackFail", "", "#");
	try {
	    this.syncCallbackServiceFail();
	    this.syncCallbackServiceTrace();
	    this.syncCallbackServiceRedirect();
	    log.appendConsole();

	} catch (Exception e) {

	}
    }

    @Override
    public void syncCallbackServiceRedirect() {
	log.trace(zackage, zlass, "redirect", "", this.baseObject.getRedirectUrl());
	if (this.baseObject.getRedirectUrl() != null) {
	    entryUtil.setUrlRedirect(this.baseObject.getRedirectUrl());
	}
    }
}