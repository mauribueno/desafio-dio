package br.com.dio.desafio.dominio;

import java.time.LocalDate;
import java.util.Collections;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Objects;
import java.util.Set;

public class Bootcamp {

    private String nome;
    private String descricao;
    private final LocalDate dataInicial;
    private final LocalDate dataFinal;

    private final Set<Dev> devsInscritos = new HashSet<>();
    private final Set<Conteudo> conteudos = new LinkedHashSet<>();

    public Bootcamp() {
        this.dataInicial = LocalDate.now();
        this.dataFinal = this.dataInicial.plusDays(45);
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        if (nome == null || nome.isBlank()) {
            throw new IllegalArgumentException("Nome do bootcamp é obrigatório");
        }
        this.nome = nome;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        if (descricao == null || descricao.isBlank()) {
            throw new IllegalArgumentException("Descrição do bootcamp é obrigatória");
        }
        this.descricao = descricao;
    }

    public LocalDate getDataInicial() {
        return dataInicial;
    }

    public LocalDate getDataFinal() {
        return dataFinal;
    }

    public Set<Dev> getDevsInscritos() {
        return Collections.unmodifiableSet(devsInscritos);
    }

    public Set<Conteudo> getConteudos() {
        return Collections.unmodifiableSet(conteudos);
    }

    public void inscreverDev(Dev dev) {
        if (dev == null) {
            throw new IllegalArgumentException("Dev não pode ser nulo");
        }

        devsInscritos.add(dev);
        dev.inscreverConteudos(this.conteudos);
    }

    public void adicionarConteudo(Conteudo conteudo) {
        if (conteudo == null) {
            throw new IllegalArgumentException("Conteúdo não pode ser nulo");
        }
        conteudos.add(conteudo);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o)
            return true;

        if (!(o instanceof Bootcamp))
            return false;

        Bootcamp bootcamp = (Bootcamp) o;
        return Objects.equals(nome, bootcamp.nome);
    }

    @Override
    public int hashCode() {
        return Objects.hash(nome);
    }
}
