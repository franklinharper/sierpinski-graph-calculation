package com.franklinharper.sierpinskigraphcalculation;

// TODO insert link to the paper published on Arxiv.

public class SierpinskiGraph {

  static final int MAX_M_N = 13;
  private static int[][] powerValues;

  // Verify that Conjecture 2 is true for
  // all n, m such that n >= 2, n >= 1, and n + m <= MAX_M_N
  //
  public static void main(String[] args) {
    verifyInequality(2, MAX_M_N, 1);
  }

  static long verifyInequality(int initialM, int maxMplusN, int initialN) {
    System.out.println(String.format(
        "Verifying conjecture  for all n, m such that n >= %d, m >= %d, and n + m <= %d",
        initialN, initialM, maxMplusN
    ));
    long sumExcesses = 0;
    for (int m = initialM; m <= maxMplusN; m++) {
      for (int n = initialN; n <= maxMplusN - m; n++) {
        System.out.println(String.format("Calculating thetaValues for n:%d m:%d", n, m));
        long[][][] theta = thetaValues(n, m);
        sumExcesses += verifyInequalityForGivenNandM(n, m, theta);
      }
    }
    System.out.println(String.format(
        "Conjecture verified for all n, m such that n >= %d, m >= %d, and n + m <= %d",
        initialN, initialM, maxMplusN
    ));
    System.out.println(String.format(
        "sumExcesses: %d for initialM:%d maxM:%d initialN:%d",
        sumExcesses, initialM, maxMplusN, initialN
    ));
    return sumExcesses;
  }

  // Verify that Conjecture 2 is true for given values of n, m, and theta.
  static long verifyInequalityForGivenNandM(int n, int m, long[][][] theta) {
    System.out.println(String.format("Verifying inequality for n:%d m:%d", n, m));
    long sumExcesses = 0;
    for (int l = 0; l <= power(m, n); l++) {
      for (int lPrime = 0; lPrime <= l; lPrime++) {
        sumExcesses += excesses(n, m, l, lPrime, theta);
      }
    }
    return sumExcesses;
  }

  // This function verifies the inequalities in conjecture 2, and immediately stops
  // iff the conjecture is not true.
  //
  // It also calculates the difference between the RHS and the LHS
  // of both inequalities.
  //
  // If both of the differences (aka excesses) are >= 0 then the conjecture holds true
  // for the given values of n, m, l, lPrime, and theta.
  //
  // Calculating the excesses enables fine grained testing that calculation gives the
  // expected results.
  static long excesses(int n, int m, int l, int lPrime, long[][][] theta) {
    long excess1 = 0;
    if (l + lPrime <= power(m, n)) {
      excess1 = theta[n][m][l] + theta[n][m][lPrime]
                - (theta[n][m][l + lPrime] + sigma(n, m, l, lPrime));
      if (excess1 < 0) {
        // Immediately stop the verification
        throw new IllegalStateException(
            String.format("Inequality not true for excess1: %d, n:%d m:%d l:%d lPrime:%d", excess1, n, m, l, lPrime));
      }
    }

    long excess2 = 0;
    if (l + lPrime >= power(m,n)) {
      excess2 = theta[n][m][l] + theta[n][m][lPrime]
                - (theta[n][m][l + lPrime - power(m, n)] + sigma(n, m, l, lPrime));
      if (excess2 < 0) {
        // Immediately stop the verification
        throw new IllegalStateException(
            String.format("Inequality not true for excess2: %d, n:%d m:%d l:%d lPrime:%d", excess2, n, m, l, lPrime));
      }
    }
//    System.out.println(String.format("excess: %d for n:%d m:%d l0:%d l1:%d", excess, n, m, l, lPrime));
    return excess1 + excess2;
  }

  // Use Lemma 3 to calculate values of theta for:
  //    0 <= n <= maxN,
  //    2 <= m <= maxM,
  //    0 <= l <= mˆn
  //
  // In the array of calculated theta values:
  //    The first array index is n.
  //    The second array index is m.
  //    The third array index is l.
  //
  static long[][][] thetaValues(int maxN, int maxM) {

    // Java arrays contain n elements that are indexed from 0 to n - 1.
    // To be able to use an index of maxN, the array must contain the maxN + 1 elements
    // The same holds for for maxM.
    long[][][] thetaValues = new long[maxN + 1][maxM + 1][];

    for (int m = 2; m <= maxM; m++) {
      thetaValues[0][m] = new long[2];
      thetaValues[0][m][0] = 0;
      System.out.println(String.format("thetaValues[0][%d][0] = %d", m, thetaValues[0][m][0]));
      thetaValues[0][m][1] = 0;
      System.out.println(String.format("thetaValues[0][%d][1] = %d", m, thetaValues[0][m][1]));
    }

    for (int m = 2; m <= maxM; m++) {
      // At each step, we are calculating the thetaValues for n
      for (int n = 1; n <= maxN; n++) {
        // Allocate an array containing mˆn + 1 elements, that can be indexed from 0 to mˆn.
        thetaValues[n][m] = new long[power(m, n) + 1];
        for (int l = 0; l <= power(m, n); l++) {
          System.out.print(String.format("thetaValues[%d][%d][%d] = ", n, m, l));
          int lPrime = l - k(n, m, l) * power(m, n - 1);
          int correctionFactor;
          if (q(n - 1, m, lPrime) <= k(n, m, l)) {
            correctionFactor = -q(n - 1, m, lPrime);
          } else {
            correctionFactor = q(n - 1, m, lPrime) - 2 * k(n, m, l) - 1;
          }
          thetaValues[n][m][l]
              = k(n, m, l) * (m - k(n, m, l))
              + thetaValues[n - 1][m][lPrime]
              + correctionFactor;

          // Sanity check!
          if (thetaValues[n][m][l] < 0) {
            throw new IllegalStateException("negative theta value");
          }
          System.out.println(thetaValues[n][m][l]);
        }
        // Check that the theta values are symmetric in l.
        for (int l = 0; l <= power(m, n) / 2; l++) {
          if (thetaValues[n][m][l] != thetaValues[n][m][power(m, n) - l]) {
            throw new IllegalStateException("Values calculated for theta aren't symmetric in l!");
          }
        }
      }
    }
    return thetaValues;
  }

  // Lemma 1 of the paper defines k(n, m, l).
  static int k(int n, int m, int l) {
    if (n < 1 || m < 2 || l < 0 || l > power(m, n)) {
      throw new IllegalArgumentException(String.format("n:%d m:%d l:%d", n, m, l));
    }
    return Math.floorDiv(l, power(m, n - 1));
  }

  // Lemma 2 of the paper defines q(n, m, l).
  static int q(int n, int m, int l) {
    if (n < 0 || m < 2 || l < 0 || l > power(m, n)) {
      throw new IllegalArgumentException(String.format("n:%d m:%d l:%d", n, m, l));
    }
    if (n == 0 && (l == 0 || l == 1)) {
      return 0;
    } else {
      return 1 + Math.floorDiv((l - 1) * (m - 1), power(m, n) - 1);
    }
  }

  // Definition 5 in the paper defines sigma(int n, int m, int l0, int l1)
  static int sigma(int n, int m, int l0, int l1) {
    if (!(l1 >= 0 && l0 >= l1 && power(m, n) >= l0)) {
      throw new IllegalArgumentException(
          String.format(" sigma(n:%d, m:%d, l0:%d, l1:%d)", n, m, l0, l1));
    }

    if (l0 + l1 < power(m, n)) {
      return sigma1(n, m, l0, l1);
    } else if (l0 + l1 > power(m, n)) {
      return sigma2(n, m, l0, l1);
    }
// l0 + l1 == power(m, n))
// Verify that the value of both formulas is the same
    int sigma1 = sigma1(n, m, l0, l1);
    int sigma2 = sigma2(n, m, l0, l1);
    if (sigma1 != sigma2) {
      throw new IllegalArgumentException(
          String.format("Different values for sigma(n:%d, m:%d, l0:%d, l1:%d): sigma1:%d sigma2: %d, ",
              sigma1, sigma2, n, m, l0, l1)
      );
    }
    return sigma2;
  }

  private static int sigma2(int n, int m, int l0, int l1) {
    return q(n, m, l1) - q(n, m, l0 + l1 - power(m, n)) + (m - q(n, m, l0));
  }

  private static int sigma1(int n, int m, int l0, int l1) {
    return q(n, m, l1) + (q(n, m, l0 + l1) - q(n, m, l0));
  }

  static int power(int base, int exponent) {
    if (exponent < 0) {
      throw new IllegalArgumentException("exponent:" + exponent);
    }
    if (powerValues==null) {
      // calculate all the necessary values once
      powerValues = powerValues(MAX_M_N);
    }
    return powerValues[base][exponent];
  }

  private static int[][] powerValues(int maxPower) {
    int[][] values = new int[maxPower+1][maxPower+1];
    for (int base = 1; base <= maxPower; base++) {
      // We're defining base^0 to be equal to 1;
      values[base][0] = 1;
      for (int exponent = 1; exponent <= maxPower; exponent++) {
        values[base][exponent] = base * values[base][exponent - 1];
      }
    }
    return values;
  }

}
