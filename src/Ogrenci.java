import java.util.ArrayList;
import java.util.LinkedList;

public class Ogrenci extends Kisi {

    private ArrayList<Kurs> katildigiKurslar;
    private LinkedList<Ders> izlenecekDersler;

    public LinkedList<Ders> getIzlenecekDersler() {
        return izlenecekDersler;
    }


    public Ogrenci(String isim, int tc) {
        super(isim, tc);
        katildigiKurslar = new ArrayList<>();
        izlenecekDersler = new LinkedList<>();
        System.out.println(isim + " ogrencisi yaratıldı.");
    }

    public void kursaKatil(Kurs katilinacakKurs) {
        if (katilinacakKurs.kursYayindaKontrol()) {
            katilinacakKurs.getKursOgrencileri().add(this);
            this.katildigiKurslar.add(katilinacakKurs);
            System.out.println("Ogrenci " + katilinacakKurs.getKursAdi() + "'a katıldı.");
        } else System.out.println(katilinacakKurs.getKursAdi() + " Kursu yayında değil o sebeple öğrenci katılamadi.");

    }

    public void kurstanAyril(Kurs ayrilinilacakKurs) {
        if (katildigiKurslar.contains(ayrilinilacakKurs)) {
            katildigiKurslar.remove(ayrilinilacakKurs);
        }
        System.out.println(ayrilinilacakKurs + "' silindi.");
    }

    public void listeyeDersEkle(Ders eklenecekDers) {

        boolean dersBulundu=false;
        for (Kurs a : katildigiKurslar) {

            if (a.getKurstakiDersler().contains(eklenecekDers)) {

                if (!izlenecekDersler.contains(eklenecekDers)) {

                    izlenecekDersler.add(eklenecekDers);
                    System.out.println(eklenecekDers.getDersBaslik() + " dersi listeye eklendi.");
                    dersBulundu=true;
                    break;

                } else {
                    System.out.println(eklenecekDers.getDersBaslik() + " zaten listeye ekli.");
                    dersBulundu=true;
                    break;
                }

            }
        }
        if (!dersBulundu){
            System.out.println(eklenecekDers.getDersBaslik()+" dersi, Öğrencinin kayıtlı olduğu kursların içinde bulunamadı.");
        }


    }

    public void listedenDersCikar(Ders cikarilacakDers) {
        if (izlenecekDersler.contains(cikarilacakDers)) {
            izlenecekDersler.remove(cikarilacakDers);
            System.out.println(cikarilacakDers.getDersBaslik() + " listeden çıkarıldı");
        } else System.out.println(cikarilacakDers.getDersBaslik() + " zaten listede bulunmuyor.");
    }

    @Override
    public String toString() {
        return "Ogrenci{" +
                "katildigiKurslar=" + katildigiKurslar +
                ", izlenecekDersler=" + izlenecekDersler +
                '}';
    }

}
