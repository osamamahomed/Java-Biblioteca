package classe;

public abstract class Usuario {

    //Atributos
     private int id;
     private String nome;
     private Emprestimo[] emprestimoActivos;
     private int nrEmprestimosActivos;
     private boolean temMulta;
     //Construtor
     public Usuario(){}

     public Usuario(int id, String nome, int limiteEmprestimo){
         this.id=id;
      this.nome=nome;
      this.emprestimoActivos= new Emprestimo[limiteEmprestimo];
      this.nrEmprestimosActivos=0;
      this.temMulta = false;
     }

    public Usuario(int id, String nome) {
         this.id=id;
         this.nome=nome;
    }

    //GEt e Set
     public String getNome(){
         return nome;
     }
     public Emprestimo[] getEmprestimoActivos(){
         return emprestimoActivos;
     }
     public int getNrEmprestimosActivos(){
         return nrEmprestimosActivos;
     }
     public boolean isTemMulta() {
         return temMulta;
    }
    public int getId(){
         return id;
    }
    public void setTemMulta(boolean temMulta) {
        this.temMulta = temMulta;
    }

    //Metodos abstratos(declarados mais nao implementados)
     public abstract int getLimiteEmprestimos();
     public abstract int getPrazoEmprestimoDias();

     //Metodos Concretos
    public boolean podeFazerEmprestimo(){
        return nrEmprestimosActivos < getLimiteEmprestimos() && !temMulta;
    }
    public void adicionarEmprestimo(Emprestimo emprestimo){
        if (nrEmprestimosActivos<emprestimoActivos.length){
            emprestimoActivos[nrEmprestimosActivos++]=emprestimo;
        }
    }
    public void removerEmprestimo(Emprestimo emprestimo){
        for (int i=0;i<nrEmprestimosActivos;i++){
            if (emprestimoActivos[i]==emprestimo){
                for (int j=i;j<nrEmprestimosActivos-1;j++){
                    emprestimoActivos[j]=emprestimoActivos[j+1];
                }
                emprestimoActivos[--nrEmprestimosActivos]=null;
                break;
            }
        }
    }



}
