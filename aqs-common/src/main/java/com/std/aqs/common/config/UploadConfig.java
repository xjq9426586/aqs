package com.std.aqs.common.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Component
@ConfigurationProperties(prefix="xcloud")
public class UploadConfig {
   //上传路径
   private String uploadPath;
 
   public String getUploadPath() {
      return uploadPath;
   }
 
   public void setUploadPath(String uploadPath) {
      this.uploadPath = uploadPath;
   }
}
