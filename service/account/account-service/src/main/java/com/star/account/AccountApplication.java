package com.star.account;

import com.fasterxml.jackson.databind.SerializationFeature;
import com.star.config.jersey.RpcTransProviderFilter;
import org.glassfish.jersey.server.ResourceConfig;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.autoconfigure.jackson.Jackson2ObjectMapperBuilderCustomizer;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.transaction.annotation.EnableTransactionManagement;

/**
 * @author ZhuYX
 * @date 2021/03/03
 */
@EnableDiscoveryClient
@SpringBootApplication(scanBasePackages = "com.star")
@EnableTransactionManagement
@EnableAspectJAutoProxy(exposeProxy = true, proxyTargetClass = true)
@EntityScan("com.star.account.domain")
@EnableJpaRepositories("com.star.account.dao")
@EnableFeignClients({
        "com.star.resource.api.business",
        "com.star.order.api.business",
})
public class AccountApplication {

    public static void main(String[] args) {
        SpringApplication.run(AccountApplication.class, "AccountApplication.class");
    }

    @Bean
    public ResourceConfig jerseyConfig() {
        ResourceConfig config = new ResourceConfig();
        config.register(RpcTransProviderFilter.class);
        config.packages("com.star.account.api.business");
        return config;
    }

    @Bean
    public Jackson2ObjectMapperBuilderCustomizer jackson2ObjectMapperBuilderCustomizer() {
        return builder -> {
            builder.featuresToDisable(SerializationFeature.FAIL_ON_EMPTY_BEANS);
        };
    }
}
