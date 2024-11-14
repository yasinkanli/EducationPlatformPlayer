import java.util.Iterator;
import java.util.LinkedList;
import java.util.ListIterator;
import java.util.Scanner;


public class Main {
    public static void main(String[] args) {

        Olustur olustur = new Olustur();
    }
}


class Olustur {
    public Olustur() {
        Ogrenci ogr1 = new Ogrenci("Ahmet", 123);
        Ogrenci ogr2 = new Ogrenci("Haşmet", 123);

        Egitmen yasin = new Egitmen("Yasin", 123);


        //--
        Kurs javaKursu = new Kurs("Java Kursu", yasin);

        Ders d1 = new Ders(1, "Java Nedir", 3.4);
        Ders d2 = new Ders(2, "Method Nedir", 13.4);
        Ders d3 = new Ders(3, "Class Nedir", 43.4);
        Ders d4 = new Ders(4, "Erişim Belirleyici Nedir", 23.4);
        Ders d5 = new Ders(5, "Static Nedir", 33.4);

        javaKursu.kursaDersEkle(d1);
        javaKursu.kursaDersEkle(d2);
        javaKursu.kursaDersEkle(d3);
        javaKursu.kursaDersEkle(d4);
        javaKursu.kursaDersEkle(d5);

        //--

        Kurs ileriSeviyeJava = new Kurs("İleri Seviye Java", yasin);

        Ders d6 = new Ders(6, "Kalıtım", 3.4);
        Ders d7 = new Ders(7, "Çok Biçimlilik", 13.4);
        Ders d8 = new Ders(8, "Soyut Sınıflar", 43.4);
        Ders d9 = new Ders(9, "Arayüzler", 23.4);
        Ders d10 = new Ders(10, "Lambda İfadeler", 33.4);


        ileriSeviyeJava.kursaDersEkle(d6);
        ileriSeviyeJava.kursaDersEkle(d7);
        ileriSeviyeJava.kursaDersEkle(d8);
        ileriSeviyeJava.kursaDersEkle(d9);
        ileriSeviyeJava.kursaDersEkle(d10);

        //--
        Kurs android = new Kurs("Anroid", yasin);
        Ders d11 = new Ders(6, "Python", 33.3);
        android.kursaDersEkle(d11);

        //--

        ogr1.kursaKatil(javaKursu);
        ogr1.kursaKatil(ileriSeviyeJava);

        ogr1.listeyeDersEkle(d1);
        ogr1.listeyeDersEkle(d9);
        ogr1.listeyeDersEkle(d6);

        listeyiOynat(ogr1.getIzlenecekDersler());
    }

    public static void listeyiOynat(LinkedList<Ders> izlenecekDersler) {

        Ders suankiDers = null;

        boolean ileriDogruHareket=false;

        ListIterator<Ders> iterator = izlenecekDersler.listIterator();

        if (izlenecekDersler.size() > 0) {
            Ders ilkDers = iterator.next();
            suankiDers=ilkDers;
            System.out.println("İzlenen ders : " + ilkDers.getDersBaslik() + " Süre: " + ilkDers.getDakika());
        } else System.out.println("Ders Listesi Boş.");


        menuGoster();
        boolean cikis = false;
        Scanner scn = new Scanner(System.in);

        while (!cikis) {

            System.out.print("Seçiminiz :");
            int kullaniciSecimi = scn.nextInt();
            switch (kullaniciSecimi) {
                case 0:
                    System.out.println("Uygulamadan cıkılıyor");
                    cikis = true;
                    break;
                case 1:
                    if(!ileriDogruHareket){
                        ileriDogruHareket=true;
                        if(iterator.hasNext()){
                            iterator.next();
                        }
                    }
                    if(iterator.hasNext()){
                        System.out.println("***************************************");
                        System.out.println("Bir sonraki ders: "+iterator.next().getDersBaslik());
                        System.out.println("***************************************");
                    }else System.out.println("Listenin sonundasınız.");
                    break;
                case 2:
                    if(ileriDogruHareket){
                        ileriDogruHareket=false;
                        if (iterator.hasPrevious()){
                            iterator.previous();
                        }
                    }
                    if(iterator.hasPrevious()){
                        System.out.println("***************************************");
                        System.out.println("Bir önceki ders: "+iterator.previous().getDersBaslik());
                        System.out.println("***************************************");
                    }else System.out.println("Listenin en başındasınız.");
                    break;
                case 3:
                    izlenecekDersleriListele(izlenecekDersler);
                    break;
                case 4:
                    System.out.println("***************************************");
                    System.out.println("Şuanki Ders : "+suankiDers.getDersBaslik());
                    System.out.println("***************************************");
                    break;

                case 9:
                    menuGoster();
                    break;

            }


        }


    }

    private static void izlenecekDersleriListele(LinkedList<Ders> dersler) {
        Iterator<Ders> iterator = dersler.listIterator();
        while(iterator.hasNext()){
            System.out.println(iterator.next());
        }
    }

    private static void menuGoster() {
        System.out.println("****************MENU*************");
        System.out.println("0 -> Çıkış\n" +
                "1->Bir Sonraki Derse Git\n" +
                "2->Bir Önceki Derse Git\n" +
                "3->Tüm Listeyi Göster\n" +
                "4->Şuanki Dersi Göster\n" +
                "9->Menüyü Göster\n");


    }
}
