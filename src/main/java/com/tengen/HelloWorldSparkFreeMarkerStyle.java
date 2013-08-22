/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tengen;

import freemarker.template.Configuration;
import freemarker.template.Template;
import java.io.StringWriter;
import java.util.HashMap;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import spark.Request;
import spark.Response;
import spark.Route;
import spark.Spark;

/**
 *
 * @author HShakya
 */
public class HelloWorldSparkFreeMarkerStyle {
    public static void main(String[] args) {
        final Configuration configuration = new Configuration();
        configuration.setClassForTemplateLoading(HelloWorldSparkFreeMarkerStyle.class, "/");
        
        Spark.get(new Route("/") {
            @Override
            public Object handle(Request rqst, Response rspns) {
                StringWriter writer = new StringWriter();
                try {
                    Template helloTemplate = configuration.getTemplate("hello.ftl");
                    Map<String, Object> helloMap = new HashMap<String, Object>();
                    helloMap.put("name", "FreeMarker");

                    helloTemplate.process(helloMap, writer);

                    System.out.println(writer);
                } catch (Exception ex) {
                    halt(500);
                    Logger.getLogger(HelloWorldFreeMarkerStyle.class.getName()).log(Level.SEVERE, null, ex);
                }
                
                return writer;
            }
        });
    }
}
