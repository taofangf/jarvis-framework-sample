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

package org.jarvisframework.sample.desensitization.controller;

import org.jarvisframework.common.domain.CommonResult;
import org.jarvisframework.sample.desensitization.domain.UserInfo;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 用户信息
 *
 * @author <a href="mailto:taofangf@gmail.com">fangtao</a>
 * @since 1.0.0
 */
@RestController
public class UserInfoController {
    @GetMapping("/user")
    public CommonResult<UserInfo> user() {
        UserInfo userInfo = UserInfo.builder().username("贾维斯").password("jarvis@123456")
                .phoneNumber("13834567987").build();
        return CommonResult.ofSuccess(userInfo);
    }
}
