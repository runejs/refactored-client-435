package org.runejs.client.cache.system;

public interface CacheLocator {
    String getCachePath(String homeDirectory) throws RuntimeException;
}
