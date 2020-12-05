package team.dotspace.radiobots4j.category;

import kong.unirest.HttpResponse;
import kong.unirest.JsonNode;
import team.dotspace.radiobots4j.http.RequestProvider;
import team.dotspace.radiobots4j.util.JsonMapBuilder;

public class CloudCategory {

    private final RequestProvider provider;

    public CloudCategory(RequestProvider provider) {
        this.provider = provider;
    }

    /**
     * @apiNote <a href="https://docs.radiobots.eu/#cloud-get-all-regions">https://docs.radiobots.eu/#cloud-get-all-regions</a>
     */
    public HttpResponse<JsonNode> getRegions() {
        return provider.get("cloud/regions").asJson();
    }

    /**
     * @apiNote <a href="https://docs.radiobots.eu/#cloud-get-a-task">https://docs.radiobots.eu/#cloud-get-a-task</a>
     */
    public HttpResponse<JsonNode> getTask(String uuid) {
        return provider.get("cloud/task").header("Data", new JsonMapBuilder().addEntry("uuid", uuid).build()).asJson();
    }
}
