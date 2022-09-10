/*
 * Licensed to the Apache Software Foundation (ASF) under one or more
 * contributor license agreements.  See the NOTICE file distributed with
 * this work for additional information regarding copyright ownership.
 * The ASF licenses this file to You under the Apache License, Version 2.0
 * (the "License"); you may not use this file except in compliance with
 * the License.  You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package org.jarvisframework.sample.aksk.service;

import org.jarvisframework.web.common.filter.authentication.SecretKeyService;
import org.springframework.stereotype.Service;

/**
 * 秘钥查询实现
 *
 * @author <a href="mailto:taofangf@gmail.com">fangtao</a>
 * @since 1.0.0
 */
@Service
public class SecretKeyImpl implements SecretKeyService {
    /**
     * 通过appId查询对应的SecretKey
     *
     * @param appId 接入方Id
     * @return 秘钥
     */
    @Override
    public String getSecretKeyByAppId(String appId) {
        return "09ef5dd65d057d615162738633527fd4a9682088ca5f84928aad0c9efca53d88";
    }
}
