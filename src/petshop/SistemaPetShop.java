package petshop;

import java.util.ArrayList;

public class SistemaPetShop {
    private ArrayList<Animal> animais;
    
    public SistemaPetShop() {
        animais = new ArrayList<>();
    }
    
    public void adicionarAnimal(Animal animal) throws Exception {
        // Antes de adicionar, vou checar se o objeto animal é válido
        if (animal.getNome().equals("")) {
            throw new Exception("O campo nome é obrigatório !");
        }
        if (animal.getTipo().equals("")) {
            throw new Exception("O campo tipo é obrigatório");
        }
        
        animais.add(animal);
    }
    
    public void removerAnimal(Animal animal) {
        animais.remove(animal);
    }
    
    public Animal getAnimalPorIndice(int indice) {
        return animais.get(indice);
    }
    
    public ArrayList<Animal> getAnimais() {
        return animais;
    }
}
