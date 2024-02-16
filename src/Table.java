import java.util.ArrayList;

public class Table {

    public ArrayList<Cube> cube = new ArrayList<Cube>();

    public boolean poserCube( Cube c) {
        this.cube.add(c);
        return true;
    }

    public boolean poserSurCube( Cube c) {
        // TODO -----------------------------
        return true;
    }


    public Cube chercherCube( String couleur,  TailleCube taille) {
        // TODO -----------------------------
        return new Cube(couleur,taille);
    }

    public Cube prendreCube( String couleur,  TailleCube taille) {
        // TODO -----------------------------
        return new Cube(couleur,taille);
    }

    public void chercherCubePrendre( String couleur,  TailleCube taille) {
        // TODO -----------------------------
    }

    public void depiler( Cube c) {
        // TODO -----------------------------
    }

    public void empiler( Cube c) {
        // TODO -----------------------------
    }

    public void afficherTable() {
        System.out.println("Table :");
        for (int i=0;i<this.cube.size();i++){
            System.out.println(this.cube.get(i));
        }
    }
}
