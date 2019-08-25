/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.ulima.bean;

import java.io.Serializable;

/**
 *
 * @author Andrea
 */
public class Libro implements Serializable {
    private int codigo;
    private String titulo;
    private String imagen;
    private String autor;
    private double precio;
    private String url;

    public Libro() {
    }

    public Libro(int codigo, String titulo, String imagen, String autor, double precio, String url) {
        this.codigo = codigo;
        this.titulo = titulo;
        this.imagen = imagen;
        this.autor = autor;
        this.precio = precio;
        this.url = url;
    }


    
    
    
    
    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getImagen() {
        return imagen;
    }

    public void setImagen(String imagen) {
        this.imagen = imagen;
    }

    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }
    
}
