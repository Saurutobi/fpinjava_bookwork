package com.fpinjava.makingjavafunctional.exercise03_07;

import com.fpinjava.common.Function;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class FoldRight {
  @SafeVarargs
  public static <T> List<T > list(T... t) {
    return Collections.unmodifiableList(Arrays.asList(Arrays.copyOf(t, t.length)));
  }

  public static <T> T head(List<T> list) {
    if (list.size() == 0) {
      throw new IllegalStateException("head of empty list");
    }
    return list.get(0);
  }

  public static <T, U> U foldRight(List<T> ts,
                                   U identity,
                                   Function<T, Function<U, U>> f) {

    U result = identity;
    for (int i= ts.size()-1; i >=0; i--) {
      result = f.apply(ts.get(i)).apply(result);
    }
    return result;
  }

}
