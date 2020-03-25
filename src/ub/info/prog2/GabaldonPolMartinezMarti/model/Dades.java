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
        repositori.addFitxer(audio);
    }
    
    public void addImatge(String cami, String autor, String codec, int pixelsAlcada, int pixelsAmplada) throws ReproException{
        Motor motor = new Motor();
        Imatge imatge = new Imatge(cami, autor, codec, pixelsAlcada, pixelsAmplada, motor);
        repositori.addFitxer(imatge);
    }
}
