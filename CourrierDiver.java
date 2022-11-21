/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package calender;

/**
 *
 * @author Mon pc
 */
public class CourrierDiver {
    private String numeroCourrier;
    private String expediteur;
    private String destinataire;
    private String objet;
    private String dateArr;
    private String dateArchivage;
    private String cheminDossier;

    public CourrierDiver(String numeroCourrier, String expediteur, String destinataire, String objet, String dateArr, String dateArchivage, String cheminDossier) {
        this.numeroCourrier = numeroCourrier;
        this.expediteur = expediteur;
        this.destinataire = destinataire;
        this.objet = objet;
        this.dateArr = dateArr;
        this.dateArchivage = dateArchivage;
        this.cheminDossier = cheminDossier;
    }

 

    public String getNumeroCourrier() {
        return numeroCourrier;
    }

    public void setNumeroCourrier(String numeroCourrier) {
        this.numeroCourrier = numeroCourrier;
    }

    public String getExpediteur() {
        return expediteur;
    }

    public void setExpediteur(String expediteur) {
        this.expediteur = expediteur;
    }

    public String getDestinataire() {
        return destinataire;
    }

    public void setDestinataire(String destinataire) {
        this.destinataire = destinataire;
    }

    public String getObjet() {
        return objet;
    }

    public void setObjet(String objet) {
        this.objet = objet;
    }

    public String getDateArr() {
        return dateArr;
    }

    public void setDateArr(String dateArr) {
        this.dateArr= dateArr;
    }

    public String getDateArchivage() {
        return dateArchivage;
    }

    public void setDateArchivage(String dateArchivage) {
        this.dateArchivage = dateArchivage;
    }

    public String getCheminDossier() {
        return cheminDossier;
    }

    public void setCheminDossier(String cheminDossier) {
        this.cheminDossier = cheminDossier;
    }
    
}
