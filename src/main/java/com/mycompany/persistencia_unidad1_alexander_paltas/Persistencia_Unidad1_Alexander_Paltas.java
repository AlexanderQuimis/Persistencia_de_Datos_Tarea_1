package com.mycompany.persistencia_unidad1_alexander_paltas;

import modelo.CorteCarne;
import repository.CorteCarneRepository;

public class Persistencia_Unidad1_Alexander_Paltas {

    public static void main(String[] args) {

        CorteCarneRepository repo = new CorteCarneRepository();

        // CREATE
       CorteCarne carne = new CorteCarne();
       carne.setNombre("Picana");
       carne.setGramaje(60000);
       carne.setPrecio(18.00);
       carne.setTermino("Medio");

       //repo.guardar(carne);

       //READ
       //repo.listar().forEach(c ->
       //         System.out.println(c.getNombre() + " $" + c.getPrecio())
       // );

        // UPDATE
        carne.setPrecio(27.00);
        repo.actualizar(carne);

        // DELETE
        //repo.eliminar(9);
    }
}