package com.std.aqs.api;

import java.io.File;
import java.io.IOException;

import com.std.aqs.entity.FileInfo;
import com.std.aqs.service.FileInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.std.aqs.bean.ResultBean;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;

@Api("文件上传")
@RestController
@RequestMapping("/api/file/*")
public class FileController {
	@Value("${resourceLocations.uploadPath}")
	private String uploadPath;
	@Value("${resourceHandler.pathHandler}")
	private String pathHandler;
	@Autowired
	private FileInfoService fileInfoService;

	@SuppressWarnings("unchecked")
	@ApiImplicitParam(name = "file",value = "文件",dataType = "MultipartFile")
	@PostMapping("upload")
	public ResultBean<String> upload(@RequestParam("file") MultipartFile file) {
		String fileName = file.getOriginalFilename();
		File f = new File(uploadPath);
		if (!f.exists()) {
			f.mkdirs();
		}
		File taget = new File(f, fileName);
		try {

			if (!taget.exists()) {
				taget.createNewFile();
			}
			file.transferTo(taget);

		} catch (IOException e) {
			e.printStackTrace();
		}

		return ResultBean.isOk(1).data(pathHandler + fileName);

	}
}
