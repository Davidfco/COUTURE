package com.couture.domain;

import jakarta.persistence.*;
import java.io.Serializable;
import lombok.Data;

@Data
@Entity
@Table(name="camisa")
public class Camisa implements Serializable{
    
    private static final long serialVersionUID = 1L;
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id_camisa")
    private Long idCamisa;
    private String nombre;
    private String marca;
    private String color;
    private String talla;
    private String material;
    private Double precio;
    private int stock;
    private String imagen;
    private boolean disponible;

    public Camisa() {
    }

    public Camisa(String nombre, String marca, String color, String talla, String material, Double precio, int stock, String imagen, boolean disponible) {
        this.nombre = nombre;
        this.marca = marca;
        this.color = color;
        this.talla = talla;
        this.material = material;
        this.precio = precio;
        this.stock = stock;
        this.imagen = imagen;
        this.disponible = disponible;
    }
  
}
