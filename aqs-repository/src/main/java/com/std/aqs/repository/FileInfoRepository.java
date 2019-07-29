package com.std.aqs.repository;

import com.std.aqs.entity.FileInfo;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @Auther: xujunqian
 * @Date: 2019/7/29 0029 16:14
 * @Description:
 */
public interface FileInfoRepository extends JpaRepository<FileInfo, Integer> {
}
