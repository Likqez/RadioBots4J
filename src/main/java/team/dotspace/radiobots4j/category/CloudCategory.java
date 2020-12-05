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

    /* Misc */

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
        return provider.get("cloud/task")
                .header("Data", new JsonMapBuilder().addEntry("uuid", uuid).build())
                .asJson();
    }

    /* CloudServer */

    /**
     * @apiNote <a href="https://docs.radiobots.eu/#cloud-cloudserver-create-a-cloudserver">https://docs.radiobots.eu/#cloud-cloudserver-create-a-cloudserver</a>
     */
    public HttpResponse<JsonNode> createServer(String name, String region, String series, String image, int cores, double ram, int disk, String network, String ssh_key) {
        network = "both";
        return provider.post("cloud/cloudserver/server").header("Data",
                new JsonMapBuilder()
                        .addEntry("name", name)
                        .addEntry("region", region)
                        .addEntry("series", series)
                        .addEntry("image", image)
                        .addEntry("cores", cores)
                        .addEntry("ram", ram)
                        .addEntry("disk", disk)
                        .addEntry("network", network)
                        .addEntry("ssh_keys", ssh_key)
                        .addEntry("calc", false)
                        .build()
        ).asJson();
    }

    /**
     * @apiNote <a href="https://docs.radiobots.eu/#cloud-cloudserver-delete-a-cloudserver">https://docs.radiobots.eu/#cloud-cloudserver-delete-a-cloudserver</a>
     */
    public HttpResponse<JsonNode> deleteServer(String uuid) {
        return provider.delete("cloud/cloudserver/server")
                .header("Data", new JsonMapBuilder().addEntry("uuid", uuid).build())
                .asJson();
    }

    /**
     * @apiNote <a href="https://docs.radiobots.eu/#cloud-cloudserver-get-all-cloudserver">https://docs.radiobots.eu/#cloud-cloudserver-get-all-cloudserver</a>
     */
    public HttpResponse<JsonNode> getServers() {
        return provider.get("cloud/cloudserver/get").asJson();
    }

    /**
     * @apiNote <a href="https://docs.radiobots.eu/#cloud-cloudserver-get-a-cloudserver">https://docs.radiobots.eu/#cloud-cloudserver-get-a-cloudserver</a>
     */
    public HttpResponse<JsonNode> getServer(String uuid) {
        return provider.get("cloud/cloudserver/server")
                .header("Data", new JsonMapBuilder().addEntry("uuid", uuid).build())
                .asJson();
    }

    /**
     * @apiNote <a href="https://docs.radiobots.eu/#cloud-cloudserver-get-all-images">https://docs.radiobots.eu/#cloud-cloudserver-get-all-images</a>
     */
    public HttpResponse<JsonNode> getImages() {
        return provider.get("cloud/cloudserver/images").asJson();
    }

    /**
     * @apiNote <a href="https://docs.radiobots.eu/#cloud-cloudserver-action-start">https://docs.radiobots.eu/#cloud-cloudserver-action-start</a>
     */
    public HttpResponse<JsonNode> startServer(String uuid) {
        return provider.post("cloud/cloudserver/action/start")
                .header("Data", new JsonMapBuilder().addEntry("uuid", uuid).build())
                .asJson();
    }

    /**
     * @apiNote <a href="https://docs.radiobots.eu/#cloud-cloudserver-action-shutdown">https://docs.radiobots.eu/#cloud-cloudserver-action-shutdown</a>
     */
    public HttpResponse<JsonNode> shutdownServer(String uuid) {
        return provider.post("cloud/cloudserver/action/shutdown")
                .header("Data", new JsonMapBuilder().addEntry("uuid", uuid).build())
                .asJson();
    }

    /**
     * @apiNote <a href="https://docs.radiobots.eu/#cloud-cloudserver-action-stop">https://docs.radiobots.eu/#cloud-cloudserver-action-stop</a>
     */
    public HttpResponse<JsonNode> stopServer(String uuid) {
        return provider.post("cloud/cloudserver/action/stop")
                .header("Data", new JsonMapBuilder().addEntry("uuid", uuid).build())
                .asJson();
    }

    /**
     * @apiNote <a href="https://docs.radiobots.eu/#cloud-cloudserver-action-restart">https://docs.radiobots.eu/#cloud-cloudserver-action-restart</a>
     */
    public HttpResponse<JsonNode> restartServer(String uuid) {
        return provider.post("cloud/cloudserver/action/restart")
                .header("Data", new JsonMapBuilder().addEntry("uuid", uuid).build())
                .asJson();
    }

    /**
     * @apiNote <a href="https://docs.radiobots.eu/#cloud-cloudserver-action-reset">https://docs.radiobots.eu/#cloud-cloudserver-action-reset</a>
     */
    public HttpResponse<JsonNode> resetServer(String uuid) {
        return provider.post("cloud/cloudserver/action/reset")
                .header("Data", new JsonMapBuilder().addEntry("uuid", uuid).build())
                .asJson();
    }

    /**
     * @apiNote <a href="https://docs.radiobots.eu/#cloud-cloudserver-action-reset-root-password">https://docs.radiobots.eu/#cloud-cloudserver-action-reset-root-password</a>
     */
    public HttpResponse<JsonNode> resetServerPassword(String uuid) {
        return provider.post("cloud/cloudserver/action/reset_root_password")
                .header("Data", new JsonMapBuilder().addEntry("uuid", uuid).build())
                .asJson();
    }

    /**
     * @apiNote <a href="https://docs.radiobots.eu/#cloud-cloudserver-action-rescale">https://docs.radiobots.eu/#cloud-cloudserver-action-rescale</a>
     */
    public HttpResponse<JsonNode> rescaleServer(String uuid, int cores, double ram, int disk) {
        return provider.post("cloud/cloudserver/action/rescale")
                .header("Data",
                        new JsonMapBuilder()
                                .addEntry("uuid", uuid)
                                .addEntry("cores", cores)
                                .addEntry("ram", ram)
                                .addEntry("disk", disk)
                                .build())
                .asJson();
    }

    /**
     * @apiNote <a href="https://docs.radiobots.eu/#cloud-cloudserver-action-rebuild">https://docs.radiobots.eu/#cloud-cloudserver-action-rebuild</a>
     */
    public HttpResponse<JsonNode> rebuildServer(String uuid, String image) {
        return provider.post("cloud/cloudserver/action/rebuild")
                .header("Data",
                        new JsonMapBuilder()
                                .addEntry("uuid", uuid)
                                .addEntry("image", image)
                                .build())
                .asJson();
    }
}
