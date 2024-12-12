/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gruppo15.rubrica;

import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;

/**
 *
 * @author claud
 */
public class IOFileTest {   
    /**
     * Test of carica and salva method, of class IOFile.
     */
    //controllo che il file slavato sia uguale a quello caricato
    @org.junit.jupiter.api.Test
    public void testCarica() throws Exception {
        ElencoContatti lista = new ElencoContatti();
        Contatto contatto = new Contatto();
            contatto.setNome("Claudia");
            contatto.setCognome("Cerra");
            contatto.setNumeroAt(0, "1234895111");
            contatto.setEmailAt(0, "pippo@gmail.com");
        Contatto contatto1 = new Contatto();
            contatto1.setNome("Andrea");
            contatto1.setCognome("Bruno");
            contatto1.setNumeroAt(0, "5644895111");
            contatto1.setEmailAt(0, "pluto@alice.it");
            contatto1.setEmailAt(1,"paperino@libero.it");
        lista.addContatto(contatto);
        lista.addContatto(contatto1);
        IOFile.salva(lista, "file.csv");
        ElencoContatti result = IOFile.carica("file.csv");
        Contatto listaarray[] = new Contatto[2];
        Contatto resultarray[] = new Contatto[2];
        int i=0;int j=0;
        for(Contatto c : lista.getElencoOrdinato()){
            listaarray[i] = c;
            i++;
        }
        for(Contatto con : result.getElencoOrdinato()){
            resultarray[j] = con;
            j++;
        }
        //controllo se i contatti che sono stati caricati dal file sono uguali a quelli che sono stati precedentemente salvati nello stesso file
        for(int k=0; k<2; k++){
            Contatto contattouno = listaarray[k];
            Contatto contattodue = resultarray[k];
            assertEquals(contattouno.getNome(), contattodue.getNome()); 
            assertEquals(contattouno.getCognome(), contattodue.getCognome());
            for(int x = 0; x<3;x++){
                assertEquals(contattouno.getNumeroAt(x), contattodue.getNumeroAt(x));
            }
            for(int t = 0; t<3;t++){
                assertEquals(contattouno.getEmailAt(t), contattodue.getEmailAt(t));
            }
        }
    } 
    
}
