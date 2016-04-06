package evedev.csgoadminpart.services;

import evedev.csgoadminpart.constants.BotServer;
import org.json.simple.JSONObject;
import retrofit.http.Body;
import retrofit.http.Headers;
import retrofit.http.POST;

/**
 * @author Alexander Eveler
 */
public interface LoginService {

    @POST(value = BotServer.BotPaths.UPDATE)
    @Headers("Content-Type: application/json")
    JSONObject login(@Body JSONObject body);
}
