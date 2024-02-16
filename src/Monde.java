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
    public Table table;

    public Robot robot;
    public static void ecrire(int coul, String s) {
        System.out.printf("\033[%d;1m%s\033[0m\n", coul+31, s);
    }

    public static void main(String[] args) {
//		Couleur.testCouleur();
        Table tab = new Table();
        Robot D2R2 = new Robot(tab);
        char c = ' ';
        String coul;
        TailleCube tc;
        do {
            System.out.println("1 - creer un cube");
            System.out.println("2 - détruire un cube");
            System.out.println("3 - prendre un cube");
            System.out.println("4 - poser un cube sur la table");
            System.out.println("5 - poser un cube sur un cube");
            System.out.println("f - fin du monde");
            System.out.print("Votre choix : ");
            c = Keyboard.getChar();
            switch (c) {
                case '1':
                    System.out.print("Couleur du cube : ");
                    coul = Keyboard.getString();
//			ecrire (coul, "couleur saisie");
                    System.out.print("Taille (grand/moyen/petit) : ");
                    tc = TailleCube.getTaille(Keyboard.getString());
                    D2R2.creerCube(coul, tc);
                    break;
                case '2':
                    System.out.println("Le cube tenu par le robot va être détruit ");
//			Keyboard.pause();
                    D2R2.supprimeCube();
                    break;
                case '3':
                    System.out.println("Quel CUbe voulez vous prendre ?");
//			Keyboard.pause();
                    // TODO------------------------
                    break;
                case '4':
                    System.out.println("Le Cube a été poser sur la table");
//			Keyboard.pause();
                    D2R2.poserCubeSurTable();
                    break;
            }
            afficherMonde(D2R2, tab);
        } while (c != 'f');
    }

    private static void afficherMonde(Robot R, Table T) {
        ecrire(noir, "Etat du monde : ");
        R.afficherRobot();
        T.afficherTable();
//		Keyboard.pause();

    }
}
