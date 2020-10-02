package org.example.app.service;

import org.example.app.bean.Bean;

import javax.ejb.EJB;
import javax.ws.rs.*;
import javax.ws.rs.core.Application;
import javax.ws.rs.core.MediaType;
import java.util.Map;

/**
 * Реализовать приложение с  REST-сервисом, позволяющим получить значения всех
 * переменных окружения операционной системы, а так же значение какой-либо
 * конкретной переменной по имени. Аналогично REST-сервису сделать JSP или JSF
 * страницу, в которой бы отображалась в табличном виде информация о переменных
 * окружения. Код работы с переменными окружения вынести в отдельный EJB-бин.
 */

@Path("/service")
@ApplicationPath("/app")
public class RestServiceBean extends Application {

    @EJB
    Bean bean;

    @GET
    @Path("/allEnv") //http://localhost:8080/homework_14_rest/app/service/allEnv
    @Produces(MediaType.APPLICATION_JSON)
    public Map<String, String> getAll() {
        return bean.getEnv();
    }

    @GET
    @Path("/{oneEnv}") //http://localhost:8080/homework_14_rest/app/service/JAVA
    @Produces(MediaType.APPLICATION_JSON)
    public String getOne(@PathParam("oneEnv") String name) {
        return bean.getEnv().get(name);
    }
    // for all env in table view:
    //http://localhost:8080/homework_14_rest/table.xhtml
}
