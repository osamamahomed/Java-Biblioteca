package classe;

public class Visitante extends Usuario{

    //construtor
    public Visitante(){}
    public Visitante(int id, String nome){
        super(id,nome);
    }

    @Override
    public int getLimiteEmprestimos() {
        return 0;
    }

    @Override
    public int getPrazoEmprestimoDias() {
        return 0;
    }
}
