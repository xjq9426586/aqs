package com.std.aqs.entity;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.io.Serializable;

/**
 * @Auther: xujunqian
 * @Date: 2019/7/29 0029 16:06
 * @Description:
 */
@Data
@Entity
public class FileInfo implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue
    @ApiModelProperty("id")
    private int id;

    @Column
    @ApiModelProperty("文件路径")
    private String url;

    @Column
    @ApiModelProperty("文件名")
    private String fileName;

    @Column
    @ApiModelProperty("文件类型")
    private String fileType;

    @Column
    @ApiModelProperty("关联id")
    private int relId;

}
