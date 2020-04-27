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

        post("/heroes/new",(request, response) ->
        {
            Map<String, Object>model = new HashMap<String, Object>();

            String name=request.queryParams("name");
            int age = Integer.parseInt(request.queryParams("age"));
            String specialPowers=request.queryParams("specialPowers");
            String weakness = request.queryParams("weakness");
            Hero newHero=new Hero(name,age,specialPowers,weakness);
            model.put("hero",newHero);
            response.redirect("/");
            return null;
        }, new HandlebarsTemplateEngine());

        get("/squad/new",(request, response) ->
        {
            Map<String, Object>model=new HashMap<String, Object>();
            return new ModelAndView(model, "new-squad-form.hbs");
        },new HandlebarsTemplateEngine());
        post("/squad/new", (request, response) ->
        {
            Map<String, Object>model=new HashMap<String, Object>();


            String name= request.queryParams("name");
            String cause=request.queryParams("cause");
            Squad newSquad=new Squad(name,cause);
            model.put("squad",newSquad);
            response.redirect("/");
            return null;
        },new HandlebarsTemplateEngine());
        get("/heroes/:id", (request, response) ->
        {
            Map<String, Object>model=new HashMap<String, Object>();
            int idToFind=Integer.parseInt(request.params(":id"));
            Hero foundHero=Hero.findById(idToFind);
            model.put("hero",foundHero);
            return  new ModelAndView(model, "hero-details.hbs");
        }, new HandlebarsTemplateEngine());
        get("/squads/:id", (request, response) ->
        {
            Map<String, Object>model=new HashMap<String, Object>();
            int idToFind=Integer.parseInt(request.params(":id"));
            Squad foundSquad=Squad.findById(idToFind);
            model.put("squad", foundSquad);
            return new ModelAndView(model, "squad-details.hbs");
        }, new HandlebarsTemplateEngine());
        get("/heroes/:id/update", (request, response) ->
        {
            Map<String, Object>model=new HashMap<String, Object>();
            int idOfHeroToUpdate=Integer.parseInt(request.params(":id"));
            Hero editHero= Hero.findById(idOfHeroToUpdate);
            model.put("editHero", editHero);
            return new ModelAndView(model, "edit-hero.hbs");
        }, new HandlebarsTemplateEngine());

        post("/heroes/:id/update", (request, response) ->
        {
            Map<String, Object>model=new HashMap<String, Object>();
            String newName=request.queryParams("name");
            int newAge = Integer.parseInt(request.queryParams("age"));
            String newSpecialPowers=request.queryParams("specialPowers");
            String newWeakness = request.queryParams("weakness");
            int idOfHeroToUpdate=Integer.parseInt(request.params(":id"));
            Hero editHero= Hero.findById(idOfHeroToUpdate);
            editHero.update(newName,newAge,newSpecialPowers,newWeakness);
            return new ModelAndView(model, "hero-details.hbs");
        }, new HandlebarsTemplateEngine());
    }
}
