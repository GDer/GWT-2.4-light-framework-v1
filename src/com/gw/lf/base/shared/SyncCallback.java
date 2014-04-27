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


public interface SyncCallback {
    public void syncCallbackFormBinder() throws Exception;
    public void syncCallbackValidationForm() throws Exception;
    public void syncCallbackService() throws Exception;
    
    public void syncCallbackServiceSuccess(com.gw.lf.client.base.BaseObject baseObject);
    public void syncCallbackServiceFail();
    public void syncCallbackServiceRedirect();
    public void syncCallbackServiceTrace() throws Exception;
}