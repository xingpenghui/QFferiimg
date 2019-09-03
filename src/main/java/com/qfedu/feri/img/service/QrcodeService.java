package com.qfedu.feri.img.service;

import com.qfedu.feri.img.model.QrcodeCard;
import com.qfedu.feri.img.vo.R;

import java.io.OutputStream;

public interface QrcodeService {
    //对象包含base64格式的二维码
    R createQrCode(QrcodeCard card);
    //生成图片
    void createQrCode(OutputStream os);
}