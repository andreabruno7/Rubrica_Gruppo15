/**
 * @file IOFile.java
 * @brief Questo file contiene le operazioni di I/O su un file.
 * 
 * Questo file contiene i metodi necessari al salvataggio e al caricamento di un elenco contatti su un file.
 * 
 */
package Rubrica;


public class IOFile {

/**
 * @brief Operazione di output.
 * 
 * L'elenco contatti passato viene salvato su un file esterno.
 * 
 * @pre Il file deve avere come estensione .csv
 * @invariant L'elenco contatti non viene modificato.
 * @post Se l'elenco è vuoto il file sarà vuoto.
 * 
 * @param [in] c l'elenco contatti che deve essere salvato.
 * @param [in] filename il nome del file su cui salvare l'elenco.
 */
    public static void salva(ElencoContatti c, String filename){
        
    }

/**
 * @brief Operazione di input.  
 * 
 * Viene caricato l'elenco contatti da un file esterno.
 * 
 * @pre Il file deve avere come estensione .csv
 * @invariant L'elenco contatti non viene modificato.
 * @post Se il file è vuoto l'elenco risultante sarà vuoto.
 * 
 * @param [in] filename Il nome del file da cui caricare l'elenco dei contatti.
 */    
    public static ElencoContatti carica(String filename){
        
    }
}
