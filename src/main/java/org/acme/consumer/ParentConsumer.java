package org.acme.consumer;

import java.util.List;

import org.acme.Service.ParentService;
import org.acme.dto.Message;
import org.jboss.logging.Logger;

import io.quarkus.runtime.Startup;
import jakarta.annotation.PostConstruct;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.core.Response;

@Startup
@ApplicationScoped
@Path("/persist")
public class ParentConsumer {

    @Inject
    Logger logger;

    @Inject
    ParentService service;

    @POST
    public Response persist(Message message) {
        if (message == null) {
            return Response.noContent().build();
        }
        service.persist(message);
        return Response.ok().build();
    }

    // já inicia fazendo o teste de update
    
    @PostConstruct
    public void postMessage(){
        Message message = new Message(
            "common-id-1",
            "common-id-2",
            "common-id-3",
        "parent-field-1",
        "parent-field-2",
                List.of("child-1-field-1", "child-2-field-1", "child-3-field-1"));
        this.persist(message);        
    }

}
