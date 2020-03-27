/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ub.info.prog2.GabaldonPolMartinezMarti.model;

import java.io.File;
import ub.info.prog2.utils.ReproException;

/**
 *
 * @author polg24
 */
public class RepositoriFitxersMultimedia extends LlistaFitxers{
    
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
        if(!isCorrect(file)){
            super.addFitxer(file);
        }
        else{
            throw new ReproException("El fitxer està repetit");
        }
           
    }
    
    public boolean isCorrect(File file) throws ReproException{
        int i = 0;
        boolean repetit = false;
        while(i < getSize() && !repetit){
            if(getAt(i).equals(file))
                repetit = true;
            else
                i++;               
        }
        return repetit;
        
    }
       
}

    

