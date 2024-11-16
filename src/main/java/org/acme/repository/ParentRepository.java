package org.acme.repository;

import org.acme.entity.Parent;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.persistence.EntityManager;
import jakarta.transaction.Transactional;

@Transactional
@ApplicationScoped
public class ParentRepository {

    @Inject
    EntityManager em;

    private Logger logger = LoggerFactory.getLogger(this.getClass());

    public void saveOrUpdate(Parent entity) {

        logger.info("Parent sendo persistida:  {}",entity);
        em.merge(entity);
    }
}

