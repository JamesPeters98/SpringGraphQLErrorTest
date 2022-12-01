package com.example.springgraphqlerrortest;

import org.springframework.boot.autoconfigure.graphql.GraphQlSourceBuilderCustomizer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class GraphQLConfig {

  @Bean
  public GraphQlSourceBuilderCustomizer sourceBuilderCustomizer() {
    return (builder) -> builder.configureGraphQl(config ->
      config.queryExecutionStrategy(new CustomAsyncExecutionStrategy()));
  }

}
