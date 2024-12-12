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
 * @author mario
 */
public class ContattoTest {
    
     @Test
    public void testGetNome(){
        Contatto c = new Contatto();
        assertEquals("",c.getNome());    //Controllo nessun input
        c.setNome("Claudia");
        assertEquals("Claudia", c.getNome());   //Controllo input valido
    }
    @Test
    public void testGetCognome(){
        Contatto c = new Contatto();
        assertEquals("",c.getCognome());     //Controllo nessun input
        c.setCognome("Finamore");
        assertEquals("Finamore", c.getCognome());   //Controllo input valido
    }
    
    @Test public void testGetNumeroAt() throws Exception { 
    Contatto c = new Contatto();
    assertNull(c.getNumeroAt(0));   //Controllo nessun input
    assertThrows(Exception.class, () -> {c.setNumeroAt(0, "Not a number");});   //Controllo eccezione
    c.setNumeroAt(0, "3342618910");
    assertEquals("3342618910", c.getNumeroAt(0));   //Controllo input valido
    }
    
    @Test
    public void testGetMailAt() throws Exception{
        Contatto c = new Contatto();
        assertNull(c.getEmailAt(0));    //Controllo nessun input
        assertThrows(Exception.class, () -> {c.setEmailAt(0, "notaMail.com");});    //Controllo eccezione 1
        assertThrows(Exception.class, () -> {c.setEmailAt(0, "notaMail@gmail.company");});  //Controllo eccezione 2
        c.setEmailAt(0, "giovannieluco@gmail.com");
        assertEquals("giovannieluco@gmail.com", c.getEmailAt(0));   //Controllo input valido
    }
    
    
}
