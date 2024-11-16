package org.acme.Service;

import org.acme.dto.Message;
import org.acme.entity.Parent;
import org.acme.repository.ParentRepository;
import org.jboss.logging.Logger;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;

@ApplicationScoped
public class ParentService {

    @Inject
    ParentRepository repository;

    @Inject
    Logger logger;

    @Transactional
    public void persist(Message message) {
        try {
            if (message == null) {
                throw new IllegalArgumentException("Mensagem não pode ser nula");
            }
            var parent = Parent.buildFromMessage(message);
            repository.saveOrUpdate(parent);
        } catch (Exception e) {
            logger.error("Erro ao salvar ou atualizar entidade Parent: " + e.getMessage(), e);
            throw e;
        }
    }
}

