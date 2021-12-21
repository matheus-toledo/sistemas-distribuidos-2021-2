package Exercicio1.entidades;

import Exercicio1.constantes.FuncionarioConstantes;

public class Funcionario {
    private String nome;
    private String cargo;
    private Double salario;

    public Funcionario(String nome, String cargo, Double salario) {
        this.nome = nome;
        this.cargo = cargo;
        this.salario = salario;
    }

    public String getCargo() {
        return cargo;
    }

    public void setCargo(String cargo) {
        this.cargo = cargo;
    }

    public Double getSalario() {
        return salario;
    }

    public void setSalario(Double salario) {
        this.salario = salario;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void reajustaSalario() {
        switch (cargo) {
            case FuncionarioConstantes.CARGO_OPERADOR:
                salario = salario * 1.20D;
                break;
            case FuncionarioConstantes.CARGO_PROGRAMADOR:
                salario = salario * 1.18D;
        }
    }
}
