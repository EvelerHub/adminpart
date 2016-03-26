package evedev.csgoadminpart.controllers;

import evedev.csgoadminpart.entity.dao.Collection;
import evedev.csgoadminpart.repository.dao.CollectionRepository;
import org.jboss.logging.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
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
public class CollectionController {

    public static final  Logger logger = Logger.getLogger(CollectionController.class);

    @Autowired
    CollectionRepository collectionRepository;

    @RequestMapping(method = RequestMethod.GET)
    public String getView() {
        List<Collection> collections = collectionRepository.getAll();
        System.out.println(collections);

        return "collections";
    }

    @RequestMapping(value = "/getCollections", method = RequestMethod.POST)
    public @ResponseBody List<Collection> getCollections() {
        List<Collection> collections = collectionRepository.getAll();
        System.out.println(collections);

        return collections;
    }
}
