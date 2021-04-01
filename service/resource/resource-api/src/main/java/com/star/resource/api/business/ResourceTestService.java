package com.star.resource.api.business;

import com.star.resource.dto.ResourceTestDTO;
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
@FeignClient(name = "resource-service", path = Module.JAXRS_PATH, contextId = "jaxrs")
@Consumes({MediaType.APPLICATION_JSON})
@Produces({MediaType.APPLICATION_JSON})
@Path("/resource-test")
public interface ResourceTestService {

    @PUT
    @Path("/save")
    ResourceTestDTO save(ResourceTestDTO rt);

    @PUT
    @Path("/increment")
    ResourceTestDTO increment(Long id);
}
