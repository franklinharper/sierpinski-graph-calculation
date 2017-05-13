package com.franklinharper.sierpinskigraphcalculation;

public class SierpinskiGraph {

  static final int MAX_M = 12;

  public static void main(String[] args) {

    for (int m = 2; m <= MAX_M; m++) {
      for (int n = 1; n <= MAX_M - m; n++) {
        System.out.println(String.format("Calculating thetaValues for n:%d m:%d", n, m));
        long[][][] thetaValues = thetaValues(n, m);
        System.out.println("verifying inequality");
        for (int l0 = 0; l0 <= power(m, n); l0++) {
          for (int l1 = 0; l1 <= l0; l1++) {
            boolean verified;
            if (l0 + l1 <= power(m, n)) {
              verified =
                  thetaValues[n][m][l0 + l1] + sigma(n, m, l0, l1)
                      <= thetaValues[n][m][l0] + thetaValues[n][m][l1];
            } else {
              verified =
                  thetaValues[n][m][l0 + l1 - power(m, n)] + sigma(n, m, l0, l1)
                      <= thetaValues[n][m][l0] + thetaValues[n][m][l1];
            }
            if (!verified) {
              System.out.println(String.format(
                  "inequality not verified for n:%d m:%d l0:%d l1:%d", n, m, l0, l1));
              throw new IllegalStateException();
            }
          }
        }
      }
    }
  }

  // Returns an array containing the calculated values of the function
  // theta.
  //
  // The first array index is n.
  // The second array index is m.
  // The second array index is l.
  //
  static long[][][] thetaValues(int maxN, int maxM) {

    long[][][] thetaValues = new long[maxN + 1][maxM + 1][];

    for (int m = 2; m <= maxM; m++) {
      thetaValues[0][m] = new long[2];
      thetaValues[0][m][0] = 0;
      thetaValues[0][m][1] = 0;
    }

    for (int m = 2; m <= maxM; m++) {
      // At each step, we are calculating the thetaValues for n
      for (int n = 1; n <= maxN; n++) {
        thetaValues[n][m] = new long[power(m, n) + 1];
        for (int l = 0; l <= power(m, n); l++) {
//          System.out.print(String.format("thetaValues[%d][%d][%d] = ", n, m, l));
          int lPrime = l - k(n, m, l) * power(m, n -1);
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
//          System.out.println(thetaValues[n][m][l]);
        }

        // Check that the theta values are symmetric in l.
        for (int l = 0; l <= power(m, n) / 2; l++) {
          if ( thetaValues[n][m][l] != thetaValues[n][m][power(m, n) - l]) {
            throw new IllegalStateException("theta values aren't symmetric");
          }
        }
      }
    }
    return thetaValues;
  }

  static int k(int n, int m, int l) {
    if (n < 1 || m < 2 || l < 0 || l > power(m, n)) {
      throw new IllegalArgumentException(String.format("n:%d m:%d l:%d", n, m, l));
    }
    return Math.floorDiv(l, power(m, n - 1));
  }

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

  static int sigma(int n, int m, int l0, int l1) {
    if (!(l1 >= 0 && l0 >= l1 && power(m, n) >= l0)) {
      throw new IllegalArgumentException(
          String.format(" sigma(n:%d, m:%d, l0:%d, l1:%d)", n, m, l0, l1));
    }
    if (l0 + l1 <= power(m,n)) {
      return q(n, m, l1) + (q(n, m, l0 + l1) - q(n, m, l0));
    } else {
      return q(n, m, l1) - (q(n, m, l0 + l1 - power(m,n)) + (m -  q(n, m, l0)));
    }
  }

  static int power(int base, int exponent) {
    if (exponent < 0) {
      throw new IllegalArgumentException("exponent:" + exponent);
    }

    // We're defining x ^ 0 to be equal to 1;
    int result = 1;
    for (int i = 1; i <= exponent; i++) {
      result *= base;
    }
    return result;
  }

}
