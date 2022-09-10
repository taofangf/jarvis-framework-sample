package org.jarvisframework.sample.aksk.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 测试Controller
 *
 * @author <a href="mailto:taofangf@gmail.com">fangtao</a>
 * @since 1.0.0
 */
@RestController
public class SampleController {
    @GetMapping("/hello")
    public String hello() {
        return "hello world";
    }
}
