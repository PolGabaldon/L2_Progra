package ub.info.prog2.GabaldonPolMartinezMarti.model;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import ub.info.prog2.GabaldonPolMartinezMarti.controlador.Motor;
import ub.info.prog2.utils.ReproException;


public class Dades implements Serializable{
    private RepositoriFitxersMultimedia repositori;
    private ArrayList<PortafoliFitxersMultimedia> portafolis;
    
    public Dades(){
        repositori = new RepositoriFitxersMultimedia();
        portafolis = new ArrayList<>();
    }
    
    public RepositoriFitxersMultimedia getRepositori(){
        return repositori;
    }
    
    public ArrayList<PortafoliFitxersMultimedia> getPortafolis(){
        return portafolis;
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
    
    private boolean isAudio(String ext){
        return ext.equals("mp3") || ext.equals("wav");
    }
    
    private boolean isImatge(String ext){
        return ext.equals("png") || ext.equals("jpg") || ext.equals("jpeg");
    }
    
    public List<String> showRepositori(){
        String s = repositori.toString();
        ArrayList<String> list = new ArrayList<>();
        list.add(s);
        return list;
    }
    
    public void removeFitxer(int i) throws ReproException{
        repositori.removeFitxer(i);
    }
    
    public void saveDades(String cami) throws ReproException {
        File fitxer = new File(cami);
        if (fitxer.exists()){
            try{
                FileOutputStream fout = new FileOutputStream(fitxer);            
                ObjectOutputStream oos = new ObjectOutputStream(fout);            
                oos.writeObject(this);
                fout.close();
                oos.close();
                System.out.println("Llista guardada exitosament.");
            }
            catch (IOException e){
                throw new ReproException(e.getMessage());
            }
        }
        else{
            throw new ReproException("El fitxer on es volen guardar les dades no existeix.");
        }
        
    }
    
    public void loadDades(String cami) throws ReproException {
        File fitxer = new File(cami);
        if (fitxer.exists()){
            try{
                FileInputStream fin = new FileInputStream(fitxer);           
                ObjectInputStream ois = new ObjectInputStream(fin);            
                Dades d = (Dades)ois.readObject();
                repositori = d.getRepositori();
                portafolis = d.getPortafolis();
                fin.close();
                ois.close();
                System.out.println("Llista guardada exitosament.");
            }
            catch (IOException | ClassNotFoundException e){
                throw new ReproException(e.getMessage());
            }
        }
        else{
            throw new ReproException("El fitxer on es volen guardar les dades no existeix.");
        }
    }
    
    public void addPortafoli(String titol) throws ReproException{
        if (!portafoliExists(titol)) {
            PortafoliFitxersMultimedia portafoli = new PortafoliFitxersMultimedia(titol);
            portafolis.add(portafoli);
        }
        else{
            throw new ReproException("Ja existeix un portafoli amb aquest titol.");
        }
    }
    
    public boolean portafoliExists(String titol){
        Iterator<PortafoliFitxersMultimedia> iter = portafolis.iterator();
        boolean exists = false;
        while(iter.hasNext() && !exists){
            if(iter.next().getTitol().equals(titol)) {
                exists = true;
            }
        }
        return exists;
    }
    
    public List<String> showPortafolis() {
        String s = "";
        Iterator<PortafoliFitxersMultimedia> iter = portafolis.iterator();
        while (iter.hasNext()) {
            s += "-" + iter.next().getTitol() + "\n";
        }
        
        ArrayList<String> list = new ArrayList<>();
        list.add(s);
        return list;
    }
    
    public List<String> showPortafoli(String titol) throws ReproException{
        Iterator<PortafoliFitxersMultimedia> iter = portafolis.iterator();
        PortafoliFitxersMultimedia portafoli = new PortafoliFitxersMultimedia("");
        
        if (portafoliExists(titol)) {
            boolean trobat = false;
            while (iter.hasNext() && !trobat) {
                portafoli = iter.next();
                if (portafoli.getTitol().equals(titol)) {
                    trobat = true;
                }
            }
            String s = portafoli.toString();
            ArrayList<String> list = new ArrayList<>();
            list.add(s);
            return list;
        }
        else{
            throw new ReproException("Aquest portafoli no existeix.");
        }
    }
}
