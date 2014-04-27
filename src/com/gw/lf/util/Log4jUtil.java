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

package com.gw.lf.util;

public class Log4jUtil {

    public static void log4j(org.apache.log4j.Level level, Class c, String message) {
	org.apache.log4j.Logger logger = org.apache.log4j.Logger.getLogger("# " + c.getName());
	if (level.equals(org.apache.log4j.Level.INFO)) {
	    logger.info(message);

	} else if (level.equals(org.apache.log4j.Level.DEBUG)) {
	    logger.debug(message);

	} else if (level.equals(org.apache.log4j.Level.ERROR)) {
	    logger.error(message);

	} else if (level.equals(org.apache.log4j.Level.FATAL)) {
	    logger.fatal(message);

	} else if (level.equals(org.apache.log4j.Level.WARN)) {
	    logger.warn(message);
	}
    }

    public static void log4j(org.apache.log4j.Level level, Class c, Exception ex) {
	org.apache.log4j.Logger logger = org.apache.log4j.Logger.getLogger("# " + c.getName());
	if (level.equals(org.apache.log4j.Level.INFO)) {
	    logger.info(ex);

	} else if (level.equals(org.apache.log4j.Level.DEBUG)) {
	    logger.debug(ex);

	} else if (level.equals(org.apache.log4j.Level.ERROR)) {
	    logger.error(ex);

	} else if (level.equals(org.apache.log4j.Level.FATAL)) {
	    logger.fatal(ex);

	} else if (level.equals(org.apache.log4j.Level.WARN)) {
	    logger.warn(ex);
	}
    }
}
