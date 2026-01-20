package br.com.dio.desafio.dominio;

import java.time.LocalDate;

public class Mentoria extends Conteudo {

    private LocalDate data;

    private static final double BONUS_XP_MENTORIA = 20d;

    @Override
    public double calcularXp() {
        return XP_PADRAO + BONUS_XP_MENTORIA;
    }

    public Mentoria() {
    }

    public LocalDate getData() {
        return data;
    }

    public void setData(LocalDate data) {
        if (data == null) {
            throw new IllegalArgumentException("Data da mentoria não pode ser nula");
        }
        if (data.isBefore(LocalDate.now())) {
            throw new IllegalArgumentException("Data da mentoria não pode ser no passado");
        }
        this.data = data;
    }

    @Override
    public String toString() {
        return "Mentoria{" +
                "titulo='" + getTitulo() + '\'' +
                ", descricao='" + getDescricao() + '\'' +
                ", data=" + data +
                '}';
    }
}
