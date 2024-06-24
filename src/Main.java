import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        double[] valores = new double[10];
        int tamanhoArray = entradaNumerosNaLista(valores);
        contaOcorrencias(valores);
        double media = calculaMedia(valores, tamanhoArray);
        System.out.println("A média dos numeros digitados: " + media + "\n");
        System.out.println("Valores iguais ou acima da média: ");
        mostraValoresAcimaMedia(valores, media);
    }
    public static void mostraValoresAcimaMedia(double[] valores, double media) {
        for (double valor : valores) {
            if (valor >= media) {
                System.out.println(valor);
            }
        }
    }
    public static double calculaMedia(double[] valores, int tamanhoArray){
        double soma = 0;
        for (int i = 0; i < tamanhoArray; i++) {
            soma += valores[i];
        }
        if (tamanhoArray == 0) {
            return 0.0;
        } else {
            return soma / tamanhoArray;
        }
    }
    public static double entrarDouble(String msg) {
        Scanner entrada = new Scanner(System.in);
        double num = 0;
        while (true) {
            System.out.println(msg);
            try {
                num = entrada.nextDouble();
                break;
            } catch (InputMismatchException e) {
                System.out.println("Erro: Apenas números reais são permitidos");
                entrada.nextLine();
            }
        }
        entrada.close();
        return num;
    }
    public static void contaOcorrencias(double[] valores) {
        double num = entrarDouble("Agora informe o numero que você quer verificar quantas ocorrencias existem");
        int contador = 0;
        for (double valor : valores) {
            if (valor == num) {
                contador++;
            }
        }
        System.out.println("O numero de ocorrencias do numero " + num + ": " + contador + " vezes.\n");
    }
    public static int entradaNumerosNaLista(double[] numeros) {
        double num;
        int indice = 0;
        while (true) {
            if (indice == numeros.length) {
                System.out.println("Apenas 10 números permitidos.");
                break;
            }
            num = entrarDouble("Informe um número ou 0 para sair: ");
            if (num == 0) {
                break;
            }
            numeros[indice] = num;
            indice++;
        }
        return indice;
    }
}
