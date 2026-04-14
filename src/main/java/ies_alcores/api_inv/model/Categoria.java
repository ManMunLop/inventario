package ies_alcores.api_inv.model;

import lombok.Data;
import org.springframework.data.mongodb.core.mapping.Field;

@Data
public class Categoria {
    @Field("id")
    private int id;

    @Field("Nombre")
    private String nombre;
}
