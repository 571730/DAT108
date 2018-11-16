import java.util.ArrayList;
import java.util.LinkedList;
import java.util.PriorityQueue;

public class Graf {
    private int antallNoder;
    private LinkedList<Node> noder;
    private LinkedList<Kant> kanter;

    public Graf(int antallNoder){
        this.antallNoder = antallNoder;
        noder = new LinkedList<>();
        kanter = new LinkedList<>();
        for (int i = 0; i < antallNoder; i++){
            Node n = new Node(i);
            noder.add(n);
        }
    }

    public ArrayList<Kant> mst(){
        PriorityQueue<Kant> haug = new PriorityQueue<>();
        ArrayList<Node> mstListe = new ArrayList<>();
        ArrayList<Kant> kantListeMST = new ArrayList<>();

        Node startNode = noder.getFirst();
        mstListe.add(startNode);
        //Legger til kantene i køen
        haug.addAll(finnKanter(startNode));

        while(!haug.isEmpty()){
            Kant k = haug.poll();
            if (!mstListe.contains(k.getFra()) ||
                    !mstListe.contains(k.getTil())){
                Node n = mstListe.contains(k.getTil()) ? k.getFra() :
                        k.getTil();
                mstListe.add(n);
                kantListeMST.add(k);
                for (Kant kant : finnKanter(n)){
                    if (!haug.contains(kant)){
                        haug.add(kant);
                    }
                }
            }
        }
        return kantListeMST;
    }

    public ArrayList<Kant> finnKanter(Node n){
        ArrayList<Kant> nodensKanter = new ArrayList<>();
        for(Kant k : this.kanter){
            if (k.getFra().equals(n) || k.getTil().equals(n)){
                if (!nodensKanter.contains(k)){
                    nodensKanter.add(k);
                }
            }
        }
        return nodensKanter;
    }


    public void breddeForst(Node n){
        System.out.println("-- Bredde Først --");
        LinkedList<Node> ko = new LinkedList<>();
        LinkedList<Node> visited = new LinkedList<>();
        ko.add(n);
        visited.add(n);
        while(ko.size() != 0){
            Node besokt = ko.poll();
            System.out.print(besokt.getNodeVerdi() + " ");
            for (Node nabo : besokt.getNaboer()){
                if(!visited.contains(nabo)){
                    visited.add(nabo);
                    ko.add(nabo);
                }
            }
        }
    }

    public boolean fjernNode(Node slettNode){
        if (!noder.contains(slettNode)){
            System.out.println("Kan ikke slette noden, da den ikke finnes");
            return false;
        } else {
            for (Node n : noder){
                n.getNaboer().remove(slettNode);
            }
            noder.remove(slettNode);
            antallNoder--;
            ArrayList<Kant> skalSlettes = new ArrayList<>();
            for (Kant k : kanter){
                if(k.getTil().equals(slettNode) || k.getFra().equals(slettNode)){
                    skalSlettes.add(k);
                }
            }
            for (Kant k : skalSlettes){
                kanter.remove(k);
            }
            return true;
        }
    }

    public boolean fjernKant(Node fra, Node til){
        //Lager temp kant
        Kant tempKant = new Kant(fra, til, 1);
        return kanter.remove(tempKant);
    }

    public void leggTilNode(Node n){
        if(!noder.contains(n)){
            noder.add(n);
            antallNoder++;
        }
    }

    public void leggTilKant(int fra, int til, int vekt){
        Node fraNode = null;
        Node tilNode = null;

        for(Node n : noder){
            if(n.getNodeVerdi() == fra){
                fraNode = n;
            } else if(n.getNodeVerdi() == til){
                tilNode = n;
            }
        }
        if(fraNode != null && tilNode != null){
            fraNode.leggTilNabo(tilNode);
            tilNode.leggTilNabo(fraNode);
        }
        Kant kant = new Kant(fraNode, tilNode, vekt);
        kanter.add(kant);
    }

    public void visNoder(){
        for(Node n : noder){
            System.out.println(n.getNodeVerdi() + " naboer:");
            for (Node nabo : n.getNaboer()){
                System.out.print(nabo.getNodeVerdi() + " ");
            }
            System.out.println();
        }
    }
    public void visKanter(){
        for (Kant kant : kanter){
            System.out.println("fra: " + kant.getFra().getNodeVerdi() + " til: "
            + kant.getTil().getNodeVerdi() + " vekt: " + kant.getVekt());
        }
    }

    public Node hentNodeNummer(int nummer){
        for (Node n : noder){
            if (n.getNodeVerdi() == nummer){
                return n;
            }
        }
        System.out.println("Fant ikke noden du ville hente, returnerer en ugyldig node");
        return new Node(-1);
    }
}

