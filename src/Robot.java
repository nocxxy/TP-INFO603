
public class Robot {

    //Attributs

    private final Table table;

    private Cube cube;

    //Constructeur


    public Robot(Table t){
        this.table = t;
    }

    //Methode

    //MEthode permettant de créer un cube dans la pince
    public void creerCube( String couleur,  TailleCube taille) {
        this.cube = new Cube(couleur,taille);
    }

    // Methode permettant de regarder si la pince est vide
    public boolean estVidePince() {
        return this.cube == null;

    }

    //methode permettant de changer ce qui est dans la pince
    public void cubeTenue( Cube c) {
        this.cube = c;
    }


    //Methode permettant de poser un cube sur une table
    public void poserCubeSurTable() {
        if (!this.estVidePince()){
            if(this.table.poserCube(this.cube)){
            this.resetPince();
            }
        }
    }

    // Methode permettant de reinitialiser la pince
    public void resetPince() {
        this.cube = null;
    }


    // Methode permettant pour poser sur un cube
    public boolean poserSurCube( String couleur,  TailleCube taille) {
        if(!this.estVidePince()){
            boolean res = this.table.poserSurCube(couleur,taille,this.cube);
            if (res){
                this.resetPince();
            }
            return res;
        }else{
            return false;
        }

    }

    public boolean poserSurCube( String couleur) {
        if(!this.estVidePince()){
            boolean res = this.table.poserSurCube(couleur,this.cube);
            if (res){
                this.resetPince();
            }
            return res;
        }else{
            return false;
        }

    }


    //Methode pour prendre un cube
    public void prendreCube( String couleur,  TailleCube taille) {
        if(this.estVidePince()){
            Cube c = this.table.prendreCube(couleur,taille);
            if(c!=null){
                this.cubeTenue(c);
            }
        }
    }

    public void prendreCube( String couleur) {
        if(this.estVidePince()){
            Cube c = this.table.prendreCube(couleur);
            if(c!=null){
                this.cubeTenue(c);
            }
        }
    }

    // MEthod permettant de supprime un cube
    public void supprimeCube() {
        if(!this.estVidePince()) this.resetPince();
    }


    // Methode permettant d'afficher le robot
    public void afficherRobot() {
        Monde.ecrire(Monde.noir, "Etat du Robot : ");
        if(cube!=null){
            Monde.ecrire(Monde.couleur(cube.getCouleur()), "Cube " + cube.getTaille());
        }
    }
}
