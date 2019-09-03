package com.qfedu.feri.img.model;

import lombok.Data;

/**
 * @program: QFferiimg
 * @description:
 * @author: Feri
 * @create: 2019-09-04 00:42
 */
@Data //lombox 简化代码 提供getter和setter方法
public class QrcodeCard {
    private String name;
    private String email;
    private String note;
    private String phone;
    private String address;
    private String postion;
    private String blogurl;

    @Override
    public String toString(){
        StringBuffer buffer=new StringBuffer();
        buffer.append("BEGIN:VCARD\n");
        buffer.append("NOTE:"+note+"\n");
        buffer.append("N:"+name+"\n");
        buffer.append("TITLE:"+postion+"\n");
        buffer.append("ADR:"+address+"\n");
        buffer.append("EMAIL:"+email+"\n");
        buffer.append("TEL:"+phone+"\n");
        buffer.append("URL:"+blogurl+"\n");
        buffer.append("END:VCARD\n");
        return buffer.toString();
    }

}
