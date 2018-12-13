package com.std.aqs.bean;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * 主要用途：存储错误信息的Bean.
 * 设计说明：
 * 1.官方提供了默认错误存储{@link DefaultErrorAttributes},但其最终返回的是存储结构是Map<String,Object>。
 * 2.为了避免采用Map这种模糊的数据结构,故统一使用{@link ErrorInfo}来表示错误信息。
 *
 */
@Data
public class ErrorInfo {
	@ApiModelProperty("发生时间")
    private String time;
	
	@ApiModelProperty("访问Url")
    private String url;

	@ApiModelProperty("错误类型")
    private String error;
	
	@ApiModelProperty("错误的堆栈轨迹")
    String stackTrace;
    
	@ApiModelProperty("状态码")
    private int statusCode;
    
	@ApiModelProperty("状态码-描述")
    private String reasonPhrase;
}