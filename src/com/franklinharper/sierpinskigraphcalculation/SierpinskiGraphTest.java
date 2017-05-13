package com.franklinharper.sierpinskigraphcalculation;


import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class SierpinskiGraphTest {

  @Test
  void sigmaTest() {
    // TODO Dad provide values for the test
    // TODO Frank create a README file that contains a link to the paper published in Arxiv.
    assertEquals(0, SierpinskiGraph.sigma(0, 2, 0, 0));
//    System.out.println( "sigma(0, 2, 0, 0) = " + SierpinskiGraph.sigma(0, 2, 0, 0));
//    System.out.println( "sigma(2, 3, 5, 3) = " + SierpinskiGraph.sigma(2, 3, 5, 3));
//    System.out.println( "sigma(2, 3, 5, 4) = " + SierpinskiGraph.sigma(2, 3, 5, 4));
//    System.out.println( "sigma(2, 3, 5, 5) = " + SierpinskiGraph.sigma(2, 3, 5, 5));
  }

  @Test
  void kTest() {

//    k(m,n,l), For m => 2, n => 2
    assertEquals(0, SierpinskiGraph.k(2, 2, 0));
    assertEquals(0, SierpinskiGraph.k(2, 2, 1));
    assertEquals(1, SierpinskiGraph.k(2, 2, 2));
    assertEquals(1, SierpinskiGraph.k(2, 2, 3));
    assertEquals(2, SierpinskiGraph.k(2, 2, 4));

//    k(m,n,l), For m => 2, n => 3
    assertEquals(0, SierpinskiGraph.k(3, 2, 0));
    assertEquals(0, SierpinskiGraph.k(3, 2, 1));
    assertEquals(0, SierpinskiGraph.k(3, 2, 2));
    assertEquals(0, SierpinskiGraph.k(3, 2, 3));
    assertEquals(1, SierpinskiGraph.k(3, 2, 4));
    assertEquals(1, SierpinskiGraph.k(3, 2, 5));
    assertEquals(1, SierpinskiGraph.k(3, 2, 6));
    assertEquals(1, SierpinskiGraph.k(3, 2, 7));
    assertEquals(2, SierpinskiGraph.k(3, 2, 8));

//    k(m,n,l), For m => 3, n => 2
    assertEquals(0, SierpinskiGraph.k(2, 3, 0));
    assertEquals(0, SierpinskiGraph.k(2, 3, 1));
    assertEquals(0, SierpinskiGraph.k(2, 3, 2));
    assertEquals(1, SierpinskiGraph.k(2, 3, 3));
    assertEquals(1, SierpinskiGraph.k(2, 3, 4));
    assertEquals(1, SierpinskiGraph.k(2, 3, 5));
    assertEquals(2, SierpinskiGraph.k(2, 3, 6));
    assertEquals(2, SierpinskiGraph.k(2, 3, 7));
    assertEquals(2, SierpinskiGraph.k(2, 3, 8));
    assertEquals(3, SierpinskiGraph.k(2, 3, 9));

//    k(m,n,l), For m => 3, n => 3
    assertEquals(0, SierpinskiGraph.k(3, 3, 0));
    assertEquals(0, SierpinskiGraph.k(3, 3, 1));
    assertEquals(0, SierpinskiGraph.k(3, 3, 2));
    assertEquals(0, SierpinskiGraph.k(3, 3, 3));
    assertEquals(0, SierpinskiGraph.k(3, 3, 4));
    assertEquals(0, SierpinskiGraph.k(3, 3, 5));
    assertEquals(0, SierpinskiGraph.k(3, 3, 6));
    assertEquals(0, SierpinskiGraph.k(3, 3, 7));
    assertEquals(0, SierpinskiGraph.k(3, 3, 8));
    assertEquals(1, SierpinskiGraph.k(3, 3, 9));
    assertEquals(1, SierpinskiGraph.k(3, 3, 10));
    assertEquals(1, SierpinskiGraph.k(3, 3, 11));
    assertEquals(1, SierpinskiGraph.k(3, 3, 12));
    assertEquals(1, SierpinskiGraph.k(3, 3, 13));
    assertEquals(1, SierpinskiGraph.k(3, 3, 14));
    assertEquals(1, SierpinskiGraph.k(3, 3, 15));
    assertEquals(1, SierpinskiGraph.k(3, 3, 16));
    assertEquals(1, SierpinskiGraph.k(3, 3, 17));
    assertEquals(2, SierpinskiGraph.k(3, 3, 18));
    assertEquals(2, SierpinskiGraph.k(3, 3, 19));
    assertEquals(2, SierpinskiGraph.k(3, 3, 20));
    assertEquals(2, SierpinskiGraph.k(3, 3, 21));
    assertEquals(2, SierpinskiGraph.k(3, 3, 22));
    assertEquals(2, SierpinskiGraph.k(3, 3, 23));
    assertEquals(2, SierpinskiGraph.k(3, 3, 24));
    assertEquals(2, SierpinskiGraph.k(3, 3, 25));
    assertEquals(2, SierpinskiGraph.k(3, 3, 26));
    assertEquals(3, SierpinskiGraph.k(3, 3, 27));
  }

  @Test
  void qTest() {

    // k(m,n,l), For m => 2, n => 2
    assertEquals(0, SierpinskiGraph.q(2, 2, 0));
    assertEquals(1, SierpinskiGraph.q(2, 2, 1));
    assertEquals(1, SierpinskiGraph.q(2, 2, 2));
    assertEquals(1, SierpinskiGraph.q(2, 2, 3));
    assertEquals(2, SierpinskiGraph.q(2, 2, 4));

    // k(m,n,l), For m => 2, n => 3
    assertEquals(0, SierpinskiGraph.q(3, 2, 0));
    assertEquals(1, SierpinskiGraph.q(3, 2, 1));
    assertEquals(1, SierpinskiGraph.q(3, 2, 2));
    assertEquals(1, SierpinskiGraph.q(3, 2, 3));
    assertEquals(1, SierpinskiGraph.q(3, 2, 4));
    assertEquals(1, SierpinskiGraph.q(3, 2, 5));
    assertEquals(1, SierpinskiGraph.q(3, 2, 6));
    assertEquals(1, SierpinskiGraph.q(3, 2, 7));
    assertEquals(2, SierpinskiGraph.q(3, 2, 8));

    // k(m,n,l), For m => 3, n => 2
    assertEquals(0, SierpinskiGraph.q(2, 3, 0));
    assertEquals(1, SierpinskiGraph.q(2, 3, 1));
    assertEquals(1, SierpinskiGraph.q(2, 3, 2));
    assertEquals(1, SierpinskiGraph.q(2, 3, 3));
    assertEquals(1, SierpinskiGraph.q(2, 3, 4));
    assertEquals(2, SierpinskiGraph.q(2, 3, 5));
    assertEquals(2, SierpinskiGraph.q(2, 3, 6));
    assertEquals(2, SierpinskiGraph.q(2, 3, 7));
    assertEquals(2, SierpinskiGraph.q(2, 3, 8));
    assertEquals(3, SierpinskiGraph.q(2, 3, 9));

    // k(m,n,l), For m => 3, n => 3
    assertEquals(0, SierpinskiGraph.q(3, 3, 0));
    assertEquals(1, SierpinskiGraph.q(3, 3, 1));
    assertEquals(1, SierpinskiGraph.q(3, 3, 2));
    assertEquals(1, SierpinskiGraph.q(3, 3, 3));
    assertEquals(1, SierpinskiGraph.q(3, 3, 4));
    assertEquals(1, SierpinskiGraph.q(3, 3, 5));
    assertEquals(1, SierpinskiGraph.q(3, 3, 6));
    assertEquals(1, SierpinskiGraph.q(3, 3, 7));
    assertEquals(1, SierpinskiGraph.q(3, 3, 8));
    assertEquals(1, SierpinskiGraph.q(3, 3, 9));
    assertEquals(1, SierpinskiGraph.q(3, 3, 10));
    assertEquals(1, SierpinskiGraph.q(3, 3, 11));
    assertEquals(1, SierpinskiGraph.q(3, 3, 12));
    assertEquals(1, SierpinskiGraph.q(3, 3, 13));
    assertEquals(2, SierpinskiGraph.q(3, 3, 14));
    assertEquals(2, SierpinskiGraph.q(3, 3, 15));
    assertEquals(2, SierpinskiGraph.q(3, 3, 16));
    assertEquals(2, SierpinskiGraph.q(3, 3, 17));
    assertEquals(2, SierpinskiGraph.q(3, 3, 18));
    assertEquals(2, SierpinskiGraph.q(3, 3, 19));
    assertEquals(2, SierpinskiGraph.q(3, 3, 20));
    assertEquals(2, SierpinskiGraph.q(3, 3, 21));
    assertEquals(2, SierpinskiGraph.q(3, 3, 22));
    assertEquals(2, SierpinskiGraph.q(3, 3, 23));
    assertEquals(2, SierpinskiGraph.q(3, 3, 24));
    assertEquals(2, SierpinskiGraph.q(3, 3, 25));
    assertEquals(2, SierpinskiGraph.q(3, 3, 26));
    assertEquals(3, SierpinskiGraph.q(3, 3, 27));
  }

  @Test
  void thetaTest() {
    long[][][] thetaValues = SierpinskiGraph.thetaValues(3, 3);

    // n == 1 and m == 2
    assertEquals(0, thetaValues[1][2][0]);
    assertEquals(1, thetaValues[1][2][1]);
    assertEquals(0, thetaValues[1][2][2]);

    // n == 2 and m == 2
    assertEquals(0, thetaValues[2][2][0]);
    assertEquals(1, thetaValues[2][2][1]);
    assertEquals(1, thetaValues[2][2][2]);
    assertEquals(1, thetaValues[2][2][3]);
    assertEquals(0, thetaValues[2][2][4]);

    // n == 2 and m == 3
    assertEquals(0, thetaValues[2][3][0]);
    assertEquals(2, thetaValues[2][3][1]);
    assertEquals(3, thetaValues[2][3][2]);
    assertEquals(2, thetaValues[2][3][3]);
    assertEquals(3, thetaValues[2][3][4]);
    assertEquals(3, thetaValues[2][3][5]);
    assertEquals(2, thetaValues[2][3][6]);
    assertEquals(3, thetaValues[2][3][7]);
    assertEquals(2, thetaValues[2][3][8]);
    assertEquals(0, thetaValues[2][3][9]);

    // n == 3 and m == 3
    // Check that the theta values are symmetric in l.
    for (int l = 0; l < 14; l++) {
      assertEquals(thetaValues[3][3][l], thetaValues[3][3][27-l]);
    }
    assertEquals(0, thetaValues[3][3][0]);
    assertEquals(2, thetaValues[3][3][1]);
    assertEquals(3, thetaValues[3][3][2]);
    assertEquals(2, thetaValues[3][3][3]);
    assertEquals(3, thetaValues[3][3][4]);
    assertEquals(4, thetaValues[3][3][5]);
    assertEquals(3, thetaValues[3][3][6]);
    assertEquals(4, thetaValues[3][3][7]);
    assertEquals(3, thetaValues[3][3][8]);
    assertEquals(2, thetaValues[3][3][9]);
    assertEquals(3, thetaValues[3][3][10]);
    assertEquals(4, thetaValues[3][3][11]);
    assertEquals(3, thetaValues[3][3][12]);
    assertEquals(4, thetaValues[3][3][13]);
    assertEquals(4, thetaValues[3][3][14]);
    assertEquals(3, thetaValues[3][3][15]);
    assertEquals(4, thetaValues[3][3][16]);
    assertEquals(3, thetaValues[3][3][17]);
    assertEquals(2, thetaValues[3][3][18]);
    assertEquals(3, thetaValues[3][3][19]);
    assertEquals(4, thetaValues[3][3][20]);
    assertEquals(3, thetaValues[3][3][21]);
    assertEquals(4, thetaValues[3][3][22]);
    assertEquals(3, thetaValues[3][3][23]);
    assertEquals(2, thetaValues[3][3][24]);
    assertEquals(3, thetaValues[3][3][25]);
    assertEquals(2, thetaValues[3][3][26]);
    assertEquals(0, thetaValues[3][3][27]);
  }

  @Test
  void power_returns1_whenExponentIs0() {
    for (int base = -10; base < 11; base++) {
      assertEquals(1, SierpinskiGraph.power(base, 0));
    }
  }

  @Test
  void power_returnsBase_whenExponentIs1() {
    for (int base = -10; base < 11; base++) {
      assertEquals(base, SierpinskiGraph.power(base, 1));
    }
  }

  @Test
  void power_returnsBaseSquared_whenExponentIs2() {
    for (int base = -10; base < 11; base++) {
      assertEquals(base * base, SierpinskiGraph.power(base, 2));
    }
  }

  @Test
  void power_returnsBaseCubed_whenExponentIs3() {
    for (int base = -10; base < 11; base++) {
      assertEquals(base * base * base, SierpinskiGraph.power(base, 3));
    }
  }

}