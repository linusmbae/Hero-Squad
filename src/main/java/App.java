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

//        display hero details
        get("/",(request, response) ->
        {
            Map<String, Object>model=new HashMap<String, Object>();
            ArrayList<Hero>heroes=Hero.getAll();
            model.put("heroes",heroes);
            return new ModelAndView(model,"index.hbs");
        },new HandlebarsTemplateEngine());

//        display new hero form
        get("/heroes/new",(request, response) ->
        {
            Map<String, Object>model=new HashMap<String, Object>();
            return new ModelAndView(model,"new-heroes-form.hbs");
        }, new HandlebarsTemplateEngine());

//        create new hero
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

//        view hero details by id
        get("/heroes/:id", (request, response) ->
        {
            Map<String, Object>model=new HashMap<String, Object>();
            int idToFind=Integer.parseInt(request.params(":id"));
            Hero foundHero=Hero.findById(idToFind);
            model.put("hero",foundHero);
            return  new ModelAndView(model, "hero-details.hbs");
        }, new HandlebarsTemplateEngine());

//        update hero form
        get("/heroes/:id/update", (request, response) ->
        {
            Map<String, Object>model=new HashMap<String, Object>();
            int idOfHeroToUpdate=Integer.parseInt(request.params(":id"));
            Hero editHero= Hero.findById(idOfHeroToUpdate);
            model.put("editHero", editHero);
            return new ModelAndView(model, "edit-hero.hbs");
        }, new HandlebarsTemplateEngine());

//        post new hero details
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

//        remove post by id
        get("/heroes/:id/delete", (request, response) ->
        {
            Map<String , Object>model=new HashMap<String, Object>();
            int idOfHeroToRemove=Integer.parseInt(request.params(":id"));
            Hero removeHeroById=Hero.findById(idOfHeroToRemove);
            removeHeroById.deleteHero();
            response.redirect("/");
            return null;
        }, new HandlebarsTemplateEngine());



//        squad starts
//        get squad details
        get("/",(request, response) ->
        {
            Map<String, Object>model=new HashMap<String, Object>();
            ArrayList<Squad>squads=Squad.getAll();
            model.put("squads",squads);
            return new ModelAndView(model,"index.hbs");
        },new HandlebarsTemplateEngine());

//        view new squad form
        get("/squad/new",(request, response) ->
        {
            Map<String, Object>model=new HashMap<String, Object>();
            return new ModelAndView(model, "new-squad-form.hbs");
        },new HandlebarsTemplateEngine());

//        create new squad
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

//        view squad by id
        get("/squads/:id", (request, response) ->
        {
            Map<String, Object>model=new HashMap<String, Object>();
            int idToFind=Integer.parseInt(request.params(":id"));
            Squad foundSquad=Squad.findById(idToFind);
            model.put("squad", foundSquad);
            return new ModelAndView(model, "squad-details.hbs");
        }, new HandlebarsTemplateEngine());

        //        update squad form
        get("/squads/:id/update", (request, response) ->
        {
            Map<String, Object>model=new HashMap<String, Object>();
            int idOfSquadToUpdate=Integer.parseInt(request.params(":id"));
            Squad editSquad= Squad.findById(idOfSquadToUpdate);
            model.put("editSquad", editSquad);
            return new ModelAndView(model, "edit-squad.hbs");
        }, new HandlebarsTemplateEngine());
    }
}
