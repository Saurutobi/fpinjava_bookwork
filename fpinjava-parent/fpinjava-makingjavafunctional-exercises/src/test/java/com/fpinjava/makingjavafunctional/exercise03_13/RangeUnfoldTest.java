package com.fpinjava.makingjavafunctional.exercise03_13;

import static org.junit.Assert.*;

import org.junit.Test;

public class RangeUnfoldTest {

  @Test
  public void testRange() {
    assertEquals("[]", RangeUnfold.range(0, 0).toString());
    assertEquals("[0]", RangeUnfold.range(0, 1).toString());
    assertEquals("[0, 1, 2, 3, 4]", RangeUnfold.range(0, 5).toString());
    assertEquals("[]", RangeUnfold.range(5, 1).toString());
  }

}
