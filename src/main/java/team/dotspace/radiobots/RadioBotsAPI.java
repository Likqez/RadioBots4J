package team.dotspace.radiobots;

import team.dotspace.radiobots.auth.AuthCredentials;
import team.dotspace.radiobots.category.CloudCategory;
import team.dotspace.radiobots.http.RequestProvider;

public class RadioBotsAPI {

    private final RequestProvider provider;

    public RadioBotsAPI(AuthCredentials authCredentials) {
        this.provider = new RequestProvider(authCredentials);
    }


    public CloudCategory cloud() {
        return new CloudCategory(this.provider);
    }
}
