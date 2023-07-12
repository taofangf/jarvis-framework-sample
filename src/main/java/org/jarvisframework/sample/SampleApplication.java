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

package org.jarvisframework.sample;

import org.jarvisframework.sample.desensitization.domain.UserInfo;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

/**
 * SpringBoot启动类
 *
 * @author <a href="mailto:taofangf@gmail.com">fangtao</a>
 * @since 1.0.0
 */
@SpringBootApplication
public class SampleApplication {
    public static void main(String[] args) {
        SpringApplication springApplication = new SpringApplication(SampleApplication.class);
        springApplication.run(args);
    }

    @Bean
    public UserInfo userInfo() {
        return UserInfo.builder().username("哈哈").build();
    }

    @Bean
    public FilterRegistrationBean filterRegistrationBean() {
        FilterRegistrationBean registration = new FilterRegistrationBean();
        registration.setFilter((request, response, chain) -> {
            System.out.println("enter custom filter...");
            chain.doFilter(request, response);
        });
        registration.addUrlPatterns("/*");
        registration.setOrder(1);
        registration.setName("TestFilter");
        return registration;
    }

    /**
     * 方案一：类实例化后修改属性禁用掉该过滤器
     * 方案二：{@link DisableCustomFilterBeanFactoryPostProcessor}
     */
    @Component
    public class DisableCustomFilterBeanPostProcessor implements BeanPostProcessor {
        @Override
        public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
            if (bean instanceof FilterRegistrationBean) {
                System.out.println("beanName = " + beanName);
                if ("filterRegistrationBean".equals(beanName)) {
                    FilterRegistrationBean filterRegistrationBean = (FilterRegistrationBean) bean;
                    filterRegistrationBean.setEnabled(false);
                }
            }
            return bean;
        }
    }
}
