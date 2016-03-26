package evedev.csgoadminpart.services;

import evedev.csgoadminpart.constants.BotServer;
import evedev.csgoadminpart.entity.botserver.SteamAccount;
import org.json.simple.JSONObject;
import retrofit.http.Body;
import retrofit.http.GET;
import retrofit.http.Headers;
import retrofit.http.POST;

import java.util.List;

/**
 * Service for bot server api. <br/>
 * Based on Retrofit 1.9.0 library.
 *
 * @author Alexander Eveler;
 */
public interface SteamAccountService {
    @GET(value = BotServer.BotPaths.BOT)
    List<SteamAccount> listSteamAccounts();

    @POST(value = BotServer.BotPaths.UPDATE)
    @Headers("Content-Type: application/json")
    JSONObject updateSteamAccount(@Body JSONObject body);

    @POST(value = BotServer.BotPaths.DELETE)
    @Headers("Content-Type: application/json")
    JSONObject deleteSteamAccount(@Body JSONObject body);

    @POST(value = BotServer.BotPaths.START)
    @Headers("Content-Type: application/json")
    JSONObject startSteamAccount(@Body JSONObject body);

    @POST(value = BotServer.BotPaths.STOP)
    @Headers("Content-Type: application/json")
    JSONObject stopSteamAccount(@Body JSONObject body);

    @POST(value = BotServer.BotPaths.ADD)
    @Headers("Content-Type: application/json")
    JSONObject addSteamAccount(@Body JSONObject body);
}
