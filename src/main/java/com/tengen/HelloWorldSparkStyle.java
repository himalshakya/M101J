/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tengen;

import spark.Request;
import spark.Response;
import spark.Route;
import spark.Spark;

/**
 *
 * @author HShakya
 */
public class HelloWorldSparkStyle {
    public static void main(String[] args) {
        Spark.get(new Route("/") {
            @Override
            public Object handle(Request rqst, Response rspns) {
                return "Hello";
            }
        });
    }
}
