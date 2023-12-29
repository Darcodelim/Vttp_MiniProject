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
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import jakarta.servlet.http.HttpSession;
import jakarta.validation.Valid;
import vttp.miniProject.Model.Beer;
import vttp.miniProject.Model.BeerRepo;
import vttp.miniProject.Model.BeerSearchForm;
import vttp.miniProject.Service.BeerRepoService;
import vttp.miniProject.Service.BeerService;

@Controller
@RequestMapping
public class BeerController {

    @Autowired
    BeerService beerSvc;

    @Autowired
    BeerRepoService beerRepoService;

   // GET / /index.html
   @GetMapping("/")
   public String getMain(@RequestParam MultiValueMap<String,String> param, Model model, HttpSession sess)
   {  
      String username = param.getFirst("username");
      List<BeerRepo> beerListRepo = beerRepoService.getList(username);

      sess.setAttribute("beerListRepo", beerListRepo);

      model.addAttribute("beerListRepo", beerListRepo);
      
      
      return "Main";
   }
   
   @GetMapping(path={"/Home"})
   public String getHome(Model model) {

      List<Beer> beerList = beerSvc.getBeer("1", "3", null, null, null, null, null, null,null);
      model.addAttribute("beerList", beerList);
      return "Home";
   }

   @GetMapping(path={"/To-do-list"})
   public String getToDoList(Model model,HttpSession sess)
   {
      List<BeerRepo> beerListRepo = (List<BeerRepo>)sess.getAttribute("beerListRepo");
      String ids = "";
      ids = beerListRepo.stream().map(i->i.getId()).collect(Collectors.joining("|"));
      List<Beer> beerList = beerSvc.getBeer(null, null, null, null, null, null, null, null, ids);
      model.addAttribute("beerList", beerList);
      return "ToDoList";

   }

   @GetMapping(path={"/Beer"})
   public String getBeer(@RequestParam MultiValueMap<String,String> params, Model model) {
      String id = params.getFirst("id");
      List<Beer> beerList = beerSvc.getBeer(null, null, null, null, null, null, null, null,id);
      Beer beer = beerList.get(0);
      model.addAttribute("Beer", beer);
      return "Beer";
   }

   @GetMapping("/advanceSearch")
   public String goAdvanceSearch(Model model)
   {  
      BeerSearchForm form =new BeerSearchForm("","0.5","55","1","250");

      model.addAttribute("beerSearchForm", form);

      return "advanceSearch";
   }


   @PostMapping("/advanceSearch/search")
   public String goAdvanceSearchResult(@Valid @ModelAttribute("beerSearchForm") BeerSearchForm beerSearchForm,BindingResult bindings, Model model,  @RequestBody MultiValueMap<String,String> form )
    {  
      
      // if(Double.parseDouble(beerSearchForm.getABVmin()) < 0.5)
      // {
      //    FieldError error = new FieldError("beerSearchForm","ABVmin","The minimum ABV is 0.5%");
      //    bindings.addError(error);
      //    return"advanceSearch";
      // }
      
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
      
      String AbvMin = form.getFirst("ABVmin");
      String AbvMax = form.getFirst("ABVmax");
      String IbuMin = form.getFirst("IBUmin");
      String IbuMax = form.getFirst("IBUmax");

      System.out.printf("\nFood:%s\nAbvMin:%s\nAbvMax:%s\nIbuMin:%s\nIbuMax:%s\n",food,AbvMin,AbvMax,IbuMin,IbuMax);
      
      List<Beer> beerSearchList = beerSvc.getBeer("1", "80", AbvMin, AbvMax, IbuMin, IbuMax, food, null, null);
      model.addAttribute("beerSearchForm", beerSearchForm);
      model.addAttribute("beerSearchList", beerSearchList);
      
       if (bindings.hasErrors()) {
         bindings.getAllErrors().stream().forEach(f->System.out.println("\nERRORS:\n" +f.getCode() +": " + f.getDefaultMessage()));
         return "advanceSearch";
      }

      return "BeerSearch";
   }

}
