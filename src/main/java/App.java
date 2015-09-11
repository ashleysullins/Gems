import java.util.HashMap;
import spark.ModelAndView;
import spark.template.velocity.VelocityTemplateEngine;
import static spark.Spark.*;
import java.io.Console;
import java.util.ArrayList;

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
      // System.out.println(gemId);
      Gem firstGem = Gem.find(gemId);
      ArrayList<Gem> gems = firstGem.getCombos();

      model.put("firstGem", firstGem);
       model.put("gems", gems);
      //model.put("gemId", gemId);
      model.put("template", "templates/selected-gem.vtl");
      return new ModelAndView(model, layout);
    }, new VelocityTemplateEngine());

    get("/video", (request, response) -> {
      HashMap<String, Object> model = new HashMap<String, Object>();

      model.put("template", "templates/video.vtl");
      return new ModelAndView(model, layout);
    }, new VelocityTemplateEngine());

    post("/fusion", (request, response) -> {
      HashMap<String, Object> model = new HashMap<String, Object>();

      int gemIdOne = Integer.parseInt(request.queryParams("fusionChoice1"));
      Gem firstGem = Gem.find(gemIdOne);
      model.put("gemOne", firstGem);
      System.out.println(gemIdOne);

      int gemIdTwo = Integer.parseInt(request.queryParams("fusionChoice2"));
      Gem secondGem = Gem.find(gemIdTwo);
      model.put("gemTwo", secondGem);
      System.out.println(gemIdTwo);

      Combo comboObject = new Combo(gemIdOne, gemIdTwo);
      int fusionId = comboObject.getFusionId();

      Fusion fusion = Fusion.find(fusionId);
      model.put("fusion", fusion);
      System.out.println(fusionId);

      model.put("template", "templates/fusion.vtl");
      return new ModelAndView(model, layout);
    }, new VelocityTemplateEngine());

  }
}
