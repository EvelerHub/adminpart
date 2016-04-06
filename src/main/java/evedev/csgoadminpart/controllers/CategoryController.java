package evedev.csgoadminpart.controllers;

import evedev.csgoadminpart.entity.dao.Category;
import evedev.csgoadminpart.entity.dao.Collection;
import evedev.csgoadminpart.exceptions.RecordNotFoundException;
import evedev.csgoadminpart.repository.dao.CategoryRepository;
import evedev.csgoadminpart.repository.dao.CollectionRepository;
import org.jboss.logging.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

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

    public static final Logger logger = Logger.getLogger(CollectionsController.class);

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

    @ResponseBody
    @RequestMapping(value = "/getAll", method = RequestMethod.POST)
    public List<Collection> getCollections(@PathVariable long categoryID) {
        List<Collection> collections;
        try {
            collections = collectionRepository.getByCategoryId(categoryID);
            System.out.println(collections);
        } catch (RecordNotFoundException e) {
            return null;
        }

        return collections;
    }

    @ResponseBody
    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public Collection addCollection(@RequestBody Collection collection, @PathVariable long categoryID) {
        Collection addedCollection;
        try {
            collection.setCategory(categoryRepository.getById(categoryID));
            addedCollection = collectionRepository.add(collection);
            System.out.println(addedCollection);
        } catch (RecordNotFoundException e) {
            return null;
        }

        return addedCollection;
    }

    @ResponseBody
    @RequestMapping(value = "/update", method = RequestMethod.POST)
    public Collection updateCollection(@RequestBody Collection collection, @PathVariable long categoryID) {
        Collection updatedCollection;
        try {
            collection.setCategory(categoryRepository.getById(categoryID));
            updatedCollection = collectionRepository.update(collection);
            System.out.println(updatedCollection);
        } catch (RecordNotFoundException e) {
            return null;
        }

        return updatedCollection;
    }

    @ResponseBody
    @RequestMapping(value = "/delete", method = RequestMethod.POST)
    public Collection deleteCollection(@RequestBody Collection collection, @PathVariable long categoryID) {
        try {
            collection.setCategory(categoryRepository.getById(categoryID));
            collectionRepository.remove(collection);
            System.out.println("remove ==>" + collection);
        } catch (RecordNotFoundException e) {
            return null;
        }

        return collection;
    }
}
