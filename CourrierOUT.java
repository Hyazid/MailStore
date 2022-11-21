
package calender;


public class CourrierOUT {
    private String numeroCourrier;
    private String destinataire;
    private String objet;
    private String dateEnvoi;
    private String dateArchivage;
    private String cheminDossier;
    public CourrierOUT(String numeroCourrier, String destinataire, String objet, String dateEnvoi, String dateArchivage, String cheminDossier){
    this.dateArchivage=dateArchivage;
    this.numeroCourrier=numeroCourrier;
    this.dateEnvoi=dateEnvoi;
    this.objet=objet;
    this.destinataire=destinataire;
    this.cheminDossier=cheminDossier;
}

    public String getNumeroCourrier() {
        return numeroCourrier;
    }

    public void setNumeroCourrier(String numeroCourrier) {
        this.numeroCourrier = numeroCourrier;
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

    public String getDateEnvoi() {
        return dateEnvoi;
    }

    public void setDateEnvoi(String dateEnvoi) {
        this.dateEnvoi = dateEnvoi;
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
