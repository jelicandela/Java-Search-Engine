package SearchEngine;

import org.glassfish.jersey.server.ResourceConfig;

public class MyApplication extends ResourceConfig {
    public MyApplication() {
        register(SearchResource.class);
        register(UserResource.class);
        register(AdminResource.class);
    }
}