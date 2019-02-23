package com.core.util;


public class ResponseResult<T> {

    private int code;
    private String msg;
    private T data;


    public void setCode(int code) {
        this.code = code;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public void setData(T data) {
        this.data = data;
    }

    public int getCode() {
        return code;
    }

    public String getMsg() {
        return msg;
    }

    public T getData() {
        return data;
    }

    @Override
    public String toString() {
        return "code=" + code + " message=" + msg + " data=" + data;
    }

    public static <T> ResponseResult<T> fail() {
        ResponseResult<T> ret = new ResponseResult<>();
        ret.setCode(-1);
        ret.setMsg("操作失败");
        return ret;
    }

    public static <T>  ResponseResult<T> fail(T data) {
        ResponseResult<T> ret = ResponseResult.fail();
        ret.setData(data);
        return ret;
    }

    public static <T>  ResponseResult<T> failMessage(String msg) {
        ResponseResult<T> ret = ResponseResult.fail();
        ret.setMsg(msg);
        return ret;
    }

    public static <T>  ResponseResult<T> successMessage(String msg) {
        ResponseResult<T> ret = ResponseResult.success();
        ret.setMsg(msg);
        return ret;
    }

    public static <T> ResponseResult<T> success() {
        ResponseResult<T> ret = new ResponseResult<>();
        ret.setCode(1);
        ret.setMsg("操作成功");
        return ret;
    }


    public static <T> ResponseResult<T> success(T data) {
        ResponseResult<T> ret = ResponseResult.success();
        ret.setData(data);
        return ret;
    }

}
