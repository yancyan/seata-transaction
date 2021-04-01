/**
 * @author ZhuYX
 * @date 2021/03/04
 */
package com.star.order.api.business;

class Module{

    public static final String NAME = "order-service";

    public static final String URL = "${boss.url." + NAME + ":" + NAME + "}";

    public static final String JAXRS_PATH = NAME;

    public static final String WEB_PATH = "";
}