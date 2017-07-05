package com.franklinharper.sierpinskigraphcalculation;

import org.junit.jupiter.api.Test;

import static com.franklinharper.sierpinskigraphcalculation.SierpinskiGraph.verifyInequality;
import static org.junit.jupiter.api.Assertions.*;

class SierpinskiGraphTest {

  // Caution when running this test, it takes more than 5 hours to run
  // on a MacBook pro.
//  @Test
//  void sumExcesses_forLargeMax_M_plus_N() {
//    long sumExcesses = verifyInequality(2, 13, 2);
//    assertEquals(3968105989580L, sumExcesses);
//  }

  @Test
  void sumExcessesTest() {
    long sumExcesses = verifyInequality(2, 5, 1);
    assertEquals(62, sumExcesses);
  }

  @Test
  void verifyInequalityTest() {
    long[][][] theta = SierpinskiGraph.thetaValues(2, 3);
    assertEquals(
        48,
        SierpinskiGraph.verifyInequalityForGivenNandM(2, 3, theta)
    );
    assertEquals(
        48,
        SierpinskiGraph.verifyInequalityForGivenNandM(2, 3, theta)
    );
  }

  @Test
  void verifyInequality_is_false_for_N_2_M_3_With_fake_theta_value() {
    long[][][] theta = SierpinskiGraph.thetaValues(2, 3);
    // For testing purposes, insert a fake value of theta that invalidates
    // the inequality. The real value is 0.
    theta[2][3][9] = 3;
    System.out.println("The failure to verify the inequality below is expected.");
    System.out.println("For testing purposes fake thetaValues have been supplied.");
    assertThrows(IllegalStateException.class, () -> {
      SierpinskiGraph.verifyInequalityForGivenNandM(2, 3, theta);
    });
  }

  @Test
  void excessTest() {
    final int n = 2;
    final int m = 3;
    long[][][] theta = SierpinskiGraph.thetaValues(n, m);

    // Values for l => 1, and 1 <= lPrime <= l
    assertEquals(0, SierpinskiGraph.excess(n, m, 1, 1, theta));

    // Values for l => 2, and 1 <= lPrime <= l
    assertEquals(2, SierpinskiGraph.excess(n, m, 2, 1, theta));
    assertEquals(2, SierpinskiGraph.excess(n, m, 2, 2, theta));

    // Values for l => 3, and 1 <= lPrime <= l
    assertEquals(0, SierpinskiGraph.excess(n, m, 3, 1, theta));
    assertEquals(0, SierpinskiGraph.excess(n, m, 3, 2, theta));
    assertEquals(0, SierpinskiGraph.excess(n, m, 3, 3, theta));

    // Values for l => 4, and 1 <= lPrime <= l
    assertEquals(0, SierpinskiGraph.excess(n, m, 4, 1, theta));
    assertEquals(2, SierpinskiGraph.excess(n, m, 4, 2, theta));
    assertEquals(0, SierpinskiGraph.excess(n, m, 4, 3, theta));
    assertEquals(2, SierpinskiGraph.excess(n, m, 4, 4, theta));

    // Values for l => 5, and 1 <= lPrime <= l
    assertEquals(2, SierpinskiGraph.excess(n, m, 5, 1, theta));
    assertEquals(2, SierpinskiGraph.excess(n, m, 5, 2, theta));
    assertEquals(2, SierpinskiGraph.excess(n, m, 5, 3, theta));
    assertEquals(4, SierpinskiGraph.excess(n, m, 5, 4, theta));
    assertEquals(2, SierpinskiGraph.excess(n, m, 5, 5, theta));

    // Values for l => 6, and 1 <= lPrime <= l
    assertEquals(0, SierpinskiGraph.excess(n, m, 6, 1, theta));
    assertEquals(2, SierpinskiGraph.excess(n, m, 6, 2, theta));
    assertEquals(2, SierpinskiGraph.excess(n, m, 6, 3, theta));
    assertEquals(2, SierpinskiGraph.excess(n, m, 6, 4, theta));
    assertEquals(0, SierpinskiGraph.excess(n, m, 6, 5, theta));
    assertEquals(0, SierpinskiGraph.excess(n, m, 6, 6, theta));

    // Values for l => 7, and 1 <= lPrime <= l
    assertEquals(2, SierpinskiGraph.excess(n, m, 7, 1, theta));
    assertEquals(4, SierpinskiGraph.excess(n, m, 7, 2, theta));
    assertEquals(2, SierpinskiGraph.excess(n, m, 7, 3, theta));
    assertEquals(2, SierpinskiGraph.excess(n, m, 7, 4, theta));
    assertEquals(2, SierpinskiGraph.excess(n, m, 7, 5, theta));
    assertEquals(0, SierpinskiGraph.excess(n, m, 7, 6, theta));
    assertEquals(2, SierpinskiGraph.excess(n, m, 7, 7, theta));

    // Values for l => 8, and 1 <= lPrime <= l
    assertEquals(2, SierpinskiGraph.excess(n, m, 8, 1, theta));
    assertEquals(2, SierpinskiGraph.excess(n, m, 8, 2, theta));
    assertEquals(0, SierpinskiGraph.excess(n, m, 8, 3, theta));
    assertEquals(2, SierpinskiGraph.excess(n, m, 8, 4, theta));
    assertEquals(0, SierpinskiGraph.excess(n, m, 8, 5, theta));
    assertEquals(0, SierpinskiGraph.excess(n, m, 8, 6, theta));
    assertEquals(2, SierpinskiGraph.excess(n, m, 8, 7, theta));
    assertEquals(0, SierpinskiGraph.excess(n, m, 8, 8, theta));
  }

  @Test
  void sigmaTest() {
//    sigma(n,m,l0, l1), For m => 2, n => 0
    assertEquals(0, SierpinskiGraph.sigma(0, 2, 0, 0));

//    sigma(n,m,l0, l1), For m => 2, n => 1
    assertEquals(0, SierpinskiGraph.sigma(1, 2, 0, 0));
    assertEquals(0, SierpinskiGraph.sigma(1, 2, 1, 0));
    assertEquals(0, SierpinskiGraph.sigma(1, 2, 2, 0));
    assertEquals(2, SierpinskiGraph.sigma(1, 2, 1, 1));
    assertEquals(0, SierpinskiGraph.sigma(1, 2, 2, 1));
    assertEquals(0, SierpinskiGraph.sigma(1, 2, 2, 2));

//    sigma(n,m,l0, l1), For m => 2, n => 2
    assertEquals(0, SierpinskiGraph.sigma(2, 2, 0, 0));
    assertEquals(0, SierpinskiGraph.sigma(2, 2, 1, 0));
    assertEquals(0, SierpinskiGraph.sigma(2, 2, 2, 0));
    assertEquals(0, SierpinskiGraph.sigma(2, 2, 3, 0));
    assertEquals(0, SierpinskiGraph.sigma(2, 2, 4, 0));
    assertEquals(1, SierpinskiGraph.sigma(2, 2, 1, 1));
    assertEquals(1, SierpinskiGraph.sigma(2, 2, 2, 1));
    assertEquals(2, SierpinskiGraph.sigma(2, 2, 3, 1));
    assertEquals(0, SierpinskiGraph.sigma(2, 2, 4, 1));
    assertEquals(2, SierpinskiGraph.sigma(2, 2, 2, 2));
    assertEquals(1, SierpinskiGraph.sigma(2, 2, 3, 2));
    assertEquals(0, SierpinskiGraph.sigma(2, 2, 4, 2));
    assertEquals(1, SierpinskiGraph.sigma(2, 2, 3, 3));
    assertEquals(0, SierpinskiGraph.sigma(2, 2, 4, 3));
    assertEquals(0, SierpinskiGraph.sigma(2, 2, 4, 4));
  }

  @Test
  void kTest() {

//    k(n,m,l), For m => 2, n => 2
    assertEquals(0, SierpinskiGraph.k(2, 2, 0));
    assertEquals(0, SierpinskiGraph.k(2, 2, 1));
    assertEquals(1, SierpinskiGraph.k(2, 2, 2));
    assertEquals(1, SierpinskiGraph.k(2, 2, 3));
    assertEquals(2, SierpinskiGraph.k(2, 2, 4));

//    k(n,m,l), For m => 2, n => 3
    assertEquals(0, SierpinskiGraph.k(3, 2, 0));
    assertEquals(0, SierpinskiGraph.k(3, 2, 1));
    assertEquals(0, SierpinskiGraph.k(3, 2, 2));
    assertEquals(0, SierpinskiGraph.k(3, 2, 3));
    assertEquals(1, SierpinskiGraph.k(3, 2, 4));
    assertEquals(1, SierpinskiGraph.k(3, 2, 5));
    assertEquals(1, SierpinskiGraph.k(3, 2, 6));
    assertEquals(1, SierpinskiGraph.k(3, 2, 7));
    assertEquals(2, SierpinskiGraph.k(3, 2, 8));

//    k(n,m,l), For m => 3, n => 2
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

//    k(n,m,l), For m => 3, n => 3
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

    // q(n,m,l), For m => 2, n => 2
    assertEquals(0, SierpinskiGraph.q(2, 2, 0));
    assertEquals(1, SierpinskiGraph.q(2, 2, 1));
    assertEquals(1, SierpinskiGraph.q(2, 2, 2));
    assertEquals(1, SierpinskiGraph.q(2, 2, 3));
    assertEquals(2, SierpinskiGraph.q(2, 2, 4));

    // q(n,m,l), For m => 2, n => 3
    assertEquals(0, SierpinskiGraph.q(3, 2, 0));
    assertEquals(1, SierpinskiGraph.q(3, 2, 1));
    assertEquals(1, SierpinskiGraph.q(3, 2, 2));
    assertEquals(1, SierpinskiGraph.q(3, 2, 3));
    assertEquals(1, SierpinskiGraph.q(3, 2, 4));
    assertEquals(1, SierpinskiGraph.q(3, 2, 5));
    assertEquals(1, SierpinskiGraph.q(3, 2, 6));
    assertEquals(1, SierpinskiGraph.q(3, 2, 7));
    assertEquals(2, SierpinskiGraph.q(3, 2, 8));

    // q(n,m,l), For m => 3, n => 2
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

    // q(n,m,l), For m => 3, n => 3
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