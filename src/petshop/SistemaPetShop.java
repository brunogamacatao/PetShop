package petshop;

import java.util.ArrayList;

public class SistemaPetShop {
    private ArrayList<Animal> animais;
    private Persistencia persistencia;
    
    public SistemaPetShop() {
        persistencia = new Persistencia();
        animais = persistencia.carregar();
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
        persistencia.gravar(animais);
    }
    
    public void atualizarAnimal(Animal animal) {
        persistencia.gravar(animais);
    }
    
    public void removerAnimal(Animal animal) {
        animais.remove(animal);
        persistencia.gravar(animais);
    }
    
    public Animal getAnimalPorIndice(int indice) {
        return animais.get(indice);
    }
    
    public ArrayList<Animal> getAnimais() {
        return animais;
    }
}
