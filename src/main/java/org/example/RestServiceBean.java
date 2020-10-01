package org.example;

import javax.ejb.Stateless;
import javax.ws.rs.*;
import javax.ws.rs.core.Application;
import javax.ws.rs.core.MediaType;
import java.util.List;
import java.util.Map;

/**
 * Реализовать приложение с  REST-сервисом, позволяющим получить значения всех
 * переменных окружения операционной системы, а так же значение какой-либо
 * конкретной переменной по имени. Аналогично REST-сервису сделать JSP или JSF
 * страницу, в которой бы отображалась в табличном виде информация о переменных
 * окружения. Код работы с переменными окружения вынести в отдельный EJB-бин.
 */

@Path("/myapp")
@ApplicationPath("/rest")
@Stateless
public class RestServiceBean extends Application {

    @GET
    @Path("/allEnv") //http://localhost:8080/STC27-JavaEE-1.0.0/rest/myapp/allEnv
    @Produces(MediaType.APPLICATION_JSON)
    public static Map<String, String> getEnv() {
        return System.getenv();
    }

    @GET
    @Path("/{oneEnv}") //http://localhost:8080/STC27-JavaEE-1.0.0/rest/myapp/JAVA
    @Produces(MediaType.APPLICATION_JSON)
    public String getOne(@PathParam("oneEnv") String var) {
        if (RestServiceBean.getEnv().containsKey(var) || RestServiceBean.getEnv().containsValue(var)) {
            return RestServiceBean.getEnv().get(var);
        }
        return "Param not found";
    }

    public List<String> toList() {
        List<String> list = null;
        for (String string : RestServiceBean.getEnv().keySet()) {
            list.add(string);
            System.out.println(string);
        }
        return list;
    }
}
