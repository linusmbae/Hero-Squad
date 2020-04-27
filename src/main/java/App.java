import javafx.geometry.Pos;
import models.Hero;
import models.Squad;
import spark.ModelAndView;
import spark.template.handlebars.HandlebarsTemplateEngine;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import static spark.Spark.*;
public class App {
    public static void main(String[] args) {
        staticFileLocation("/public");

        get("/",(request, response) ->
        {
            Map<String, Object>model=new HashMap<String, Object>();
            ArrayList<Hero>heroes=Hero.getAll();
            model.put("heroes",heroes);
            return new ModelAndView(model,"index.hbs");
        },new HandlebarsTemplateEngine());

        get("/heroes/new",(request, response) ->
        {
            Map<String, Object>model=new HashMap<String, Object>();
            return new ModelAndView(model,"new-heroes-form.hbs");
        }, new HandlebarsTemplateEngine());

//        post("/heroes/new",(request, response) ->
//        {
//            Map<String, Object>model = new HashMap<String, Object>();
//            String name=request.queryParams("name");
//            int age = Integer.parseInt(request.queryParams("age"));
//            String specialPowers=request.queryParams("specialPowers");
//            String weakness = request.queryParams("weakness");
//            int id =Integer.parseInt(request.queryParams("id"));
//            Hero newHero=new Hero(name,age,specialPowers,weakness,id);
//            model.put("hero",newHero);
//            response.redirect("/");
//        }, new HandlebarsTemplateEngine());

        get("/squad/new",(request, response) ->
        {
            Map<String, Object>model=new HashMap<String, Object>();
            return new ModelAndView(model, "new-squad-form.hbs");
        },new HandlebarsTemplateEngine());
//        post("/squad/new", (request, response) ->
//        {
//            Map<String, Object>model=new HashMap<String, Object>();
//            String name= request.queryParams("name");
//            String cause=request.queryParams("cause");
//            int id = Integer.parseInt(request.queryParams("id"));
//            Squad newSquad=new Squad(id,name,cause);
//            model.put("squad",newSquad);
//            response.redirect("/");
//        },new HandlebarsTemplateEngine());


    }
}
