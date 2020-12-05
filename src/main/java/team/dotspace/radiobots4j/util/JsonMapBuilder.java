package team.dotspace.radiobots4j.util;

import kong.unirest.JsonObjectMapper;

import java.util.HashMap;
import java.util.Map;

public class JsonMapBuilder {

    private final HashMap<String, Object> map = new HashMap<>();

    public JsonMapBuilder addEntry(String key, Object value) {
        this.map.put(key, value);
        return this;
    }

    public JsonMapBuilder addEntry(Map<String, ?> map) {
        this.map.putAll(map);
        return this;
    }

    public String build() {
        return new JsonObjectMapper().writeValue(map);
    }

}
