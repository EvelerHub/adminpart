package evedev.csgoadminpart.repository.dao;

import evedev.csgoadminpart.entity.dao.Collection;
import evedev.csgoadminpart.exceptions.RecordNotFoundException;

import java.util.List;

/**
 * DAO interface for Collection.
 *
 * @author Alexander Eveler
 */
public interface CollectionRepository {

    List<Collection> getAll();

    Collection getById(long id) throws RecordNotFoundException;

    List<Collection> getByCategoryId(long categoryId) throws RecordNotFoundException;

    Collection update(Collection collection) throws RecordNotFoundException;

    Collection add(Collection collection);

    void remove(Collection collection) throws RecordNotFoundException;
}
