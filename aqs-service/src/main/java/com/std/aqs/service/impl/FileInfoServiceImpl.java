package com.std.aqs.service.impl;

import com.std.aqs.entity.FileInfo;
import com.std.aqs.service.FileInfoService;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

/**
 * @Auther: xujunqian
 * @Date: 2019/7/29 0029 16:17
 * @Description:
 */
@Service
@Transactional
public class FileInfoServiceImpl extends BaseServiceImpl<FileInfo, Integer> implements FileInfoService {
}
