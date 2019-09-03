package com.qfedu.feri.img.api;

import com.qfedu.feri.img.model.QrcodeCard;
import com.qfedu.feri.img.service.QrcodeService;
import com.qfedu.feri.img.vo.R;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @program: QFferiimg
 * @description:
 * @author: Feri
 * @create: 2019-09-04 00:54
 */
@Api(value = "二维码名片相关操作",tags = "二维码名片相关操作")
@Controller
public class QrcodeApi {
    @Autowired
    private QrcodeService qrcodeService;

    @ApiOperation(value = "测试二维码名片",notes = "测试二维码名片")
    @GetMapping("api/qrcode/test.do")
    public void createQr(HttpServletResponse response) throws IOException {
        qrcodeService.createQrCode(response.getOutputStream());
    }
    @ApiOperation(value = "生成二维码名片",notes = "生成二维码名片")
    @PostMapping("api/qrcode/createcard.do")
    @ResponseBody
    public R createQr(@RequestBody QrcodeCard card){
        return qrcodeService.createQrCode(card);
    }
}
