package com.sparrow.admin.common;

import java.io.Serializable;
/**
 * Json 统一返回消息类
 */
public class JsonResult implements Serializable {
	private static final long serialVersionUID = -1491499610244557029L;
	public static String CODE_SUCCESS = "000000";
	public static String CODE_FAILURE = "111111";
	public static String[] NOOP = new String[] {};

	private String code; // 处理状态：0: 成功
	private String message;
	private Object data; // 返回数据

	private JsonResult(String code, String message, Object data) {
		this.code = code;
		this.message = message;
		this.data = data;
	}

	/**
	 * 处理成功，并返回数据
	 * @param data 数据对象
	 */
	public static final JsonResult success(Object data) {
		return new JsonResult(CODE_SUCCESS, "操作成功", data);
	}

	/**
	 * 处理成功
	 */
	public static final JsonResult success() {
		return new JsonResult(CODE_SUCCESS, "操作成功", NOOP);
	}

	/**
	 * 处理成功
	 * @param message 消息
	 */
	public static final JsonResult success(String message) {
		return new JsonResult(CODE_SUCCESS, message, NOOP);
	}

	/**
	 * 处理成功
	 * @param message 消息
	 * @param data 数据对象
	 */
	public static final JsonResult success(String message, Object data) {
		return new JsonResult(CODE_SUCCESS, message, data);
	}

	/**
	 * 处理失败，并返回数据（一般为错误信息）
	 * @param code 错误代码
	 * @param message 消息
	 * @return data
	 */
	public static final JsonResult failure(String code, String message) {
		return new JsonResult(code, message, NOOP);
	}

	/**
	 * 处理失败
	 * @param message 消息
	 * @return data
	 */
	public static final JsonResult failure(String message) {
		return failure(CODE_FAILURE, message);
	}

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

	@Override
	public String toString() {
		return "JsonResult [code=" + code + ", message=" + message + ", data="
				+ data + "]";
	}


}
