/**
 * @author ZhuYX
 * @date 2021/03/04
 */
package com.star.resource.api.business;


class Module{
    public static final String NAME = "resource-service";

    public static final String URL = "${boss.url." + NAME + ":" + NAME + "}";

    public static final String JAXRS_PATH = NAME;

    public static final String WEB_PATH = "";
}