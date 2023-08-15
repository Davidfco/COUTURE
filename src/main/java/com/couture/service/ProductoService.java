package com.couture.service;

import com.couture.domain.Producto;
import java.util.List;

public interface ProductoService {

    public List<Producto> getProductos(boolean activos);

    public void save(Producto producto);

    public void delete(Producto producto);

    public Producto getProducto(Producto producto);

    public List<Producto> findByPrecioBetweenOrderByDescripcion(double precioInf, double precioSup);

    public List<Producto> metodoJPQL(double precioInf, double precioSup);

    public List<Producto> metodoNativo(double precioInf, double precioSup);
}
