package com.qfedu.feri.img.qrcode;

import com.google.zxing.BarcodeFormat;
import com.google.zxing.EncodeHintType;
import com.google.zxing.MultiFormatWriter;
import com.google.zxing.WriterException;
import com.google.zxing.client.j2se.MatrixToImageConfig;
import com.google.zxing.client.j2se.MatrixToImageWriter;
import com.google.zxing.common.BitMatrix;
import com.google.zxing.qrcode.decoder.ErrorCorrectionLevel;

import java.awt.image.BufferedImage;
import java.util.HashMap;
import java.util.Map;

/**
 * @program: QFferiimg
 * @description:
 * @author: Feri
 * @create: 2019-09-04 00:36
 */
public class QrcodeUtil {
    /**
     * 二维码是生成
     * @param content 二维码内容
     * @param width 二维码的额宽度
     * @return 缓存图片*/
    public static BufferedImage createQrCode(String content,int width){
        //1、创建集合 Map
        Map<EncodeHintType,Object> map=new HashMap<>();
        //2、设置二维码属性
        map.put(EncodeHintType.CHARACTER_SET,"UTF-8");
        map.put(EncodeHintType.ERROR_CORRECTION, ErrorCorrectionLevel.H);
        map.put(EncodeHintType.MARGIN,2);
        //3、生成位图
        try {
            BitMatrix bitMatrix=new MultiFormatWriter().encode(content, BarcodeFormat.QR_CODE,width,width,map);
            return MatrixToImageWriter.toBufferedImage(bitMatrix,new MatrixToImageConfig(0xFF000000,0xFFFFFFFF));
        } catch (WriterException e) {
            e.printStackTrace();
        }
        return null;
    }
}
