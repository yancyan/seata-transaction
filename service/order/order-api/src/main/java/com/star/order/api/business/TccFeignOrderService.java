package com.star.order.api.business;

import org.springframework.cloud.openfeign.FeignClient;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;

/**
 * @author ZhuYX
 * @date 2021/03/08
 */
@FeignClient(name = "order-service", path = Module.JAXRS_PATH, contextId = "jaxrs")
@Consumes({MediaType.APPLICATION_JSON})
@Produces({MediaType.APPLICATION_JSON})
@Path("/order-tcc-feign")
public interface TccFeignOrderService {

    @GET
    @Path("/prepare")
    public boolean prepare_(@QueryParam("amount") Integer amount);


}
