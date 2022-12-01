package com.example.springgraphqlerrortest;

import java.util.concurrent.CompletableFuture;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;

@Controller
public class QueryController {

  @QueryMapping
  public CompletableFuture<String> helloWorld() {
    return CompletableFuture.failedFuture(new RuntimeException("Query exception!"));
  }

  @MutationMapping
  public CompletableFuture<String> hello(@Argument String name) {
    if (name.equals("world"))
      return CompletableFuture.failedFuture(new RuntimeException("Name cannot be world!"));

    return CompletableFuture.completedFuture("Hello " + name);
  }

}
