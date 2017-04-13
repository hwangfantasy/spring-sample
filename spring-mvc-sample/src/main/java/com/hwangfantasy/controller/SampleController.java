package com.hwangfantasy.controller;

import com.google.code.kaptcha.Constants;
import com.google.code.kaptcha.Producer;
import com.hwangfantasy.bean.User;
import com.hwangfantasy.service.SampleService;
import com.hwangfantasy.util.RedisCacheUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.imageio.ImageIO;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.awt.image.BufferedImage;
import java.io.IOException;

/**
 * @作者 hwangfantasy
 * @创建时间: 2017/4/12 <br/>
 * @方法描述: SampleController. <br/>
 */
@Controller
@RequestMapping("/sample")
public class SampleController {
    private static final Logger LOGGER = LoggerFactory.getLogger(SampleController.class);

    @Autowired
    private SampleService sampleService;
    @Autowired
    private Producer producer;
    @Autowired
    private RedisCacheUtil redisCacheUtil;

    @RequestMapping("/sayHi")
    @ResponseBody
    public String sayHi(){
        return "Hello Fantasy!";
    }

    @RequestMapping("/addUser")
    @ResponseBody
    public String addUser(@RequestParam String name,@RequestParam String password,@RequestParam String phone){
        User user = new User();
        sampleService.addUser(user.withName(name).withPassword(password).withPhone(phone));
        return "success";
    }

    /**
     * @作者: hwangfantasy
     * @创建日期: 2017/4/13 11:22
     * @方法描述:  获取验证码
     */
    @RequestMapping(value = "/getCaptcha")
    public void getCaptcha(HttpServletRequest request, HttpServletResponse response) throws IOException {
        HttpSession session = request.getSession();
        String code = (String) session.getAttribute(Constants.KAPTCHA_SESSION_KEY);
        LOGGER.info("原先的验证码为: " + code);
        response.setDateHeader("Expires", 0);
        response.setHeader("Cache-Control", "no-store, no-cache, must-revalidate");
        response.addHeader("Cache-Control", "post-check=0, pre-check=0");
        response.setHeader("Pragma", "no-cache");
        response.setContentType("image/jpeg");

        String capText = producer.createText();
        session.setAttribute(Constants.KAPTCHA_SESSION_KEY, capText);
        LOGGER.info("新生成的验证码为: " + capText);
        BufferedImage bi = producer.createImage(capText);
        ServletOutputStream out = response.getOutputStream();
        ImageIO.write(bi, "jpg", out);
        try {
            out.flush();
        } finally {
            out.close();
        }
    }

    @RequestMapping("/addRedis")
    @ResponseBody
    public String addRedis(@RequestParam String key ,@RequestParam String value,@RequestParam long expire){
        redisCacheUtil.set(key,value,expire);
        return "success";
    }
}
