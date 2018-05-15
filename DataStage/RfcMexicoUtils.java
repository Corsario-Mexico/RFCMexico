/*
 * Funciones para la generación y verificación del Registro Federal de
 * Causantes (RFC) utilizado en México
 */
package mx.com.itweb.rfcmexico;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Locale;

/**
 * Contiene funciones para la generación y verificación del Registro federal de
 * Causantes (RFC) utilizado en México
 * @author David Sol
 */
public class RfcMexicoUtils {
    /* Lista de palabras que se utilizan en los algoritmos */
    private static List<String> fListVocales = new ArrayList<String>(5);
    private static List<String> fListIgnorarApellidos = new ArrayList<String>(11);
    private static List<String> fListIgnorarNombres = new ArrayList<String>(13);
    private static List<String> fListPrefijosInvalidos = new ArrayList<String>(41);
    /* Inicializa el Locale para la conversión a mayúsculas */
    private static Locale mxLocale = new Locale("es","MX");

    public RfcMexicoUtils() {
        /* Inicializa la lista fListVolcales con las vocales */
        fListVocales.add("A");
        fListVocales.add("E");
        fListVocales.add("I");
        fListVocales.add("O");
        fListVocales.add("U");
        /* Inicializa la lista fListIgnorarApellidos con las palabras que deben
         * ignorarse durante el proceso de Apellidos, así como de Nombres */
        fListIgnorarApellidos.add("DE");
        fListIgnorarApellidos.add("DEL");
        fListIgnorarApellidos.add("LA");
        fListIgnorarApellidos.add("LAS");
        fListIgnorarApellidos.add("LOS");
        fListIgnorarApellidos.add("MAC");
        fListIgnorarApellidos.add("MC");
        fListIgnorarApellidos.add("MI");
        fListIgnorarApellidos.add("VAN");
        fListIgnorarApellidos.add("VON");
        fListIgnorarApellidos.add("Y");
        /* Incializa la lista fListIgnorarNombres con las palabras que deben
         * ignorarse durante el proceso de Nombres, que son las mismas que en
         * el caso de Apellidos mas otras dos */
        fListIgnorarNombres.addAll(fListIgnorarApellidos);
        fListIgnorarNombres.add("JOSE");
        fListIgnorarNombres.add("MARIA");
        Collections.sort(fListIgnorarNombres);
        /* Inicializa la lista fListaPrefijosInvalidos con los prefijos de RFC
         * los cuales no son válidos ya que son palabras "impropias" */
        fListPrefijosInvalidos.add("BUEI");
        fListPrefijosInvalidos.add("BUEY");
        fListPrefijosInvalidos.add("CACA");
        fListPrefijosInvalidos.add("CACO");
        fListPrefijosInvalidos.add("CAGA");
        fListPrefijosInvalidos.add("CAGO");
        fListPrefijosInvalidos.add("CAKA");
        fListPrefijosInvalidos.add("CAKO");
        fListPrefijosInvalidos.add("COGE");
        fListPrefijosInvalidos.add("COJA");
        fListPrefijosInvalidos.add("COJE");
        fListPrefijosInvalidos.add("COJI");
        fListPrefijosInvalidos.add("COJO");
        fListPrefijosInvalidos.add("CULO");
        fListPrefijosInvalidos.add("FETO");
        fListPrefijosInvalidos.add("GUEY");
        fListPrefijosInvalidos.add("JOTO");
        fListPrefijosInvalidos.add("KACA");
        fListPrefijosInvalidos.add("KACO");
        fListPrefijosInvalidos.add("KAGA");
        fListPrefijosInvalidos.add("KAGO");
        fListPrefijosInvalidos.add("KAKA");
        fListPrefijosInvalidos.add("KOGE");
        fListPrefijosInvalidos.add("KOJO");
        fListPrefijosInvalidos.add("KULO");
        fListPrefijosInvalidos.add("MAME");
        fListPrefijosInvalidos.add("MAMO");
        fListPrefijosInvalidos.add("MEAR");
        fListPrefijosInvalidos.add("MEAS");
        fListPrefijosInvalidos.add("MEON");
        fListPrefijosInvalidos.add("MION");
        fListPrefijosInvalidos.add("MOCO");
        fListPrefijosInvalidos.add("MULA");
        fListPrefijosInvalidos.add("PEDA");
        fListPrefijosInvalidos.add("PEDO");
        fListPrefijosInvalidos.add("PENE");
        fListPrefijosInvalidos.add("PUTA");
        fListPrefijosInvalidos.add("PUTO");
        fListPrefijosInvalidos.add("QULO");
        fListPrefijosInvalidos.add("RATA");
        fListPrefijosInvalidos.add("RUIN");        
    }
    
    public String RFCGeneraInicioFisica (String ApellidoPaterno,
                                         String ApellidoMaterno,
                                         String NombreCompleto) {
        StringBuilder Paterno = new StringBuilder(ApellidoPaterno.toUpperCase(mxLocale));
        if (Paterno.substring(2).equals("CH")) {
            Paterno.replace(1, 3, "C");
        }
        if (Paterno.substring(2).equals("LL")) {
            Paterno.replace(1, 3, "L");
        }
        StringBuilder Materno = new StringBuilder(ApellidoMaterno.toUpperCase(mxLocale));
        if (Materno.substring(2).equals("CH")) {
            Materno.replace(1, 3, "C");
        }
        if (Materno.substring(2).equals("LL")) {
            Materno.replace(1, 3, "L");
        }
        StringBuilder Nombre = new StringBuilder(NombreCompleto.toUpperCase(mxLocale));
        if (Nombre.substring(2).equals("CH")) {
            Nombre.replace(1, 3, "C");
        }
        if (Nombre.substring(2).equals("LL")) {
            Nombre.replace(1, 3, "L");
        }
        return Paterno.toString();
    }
}
