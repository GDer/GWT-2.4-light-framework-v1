package com.gw.lf.client.base;

import com.gw.lf.client.base.BaseModuleLogin;

public abstract class BaseModuleLoginTest extends BaseModuleLogin {
    private static String zackage = "com.gw.lf.client.base";
    private static String zlass = "BaseModuleLoginTest";
    
//  protected LocaleUtil localeUtil = new LocaleUtil();
//  protected PropertiesUtil propertiesUtil = new PropertiesUtil();
    @Override
    public void setBaseTools() throws Exception {
//	    this.baseLocale = this.localeUtil;
//	    this.baseProperties = this.propertiesUtil;
    }
    
    @Override
    public void setProperties() throws Exception {
//    	this.baseObject.setProperties("FileCount", this.propertiesUtil.log.gwtFileCount());
//    	this.baseObject.setProperties("FileSize", this.propertiesUtil.log.gwtFileSize());
//    	this.baseObject.setProperties("ContextPath", this.propertiesUtil.project.contextPath());
	
//	this.baseObject.setProperties("FileCount", "3");
//    	this.baseObject.setProperties("FileSize", "100000");
//    	this.baseObject.setProperties("ContextPath", "");
//	
//    	this.baseObject.setProperties("locale", this.baseLocale.urlLocale);
    }
    
    @Override
    public void validateAuthenticateUser() throws Exception {
//	if (this.baseObject.isAuthenticateUser()) {
//	    final IsFriendServiceAsync isFriendService = GWT.create(IsFriendService.class);
//    		isFriendService.server(this.baseObject, new AsyncCallback<BaseObject>() {
//    		public void onSuccess(BaseObject baseObject) { // not authenticate user redirect to login page 
//    		    log.trace(zackage, zlass, "isFriendService.server.onSuccess", "", "#");
//    		    if (baseObject.getResult().equals(baseObject.BYE)) {
//    			EntryUtil.setUrlRedirect(baseObject.getRedirectUrl());
//    		    }
//    		}
//    				
//    		public void onFailure(Throwable caught) {
//    		    log.trace(zackage, zlass, "isFriendService.server.onFailure", "", "#");
//    		    EntryUtil.setUrlRedirect(baseObject.getRedirectUrl());
//    		}
//    	     });
//	}
    }
    
}
