public class Robot {

    public Table table;

    public Cube cube;


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
        // TODO -----------------------------
        return true;
    }


    public void prendreCube( String couleur,  TailleCube taille) {
        // TODO -----------------------------
    }

    public void supprimeCube() {
        this.resetPince();
    }

    public void afficherRobot() {
        System.out.println("ROBOT :");
        if(!this.estVidePince()){
            System.out.println(this.cube.toString());
        }

    }
}
