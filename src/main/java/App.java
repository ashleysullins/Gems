import java.util.HashMap;
import spark.ModelAndView;
import spark.template.velocity.VelocityTemplateEngine;
import static spark.Spark.*;
import java.io.Console;

import java.util.List;


public class App {
  public static void main(String[] args) {
    Console myConsole = System.console();
    staticFileLocation("/public");
    String layout = "templates/layout.vtl";

    get("/", (request, response) -> {
      HashMap<String, Object> model = new HashMap<String, Object>();

      model.put("template", "templates/index.vtl");
      return new ModelAndView(model, layout);
    }, new VelocityTemplateEngine());

    get("/gems", (request, response) -> {
      HashMap<String, Object> model = new HashMap<String, Object>();
      // List<Gem> gems = Gem.all();
      // model.put("gems", gems);
      model.put("gems", Gem.all());
      model.put("template", "templates/gems.vtl");
      return new ModelAndView(model, layout);
    }, new VelocityTemplateEngine());


    get("/gem/:id", (request, response) -> {

      HashMap<String, Object> model = new HashMap<String, Object>();
      int gemId = Integer.parseInt(request.params("id"));
      System.out.println(gemId);
      Gem gem = Gem.find(gemId);
      System.out.println(gem);

      model.put("gems", Gem.all());
      model.put("gem", gem);
      model.put("template", "templates/selected-gem.vtl");
      return new ModelAndView(model, layout);
    }, new VelocityTemplateEngine());

    get("/loadpage", (request, response) -> {
      HashMap<String, Object> model = new HashMap<String, Object>();
      //Get the relevant gems from the params, put into model...


      model.put("template", "templates/loadpage.vtl");
      return new ModelAndView(model, layout);
    }, new VelocityTemplateEngine());

    post("/fusion", (request, response) -> {
      HashMap<String, Object> model = new HashMap<String, Object>();

      model.put("template", "templates/fusion.vtl");
      return new ModelAndView(model, layout);
    }, new VelocityTemplateEngine());

  }
}
