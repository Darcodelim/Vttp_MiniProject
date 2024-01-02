package vttp.miniProject.Controller;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatusCode;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.MultiValueMap;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;


import jakarta.servlet.http.HttpSession;
import jakarta.validation.Valid;
import vttp.miniProject.Model.Beer;
import vttp.miniProject.Model.BeerRepo;
import vttp.miniProject.Model.BeerSearchForm;
import vttp.miniProject.Model.User;
import vttp.miniProject.Repository.userBeerRepo;
import vttp.miniProject.Service.BeerRepoService;
import vttp.miniProject.Service.BeerService;
import vttp.miniProject.Utils.listUtils;

@Controller
@RequestMapping
public class BeerController {

    @Autowired
    BeerService beerSvc;

    @Autowired
    BeerRepoService beerRepoService;

    @Autowired
    userBeerRepo userBeerRepo;

    @Autowired
    listUtils listUtils;

   
   @GetMapping("/")
   public String getMain(Model model)
   {  


      return "Main";
   }
   
      @PostMapping(path={"/Home"})
      public String getHome(@RequestBody MultiValueMap<String,String> body,Model model,HttpSession sess) {
      // String username = param
      // System.out.println(username);

      String username = body.getFirst("username");
      System.out.println(username);


      sess.setAttribute("username", username);
      
      //This is from the posting /Beer back to Home, if beer is access from the Home page
      String id = body.getFirst("id");
      String name = body.getFirst("beerName");
      BeerRepo beerRepo = new BeerRepo(id, name);
      
      List<BeerRepo> beerListRepo = beerRepoService.getList(username);
      // List<BeerRepo> beerListRepo = listUtils.getList(sess);
      beerListRepo.add(beerRepo);

      beerRepoService.save(username, beerListRepo);

      List<Beer> beerList = beerSvc.getBeer("1", "80", null, null, null, null, null, null,null);
      model.addAttribute("beerList", beerList);
      model.addAttribute("username1", username);
      return "Home";

   }
      @GetMapping(path={"/Home/p2"})
      public String getHomeP2(Model model,HttpSession sess) {

      //Prevent direct access using URL if it's not login
      String username = (String)sess.getAttribute("username");
      if(username.isEmpty())
      {
         return "error";
      }
      System.out.println(username);
      
      //This is for the posting /Beer back to Home, if beer is access from the Home page
      List<Beer> beerList = beerSvc.getBeer("2", "80", null, null, null, null, null, null,null);
      model.addAttribute("beerList", beerList);
      model.addAttribute("username1", username);
      return "Home2";
   }

      @GetMapping(path={"/Home/p3"})
      public String getHomeP3(Model model,HttpSession sess) {
      // String username = param
      // System.out.println(username);
      
      String username = (String)sess.getAttribute("username");
      if(username.isEmpty())
      {
         return "error";
      }
      System.out.println(username);
      
      //This is from the posting /Beer back to Home, if beer is access from the Home page


      List<Beer> beerList = beerSvc.getBeer("3", "80", null, null, null, null, null, null,null);
      model.addAttribute("beerList", beerList);
      model.addAttribute("username1", username);
      return "Home3";
   }

      @GetMapping(path={"/Home/p4"})
      public String getHomeP4(Model model,HttpSession sess) {
      // String username = param
      // System.out.println(username);
      
      String username = (String)sess.getAttribute("username");
      if(username.isEmpty())
      {
         return "error";
      }
      System.out.println(username);
      
      //This is from the posting /Beer back to Home, if beer is access from the Home page


      List<Beer> beerList = beerSvc.getBeer("4", "80", null, null, null, null, null, null,null);
      model.addAttribute("beerList", beerList);
      model.addAttribute("username1", username);
      return "Home4";
   }

      @GetMapping(path={"/Home/p5"})
      public String getHomeP5(Model model,HttpSession sess) {
      // String username = param
      // System.out.println(username);
      
      String username = (String)sess.getAttribute("username");
      if(username.isEmpty())
      {
         return "error";
      }
      System.out.println(username);
      
      //This is from the posting /Beer back to Home, if beer is access from the Home page


      List<Beer> beerList = beerSvc.getBeer("5", "80", null, null, null, null, null, null,null);
      model.addAttribute("beerList", beerList);
      model.addAttribute("username1", username);
      return "Home5";
   }



   @PostMapping(path={"/To_do_list"})
   public String getToDoList(@RequestBody MultiValueMap<String,String> body,Model model,HttpSession sess)
   {  
      String username = body.getFirst("username");
      System.out.println(username);

      // String id = body.getFirst("id");
      // String name = body.getFirst("beerName");
      // BeerRepo beerRepo = new BeerRepo(id, name);
      
      List<BeerRepo> beerListRepo = beerRepoService.getList(username);
      // List<BeerRepo> beerListRepo = listUtils.getList(sess);
      // beerListRepo.add(beerRepo);

      // beerRepoService.save(username, beerListRepo);

      
      String ids = "";
      ids = beerListRepo.stream().map(i->i.getId()).collect(Collectors.joining("|"));
      List<Beer> beerList = beerSvc.getBeer(null, null, null, null, null, null, null, null, ids);
      model.addAttribute("beerList", beerList);

      model.addAttribute("username1",username);



      return "ToDoList";

   }

   @PostMapping(path={"/deleteBeer"})
   public String deleteBeer(@RequestBody MultiValueMap<String,String> body,Model model, HttpSession sess)
   {  
      String username = body.getFirst("username");
      System.out.println(username);

      String id = body.getFirst("id");
      String name = body.getFirst("beerName");
      // BeerRepo beerRepo = new BeerRepo(id, name);
      // System.out.printf("id:%s,name:%s",id,name);

      beerRepoService.delete(name, id,name); //This function is not WORKING
      model.addAttribute("username1",username);
      return "forward:/Home";

   }

   // @PostMapping(path={"/To_do_list_update"})
   // public String postToDoList(@ModelAttribute("Beer") Beer beers,Model model,HttpSession sess, @RequestBody MultiValueMap<String,String> beerRepoForm)
   // {
   //    //When posting, Id and the name of the beer would be added to the BeerRepo List

      
   //    //Have to check whether it require another Session setAttribute to update the page
   //    String ids = "";
   //    ids = beerListRepo.stream().map(i->i.getId()).collect(Collectors.joining("|"));
   //    List<Beer> beerList = beerSvc.getBeer(null, null, null, null, null, null, null, null, ids);
   //    model.addAttribute("beerList", beerList);

      

   //    return "ToDoList";

   // }

   @PostMapping(path={"/Beer"})
   public String getBeer(@RequestBody MultiValueMap<String,String> body, Model model) {
      String username = body.getFirst("username");
      String id = body.getFirst("id");
      String todo = body.getFirst("todo");//Check whether the response is from to do list
      String food = body.getFirst("food");
      String ABVmin =body.getFirst("ABVmin");
      String ABVmax =body.getFirst("ABVmax");
      String IBUmin =body.getFirst("IBUmin");
      String IBUmax =body.getFirst("IBUmax");

      List<Beer> beerList = beerSvc.getBeer(null, null, null, null, null, null, null, null,id);
      Beer beer = beerList.get(0);
      
      System.out.printf("todo:%s",todo);

      model.addAttribute("food",food);
      model.addAttribute("ABVmin",ABVmin);
      model.addAttribute("ABVmax",ABVmax);
      model.addAttribute("IBUmin",IBUmin);
      model.addAttribute("IBUmax",IBUmax);
      model.addAttribute("Beer", beer);
      model.addAttribute("username1", username);
      model.addAttribute("beerList", beerList);
      model.addAttribute("todo", todo);
      return "Beer";
   }

   @GetMapping("/advanceSearch")
   public String goAdvanceSearch(Model model,HttpSession sess)
   {  
      // String username = body.getFirst("username");
      String username = (String)sess.getAttribute("username");
      if(username.isEmpty())
      {
         return "error";
      }
      else{
      BeerSearchForm form =new BeerSearchForm("","0.5","55","1","250");

      model.addAttribute("beerSearchForm", form);
      model.addAttribute("username1", username);

      return "advanceSearch";
      }
   }


   @PostMapping("/advanceSearch/search")
   public String goAdvanceSearchResult(@Valid @ModelAttribute("beerSearchForm") BeerSearchForm beerSearchForm,BindingResult bindings, Model model,  @RequestBody MultiValueMap<String,String> form )
    {
      // Need to replace spaces to underscore for food before sending to the API
      String food = form.getFirst("food");
      if(food.isBlank())
      {
         food=null;
      }
      else
      {
         food = food.replaceAll(" ", "_");
      }
      String username = form.getFirst("username");
      String ABVmin = form.getFirst("ABVmin");
      String AbvMax = form.getFirst("ABVmax");
      String IbuMin = form.getFirst("IBUmin");
      String IbuMax = form.getFirst("IBUmax");

      System.out.println(username);

      String id = form.getFirst("id");
      String name = form.getFirst("beerName");
      BeerRepo beerRepo = new BeerRepo(id, name);
      
      List<BeerRepo> beerListRepo = beerRepoService.getList(username);
      // List<BeerRepo> beerListRepo = listUtils.getList(sess);
      beerListRepo.add(beerRepo);
      beerRepoService.save(username, beerListRepo);
      
      /*
       Model must be added before searching for the beer to allow for validation to occur
       */
      model.addAttribute("beerSearchForm", beerSearchForm); //
      model.addAttribute("username1", username);

      if (bindings.hasErrors()) {
         bindings.getAllErrors().stream().forEach(f->System.out.println("\nERRORS:\n" +f.getCode() +": " + f.getDefaultMessage()));
         return "advanceSearch";
      }


      System.out.printf("\nFood:%s\nAbvMin:%s\nAbvMax:%s\nIbuMin:%s\nIbuMax:%s\n",food,ABVmin,AbvMax,IbuMin,IbuMax);
      
      List<Beer> beerSearchList = beerSvc.getBeer("1", "80", ABVmin, AbvMax, IbuMin, IbuMax, food, null, null);
      model.addAttribute("beerList", beerSearchList);

      
      return "BeerSearch";
   }

   @GetMapping("/search/{food1}")
   public String food(@PathVariable(name="food1",required = true) String food1,Model model)
   {  
      food1 = food1.replaceAll(" ", "_");
      String username1 = "";
      System.out.println(food1);
      List<Beer> beerSearchList = beerSvc.getBeer("1", "80", null, null, null, null, food1, null, null);
      model.addAttribute("beerList",beerSearchList);
      model.addAttribute("username1", username1);
      return "Home";
   }

   @GetMapping("/Random")
   public String randomBeer(HttpSession sess, Model model)
   {  String todo ="Yes";
      String username = (String)sess.getAttribute("username");
      if(username.isEmpty())
      {
         return "error";
      }
      else{
     Beer randomBeer = beerSvc.randomBeer();
      System.out.println(username);
     model.addAttribute("Beer", randomBeer);
     model.addAttribute("username1", username);
     model.addAttribute("todo",todo);
     return "Beer";

      }

   }

   @GetMapping("/logout")
   public String logout(HttpSession sess,Model model)
   { 
      sess.invalidate();
      
      return"Main";

   }
   

}
