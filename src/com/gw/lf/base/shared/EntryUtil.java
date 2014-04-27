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

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.ui.RootLayoutPanel;
import com.gw.lf.client.base.BaseLocale;

public class EntryUtil {
    private static final String zackage = "com.test.util";
    private static final String zlass = "EntryUtil";

    private String baseUrl;
    private String url;
    private List<String> urlSplitList = new ArrayList<String>();
    private String entryPoint;
    public boolean isEntryPoint;

    public static native void setUrlRedirect(String url) /*-{
	$wnd.location.href = url;
    }-*/;

    public static native void setToken(String token) /*-{
	$wnd.history.pushState({}, '', token);
    }-*/;

    public void setForwarder(String path) {
	path = path.trim();
	Window.Location.assign(Window.Location.createUrlBuilder().setPath(path).buildString());
	// .setPath("/Joy/"+path)
	// String s =
	// Location.getHref().substring(Location.getHref().lastIndexOf("/"));
	// s = s.substring(0, s.indexOf("#")-1);
	// setToken(s);
    }

    public void removeRootLayoutPanel(String baseUrl, String entryPoint) throws Exception {
	this.isEntryPoint = false;
	this.baseUrl = baseUrl;
	this.url = Window.Location.getHref().trim();
	this.urlSplitList = Arrays.asList((String[]) this.url.split(this.baseUrl));
	this.entryPoint = "{1}{2}".replace("{1}", entryPoint).replace("{2}", BaseLocale.html);
	this.compare();
	this.removeRootLayoutPanel();
    }

    // layout will stack page to page, have to remove to 0
    private void removeRootLayoutPanel() throws Exception {
	if (this.isEntryPoint) {
	    int count = RootLayoutPanel.get().getWidgetCount();
	    for (int ix = 0; ix < count; ix++) {
		RootLayoutPanel.get().remove(ix);
	    }
	}
    }

    private void compare() throws Exception {
	for (int ix = 0; ix < urlSplitList.size(); ix++) {
	    String url = (String) urlSplitList.get(ix);
	    if (url.trim().startsWith(entryPoint.trim())) {
		this.isEntryPoint = true;
		return;
	    }
	}
    }
}
