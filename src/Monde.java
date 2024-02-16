import in.keyboard.Keyboard;

public class Monde {


	public static final int noir = 38;

    public static final int rouge = 31;
    public static final int vert = 32;
    public static final int jaune = 33;
    public static final int bleu = 34;
    public static final int violet = 35;
    public static final int cyan = 36;
    public static final int gris = 37;

    //methode permettant d'écrire en couleur
    public static void ecrire(int coul, String s) {
        System.out.printf("\033[%d;1m%s\033[0m\n", coul, s);
    }

    //methode permettant d'écrire une ligne
    public static void ecrireEnUneLigne(int coul, String s) {
        System.out.printf("\033[%d;1m%s\033[0m", coul, s);
    }

    //méthode permettant de faire la translation entre valeur tapé au clavier et la couleur dans le print
    public static int couleur(String coul){
        return switch (coul) {
            case "rouge" -> rouge;
            case "vert" -> vert;
            case "jaune" -> jaune;
            case "bleu" -> bleu;
            case "violet" -> violet;
            case "cyan" -> cyan;
            case "gris" -> gris;
            default -> noir;
        };
    }

    //methode permettant d'écrire le panel de controle
    public static void ecrisMenu(){
        System.out.println("1 - creer un cube");
        System.out.println("2 - détruire un cube");
        System.out.println("3 - prendre un cube");
        System.out.println("4 - poser un cube sur la table");
        System.out.println("5 - poser un cube sur un cube");
        System.out.println("f - fin du monde");
        System.out.print("Votre choix : ");
    }


    //methode permettant de faire l'appel aux methodes pour creer le cube
    private static void creerCube(Robot D2R2){
        String coul;
        TailleCube tc;
        System.out.print("Couleur du cube : ");
        coul = Keyboard.getString();
        if (coul.equals("")) coul = "rouge";
//			ecrire (coul, "couleur saisie");
        System.out.print("Taille (grand/moyen/petit) : ");
        tc = TailleCube.getTaille(Keyboard.getString());
        if(tc.equals(TailleCube.vide)) tc = TailleCube.grand;
        D2R2.creerCube(coul, tc);
    }


    //methode permettant de faire l'appel aux méthodes pour supprimer le cube
    private static void supprimeCube(Robot D2R2){
        System.out.println("Le cube tenu par le robot va être détruit ");
//			Keyboard.pause();
        D2R2.supprimeCube();
    }

    //methode permettant de faire l'appel aux méthodes pour prendre un cube
    private static void prendreCube(Robot D2R2){
        String coul;
        TailleCube tc;
        System.out.println("Quel Cube voulez vous prendre ?");
//			Keyboard.pause();
        System.out.print("Couleur du cube : ");
        coul = Keyboard.getString();
        System.out.print("Taille (grand/moyen/petit) : ");
        tc = TailleCube.getTaille(Keyboard.getString());
//			Keyboard.pause();
        if(!coul.equals("")){
            if(tc.equals(TailleCube.vide)){
                D2R2.prendreCube(coul);
            }else {
                D2R2.prendreCube(coul, tc);
            }
        }else {
            System.out.println("Veuillez choisir au minimum une couleur");
        }

    }

    //methode permettant de faire l'appel aux méthodes pour poser un cube sur une table
    private static void poserCubeSurTable(Robot D2R2){
        System.out.println("Le Cube a été poser sur la table");
//			Keyboard.pause();
        D2R2.poserCubeSurTable();
    }


    //methode permettant de faire l'appel aux méthodes pour poser un cube sur un cube
    private static void poserCubeSurCube(Robot D2R2){
        String coul;
        TailleCube tc;
        System.out.println("Sur quel Cube voulez-vous posez ?");
        System.out.print("Couleur du cube : ");
        coul = Keyboard.getString();
        System.out.print("Taille (grand/moyen/petit) : ");
        tc = TailleCube.getTaille(Keyboard.getString());
        //			Keyboard.pause();
        if(!coul.equals("")){
            boolean res;
            if(tc.equals(TailleCube.vide)){
                res = D2R2.poserSurCube(coul);
            }else {
                res = D2R2.poserSurCube(coul, tc);
            }
            if(res){
                System.out.println("Le cube a été poser !");
            }else{
                System.out.println("Aucun cube a été trouver !");
            }
        }else {
            System.out.println("Veuillez choisir au minimum une couleur");
        }

    }

    //Methode permettant d'afficher le monde
    private static void afficherMonde(Robot R, Table T) {
        ecrire(noir, "Etat du monde : ");
        ecrire(noir, "--------------------------------------------------");
        R.afficherRobot();
        T.afficherTable();
//		Keyboard.pause();

    }

    // Methode main avec le code principal
    public static void main(String[] args) {
//		Couleur.testCouleur();
        Table tab = new Table();
        Robot D2R2 = new Robot(tab);
        char c;
        do {
            ecrisMenu();
            c = Keyboard.getChar();
            switch (c) {
                case '1' -> creerCube(D2R2);
                case '2' -> supprimeCube(D2R2);
                case '3' -> prendreCube(D2R2);
                case '4' -> poserCubeSurTable(D2R2);
                case '5' -> poserCubeSurCube(D2R2);
            }
            afficherMonde(D2R2, tab);
        } while (c != 'f');
    }



}
