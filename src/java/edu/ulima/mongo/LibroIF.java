/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.ulima.mongo;

import edu.ulima.bean.Libro;
import java.util.List;

/**
 *
 * @author Andrea
 */
public interface LibroIF {
    public void printFirstLibro(); 
    public List<Libro> getAllLibros(); 
    public void deleteByCodigo(int codigo); 
    public void createLibro(Libro l); 
    public void updateLibro(int codigo, String titulo, String autor, double precio, String imagenURL);
    public Libro getLibroByTitulo(String titulo); //el titulo especifico
    public List<Libro> getLibroByPalabra(String palabra); //palabra que contenga el titulo
}
