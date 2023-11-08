public class Colaborador {

    //Atributos
    private String nome;
    private int idade;
    private String cargo;
    private double salario;


    //Construtor
    public Colaborador(String nome, int idade, String cargo, double salario) {
        this.nome = nome;
        this.idade = idade;
        this.cargo = cargo;
        this.salario = salario;
    }

    //Metodos
    public String exibirColaborador(){
        return (this.nome + " (" + this.idade + " anos) - [" + this.cargo + "] {" + Main.df.format(this.salario) + " €}");
    }

    public String getNome(){
        return this.nome;
    }

    public void setNome(String nome){
        this.nome = nome;
    }

    public int getIdade(){
        return this.idade;
    }

    public void setIdade(int idade){
        this.idade = idade;
    }

    public String getCargo(){
        return this.cargo;
    }

    public void setCargo(String cargo){
        this.cargo = cargo;
    }

    public double getSalario(){
        return this.salario;
    }

    public void setSalario(double salario){
        this.salario = salario;
    }

}


