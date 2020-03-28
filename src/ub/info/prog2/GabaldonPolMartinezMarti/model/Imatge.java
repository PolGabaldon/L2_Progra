package ub.info.prog2.GabaldonPolMartinezMarti.model;
import ub.info.prog2.GabaldonPolMartinezMarti.controlador.Motor;
import ub.info.prog2.utils.ReproException;


public class Imatge extends FitxerMultimedia{
    
    private final int alcada, amplada, resolucio;
    
    public Imatge(String cami, String autor, String codec, int alcada, int amplada, Motor motor){
        super(cami, codec, motor, autor);
        this.alcada = alcada;
        this.amplada = amplada;
        resolucio = alcada * amplada;
    }

    @Override
    public void reproduir() throws ReproException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    @Override
    public String toString(){
        String s;
        s = "Tipus = Imatge, Autor = " + getAutor() + ", Data = " + getUltimaModificacio() + ",\n    Cami complet = " + getCamiAbsolut()
                + ",\n    Resolució = " + resolucio + "\n";
        return s;
    }
    
}