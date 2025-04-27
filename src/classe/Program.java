package classe;

public class Program {
    public static void main(String[] args) {

        Funcionario f = new Funcionario();
        //Cadastrar Usuarios
        f.cadastrarUsuario(new Estudante(1,"Osama"));

        //Cadastrar Livros
        f.cadastrarLivro(new Livro("00-001","Java","Osama Dev", "Tecnologia",2017,5));
        f.realizarEmprestimos("00-001",1);


    }
}
