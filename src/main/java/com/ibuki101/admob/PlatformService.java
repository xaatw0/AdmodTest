package com.ibuki101.admob;

import static java.lang.String.*;

import java.util.Iterator;
import java.util.ServiceLoader;

public class PlatformService {

    private static PlatformService instance = new PlatformService();
    public static PlatformService getInstance() {
        return instance;
    }

    private final ServiceLoader<IPlatformProvider> serviceLoader;
    private IPlatformProvider provider;

    private PlatformService() {
        serviceLoader = ServiceLoader.load(IPlatformProvider.class);
        Iterator<IPlatformProvider> iterator = serviceLoader.iterator();
        while (iterator.hasNext()) {
        	provider = iterator.next();
        }

        if (provider == null) {
        	System.out.println("No PlatformProvider implementation could be found!");
        } else {
        	System.out.println(format("Using PlatformProvider: %s", provider.getClass().getName()));
        }
    }

    public IPlatformProvider getProvider() {
    	return provider == null ? null : provider;
    }
}
