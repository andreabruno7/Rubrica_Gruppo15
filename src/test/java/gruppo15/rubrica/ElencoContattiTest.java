/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gruppo15.rubrica;

import javafx.collections.ObservableList;
import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;

/**
 *
 * @author bruno
 */
public class ElencoContattiTest {
    
    /**
     * Test of removeContatto method, of class ElencoContatti.
     */
    @org.junit.jupiter.api.Test
    public void testRemoveContatto() {
        System.out.println("removeContatto");
        Contatto contatto1 = new Contatto();
        contatto1.setNome("Andrea");
        Contatto contatto2 = new Contatto();
        contatto2.setNome("Claudia");
        Contatto contatto3 = new Contatto();
        contatto3.setNome("Francesco");
        Contatto contatto4 = new Contatto();
        contatto4.setNome("Salvatore");
        ElencoContatti lista = new ElencoContatti();
        lista.addContatto(contatto4);
        lista.addContatto(contatto3);
        lista.addContatto(contatto2);
        boolean result = lista.removeContatto(contatto3);
        assertEquals(true,result); //controlla che la rimozione sia andata a buon fine
        result = lista.removeContatto(contatto1);
        assertEquals(false,result); //controlla che la rimozione non sia andata a buon fine ( contatto1 non è presente nell'elenco)
    }

    /**
     * Test of getElencoOrdinato method, of class ElencoContatti.
     */
    @org.junit.jupiter.api.Test
    public void testGetElencoOrdinato() {
        ElencoContatti lista = new ElencoContatti();
        Contatto contatto1 = new Contatto();
        contatto1.setNome("Claudia");
        Contatto contatto2 = new Contatto();
        contatto2.setCognome("Finamore");
        Contatto contatto3 = new Contatto();
        contatto3.setNome("Andrea");
        contatto3.setCognome("Bruno");
        lista.addContatto(contatto1);
        lista.addContatto(contatto3);
        lista.addContatto(contatto2);
        ObservableList<Contatto> result = lista.getElencoOrdinato();
        assertEquals(contatto1,result.get(0)); //controlla se gli elementi sono correttamente in ordine
        assertEquals(contatto3,result.get(1));
        assertEquals(contatto2,result.get(2));
        Contatto contatto4 = new Contatto(); 
        contatto4.setNome("Salvatore");
        lista.addContatto(contatto4);
        assertEquals(contatto1,result.get(0)); //controlla se gli elementi restano in ordine dopo aver aggiunto un elemento
        assertEquals(contatto4,result.get(1)); 
        assertEquals(contatto3,result.get(2));
        assertEquals(contatto2,result.get(3));
        lista.removeContatto(contatto3);
        assertEquals(contatto1,result.get(0)); //controlla se gli elementi restano in ordine dopo aver rimosso un elemento
        assertEquals(contatto4,result.get(1)); 
        assertEquals(contatto2,result.get(2));
    }
    
    /**
     * Test of ricercaContatto method, of class ElencoContatti.
     */
    @org.junit.jupiter.api.Test
    public void testRicercaContatto() {
        ElencoContatti lista = new ElencoContatti();
        Contatto contatto1 = new Contatto();
        contatto1.setNome("Andrea");
        Contatto contatto2 = new Contatto();
        contatto2.setNome("Alessandro");
        lista.addContatto(contatto1);
        lista.addContatto(contatto2);
        ObservableList<Contatto> cercato = lista.ricercaContatto("An");
        assertEquals(contatto1,cercato.get(0)); //controlla che venga trovato solo contatto1
        assertEquals(1,cercato.size()); //controlla che la lista di ritorno abbia un unico elemento
        Contatto contatto3 = new Contatto();
        contatto3.setCognome("Anna");
        lista.addContatto(contatto3);
        cercato = lista.ricercaContatto("an"); //controlla che i contatti vengano cercati in modo case insensitive
        assertEquals(contatto1,cercato.get(0));
        assertEquals(contatto3,cercato.get(1));
        assertEquals(2,cercato.size());
    }

    
    @Test
    public void testModificaContatto(){
        ElencoContatti contatti = new ElencoContatti();
        Contatto contatto1 = new Contatto();
        contatto1.setNome("Claudia");
        Contatto contatto2 = new Contatto();
        contatto2.setNome("Finamore");
        Contatto contatto3 = new Contatto();
        contatto3.setNome("Andrea");
        contatti.addContatto(contatto1);
        contatti.addContatto(contatto3);
        contatti.addContatto(contatto2);
        Contatto contatto3new = new Contatto();
        contatto3new.setNome("Salvatore");
        contatti.modificaContatto(contatto3,contatto3new);
        ObservableList<Contatto> result = contatti.getElencoOrdinato();
        assertEquals(contatto1,result.get(0)); //controlla se gli elementi restano in ordine dopo aver modificato un elemento
        assertEquals(contatto2,result.get(1)); 
        assertEquals(contatto3,result.get(2));
    }
    
    
}
