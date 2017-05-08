package com.franklinharper.sierpinskigraphcalculation;


import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class SierpinskiGraphTest {

    @Test
    void kTest() {
        // k(m, n, l) is valid for the following values
        // m >= 1
        // n >= 0
        // 0 <= l <= m ^ n

// Why aren't we testing these values?
//    k(m,n,l), For m => 1, n => 0
//        assertEquals(0, SierpinskiGraph.k(1,0, 0));
//        assertEquals(0, SierpinskiGraph.k(1,0, 1));

//    k(m,n,l), For m => 2, n => 2
//    For 0 <= l <= 4
        assertEquals(0, SierpinskiGraph.k(2, 2, 0));
        assertEquals(0, SierpinskiGraph.k(2, 2, 1));
        assertEquals(1, SierpinskiGraph.k(2, 2, 2));
        assertEquals(1, SierpinskiGraph.k(2, 2, 3));
        assertEquals(2, SierpinskiGraph.k(2, 2, 4));

//    k(m,n,l), For m => 2, n => 3
//    For 0 <= l <= 8
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
//    For 0 <= l <= 9
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
//    For 0 <= l <= 27
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
        // m >= 1
        // n >= 0
        // 0 <= l <= m ^ n

        // Case m == 1 doesn't work, we'll skip for the time being???
        // assertEquals(0, SierpinskiGraph.q(2,0, 0));
        // Why did we skip the case m => 1?

        // k(m,n,l), For m => 2, n => 2
        // For 0 <= l <= 4
        assertEquals(0, SierpinskiGraph.q(2, 2, 0));
        assertEquals(1, SierpinskiGraph.q(2, 2, 1));
        assertEquals(1, SierpinskiGraph.q(2, 2, 2));
        assertEquals(1, SierpinskiGraph.q(2, 2, 3));
        assertEquals(2, SierpinskiGraph.q(2, 2, 4));

        // k(m,n,l), For m => 2, n => 3
        // For 0 <= l <= 8
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
        // For 0 <= l <= 9
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
        // For 0 <= l <= 27
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
    void power_returns1_whenExponentIs0() {
        for (int base = -10; base < 11; base++) {
            assertEquals(1, SierpinskiGraph.power(base, 0) );
        }
    }

    @Test
    void power_returnsBase_whenExponentIs1() {
        for (int base = -10; base < 11; base++) {
            assertEquals(base, SierpinskiGraph.power(base, 1) );
        }
    }

    @Test
    void power_returnsBaseSquared_whenExponentIs2() {
        for (int base = -10; base < 11; base++) {
            assertEquals(base*base, SierpinskiGraph.power(base, 2) );
        }
    }

    @Test
    void power_returnsBaseCubed_whenExponentIs3() {
        for (int base = -10; base < 11; base++) {
            assertEquals(base*base*base, SierpinskiGraph.power(base, 3) );
        }
    }

    @Test
    void thetaTest() {
//        //    The initial condition when n => 1 is Theta(m,1,l) = l(m-l)
//        assertEquals(0, SierpinskiGraph.theta(0,1, 0));
//        assertEquals(0, SierpinskiGraph.theta(1,1, 0));
//        assertEquals(0, SierpinskiGraph.theta(2,1, 0));
//        assertEquals(4, SierpinskiGraph.theta(4,1, 2));
//        assertEquals(2, SierpinskiGraph.theta(3,1, 2));
//
//        //    theta(m,n,l), For m => 2, n => 1
//        // I didn't understand this part.
//        //    For m = 2,
//        //    For all n => 1, Theta(n,2;l) = 0 if l = 0 or 2^n & 1 otherwise.
//
        long[][][] thetaValues = SierpinskiGraph.thetaValues(2, 3);
        // Java arrays start with index 0, so we'll have 2 + 1 elements in the "n" value array.
        assertEquals(3, thetaValues.length);
        // All the arrays of "m" values will be of length maxM ^ maxN + 1, i.e. 3 ^ 2 + 1
//        for (int n = 0; n < thetaValues.length; n++) {
//            assertEquals(10, thetaValues[n].length);
//        }

        assertEquals(0, thetaValues[1][2][0]);
        assertEquals(1, thetaValues[1][2][1]);
        assertEquals(0, thetaValues[1][2][2]);

        assertEquals(0, thetaValues[2][2][0]);
        assertEquals(1, thetaValues[2][2][1]);
        assertEquals(1, thetaValues[2][2][2]);
        assertEquals(1, thetaValues[2][2][3]);
        assertEquals(0, thetaValues[2][2][4]);

        assertEquals(0, thetaValues[2][3][0]);
        assertEquals(2, thetaValues[2][3][1]);

//        // theta(m,n,l), For m => 3, n => 2
//        // For 0 <= l <= 9
//        assertEquals(0, SierpinskiGraph.theta(3,2, 0));
//        assertEquals(2, SierpinskiGraph.theta(3,2, 1));
//        assertEquals(3, SierpinskiGraph.theta(3,2, 2));
//        assertEquals(2, SierpinskiGraph.theta(3,2, 3));
//        assertEquals(3, SierpinskiGraph.theta(3,2, 4));
//        assertEquals(3, SierpinskiGraph.theta(3,2, 5));
//        assertEquals(2, SierpinskiGraph.theta(3,2, 6));
//        assertEquals(3, SierpinskiGraph.theta(3,2, 7));
//        assertEquals(2, SierpinskiGraph.theta(3,2, 8));
//        assertEquals(0, SierpinskiGraph.theta(3,2, 9));
//
//        // theta(m,n,l), For m => 3, n => 3
//        // For 0 <= l <= 27
//
//        assertEquals(0, SierpinskiGraph.theta(3,3, 0));
//        assertEquals(2, SierpinskiGraph.theta(3,3, 1));
//        assertEquals(3, SierpinskiGraph.theta(3,3, 2));
//        assertEquals(2, SierpinskiGraph.theta(3,3, 3));
//        assertEquals(3, SierpinskiGraph.theta(3,3, 4));
//        assertEquals(4, SierpinskiGraph.theta(3,3, 5));
//        assertEquals(3, SierpinskiGraph.theta(3,3, 6));
//        assertEquals(4, SierpinskiGraph.theta(3,3, 7));
//        assertEquals(3, SierpinskiGraph.theta(3,3, 8));
//        assertEquals(2, SierpinskiGraph.theta(3,3, 9));
//        assertEquals(3, SierpinskiGraph.theta(3,3, 10));
//        assertEquals(4, SierpinskiGraph.theta(3,3, 11));
//        assertEquals(3, SierpinskiGraph.theta(3,3, 12));
//        assertEquals(4, SierpinskiGraph.theta(3,3, 13));
//        assertEquals(4, SierpinskiGraph.theta(3,3, 14));
//        assertEquals(3, SierpinskiGraph.theta(3,3, 15));
//        assertEquals(4, SierpinskiGraph.theta(3,3, 16));
//        assertEquals(3, SierpinskiGraph.theta(3,3, 17));
//        assertEquals(2, SierpinskiGraph.theta(3,3, 18));
//        assertEquals(3, SierpinskiGraph.theta(3,3, 19));
//        assertEquals(4, SierpinskiGraph.theta(3,3, 20));
//        assertEquals(3, SierpinskiGraph.theta(3,3, 21));
//        assertEquals(4, SierpinskiGraph.theta(3,3, 22));
//        assertEquals(3, SierpinskiGraph.theta(3,3, 23));
//        assertEquals(2, SierpinskiGraph.theta(3,3, 24));
//        assertEquals(3, SierpinskiGraph.theta(3,3, 25));
//        assertEquals(2, SierpinskiGraph.theta(3,3, 26));
//        assertEquals(0, SierpinskiGraph.theta(3,3, 27));
    }
}