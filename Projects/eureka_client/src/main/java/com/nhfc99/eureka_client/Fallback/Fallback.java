package com.nhfc99.eureka_client.Fallback;

import com.nhfc99.eureka_client.service.RequestService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

/**
 * 降级处理
 */
@Component
public class Fallback implements RequestService {
    private static final Logger logger = LoggerFactory.getLogger(Object.class);

    @Override
    public String getPort() {
        logger.error("Call Technolygy --- 服务异常报警监控通知");
        return "被挤爆了，你再看看其他信息，这里可以发送短信给技术人员";
    }
}
