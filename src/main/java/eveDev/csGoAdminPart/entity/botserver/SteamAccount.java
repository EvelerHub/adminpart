package evedev.csgoadminpart.entity.botserver;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.io.Serializable;

/**
 * Entity for SteamAccount table from bot server. <br/>
 *
 * @author Alexander Eveler
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class SteamAccount implements Serializable {

    private static final long serialVersionUID = 1718619513645258261L;

    @JsonProperty("login")
    private String login;

    @JsonProperty("pass")
    private String password;

    @JsonProperty("market_key")
    private String marketKey;

    @JsonProperty("steam_key")
    private String steamKey;

    @JsonProperty("dateAdded")
    private String dateAdded;

    @JsonProperty("updateDate")
    private String updateDate;

    @JsonProperty("status")
    private String status;

    public SteamAccount() {
    }

    /**
     * <p>Constructor with parameters <p/>
     *
     * unstable.<br/>
     * Too many parameters.<br/>
     * Here should be <em>builder pattern</em>.<br/>
     *
//     * @param id is name for database in <em> CsGoBot server </em>
     * @param login is <em> Steam account </em> username
     * @param password is <em> Steam account </em> password
     * @param marketKey is developer key of <a href="https://csgo.tm/"> marketplace </a>
     * @param steamKey is developer key of Steam
     * @param dateAdded is date of added entity into <em> CsGoBot server </em>
     * @param updateDate is date of last status updating by <em> CsGoBot server <em>
     * @param status is one of <em> Steam account  </em> condition into <em> CsGoBot server </em>
     */
    public SteamAccount(String login, String password, String marketKey,
                        String steamKey, String dateAdded, String updateDate, String status) {
        this.login = login;
        this.password = password;
        this.marketKey = marketKey;
        this.steamKey = steamKey;
        this.dateAdded = dateAdded;
        this.updateDate = updateDate;
        this.status = status;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getMarketKey() {
        return marketKey;
    }

    public void setMarketKey(String marketKey) {
        this.marketKey = marketKey;
    }

    public String getSteamKey() {
        return steamKey;
    }

    public void setSteamKey(String steamKey) {
        this.steamKey = steamKey;
    }

    public String getDateAdded() {
        return dateAdded;
    }

    public void setDateAdded(String dateAdded) {
        this.dateAdded = dateAdded;
    }

    public String getUpdateDate() {
        return updateDate;
    }

    public void setUpdateDate(String updateDate) {
        this.updateDate = updateDate;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "SteamAccount{" +
                ", login='" + login + '\'' +
                ", password='" + password + '\'' +
                ", marketKey='" + marketKey + '\'' +
                ", steamKey='" + steamKey + '\'' +
                ", dateAdded='" + dateAdded + '\'' +
                ", updateDate='" + updateDate + '\'' +
                ", status='" + status + '\'' +
                '}';
    }
}
