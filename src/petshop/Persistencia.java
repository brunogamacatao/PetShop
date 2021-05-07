package petshop;

import java.io.File;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;

public class Persistencia {
    public void gravar(ArrayList<Animal> animais) {
        try {
            PrintWriter saida = new PrintWriter(new File("petshop.txt"));
            
            for (Animal a : animais) {
                saida.println(a.getNome());
                saida.println(a.getTipo());
            }
            
            saida.close();
        } catch (Exception ex) {
            System.out.println(ex);
        }
    }
    
    public ArrayList<Animal> carregar() {
        ArrayList<Animal> animais = new ArrayList<>();
        
        try {
            Scanner entrada = new Scanner(new File("petshop.txt"));
            
            while (entrada.hasNextLine()) {
                String nome = entrada.nextLine();
                String tipo = entrada.nextLine();
                
                Animal animal = new Animal(nome, tipo);
                animais.add(animal);
            }
        } catch (Exception ex) {
            System.out.println(ex);
        }
        
        return animais;
    }
}
 