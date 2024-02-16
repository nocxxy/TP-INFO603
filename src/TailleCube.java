public enum TailleCube {
    vide,
    petit,
    moyen,
    grand;

    public static TailleCube getTaille(String taille) {
        for (TailleCube t:TailleCube.values())
            if (t.name().equalsIgnoreCase(taille))
                return t;
        return TailleCube.vide;// Cas pour voir quand la taille d'un cube n'as pas été signalé
    }
}
