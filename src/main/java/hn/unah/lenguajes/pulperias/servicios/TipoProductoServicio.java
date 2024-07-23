package hn.unah.lenguajes.pulperias.servicios;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import hn.unah.lenguajes.pulperias.modelos.TipoProducto;
import hn.unah.lenguajes.pulperias.repositorios.TipoProductoRepositorio;

@Service
public class TipoProductoServicio {
    

    @Autowired
    private TipoProductoRepositorio tipoProductoRepositorio;


    public List<TipoProducto> obtenerTodos(){
        return this.tipoProductoRepositorio.findAll();
    }

    public TipoProducto crearNuevo(String descripcion){
        TipoProducto tipoProducto = new TipoProducto();
        tipoProducto.setDescripcion(descripcion);
        return this.tipoProductoRepositorio.save(tipoProducto);
    }

    public TipoProducto obtenerPorCodigo(long codigoTipo){
        return this.tipoProductoRepositorio.findById(codigoTipo).get();
    }

    public String eliminarPorCodigo(long codigoTipo){
        if(this.tipoProductoRepositorio.existsById(codigoTipo)){
            this.tipoProductoRepositorio.deleteById(codigoTipo);
            return "Se ha eliminado el registro";
        }
        return "No existe el registro";
    }

    public TipoProducto actualizar(long codigoTipoProducto, TipoProducto tipoProducto){
        if(this.tipoProductoRepositorio.existsById(codigoTipoProducto)){            
            TipoProducto tipoProductoActualizar = this.tipoProductoRepositorio.findById(codigoTipoProducto).get();
            tipoProductoActualizar.setDescripcion(tipoProducto.getDescripcion());
            tipoProductoActualizar.setReorden(tipoProducto.getReorden());
            this.tipoProductoRepositorio.save(tipoProductoActualizar);
            return tipoProductoActualizar;
        }
        return null;
    }



}
