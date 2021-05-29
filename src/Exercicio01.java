public class Exercicio01 {

    public static void main(String args[]) throws Exception {
        if (args.length < 1) {
            throw new Exception("Passe o número de rainhas como argumento");
        }

        int n = Integer.parseInt(args[0]);

        executar(n);
    }

    private static void executar(int n) {
        if (n >= 2) {
            iniciar(n);
        } else {
            System.out.println("Valor de n deve ser maior que 2");
        }
    }

    private static boolean iniciar(int n) {
        int[][] tabuleiro = new int[n][n];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                tabuleiro[i][j] = 0;
            }
        }

        if (possuiSolucao(tabuleiro, 0) == false) {
            System.out.print("Solution does not exist");
            return false;
        }

        imprimir(tabuleiro, n);

        return true;
    }


    private static boolean posicaoValida(int[][] tabuleiro, int linha, int coluna, int n) {

        for (int i = 0; i < coluna; i++) {
            if (tabuleiro[linha][i] == 1) {
                return false;
            }
        }

        for (int i = linha, j = coluna; i >= 0 && j >= 0; i--, j--) {
            if (tabuleiro[i][j] == 1)
                return false;
        }

        for (int i = linha, j = coluna; j >= 0 && i < n; i++, j--) {
            if (tabuleiro[i][j] == 1)
                return false;
        }

        return true;
    }

    private static boolean possuiSolucao(int[][] tabuleiro, int n) {
        return possuiSolucao(tabuleiro, 0, n);
    }

    private static boolean possuiSolucao(int tabuleiro[][], int coluna, int n) {

        if (coluna >= n) {
            return true;
        }

        for (int i = 0; i < n; i++) {
            if (posicaoValida(tabuleiro, i, coluna, n)) {

                tabuleiro[i][coluna] = 1;

                if (possuiSolucao(tabuleiro, coluna + 1)) {
                    return true;
                }

                tabuleiro[i][coluna] = 0;
            }
        }

        return false;
    }


    private static void imprimir(int[][] tabuleiro, int n) {
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++)
                if (tabuleiro[i][j] == 0) {
                    System.out.print("| |");
                } else {
                    System.out.print("|Q|");
                }
            System.out.println();
        }
    }


}
