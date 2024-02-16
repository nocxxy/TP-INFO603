public class Robot {

    private Table table;

    private Cube cube;


    public Robot(Table t){
        this.table = t;
    }

    public void creerCube( String couleur,  TailleCube taille) {
        this.cube = new Cube(couleur,taille);
    }

    public boolean estVidePince() {
        if (this.cube ==null){
            return true;
        }else{
            return false;
        }

    }

    public void cubeTenue( Cube c) {
        this.cube = c;
    }


    public void poserCubeSurTable() {
        if (!this.estVidePince()){
            if(this.table.poserCube(this.cube)){
            this.resetPince();
            }
        }
    }

    public void resetPince() {
        this.cube = null;
    }


    public boolean poserSurCube( String couleur,  TailleCube taille) {
        if(!this.estVidePince()){
            Boolean res = this.table.poserSurCube(couleur,taille,this.cube);
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
            return this.table.poserSurCube(couleur,this.cube);
        }else{
            return false;
        }

    }


    public void prendreCube( String couleur,  TailleCube taille) {
        if(this.estVidePince()){
            Cube c = this.table.prendreCube(couleur,taille);
            if(c!=null){
                this.cubeTenue(c);
            }
        }
    }

    public void supprimeCube() {
        if(!this.estVidePince())
        this.resetPince();
    }

    public void afficherRobot() {
        Monde.ecrire(Monde.noir, "Etat du Robot : ");
        if(cube!=null){
            Monde.ecrire(Monde.couleur(cube.getCouleur()), "Cube " + cube.getTaille());
        }
    }
}
