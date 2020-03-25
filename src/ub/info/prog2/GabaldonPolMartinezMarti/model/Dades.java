package ub.info.prog2.GabaldonPolMartinezMarti.model;

import java.io.File;
import java.io.Serializable;
import java.util.ArrayList;
import ub.info.prog2.GabaldonPolMartinezMarti.controlador.Motor;
import ub.info.prog2.utils.ReproException;


public class Dades implements Serializable{
    private RepositoriFitxersMultimedia repositori;
    private ArrayList<PortafoliFitxersMultimedia> portafolis;
    
    public Dades(){
        repositori = new RepositoriFitxersMultimedia();
        portafolis = new ArrayList<>();
    }
    
    public void addAudio(String camiFitxerAudio, String camiFitxerImatge, String autor, String codec, int kbps) throws ReproException{
        File fitxerImatge = new File(camiFitxerImatge);
        Motor motor = new Motor();
        Audio audio = new Audio(camiFitxerAudio, fitxerImatge, autor, codec, kbps, motor);
        
        String nomIm = fitxerImatge.getName(), nomAu = audio.getNomFitxer();
        String imExt = nomIm.substring(nomIm.lastIndexOf(".")), auExt = nomAu.substring(nomAu.lastIndexOf("."));
        if (isImatge(imExt) && isAudio(auExt))
            repositori.addFitxer(audio);
        else
            throw new ReproException("Error a l'afegir el fitxer.");
    }
    
    public void addImatge(String cami, String autor, String codec, int pixelsAlcada, int pixelsAmplada) throws ReproException{
        Motor motor = new Motor();
        Imatge imatge = new Imatge(cami, autor, codec, pixelsAlcada, pixelsAmplada, motor);
        
        String nomIm = imatge.getNomFitxer();
        String imExt = nomIm.substring(nomIm.lastIndexOf("."));
        if (isImatge(imExt))
            repositori.addFitxer(imatge);
        else
            throw new ReproException("Error a l'afegir el fitxer.");
    }
    
    public boolean isAudio(String ext){
        if (ext.equals("mp3") || ext.equals("wav"))
            return true;
        return false;
    }
    
    public boolean isImatge(String ext){
        if (ext.equals("png") || ext.equals("jpg") || ext.equals("jpeg"))
            return true;
        return false;
    }
}
