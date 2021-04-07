package com.std.aqs.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
@Entity
public class Unit implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue
    @ApiModelProperty("id")
    private int id;
    @Column(nullable = false, unique = true)
    @ApiModelProperty("单位名称")
    private String unitName;
}
