package com.star.account.api.business;

import org.springframework.cloud.openfeign.FeignClient;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;

/**
 * @author ZhuYX
 * @date 2021/03/08
 */
@FeignClient(name = "account-service", path = Module.JAXRS_PATH, contextId = "jaxrs")
@Consumes({MediaType.APPLICATION_JSON})
@Produces({MediaType.APPLICATION_JSON})
@Path("/tcc")
public interface TccTransactionService {

    @GET
    @Path("/test")
    String test(@QueryParam("accountNo") String accountNo,
                @QueryParam("amount") Double amount);

}
