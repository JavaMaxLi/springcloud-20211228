package com.lxf.utils;


/**
 * 接口数据返回主体
 * 
 * @author ZmSoft
 * @version 2.0.0 2018/10/10
 * @since 2.0.0 2018/10/10
 */

public class RESTResultBean<T> implements ISFrameworkConstants {

	/**
	 * 处理状态(0成功1失败)
	 */
	private String code = ZERO;// 对接返回代码 1:无数据 0:正确 其他：对应对接方错误码

	/**
	 * 提示信息
	 */
	private String message = MESSAGE_OK;// 对接返回信息 ok:正确 其他：对应对接方错误描述

	/**
	 * 返回结果
	 */
	private Object data;

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public Object getData() {
		return data;
	}

	public void setData(Object data) {
		this.data = data;
	}
}
