package eveDev.csGoAdminPart.mvc;

import org.jboss.logging.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Controller for welcome page(index.jsp)<br/>
 * Mapping: /
 *
 * @author Alexander Eveler
 */
@Controller
public class IndexController {

    private static final Logger log = Logger.getLogger(IndexController.class.getName());

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String getIndexView() {

        return "index";
    }

    @RequestMapping(value = "/get", method = RequestMethod.GET)
    String getAll() {
        String server = "http://ec2-52-35-187-114.us-west-2.compute.amazonaws.com";
        int port = 9000;
        String paht = "/bot";

        return "redirect:" + server + ":" + port + paht;
    }
}
