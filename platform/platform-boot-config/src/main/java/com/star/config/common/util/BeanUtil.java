package com.star.config.common.util;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.objenesis.ObjenesisException;
import org.springframework.objenesis.SpringObjenesis;
import org.springframework.util.ReflectionUtils;

/**
 * @author ZhuYX
 * @date 2021/03/03
 */
@Slf4j
public abstract class BeanUtil {
    private static final SpringObjenesis objenesis = new SpringObjenesis();


    public static <T> T copy(Object source, Class<T> targetClass, String... ignoreProperties) {
        T target = newInstance(targetClass, true);
        BeanUtils.copyProperties(source, target, ignoreProperties);
        return target;
    }


    public static <T> T newInstance(Class<T> tgClass, boolean useCache) {
        if (objenesis.isWorthTrying()) {
            try {
                return objenesis.newInstance(tgClass, useCache);
            }
            catch (ObjenesisException ex) {
                log.debug("Unable to instantiate using Objenesis, falling back to regular construction", ex);
            }
        }
        try {
            return ReflectionUtils.accessibleConstructor(tgClass).newInstance();
        }
        catch (Throwable ex) {
            throw new IllegalStateException("Instantiation via default constructor fails as well", ex);
        }
    }
}
