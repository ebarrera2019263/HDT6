import java.util.ArrayList;
import java.util.HashMap;
import java.util.*;
import java.util.Map;
import java.util.Map.Entry;
/**
 * @author Jorge Lopez
 *
 */
public class Hash extends MapF{
    Map<Integer, String> inventario= new HashMap<Integer, String>();
    Map<Integer, String> categoria= new HashMap<Integer, String>();
    Map<Integer, Integer> cantidad= new HashMap<Integer,Integer>();
    ArrayList<String> miArray = new ArrayList<String>();
    View miVista = new View();
    String dato ="";
    public Hash(Archivo miArchivo){
        miArray = miArchivo.getArchivo();
        int x = 0;
        for (int i=0; i<miArray.size(); i = i+2){
            x++;
            categoria.put(x,miArray.get(i));
            cantidad.put(x,0);
        }
        x=0;
        for(int j =1; j<miArray.size();j = j + 2){
            x++;
            inventario.put(x,miArray.get(j));
        }
    }
    public void agregarProducto(String categoria, String nombreProducto, int cantProductos){
        Integer getKeyFromValue = getSingleKeyFromValue(inventario, nombreProducto);
        if(getKeyFromValue==null){
            System.out.println("El producto al que desea agregar no existe");
        }
        else{
            int cant = cantidad.get(getKeyFromValue);
            cantidad.replace(getKeyFromValue,cant + cantProductos);
        }
    }
    public void mostrarCategoria(String nombreProducto) {
        Integer getKeyFromValue = getSingleKeyFromValue(inventario, nombreProducto);
        System.out.println("Codigo:"+getKeyFromValue+ " Categoria: " + categoria.get(getKeyFromValue));
    }
    private static <K, V> K getSingleKeyFromValue(Map<K, V> map, V value) {
        for (Map.Entry<K, V> entry : map.entrySet()) {
            if (Objects.equals(value, entry.getValue())) {
                return entry.getKey();
            }
        }
        return null;
    }
    public void ProductosCaracteristicas() {
        for (Integer key: inventario.keySet()){
            System.out.println("Codigo:"+key+ " Categoria: " + categoria.get(key)+ " Nombre: " + inventario.get(key)+ " Cantidad: " + cantidad.get(key));
        }
    }
    public void ProductosCaracteristicasOrdenadas() {
        List<Entry<Integer, String>> list = new ArrayList<>(categoria.entrySet());
        list.sort(Entry.comparingByValue());
        for (int i =0; i<list.size();i++){
            System.out.println("Codigo:"+list.get(i).getKey()+ " Categoria: " + categoria.get(list.get(i).getKey())+ " Nombre: " + inventario.get(list.get(i).getKey())+ " Cantidad: " + cantidad.get(list.get(i).getKey()));
        }
    }
    public void productoCategoria() {
        for (Integer key: inventario.keySet()){
            System.out.println("Codigo:"+key+ " Categoria: " + categoria.get(key)+ " Nombre: " + inventario.get(key));
        }
    }
    public void productoCategoriaOrdenada() {
        List<Entry<Integer, String>> list = new ArrayList<>(categoria.entrySet());
        list.sort(Entry.comparingByValue());
        for (int i =0; i<list.size();i++){
            System.out.println("Codigo:"+list.get(i).getKey()+ " Categoria: " + categoria.get(list.get(i).getKey())+ " Nombre: " + inventario.get(list.get(i).getKey()));
        }
    }
}
