package com.franklinharper.sierpinskigraphcalculation;

public class SierpinskiGraph {

  static final int MAX_M = 12;
  static final int MAX_N = 12;

  public static void main(String[] args) {

//        for (long l = 0; l < 10; l++) {
//            System.out.println(String.format("    theta(3,2,%d):%d", l, theta(3, 2, l)));
//        }
//        for (long m = 2; m < 13; m++) {
//            for (long n = 1; n < 13; n++) {
//                if (m + n < 13)
//                    for (long l = 1; l < 3; l++) {
//                        System.out.println(String.format("m:%d, n:%d, l:%d", m, n, l));
//                        System.out.println(String.format("    k(m,n,l):%d", k(m, n, l)));
//                        System.out.println(String.format("    q(m,n,l):%d", q(m, n, l)));
//                    }
//            }
//        }
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

    System.out.println("----------------------------------");
    System.out.println("Calculating thetaValues[n][m][l]");
    System.out.println("----------------------------------");
    System.out.println("Initial condition");
    for (int m = 2; m <= maxM; m++) {
      thetaValues[0][m] = new long[2];
      thetaValues[0][m][0] = 0;
      System.out.println(String.format("thetaValues[0][%d][0] = 0", m));
      thetaValues[0][m][1] = 0;
      System.out.println(String.format("thetaValues[0][%d][1] = 0", m));
    }
    System.out.println("---- End of initial condition ----");

    for (int m = 2; m <= maxM; m++) {
      // At each step, we are calculating the thetaValues for n
      for (int n = 1; n <= maxN; n++) {
        thetaValues[n][m] = new long[power(m, n) + 1];
        for (int l = 0; l <= power(m, n); l++) {
          System.out.print(String.format("thetaValues[%d][%d][%d] = ", n, m, l));
          int lPrime = l - k(n, m, l) * power(m, n -1);
          int correctionFactor;
          if (q(n - 1, m, lPrime) <= k(n, m, l)) {
            correctionFactor = -q(n - 1, m, lPrime);
          } else {
            correctionFactor = q(n - 1, m, lPrime) - 2 * k(n, m, l);
          }
          thetaValues[n][m][l]
              = k(n, m, l) * (m - k(n, m, l))
              + thetaValues[n - 1][m][lPrime]
              + correctionFactor;
          System.out.println(thetaValues[n][m][l]);
        }
      }
    }
    return thetaValues;
  }

//    static long theta(long m, long n, long l) {
//        // m >= 2
//        // n >= 1
//        // l between 0 and mˆn
//        if (l < 0 || l > power(m, n)) {
//            throw new IllegalArgumentException(String.format("m:%d n:%d l:%d", m, n, l));
//        }
//        long result;
//        if (n == 1) {
//            result = l * (m - l);
//        } else {
//            long lPrime = l - k(m, n, l) * power(m, n - 1);
//            long q = q(m, n - 1, lPrime);
//            long correctionFactor;
//            if (q <= k(m, n, l)) {
//                correctionFactor = -q(m, n-1, lPrime);
//            } else {
//                correctionFactor = q(m, n -1, lPrime) - 2 * k(m, n, l);
//            }
//            result = k(m, n, l) * (m - k(m, n, l)) + correctionFactor + theta(m, n - 1, lPrime);
//        }
////        System.out.println(String.format("    theta(%d,%d,%d):%d", m, n, l, result));
//        return result;
//    }

  static int k(int n, int m, int l) {
    if (n < 1) {
      throw new IllegalArgumentException("n:" + n);
    }
    return Math.floorDiv(l, power(m, n - 1));
  }

  static int q(int n, int m, int l) {
    if (n < 0) {
      throw new IllegalArgumentException("n:" + n);
    }
    if (m < 2) {
      throw new IllegalArgumentException("m:" + m);
    }
    if (l < 0 || l > power(m, n)) {
      throw new IllegalArgumentException(String.format("m:%d n:%d l:%d", m, n, l));
    }
    if (m >= 2 && n == 0 && (l == 0 || l == 1)) {
      return 0;
    } else {
      return 1 + Math.floorDiv((l - 1) * (m - 1), power(m, n) - 1);
    }
  }

  static int power(long base, long exponent) {
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

//  private static void print(long[][][] thetaValues, int n, int m) {
//    System.out.print(String.format("thetaValues[n:%d][m:%d] = [ ", n, m));
//    for (int l = 0; l < thetaValues[n][m].length; l++) {
//      System.out.print(String.format("%d:%d, ", l, thetaValues[n][m][l]));
//    }
//    System.out.println("]");
//  }

}
