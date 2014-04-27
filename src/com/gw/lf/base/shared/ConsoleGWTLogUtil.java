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
import java.util.List;

import com.google.gwt.i18n.client.DateTimeFormat;


public class ConsoleGWTLogUtil {

	private List<String> message = new ArrayList<String>();
	
    public void trace(String zackage, 
	    			String zlass, 
	    			String function,
	    			String variable, 
	    			String message) {
		DateTimeFormat dateFormat = DateTimeFormat.getFormat("dd-mm-yyyy hh:mm:ss");
		String log = "{1} [{2}] {3}.[{4}].[{5}].[{6}] = {7}"
	        	.replace("{1}", "@client.millisecond")
	        	.replace("{2}", dateFormat.format(new java.util.Date()))
	        	.replace("{3}", zackage)
	        	.replace("{4}", zlass)
	        	.replace("{5}", function)
	        	.replace("{6}", variable)
	        	.replace("{7}", message);
	
		this.message.add(log);
    }
    
    public void info(String zackage, 
			String zlass, 
			String function,
			String variable, 
			String message) {
		DateTimeFormat dateFormat = DateTimeFormat.getFormat("dd-mm-yyyy hh:mm:ss");
		String log = "{1} [{2}] {3}.[{4}].[{5}].[{6}] = {7}"
		    	.replace("{1}", "@client.millisecond")
		    	.replace("{2}", dateFormat.format(new java.util.Date()))
		    	.replace("{3}", zackage)
		    	.replace("{4}", zlass)
		    	.replace("{5}", function)
		    	.replace("{6}", variable)
		    	.replace("{7}", message);
		java.util.logging.Logger logger = java.util.logging.Logger.getLogger(ConsoleGWTLogUtil.class.getName());
		logger.setLevel(java.util.logging.Level.INFO);
		logger.log(java.util.logging.Level.INFO, log);
    }

    public void error(String zackage, 
	    		String zlass, 
			String title,
			Exception e) {
		String log = "";
		for (StackTraceElement element : e.getStackTrace()) {
		    log = "{1} {2} \n {3}"
				.replace("{1}", log)
				.replace("{2}", element.toString())
				.replace("{3}", "                ");
		}
	
		DateTimeFormat dateFormat = DateTimeFormat.getFormat("dd-mm-yyyy hh:mm:ss");
		String message = "{1} [{2}] {3}.[{4}] *** {5} "
		    		.replace("{1}", "@client.millisecond")
					.replace("{2}", dateFormat.format(new java.util.Date()))
					.replace("{3}", zlass)
					.replace("{4}", title)
					.replace("{5}", log);
		
		java.util.logging.Logger logger = java.util.logging.Logger.getLogger(ConsoleGWTLogUtil.class.getName());
		logger.setLevel(java.util.logging.Level.INFO);
		logger.log(java.util.logging.Level.INFO, message);
    }
    
    public void appendConsole() {
    	java.util.logging.Logger logger = java.util.logging.Logger.getLogger(ConsoleGWTLogUtil.class.getName());
    	logger.setLevel(java.util.logging.Level.INFO);
	logger.log(java.util.logging.Level.INFO, this.toString());
    }
    
    public String toString() {
    	StringBuffer log = new StringBuffer();
    	for (int ix = 0 ; ix < message.size(); ix++) {
    		log.append(" {0} >>>>>>>>>> {1} . {2}"
    					.replace("{0}", "\n")
    					.replace("{1}", String.valueOf(ix))
    					.replace("{2}", message.get(ix))); 
    	}
    	return log.toString();
    }
}
