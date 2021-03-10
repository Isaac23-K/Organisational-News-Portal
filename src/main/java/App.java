import models.Department;
import models.News;
import models.User;
import spark.ModelAndView;
import spark.template.handlebars.HandlebarsTemplateEngine;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static spark.Spark.*;

public class App {

    static int getHerokuAssignedPort() {
        ProcessBuilder processBuilder = new ProcessBuilder();
        if (processBuilder.environment().get("PORT") != null) {
            return Integer.parseInt(processBuilder.environment().get("PORT"));
        }
        return 4567; //return default port if heroku-port isn't set (i.e. on localhost)
    }

    public static void main(String[] args) {

        port(getHerokuAssignedPort());
        staticFileLocation("/public");

        get("/", (request, response) -> {
            Map<String, Object> model = new HashMap<String, Object>();
            return new ModelAndView(model, "homepage.hbs");
        },new HandlebarsTemplateEngine());

        get("/homepage", (request, response) -> {
            Map<String, Object> model = new HashMap<String, Object>();
            return new ModelAndView(model, "departmentform.hbs");
        },new HandlebarsTemplateEngine());

//        get("/departform", (request, response) -> {
//            Map<String, Object> model = new HashMap<String, Object>();
//            return new ModelAndView(model, "departform.hbs");
//        },new HandlebarsTemplateEngine());
//
//        get("/viewdepartments", (request, response) -> {
//            Map<String, Object> model = new HashMap<String, Object>();
//           // model.put("departments", Department.getAll());
//            return new ModelAndView(model, "viewdepartments.hbs");
//        },new HandlebarsTemplateEngine());


    }

}