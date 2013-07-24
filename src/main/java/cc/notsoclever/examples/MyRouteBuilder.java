package cc.notsoclever.examples;

import org.apache.camel.builder.RouteBuilder;

public class MyRouteBuilder extends RouteBuilder {

   public void configure() {

      from("restlet:http://0.0.0.0:9090/temperature/f/{degrees}?restletMethods=get")
            .setBody().groovy("(request.getHeader('degrees', Double.class) - 32) / 1.8");

      from("restlet:http://0.0.0.0:9090/temperature/c/{degrees}?restletMethods=get")
            .setBody().groovy("request.getHeader('degrees', Double.class) * 1.8 + 32");

   }
}
