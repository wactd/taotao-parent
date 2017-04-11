package com.taotao.portal.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by tiger on 17-4-11.
 */

@Controller
public class IndexController {

    @RequestMapping(value = "/index")
    public String showIndex() {
        return "index";
    }

}
