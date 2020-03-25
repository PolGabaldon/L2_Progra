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
public class PortafoliFitxersMultimedia extends LlistaFitxers{
    private String titol;
    private static String autor;
    
    /**
     * Constructor que inicialitza l'ArrayList i la mida màxima a 100 per defecte.
     */
    public PortafoliFitxersMultimedia(int midaMax, String titol){
        super(midaMax);
        this.titol = titol;
    }
    
 

    /**
     * Si el fitxer passat per paràmetre existeix, l'afegeix a l'ArrayList i si 
     * no llença un error.
     * @param file Fitxer que es desitja afegir a l'ArrayList.
     * @throws ReproException Error llançat si el fitxer a afegir no existeix.
     */
    @Override
    public void addFitxer(File file) throws ReproException {
                       
        
            if(getSize()==0){
                FitxerMultimedia fitxer = (FitxerMultimedia) file;
                autor = fitxer.getAutor();
                super.addFitxer(file);
        
            }
            else{
                FitxerMultimedia fitxer = (FitxerMultimedia) file;
                if(autorCorrecte(fitxer)){
                    super.addFitxer(file);
                }
                else{
                    throw new ReproException("Autor incorrecte");
                }
                
            }

    }

           
    
    
    private boolean autorCorrecte(FitxerMultimedia file){
        if(file.getAutor().equals(this.autor))
            return true;
        else
            return false;
    }
 


    
}
