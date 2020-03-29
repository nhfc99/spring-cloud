package com.nhfc99.eureka_client.Controller;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import com.nhfc99.eureka_client.service.RequestService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

@RestController
@RequestMapping("/index")
@RefreshScope
public class IndexController {
    private static final Logger logger = LoggerFactory.getLogger(Object.class);
    @Autowired
    private RestTemplate restTemplate;

    @Autowired
    private RequestService requestService;

    @Value("${infoname}")
    private String infoname;

    @GetMapping("/getlist")
    @ResponseBody
    public Object getList() {
        String url = "http://eurekaproduct/index/getlist";
        String result = restTemplate.getForObject(url, String.class);
        return result;
    }

    @GetMapping("/getport")
    @ResponseBody
    @HystrixCommand(fallbackMethod = "printInfo", commandProperties = {
            @HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds", value = "4000")
    })
    public Object getPort(@RequestParam("info") String info) {
//        String url = "http://eurekaproduct/index/getport";
//        String result = restTemplate.getForObject(url, String.class);
        logger.info("获取到的参数是 = " + info);
        logger.error("开始获取port");
        String result = requestService.getPort();
//        TimeUnit.SECONDS.sleep(2);
        logger.error("开始获取完毕");
        logger.warn("infoname = " + this.infoname);
        return result;
    }

    /**
     * 服务熔断之后降级
     *
     * @return
     */
    public Object printInfo(@RequestParam("info") String info) {
        return "抢购人数太多了";
    }
}