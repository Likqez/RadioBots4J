package team.dotspace.radiobots4j.http;

import kong.unirest.Config;
import kong.unirest.UnirestInstance;
import team.dotspace.radiobots4j.auth.AuthCredentials;

import java.time.Duration;

public class RequestProvider extends UnirestInstance {

    private static final Config DEFAULT_CONFIG = new Config()
            .verifySsl(true)
            .connectionTTL(Duration.ofSeconds(10))
            .automaticRetries(true)
            .followRedirects(false)
            .defaultBaseUrl("https://customerapi.radiobots.eu/v1/");


    public RequestProvider(AuthCredentials credentials) {
        super(DEFAULT_CONFIG);
        this.config().setDefaultHeader("Auth", credentials.getAsHeader());
    }
}
