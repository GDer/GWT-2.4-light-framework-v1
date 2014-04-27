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

public abstract class BaseModuleLogin extends BaseModelClient {

    protected static String zackage = "com.test.client.base";
    protected static String zlass = "BaseModuleLogin";

    @Override
    public void setAuthenticateUser() throws Exception {
	log.trace(zackage, zlass, "setAuthenticateUser", "", "false");
	this.baseObject.setAuthenticateUser(false);
    }
}
