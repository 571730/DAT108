import java.util.LinkedList;

public class Node {
    private int nodeVerdi;
    private LinkedList<Node> naboer;

    public Node(int nodeVerdi){
        this.nodeVerdi = nodeVerdi;
        naboer = new LinkedList<>();
    }

    public void leggTilNabo(Node node){
        naboer.add(node);
    }

    public int getNodeVerdi() {
        return nodeVerdi;
    }

    public void setNodeVerdi(int nodeVerdi) {
        this.nodeVerdi = nodeVerdi;
    }

    public LinkedList<Node> getNaboer() {
        return naboer;
    }

    public void setNaboer(LinkedList<Node> naboer) {
        this.naboer = naboer;
    }

    @Override
    public boolean equals(Object n){
        Node node = (Node) n;
        return nodeVerdi == node.getNodeVerdi();
    }

    @Override
    public String toString(){
        return Integer.toString(nodeVerdi);
    }
}
