
package calender;
public class Courrier {
    private String numeroCourrier;
    private String expediteur;
    private String objet;
    private String dateArrive;
    private String dateArchivage;

    public String getCheminDossier() {
        return cheminDossier;
    }

    public void setCheminDossier(String cheminDossier) {
        this.cheminDossier = cheminDossier;
    }
    private String cheminDossier;
    public Courrier (String numeroCourrier, String expediteur, String objet, String dateArrive, String dateArchivage, String cheminDossier){
        this.numeroCourrier=numeroCourrier;
        this.expediteur=expediteur;
        this.objet=objet;
        this.dateArrive=dateArrive;
        this.dateArchivage=dateArchivage;
        this.cheminDossier=cheminDossier;
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

    public String getObjet() {
        return objet;
    }

    public void setObjet(String objet) {
        this.objet = objet;
    }

    public String getDateArrive() {
        return dateArrive;
    }

    public void setDateArrive(String dateArrive) {
        this.dateArrive = dateArrive;
    }

    public String getDateArchivage() {
        return dateArchivage;
    }

    public void setDateArchivage(String dateArchivage) {
        this.dateArchivage = dateArchivage;
    }
    
}
