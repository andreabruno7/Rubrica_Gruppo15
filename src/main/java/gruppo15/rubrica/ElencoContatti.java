/**
 * @file ElencoContatti.java
 * @brief Questo file contiene l'impelementazione di un elenco di contatti.
 * 
 * Questo file implementa un elenco di contatti. L'elenco viene ottenuto come ordinato
 * attraverso una lista osservabile ObservableList.
 * 
 * 
 */
package gruppo15.rubrica;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class ElencoContatti {
    
    private final ArrayList<Contatto> elenco;
    
    private final ObservableList<Contatto> elencoOrdinato;
    
    private class Comparatore implements Comparator<Contatto>{

        @Override
        public int compare(Contatto o1, Contatto o2) { //comparatore per l'ordine dell'elenco
            int compare;
            if(o1.getCognome() != null && o2.getCognome() != null) //comparatore con entrambi i cognomi presenti
               compare = o1.getCognome().compareToIgnoreCase(o2.getCognome()); 
            else{
                if(o1.getCognome()!=null) //caso in cui il cognome di o1 è presente, quello di o2 no
                    compare = 1;
                else if(o2.getCognome() != null) //caso in cui il cognome di o2 è presente, quello di o1 no
                        compare = -1;
                    else
                        compare = 0;
                    
            }if(compare==0){ //caso in cui né o1 che o2 hanno un cognome
                if(o1.getNome() != null && o2.getNome() != null) //caso in cui sia o1 che o2 hanno il nome
                    compare = o1.getNome().compareToIgnoreCase(o2.getNome());
                else{
                    if(o1.getNome() != null)//caso in cui il nome di o1 è presente, quello di o2 no
                        compare = 1;
                    else if (o2.getNome() != null)//caso in cui il nome di o2 è presente, quello di o1 no
                        compare = -1; 
                    else // caso in cui nessuno dei due ha né il nome né il cognome
                        compare = 0;
                }
            }return compare;
        }
        
    }
    /**
     * @brief Costruttore di default.
     * 
     * @post L'elenco dei contatti viene inizializzato come vuoto.
     * 
     */
    public ElencoContatti(){
        elenco = new ArrayList<>();
        elencoOrdinato = FXCollections.observableArrayList();
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
        elenco.add(c);
        aggiornaElenco();
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
        boolean result = elenco.remove(c);
        aggiornaElenco();
        return result;
    }
    
    /**
     * @brief Ritorna l'elenco ordinato.
     * 
     * Il metodo ritorna una ObservableList dell'elenco dei contatti.
     * 
     * @post Per manipolare la lista di ritorno è sufficiente chiamare i metodi sull'oggetto ElencoContatti su cui è stato chiamato questo metodo.
     * @post Nonostante l'inserimento o la rimozione di altri elementi, la lista rimarrà sempre ordinata.
     * @post L'ordinamento di questa lista è per cognome. Se il cognome è uguale, si sceglie per il nome.
     * 
     * @return Ritorna una ObservableList contenente i contatti in modo ordinato.
     */
    public ObservableList<Contatto> getElencoOrdinato(){
        return elencoOrdinato;
    }
    
    /**
     * @brief Ritorna l'elenco ordinato contenete i risultati della ricerca.
     * 
     * Il metodo ricerca la stringa passata come parametro nei nomi e nei cognomi di tutti i contatti inseriti.
     * Restituisce una ObservableList contenete tutti i contatti in cui trova corrispondenza.
     * 
     * @post Se non vengono trovati contatti, la ObservableList sarà null.
     * 
     * @param[in] str La stringa da cercare.
     * @return Ritorna una ObservableList contenente i contatti richiesti.
     */
    public ObservableList<Contatto> ricercaContatto(String str){
        ArrayList<Contatto> risultati = new ArrayList<>();
        for(Contatto c : elenco){
            if(c.getNome().matches("(?i)^"+str+".*")||c.getCognome().matches("(?i)^"+str+".*")) //cerca la stringa passata come sottostringa iniziale in modo case insensitive in tutti i contatti
                risultati.add(c);
        }
        ObservableList<Contatto> risultatiOsservabili = FXCollections.observableArrayList(risultati);
        return risultatiOsservabili;
    }
    
    public void modificaContatto(Contatto vecchio,Contatto nuovo){
        vecchio.setNome(nuovo.getNome());
        vecchio.setCognome(nuovo.getCognome());
        for(int i = 0;i<3;i++){
            try {
                vecchio.setNumeroAt(i,nuovo.getNumeroAt(i));
            } catch (Exception ex) {
                Logger.getLogger(ElencoContatti.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        for(int i = 0;i<3;i++){
            try {
                vecchio.setEmailAt(i,nuovo.getEmailAt(i));
            } catch (Exception ex) {
                Logger.getLogger(ElencoContatti.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        aggiornaElenco();
    }
    
    private void aggiornaElenco(){
        elenco.sort(new Comparatore());
        elencoOrdinato.setAll(elenco);
    }
}
