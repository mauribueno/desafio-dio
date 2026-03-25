package br.com.dio.desafio.application;

import br.com.dio.desafio.dominio.Materia;

public class Principal {

    public static void main(String[] args) {

        Materia portugues = new Materia();
        portugues.setNome("Materia Português");
        portugues.setNota(8.5);
        portugues.setProfessor ("Maria");

        Materia matematica = new Materia();
        matematica.setNome("Matemática");
        matematica.setNota(9.5);
        matematica.setProfessor ("Andrea");;
        System.out.println("Matéria: " + portugues.getNome() + " = Nota: "+ portugues.getNota() + " = Professor: "  + portugues.getProfessor());
        System.out.println("Matéria: " + matematica.getNome() + " = Nota: "+ matematica.getNota() +" = Professor: "  + matematica.getProfessor());
    }

}
