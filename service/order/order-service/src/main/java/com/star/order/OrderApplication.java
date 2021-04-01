package com.star.order;

import com.star.config.jersey.RpcTransProviderFilter;
import org.glassfish.jersey.server.ResourceConfig;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.ApplicationContext;
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
@EnableAspectJAutoProxy(exposeProxy = true)
@EntityScan("com.star.order.domain")
@EnableJpaRepositories("com.star.order.dao")
@EnableFeignClients({
        "com.star.resource.api.business",
        "com.star.account.api.business",
})
public class OrderApplication {

    public static void main(String[] args) {
        SpringApplication.run(OrderApplication.class, "OrderApplication.class");
    }

    @Bean
    public ResourceConfig jerseyConfig(ApplicationContext ac) {
        ResourceConfig config = new ResourceConfig();
        config.register(RpcTransProviderFilter.class);
//        config.registerClasses(JerseyServiceAutoScanner.getPublishJerseyServiceClasses(ac,
//                "com.star.order.api.business"));
        config.packages("com.star.order.api.business");
        return config;
    }
}
