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

public class BaseSessionObject {
    private final static String zackage = "com.gw.lf.server.base";
    private final static String zlass = "BaseSessionObject";
    
    public String result;
    public String forward;
//    public boolean isLogin; 

    public BaseSessionObject() {
    }

    public BaseSessionObject(
	    String result, 
	    String forward,
	    boolean isLogin) { 
	this.result = result;
	this.forward = forward;
//	this.isLogin = isLogin;
    }

    public String getResult() {
	return result;
    }

    public void setResult(String result) {
	this.result = result;
    }

    public String getForward() {
	return forward;
    }

    public void setForward(String forward) {
	this.forward = forward;
    }

//    public boolean isLogin() {
//        return isLogin;
//    }
//
//    public void setLogin(boolean isLogin) {
//        this.isLogin = isLogin;
//    }
}
