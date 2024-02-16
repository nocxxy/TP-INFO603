public class Cube {

    //Constructeur
    public Cube(String couleur, TailleCube taille) {
        this.couleur = couleur;
        this.taille = taille;
    }


    // ATTRIBUTs
    private TailleCube taille;
    private String couleur;
    private Cube dessous;


    // GETTER/SETTER

    public TailleCube getTaille() {
        return this.taille;
    }

    public void setTaille( TailleCube value) {
        this.taille = value;
    }

    public String getCouleur() {
        return this.couleur;
    }

    public void setCouleur( String value) {
        this.couleur = value;
    }

    public Cube getDessous() {
        return dessous;
    }


    // Methodes

    // Methodes permettant de mettre le cube sur un cube
    public boolean poserSurCube(Cube c) {
        this.dessous = c;
        return true;
    }

    //Regarde si le cube peut etre poser sur le cube c
    public boolean estPossibleDePoserSur( Cube c) {
        TailleCube t = c.getTaille();
        return (t.equals(this.taille))||(t.equals(TailleCube.grand)) ||(t.equals(TailleCube.moyen)&&(this.taille.equals(TailleCube.petit)));
    }

    //on enleve le cubede la pile
    public boolean enleverCube() {
        this.dessous = null;
        return true;
    }


    //Methode permettant de regarder si le cube correspond à la couleur et la taille
    public boolean correspond( String couleur,  TailleCube taille) {
        if(this.couleur.equals(couleur) && this.taille.equals(taille)){
            return true;
        }else{
            return false;
        }

    }
    //Methode permettant de regarder si le cube correspond à la couleur
    public boolean correspond( String couleur) {
        if(this.couleur.equals(couleur)){
            return true;
        }else{
            return false;
        }

    }
}
