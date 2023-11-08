//Importacoes
import java.util.ArrayList;
import java.util.Scanner;
import java.util.Collections;
import java.util.Comparator;

public class RecursosHumanos extends Colaborador{

    //Atributos
    public static Scanner input_texto = new Scanner(System.in);
    public static Scanner input_numerico = new Scanner(System.in);
    public static ArrayList<Colaborador> colaboradores = new ArrayList<Colaborador>();
    public static int total = 0;
    public static int id_digitado;

    //Construtor
    public RecursosHumanos(String nome, int idade, String cargo, double salario){
        super(nome, idade, cargo, salario);
    }

    //Metodos
    public static void registarColaborador(){
        //Variaveis locais
        String nome_digitado;
        int idade_digitada;
        String cargo_digitado;
        double salario_digitado;

        //Executar
        Main.limpar();
        Main.exibirSubMenu("Novo Colaborador");
        System.out.print("Nome: ");
        nome_digitado = input_texto.nextLine();
        System.out.print("Idade: ");
        idade_digitada = input_numerico.nextInt();
        System.out.print("Cargo: ");
        cargo_digitado = input_texto.nextLine();
        System.out.print("Salário: ");
        salario_digitado = input_numerico.nextDouble();

        colaboradores.add(total, new Colaborador(nome_digitado, idade_digitada, cargo_digitado, salario_digitado));
        total++;

        Main.exibirMensagem(2);
        Main.carregueEnter();
    }

    public static void editarColaborador(){
        //Variaveis locais
        int opcao = 0;
        String nome_digitado;
        int idade_digitada;
        String cargo_digitado;
        double salario_digitado;

        //Executar
        Main.limpar();

        if(colaboradores.isEmpty()){
            Main.exibirMensagem(3);
            Main.carregueEnter();
        }
        else{
            Main.exibirSubMenu("Editar Colaborador");
            listar();
            System.out.print("\nDigite o id do colaborador a ser editado: ");
            id_digitado = input_numerico.nextInt();

            if(id_digitado <= 0 || id_digitado > colaboradores.size()){
                Main.exibirMensagem(1);
                Main.carregueEnter();
            }

            else{
                Main.limpar();

                System.out.println("=== " + colaboradores.get(id_digitado-1).exibirColaborador() + " ===\n");

                System.out.println("1 - Nome.");
                System.out.println("2 - Idade.");
                System.out.println("3 - Cargo.");
                System.out.println("4 - Salário.");

                System.out.print("\nSeleccione o que será editado neste colaborador: ");
                opcao = input_numerico.nextInt();

                switch (opcao){
                    case 1: editarNome(); break;
                    case 2: editarIdade(); break;
                    case 3: editarCargo(); break;
                    case 4: editarSalario(); break;
                    default: Main.exibirMensagem(4); Main.carregueEnter(); break;
                }
            }
        }
    }
    public static void editarNome(){
        //Variaveis locais
        String novo_nome;

        //Executar
        System.out.print("\nDigite o que irá substituir ("+ colaboradores.get(id_digitado - 1).getNome() +"): ");
        novo_nome = input_texto.nextLine();
        colaboradores.get(id_digitado - 1).setNome(novo_nome);
        System.out.println("\n=== " + colaboradores.get(id_digitado-1).exibirColaborador() + " ===");
        Main.exibirMensagem(2);
        Main.carregueEnter();
    }
    public static void editarIdade(){
        //Variaveis locais
        int nova_idade;

        //Executar
        System.out.print("\nDigite o que irá substituir ("+ colaboradores.get(id_digitado - 1).getIdade() +"): ");
        nova_idade = input_numerico.nextInt();

        if(nova_idade <= 0){
            Main.exibirMensagem(1);
            Main.carregueEnter();
        }
        else{
            colaboradores.get(id_digitado - 1).setIdade(nova_idade);
            System.out.println("\n=== " + colaboradores.get(id_digitado-1).exibirColaborador() + " ===");
            Main.exibirMensagem(2);
            Main.carregueEnter();
        }
    }
    public static void editarCargo(){
        //Variaveis locais
        String novo_cargo;

        //Executar
        System.out.print("\nDigite o que irá substituir ("+ colaboradores.get(id_digitado - 1).getCargo() +"): ");
        novo_cargo = input_texto.nextLine();
        colaboradores.get(id_digitado - 1).setCargo(novo_cargo);
        System.out.println("\n=== " + colaboradores.get(id_digitado-1).exibirColaborador() + " ===");
        Main.exibirMensagem(2);
        Main.carregueEnter();
    }
    public static void editarSalario(){
        //Variaveis locais
        Double novo_salario;

        //Executar
        System.out.print("\nDigite o que irá substituir ("+ colaboradores.get(id_digitado - 1).getSalario() +"): ");
        novo_salario = input_numerico.nextDouble();

        if(novo_salario <= 0){
            Main.exibirMensagem(1);
            Main.carregueEnter();
        }
        else{
            colaboradores.get(id_digitado - 1).setSalario(novo_salario);
            System.out.println("\n=== " + colaboradores.get(id_digitado-1).exibirColaborador() + " ===");
            Main.exibirMensagem(2);
            Main.carregueEnter();
        }
    }
    public static void pesqColNome(){
        //Variaveis locais
        String nome_digitado;
        boolean encontrado = false;

        //Executar
        Main.limpar();
        if(colaboradores.isEmpty()){
            Main.exibirMensagem(3);
            Main.carregueEnter();
        }
        else{
            Main.exibirSubMenu("Pesquisar Colaborador por Nome");
            System.out.print("Digite o nome a ser pesquisado: ");
            nome_digitado = input_texto.nextLine();
            System.out.println();

            for (int i = 0; i < total; i++) {
                if(nome_digitado.equalsIgnoreCase(colaboradores.get(i).getNome())){
                    System.out.println((i+1) + ") " + colaboradores.get(i).exibirColaborador() + "\n");
                    Main.carregueEnter();
                    encontrado = true;
                }
            }

            if(!encontrado){
                System.out.println("Colaborador não encontrado.\n");
                Main.carregueEnter();
            }
        }
    }
    public static void despedirColaborador(){
        //Variaveis locais
        String resposta;

        //Executar
        Main.limpar();

        if(colaboradores.isEmpty()){
            Main.exibirMensagem(3);
            Main.carregueEnter();
        }
        else{
            Main.exibirSubMenu("Despedir Colaborador");

            listar();
            System.out.print("\nDigite o código do colaborador a ser despedido: ");
            id_digitado = input_numerico.nextInt();
            System.out.print("\nTem a certeza desta operação? (s/n) ");
            resposta = input_texto.nextLine();
            System.out.println();

            if (resposta.equalsIgnoreCase("s")){
                colaboradores.remove(id_digitado-1);
                total--;
                listar();
            }

            System.out.println();
            Main.carregueEnter();
        }

    }
    public static void listarColaboradores(){
        Main.limpar();

        if(colaboradores.isEmpty()){
            Main.exibirMensagem(3);
            Main.carregueEnter();
        }
        else{
            Main.exibirSubMenu("Lista de Colaboradores Registados");
            listar();
            System.out.println();
            Main.carregueEnter();
        }
    }
    public static void listar(){
        for (int i = 0; i < total; i++){
            System.out.println((i+1) + ") " + colaboradores.get(i).exibirColaborador());
        }
    }
    public static double calcSalarios(){
        //Variaveis locais
        double total_salarios = 0;

        //Executar
        for (int i = 0; i < total; i++) {
            total_salarios +=  colaboradores.get(i).getSalario();
        }
        return total_salarios;
    }
    public static void listaPorSal(){
        //Variaveis locais
        ArrayList<Colaborador> ordemsalarial = new ArrayList<Colaborador>();

        //Executar
        Main.limpar();
        ordemsalarial.clear();
        ordemsalarial = colaboradores;

        Collections.sort(ordemsalarial, new Comparator<Colaborador>(){
            public int compare(Colaborador c1, Colaborador c2){
                return (Double.valueOf(c1.getSalario()).compareTo(c2.getSalario()));
            }
        });

        for (int i = 0; i < ordemsalarial.size(); i++){
            System.out.println((i+1) + ") " + ordemsalarial.get(i).exibirColaborador());
        }

        System.out.println();
        Main.carregueEnter();
    }
    public static void pesquBalizaSal(){
        //Variaveis locais
        double min;
        double max;
        double valor_digitado;

        //Executar
        Main.limpar();
        Main.exibirSubMenu("Pesquisa por baliza de salários");

        System.out.print("Digite o valor MINIMO de salário a ser pesquisado: ");
        min = input_numerico.nextDouble();
        System.out.print("Digite o valor MAXIMO de salário a ser pesquisado: ");
        max = input_numerico.nextDouble();
        System.out.println();

        for (int i = 0; i < total; i++) {
            if(colaboradores.get(i).getSalario() >= min && colaboradores.get(i).getSalario() <= max){
                System.out.println((i+1) + ") " +colaboradores.get(i).exibirColaborador());
            }
        }

        System.out.println();
        Main.carregueEnter();
    }
    public static void listarDespesas(){
        Main.limpar();

        if(colaboradores.isEmpty()){
            Main.exibirMensagem(3);
            Main.carregueEnter();
        }
        else{
            Main.exibirSubMenu("Lista de Colaboradores Registados");
            listar();
            System.out.println("\n--- TOTAL: (" + Main.df.format(calcSalarios()) + " €) ---");
            System.out.println();
            Main.carregueEnter();
        }
    }
    public static void _temp(){
        colaboradores.add(total, new Colaborador("Maria Lopes", 36, "Vendedora", 1560.30));
        total++;
        colaboradores.add(total, new Colaborador("Joana Marques", 45, "Contabilista", 1380.20));
        total++;
        colaboradores.add(total, new Colaborador("Jorge Pereira", 41, "Markting", 1530.00));
        total++;
        colaboradores.add(total, new Colaborador("Victor Valdez", 62, "Assistente operacional", 950.84));
        total++;
        colaboradores.add(total, new Colaborador("Alice Figueiredo", 32, "Gestora", 2050.00));
        total++;
    }
}
