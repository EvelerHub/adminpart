package evedev.csgoadminpart.controllers;

import evedev.csgoadminpart.constants.BotServer;
import evedev.csgoadminpart.entity.botserver.SteamAccount;
import evedev.csgoadminpart.services.SteamAccountService;
import org.json.simple.JSONObject;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import retrofit.RestAdapter;
import retrofit.converter.JacksonConverter;

import java.net.MalformedURLException;
import java.util.List;

/**
 * Controller for steam page(steam.jsp) <br/>
 * Mapping:  /steam.
 *
 * @author Alexander Eveler
 */
@Controller
@RequestMapping("/steam")
public class SteamController {

    private SteamAccountService steamAccountService = new RestAdapter.Builder()
            .setEndpoint(BotServer.URL)
            .setConverter(new JacksonConverter())
            .build()
            .create(SteamAccountService.class);

    @RequestMapping(method = RequestMethod.GET)
    public String getView() {

        return "steam";
    }

    @RequestMapping(value = "/get", method = RequestMethod.GET)
    @ResponseBody
    List<SteamAccount> getSteamAccounts() throws MalformedURLException {

        return steamAccountService.listSteamAccounts();
    }

    @RequestMapping(value = "/add", method = RequestMethod.GET)
    @ResponseBody
    JSONObject addSteamAccounts(@RequestBody JSONObject postPayload) {

        return steamAccountService.addSteamAccount(postPayload);
    }

    @RequestMapping(value = "/update", method = RequestMethod.POST)
    @ResponseBody
    JSONObject doUpdateSteamAccount(@RequestBody JSONObject postPayload) {

        return steamAccountService.updateSteamAccount(postPayload);
    }

    @RequestMapping(value = "/delete", method = RequestMethod.POST)
    @ResponseBody
    JSONObject doDeleteSteamAccount(@RequestBody JSONObject postPayload) {

        return steamAccountService.deleteSteamAccount(postPayload);
    }

    @RequestMapping(value = "/start", method = RequestMethod.POST)
    @ResponseBody
    JSONObject doStartSteamAccount(@RequestBody JSONObject postPayload) {

        return steamAccountService.startSteamAccount(postPayload);
    }

    @RequestMapping(value = "/stop", method = RequestMethod.POST)
    @ResponseBody
    JSONObject doStopSteamAccount(@RequestBody JSONObject postPayload) {

        return steamAccountService.stopSteamAccount(postPayload);
    }
}
