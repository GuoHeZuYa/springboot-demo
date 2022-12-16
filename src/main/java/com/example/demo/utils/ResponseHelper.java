package com.example.demo.utils;

import lombok.Data;

/**
 * 返回的结构进行封装
 * 可以用泛型
 * 也可以用Object
 * 一些包也有封装的返回结构
 * Spring也提供了封装的返回结构
 * @param <T>
 */
@Data
public class ResponseHelper<T> {

    private int code;
    private String msg;
    private T data;

    public ResponseHelper(){
        this(ResponseCode.SUCCESS, (T) Boolean.valueOf(true));
    }

    public ResponseHelper(T t) {
        if(t == null){
            this.code =  ResponseCode.TARGET_NOT_EXIST.getCode();
            this.msg = ResponseCode.TARGET_NOT_EXIST.getMsg();
        }else{
            this.code = ResponseCode.SUCCESS.getCode();
            this.msg = ResponseCode.SUCCESS.getMsg();
        }
        this.data = t;
    }

    public ResponseHelper(ResponseCode responseCode, T data) {
        this.code = responseCode.getCode();
        this.msg = responseCode.getMsg();
        this.data = data;
    }

    public ResponseHelper(ResponseCode responseCode, Boolean data,String o) {
        this.code = responseCode.getCode();
        this.msg = responseCode.getMsg();
        this.data = (T) data;
    }



    public  static <T> ResponseHelper<T> error(ResponseCode responseCode){
        return new ResponseHelper<>(responseCode,false,"");
    }

    public  static <T> ResponseHelper<T> error(){
        return ResponseHelper.error(ResponseCode.ERROR);
    }


}
