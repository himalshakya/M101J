/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tengen;

import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.DBObject;
import com.mongodb.MongoClient;
import com.mongodb.ServerAddress;
import freemarker.template.Configuration;
import freemarker.template.Template;
import java.io.StringWriter;
import java.net.UnknownHostException;
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
public class HelloWorldMongoDBSparkFreeMarkerStyle {
    public static void main(String[] args) throws UnknownHostException {
        final Configuration configuration = new Configuration();
        configuration.setClassForTemplateLoading(HelloWorldSparkFreeMarkerStyle.class, "/");
        
        MongoClient client = new MongoClient(new ServerAddress("localhost", 27017));
        
        DB database = client.getDB("course");
        final DBCollection collection = database.getCollection("names");
        
        
        
        Spark.get(new Route("/") {
            @Override
            public Object handle(Request rqst, Response rspns) {
                StringWriter writer = new StringWriter();
                try {
                    Template helloTemplate = configuration.getTemplate("hello.ftl");
                    
                    DBObject document = collection.findOne();
                    
                    helloTemplate.process(document, writer);

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
