package evedev.csgoadminpart.repository.impl;

import evedev.csgoadminpart.entity.dao.Category;
import evedev.csgoadminpart.exceptions.RecordNotFoundException;
import evedev.csgoadminpart.repository.dao.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import java.util.List;

/**
 * DAO MySQL implementation for Category.
 *
 * @author Alexander Eveler
 */
@Repository
public class CategoryRepositoryImpl implements CategoryRepository {

    private static final String NAMED_QUERY_GET_ALL_CATEGORY = "Category.getAll";

    @Autowired
    private EntityManager entityManager;

    @Override
    public List<Category> getAll() {
        Query query = entityManager.createNamedQuery(NAMED_QUERY_GET_ALL_CATEGORY);
        List<Category> categories = query.getResultList();
        entityManager.close();

        return categories;
    }

    @Override
    public Category getById(long id) throws RecordNotFoundException {
        Category category = entityManager.find(Category.class, id);
        entityManager.close();

        if (category == null) {
            throw new RecordNotFoundException();
        }

        return category;
    }

    @Override
    @Transactional
    public Category update(Category category) throws RecordNotFoundException {
        Category verifiedCategory = getById(category.getId());
        Category updatedCategory = entityManager.merge(verifiedCategory);
        entityManager.close();

        return updatedCategory;
    }

    @Override
    @Transactional
    public Category add(Category category) {
        Category addedCategory = entityManager.merge(category);
        entityManager.close();

        return addedCategory;
    }

    @Override
    @Transactional
    public void remove(Category category) throws RecordNotFoundException {
        Category verifiedCategory = getById(category.getId());
        entityManager.remove(verifiedCategory);
        entityManager.close();
    }
}
