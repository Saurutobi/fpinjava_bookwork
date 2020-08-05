package com.fpinjava.makingjavafunctional.exercise03_03;

import static java.util.Collections.emptyList;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class CollectionUtilities {

  public static <T> List<T > list() {
    return emptyList();
  }

  public static <T> List<T > list(T t) {
    return Collections.singletonList(t);
  }
  public static <T> List<T > list(List<T> ts) {
    return null; //return List.copyOf(ts);
  }

  @SafeVarargs
  public static <T> List<T > list(T... t) {
    return null; //return List.of(t);
  }
}
