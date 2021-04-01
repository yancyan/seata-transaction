package com.star.resource.api.business;

import com.star.config.common.util.BeanUtil;
import com.star.resource.dao.ResourceTestRepository;
import com.star.resource.domain.ResourceTest;
import com.star.resource.dto.ResourceTestDTO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.concurrent.atomic.AtomicReference;

/**
 * @author ZhuYX
 * @date 2021/03/03
 */
@Slf4j
@Service("resourceTestService")
public class ResourceTestServiceImpl implements ResourceTestService {


    @Resource
    private ResourceTestRepository resourceTestRepository;

    @Override
    public ResourceTestDTO save(ResourceTestDTO rt) {
        return null;
    }

    @Transactional(propagation = Propagation.REQUIRED)
    @Override
    public ResourceTestDTO increment(Long id) {
        AtomicReference<ResourceTestDTO> r = new AtomicReference<>();
        resourceTestRepository.findById(id).ifPresent(rt -> {
            rt.setAmount(rt.getAmount() + 1);
            ResourceTest save = resourceTestRepository.save(rt);

            r.set(BeanUtil.copy(save, ResourceTestDTO.class));
        });
        if (1 == 1) {
            throw new RuntimeException("test exception...");
        }

        return r.get();
    }
}
