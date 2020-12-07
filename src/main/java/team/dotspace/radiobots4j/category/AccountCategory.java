package team.dotspace.radiobots4j.category;

import kong.unirest.HttpResponse;
import kong.unirest.JsonNode;
import team.dotspace.radiobots4j.http.RequestProvider;
import team.dotspace.radiobots4j.util.JsonMapBuilder;

public class AccountCategory {

    private final RequestProvider provider;

    public AccountCategory(RequestProvider provider) {
        this.provider = provider;
    }

    /**
     * @apiNote <a href="https://docs.radiobots.eu/#cloud-sshkeys-create-an-ssh-key">https://docs.radiobots.eu/#cloud-sshkeys-create-an-ssh-key</a>
     */
    public HttpResponse<JsonNode> createSSHKey(String name, String pubkey) {
        return provider.post("cloud/account/sshkey")
                .header("Data", new JsonMapBuilder().addEntry("name", name).addEntry("publickey", pubkey).build())
                .asJson();
    }

    /**
     * @apiNote <a href="https://docs.radiobots.eu/#cloud-sshkeys-get-all-ssh-keys">https://docs.radiobots.eu/#cloud-sshkeys-get-all-ssh-keys</a>
     */
    public HttpResponse<JsonNode> getSSHKeys() {
        return provider.get("cloud/account/sshkey").asJson();
    }

    /**
     * @apiNote <a href="https://docs.radiobots.eu/#cloud-sshkeys-delete-an-ssh-key">https://docs.radiobots.eu/#cloud-sshkeys-delete-an-ssh-key</a>
     */
    public HttpResponse<JsonNode> deleteSSHKey(String uuid) {
        return provider.delete("cloud/account/sshkey")
                .header("Data", new JsonMapBuilder().addEntry("uuid", uuid).build())
                .asJson();
    }
}
