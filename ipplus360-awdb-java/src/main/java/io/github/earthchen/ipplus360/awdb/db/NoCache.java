package io.github.earthchen.ipplus360.awdb.db;

import com.fasterxml.jackson.databind.JsonNode;

import java.io.IOException;

/**
 * A no-op cache singleton.
 */
public class NoCache implements NodeCache {

    private static final NoCache INSTANCE = new NoCache();

    private NoCache() {
    }

    @Override
    public JsonNode get(int key, Loader loader) throws IOException {
        return loader.load(key);
    }

    public static NoCache getInstance() {
        return INSTANCE;
    }

}
