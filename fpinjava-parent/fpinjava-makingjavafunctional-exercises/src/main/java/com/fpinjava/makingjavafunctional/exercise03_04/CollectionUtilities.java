package com.fpinjava.makingjavafunctional.exercise03_04;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

public class CollectionUtilities {

  public static <T> List<T > list() {
    return Collections.emptyList();
  }

  public static <T> List<T > list(T t) {
    return Collections.singletonList(t);
  }

  public static <T> List<T > list(List<T> ts) {
    return Collections.unmodifiableList(new ArrayList<>(ts));
  }

  @SafeVarargs
  public static <T> List<T > list(T... t) {
    return Collections.unmodifiableList(Arrays.asList(Arrays.copyOf(t, t.length)));
  }

  public static <T> T head(List<T> list) {
    return list.get(0);
  }

  private static <T> List<T > copy(List<T> ts) {
    return list(ts);
  }

  public static <T> List<T> tail(List<T> list) {
    return copy(list.subList(1, (int)list.stream().count()));
  }
}
