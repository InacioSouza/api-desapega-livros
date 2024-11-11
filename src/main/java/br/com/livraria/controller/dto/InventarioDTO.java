package br.com.livraria.controller.dto;

import br.com.livraria.repository.entity.Inventario;
import br.com.livraria.repository.entity.Lingua;
import br.com.livraria.repository.entity.Livro;


public class InventarioDTO {
    
    private Livro livro;
    
    private Lingua lingua;
    
    private int qtdLivros;
    
    
    public InventarioDTO() {
    }
    
    public InventarioDTO(Livro livro, Lingua lingua, int qtdLivors) {
    }
    
    
    public InventarioDTO converteParaDTO(Inventario inventario){
        return new InventarioDTO(inventario.getLivro(),
                inventario.getLingua(),
                inventario.getQtdLivros());
    }
    
    public Inventario converteParaInventario() {
        return new Inventario(this.livro, this.lingua, this.qtdLivros);
    }
    
    public Livro getLivro() {
        return livro;
    }
    
    public void setLivro(Livro livro) {
        this.livro = livro;
    }
    
    public Lingua getLingua() {
        return lingua;
    }
    
    public void setLingua(Lingua lingua) {
        this.lingua = lingua;
    }
    
    public int getQtdLivros() {
        return qtdLivros;
    }
    
    public void setQtdLivros(int qtdLivros) {
        this.qtdLivros = qtdLivros;
    }
}
