package evedev.csgoadminpart.constants;

/**
 * Constants for bot Server API.
 *
 * @author Alexander Eveler
 */
public class BotServer {
    public static final String URL = "http://ec2-52-35-187-114.us-west-2.compute.amazonaws.com:9000";

    public static final String PROTOCOL = "http";

    public static final String HOST = "ec2-52-35-187-114.us-west-2.compute.amazonaws.com";

    public static final int PORT = 9000;

    public class BotPaths {
        public static final String BOT = "/bot";

        public static final String DELETE = "/bot/delete";

        public static final String STOP = "/bot/stop";

        public static final String START = "/bot/start";

        public static final String UPDATE = "/bot/update";

        public static final String ADD = "/bot/add";
    }
}
