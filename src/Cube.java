public class Cube {

    public Cube(String couleur, TailleCube taille) {
        this.couleur = couleur;
        this.taille = taille;
    }

    private TailleCube taille;



    public TailleCube getTaille() {
        return this.taille;
    }

    public void setTaille( TailleCube value) {
        this.taille = value;
    }



    private String couleur;

    public String getCouleur() {
        return this.couleur;
    }

    public void setCouleur( String value) {
        this.couleur = value;
    }

    public Cube dessous;

    public boolean poserSurCube( Cube c) {
        this.dessous = c;
        return true;
    }


    public boolean estPossibleDePoserSur( Cube c) {
        // TODO -----------------------------
        return true;
    }

    public boolean EnleverCube() {
        this.dessous = null;
        return true;
    }


    public boolean correspond( String couleur,  TailleCube taille) {
        if(this.couleur.equals(couleur) && this.taille.equals(taille)){
            return true;
        }else{
            return false;
        }

    }

    @Override
    public String toString() {
        return "Cube("+this.couleur+","+this.taille+")";
    }
}
