package com.fpinjava.makingjavafunctional.exercise03_02;

import com.fpinjava.common.Tuple;
import com.fpinjava.makingjavafunctional.exercise03_01.Result;

public class Case<T> extends Tuple<Supplier<Boolean>, Supplier<Result<T>>>{  //missed method signature

  private Case(Supplier<Boolean> booleanSupplier, Supplier<Result<T>> resultSupplier) {
    super(booleanSupplier, resultSupplier);
  }

  public static <T> Case<T> mcase(Supplier<Boolean> condition, Supplier<Result<T>> value) {
    return new Case<>(condition, value);
//
//    if (condition.get())
//    {
//      value.get().bind();
//    }

  }

  public static <T> DefaultCase<T> mcase(Supplier<Result<T>> value) {
    return new DefaultCase<>(() -> true, value);

//    value.get().bind();


  }

  private static class DefaultCase<T> extends Case<T> {

    private DefaultCase(Supplier<Boolean> booleanSupplier, Supplier<Result<T>> resultSupplier) {
      super(booleanSupplier, resultSupplier);
    }
  }

  @SafeVarargs
  public static <T> Result<T> match(DefaultCase<T> defaultCase, Case<T>... matchers) {
//run through the matchers and return something, then return defaultcase if not

    
    for (Case<T> aCase : matchers) {
      if (aCase._1.get()) return aCase._2.get();
    }
    return defaultCase._2.get();

  }
}
