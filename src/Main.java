// https://app.patika.dev/
// https://app.patika.dev/thendbranch

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        /*
        Java ile mesafeye ve şartlara göre uçak bileti fiyatı hesaplayan programı yapın.
            Kullanıcıdan Mesafe (KM),
            yaşı ve yolculuk tipi (Tek Yön, Gidiş-Dönüş) bilgilerini alın.
            Mesafe başına ücret 0,10 TL / km olarak alın.
            İlk olarak uçuşun toplam fiyatını hesaplayın
            sonrasında ki koşullara göre müşteriye aşağıdaki indirimleri uygulayın ;

        Kullanıcıdan alınan değerler geçerli
            (mesafe ve yaş değerleri pozitif sayı,
             yolculuk tipi ise 1 veya 2) olmalıdır.
            Aksi takdirde kullanıcıya "Hatalı Veri Girdiniz !" şeklinde bir uyarı verilmelidir.

            Kişi 12 yaşından küçükse bilet fiyatı üzerinden %50 indirim uygulanır.
            Kişi 12-24 yaşları arasında ise bilet fiyatı üzerinden %10 indirim uygulanır.
            Kişi 65 yaşından büyük ise bilet fiyatı üzerinden %30 indirim uygulanır.
            Kişi "Yolculuk Tipini" gidiş dönüş seçmiş ise bilet fiyatı üzerinden %20 indirim uygulanır.
         */

        // Kullanıcıdan değerlerimizi alalım.

        Scanner input = new Scanner(System.in);

        System.out.println("!! Uçak Bilet Fiyatı Hesaplama !!");
        System.out.print("Gidilecek Mesafe (KM) : ");
        int mesafe = input.nextInt();

        System.out.print("Yaşınız : ");
        int yas = input.nextInt();

        System.out.print("1.) Tek Yön\n2.) Gidiş - Dönüş\nYolculuk Tipinizi Seçiniz : ");
        int tip = input.nextInt();

        // KULLANICIDAN ALINAN DEĞERLER POZİTİF OLMALI KONTROL.

        if (mesafe>0 && yas>0 && (tip == 1 || tip == 2)){
            // Uçuşun toplam fiyatının hesaplanması.
            double birim =  0.10;
            double bilet = birim*mesafe;
            System.out.println("Uçuşun Toplam Fiyatı : " + bilet);

            // Koşullara göre indirim uygulama
            if (yas<12) {
                double indirim = bilet*0.50;
                if (tip == 2){
                    double gbi = 2*(indirim - (indirim*0.20));
                    System.out.println("Gidiş Dönüşlü İndirimli Bilet Fiyatı : " + gbi);
                }else {
                    System.out.println("İndirimli Bilet Ücreti : " + indirim);
                }

            } else if (yas>=12 && yas<24) {
                double k2 = bilet - (bilet*0.10);
                if (tip == 2){
                    double gbi = 2*(k2 - (k2*0.20));
                    System.out.println("Gidiş Dönüşlü İndirimli Bilet Fiyatı : " + gbi);
                }else {
                    System.out.println("İndirimli Bilet Ücreti : " + k2);
                }

            } else if (yas>65) {
                double k3 = bilet - (bilet*0.30);
                if (tip == 2){
                    double gbi = 2*(k3 - (k3*0.20));
                    System.out.println("Gidiş Dönüşlü İndirimli Bilet Fiyatı : " + gbi);
                }else {
                    System.out.println("İndirimli Bilet Ücreti : " + k3);
                }

            }else if (tip == 2){
                    double twoway = (2*(bilet))-((2*(bilet))*0.20);
                    System.out.println("Gidiş Dönüşlü Bilet Alınırsa\nUygulanan İndirimle Bilet Fiyatı : " + twoway);
            }
        }else {
            System.out.println("Hatalı Veri Girdiniz !");
        }

    }
}