package com.std.aqs.bean;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * 统一返回结果bean
 * @author Schaw
 *
 * @param <T>
 */
@Data
@SuppressWarnings("rawtypes")
public class ResultBean<T> {
	@ApiModelProperty("状态0失败1成功")
	private int status;

	@ApiModelProperty("返回消息")
	private String message;
	
	@ApiModelProperty("数据")
	private T data;
	
	@ApiModelProperty("错误信息")
	private ErrorInfo error;
	
	
	//APIS
	public static ResultBean isOk(int isOk) {
    	ResultBean r = new ResultBean();
    	r.setStatus(isOk);
    	if(isOk == 0) {
    		r.setMessage("调用接口失败");
    	}else {
    		r.setMessage("调用接口成功");
    	}
        return r;
    }
    public static ResultBean isOk(int isOk,String msg) {
    	ResultBean r = new ResultBean();
    	r.setStatus(isOk);
    	r.setMessage(msg);
        return r;
    }
    public ResultBean<T> data(T data) {
    	this.setData(data);
		return this;
    	
    }
    public ResultBean<T> error(ErrorInfo e) {
    	this.setError(e);
		return this;
    }
   
}
