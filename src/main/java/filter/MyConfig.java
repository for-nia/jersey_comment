package filter;

import api.AuthRequestFilter;
import org.glassfish.jersey.server.ResourceConfig;

/**
 * Created by fornia on 16/10/11.
 */

public class MyConfig extends ResourceConfig {
    public MyConfig(){
        register(AuthRequestFilter.class);
    }
}
