package uniandes.dpoo.estructuras.logica;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/**
 * Esta clase tiene un conjunto de métodos para practicar operaciones sobre mapas.
 *
 * Todos los métodos deben operar sobre el atributo mapaCadenas que se declara como un Map.
 * 
 * En este mapa, las llaves serán cadenas y los valores serán también cadenas. La relación entre los dos será que cada llave será igual a la cadena del valor, pero invertida.
 * 
 * El objetivo de usar el tipo Map es que sólo puedan usarse métodos de esa interfaz y no métodos adicionales provistos por la implementación concreta (HashMap).
 * 
 * No pueden agregarse nuevos atributos.
 */
public class SandboxMapas
{
    /**
     * Un mapa de cadenas para realizar varias de las siguientes operaciones.
     * 
     * Las llaves del mapa son cadenas, así como los valores.
     * 
     * Las llaves corresponden a invertir la cadena que aparece asociada a cada llave.
     */
    private Map<String, String> mapaCadenas;

    /**
     * Crea una nueva instancia de la clase con las dos listas inicializadas pero vacías
     */
    public SandboxMapas( )
    {
        mapaCadenas = new HashMap<String, String>( );
    }

    /**
     * Retorna una lista con las cadenas del mapa (los valores) ordenadas lexicográficamente
     * @return Una lista ordenada con las cadenas que conforman los valores del mapa
     */
    public List<String> getValoresComoLista( )
    {
        List<String> lista = new ArrayList<String>();
        
        for(String a: mapaCadenas.values())
        {
        	lista.add(a);
        }
        
        //Los ordeno por aparte
       
        for ( int i = 0; i < lista.size(); i++)
        {
        	for ( int j = 0; j < lista.size() - 1; j++)
        	{
        		if (lista.get(j).compareTo(lista.get(j+1)) > 0)
        			// recuerda que el compareTo compara dos string lexicograficamente
        		{
        			String temporal = lista.get(j);
        			lista.set(j, lista.get(j+1));
        			lista.set(j+1, temporal);
     
        		}
        	}
        }
        
        return lista;
    }

    /**
     * Retorna una lista con las llaves del mapa ordenadas lexicográficamente de mayor a menor
     * @return Una lista ordenada con las cadenas que conforman las llaves del mapa
     */
    public List<String> getLlavesComoListaInvertida( )
    {
        List<String> lista = new ArrayList<String>();
        
        for (String a : mapaCadenas.keySet())
        {
        	lista.add(a);
        }
        
        //ordeno ahora la lista de mayor a menor
       
        for (int i = 0; i < lista.size(); i++)
        {
            for (int j = 0; j < lista.size() - 1; j++)
            {
            	if(lista.get(j).compareTo(lista.get(j+1))<0)
         //Si tengo dudas pongo el cursor encima del compareTo. Pero basicmanete esta comparación funciona para saber si j es mayor o menor de j+1. En caso de que j+1 sea mayor, los cambio. 
            		
            	{
            		String temporal = lista.get(j);
            		lista.set(j, lista.get(j+1));
            		lista.set(j+1, temporal);
            	}
            }
        }
        
        return lista;
    }

    /**
     * Retorna la cadena que sea lexicográficamente menor dentro de las llaves del mapa .
     * 
     * Si el mapa está vacío, debe retornar null.
     * @return
     */
    public String getPrimera( )
    {
        if ( mapaCadenas.isEmpty())
        {
        	return null;
        }
        
        String menor = null;
        for (String a : mapaCadenas.keySet())
        {
        	if (menor == null || a.compareTo(menor) < 0)
        	{
        		menor = a;
        	}
        }
        
        return menor;
    }
    

    /**
     * Retorna la cadena que sea lexicográficamente mayor dentro de los valores del mapa
     * 
     * Si el conjunto está vacío, debe retornar null.
     * @return
     */
    public String getUltima( )
    {
    	if ( mapaCadenas.isEmpty())
        {
        	return null;
        }
        
        String mayor = null;
        for (String a : mapaCadenas.values())
        {
        	if (mayor == null || a.compareTo(mayor) > 0)
        	{
        		mayor = a;
        	}
        }
        
        return mayor;
    }

    /**
     * Retorna una colección con las llaves del mapa, convertidas a mayúsculas.
     * 
     * El orden de las llaves retornadas no importa.
     * @return Una lista de cadenas donde todas las cadenas están en mayúsculas
     */
    public Collection<String> getLlaves( )
    {
        Collection<String> llaves = new ArrayList<String>();
        
        for (String a : mapaCadenas.keySet())
        {
        	llaves.add(a.toUpperCase());
        	
        }
        
        return llaves;
        
    }

    /**
     * Retorna la cantidad de *valores* diferentes en el mapa
     * @return
     */
    public int getCantidadCadenasDiferentes( )
    {
        List<String> aux = new ArrayList<String>();
        
        for (String a : mapaCadenas.values())
        {
        	if (!aux.contains(a))
        	{
        		aux.add(a);
        	}
        }
        
        return aux.size();
    }

    /**
     * Agrega un nuevo valor al mapa de cadenas: el valor será el recibido por parámetro, y la llave será la cadena invertida
     * 
     * Este método podría o no aumentar el tamaño del mapa, dependiendo de si ya existía la cadena en el mapa
     * 
     * @param cadena La cadena que se va a agregar al mapa
     */
    public void agregarCadena( String cadena )
    {
    	String inv = "";
    	
    	for( int i = cadena.length() - 1; i >=0 ; i--)
    	{
    		inv += cadena.charAt(i);
    		//Char devuelve la letra de dicha posicion
    	}
    	
    	mapaCadenas.put(inv, cadena);
    }

    /**
     * Elimina una cadena del mapa, dada la llave
     * @param cadena La llave para identificar el valor que se debe eliminar
     */
    public void eliminarCadenaConLLave( String llave )
    {
    	mapaCadenas.remove(llave);
    }

    /**
     * Elimina una cadena del mapa, dado el valor
     * @param cadena El valor que se debe eliminar
     */
    public void eliminarCadenaConValor( String valor )
    {
    	Iterator<Map.Entry<String, String>> a = mapaCadenas.entrySet().iterator();

        while (a.hasNext())
        {
            Map.Entry<String, String> entrada = a.next();
            // En eset caso a se interpreta como la entry, entoncees hay que acceder a su valor. 
            if (entrada.getValue().equals(valor))
            {
                a.remove();
            }
        }
    }

    /**
     * Reinicia el mapa de cadenas con las representaciones como Strings de los objetos contenidos en la lista del parámetro 'objetos'.
     * 
     * Use el método toString para convertir los objetos a cadenas.
     * @param valores Una lista de objetos
     */
    public void reiniciarMapaCadenas( List<Object> objetos )
    {
    	mapaCadenas.clear();
    	
    	for (Object o: objetos)
    	{
    		agregarCadena(o.toString());
    	}
    }

    /**
     * Modifica el mapa de cadenas reemplazando las llaves para que ahora todas estén en mayúsculas pero sigan conservando las mismas cadenas asociadas.
     */
    public void volverMayusculas( )
    {
    	Map<String, String> nuevo = new HashMap<String, String>();
    	
    	for (Map.Entry<String, String> entrada: mapaCadenas.entrySet())
    	{
    		nuevo.put(entrada.getKey().toUpperCase(), entrada.getValue());
    	}
    	
    	mapaCadenas = nuevo;
    	
    }

    /**
     * Verifica si todos los elementos en el arreglo de cadenas del parámetro hacen parte del mapa de cadenas (de los valores)
     * @param otroArreglo El arreglo de enteros con el que se debe comparar
     * @return True si todos los elementos del arreglo están dentro de los valores del mapa
     */
    public boolean compararValores( String[] otroArreglo )
    {
        for (int  i = 0; i < otroArreglo.length; i++)
        {
        	if (!mapaCadenas.containsValue(otroArreglo[i]))
        	{
        		return false;
        	}
        }
        
        return true;
    }

}
