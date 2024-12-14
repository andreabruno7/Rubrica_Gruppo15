/**
 * @file IOFile.java
 * @brief Questo file contiene le operazioni di I/O su un file.
 * 
 * Questo file contiene i metodi necessari al salvataggio e al caricamento di un elenco contatti su un file.
 * 
 */
package gruppo15.rubrica;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;


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
    public static void salva(ElencoContatti c, String filename) throws IOException{
        try( PrintWriter pw = new PrintWriter(new BufferedWriter ( new FileWriter(filename)))){
            pw.println("NOME;COGNOME;PRIMO NUMERO;SECONDO NUMERO;TERZO NUMERO; PRIMA EMAIL; SECONDA EMAIL; TERZA EMAIL");
            for(Contatto contatto : c.getElencoOrdinato()){
                
                if(contatto.getNome() != null)
                    pw.print(contatto.getNome());
                else
                    pw.print("null");
                pw.append(';');
                if(contatto.getCognome() != null)
                    pw.print(contatto.getCognome());
                else
                    pw.print("null");
                pw.append(';');
                for(int i=0; i<3 ; i++){
                    if(contatto.getNumeroAt(i)!= null)
                        pw.print(contatto.getNumeroAt(i));
                    else
                        pw.print("null");
                    pw.append(';');
                }
                for(int i=0; i<3 ; i++){
                    if(contatto.getEmailAt(i)!= null)
                        pw.print(contatto.getEmailAt(i));
                    else
                        pw.print("null");
                    if(i != 2)
                    pw.append(';');
                }
                pw.append('\n');
            }   
        } 
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
    public static ElencoContatti carica(String filename) throws FileNotFoundException, Exception{
                String[] numero = new String[3];
        String[] email = new String[3];
        String var;
        String var1;
        ElencoContatti elenco  = new ElencoContatti();
        try(Scanner s = new Scanner(new BufferedReader( new FileReader(filename)))){
            if(s.nextLine() == null)
                return elenco;
            s.useDelimiter("[;\n]");
            //s.useLocale( Locale.US); //perchè altrimenti il punto in 28.5 dava problemi
            while(s.hasNext()){
                
                String nome = s.next();
                String cognome = s.next();
                for(int i = 0; i<3; i++){
                    var = s.next();
                    if(!var.contains("null"))
                        numero[i] = var;
                    else
                        numero[i] = null;
                }
                for(int i = 0; i<3; i++){
                    var1 = s.next();
                    if(!var1.contains("null"))
                        email[i] = var1;
                    else
                        email[i] = null;
                }
                
            Contatto contatto = new Contatto();
            contatto.setNome(nome);
            contatto.setCognome(cognome);
            for(int k = 0;k <3 ; k++){
                    contatto.setNumeroAt(k, numero[k]);
            }
            for(int h = 0;h <3 ; h++){
                    contatto.setEmailAt(h, email[h]);
            }
            elenco.addContatto(contatto);
            }
                
            }
        return elenco;
    }
}
