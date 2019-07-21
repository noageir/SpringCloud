package com.micro.system.zuul.config;

import org.apache.commons.lang.StringUtils;
import org.springframework.cloud.netflix.zuul.filters.Route;
import org.springframework.cloud.netflix.zuul.filters.RouteLocator;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;
import springfox.documentation.swagger.web.SwaggerResource;
import springfox.documentation.swagger.web.SwaggerResourcesProvider;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Noageir
 * Date: 2018-06-24
 * Project: com.spring.cloud
 * Package: com.micro.system.zuul.config
 */
@Component
@Primary
public class GatewaySwaggerResourcesProvider implements SwaggerResourcesProvider {
    private final RouteLocator routeLocator;

    public GatewaySwaggerResourcesProvider(RouteLocator routeLocator) {
        this.routeLocator = routeLocator;
    }

    @Override
    public List<SwaggerResource> get() {
        List<SwaggerResource> resources = new ArrayList<>();
        List<Route> routes = routeLocator.getRoutes();
        resources.add(swaggerResource("zuul-server", "/v2/api-docs"));
        for (Route route : routes) {
            String serverId = route.getId();
            if (!StringUtils.equals("eureka-server", serverId) && !StringUtils.equals("config-server", serverId)) {
                String fullPath = route.getFullPath();
                resources.add(swaggerResource(serverId, fullPath.replace("**", "v2/api-docs")));
            }
        }
        return resources;
    }

    private SwaggerResource swaggerResource(String name, String location) {
        SwaggerResource swaggerResource = new SwaggerResource();
        swaggerResource.setName(name);
        swaggerResource.setLocation(location);
        swaggerResource.setSwaggerVersion("1.0");
        return swaggerResource;
    }
}
