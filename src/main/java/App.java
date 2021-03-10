import com.google.gson.Gson;
import dao.*;
import exceptions.ApiException;
import models.Department;
import models.User;
import org.sql2o.Connection;
import org.sql2o.Sql2o;

import java.util.HashMap;
import java.util.Map;

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


        get("/users", "application/json", (req, res) -> { //accept a request in format JSON from an app
            User user = gson.fromJson(req.body(),User.class);
            UserDao.add(user);
            res.status(201);
            return gson.toJson(UserDao.getAll());//send it back to be displayed
        });

        exception(ApiException.class, (exception, request, response) -> {
            ApiException err = exception;
            Map<String, Object> jsonMap = new HashMap<>();
            jsonMap.put("status", err.getStatusCode());
            jsonMap.put("errorMessage", err.getMessage());
            response.type("application/json");
            response.status(err.getStatusCode());
            response.body(gson.toJson(jsonMap));
        });
        after((request, response) ->{
            response.type("application/json");
        });

        get("/department","application/json" ,(req, res) -> {
        Department department = gson.fromJson(req.body(),Department.class);
        DepartmentDao.add(department);
        res.status(201);
        return gson.toJson(DepartmentDao.getAll());
        });

        post("/department/new","application/json", (req, res) -> {
            Department department = gson.fromJson(req.body(),Department.class);
            DepartmentDao.add(department);
            res.status(201);
            return gson.toJson(department);
        });
    }
}