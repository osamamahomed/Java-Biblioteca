package classe;

import java.util.Arrays;

public class Funcionario extends Usuario{

        //Atributos
        private String cargo;
        private Livro[] livros;
        private Usuario[] usuarios;
        private Emprestimo[] historicoEmprestimos;
        private int nrLivros;
        private int nrUsuarios;
        private int nrEmprestimos;

        //construtor
        public Funcionario(){}
        public Funcionario(int id, String nome, String cargo, int capacidade){
            super(id,nome);
            this.cargo=cargo;
            this.livros=new Livro[capacidade];
            this.usuarios=new Usuario[capacidade];
            this.historicoEmprestimos=new Emprestimo[capacidade];
        }

        //Metodos de gerenciamento
        public void cadastrarLivro(Livro livro){
            if (nrLivros<livros.length){
                livros[nrLivros++] = livro;
            }
        }

        public void cadastrarUsuario(Usuario usuario){
            if (nrUsuarios<usuarios.length){
                usuarios[nrUsuarios++]=usuario;
            }
        }

        public boolean realizarEmprestimos(String isbn, int usuarioId){
            Usuario usuario= encontrarUsuarioPorId(usuarioId);
            Livro livro = encontrarLivroPorIsbn(isbn);

            if (usuario == null || livro == null || !livro.isDisponivel() || !usuario.podeFazerEmprestimo()){
                return false;
            }

            if (nrEmprestimos<historicoEmprestimos.length){
                Emprestimo emprestimo = new Emprestimo(livro,usuario);
                historicoEmprestimos[nrEmprestimos++]=emprestimo;
                return true;
            }
            return false;
        }

        public double registrarDevolucao(int idUsuario, String isbn){
            for(int i=0; i<nrEmprestimos;i++){
                Emprestimo e =historicoEmprestimos[i];
                if (!e.isDevolvido() && e.getUsuario().getId()==idUsuario && e.getLivro().getIsbn().equals(isbn)){
                    e.devolver();
                    return e.getMulta();
                }
            }
            return -1;
        }



        //Metodos auxiliares
        private Usuario encontrarUsuarioPorId(int id){
            for (int i =0;i<nrUsuarios;i++){
                if (usuarios[i].getId()==id){
                    return usuarios[i];
                }
            }
            return null;
        }

        private Livro encontrarLivroPorIsbn(String isbn){
            for (int i=0;i<nrLivros;i++){
                if (livros[i].getIsbn().equals(isbn)){
                    return livros[i];
                }
            }
            return null;
        }








   //metodos extendido do usuario
    @Override
    public int getLimiteEmprestimos() {
        return 0;
    }

    @Override
    public int getPrazoEmprestimoDias() {
        return 0;
    }
}
