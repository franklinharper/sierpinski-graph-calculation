# Verification of the Sierpinski graph inequality
 
This code is part of the paper published on Arxiv (add link).

### Pre-requisites
To run this code you will need to have the Java SDK installed.

### Tests
From the top level directory typing `./run_tests.sh` (on a Mac or Linux), will run tests checking that the calculation gives the expected results for small values of N and M.

When all the tests are successful the output will end with
```
[        12 tests successful      ]
[         0 tests failed          ]
```

### Verification calculation
To run the verification calculation type `./run_verification.sh` while in the top level directory.

The output will end with
> Conjecture verified for all n, m  
> such that n >= 2, n >= 1,  
> and n + m <= 13
