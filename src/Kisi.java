abstract public class Kisi {

    private String isim;
    private int tc;

    public String getIsim() {
        return isim;
    }

    public void setIsim(String isim) {
        this.isim = isim;
    }

    public Kisi(String isim, int tc) {
        this.isim = isim;
        this.tc = tc;
    }

    @Override
    public String toString() {
        return "Kisi{" +
                "isim='" + isim + '\'' +
                ", tc=" + tc +
                '}';
    }
}
