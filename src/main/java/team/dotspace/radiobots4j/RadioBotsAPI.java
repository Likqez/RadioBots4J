package team.dotspace.radiobots4j;

import team.dotspace.radiobots4j.auth.AuthCredentials;
import team.dotspace.radiobots4j.category.CloudCategory;
import team.dotspace.radiobots4j.http.RequestProvider;

public class RadioBotsAPI {

    private final RequestProvider provider;

    public RadioBotsAPI(AuthCredentials authCredentials) {
        this.provider = new RequestProvider(authCredentials);
    }


    public CloudCategory cloud() {
        return new CloudCategory(this.provider);
    }
}
