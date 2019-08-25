/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.ulima.mongo;

import com.mongodb.BasicDBObject;
import com.mongodb.DBCursor;
import com.mongodb.MongoClient;
import com.mongodb.MongoClientURI;
import com.mongodb.MongoException;
import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoCursor;
import com.mongodb.client.MongoDatabase;
import static com.mongodb.client.model.Filters.*;

import edu.ulima.bean.Libro;
import java.util.ArrayList;
import java.util.List;
import org.bson.Document;
import org.bson.conversions.Bson;


/**
 *
 * @author Andrea
 */
public class LibroMongo implements LibroIF{
    
    public MongoCollection getCollection(){
        MongoCollection collection = null;
        try {

            MongoClientURI uri = new MongoClientURI(
                "mongodb://admin:admin@cluster0-shard-00-00-l72lq.mongodb.net:27017,cluster0-shard-00-01-l72lq.mongodb.net:27017,cluster0-shard-00-02-l72lq.mongodb.net:27017/test?ssl=true&replicaSet=Cluster0-shard-0&authSource=admin&retryWrites=true&w=majority");
               

            MongoClient mongoClient = new MongoClient(uri);
            MongoDatabase database = mongoClient.getDatabase("prueba4");
            System.out.println("Conectándose a la bd... "+database.getName());
            
            collection = database.getCollection("prue_lib");
            //System.out.println(collection.count());
            
            

            //Document myDoc = (Document) collection.find().first();
            //System.out.println(myDoc.toJson());
			

        } catch (MongoException e) {
            e.printStackTrace();
        }
        return collection;
    }

    @Override
    public List<Libro> getAllLibros() {
        MongoCollection collection = getCollection();
        MongoCursor cursor = collection.find().iterator();
        Libro l = null;
        List<Libro> ll = new ArrayList<Libro>();
        while (cursor.hasNext()){
            Document document = (Document) cursor.next();
            //System.out.println(document.toString());
            l = new Libro();
            l.setCodigo(document.getInteger("codigo"));
            l.setTitulo(document.getString("titulo"));
            l.setImagen(document.getString("imagen"));
            l.setAutor(document.getString("autor"));
            l.setPrecio(document.getDouble("precio"));
            l.setUrl(document.getString("url"));
            System.out.println(l.getCodigo());
            ll.add(l);
        }
        cursor.close();
        return ll;
    }

    @Override
    public void printFirstLibro() { //Prueba
        MongoCollection collection = getCollection();
        System.out.println("Hay "+collection.count()+" libros en esta colección");
        System.out.println("Primer libro: ");
        Document myDoc = (Document) collection.find().first();
        System.out.println(myDoc.toJson());
        String titulo = myDoc.getString("titulo");
        System.out.println(titulo);
    }

    @Override
    public void deleteByCodigo(int codigo) { 
        MongoCollection collection = getCollection();
        collection.deleteOne(new Document("codigo", codigo));
    }

    @Override
    public void createLibro(Libro l) { 
        MongoCollection collection = getCollection();
        Document libroMongo= new Document();
        libroMongo.append("codigo",l.getCodigo());
        libroMongo.append("titulo",l.getTitulo());
        libroMongo.append("imagen",l.getImagen());
        libroMongo.append("autor",l.getAutor());
        libroMongo.append("precio",l.getPrecio());
        libroMongo.append("url",l.getUrl());  
        collection.insertOne(libroMongo);
        
    }

    @Override
    public void updateLibro(int codigo,String titulo, String autor, double precio, String imagenURL) {
        MongoCollection collection = getCollection();
        Bson orig = new Document("codigo",codigo);
        Bson newTitulo = new Document("titulo",titulo);
        Bson newAutor = new Document("autor",autor);
        Bson newPrecio = new Document("precio",precio);
        Bson newImagenURL = new Document("imagen",imagenURL);
        
        
        Bson updateTitulo = new Document("$set", newTitulo);
        Bson updateAutor = new Document("$set", newAutor);
        Bson updatePrecio = new Document("$set", newPrecio);
        Bson updateImagenURL = new Document("$set",newImagenURL);
        
        
        collection.updateOne(orig,updateTitulo);
        collection.updateOne(orig,updateAutor);
        collection.updateOne(orig,updatePrecio);
        collection.updateOne(orig,updateImagenURL);
    }

    @Override
    public Libro getLibroByTitulo(String titulo) {
        Libro lib = null;
        MongoCollection collection = getCollection();
        Document myDoc = (Document) collection.find(eq("titulo",titulo)).first();        
        lib = new Libro();
        lib.setCodigo((int)myDoc.get("codigo"));
        lib.setAutor((String)myDoc.get("autor"));
        lib.setTitulo((String)myDoc.get("titulo"));
        lib.setImagen((String)myDoc.get("imagen"));
        lib.setPrecio((double)myDoc.get("precio"));
        lib.setUrl((String)myDoc.get("url"));
        
        return lib;
    }

    @Override
    public List<Libro> getLibroByPalabra(String palabra) {
        MongoCollection collection = getCollection();
        BasicDBObject filtro = new BasicDBObject();
        filtro.put("titulo",palabra); 
        MongoCursor cursor = (MongoCursor) collection.find(regex("titulo",palabra)).iterator();
        Libro l = null;
        List<Libro> ll = new ArrayList<Libro>();
        while (cursor.hasNext()){
            Document document = (Document) cursor.next();
            //System.out.println(document.toString());
            l = new Libro();
            l.setCodigo(document.getInteger("codigo"));
            l.setTitulo(document.getString("titulo"));
            l.setImagen(document.getString("imagen"));
            l.setAutor(document.getString("autor"));
            l.setPrecio(document.getDouble("precio"));
            l.setUrl(document.getString("url"));
            ll.add(l);
        }
        cursor.close();
        return ll;
    }
    
}
