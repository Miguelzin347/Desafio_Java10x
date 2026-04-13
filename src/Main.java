import java.util.Scanner;
    public class Desafioninja {
        public static void main(String[] args) {


            Scanner scanner = new Scanner(System.in);


            int option = 10;
            String[] ninja = new String[10];
            int i = 0;
            while(option !=0 || i > 9)
            {
                System.out.println("Digite a opção que você quer seguir: ");
                System.out.println("1 - Cadastrar o ninja");
                System.out.println("2 - Mostrar os ninjas cadastrados");
                System.out.println("0 - Pra Sair");


                option = sc.nextInt();
                sc.nextLine();




                switch (option)
                {
                    case 1:
                        System.out.println("Digite o nome do seu ninja: ");
                        ninja[i] = sc.nextLine();
                        i++;



                        break;
                    case 2:
                        System.out.println("A lista de Ninjas cadastrados: ");
                        for(int j = 0 ; ninja[j]!= null ; j++)
                        {
                            System.out.println(ninja[j]);
                        }

                        break;


                    default:

                        break;
                }


            }


            System.out.println("Você selecionou a opção de sair ou a lista de ninjas acabou!");
            System.out.println("A Lista de ninjas atualizada: ");


            for(int j = 0 ; ninja[j] != null ; j++)
            {
                System.out.println(ninja[j]);


            }

        }

    }

}