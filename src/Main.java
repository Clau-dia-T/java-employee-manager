//Importacoes
import java.text.DecimalFormat;
import java.util.Locale;
import java.util.Scanner;


public class Main {

    //Variaveis globais
    public static DecimalFormat df = new DecimalFormat("0.00");
    public static Scanner input_texto = new Scanner(System.in);
    public static Scanner input_numerico = new Scanner(System.in);
    public static final int TEMPO = 350;


    public static void main(String[] args) {
        Locale.setDefault(Locale.US);
        input_numerico = new Scanner(System.in);

        //Variaveis locais
        int opcao = 0;

        //Executar
        RecursosHumanos._temp();

        do{
            limpar();
            exibirMenu();
            opcao = input_numerico.nextInt();

            switch (opcao){
                case 1: RecursosHumanos.registarColaborador(); break;
                case 2: RecursosHumanos.editarColaborador(); break;
                case 3: RecursosHumanos.pesqColNome(); break;
                case 4: RecursosHumanos.despedirColaborador(); break;
                case 5: RecursosHumanos.listarColaboradores(); break;
                case 6: RecursosHumanos.listaPorSal(); break;
                case 7: RecursosHumanos.pesquBalizaSal(); break;
                case 8: RecursosHumanos.listarDespesas(); break;
                case 0: sair(); break;
                default: exibirMensagem(1); carregueEnter(); break;
            }

        }while(opcao != 0);
    }

    //Funcoes
    public static void exibirMenu(){
        System.out.println("=== Gestor de Colaboradores ===\n");
        System.out.println("1 - Registar novo colaborador. ");
        System.out.println("2 - Editar colaborador.");
        System.out.println("3 - Pesquisar colaborador por nome.");
        System.out.println("4 - Despedir colaborador.");
        System.out.println("5 - Listar colaboradores.\n");

        System.out.println("6 - Listar colaboradores por ordem salarial.\n");

        System.out.println("7 - Pesquisar colaborador por baliza salarial.");
        System.out.println("8 - Despesas com colaboradores.\n");

        System.out.println("0 - Logout.\n");

        System.out.print("Opção: ");
    }
    public static void exibirSubMenu(String submenu){
        System.out.println("--- "+submenu+" ---\n");
    }
    public static void exibirMensagem(int m){
        switch (m){
            case 1: System.out.println("\n--- Valor inválido! ---\n"); break;
            case 2: System.out.println("\n--- SUCESSO! ---\n"); break;
            case 3: System.out.println("\n--- Sem colaboradores registados ---\n"); break;
            case 4: System.out.println("\n--- Opcão inválida! ---\n"); break;
        }
    }
    public static void sair(){
        limpar();
        System.out.print("A sair");
        aguarde(TEMPO);
        System.out.print(".");
        aguarde(TEMPO);
        System.out.print(".");
        aguarde(TEMPO);
        System.out.print(".");
        aguarde(TEMPO);
    }
    public static void aguarde(int ms){
        try{
            Thread.sleep(ms);
        }
        catch (Exception e){
            e.printStackTrace();
        }
    }
    public static void carregueEnter() {
        System.out.print("Carregue <enter> para continuar...");
        input_texto.nextLine();
    }
    public static void limpar(){
        for (int i = 0; i < 25; i++) {
            System.out.println();
        }
    }
}