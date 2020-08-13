package com.fpinjava.makingjavafunctional.exercise03_10;

import static org.junit.Assert.*;
import static com.fpinjava.makingjavafunctional.exercise03_10.MapFold.*;

import org.junit.Test;

public class MapFoldTest {

  @Test
  public void testMapViaFoldLeft() {
    assertEquals("[1, 4, 9]", mapViaFoldLeft(list(1, 2, 3), x -> x * x).toString());
  }

  @Test
  public void testMapViaFoldRight() {
    assertEquals("[1, 4, 9]", mapViaFoldRight(list(1, 2, 3), x -> x * x).toString());
  }

}
