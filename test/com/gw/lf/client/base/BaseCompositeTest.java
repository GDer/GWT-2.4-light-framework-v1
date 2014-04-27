package com.gw.lf.client.base;

public abstract class BaseCompositeTest extends BaseComposite {
    private static String zackage = "com.gw.lf.client.base";
    private static String zlass = "BaseCompositeTest";
    
    public BaseCompositeTest(com.gw.lf.client.base.BaseObject baseObject) throws Exception {
	super(baseObject);
	this.baseObject = baseObject;
	
//	this.baseLocale = localeUtil;
//	this.baseProperties = propertiesUtil;
	
//	this.baseLocale.setLocale();
//	this.baseProperties.setProperties(this.baseLocale.urlLocale);
    }
}
