package fi.tuni.e02;


import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

public class HtmlHelperImpl implements HtmlHelper {
    private boolean prettyPrint = false;

    public HtmlHelperImpl(boolean prettyPrint){
        this.prettyPrint = prettyPrint;
    }
    public HtmlHelperImpl(){}
    @PostConstruct
    public void init(){
        System.out.println("init");
    }
    @PreDestroy
    public void cleanup() throws Exception{
        System.out.println("cleanup");
    }
    @Override
    public String createHtmlTable(String[][] data) {
        StringBuilder table = new StringBuilder();
        table.append("<table>");
        if(prettyPrint){
            table.append("\n    ");
            for(int i = 0; i < data.length;i++){
                table.append("<tr>");
                table.append("\n        ");
                for(int y = 0; y < data[0].length; y++){
                    table.append("<td>");
                    table.append(data[i][y]);
                    table.append("</td>");
                    if(y < data[0].length-1) {
                        table.append("\n        ");
                    }
                }
                table.append("\n    ");
                table.append("</tr>");
                table.append("\n    ");
            }
            table.append("\n");
        }else{
            for(int i = 0; i < data.length;i++){
                table.append("<tr>");
                for(int y = 0; y < data[0].length; y++){
                    table.append("<td>");
                    table.append(data[i][y]);
                    table.append("</td>");
                }
                table.append("</tr>");
            }
        }
        table.append("</table>");
        return table.toString();
    }

    @Override
    public String createHtmlPage(String title, String content) {
        String ret =
            "\n" +
                    "<!DOCTYPE html>\n" +
                    "<html>\n" +
                    "  <head>\n" +
                    "    <title>\n" +
                            title +
                    "    </title>    \n" +
                    "  </head>\n" +
                    "  \n" +
                    "  <body>\n" +
                            content +
                    "  </body>\n" +
                    "</html>";
        return ret;
    }
}
