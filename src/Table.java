import java.util.ArrayList;

public class Table {

    private ArrayList<Cube> cube = new ArrayList<Cube>();

    public boolean poserCube( Cube c) {
        this.cube.add(c);
        return true;
    }

    public boolean poserSurCube( String couleur, TailleCube t ,Cube c) {
        Cube c1=chercherCube(couleur,t,c);
        if(c1!=null){
            empiler(c1,c);
            return true;
        }else{
            return false ;
        }
    }

    public boolean poserSurCube( String couleur ,Cube c) {
        // TODO -----------------------------
        return true;
    }


    public Cube chercherCube( String couleur,  TailleCube taille,Cube c) {
        Cube c1 = null;
        for(int i =0; i<this.cube.size();i++){
            if(this.cube.get(i).correspond(couleur,taille)){
                if(c.estPossibleDePoserSur(this.cube.get(i))){
                    c1 = this.cube.get(i);
                }
            }
        }
        return c1;
    }

    public Cube chercherCube( String couleur,Cube c) {
        Cube c1 = null;
        for(int i =0; i<this.cube.size();i++){
            if(this.cube.get(i).correspond(couleur)){
                if(c.estPossibleDePoserSur(this.cube.get(i))){
                    c1 = this.cube.get(i);
                }
            }
        }
        return c1;
    }

    public Cube prendreCube( String couleur,  TailleCube taille) {
        Cube res = chercherCubePrendre(couleur,taille);
        if (res!=null){
            depiler(res);
        }
        return res;
    }

    public Cube chercherCubePrendre( String couleur,  TailleCube taille) {
        Cube res = null;
        for(int i=0;i<this.cube.size();i++){
            if(this.cube.get(i).correspond(couleur,taille)){
                res = this.cube.get(i);
            }
        }
        return res;
    }

    public void depiler( Cube c) {
        Cube nouveauSommet = c.getDessous();
        this.cube.remove(c);
        this.cube.add(nouveauSommet);
        c.enleverCube();


    }
    // Empile le cube c1 sur le cube c2
    public void empiler( Cube c1,Cube c2) {
        c2.poserSurCube(c1);
        this.cube.remove(c1);
        this.cube.add(c2);
    }

    public void afficherTable() {
        Monde.ecrire(Monde.noir, "Etat de la Table : ");
        for (Cube c: cube){
            Cube tmp = c;
            int cpt = 0;
            while(tmp != null) {
                if (cpt != 0) Monde.ecrireEnUneLigne(Monde.noir, " <- ");
                Monde.ecrireEnUneLigne(Monde.couleur(tmp.getCouleur()), "Cube " + tmp.getTaille());
                cpt++;
                tmp = tmp.getDessous();
            }
            System.out.println("\n");
        }
    }
}
