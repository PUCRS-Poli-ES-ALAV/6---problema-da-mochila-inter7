// 1. Dadas as três versões de implementação de Fibonacci abaixo:

//     * implemente os algortimos;
//     * teste todos para os inteiros 4, 8, 16, 32; 
//     * teste os dois últimos também para os inteiro 128, 1000 e 10.000.

//    ```java
//    FIBO-REC (n)
//       se n ≤ 1
//       então devolva n
//       senão a ← FIBO-REC (n − 1)
//             b ← FIBO-REC (n − 2)
//             devolva a + b
//    ```

//    ```java
//    FIBO (n)
//         f [0] ← 0 
// 	f [1] ← 1
// 	para i ← 2 até n faça
//            f[i] ← f[i-1]+f[i-2]
//   	devolva f [n]
//    ```

//    ```java
//    MEMOIZED-FIBO (f, n)
// 	para i ← 0 até n faça
// 	     f [i] ← −1
// 	devolva LOOKUP-FIBO (f, n)

//    LOOKUP-FIBO (f, n)
// 	se f [n] ≥ 0
//         então devolva f [n]
// 	se n ≤ 1
// 	então f [n] ← n
// 	senão f [n] ← LOOKUP-FIBO(f, n − 1) + LOOKUP-FIBO(f, n − 2)
// 	devolva f [n]
//    ``` 
public class fibo {
public static void main(String[] args) {
    int[] testValues = {4, 8, 16, 32, 128, 1000, 10000};
    for (int n : testValues) {
        int[] f = new int[n+1];
        System.out.println("FIBO-REC(" + n + ") = " + fiboRec(n));
        System.out.println("FIBO2(" + n + ") = " + fibo2(n));
        System.out.println("MEMOIZED-FIBO(" + n + ") = " + memorizedFibo(f, n));
    }
}

    public static int fiboRec(int n) {
        if (n <= 1)
            return n;
        else {
            int a = fiboRec(n - 1);
            int b = fiboRec(n - 2);
            return a + b;
        }
    }

    public static int fibo2(int n) {
        int[] f = new int[n + 1];
        f[0] = 0;
        f[1] = 1;
        for (int i = 2; i <= n; i++) {
            f[i] = f[i - 1] + f[i - 2];
        }
        return f[n];
    }

    public static int memorizedFibo(int[] f, int n) {
        for (int i = 0; i <= n; i++) {
            f[i] = -1;
        }
        return lookupFibo(f, n);
    }

    public static int lookupFibo(int[] f, int n) {
        if (f[n] >= 0)
            return f[n];
        if (n <= 1)
            return f[n] = n;
        else {
            f[n] = lookupFibo(f, n - 1) + lookupFibo(f, n - 2);
            return f[n];
        }
    }
}