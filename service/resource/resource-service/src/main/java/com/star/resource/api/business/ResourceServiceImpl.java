package com.star.resource.api.business;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.concurrent.ThreadLocalRandom;

/**
 * @author ZhuYX
 * @date 2021/03/03
 */
@Slf4j
@Service("resourceService")
public class ResourceServiceImpl implements ResourceService {



    @Override
    public void test() {
        log.info("ResourceServiceImpl test exec.");
    }

    @Override
    public String getRandom() {
        return ThreadLocalRandom.current().toString();
    }
}
