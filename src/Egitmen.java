import java.util.ArrayList;

public class Egitmen extends Kisi {

    private ArrayList<Kurs> katildigiKurslar;


    public Egitmen(String isim, int tc) {
        super(isim, tc);
        System.out.println(isim+" egitmeni yaratıldı.");
    }

    public Kurs kursYarat(String kursAdi, Egitmen egitmen){
        Kurs kurs = new Kurs(kursAdi,egitmen);
        System.out.println(kursAdi+" "+ egitmen+" ile yaratıldı.");
        return kurs;
    }

    @Override
    public String toString() {
        return "Egitmen{" +
                "katildigiKurslar=" + katildigiKurslar +
                '}';
    }
}
