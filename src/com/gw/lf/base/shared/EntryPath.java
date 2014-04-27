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

import com.gw.lf.client.base.BaseEntryPath;


public interface EntryPath extends BaseEntryPath {
    public static final String ENTRY_LOGIN = "Login";

    public static final String WELCOME = "welcome";
    public static final String BYE = "bye";
    
    public static final String DO_INIT_1 = "INIT_1";
    public static final String DO_INIT_2 = "INIT_2";
    public static final String DO_INIT_3 = "INIT_3";
    public static final String DO_INIT_4 = "INIT_4";
    public static final String DO_INIT_5 = "INIT_5";
    
    public static final String RESULT_SUCCESS = "success";
    public static final String RESULT_FAIL = "fail";
    public static final String RESULT_WARNING = "warning";
    public static final String RESULT_LOGOUT = "bye";
    public static final String RESULT_SYSTEM_ERROR = "SystemError";
}