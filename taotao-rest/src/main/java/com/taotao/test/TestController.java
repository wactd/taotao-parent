package com.taotao.test;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by tiger on 17-4-9.
 */

@RestController
public class TestController {

    @RequestMapping(value = "/")
    public String hello() {

        return "Hello World!";
    }

    @RequestMapping(value = "/a")
    public String helloa() {

        return "Hello World!-a";
    }

}
