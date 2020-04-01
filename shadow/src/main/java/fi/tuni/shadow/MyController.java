package fi.tuni.shadow;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Random;

// This class acts as a controller.
// Usually when using @Controller, you will use also @RequestMapping
@Controller
public class MyController {
    private List<String> names = new ArrayList<>();
    private List<Integer> imges = new ArrayList<>();
    // When HTTP GET, POST, PUT or OTHER request happens
    // to http://localhost:8080/greeting
    // invoke this method
    @RequestMapping("/hello")
    public String greeting(Model model){
        model.addAttribute("name", "Jack");
        return "view";
    }
    @RequestMapping("/form")
    public String forming(Model model, @RequestParam Optional<String> nameT){
        System.out.println(nameT);
        if(nameT.isPresent()) {
            String name = nameT.get();
            if (name.length() >= 3) {
                model.addAttribute("status", "Success");
                names.add(name);
            } else {
                model.addAttribute("status", "Fail");
            }
            model.addAttribute("names", names);
        }

        return "form";
    }
    @RequestMapping("/save-to-db")
    public String saveToDb(Model model, @RequestParam String name){
        if(!name.isEmpty() && name.length() >= 3){
            model.addAttribute("status", "Success");
            names.add(name);
        }else{
            model.addAttribute("status", "Fail");
        }
        model.addAttribute("names",names);
        return "save-to-db";
    }
    @RequestMapping("/slot")
    public String slotM(HttpSession httpSession){
        System.out.println(httpSession);
        if(httpSession.isNew()){
            httpSession.setAttribute("money", 10);
        }else{
            if(httpSession.getAttribute("money").equals(0)){
                httpSession.setAttribute("money", 10);
            }
            imges.clear();
            for(int i = 0; i < 3; i++){
                int ran = new Random().nextInt(3) + 1;
                System.out.println(ran);
                imges.add(ran);
            }
        }
        httpSession.setAttribute("imges", imges);
        return "slot";
    }
    //org.apache.catalina.session.StandardSessionFacade@28092e97
    //org.apache.catalina.session.StandardSessionFacade@4f3e7cf2

}
