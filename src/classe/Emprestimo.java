package classe;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

public class Emprestimo {

    //Atributos
    private Livro livro;
    private Usuario usuario;
    private LocalDate dataEmprestimo;
    private LocalDate dataDevolucaoPrevista;
    private LocalDate dataDevolucaoReal;
    private boolean devolvido;
    private double multa;

    //Construtor
    public Emprestimo(){}

    public Emprestimo(Livro livro, Usuario usuario){
        this.livro=livro;
        this.usuario=usuario;
        this.dataEmprestimo=LocalDate.now();
        this.dataDevolucaoPrevista = dataEmprestimo.plusDays(usuario.getPrazoEmprestimoDias());
        this.devolvido=false;
        this.multa=0.0;

        livro.setDisponivel(false);
        livro.incrementarVezesEmprestados();
        usuario.adicionarEmprestimo(this);
    }

    //get

    public Livro getLivro() {
        return livro;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public LocalDate getDataEmprestimo() {
        return dataEmprestimo;
    }

    public LocalDate getDataDevolucaoPrevista() {
        return dataDevolucaoPrevista;
    }

    public LocalDate getDataDevolucaoReal() {
        return dataDevolucaoReal;
    }

    public boolean isDevolvido() {
        return devolvido;
    }

    public double getMulta() {
        return multa;
    }

    //metodos(comportamentos)
    public void devolver(){
        this.dataDevolucaoReal=LocalDate.now();
        this.devolvido =true;
        livro.setDisponivel(true);
        usuario.removerEmprestimo(this);

        if (dataDevolucaoReal.isAfter(dataDevolucaoPrevista)){
            long diasAtraso = ChronoUnit.DAYS.between(dataDevolucaoPrevista,dataDevolucaoReal);
            this.multa=diasAtraso*2.0;
            usuario.setTemMulta(true);
        }
    }



}
