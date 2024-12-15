/**
 * @file Contatto.java
 * @brief Questo file contiene l'implementazione di contatto.
 * 
 * Questo file contiene gli attributi e i metodi necessari alla gestione di un contatto.
 * 
 */
package gruppo15.rubrica;

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
       nome = new String();
       cognome = new String();
       numeri = new String[3];
       email  = new String[3];
    }
    
    /**
     * @brief Restituisce il nome.
     * 
     * @return Restituisce una stringa contenente il nome del contatto.
     */
    public String getNome() {
        return nome;
    }
    
    /**
     * @brief Viene inizializzato il nome.
     * 
     * @param[in] nome Il nome da assegnare al contatto.
     */
    public void setNome(String nome) {
        this.nome = nome;
    }
    
    /**
     * @brief Restituisce il cognome.
     * 
     * @return Restituisce una stringa contenente il cognome del contatto.
     */
    public String getCognome() {
        return cognome;
    }
    
    /**
     * @brief Viene inizializzato il cognome.
     * 
     * @param [in] cognome Il cognome da assegnare al contatto.
     */
    public void setCognome(String cognome) {
        this.cognome = cognome;
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
        return numeri[index]; 
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
        return email[index]; 
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
        if(numero == null){
            this.numeri[index]=null;
            return;
        }
        if(!validaNumero(numero)){
            throw new Exception();
                    }
            this.numeri[index]=numero;
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
        if(email == null || email.isEmpty()){
            this.email[index]=null;
            return;
        }
        if(!validaEmail(email)){
            throw new Exception();
                    }
        this.email[index]=email;
    }
    
    // controlla che la stringa numero contenga solo cifre ( o che sia vuota )
    private boolean validaNumero(String numero) throws Exception{
        return numero.matches("\\d{" + numero.length() + "}") || numero == null;
    }
    
    // controlla che la stringa email abbia un formato valido 
    private boolean validaEmail(String email) throws Exception{
        return email.matches("[\\w._%+-]+@[\\w.-]+\\.[a-zA-Z]{2,6}") || email == null || email.isEmpty();
    }
}
