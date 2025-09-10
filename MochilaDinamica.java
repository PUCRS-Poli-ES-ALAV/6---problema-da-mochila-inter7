public class MochilaDinamica {
    static long iteracoes = 0;
    static long instrucoes = 0;

    public static void main(String[] args) {
        // Teste 1 (exemplo menor)
        int preco1[] = {4, 2, 10, 1, 2};
        int peso1[] = {12, 1, 4, 1, 2};
        int weight1 = 15;
        runTest("PD", 1, preco1, peso1, weight1);

    }

    static void runTest(String tag, int id, int preco[], int peso[], int W) {
        iteracoes = 0;
        instrucoes = 0;
        long t0 = System.nanoTime();
        int resultado = knapSack(W, peso, preco, preco.length);
        long tempoMs = (System.nanoTime() - t0) / 1_000_000;
        System.out.println("Teste " + id + " - " + tag);
        System.out.println(resultado + ", iteracoes = " + iteracoes + ", instrucoes = " + instrucoes + ", tempo = " + tempoMs + "ms");
        System.out.println("---------------");
    }

    static int knapSack(int W, int peso[], int preco[], int n) {
        int i, w;
        int K[][] = new int[n + 1][W + 1];

        for (i = 0; i <= n; i++) {
            for (w = 0; w <= W; w++) {
                iteracoes++;
                instrucoes++; // loop body
                if (i == 0 || w == 0) {
                    K[i][w] = 0;
                    instrucoes++;
                } else if (peso[i - 1] <= w) {
                    K[i][w] = Math.max(preco[i - 1] + K[i - 1][w - peso[i - 1]], K[i - 1][w]);
                    instrucoes += 2;
                } else {
                    K[i][w] = K[i - 1][w];
                    instrucoes++;
                }
            }
        }
        return K[n][W];
    }
}
