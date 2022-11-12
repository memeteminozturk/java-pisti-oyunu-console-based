
import java.security.SecureRandom;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        KartManager kartManager = new KartManager();
        OyunManager oyunManager = new OyunManager();
        SecureRandom random = new SecureRandom();

        Scanner scanner = new Scanner(System.in);
        System.out.println("1.OYUNA BAŞLA.");
        System.out.println("2.ÇIK");
        int a = scanner.nextInt();
        switch (a) {
            case 1:
                System.out.println("Lütfen ne yapmak istediğinizi seçiniz.");
                System.out.println('\n' + "1.Desteyi kar ve oyuna başla.");
                System.out.println("2.Kartları dağıt ve hemen başla!");
                int b = scanner.nextInt();
                switch (b) {
                    case 1:
                        kartManager.kartlariKaristir(oyunManager);
                        System.out.println("Deste karıldı!");
                    case 2:
                        System.out.println("OYUN BAŞLADI!!!!");
                        oyunManager.oyunBasla();

                        // while (kartDestesi.deste.size()!=0) {
                        for (int i = 0; i < 6; i++) {

                            System.out.println("Atmak istediğiniz kartı seçiniz.");
                            kartManager.kartVer(oyunManager);
                            int c = scanner.nextInt();
                            System.out.println("Oynadığınız kart: " + kartManager.secilenDeste.get(c - 1));
                            oyunManager.getOrtadakiKartlar().add(kartManager.secilenDeste.get(c - 1));

                            //rakip oynaması
                            int rakipKart2;
                            rakipKart2 = random.nextInt((oyunManager.getDeste().size() - 1));
                            while (oyunManager.getDeste().get(rakipKart2) == kartManager.secilenDeste.get(c - 1)) {
                                rakipKart2 = random.nextInt((oyunManager.getDeste().size() - 1));
                            }
                            oyunManager.kontrolEtDost(kartManager);
                            System.out.println("Rakibin Oynadığı kart: " + oyunManager.getDeste().get(rakipKart2));
                            oyunManager.getOrtadakiKartlar().add(oyunManager.getDeste().get(rakipKart2));
                            oyunManager.kontrolEtRakip(kartManager);
                            oyunManager.rakipCikar(rakipKart2);

                            oyunManager.oyna(c, kartManager.secilenDeste);
                            c = scanner.nextInt();
                            oyunManager.getOrtadakiKartlar().add(kartManager.secilenDeste.get(c - 1));
                            oyunManager.kontrolEtDost(kartManager);

                            oyunManager.rakipOyna();
                            oyunManager.kontrolEtRakip(kartManager);

                            oyunManager.oyna(c, kartManager.secilenDeste);
                            c = scanner.nextInt();
                            oyunManager.getOrtadakiKartlar().add(kartManager.secilenDeste.get(c - 1));
                            oyunManager.kontrolEtDost(kartManager);

                            oyunManager.rakipOyna();
                            oyunManager.kontrolEtRakip(kartManager);

                            oyunManager.oyna(c, kartManager.secilenDeste);
                            c = scanner.nextInt();
                            oyunManager.getOrtadakiKartlar().add(kartManager.secilenDeste.get(c - 1));
                            oyunManager.kontrolEtDost(kartManager);

                            oyunManager.rakipOyna();
                            oyunManager.kontrolEtRakip(kartManager);

                           // oyunManager.oyna(c, kartManager.secilenDeste);
                        }
                        System.out.println("OYUN BİTTİ!!");
                        System.out.println("Rakibinizin puanı: " + (oyunManager.getKazanilanRakip().size() + oyunManager.getPistiRakip()));
                        System.out.println("Sizin puanınız: " + (oyunManager.getKazanilan().size() + oyunManager.getPistiDost()));


                }

                break;
            case 2:
                System.out.println("Çıktığınıza üzüldük.İyi günler dileriz.");
                System.exit(0);
        }
    }
}
