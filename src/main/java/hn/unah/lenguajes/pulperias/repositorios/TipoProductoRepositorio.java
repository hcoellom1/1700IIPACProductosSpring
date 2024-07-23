package hn.unah.lenguajes.pulperias.repositorios;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import hn.unah.lenguajes.pulperias.modelos.TipoProducto;


public interface TipoProductoRepositorio extends JpaRepository<TipoProducto, Long>{
    
    public List<TipoProducto> getByDescripcion(String descripcion);

    public boolean existsByDescripcion(String descripcion);

    @Query("select f from tipoproducto f where lower(f.descripcion ) = lower(:descripcion)")
    public List<TipoProducto> obtenerPorDescripcion(@Param("descripcion") String descripcion);

}
