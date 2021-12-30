package com.rounds.experimentalteachingsystm.util;

import java.io.Serializable;
import java.util.List;


/**
 * ajax请求返回Json格式数据的封装
 */
public class AjaxJson implements Serializable{

    private static final long serialVersionUID = 1L;	// 序列化版本号

    public static final int CODE_SUCCESS = 200;			// 成功状态码
    public static final int CODE_ERROR = 500;			// 错误状态码
    public static final int CODE_WARNING = 501;			// 警告状态码
    public static final int CODE_NOT_JUR = 403;			// 无权限状态码
    public static final int CODE_NOT_LOGIN = 401;		// 未登录状态码
//    public static final int CODE_ERROR_PWD=400; //密码错误
    public static final int CODE_USER_NOT_EXIST=404; //用户不存在
    public static final int CODE_USER_ALREADY_EXIST=402; // 用户已存在
//    public static final int CODE_INVALID_REQUEST = 400;	// 无效请求状态码

    public static final int CODE_NO_VERICODE=400; // 邮件验证码过期或不存在状态码
    public static final int CODE_INVALID_CODE=405;// 邮件验证码输入错误状态码


    public int code; 	// 状态码
    public String message; 	// 描述信息
    public Object data; // 携带对象
    public Boolean success; //是否成功

    /**
     * 返回code
     * @return
     */
    public int getCode() {
        return this.code;
    }

    /**
     * 给msg赋值，连缀风格
     */
    public AjaxJson setMsg(String msg) {
        this.message = msg;
        return this;
    }
    public String getMsg() {
        return this.message;
    }

    /**
     * 给data赋值，连缀风格
     */
    public AjaxJson setData(Object data) {
        this.data = data;
        return this;
    }

    /**
     * 将data还原为指定类型并返回
     */
    @SuppressWarnings("unchecked")
    public <T> T getData(Class<T> cs) {
        return (T) data;
    }

    // ============================  构建  ==================================

    public AjaxJson(int code, String msg, Object data, Boolean suc) {
        this.code = code;
        this.message = msg;
        this.data = data;
        this.success=suc;
    }

    // 返回成功
    public static AjaxJson getSuccess() {
        return new AjaxJson(CODE_SUCCESS, "ok", null, true);
    }
    public static AjaxJson getSuccess(String msg) {
        return new AjaxJson(CODE_SUCCESS, msg, null, true);
    }
    public static AjaxJson getSuccess(String msg, Object data) {
        return new AjaxJson(CODE_SUCCESS, msg, data, true);
    }
    public static AjaxJson getSuccessData(Object data) {
        return new AjaxJson(CODE_SUCCESS, "ok", data, true);
    }
    public static AjaxJson getSuccessArray(Object... data) {
        return new AjaxJson(CODE_SUCCESS, "ok", data, true);
    }

    // 返回失败
    public static AjaxJson getError() {
        return new AjaxJson(CODE_ERROR, "error", null, false);
    }
    public static AjaxJson getError(String msg) {
        return new AjaxJson(CODE_ERROR, msg, null, false);
    }
//    public static AjaxJson getErrorPwd(String msg){return new AjaxJson(CODE_ERROR_PWD,msg,null,false);}
    public static AjaxJson getErrorUsrNotExist(String msg){return new AjaxJson(CODE_USER_NOT_EXIST,msg,null,false);}
    public static AjaxJson getErrorUsrAlreadyExist(String msg){return new AjaxJson(CODE_USER_ALREADY_EXIST,msg,null,false);};

    // 返回警告
    public static AjaxJson getWarning() {
        return new AjaxJson(CODE_ERROR, "warning", null, false);
    }
    public static AjaxJson getWarning(String msg) {
        return new AjaxJson(CODE_WARNING, msg, null, false);
    }

    // 返回未登录
    public static AjaxJson getNotLogin() {
        return new AjaxJson(CODE_NOT_LOGIN, "Sign-in required", null, false);
    }

    // 返回没有权限的
    public static AjaxJson getNotJur(String msg) {
        return new AjaxJson(CODE_NOT_JUR, msg, null, null);
    }

    // 返回邮件验证码不存在或过期的
    public static AjaxJson getNoVericode(){
        return new AjaxJson(CODE_NO_VERICODE, "验证码不存在或已过期",null, null);
    }

    // 返回邮件验证码输入错误的
    public static AjaxJson getInvalidCode(){
        return new AjaxJson(CODE_INVALID_CODE,"验证码输入错误",null,null);
    }

    // 返回分页和数据的
    public static AjaxJson getPageData(Object data){
        return new AjaxJson(CODE_SUCCESS, "ok", data,true );
    }

    // 返回，根据受影响行数的(大于0=ok，小于0=error)
    public static AjaxJson getByLine(int line){
        if(line > 0){
            return getSuccess("ok", line);
        }
        return getError("error").setData(line);
    }

    // 返回，根据布尔值来确定最终结果的  (true=ok，false=error)
    public static AjaxJson getByBoolean(boolean b){
        return b ? getSuccess("ok") : getError("error");
    }

    /* (non-Javadoc)
     * @see java.lang.Object#toString()
     */
    @SuppressWarnings("rawtypes")
    @Override
    public String toString() {
        String data_string = null;
        if(data == null){

        } else if(data instanceof List){
            data_string = "List(length=" + ((List)data).size() + ")";
        } else {
            data_string = data.toString();
        }
        return "{"
                + "\"code\": " + this.getCode()
                + ", \"msg\": \"" + this.getMsg() + "\""
                + ", \"data\": " + data_string
                + ", \"success\": " + this.success
                + "}";
    }





}