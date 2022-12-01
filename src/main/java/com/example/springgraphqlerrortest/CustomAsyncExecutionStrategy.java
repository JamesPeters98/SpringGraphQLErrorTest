package com.example.springgraphqlerrortest;

import graphql.ExecutionResult;
import graphql.ExecutionResultImpl;
import graphql.execution.AsyncExecutionStrategy;
import graphql.execution.ExecutionContext;
import graphql.execution.ExecutionStrategyParameters;
import graphql.execution.NonNullableFieldWasNullException;
import java.util.concurrent.CompletableFuture;

/**
 * Custom AsyncExecutionStrategy to return null when any errors are present.
 */
public class CustomAsyncExecutionStrategy extends AsyncExecutionStrategy {

  @Override
  public CompletableFuture<ExecutionResult> execute(ExecutionContext executionContext, ExecutionStrategyParameters parameters) throws NonNullableFieldWasNullException {
    // Normally I would change the resulting data to null here if certain exceptions were present.
    // But just this is enough to reproduce the error.
    return super.execute(executionContext, parameters);
  }

}
