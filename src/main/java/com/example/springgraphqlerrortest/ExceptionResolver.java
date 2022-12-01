package com.example.springgraphqlerrortest;

import graphql.GraphQLError;
import graphql.GraphqlErrorException;
import graphql.schema.DataFetchingEnvironment;
import java.util.List;
import org.springframework.graphql.execution.DataFetcherExceptionResolver;
import org.springframework.graphql.execution.DataFetcherExceptionResolverAdapter;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Component;

@Component
public class ExceptionResolver extends DataFetcherExceptionResolverAdapter {

  @Nullable
  @Override
  protected GraphQLError resolveToSingleError(Throwable ex, DataFetchingEnvironment env) {
    if (ex instanceof RuntimeException runtimeException) {
      return GraphqlErrorException.newErrorException()
        .cause(runtimeException)
        .message("GraphQL error exception: "+runtimeException.getMessage())
        .build();
    }
    return super.resolveToSingleError(ex, env);
  }

}
