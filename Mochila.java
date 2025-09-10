/*  3) Resolva o problema da mochila conforme o enuciado em sala de aula.

Ache uma solução que testa todas as combinações possíveis e seleciona a melhor, aplicando divisão-e-conquista ou não;
Contabilize o número de iterações;
Implemente e teste sua solução, para o caso exposto em aula e outros de mesmo porte (;-)).  */

public class Mochila {
    int preco [] = new int[5];
    int peso [] = new int[5];
    static long iteracoes = 0;
    static long instrucoes = 0;

    public static void main(String[] args) {
    // Teste 1 (exemplo menor)
    int preco1[] = {4, 2, 10, 1, 2};
    int peso1[] = {12, 1, 4, 1, 2};
    int weight1 = 15;

    runTest("Força Bruta", 1, preco1, peso1, weight1);
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
        iteracoes++;
        instrucoes++;
        int maxValor = 0;
        int totalCombinacoes = 1 << n;

        for (int i = 0; i < totalCombinacoes; i++) {
            int pesoAtual = 0;
            int valorAtual = 0;

            for (int j = 0; j < n; j++) {
                instrucoes++;
                if ((i & (1 << j)) > 0) {
                    pesoAtual += peso[j];
                    valorAtual += preco[j];
                }
            }
            if (pesoAtual <= W && valorAtual > maxValor) {
                maxValor = valorAtual;
            }
        }

        return maxValor;
    }

}
