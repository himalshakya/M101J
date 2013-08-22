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
import java.net.UnknownHostException;

/**
 *
 * @author HShakya
 */
public class HelloWorldMongoDBStyle {
    public static void main(String[] args) throws UnknownHostException{
        MongoClient client = new MongoClient(new ServerAddress("localhost", 27017));
        
        DB database = client.getDB("course");
        DBCollection collection = database.getCollection("names");
        
        DBObject document = collection.findOne();
        System.out.println(document);
    }
}
