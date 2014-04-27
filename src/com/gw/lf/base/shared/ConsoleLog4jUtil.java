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

import java.io.PrintWriter;
import java.io.StringWriter;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.logging.FileHandler;
import java.util.logging.Logger;
import java.util.logging.SimpleFormatter;

import javax.servlet.http.HttpServletRequest;

import com.gw.lf.util.Log4jUtil;


public class ConsoleLog4jUtil {

    private final static String zackage = ConsoleLog4jUtil.class.getPackage().toString();
    private final static String zlass = ConsoleLog4jUtil.class.getSimpleName();

    public final static String TRACE_FORMAT = "%s.[%s].[@%s].[@%s]";
    public final static String STATUS_LOG_MILLISECONDE = "STATUS_LOG_MILLISECONDE";
    // private final String STATUS_1 = "STATUS_1";
    // private final String STATUS_2 = "STATUS_2";
    private final String ON = "ON";
    private final String OFF = "OFF";
    private final String LOG_FILE = "D:\\Gwt.log";

    private HttpServletRequest request;
    private List<String> logList = new ArrayList<String>();
    private String fileSize;
    private String fileCount;
    private String status = "";

    public ConsoleLog4jUtil(HttpServletRequest request, String fileSize,
	    String fileCount, String status) {
	this.request = request;
	this.fileSize = fileSize;
	this.fileCount = fileCount;
	this.status = status;
	this.request.setAttribute(status, this.logList);
    }

    public void error(String title, Exception ex) {
	String stackTrace = "";
	StringWriter writerStr = new StringWriter();
	PrintWriter printerWriter = new PrintWriter(writerStr);
	ex.printStackTrace(printerWriter);
	stackTrace = writerStr.toString();
	stackTrace = stackTrace.replaceAll("\\$", "\\\\\\$");
	stackTrace = String.format("%s \n %s", ex.getMessage(), stackTrace);
	logList.add(String.format("%s %s", title, stackTrace));
	request.setAttribute(status, logList);
    }

    private static final String PATTERN_1 = "dd-MM-yyyy HH:mm:ss:SSS";
    public void trace(String logTitle, String logMessage) throws Exception {
	logTitle = String.format("@millisecond[%s] = %s", new SimpleDateFormat(PATTERN_1).format(new Date()), logTitle);
	this.logList.add(String.format("%s = %s", logTitle, logMessage));
	request.setAttribute(status, logList);
    }

    public String getLog() throws Exception {
	StringBuffer sb = new StringBuffer();
	for (int ix = 0; ix < this.logList.size(); ix++) {
	    String log = String.format("\n >>> %s . %s", ix, logList.get(ix));
	    sb.append(log);
	}
	return sb.toString();
    }

    public void appendFile() {
	try {
	    String log = this.getLog();
	    Log4jUtil.log4j(org.apache.log4j.Level.INFO, ConsoleLog4jUtil.class, log);
	    appendFileGwt(log, this.LOG_FILE, this.fileSize, this.fileCount);
	} catch (Exception ex) {
	    ex.printStackTrace();
	}
    }

    private void appendFile(
	    String log, 
	    String fileName, 
	    String fileSize,
	    String fileCount) throws Exception {
	Logger logger = Logger.getLogger("com.test.util.FileUtil");
	FileHandler handler = new FileHandler(fileName, Integer.valueOf(fileSize), Integer.valueOf(fileCount), true);
	handler.setFormatter(new SimpleFormatter());
	logger.addHandler(handler);
	logger.info(log);
	handler.flush();
	handler.close();
    }

    private void appendFileGwt(
	    String log, 
	    String fileName, 
	    String fileSize,
	    String fileCount) throws Exception {
	Logger logger = Logger.getLogger("com.test.util.FileUtil");
	FileHandler handler = new FileHandler(fileName, Integer.valueOf(fileSize), Integer.valueOf(fileCount), true);
	handler.setFormatter(new SimpleFormatter());
	logger.addHandler(handler);
	logger.info(log);
	handler.flush();
	handler.close();
    }
}
