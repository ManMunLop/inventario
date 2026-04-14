package ies_alcores.api_inv.controller;

import ies_alcores.api_inv.model.Producto;
import ies_alcores.api_inv.service.ProductoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/inv")
public class ProductoController {
    @Autowired
    private ProductoService productoService;

    @GetMapping("")
    public ResponseEntity<List<Producto>> findAll(){
        return ResponseEntity.ok(this.productoService.findAll());
    }

    @GetMapping("/categoria/{nombre}")
    public List<Producto> getByCategoria(@PathVariable String nombre) {
        return productoService.findByCategoria(nombre);
    }

    @GetMapping("/buscar")
    public List<Producto> search(@RequestParam String nombre) {
        return productoService.buscarConQuery(nombre);
    }

}
