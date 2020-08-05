package com.fpinjava.makingjavafunctional.exercise03_05;

import com.fpinjava.common.Function;

import java.util.List;

public class Fold {

  public static Integer fold(List<Integer> is, Integer identity,
                             Function<Integer, Function<Integer, Integer>> f) {
  if(is.size() == 0)
  {
    return 0;
  }
  else if(is.size() == identity)
  {
    f.apply(is.get(identity));
  }

  return fold(is, identity+1, f);


    //int result = identity;
    //for (Integer i : is) {
    //result = f.apply(result).apply(i);
    //}
    //return result;
  }
}
