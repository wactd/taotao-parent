package com.taotao.service;


import org.springframework.web.multipart.MultipartFile;

import java.util.Map;

/**
 * Created by dongly on 17-3-19.
 */
public interface PictureService {

    /**
     * 文件上传
     * @param multipartFile
     * @return
     */
    Map<String, Object> uploadPicture(MultipartFile multipartFile);

}
