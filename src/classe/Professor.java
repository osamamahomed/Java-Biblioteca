package classe;

public class Professor extends Usuario{

    //construtor
    public Professor(){}
    public Professor(int id, String nome){
        super(id, nome);
    }

    @Override
    public int getLimiteEmprestimos() {
        return 5;
    }

    @Override
    public int getPrazoEmprestimoDias() {
        return 10;
    }
}
