/**
 * @file ElencoContatti.java
 * @brief Questo file contiene l'impelementazione di un elenco di contatti.
 * 
 * Questo file implementa un elenco di contatti. L'elenco può essere ottenuto anche come ordinato
 * attraverso una lista osservabile SortableList.
 * 
 * 
 */
package Rubrica;

import javafx.collections.ObservableList;
import javafx.collections.transformation.SortedList;

public class ElencoContatti {
    
    private ObservableList<Contatto> elenco;
    
    private SortedList<Contatto> elencoOrdinato;
    
    /**
     * @brief Costruttore di default.
     * 
     * @post L'elenco dei contatti viene inizializzato come vuoto.
     * 
     */
    public ElencoContatti(){
        
    }
    
    /**
     * @brief Aggiunge un contatto all'elenco.
     * 
     * Il metodo aggiunge un contatto all'elenco.
     * 
     * @pre Il contatto passato non deve essere null.
     * @post Il contatto verrà aggiunto anche se duplicato.
     * 
     * @param[in] c Il contatto da aggiungere.
     * 
     */
    public void addContatto(Contatto c){
        
    }
    
    /**
     * @brief Rimuove un contatto dalla lista
     * 
     * Il metodo rimuove un contatto dalla lista
     * 
     * @pre Il contatto passato non deve essere null.
     * @post Il metodo restituisce un valore booleano che rappresenta se la rimozione è andata a buon fine.
     * 
     * @param[in] c Il contatto da rimuovere.
     * @return true se la rimozione è andata a buon fine, false se l'elemento non è stato trovato.
     */
    public boolean removeContatto(Contatto c){
        
    }
    
    /**
     * @brief Ritorna l'elenco ordinato.
     * 
     * Il metodo ritorna una SortedList dell'elenco dei contatti.
     * 
     * @post Per manipolare la lista di ritorno è sufficiente chiamare i metodi sull'oggetto ElencoContatti su cui è stato chiamato questo metodo.
     * @post Nonostante l'inserimento o la rimozione di altri elementi, la lista rimarrà sempre ordinata.
     * @post L'ordinamento di questa lista è per cognome. Se il cognome è uguale, si sceglie per il nome.
     * 
     * @return Ritorna una SortedList contenente i contatti in modo ordinato.
     */
    public SortedList<Contatto> getElencoOrdinato(){
        
    }
    
    /**
     * @brief Ritorna l'elenco ordinato contenete i risultati della ricerca.
     * 
     * Il metodo ricerca la stringa passata come parametro nei nomi e nei cognomi di tutti i contatti inseriti.
     * Restituisce una SortedList contenete tutti i contatti in cui trova corrispondenza.
     * 
     * @post Se non vengono trovati contatti, la SortedList sarà null.
     * 
     * @param[in] str La stringa da cercare.
     * @return Ritorna una SortedList contenente i contatti richiesti.
     */
    public SortedList<Contatto> ricercaContatto(String str){
        
    }
}
