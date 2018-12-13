package com.std.aqs.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
@Entity
public class User implements Serializable{
	private static final long serialVersionUID = 1L;

	@Id
    @GeneratedValue
    @ApiModelProperty("id")
	private int id;
	
	@Column(nullable = false, unique = true)
	@ApiModelProperty("用户名")
	private String name;
	
	@ManyToOne(fetch=FetchType.EAGER)
	@ApiModelProperty("单位")
	private Unit unit;
}
