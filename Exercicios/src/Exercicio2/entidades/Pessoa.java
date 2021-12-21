package Exercicio2.entidades;

import Exercicio2.constantes.PessoaConstantes;

public class Pessoa {
    private String sexo;
    private String nome;
    private int idade;

    public Pessoa(String sexo, String nome, int idade) {
        this.sexo = sexo;
        this.nome = nome;
        this.idade = idade;
    }

    public String getSexo() {
        return sexo;
    }

    public void setSexo(String sexo) {
        this.sexo = sexo;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getIdade() {
        return idade;
    }

    public void setIdade(int idade) {
        this.idade = idade;
    }

    public static boolean isPessoaPossuiMaioridade(Pessoa pessoa) {
        if (pessoa.getSexo().equals(PessoaConstantes.MASCULINO) && pessoa.idade >= 18) {
            return true;
        } else return pessoa.getSexo().equals(PessoaConstantes.FEMININO) && pessoa.idade >= 21;
    }

}
