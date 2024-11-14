import java.util.ArrayList;

public class Kurs {

    private String kursAdi;
    private ArrayList<Ders> kurstakiDersler;
    private ArrayList<Egitmen> kursEgitmenleri;
    private ArrayList<Ogrenci> kursOgrencileri;
    private boolean yayinda;

    public String getKursAdi() {
        return kursAdi;
    }

    public ArrayList<Ogrenci> getKursOgrencileri() {
        return kursOgrencileri;
    }

    public ArrayList<Ders> getKurstakiDersler() {
        return kurstakiDersler;
    }

    public Kurs(String kursAdi, Egitmen basEgitmen) {
        this.kursAdi = kursAdi;
        this.kurstakiDersler = new ArrayList<>();
        this.kursEgitmenleri = new ArrayList<>();
        this.kursOgrencileri = new ArrayList<>();
        kursEgitmenleri.add(basEgitmen);
        this.yayinda=false;
        System.out.println(kursAdi+" isimli ve "+ basEgitmen.getIsim()+ " baş egitmene sahip Kurs yaratıldı.");
    }

    public void kursaEgitmenEkle(Egitmen yeniEgitmen){
        if(!kursEgitmenleri.contains(yeniEgitmen)){
            kursEgitmenleri.add(yeniEgitmen);
            System.out.println(yeniEgitmen.getIsim()+" kursa eklendi.");
        }else System.out.println(yeniEgitmen.getIsim()+" zaten kursta tanımlı bir eğitmendir.");
    } public void kurstanEgitmenCikar(Egitmen egitmen){
        if(kursEgitmenleri.contains(egitmen)){
            if(!egitmen.getIsim().equals(kursEgitmenleri.get(0).getIsim())){
                kursEgitmenleri.remove(egitmen);
                System.out.println(egitmen.getIsim() + " kurstan cıkarıldı.");
            }else System.out.println("Başöğretmen listeden çıkarılamaz.");
        }else System.out.println("Eğitmen zaten yok. O sebeple çıkarılamadı.");
    }
    public void kursaDersEkle(Ders eklenecekders) {
        kurstakiDersler.add(eklenecekders);
    }
    public void kurstanDersCikar(Ders cikarilacakDers) {
        kurstakiDersler.add(cikarilacakDers);
    }

    private int kurstakiDersSayisi(){
        return kurstakiDersler.size();
    }

    private int kurstakiDerslerinSuresi(){
        int toplam=0;
        for (Ders ders:kurstakiDersler){
           toplam+=ders.getDakika();
        }
        return toplam;
    }

    public boolean kursYayindaKontrol(){
        if ((kurstakiDersler.size()>=5) && (kurstakiDerslerinSuresi()>5)){
            yayinda= true;
            return true;
        }else return false;

    }

    @Override
    public String toString() {
        return "Kurs{" +
                "kursAdi='" + kursAdi + '\'' +
                ", kurstakiDersler=" + kurstakiDersler +
                ", kursEgitmenleri=" + kursEgitmenleri +
                ", kursOgrencileri=" + kursOgrencileri +
                ", yayinda=" + yayinda +
                '}';
    }
}
