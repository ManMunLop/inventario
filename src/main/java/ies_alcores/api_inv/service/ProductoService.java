package ies_alcores.api_inv.service;

import ies_alcores.api_inv.model.Categoria;
import ies_alcores.api_inv.model.Producto;
import ies_alcores.api_inv.repository.ProductoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

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

    public Producto save(Producto producto) {
        // repository.save() inserta si el ID no existe o actualiza si ya existe
        return this.productoRepository.save(producto);
    }

    public List<Categoria> findAllCategoriasCompletas() {
        return productoRepository.findAll().stream()
                .map(Producto::getCategoria)
                .filter(c -> c != null && c.getNombre() != null)
                .collect(Collectors.toMap(
                        Categoria::getNombre,
                        c -> c,
                        (existente, reemplazo) -> existente))
                .values().stream()
                .collect(Collectors.toList());
    }
}
