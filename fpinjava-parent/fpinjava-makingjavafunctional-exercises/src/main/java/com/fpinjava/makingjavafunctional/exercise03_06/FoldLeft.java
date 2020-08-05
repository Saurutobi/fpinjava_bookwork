package com.fpinjava.makingjavafunctional.exercise03_06;

import com.fpinjava.common.Function;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class FoldLeft {
  @SafeVarargs
  public static <T> List<T > list(T... t) {
    return Collections.unmodifiableList(Arrays.asList(Arrays.copyOf(t, t.length)));
  }

  public static <T, U> U foldLeft(List<T> ts,
                                  U identity,
                                  Function<U, Function<T, U>> f) {
    U result = identity;
    for(T t : ts)
    {
      result= f.apply(result).apply(t);
    }
    return result;
  }
}
