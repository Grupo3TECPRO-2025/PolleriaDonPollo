package Clases;

import java.awt.Menu;
import java.util.ArrayList;

public class Pedidos {

    private ArrayList<Productos>Pedi;
    Cliente cli;
    

    public Pedidos(Cliente nuevo)
    {
        Pedi = new ArrayList<Productos>();
        cli=nuevo;
      
    }

    public Productos Buscar(String id)
    {
        for (Productos producto : Pedi) {

            if(producto.getId().equals(id)) return producto;
        }
        return null;
    }
    
    public int tamaño() {
    	return Pedi.size();
    	
    }
    
    public void Eliminar(int nPedidos)
    {
        Pedi.remove(nPedidos);
    }

    public void Adicionar(Productos x)
    {
        Pedi.add(x);
    }
    public Productos Obtner(int x) {
    	return Pedi.get(x);
    }
    public double Costo_Total() {
    	double total=0.0;
    	for(int i=0;i<Pedi.size();i++) {
    		total+=Obtner(i).cantidad*Obtner(i).precioUnitario;
    	}
    	return total;
    }   
    public double Costo_Total(Promociones cod) {
    	double total=0.0;
    	if(cod.tipo.trim().toLowerCase()=="fijo") {
        	for(int i=0;i<Pedi.size();i++) {
        		total+=Obtner(i).cantidad*Obtner(i).precioUnitario;
        	}
        	total-=cod.descuento;
    	}
    	else if(cod.tipo.trim().toLowerCase()=="porcentaje"){
            for(int i=0;i<Pedi.size();i++) {
            		total+=Obtner(i).cantidad*Obtner(i).precioUnitario;
            }
            total*=cod.descuento/100;
    	}
    	return total;
    }
    
}