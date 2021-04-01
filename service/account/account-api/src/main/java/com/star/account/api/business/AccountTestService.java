package com.star.account.api.business;

import com.star.account.dto.AccountTestDTO;
import org.springframework.cloud.openfeign.FeignClient;

import javax.ws.rs.Consumes;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

/**
 * @author ZhuYX
 * @date 2021/03/03
 */
@FeignClient(name = "account-service", path = Module.JAXRS_PATH, contextId = "jaxrs")
@Consumes({MediaType.APPLICATION_JSON})
@Produces({MediaType.APPLICATION_JSON})
@Path("/account-test")
public interface AccountTestService {

    @PUT
    @Path("/save")
    AccountTestDTO save(AccountTestDTO accountDTO);

    /**
     * a -> b -> c
     * @param id
     * @return
     */
    @PUT
    @Path("/increment")
    AccountTestDTO increment(Long id);

    /**
     * a -> b
     * a -> c
     * @param id
     * @return
     */
    @PUT
    @Path("/increment2")
    AccountTestDTO increment2(Long id);
}
