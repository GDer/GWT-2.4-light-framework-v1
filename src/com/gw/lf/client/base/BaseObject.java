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

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.google.gwt.user.client.rpc.IsSerializable;

import com.gw.lf.base.shared.EntryPath;
import com.gw.lf.dao.base.BaseDao;

public class BaseObject implements IsSerializable, EntryPath {

    public String result;
    public String forward;
    public Map<String, Map<Integer, String[]>> dao = new HashMap<String, Map<Integer, String[]>>();
    public Map<String, List<BaseDao>> daoObject = new HashMap<String, List<BaseDao>>();
    public boolean isAuthenticateUser;
    public String entryPoint;
    public String url; // url from browser
    public String redirectUrl; // redirect url
    public String log;
    public String service;
    public Map<String, String> properties = new HashMap<String, String>();

    public BaseObject() {
    }

    public BaseObject(String result, 
            	    String forward,
            	    Map<String, Map<Integer, String[]>> dao,
            	    Map<String, List<BaseDao>> daoObject) {
	this.result = result;
	this.forward = forward;
	this.dao = dao;
	this.daoObject = daoObject;
    }

    public BaseObject(String result, String forward) {
	this.result = result;
	this.forward = forward;
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

    public Map<String, Map<Integer, String[]>> getDao() {
	return dao;
    }

    public void setDao(String key,
	    Map<Integer, String[]> dao) {
	this.dao.put(key, dao);
    }

    public Map<String, List<BaseDao>> getDaoObject() {
	return daoObject;
    }

    public void setDaoObject(String key,
	    List<BaseDao> daoObject) {
	this.daoObject.put(key, daoObject);
    }

    public boolean isAuthenticateUser() {
	return isAuthenticateUser;
    }

    public void setAuthenticateUser(boolean isAuthenticateUser) {
	this.isAuthenticateUser = isAuthenticateUser;
    }

    public String getEntryPoint() {
	return entryPoint;
    }

    public void setEntryPoint(String entryPoint) {
	this.entryPoint = entryPoint;
    }

    public String getUrl() {
	return url;
    }

    public void setUrl(String url) {
	this.url = url;
    }

    public String getRedirectUrl() {
	return redirectUrl;
    }

    public void setRedirectUrl(String redirectUrl) {
	this.redirectUrl = redirectUrl;
    }

    public String getLog() {
	return log;
    }

    public void setLog(String log) {
	this.log = log;
    }

    public String getService() {
	return service;
    }

    public void setService(String service) {
	this.service = service;
    }

    public String getProperties(String key) {
	return properties.get(key);
    }

    public void setProperties(String key, String properties) {
	this.properties.put(key, properties);
    }
}