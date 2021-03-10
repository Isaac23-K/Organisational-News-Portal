import com.google.gson.Gson;
import dao.*;
import models.User;
import org.sql2o.Connection;
import org.sql2o.Sql2o;

import static spark.Spark.*;

public class App {

//    static int getHerokuAssignedPort() {
//        ProcessBuilder processBuilder = new ProcessBuilder();
//        if (processBuilder.environment().get("PORT") != null) {
//            return Integer.parseInt(processBuilder.environment().get("PORT"));
//        }
//        return 4567; //return default port if heroku-port isn't set (i.e. on localhost)
//    }
    public static void main(String[] args) {
        Sql2oNewsDao NewsDao;
        Sql2oUserDao UserDao;
        Sql2oDepartmentsDao DepartmentDao;
        Connection conn;
        Gson gson = new Gson();

       // port(getHerokuAssignedPort());
        staticFileLocation("/public");


        String connectionString = "jdbc:postgresql://localhost:5432/company_news_test";
        Sql2o sql2o = new Sql2o(connectionString, "isaac", "kaptoge");
        DepartmentDao = new Sql2oDepartmentsDao(sql2o);
        UserDao = new Sql2oUserDao(sql2o);
        NewsDao = new Sql2oNewsDao(sql2o);
        conn = sql2o.open();

        post("/users/new", "application/json", (req, res) -> {
            User user = gson.fromJson(req.body(), User.class);
            UserDao.add(user);
            res.status(201);
            return gson.toJson(user);
        });


        get("/department", "application/json", (req, res) -> { //accept a request in format JSON from an app
            res.type("application/json");
            return gson.toJson(DepartmentDao.getAll());//send it back to be displayed
        });


    }
}