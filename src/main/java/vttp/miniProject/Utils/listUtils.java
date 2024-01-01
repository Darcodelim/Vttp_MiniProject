package vttp.miniProject.Utils;

import java.util.LinkedList;
import java.util.List;

import org.springframework.stereotype.Component;

import jakarta.servlet.http.HttpSession;
import vttp.miniProject.Model.BeerRepo;

@Component
public class listUtils {

    public static List<BeerRepo> getList(HttpSession sess)
    {
     List<BeerRepo> beerListRepo = (List<BeerRepo>)sess.getAttribute("beerListRepo");
      if (null == beerListRepo) {
         beerListRepo = new LinkedList<>();
         sess.setAttribute("beerListRepo", beerListRepo);
      }
      return beerListRepo;
    
    }
}
