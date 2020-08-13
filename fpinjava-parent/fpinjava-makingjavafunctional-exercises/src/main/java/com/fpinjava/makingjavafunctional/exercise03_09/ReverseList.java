package com.fpinjava.makingjavafunctional.exercise03_09;

import com.fpinjava.common.Function;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class ReverseList {

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
    if (list.size() == 0) {
      throw new IllegalStateException("head of empty list");
    }
    return list.get(0);
  }

  private static <T> List<T > copy(List<T> ts) {
    return new ArrayList<>(ts);
  }

  public static <T> List<T> tail(List<T> list) {
    if (list.size() == 0) {
      throw new IllegalStateException("tail of empty list");
    }
    List<T> workList = copy(list);
    workList.remove(0);
    return Collections.unmodifiableList(workList);
  }

  public static <T, U> U foldLeft(List<T> ts,
                                  U identity,
                                  Function<U, Function<T, U>> f) {
    U result = identity;
    for (T t : ts) {
      result = f.apply(result).apply(t);
    }
    return result;
  }


  public static <T> List<T> append(List<T> list, T t) {
    List<T> ts = copy(list);
    ts.add(t);
    return Collections.unmodifiableList(ts);
  }

  public static <T> List<T> prepend(T t, List<T> list) {
      return foldLeft(list, list(t), x->y->append(x,y));
  }

  public static <T, U> List<T> reverse(List<T> list) {
    //((((0+1)+2)+3)+4)+5)
    //12345
    //prepend(0, null)
    //prepend(1, (0,null)
    //prepend(2, (1,0,null)
    //prepend(3, (2,1,0,null)
    //prepend(4, (3,2,1,0,null)
    //prepend(5, (4,3,2,1,0,null)
    //543210
    return foldLeft(list, list(), x -> y -> prepend(y, x));
  }

  public static <T, U> List<T> reverse2Append(List<T> list) {

    return foldLeft(list, list(), x -> y -> prepend(y, x));
  }
}
