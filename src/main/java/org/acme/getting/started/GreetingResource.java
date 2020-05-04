package org.acme.getting.started;

import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.jboss.resteasy.annotations.jaxrs.PathParam;

@Path("/hello")
public class GreetingResource {

    @Inject
    GreetingService service;

    @Inject
    HostnameIpService ipservice;

    @GET
    @Produces(MediaType.TEXT_PLAIN)
    public String greeting(@PathParam String name) {
        return service.greeting(name) + ": " + ipservice.hostnameIP();
    }

}