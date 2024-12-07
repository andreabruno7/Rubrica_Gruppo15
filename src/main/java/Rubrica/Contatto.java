/**
 * @file Contatto.java
 * @brief Questo file contiene l'implementazione di contatto.
 * 
 * Questo file contiene gli attributi e i metodi necessari alla gestione di un contatto.
 * 
 */
package Rubrica;

public class Contatto {
    private String nome;
    private String cognome;
    private String[] numeri;
    private String[] email;
    
    
/**
 * @brief Costruttore di default.
 * 
 * @post I campi del contatto vengono inizializzati come vuoti.
 */
    public Contatto () {
        
    }
    
/**
 * @brief Restituisce il nome.
 * 
 * @return Restituisce una stringa contenente il nome del contatto.
 */
    public String getNome() {
        
    }
    
/**
 * @brief Viene inizializzato il nome.
 * 
 * @param[in] nome Il nome da assegnare al contatto.
 */
    public void setNome(String nome) {
        
    }
    
/**
 * @brief Restituisce il cognome.
 * 
 * @return Restituisce una stringa contenente il cognome del contatto.
 */
    public String getCognome() {
        
    }
    
/**
 * @brief Viene inizializzato il cognome.
 * 
 * @param [in] cognome Il cognome da assegnare al contatto.
 */
    public void setCognome(String cognome) {
        
    }
 
/**
 * @brief Restituisce un numero di telefono.
 * 
 * Restituisce il numero di telefono con l'indice specificato.
 * 
 * @param [in] index L'indice del vettore nel quale inserire il numero.
 * @return Restituisce una stringa contenente uno dei numeri di telefono del contatto.
 */
    public String getNumeroAt(int index){
        
    }
    
/**
 * @brief Restituisce una e-mail.
 * 
 * Restituisce l'e-mail con l'indice specificato.
 * 
 * @param [in] index L'indice del vettore nel quale inserire la e-mail.
 * @return Restituisce una stringa contenente una delle e-mail del contatto.
 */
    public String getEmailAt(int index){
        
    }

/**
 * @brief Inizializza un numero di telefono.
 * 
 * Inizializza il numero di telefono con l'indice specificato.
 * 
 * @post Il campo viene inizializzato con un numero di telefono valido .
 * 
 * @param [in] index L'indice del numero di telefono da inizializzare nel vettore .
 * @param [in] numero Il numero di telefono da inizializzare.
 */    
    public void setNumeroAt(int index,String numero) throws Exception{
        
    }

/**
 * @brief Inizializza una e-mail.
 * 
 * Inizializza l'e-mail con l'indice specificato.
 * 
 * @post Il campo viene inizializzato con un'e-mail valida.
 * 
 * @param [in] index L'indice dell'e-mail da inizializzare nel vettore.
 * @param [in] email L'e-mail da inizializzare.
 */      
    public void setEmailAt(int index,String email) throws Exception{
        
    }
    
    private boolean validaNumero(String numero) throws Exception{
        
    }
    
    private boolean validaEmail(String email) throws Exception{
        
    }
}
