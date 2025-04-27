package classe;

public class Estudante extends Usuario{

    //construtor
    public Estudante(){}
    public Estudante(int id, String nome){
        super(id, nome,3);
    }

    //metodo extendido da classe usuario
    @Override
    public int getLimiteEmprestimos() {
        return 3;
    }

    @Override
    public int getPrazoEmprestimoDias() {
        return 5;
    }
}
