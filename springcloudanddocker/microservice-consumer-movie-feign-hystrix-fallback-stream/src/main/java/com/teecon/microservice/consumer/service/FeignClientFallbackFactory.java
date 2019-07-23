package com.teecon.microservice.consumer.service;

import com.teecon.microservice.consumer.pojo.User;
import feign.hystrix.FallbackFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Component
public class FeignClientFallbackFactory implements FallbackFactory<UserFeignFallbackClient> {

    private static final Logger logger = LoggerFactory.getLogger(FeignClientFallbackFactory.class);

    @Override
    public UserFeignFallbackClient create(Throwable throwable) {

        return new UserFeignFallbackClient() {
            @Override
            public User findById(Long id) {
                logger.info("Fallback, the reason was:", throwable);
                User user = new User();
                user.setId(-1L);
                user.setName("默认用户");
                return user;
            }
        };
    }
}
