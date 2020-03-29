package ub.info.prog2.GabaldonPolMartinezMarti.model;
import java.io.File;
import ub.info.prog2.GabaldonPolMartinezMarti.controlador.Motor;
import ub.info.prog2.utils.ReproException;

public class Audio extends FitxerMultimedia {
    
    private final int kbps;
    private final File fitxerImatge;
    
    public Audio(String cami, File fitxerImatge, String autor, String codec, int kbps, Motor motor){
        super(cami, codec, motor, autor);
        this.kbps = kbps;
        this.fitxerImatge = fitxerImatge;
    }

    @Override
    public void reproduir() throws ReproException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    @Override
    public String toString(){
        String s;
        s = "Tipus = Audio, Autor = " + getAutor() + ", Data = " + getUltimaModificacio() + ",\n    Cami complet = " + getCamiAbsolut()
                + ",\n    Kbps = " + kbps + ", Imatge Associada = " + fitxerImatge.getAbsolutePath() + "\n";
        return s;
    }
    
    
}
