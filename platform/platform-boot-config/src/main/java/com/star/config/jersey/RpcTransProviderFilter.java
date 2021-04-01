package com.star.config.jersey;

import io.seata.common.util.StringUtils;
import io.seata.core.context.RootContext;

import javax.ws.rs.container.ContainerRequestContext;
import javax.ws.rs.container.ContainerRequestFilter;
import javax.ws.rs.container.ContainerResponseContext;
import javax.ws.rs.container.ContainerResponseFilter;
import java.io.IOException;

public class RpcTransProviderFilter implements ContainerRequestFilter, ContainerResponseFilter {


    //ContainerRequestFilter
    @Override
    public void filter(ContainerRequestContext requestContext) throws IOException {
        String xid = RootContext.getXID();
        String rpcXid = requestContext.getHeaderString(RootContext.KEY_XID);
        if (StringUtils.isBlank(xid) && rpcXid != null) {
            RootContext.bind(rpcXid);
        }
    }

    // ContainerResponseFilter
    @Override
    public void filter(ContainerRequestContext requestContext, ContainerResponseContext responseContext) {
        if (StringUtils.isNotBlank(RootContext.getXID())) {
            String rpcXid = requestContext.getHeaderString(RootContext.KEY_XID);
            if (StringUtils.isEmpty(rpcXid)) {
                return;
            }
            String unbindXid = RootContext.unbind();
            if (!rpcXid.equalsIgnoreCase(unbindXid)) {
                if (unbindXid != null) {
                    RootContext.bind(unbindXid);
                }
            }
        }
    }



}