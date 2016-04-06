package evedev.csgoadminpart.controllers;

import evedev.csgoadminpart.entity.dao.Collection;
import evedev.csgoadminpart.exceptions.RecordNotFoundException;
import evedev.csgoadminpart.repository.dao.CollectionRepository;
import org.jboss.logging.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * Controller for set page(collections.jsp)<br/>
 * Mapping:  /collections.
 *
 * @author Alexander Eveler
 */
@Controller
@RequestMapping("/collections")
public class CollectionsController {

    public static final  Logger logger = Logger.getLogger(CollectionsController.class);

    @Autowired
    CollectionRepository collectionRepository;

    @RequestMapping(method = RequestMethod.GET)
    public String getView() {
        List<Collection> collections = collectionRepository.getAll();
        System.out.println(collections);

        return "collections";
    }

    @RequestMapping(value = "/getAll", method = RequestMethod.POST)
    public @ResponseBody List<Collection> getCollections() {
        List<Collection> collections = collectionRepository.getAll();
        System.out.println(collections);

        return collections;
    }

    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public @ResponseBody Collection addCollection(@RequestBody Collection collection) {
        Collection addedCollection = collectionRepository.add(collection);
        System.out.println(addedCollection);

        return addedCollection;
    }

    @RequestMapping(value = "/update", method = RequestMethod.POST)
    public @ResponseBody Collection updateCollection(@RequestBody Collection collection) {
        Collection updatedCollection = null;
        try {
            updatedCollection = collectionRepository.update(collection);
            System.out.println(updatedCollection);
        } catch (RecordNotFoundException e) {
            e.printStackTrace();
            return null;
        }

        return updatedCollection;
    }

    @RequestMapping(value = "/delete", method = RequestMethod.POST)
    public @ResponseBody Collection deleteCollection(@RequestBody Collection collection) {
        try {
            collectionRepository.remove(collection);
            System.out.println("remove ==>" + collection);
        } catch (RecordNotFoundException e) {
            return null;
        }

        return collection;
    }
}
