import dao.DepartmentDao;
import models.Department;
import models.News;
import models.User;
import org.sql2o.Sql2o;
import spark.ModelAndView;
import spark.template.handlebars.HandlebarsTemplateEngine;
import com.google.gson.Gson;
import org.sql2o.Connection;

import java.util.HashMap;
import java.util.List;
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
       // port(getHerokuAssignedPort());
        staticFileLocation("/public");


        Connection conn;
        Gson gson = new Gson();
        String connectionString = "jdbc:h2:~/jadle.db;INIT=RUNSCRIPT from 'classpath:db/create.sql'";
        Sql2o sql2o = new Sql2o(connectionString, "isaac", "kaptoge");

        post("/department", "application/json", (req, res) -> {
            Department department = gson.fromJson(req.body(), Department.class);
            DepartmentDao.add(department);
            res.status(201);
            res.type("application/json");
            return gson.toJson(department);
        });


        get("/department", "application/json", (req, res) -> { //accept a request in format JSON from an app
            res.type("application/json");
            return gson.toJson(DepartmentDao.getAll());//send it back to be displayed
        });


    }
}