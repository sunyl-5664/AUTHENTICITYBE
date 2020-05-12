package com.jiubo.buildstore.controller;


import com.jiubo.buildstore.Exception.MessageException;
import org.apache.catalina.connector.ClientAbortException;
import org.apache.commons.lang.StringUtils;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.util.Map;

@Controller
@RequestMapping("/fileController")
public class FileController {
    //获取图片、视频、音频
    @RequestMapping("/getFile")
    public void getFile(HttpServletRequest request, HttpServletResponse response) throws Exception {
        String path = request.getParameter("path");
        if (StringUtils.isBlank(path)) throw new MessageException("路径为空!");
        File file = new File(path);
        outputFile(file, response);
    }

    private void outputFile(File file, HttpServletResponse response) throws Exception {
        try {
            if (file == null || !file.exists()) throw new MessageException("文件不存在!");
            ServletOutputStream outputStream = response.getOutputStream();
            //String contentType = Files.probeContentType(file.toPath());
            //response.addHeader("Content-Type",contentType);
            //System.out.println(contentType);
            response.setHeader("Access-Control-Expose-Headers", "Content-Disposition");
            response.addHeader("Content-Disposition", "attachment; filename=" + file.getName());
            FileInputStream fis = new FileInputStream(file);
            BufferedInputStream bis = new BufferedInputStream(fis);
            byte[] bytes = new byte[8192];
            int len = 0;
            while ((len = bis.read(bytes)) != -1) {
                outputStream.write(bytes, 0, len);
            }
            if (bis != null) bis.close();
            if (fis != null) fis.close();
        } catch (ClientAbortException c) {
            // System.out.println("此异常不处理。。。。");
        }
    }
}
