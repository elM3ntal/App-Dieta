public class Persona {
  protected double peso; //kg
  protected double altezza; //cm
  protected String genere;
  protected int eta;
  protected String attivita;
  
  public Persona (double peso, double altezza, String genere, int eta, String attvita) {
    this.peso=peso;
    this.altezza=altezza;
    this.genere=genere;
    this.eta=eta;
    this.attivita=attvita;
  }

  public void setPeso(double peso) {
    this.peso = peso;
  }

  public void setAltezza(double altezza) {
    this.altezza = altezza;
  }

  public void setEta(int eta) {
    this.eta = eta;
  }

  public void setAttivita(String attivita) {
    this.attivita = attivita;
  }

  public void setGenere(String genere) {
    this.genere = genere;
  }

  public double getPeso() {
    return peso;
  }

  public String getAttivita() {
    return attivita;
  }

  public double getAltezza() {
    return altezza;
  }

  public int getEta() {
    return eta;
  }

  public String getGenere() {
    return genere;
  }

  public void stampaCMD () {
    System.out.println("\nPeso: " + peso);
    System.out.println("Altezza: " + altezza);
    System.out.println("Genere: " + genere);
    System.out.println("Eta': " + eta);
    System.out.println("Attivita': " + attivita);
    System.out.println();
  }
}