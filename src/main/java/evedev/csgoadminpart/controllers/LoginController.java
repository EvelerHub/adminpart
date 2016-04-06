package evedev.csgoadminpart.controllers;

import evedev.csgoadminpart.entity.controllers.Authentication;
import evedev.csgoadminpart.entity.dao.Admin;
import evedev.csgoadminpart.exceptions.RecordNotFoundException;
import evedev.csgoadminpart.exceptions.UnexpectedSituation;
import evedev.csgoadminpart.repository.dao.AdminRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;
import java.util.List;

/**
 * @author Alexander Eveler
 */
@Controller
@RequestMapping("/login")
public class LoginController {

    @Autowired
    private AdminRepository adminRepository;

    @RequestMapping(method = RequestMethod.GET)
    public String getView(){

        return "login";
    }

    @RequestMapping(method = RequestMethod.POST)
    @ResponseBody
    public Admin doAuthorization(@RequestBody Authentication authentication, HttpSession session){
        String login = authentication.getLogin();
        String password  = authentication.getPassword();

        Admin admin;
        try {
            List<Admin> admins = adminRepository.getByLoginAndPassword(login, password);
            admin = admins.get(0);
            session.setAttribute("user", admin);
        } catch (RecordNotFoundException e) {
            System.out.println("[error] [" + this.getClass() + "]" + e.getMessage());

            return null;
        } catch (UnexpectedSituation unexpectedSituation) {
            System.out.println("[error] [" + this.getClass() + "] " + unexpectedSituation.getMessage());

            return null;
        }

        return admin;
    }

}
