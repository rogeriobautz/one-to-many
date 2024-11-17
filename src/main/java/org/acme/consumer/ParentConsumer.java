package org.acme.consumer;

import java.util.List;

import org.acme.dto.Message;
import org.acme.entity.Parent;
import org.acme.repository.ParentRepository;

import io.quarkus.runtime.Startup;
import jakarta.annotation.PostConstruct;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;

@Startup
@ApplicationScoped
public class ParentConsumer {

    @Inject
    ParentRepository repository;

    //no script de inicialização já foi inserido um registro para que seja atualizado por esta chamada
    //no log é possível ver que a query de update da tabela Parent não é gerada
    @PostConstruct
    public void postMessage(){

        Message message = new Message(
            "common-id-1",
            "common-id-2",
            "common-id-3",
        "parent-field-1",
        "parent-field-2",
                List.of("child-0-field-1"));

        Parent parent = Parent.buildFromMessage(message);
        repository.saveOrUpdate(parent);   

    }

}
