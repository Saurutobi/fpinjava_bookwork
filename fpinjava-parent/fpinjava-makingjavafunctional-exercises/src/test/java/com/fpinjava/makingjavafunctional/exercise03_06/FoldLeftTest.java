package com.fpinjava.makingjavafunctional.exercise03_06;

import static org.junit.Assert.*;
import static com.fpinjava.makingjavafunctional.exercise03_06.FoldLeft.*;

import java.util.List;
import java.util.function.BiFunction;

import org.junit.Test;

import com.fpinjava.common.Function;

public class FoldLeftTest {
  private static String addSI(String s, Integer i) {
    return "(" + s + " + " + i + ")";
  }
  
  @Test
  public void testFoldLeft() {
    List<Integer> list = list(1, 2, 3, 4, 5);
    String identity = "0";
    Function<String, Function<Integer, String>> f = x -> y -> addSI(x, y);
    assertEquals("(((((0 + 1) + 2) + 3) + 4) + 5)", foldLeft(list, identity, f));
  }

  @Test
  public void testFoldLeftbifunction() {
    List<Integer> list = list(1, 2, 3, 4, 5);
    String identity = "0";
    Function<String, Function<Integer, String>> f = x -> y -> addSI(x, y);

    BiFunction<Integer, String, String> biF = (x,y) -> addSI(y,x);
    assertEquals("(((((0 + 1) + 2) + 3) + 4) + 5)", foldLeftBiFunction(list, identity, biF));
  }

}
