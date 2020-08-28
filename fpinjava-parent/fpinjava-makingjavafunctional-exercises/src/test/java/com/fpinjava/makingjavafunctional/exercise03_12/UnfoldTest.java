package com.fpinjava.makingjavafunctional.exercise03_12;

import static org.junit.Assert.*;

import org.junit.Test;

public class UnfoldTest {

  @Test
  public void testUnfold() {
    assertEquals("[1, 2, 4, 8]", Unfold.unfold(1, x -> x * 2, x -> x < 10).toString());
    assertEquals("[x, xx, xxx, xxxx]", Unfold.unfold("x", x -> x + "x", x -> x.length() < 5).toString());
  }

}
