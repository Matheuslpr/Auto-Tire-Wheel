package dev.matheus.infrastructure.persistence;

import dev.matheus.core.enuns.MaterialRoda;
import jakarta.persistence.*;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Entity
@Table(name = "rodas")
public class Rodas {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "marca_id")
    private Long marcaId;

    private String codigo;
    private String nome;
    private Integer aro;

    @Column(name = "largura_polegadas")
    private BigDecimal larguraPolegadas;

    private Integer furos;

    @Column(name = "diametro_furacao_mm")
    private BigDecimal diametroFuracaoMm;

    @Column(name = "offset_et_mm")
    private Integer offsetEtMm;

    @Enumerated(EnumType.STRING)
    private MaterialRoda material;

    @Column(name = "cor_acabamento")
    private String corAcabamento;

    @Column(name = "preco_custo")
    private BigDecimal precoCusto;

    @Column(name = "preco_venda")
    private BigDecimal precoVenda;

    private Integer estoque;

    @Column(name = "data_cadastro")
    private LocalDateTime dataCadastro;

    @Column(name = "data_atualizacao")
    private LocalDateTime dataAtualizacao;

    @PrePersist
    public void prePersist() {
        dataCadastro = LocalDateTime.now();
    }

    @PreUpdate
    public void preUpdate() {
        dataAtualizacao = LocalDateTime.now();
    }

    //gets and sets

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Integer getAro() {
        return aro;
    }

    public void setAro(Integer aro) {
        this.aro = aro;
    }

    public BigDecimal getLarguraPolegadas() {
        return larguraPolegadas;
    }

    public void setLarguraPolegadas(BigDecimal larguraPolegadas) {
        this.larguraPolegadas = larguraPolegadas;
    }

    public Integer getFuros() {
        return furos;
    }

    public void setFuros(Integer furos) {
        this.furos = furos;
    }

    public BigDecimal getDiametroFuracaoMm() {
        return diametroFuracaoMm;
    }

    public void setDiametroFuracaoMm(BigDecimal diametroFuracaoMm) {
        this.diametroFuracaoMm = diametroFuracaoMm;
    }

    public Integer getOffsetEtMm() {
        return offsetEtMm;
    }

    public void setOffsetEtMm(Integer offsetEtMm) {
        this.offsetEtMm = offsetEtMm;
    }

    public MaterialRoda getMaterial() {
        return material;
    }

    public void setMaterial(MaterialRoda material) {
        this.material = material;
    }

    public BigDecimal getPrecoCusto() {
        return precoCusto;
    }

    public void setPrecoCusto(BigDecimal precoCusto) {
        this.precoCusto = precoCusto;
    }

    public BigDecimal getPrecoVenda() {
        return precoVenda;
    }

    public void setPrecoVenda(BigDecimal precoVenda) {
        this.precoVenda = precoVenda;
    }

    public Integer getEstoque() {
        return estoque;
    }

    public void setEstoque(Integer estoque) {
        this.estoque = estoque;
    }

    public LocalDateTime getDataCadastro() {
        return dataCadastro;
    }

    public void setDataCadastro(LocalDateTime dataCadastro) {
        this.dataCadastro = dataCadastro;
    }

    public LocalDateTime getDataAtualizacao() {
        return dataAtualizacao;
    }

    public void setDataAtualizacao(LocalDateTime dataAtualizacao) {
        this.dataAtualizacao = dataAtualizacao;
    }

    public String getCorAcabamento() {
        return corAcabamento;
    }

    public void setCorAcabamento(String corAcabamento) {
        this.corAcabamento = corAcabamento;
    }

    public Long getMarcaId() {
        return marcaId;
    }

    public void setMarcaId(Long marcaId) {
        this.marcaId = marcaId;
    }
}
