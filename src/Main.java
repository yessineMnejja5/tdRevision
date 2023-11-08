import java.util.Map;
import java.util.TreeMap;


public class Main {
    public static void main(String[] args) {
        Voiture voiture1 = new Voiture(11111, "polo", 15);
        Voiture voiture2 = new Voiture(22222, "symbole", 25);
        Voiture voiture3 = new Voiture(33333, "bmw", 100);

        // Création de quelques clients
        Client client1 = new Client(1, "ahmed", "ahmed");
        Client client2 = new Client(2, "yessine", "yessine");
        Client client3 = new Client(3,"feres","feres");

        TreeMap<Client, String> clientsMap = new TreeMap<>();
        clientsMap.put(client1, "Louée");
        clientsMap.put(client2, "Louée");
        clientsMap.put(client3, "Louéé");

// Les clients seront triés en fonction de leur code client.
        for (Client client : clientsMap.keySet()) {
            System.out.println(client);


            // Création de l'agence
            Agence agence = new Agence("AgenceLocationdeVoitures");

            try {
                // Ajout de voitures à l'agence
                agence.ajoutVoiture(voiture1);
                agence.ajoutVoiture(voiture2);
                agence.ajoutVoiture(voiture3);

                // Location de voitures par des clients
                agence.loueClientVoiture(client1, voiture1);
                agence.loueClientVoiture(client3, voiture2);
                agence.loueClientVoiture(client2, voiture3);

                // Affichage des clients et des voitures louées
                agence.afficheLesClientsEtLeursListesVoitures();

                // Tri des clients par code croissant
                Map<Client, ListVoitures> clientsTriesParCode = agence.triCodeCroissant();
                System.out.println("Clients triés par code croissant:");
                for (Client clientt : clientsTriesParCode.keySet()) {
                    System.out.println(client);
                }

                // Tri des clients par nom croissant
                Map<Client, ListVoitures> clientsTriesParNom = agence.triNomCroissant();
                System.out.println("Clients triés par nom croissant:");
                for (Client clients : clientsTriesParNom.keySet()) {
                    System.out.println(client);
                }
            } catch (VoitureException e) {
                System.err.println("Erreur : " + e.getMessage());
            }
        }
    }
}
