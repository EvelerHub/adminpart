package evedev.csgoadminpart.repository.dao;

import evedev.csgoadminpart.entity.dao.Category;
import evedev.csgoadminpart.exceptions.RecordNotFoundException;

import java.util.List;

/**
 * DAO interface for Category.
 *
 * @author Alexander Eveler
 */
public interface CategoryRepository {

    List<Category> getAll();

    Category getById(long id) throws RecordNotFoundException;

    Category update(Category category) throws RecordNotFoundException;

    Category add(Category category);

    void remove(Category category) throws RecordNotFoundException;
}
