
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;
public class Archivo {

    ArrayList<String> array = new ArrayList<String>();

    public boolean read() throws FileNotFoundException{
        boolean read = false;
        try{
            read = true;
            File file = new File("D:\\HDT6\\Hoja6\\src\\ListadoProducto.txt");
            Scanner reader = new Scanner(file);
            while(reader.hasNextLine()){
                String dato = reader.nextLine();
                String[] separada = dato.split("\\|");
                for (int i=0; i<separada.length; i++)
                    array.add(separada[i].trim());
            }
            reader.close();
        }catch(FileNotFoundException e){
            String s = "SortController.read:" + e.getMessage();
            throw new FileNotFoundException(s);
        }
        return read;
    }

    public ArrayList<String> getArchivo(){
        return this.array;

    }

}
