public class Kant implements Comparable<Kant> {
    private Node fra;
    private Node til;
    private int vekt;


    public Kant(Node fra, Node til, int vekt){
        this.fra = fra;
        this.til = til;
        this.vekt = vekt;
    }

    public int getVekt() {
        return vekt;
    }

    public void setVekt(int vekt) {
        this.vekt = vekt;
    }

    public Node getFra() {
        return fra;
    }

    public void setFra(Node fra) {
        this.fra = fra;
    }

    public Node getTil() {
        return til;
    }

    public void setTil(Node til) {
        this.til = til;
    }

    @Override
    public boolean equals(Object o){
        Kant k = (Kant) o;
        return (k.getFra() == fra && k.getTil() == til) ||
                (k.getFra() == til && k.getTil() == fra);
    }

    @Override
    public int compareTo(Kant k){
        return vekt - k.getVekt();
    }

    @Override
    public String toString(){
        return "" + fra + " -- " + til;
    }
}
