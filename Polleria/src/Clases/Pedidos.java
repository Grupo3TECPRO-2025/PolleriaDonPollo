package Clases;

import java.util.ArrayList;

public class Pedidos {

    private ArrayList<Productos>Pedi;

    public Pedidos()
    {
        Pedi = new ArrayList<Productos>();
        Adicionar(new Productos(10, "Pollo1/4.01", "1/4 Pollo", 4));
        Adicionar(new Productos(10, "Pollo1/4.21", "1/4 Pollo Con Chaufa y Gaseosa", 4));
        Adicionar(new Productos(10, "PolloEntero.01", "Pollo Entero con Gaseosa y Ensalada", 4));

    }

    public Productos Buscar(String id)
    {
        for (Productos producto : Pedi) {

            if(producto.getId() == id) 
            {
                return producto;
            }
        }
        return null;
    }

    public void Eliminar(int nPedidos)
    {
        Pedi.remove(nPedidos);
    }

    public void Adicionar(Productos x)
    {
        Pedi.add(x);
    }

}