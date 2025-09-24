package r5a08.tp1;

public class UserGreeting {

    public static String formatGreeting(String nom) throws UserGreetingFailureException {
        if (nom == null || nom.isEmpty()) {
            throw new UserGreetingFailureException("Le nom ne peut pas être vide.");
        }

        // Vérification d'abord des caractères valides (pas d'espaces, pas de caractères spéciaux)
        if (!nom.matches("[a-zA-Z0-9]+")) {
            throw new UserGreetingFailureException("Le nom ne doit contenir que des lettres et des chiffres.");
        }

        // Vérification de la longueur du nom
        if (nom.length() > 10) {
            throw new UserGreetingFailureException("Le nom ne doit pas dépasser 10 caractères.");
        }

        return "Bonjour, " + nom;
    }
}

