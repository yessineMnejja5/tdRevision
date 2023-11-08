import java.util.*;

public class Agence
{
    private String nom;
    private ListVoitures parking;
    private Map<Client, ListVoitures> clientVoitureLoue;

    public Agence(String nom) {
        this.nom = nom;
        this.parking = new ListVoitures();
        this.clientVoitureLoue = new HashMap<>();
    }

    public void ajoutVoiture(Voiture v) throws VoitureException {
        parking.ajoutVoiture(v);
    }

    public void suppVoiture(Voiture v) throws VoitureException {
        parking.supprimeVoiture(v);
    }

    public void loueClientVoiture(Client cl, Voiture v) throws VoitureException {
        if (clientVoitureLoue.containsKey(cl)) {
            ListVoitures voituresLouees = clientVoitureLoue.get(cl);
            voituresLouees.ajoutVoiture(v);
        } else {
            ListVoitures voituresLouees = new ListVoitures();
            voituresLouees.ajoutVoiture(v);
            clientVoitureLoue.put(cl, voituresLouees);
        }
    }

    public void retourClientVoiture(Client cl, Voiture v) throws VoitureException {
        if (clientVoitureLoue.containsKey(cl)) {
            ListVoitures voituresLouees = clientVoitureLoue.get(cl);
            voituresLouees.supprimeVoiture(v);
        }
    }

    public List<Voiture> selectVoitureSelonCritere(Critere cr) {
        List<Voiture> result = new ArrayList<>();
        for (Voiture v : parking.getVoitures()) {
            if (Critere.estSatisfaitPar(v)) {
                result.add(v);
            }
        }
        return result;
    }

    public Set<Client> ensembleClientsLoueurs() {
        return clientVoitureLoue.keySet();
    }

    public Collection<ListVoitures> collectionVoituresLouees() {
        return clientVoitureLoue.values();
    }

    public void afficheLesClientsEtLeursListesVoitures() {
        for (Map.Entry<Client, ListVoitures> entry : clientVoitureLoue.entrySet()) {
            System.out.println("Client: " + entry.getKey());
            System.out.println("Voitures louées:");
            entry.getValue().affiche();
            System.out.println();
        }
    }

    public Map<Client, ListVoitures> triCodeCroissant() {
        Map<Client, ListVoitures> sortedMap = new TreeMap<>(clientVoitureLoue);
        return sortedMap;
    }

    public Map<Client, ListVoitures> triNomCroissant() {
        Map<Client, ListVoitures> sortedMap = new TreeMap<>(new Comparator<Client>() {
            @Override
            public int compare(Client c1, Client c2) {
                return c1.getNom().compareTo(c2.getNom());
            }
        });
        sortedMap.putAll(clientVoitureLoue);
        return sortedMap;
    }
}