package evedev.csgoadminpart.controllers;

import evedev.csgoadminpart.entity.dao.Category;
import evedev.csgoadminpart.entity.dao.Collection;
import evedev.csgoadminpart.exceptions.RecordNotFoundException;
import evedev.csgoadminpart.repository.dao.CategoryRepository;
import evedev.csgoadminpart.repository.dao.CollectionRepository;
import org.jboss.logging.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * Controller for each Category.
 * Mapping: /category.
 *
 * @author Alexander Eveler
 */
@Controller
@RequestMapping("/category/{categoryID}")
public class CategoryController {

    public static final Logger logger = Logger.getLogger(CollectionController.class);

    @Autowired
    CategoryRepository categoryRepository;

    @Autowired
    CollectionRepository collectionRepository;

    @RequestMapping(method = RequestMethod.GET)
    public String getCategory(@PathVariable int categoryID) {
        // TODO: set must be downloaded from database
        try {
            Category category = categoryRepository.getById(categoryID);

            return "category";
        } catch (RecordNotFoundException e) {
            e.printStackTrace();
        }

        return "notfound";
    }

    @RequestMapping(value = "/getCollections", method = RequestMethod.POST)
    public @ResponseBody List<Collection> getCollections(@PathVariable int categoryID) {
        List<Collection> collections = null;
        try {
            collections = collectionRepository.getByCategoryId(categoryID);
            System.out.println(collections);
        } catch (RecordNotFoundException e) {
            e.printStackTrace();
        }

        return collections;
    }
}
