package org.example.app.bean;

import javax.ejb.Stateless;
import javax.inject.Named;
import java.util.Map;

@Stateless
@Named
public class Bean {
    /**
     * Get system variables
     *
     * @return
     */
    public Map<String, String> getEnv() {
        return System.getenv();
    }
}
