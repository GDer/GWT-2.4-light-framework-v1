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

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import com.google.gwt.user.client.Window;

public abstract class BaseLocale {
    private final static String zackage = "com.test.client.base";
    private final static String zlass = "BaseLocale";
    
    public static final String localePipe = "?";
    public static final String html = ".html";
    public static final String locale = "?locale=";
    public static final String localeKey = "locale";

    protected abstract void setLocaleList() throws Exception;
    
    private String href;
    private List<String> urlList = new ArrayList<String>();
    public List<String> listLocale = new ArrayList<String>();
    public String urlLocale;
    
    public void setLocale() throws Exception {
	this.urlLocale = "";
	this.setLocaleList();
	this.href = Window.Location.getHref().trim();
	this.urlList = Arrays.asList((String[]) this.href.split("\\" + localePipe));
	this.setUrlLocale();
    }

    private void setUrlLocale() throws Exception {
	for (int ix = 0; ix < this.urlList.size(); ix++) {
	    String url = localePipe + (String) urlList.get(ix);
	    for (int ia = 0; ia < this.listLocale.size(); ia++) {
		String locale = BaseLocale.locale + (String) listLocale.get(ia);
		if (locale.startsWith(url)) {
		    this.urlLocale = (String) listLocale.get(ia);
		    return;  
		}
	    }
	}
    }
}