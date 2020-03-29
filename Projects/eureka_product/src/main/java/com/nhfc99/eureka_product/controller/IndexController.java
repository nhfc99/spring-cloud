package com.nhfc99.eureka_product.controller;

import com.nhfc99.eureka_product.service.ProductService;
import lombok.extern.log4j.Log4j2;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@Log4j2
@RestController
@RequestMapping("/index")
public class IndexController {
    private static final Logger logger = LoggerFactory.getLogger(Object.class);

    @Autowired
    private ProductService productService;

    @Value("${server.port}")
    private String port;

    @GetMapping("/getlist")
    @ResponseBody
    public Object getList() {
        return productService.listProduct();
    }

    @ResponseBody
    @GetMapping("/getport")
    public Object getPort() throws InterruptedException {
//        TimeUnit.SECONDS.sleep(2);
        log.error("根部获取port");
        return this.port;
    }
}
