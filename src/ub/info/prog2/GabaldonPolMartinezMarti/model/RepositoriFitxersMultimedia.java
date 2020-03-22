/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ub.info.prog2.GabaldonPolMartinezMarti.model;

import java.io.File;
import java.util.ArrayList;
import ub.info.prog2.utils.ReproException;

/**
 *
 * @author polg24
 */
public class RepositoriFitxersMultimedia extends LlistaFitxers{
    private ArrayList<File> llistaFitxers;
    
    /**
     * Constructor que inicialitza l'ArrayList i la mida màxima a 100 per defecte.
     */
    public RepositoriFitxersMultimedia(){
        super();
    }
    
 

    /**
     * Si el fitxer passat per paràmetre existeix, l'afegeix a l'ArrayList i si 
     * no llença un error.
     * @param file Fitxer que es desitja afegir a l'ArrayList.
     * @throws ReproException Error llançat si el fitxer a afegir no existeix.
     */
    @Override
    public void addFitxer(File file) throws ReproException {
        if(isRepeated(file)){
            llistaFitxers.add(file);
            System.out.println("Fitxer afegit.");
        }
        else{
            throw new ReproException("El fitxer està repetit");
        }
           
    }
    
    public boolean isRepeated(File file) throws ReproException{
        if(file.exists()){
            int i = 0;
            boolean repetit = false;
            while(i < llistaFitxers.size() && !repetit){
                if(llistaFitxers[i].equals(file))
                    repetit = true;
                else
                    i++;               
            }
            return repetit;
        
        }
        else{
            throw new ReproException("El fitxer no existeix");
        }
    }

    /**
     * Elimina la primera instància del fitxer passat per paràmetre que troba.
     * @param file Fitxer que es desitja eliminar.
     */
    @Override
    public void removeFitxer(File file){
        int id = llistaFitxers.indexOf(file);
        llistaFitxers.remove(id);
    }

    /**
     * Mètode per obtenir el fitxer de l'ArrayList que es troba a la posició i.
     * @param i Index del fitxer que es vol obtenir.
     * @return Fitxer a la posició i.
     */
    @Override
    public File getAt(int i) {
        return llistaFitxers.get(i);
    }

    /**
     * Buida l'ArrayList
     */
    @Override
    public void clear() {
        llistaFitxers.clear();
    }

   
    
    /**
     * Permet la representació de l'ArrayList de fitxers mitjançact un String.
     * @return String en el qual es representa l'ArrayList tractat.
     */
    @Override
    public String toString(){
        System.out.println("Carpeta Fitxers:\n==============");
        String s = "";
        for(int i = 0; i < llistaFitxers.size(); i++){
            s += "[" + (i + 1) + "] " + llistaFitxers.get(i).toString() + "\n";
        }
        return s;
    }
    
}
