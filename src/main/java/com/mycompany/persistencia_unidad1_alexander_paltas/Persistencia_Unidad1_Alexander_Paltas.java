package com.mycompany.persistencia_unidad1_alexander_paltas;

import modelo.CorteCarne;
import modelo.Proveedor;
import repository.CorteCarneRepository;

public class Persistencia_Unidad1_Alexander_Paltas {

    public static void main(String[] args) {
        
       CorteCarneRepository repo = new CorteCarneRepository();
       
        // PROVEEDOR
        Proveedor p = new Proveedor();
        p.setNombre("Distribuidora Norte");
        p.setTelefono("0987654321");
        
        // CORTE DE CARNE
       CorteCarne carne = new CorteCarne();
       carne.setNombre("Picana");
       carne.setGramaje(60000);
       carne.setPrecio(18.00);
       carne.setTermino("Medio");
      

        // 🔗 RELACIÓN
       carne.setProveedor(p);
       //repo.guardar(carne);
       repo.guardar(carne, p);
       //READ
        repo.listar().forEach(x ->
            System.out.println(x.getNombre() + " $" + x.getPrecio())
        );

        // UPDATE
        //carne.setPrecio(27.00);
        //repo.actualizar(carne);

        // DELETE
        //repo.eliminar(9);
    }
}