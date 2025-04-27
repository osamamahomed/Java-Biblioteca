package classe;

public class Livro {

    //Atributos
    private String isbn;
    private String titulo;
    private String autor;
    private String genero;
    private int ano;
    private boolean disponivel;
    private int quantidade;
    private int vezesEmprestados;

    //Construtor
    public Livro(){}
    public Livro(String isbn, String titulo, String autor, String genero,int ano,int quantidade){
        this.isbn=isbn;
        this.titulo=titulo;
        this.autor=autor;
        this.genero=genero;
        this.ano=ano;
        this.quantidade=quantidade;
        this.disponivel=true;
        this.vezesEmprestados=0;
    }

    //GET E SET
    public String getIsbn(){
        return isbn;
    }
    public String titulo(){
        return titulo;
    }
    public String getAutor(){
        return autor;
    }
    public String getGenero(){
        return genero;
    }
    public int ano(){
        return ano;
    }
    public int getQuantidade(){
        return quantidade;
    }
    public boolean isDisponivel(){
        return disponivel;
    }
    public int getVezesEmprestados(){
        return vezesEmprestados;
    }

    public void setDisponivel(boolean disponivel) {
        this.disponivel = disponivel;
    }
    public void incrementarVezesEmprestados(){
        this.vezesEmprestados++;
    }
}
