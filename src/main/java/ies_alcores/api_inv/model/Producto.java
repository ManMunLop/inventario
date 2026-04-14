package ies_alcores.api_inv.model;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import java.util.Date;

@Data

@Document(collection = "Producto")
public class Producto {

    @Id
    private int id;

    @Field("Marca")
    private String marca;

    @Field("Modelo")
    private String modelo;

    @Field("Precio")
    private double precio;

    @Field("Stock")
    private int stock;

    @Field("Fecha_lanzamiento")
    private String fecha_lanzamiento;

    @Field("Categoria")
    private Categoria categoria;
}
