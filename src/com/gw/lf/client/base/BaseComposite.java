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

public abstract class BaseComposite extends BaseSyncCallback {
    
    private final String zackage = "com.test.client.base";
    private final String zlass = "BaseComposite";

    protected abstract void setTools() throws Exception;
    protected abstract void setUiField() throws Exception;
    protected abstract void setUiBinder() throws Exception;
    protected abstract void setUiTrace() throws Exception;

    public BaseComposite(com.gw.lf.client.base.BaseObject baseObject) throws Exception {
	super(baseObject);
	log.info(zackage, zlass, "BaseComposite", "", "#");
	this.baseObject = baseObject;
    }
    
    public void setUiComposite() throws Exception { // call from concrete, tools declare in concrete
	log.trace(zackage, zlass, "setUiComposite", "", "#");
	this.setTools();
//	this.baseLocale.setLocale();
//	this.baseProperties.setProperties(this.baseLocale.urlLocale);
	this.setUiField();
	this.setUiBinder();
	this.setUiTrace();
    }
}