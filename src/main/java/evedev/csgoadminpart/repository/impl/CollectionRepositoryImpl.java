package evedev.csgoadminpart.repository.impl;

import evedev.csgoadminpart.entity.dao.Collection;
import evedev.csgoadminpart.exceptions.RecordNotFoundException;
import evedev.csgoadminpart.repository.dao.CollectionRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.List;

/**
 * DAO MySQL implementation for Collection.
 *
 * @author Alexander Eveler
 */
@Repository
public class CollectionRepositoryImpl implements CollectionRepository {

    private static final String NAMED_QUERY_GET_ALL_COLLECTION = "Collection.getAll";
    private static final String NAMED_QUERY_GET_BY_CATEGORY_ID = "Collection.getByCategoryId";

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public List<Collection> getAll() {
        Query query = entityManager.createNamedQuery(NAMED_QUERY_GET_ALL_COLLECTION);
        List<Collection> collections = query.getResultList();
        entityManager.close();

        return collections;
    }

    @Override
    public Collection getById(long id) throws RecordNotFoundException {
        Collection collection = entityManager.find(Collection.class, id);
        entityManager.close();

        if (collection == null) {
            throw new RecordNotFoundException();
        }

        return collection;
    }

    @Override
    public List<Collection> getByCategoryId(long categoryId) throws RecordNotFoundException {
        Query query = entityManager.createNamedQuery(NAMED_QUERY_GET_BY_CATEGORY_ID);
        query.setParameter(1, categoryId);
        List<Collection> collection = query.getResultList();
        entityManager.close();

        if (collection == null) {
            throw new RecordNotFoundException();
        }

        return collection;
    }

    @Override
    @Transactional
    public Collection update(Collection collection) throws RecordNotFoundException {
        Collection updatedCollection = entityManager.merge(collection);
        entityManager.close();

        return updatedCollection;
    }

    @Override
    @Transactional
    public Collection add(Collection collection) {
        Collection addedCollection = entityManager.merge(collection);
        entityManager.close();

        return addedCollection;
    }

    @Override
    @Transactional
    public void remove(Collection collection) throws RecordNotFoundException {
        entityManager.remove(entityManager.contains(collection) ? collection : entityManager.merge(collection));
        entityManager.close();
    }
}
