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

    private Cube dessous;

    public Cube getDessous() {
        return dessous;
    }

    public boolean poserSurCube(Cube c) {
        System.out.println("Hello");
        this.dessous = c;
        return true;
    }

    //Regarde si le cube peut etre poser sur le cube c
    public boolean estPossibleDePoserSur( Cube c) {
        TailleCube t = c.getTaille();
        return (t.equals(this.taille))||(t.equals(TailleCube.grand)) ||(t.equals(TailleCube.moyen)&&(this.taille.equals(TailleCube.petit)));
    }

    public boolean enleverCube() {
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

    public boolean correspond( String couleur) {
        if(this.couleur.equals(couleur)){
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
