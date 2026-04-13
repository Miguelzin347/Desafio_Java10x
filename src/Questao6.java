import java.util.Scanner;
public class Questao6 {

    Scanner ler = new Scanner(System.in);
    System.out.println("Digite o seu primeiro valor: ");
    int valor1 = ler.nextInt();
    System.out.println("Digite o seu segundo valor: ");
    int valor2 = ler.nextInt();

    if(valor2==0){
        System.out.println("Digite outro valor não pode ser zero\n ");
        System.out.println("Digite o segundo valor novamente: ");
        int valor2 = ler.nextInt();

        int div = valor1/valor2;
        System.out.println("O valor da divisão dos dois numeros é: " + div);

    }


}
