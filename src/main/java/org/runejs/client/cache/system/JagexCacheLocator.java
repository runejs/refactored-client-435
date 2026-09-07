package org.runejs.client.cache.system;

import org.runejs.Configuration;

import java.io.File;

public class JagexCacheLocator implements CacheLocator{
    @Override
    public String getCachePath(String homeDirectory) throws RuntimeException {
        File configuredCache = new File(Configuration.CACHE_NAME);
        if (configuredCache.isAbsolute()) {
            if (configuredCache.isDirectory() || configuredCache.mkdirs()) {
                return configuredCache.getPath() + "/";
            }
            throw new RuntimeException("Unable to create cache directory " + configuredCache);
        }

        if (homeDirectory == null) {
            homeDirectory = "~/";
        }

        String[] cacheLocations = {
                "c:/rsrcache/",
                "/rsrcache/",
                "c:/windows/",
                "c:/winnt/",
                "d:/windows/",
                "d:/winnt/",
                "e:/windows/",
                "e:/winnt/",
                "f:/windows/",
                "f:/winnt/",
                "c:/",
                homeDirectory,
                "/tmp/",
                ""
        };

        for (String cacheLocation : cacheLocations) {
            try {
                if (cacheLocation.length() > 0) {
                    File file = new File(cacheLocation);
                    if (!file.exists()) {
                        continue;
                    }
                }
                File file = new File(cacheLocation + Configuration.CACHE_NAME);
                if (file.exists() || file.mkdir()) {
                    return file.getPath() + "/";
                }
            } catch (Exception exception) { }
        }
        throw new RuntimeException();
    }
}
