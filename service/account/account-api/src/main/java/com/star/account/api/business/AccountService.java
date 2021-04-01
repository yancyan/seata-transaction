package com.star.account.api.business;

import com.star.account.dto.AccountDTO;
import org.springframework.cloud.openfeign.FeignClient;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;

/**
 * @author ZhuYX
 * @date 2021/03/03
 */
@FeignClient(name = "account-service", path = Module.JAXRS_PATH, contextId = "jaxrs")
@Consumes({MediaType.APPLICATION_JSON})
@Produces({MediaType.APPLICATION_JSON})
@Path("/account")
public interface AccountService {

    @GET
    @Path("/findById")
    AccountDTO findById(@QueryParam("id") Long id);

    @GET
    @Path("/test")
    void test();

    /**
     * 一阶段方法
     *
     * @param businessActionContext
     * @param accountNo
     * @param amount
     */
    @GET
    @Path("/prepareMinus")
    public boolean prepareMinus(@QueryParam("accountNo") String accountNo,
                                @QueryParam("amount") Double amount);

    @PUT
    @Path("/save")
    AccountDTO save(AccountDTO accountDTO);
}
