package com.star.order.api.business;

import org.springframework.cloud.openfeign.FeignClient;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

/**
 * @author ZhuYX
 * @date 2021/03/03
 */
@FeignClient(name = "order-service", path = Module.JAXRS_PATH, contextId = "jaxrs")
@Consumes({MediaType.APPLICATION_JSON})
@Produces({MediaType.APPLICATION_JSON})
@Path("/order")
public interface OrderService {


    @GET
    @Path("/test")
    void test();
}
