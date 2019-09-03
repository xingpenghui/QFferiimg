package com.qfedu.feri.img.vo;

import lombok.Data;

/**
 * @program: QFferiimg
 * @description:
 * @author: Feri
 * @create: 2019-09-04 00:46
 */
@Data
public class R {
    private int code;
    private String msg;
    private Object data;

    public static R setR(int code,String msg,Object obj){
        R r=new R();
        r.setData(obj);
        r.setMsg(msg);
        r.setCode(code);
        return r;
    }
}
