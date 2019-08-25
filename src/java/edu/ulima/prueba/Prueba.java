/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.ulima.prueba;

import edu.ulima.bean.Libro;
import edu.ulima.mongo.LibroIF;
import edu.ulima.mongo.LibroMongo;
import java.util.List;

/**
 *
 * @author Andrea
 */
public class Prueba {
    public static void main(String[] args) {
        LibroIF dao = new LibroMongo();
        dao.printFirstLibro();
        List<Libro> ll = dao.getAllLibros();
        Libro l = new Libro();
        for (int i=0; i<ll.size(); i++){
            l = ll.get(i);
            System.out.println(l.getCodigo());
            System.out.println(l.getAutor());
        }
    }
}
