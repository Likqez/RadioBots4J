package team.dotspace.radiobots.category;

import kong.unirest.HttpResponse;
import kong.unirest.JsonNode;
import team.dotspace.radiobots.http.RequestProvider;

public class CloudCategory {

    private final RequestProvider provider;

    public CloudCategory(RequestProvider provider) {
        this.provider = provider;
    }

    /**
     * <a href="https://docs.radiobots.eu/#cloud-get-all-regions">https://docs.radiobots.eu/#cloud-get-all-regions</a>
     */
    public HttpResponse<JsonNode> getRegions() {
        return provider.get("cloud/regions").asJson();
    }
}
