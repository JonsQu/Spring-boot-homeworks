package fi.tuni.e02;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;


class MyBean implements CommandLineRunner {
    @Autowired
    HtmlHelper help;
    @Autowired
    HtmlHelper helper;
    private String text = "Hello World";
    public MyBean(String text) {
        this.text = text;
    }
    public MyBean() {
        System.out.println("MyBean created");
    }
    public void run(String [] args) {
        System.out.println("Server ready!");
        System.out.println(help);
        System.out.println(helper);
        String [][] test = new String[2][2];
        test[0][0] = "a";
        test[0][1] = "b";
        test[1][0] = "c";
        test[1][1] = "d";
        System.out.println(help.createHtmlTable(test));
    }
}