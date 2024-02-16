import java.util.ArrayList;

public class Table {

    //Attribut

    //Liste de pile de cube
    private ArrayList<Cube> cube = new ArrayList<>();


    // Methode

    //methode permettant de poser un cube en creant une nouvelle pile sur la table
    public boolean poserCube( Cube c) {
        this.cube.add(c);
        return true;
    }


    //methode permettant de pouser un cube sur un cube
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
        Cube c1=chercherCube(couleur,c);
        if(c1!=null){
            empiler(c1,c);
            return true;
        }else{
            return false ;
        }
    }


    //methode permettant de chercher un cube sur la table
    public Cube chercherCube( String couleur,  TailleCube taille,Cube c) {
        Cube c1 = null;
        for (Cube value : this.cube) {
            if (value.correspond(couleur, taille)) {
                if (c.estPossibleDePoserSur(value)) {
                    c1 = value;
                }
            }
        }
        return c1;
    }

    public Cube chercherCube( String couleur,Cube c) {
        Cube c1 = null;
        for (Cube value : this.cube) {
            if (value.correspond(couleur)) {
                if (c.estPossibleDePoserSur(value)) {
                    c1 = value;
                }
            }
        }
        return c1;
    }

    //Methode permettant de prendre un cube sur la table
    public Cube prendreCube( String couleur,  TailleCube taille) {
        Cube res = chercherCubePrendre(couleur,taille);
        if (res!=null){
            depiler(res);
        }
        return res;
    }

    public Cube prendreCube( String couleur) {
        Cube res = chercherCubePrendre(couleur);
        if (res!=null){
            depiler(res);
        }
        return res;
    }


    //Methode permettant de chercher le cube à prendre
    public Cube chercherCubePrendre( String couleur,  TailleCube taille) {
        Cube res = null;
        for (Cube value : this.cube) {
            if (value.correspond(couleur, taille)) {
                res = value;
            }
        }
        return res;
    }

    public Cube chercherCubePrendre( String couleur) {
        Cube res = null;
        for (Cube value : this.cube) {
            if (value.correspond(couleur)) {
                res = value;
            }
        }
        return res;
    }

    // methode premettant de depiler la pile
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


    //Methode permettant d'afficher la table
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
