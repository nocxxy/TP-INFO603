public enum TailleCube {
    petit,
    moyen,
    grand;

    public static TailleCube getTaille(String taille) {
        for (TailleCube t:TailleCube.values())
            if (t.name().equalsIgnoreCase(taille))
                return t;
        return TailleCube.grand;
    }
}
