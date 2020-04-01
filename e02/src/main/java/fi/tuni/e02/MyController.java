package fi.tuni.e02;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
// This class acts as a controller.
// Usually when using @Controller, you will use also @RequestMapping
@Controller
public class MyController {
    @Autowired
    HtmlHelper helper;
    @Autowired
    ApplicationContext applicationContext;
    private String[] names;

    // When HTTP GET, POST, PUT or OTHER request happens
    // to http://localhost:8080/greeting
    // invoke this method
    @RequestMapping("/greeting")
    // The return value will be the HTTP Body
    @ResponseBody
    public String greeting(){
        names = applicationContext.getBeanDefinitionNames();

        for (int i = 0; i < names.length; i++){
            System.out.println(names[i]);
        }
        System.out.println(applicationContext.getBeanDefinitionCount());
        String [][] test = new String[2][2];
        test[0][0] = "a";
        test[0][1] = "b";
        test[1][0] = "c";
        test[1][1] = "d";
        return helper.createHtmlPage("BEANS", helper.createHtmlTable(getAllBeans()));
    }
    private String[][] getAllBeans(){
        String[][] tmp = new String[applicationContext.getBeanDefinitionCount()][2];
        for(int i = 0;i < tmp.length;i++){
            tmp[i][0] = names[i];
            tmp[i][1] = applicationContext.getBean(names[i]).getClass().toString();
        }
        return tmp;
    }
}
