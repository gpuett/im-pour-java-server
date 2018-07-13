import com.google.gson.Gson;
import dao.Sql2oBarDao;
import exceptions.ApiException;
import filters.CorsFilter;
import models.Bar;
import org.sql2o.Connection;
import org.sql2o.Sql2o;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import static spark.Spark.*;

public class App {
    private static boolean isProduction = false;

    static int getHerokuAssignedPort() {
        ProcessBuilder processBuilder = new ProcessBuilder();
        if (processBuilder.environment().get("PORT") != null) {
            isProduction = true;
            return Integer.parseInt(processBuilder.environment().get("PORT"));
        }
        return 4567;
    }

    public static void main(String[] args) {
        port(getHerokuAssignedPort());
        staticFileLocation("/public");
        Sql2oBarDao barDao;
        Connection conn;
        Gson gson = new Gson();
        CorsFilter.apply();
        Sql2o sql2o;
        if(isProduction) {
            String connectionString = ""; //Heroku credentials
            sql2o = new Sql2o(connectionString, "", "");
        } else {
            String connectionString = "jdbc:postgresql://localhost:5432/pour_bars";
            sql2o = new Sql2o(connectionString, null, null);
        }
        barDao = new Sql2oBarDao(sql2o);
        conn = sql2o.open();


        post("/bars/new", "application/json", (request, response) -> {
           Bar bar = gson.fromJson(request.body(), Bar.class);
           barDao.add(bar);
           response.status(201);
           return gson.toJson(bar);
        });

        get("/bars", "application/json", (request, response) -> {
           System.out.println(barDao.getAll());
           List<Bar> allBars = barDao.getAll();
           if(allBars.size() > 0) {
               return gson.toJson(allBars);
           } else {
               return "{\"message\":\"I'm sorry, but no bars are currently listed in the database.\"}";
           }
        });

        //FILTERS
        exception(ApiException.class, (exception, request, response) -> {
            ApiException err = (ApiException) exception;
            Map<String, Object> jsonMap = new HashMap<>();
            jsonMap.put("status", err.getStatusCode());
            jsonMap.put("errorMessage", err.getMessage());
            response.type("application/json");
            response.status(err.getStatusCode());
            response.body(gson.toJson(jsonMap));
        });

        before((request, response) -> response.header("Access-Control-Allow-Origin", "*"));


        after((request, response) -> {
            response.type("application/json");
        });
    }
}
