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
    
    @Override
    public void addAudio(String camiFitxerAudio, String camiFitxerImatge, String autor, String codec, int kbps) throws ReproException{
        dades.addAudio(camiFitxerAudio,camiFitxerImatge,autor,codec,kbps);
    }

    @Override
    public void addImatge(String cami, String autor, String codec, int pixelsAlcada, int pixelsAmplada) throws ReproException{
        dades.addImatge(cami, autor, codec, pixelsAlcada, pixelsAmplada);
    }

    @Override
    public List<String> showRepositori(){
        return dades.showRepositori();
    }

    @Override
    public void removeFitxer(int i) throws ReproException{
        dades.removeFitxer(i);
    }

    @Override
    public void saveDades(String cami) throws ReproException{
        dades.saveDades(cami);
    }

    @Override
    public void loadDades(String cami) throws ReproException{
        dades.loadDades(cami);
    }

    @Override
    public void addPortafoli(String titol) throws ReproException{
        dades.addPortafoli(titol);
    }

    @Override
    public List<String> showPortafolis(){
        return dades.showPortafolis();
    }
    
    @Override
    public List<String> showPortafoli(String titol) throws ReproException{
        return dades.showPortafoli(titol);
    }

    @Override
    public void removePortafoli(String string) throws ReproException{
        
    }

    @Override
    public boolean existPortafoli(String string){
        
    }

    @Override
    public void addFitxer(String string, int i) throws ReproException{
        
    }

    @Override
    public void removeFitxer(String string, int i) throws ReproException{
        
    }


}
