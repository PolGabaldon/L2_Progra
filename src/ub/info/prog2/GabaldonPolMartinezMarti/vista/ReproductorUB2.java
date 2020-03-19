package ub.info.prog2.GabaldonPolMartinezMarti.vista;

import java.util.Scanner;
import ub.info.prog2.utils.Menu;


/**
 * Classe que representa un reproductor amb el mètode gestioReproductorUB1 per a
 * gestionar la reproducció de fitxers.
 * @author GabaldonPolMartinezMarti
 */
public class ReproductorUB2 {
    // Declarem les opcions per a referir-se a les opcions del menÃº.
    static private enum OpcionsMenuPrincipal {GESTIO_FITXERS, GUARDAR_DADES, RECUPERAR_DADES, SORTIR};
    static private enum OpcionsSubmenu1 {CREAR_PORTAFOLI, MOSTRAR_PORTAFOLIS, ELIMINAR_PORTAFOLI, AFEGIR_FITXER, MOSTRAR_FITXERS, ELIMINAR_FITXER, MENU_ANTERIOR};
    static private enum OpcionsSubmenu2 {AFEGIR_AUDIO, AFEGIR_IMATGE, MENU_ANTERIOR};
    
    // Declarem descripcions personalitzades per a les opcions del menÃº principal
    static private String[] descMenuPrincipal={"Menú gestió dels fitxers",
                                               "Guardar dades",
                                               "Recuperar dades",
                                               "Sortir"};

    // Declarem descripcions personalitzades per a les opcions del menÃº secundari
    static private String[] descMenu2={"Crear portafoli",
                                                "Mostrar portafolis",
                                                "Eliminar portafolis", "Agefir fitxer", "Mostrar fitxers", "Eliminar fitxer", "Tornar al menú anterior"};
    static private String[] descMenu3={"Afegir fitxer d'àudio","Afegir fitxer d'imatge","Tornar al menú anterior"};

    /**
     * Fitxer principal. Crea el menÃº principal i un menÃº secundari
     * @param args the command line arguments
     */
    private Menu<ReproductorUB2.OpcionsMenuPrincipal> menu;
    private Menu<ReproductorUB2.OpcionsSubmenu1> subMenu1;
    private Menu<ReproductorUB2.OpcionsSubmenu2> subMenu2;
    
    
        public ReproductorUB2(){
        menu = new Menu<OpcionsMenuPrincipal>("Menu Principal",ReproductorUB2.OpcionsMenuPrincipal.values());
        subMenu1 = new Menu<OpcionsSubmenu1>("Menu Secundari",ReproductorUB2.OpcionsSubmenu1.values());
        subMenu2 = new Menu<OpcionsSubmenu2>("Subemnú",ReproductorUB2.OpcionsSubmenu2.values());

    }
            
    public void gestioReproductorUB(Scanner sc){
        // Assignem la descripció de les opcions
        menu.setDescripcions(descMenuPrincipal);
        
       
        int i;
        ReproductorUB2.OpcionsMenuPrincipal opcio;
        do {
            // Mostrem les opcions del menÃº
            menu.mostrarMenu();

            // Demanem una opcio
            opcio=menu.getOpcio(sc);

            // Fem les accions necessàries
            switch(opcio) {
                case GESTIO_FITXERS:
                    gestioMenu2(sc);

                    break;
                   
                case GUARDAR_DADES:
                    break;
                    
                case RECUPERAR_DADES:
                    break;
                
                case SORTIR:
                   
                    System.out.println("Chao bambino!");
                    break;
            }

        } while(opcio!=ReproductorUB2.OpcionsMenuPrincipal.SORTIR);
    }
        

    /**
     * MenÃº secundari
     * @param sc Objecte de tipus Scanner que permet accedir al teclat
     */
    public void gestioMenu2(Scanner sc){

        // Assignem la descripciÃ³ de les opcions
        subMenu1.setDescripcions(descMenu2);

        ReproductorUB2.OpcionsSubmenu1 opcio;
        do {
            // Mostrem les opcions del menÃº
            subMenu1.mostrarMenu();

            // Demanem una opcio
            opcio=subMenu1.getOpcio(sc);

            // Fem les accions necessàries
            switch(opcio) {
                case CREAR_PORTAFOLI:
                    break;
                   
                case MOSTRAR_PORTAFOLIS:
                    break;
                    
                case ELIMINAR_PORTAFOLI:
                    break;
                    
                case AFEGIR_FITXER:
                    gestioMenu3(sc);
                    break;
                    
                case MOSTRAR_FITXERS:
                    break;
                    
                case ELIMINAR_FITXER:
                    break;
                    
                case MENU_ANTERIOR:
                   
                    break;
            }

        } while(opcio!=ReproductorUB2.OpcionsSubmenu1.MENU_ANTERIOR);
    }
    
    public void gestioMenu3(Scanner sc){
        
        // Assignem la descripciÃ³ de les opcions
        subMenu2.setDescripcions(descMenu3);

        ReproductorUB2.OpcionsSubmenu2 opcio;
        do {
            // Mostrem les opcions del menÃº
            subMenu2.mostrarMenu();

            // Demanem una opcio
            opcio=subMenu2.getOpcio(sc);

            // Fem les accions necessàries
            switch(opcio) {
                case AFEGIR_AUDIO:
                    break;
                   
                case AFEGIR_IMATGE:
                    break;

                case MENU_ANTERIOR:
                   
                    break;
            }

        } while(opcio!=ReproductorUB2.OpcionsSubmenu2.MENU_ANTERIOR);
    }
// Aixo es un comentari random
}
