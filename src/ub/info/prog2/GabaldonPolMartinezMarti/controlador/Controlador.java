/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ub.info.prog2.GabaldonPolMartinezMarti.controlador;
import java.util.List;
import ub.info.prog2.utils.InControlador;
import ub.info.prog2.utils.ReproException;
import ub.info.prog2.GabaldonPolMartinezMarti.model.Dades;
/**
 *
 * @author polg24
 */
public class Controlador implements InControlador {
    private Dades dades;
    
    public Controlador(){
        dades = new Dades();
    }
    
    public void addAudio(String camiFitxerAudio, String camiFitxerImatge, String autor, String codec, int kbps) throws ReproException{
        dades.addAudio(camiFitxerAudio,camiFitxerImatge,autor,codec,kbps);
    }

    public void addImatge(String cami, String autor, String codec, int pixelsAlcada, int pixelsAmplada) throws ReproException{
        dades.addImatge(cami, autor, codec, pixelsAlcada, pixelsAmplada);
    }

    public List<String> showRepositori(){
        
    }

    public void removeFitxer(int i) throws ReproException{
        
    }

    public void saveDades(String string) throws ReproException{
        
    }

    public void loadDades(String string) throws ReproException{
        
    }

    public void addPortafoli(String string) throws ReproException{
        
    }

    public List<String> showPortafolis(){
        
    }

    public void removePortafoli(String string) throws ReproException{
        
    }

    public boolean existPortafoli(String string){
        
    }

    public void addFitxer(String string, int i) throws ReproException{
        
    }

    public List<String> showPortafoli(String string) throws ReproException{
        
    }

    public void removeFitxer(String string, int i) throws ReproException{
        
    }


}
