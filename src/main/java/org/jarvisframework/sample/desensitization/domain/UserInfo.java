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

package org.jarvisframework.sample.desensitization.domain;

import cn.hutool.core.util.DesensitizedUtil;
import com.alibaba.fastjson.annotation.JSONField;
import org.jarvisframework.common.desensitization.annotation.Desensitization;
import org.jarvisframework.sample.desensitization.service.HideDesensitization;

import java.util.StringJoiner;

/**
 * 用户信息实体类
 *
 * @author <a href="mailto:taofangf@gmail.com">fangtao</a>
 * @since 1.0.0
 */
public class UserInfo {
    /**
     * 用户名
     */
    @Desensitization(value = DesensitizedUtil.DesensitizedType.CHINESE_NAME, desensitizedUsing = HideDesensitization.class)
    private String username;

    /**
     * 密码
     */
    @Desensitization(DesensitizedUtil.DesensitizedType.PASSWORD)
    private String password;

    /**
     * 手机号
     */
    @Desensitization(DesensitizedUtil.DesensitizedType.MOBILE_PHONE)
    @JSONField(name = "telNum")
    private String phoneNumber;

    public String getUsername() {
        return username;
    }

    public UserInfo setUsername(String username) {
        this.username = username;
        return this;
    }

    public String getPassword() {
        return password;
    }

    public UserInfo setPassword(String password) {
        this.password = password;
        return this;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public UserInfo setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
        return this;
    }

    @Override
    public String toString() {
        return new StringJoiner(", ", UserInfo.class.getSimpleName() + "[", "]")
                .add("username='" + username + "'")
                .add("password='" + password + "'")
                .add("phoneNumber='" + phoneNumber + "'")
                .toString();
    }
}
