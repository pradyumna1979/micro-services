package com.pradyumna.cloud.config;

import org.springdoc.core.models.GroupedOpenApi;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.gateway.route.RouteDefinition;
import org.springframework.cloud.gateway.route.RouteDefinitionLocator;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import java.util.List;
import java.util.Objects;
import java.util.function.Function;
import java.util.stream.Collectors;
/*
In order to expose OpenAPI documentation from multiple v3/api-docs endpoints we need to use
 the GroupedOpenApi object.
 It should provide a way to switch between documentation generated by employee-service,
 department-service and organization-service.
 Those services run on dynamic addresses (or at least random ports). In that case, we will use the
 RouteDefinitionLocator bean to grab the current URL of each service.
 Then we just need to filter a list of routes to find only those related to our three microservices.
Finally, we create the GroupedOpenApi containing a service name and path.
 */
@Configuration
public class SwagerConfig {
    @Autowired
    RouteDefinitionLocator locator;

    @Bean
    public List<GroupedOpenApi> apis() {
        Function<RouteDefinition, GroupedOpenApi> getRouteDefinitionGroupedOpenApiFunction =
                routeDefinition -> {
                    String name = routeDefinition.getId()
                            .replaceAll("-service", "");
                    return GroupedOpenApi.builder()
                            .pathsToMatch("/" + name + "/**").group(name).build();
                };

        return Objects.requireNonNull(locator
                        .getRouteDefinitions().collectList().block())
                .stream().filter(routeDefinition -> routeDefinition
                        .getId()
                        .matches(".*-service"))
                .map(getRouteDefinitionGroupedOpenApiFunction)
                .collect(Collectors.toList());
    }

}
