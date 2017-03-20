package com.taotao.controller;

import com.taotao.service.PictureService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import java.util.Map;

/**
 * Created by dongly on 17-3-20.
 */

@Controller
public class PictureController {

    @Autowired
    private PictureService pictureService;


    @ResponseBody
    @RequestMapping(value = "/pic/upload")
    public Map<String, Object> pictureUpload(MultipartFile uploadFile) {

        Map<String, Object> result = pictureService.uploadPicture(uploadFile);

        return result;
    }


}
