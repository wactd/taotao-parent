package com.taotao.service.impl;

import com.taotao.service.PictureService;
import com.taotao.utils.FtpUtil;
import com.taotao.utils.IDUtils;
import org.apache.commons.lang3.time.DateFormatUtils;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.io.InputStream;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by dongly on 17-3-19.
 */

@Service
public class PictureServiceImpl implements PictureService {

    @Value("${ftp.base.path}")
    private String FTP_BASE_PATH;

    @Value("${image.base.url}")
    private String IMAGE_BASE_URL;


    @Override
    public Map<String, Object> uploadPicture(MultipartFile multipartFile) {
        Map<String, Object> result;

        // 原始文件名
        String originalFilename = multipartFile.getOriginalFilename();

        String format = DateFormatUtils.format(new Date(), "/yyyy/MM/dd");

        String imageName = IDUtils.genImageName()
                + originalFilename.substring(originalFilename.lastIndexOf("."));

        try {
            InputStream inputStream = multipartFile.getInputStream();
            // boolean b = FtpUtil.uploadFile(FTP_HOST, FTP_PORT, FTP_PASSED, FTP_USERNAME, FTP_BASE_PATH,
            //         format, imageName, inputStream);
            boolean b = FtpUtil.uploadFile(FTP_BASE_PATH, format, imageName, inputStream);
            if (b) {
                result = new HashMap<>();
                result.put("error", 0);
                result.put("url", IMAGE_BASE_URL + format + "/" + imageName);
                return result;
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        result = new HashMap<>();
        result.put("error", 1);
        result.put("message", "文件上传失败");
        return result;
    }
}
