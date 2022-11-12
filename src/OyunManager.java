
import java.security.SecureRandom;
import java.util.ArrayList;

public class OyunManager extends KartDestesi {
    private ArrayList<String> ortadakiKartlar;
    {
        setOrtadakiKartlar(new ArrayList<String>());
    }
    private ArrayList<String> kazanilanRakip;
    {
        setKazanilanRakip(new ArrayList<String>());
    }
    private ArrayList<String> kazanilan;
    {
        setKazanilan(new ArrayList<String>());
    }
    private int pistiDost=0;
    private int pistiRakip=0;


    public void oyunBasla() {
        SecureRandom random = new SecureRandom();
        for (int i = 0; i < 3; i++) {
            int x = random.nextInt(getDeste().size()-1);
            getOrtadakiKartlar().add(getDeste().get(x));
            getDeste().remove(x);

        }
        int y = random.nextInt(getDeste().size()-1);
        System.out.println("3 ters kart atıldı.");
        System.out.println("Ortadaki kart: " + getDeste().get(y));
        getOrtadakiKartlar().add(getDeste().get(y));
        getDeste().remove(y);
    }

    //seçilen kartı ortadakiKartlar dizisine kaydedip kendi dizimizden silme
    public void oyna(int c, ArrayList<String> secilenDeste) {
        System.out.println("Atmak istediğiniz kartı seçiniz.");
        secilenDeste.remove(c - 1);
        for (int i = 0; i < secilenDeste.size(); i++) {
            System.out.println((i + 1) + ". " + secilenDeste.get(i));
        }
    }
    public void rakipOyna() {
        SecureRandom random=new SecureRandom();
        int rakipKart = random.nextInt(getDeste().size());
        System.out.println("Rakibin Oynadığı kart: " + getDeste().get(rakipKart));
        getOrtadakiKartlar().add(getDeste().get(rakipKart));
        getDeste().remove(rakipKart);

    }

    public void kontrolEtDost(KartManager kartManager){
        new KartManager();
        if (getOrtadakiKartlar().size() > 1) {
            String str = getOrtadakiKartlar().get(getOrtadakiKartlar().size() - 1);
            String[] ayrik1 = str.split(" ");
            String str2 = getOrtadakiKartlar().get(getOrtadakiKartlar().size() - 2);
            String[] ayrik2 = str2.split(" ");
            if (getOrtadakiKartlar().size()==2){
                if (ayrik1[1].equals(ayrik2[1])) {
                    for (int i = 0; i < getOrtadakiKartlar().size(); i++) {
                        getKazanilan().add(getOrtadakiKartlar().get(i));

                    }
                    getOrtadakiKartlar().removeAll(getOrtadakiKartlar());
                    System.out.println("PİŞTİ!!!!!!");
                    setPistiDost(getPistiDost()+10);
                    System.out.println("KARTLARI ALDINIZ.");
                }
                else if (ayrik1[1].equals("Valesi")){
                    for (int i = 0; i < getOrtadakiKartlar().size(); i++) {
                        getKazanilan().add(getOrtadakiKartlar().get(i));

                    }
                    getOrtadakiKartlar().removeAll(getOrtadakiKartlar());
                    System.out.println("KARTLARI ALDINIZ.");
                }
            }
            else if (getOrtadakiKartlar().size()>2) {
                if (ayrik1[1].equals(ayrik2[1])) {
                    for (int i = 0; i < getOrtadakiKartlar().size(); i++) {
                        getKazanilan().add(getOrtadakiKartlar().get(i));

                    }
                    getOrtadakiKartlar().removeAll(getOrtadakiKartlar());
                    System.out.println("KARTLARI ALDINIZ.");
                }
                if (ayrik1[1].equals("Valesi")) {
                    for (int i = 0; i < getOrtadakiKartlar().size(); i++) {
                        getKazanilan().add(getOrtadakiKartlar().get(i));

                    }
                    getOrtadakiKartlar().removeAll(getOrtadakiKartlar());
                    System.out.println("KARTLARI ALDINIZ.");

                }
            }
        }

    }

    public void kontrolEtRakip(KartManager kartManager) {
        new KartManager();
        if (getOrtadakiKartlar().size() > 1) {
            String str = getOrtadakiKartlar().get(getOrtadakiKartlar().size() - 1);

            String[] ayrik1 = str.split(" ");
            String str2 = getOrtadakiKartlar().get(getOrtadakiKartlar().size() - 2);
            String[] ayrik2 = str2.split(" ");
            if (getOrtadakiKartlar().size()==2){
                if (ayrik2[1].equals(ayrik1[1])) {

                    for (int i = 0; i < getOrtadakiKartlar().size(); i++) {
                        getKazanilanRakip().add(getOrtadakiKartlar().get(i));

                    }
                    getOrtadakiKartlar().removeAll(getOrtadakiKartlar());
                    System.out.println("PİŞTİ!!!!!!!");
                    setPistiRakip(getPistiRakip()+10);
                    System.out.println("RAKİP KARTLARI ALDI.");
                }
                else if (ayrik1[1].equals("Valesi")){
                    for (int i = 0; i < getOrtadakiKartlar().size(); i++) {
                        getKazanilanRakip().add(getOrtadakiKartlar().get(i));

                    }
                    getOrtadakiKartlar().removeAll(getOrtadakiKartlar());
                    System.out.println("RAKİP KARTLARI ALDI.");
                }
            }
            else if (getOrtadakiKartlar().size()>2) {
                if (ayrik2[1].equals(ayrik1[1])) {

                    for (int i = 0; i < getOrtadakiKartlar().size(); i++) {
                        getKazanilanRakip().add(getOrtadakiKartlar().get(i));

                    }
                    getOrtadakiKartlar().removeAll(getOrtadakiKartlar());
                    System.out.println("RAKİP KARTLARI ALDI.");
                }
                if (ayrik1[1].equals("Valesi")) {
                    for (int i = 0; i < getOrtadakiKartlar().size(); i++) {
                        getKazanilanRakip().add(getOrtadakiKartlar().get(i));

                    }
                    getOrtadakiKartlar().removeAll(getOrtadakiKartlar());
                    System.out.println("RAKİP KARTLARI ALDI.");
                }

            }
        }


    }

    public void rakipCikar(int rakipKart2){
        getDeste().remove(rakipKart2);
    }

    /*public void kartDestesiSayısı(){
        System.out.println(getDeste().size());
    }*/

    public ArrayList<String> getOrtadakiKartlar() {
        return ortadakiKartlar;
    }

    public void setOrtadakiKartlar(ArrayList<String> ortadakiKartlar) {
        this.ortadakiKartlar = ortadakiKartlar;
    }

    public ArrayList<String> getKazanilanRakip() {
        return kazanilanRakip;
    }

    public void setKazanilanRakip(ArrayList<String> kazanilanRakip) {
        this.kazanilanRakip = kazanilanRakip;
    }

    public ArrayList<String> getKazanilan() {
        return kazanilan;
    }

    public void setKazanilan(ArrayList<String> kazanilan) {
        this.kazanilan = kazanilan;
    }

    public int getPistiDost() {
        return pistiDost;
    }

    public void setPistiDost(int pistiDost) {
        this.pistiDost = pistiDost;
    }

    public int getPistiRakip() {
        return pistiRakip;
    }

    public void setPistiRakip(int pistiRakip) {
        this.pistiRakip = pistiRakip;
    }
}
