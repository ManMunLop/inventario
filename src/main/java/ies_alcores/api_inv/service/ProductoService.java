package ies_alcores.api_inv.service;

import ies_alcores.api_inv.model.Producto;
import ies_alcores.api_inv.repository.ProductoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductoService {
    @Autowired
    private ProductoRepository productoRepository;

    public List<Producto> findAll() {
        return this.productoRepository.findAll();
    }

    public List<Producto> findByCategoria(String nombre) {
        return productoRepository.findByCategoriaNombre(nombre);
    }

    public List<Producto> buscarConQuery(String texto) {
        String patronRegex = ".*" + texto + ".*";
        return productoRepository.buscarPorModeloQuery(patronRegex);
    }
}
