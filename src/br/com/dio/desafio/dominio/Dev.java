package br.com.dio.desafio.dominio;

import java.util.*;

public class Dev {

    private String nome;

    private final Set<Conteudo> conteudosInscritos = new LinkedHashSet<>();
    private final Set<Conteudo> conteudosConcluidos = new LinkedHashSet<>();

    public void inscreverBootcamp(Bootcamp bootcamp) {
        if (bootcamp == null) {
            throw new IllegalArgumentException("Bootcamp não pode ser nulo");
        }

        this.conteudosInscritos.addAll(bootcamp.getConteudos());
        bootcamp.inscreverDev(this);
    }

    public void progredir() {
        if (conteudosInscritos.isEmpty()) {
            throw new IllegalStateException("Nenhum conteúdo para progredir");
        }

        Conteudo conteudo = conteudosInscritos.iterator().next();
        conteudosInscritos.remove(conteudo);
        conteudosConcluidos.add(conteudo);
    }

    public double calcularTotalXp() {
        return conteudosConcluidos.stream()
                .mapToDouble(Conteudo::calcularXp)
                .sum();
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        if (nome == null || nome.isBlank()) {
            throw new IllegalArgumentException("Nome não pode ser nulo ou vazio");
        }
        this.nome = nome;
    }

    public Set<Conteudo> getConteudosInscritos() {
        return Collections.unmodifiableSet(conteudosInscritos);
    }

    public Set<Conteudo> getConteudosConcluidos() {
        return Collections.unmodifiableSet(conteudosConcluidos);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o)
            return true;

        if (!(o instanceof Dev))
            return false;

        Dev dev = (Dev) o;
        return Objects.equals(nome, dev.nome);
    }

    public boolean podeProgredir() {
        return !conteudosInscritos.isEmpty();
    }

    void inscreverConteudos(Set<Conteudo> conteudos) {
        this.conteudosInscritos.addAll(conteudos);
    }

    @Override
    public int hashCode() {
        return Objects.hash(nome);
    }
}
