package com.msk.sso.utils;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

/**
 * Created by mabo on 2016/6/4.
 */
@Component
public class TokenSchedule {

    // /** 日志 */
    // private static Logger logger = LoggerFactory.getLogger(TokenSchedule.class);

    /**
     * 清除过期的token
     * 每分钟执行一次
     */
    @Scheduled(fixedRate = 60000)
    public void clearExpiredToken() {
        TokenManager.getInstance().expireToken();
        // logger.debug("clear expired token.");
    }

}
