package com.qfedu.feri.img.service;

import com.qfedu.feri.img.model.QrcodeCard;
import com.qfedu.feri.img.qrcode.QrcodeUtil;
import com.qfedu.feri.img.vo.R;
import org.springframework.stereotype.Service;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.Base64;

/**
 * @program: QFferiimg
 * @description:
 * @author: Feri
 * @create: 2019-09-04 00:48
 */
@Service
public class QrcodeServiceImpl implements QrcodeService {
    @Override
    public R createQrCode(QrcodeCard card) {
        //1、生成图片
        BufferedImage bufferedImage= QrcodeUtil.createQrCode(card.toString(),400);
        //2、图片转换为字节数组
        ByteArrayOutputStream baos=new ByteArrayOutputStream();
        try {
            ImageIO.write(bufferedImage,"png",baos);
            //3、转换为Base64格式
            String s= Base64.getEncoder().encodeToString(baos.toByteArray());
            //4、生成返回对象
            return R.setR(200,"OK","data:image/png;base64,"+s);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return R.setR(400,"ERROR",null);
    }

    @Override
    public void createQrCode(OutputStream os) {
        //1、创建测试信息
        QrcodeCard card=new QrcodeCard();
        card.setAddress("河南郑州");
        card.setBlogurl("http://www.1000phone.com");
        card.setEmail("xingpenghui@1000phone.com");
        card.setName("老邢");
        card.setNote("我是老邢，在郑州校区");
        card.setPhone("18515990152");
        card.setPostion("Java讲师");
        //2、生成二维码图片
        BufferedImage bufferedImage=QrcodeUtil.createQrCode(card.toString(),400);
        try {
            //3、图片内容写出
            ImageIO.write(bufferedImage,"png",os);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
