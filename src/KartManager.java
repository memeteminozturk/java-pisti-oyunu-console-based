
import java.security.SecureRandom;
import java.util.ArrayList;

public class KartManager extends KartDestesi{


    public void kartlariKaristir(OyunManager oyunManager) {
        SecureRandom random = new SecureRandom();
        new OyunManager();
        for (int i = 0; i< oyunManager.getDeste().size(); i++){
            int sayac=0;
            int rastgele= random.nextInt(oyunManager.getDeste().size()-1);
            String temp= oyunManager.getDeste().get(sayac);
            oyunManager.getDeste().set(sayac, oyunManager.getDeste().get(rastgele));
            oyunManager.getDeste().set(rastgele,temp);
            sayac++;

        }
    }
    ArrayList<String> secilenDeste;
    public void kartVer(OyunManager oyunManager) {
        {
        SecureRandom random = new SecureRandom();
            new OyunManager();
            secilenDeste = new ArrayList<String>();
            //rastgele kart seçip diziye atama
            for (int i = 0; i < 4; i++) {

                int x = random.nextInt(oyunManager.getDeste().size()-1);
                secilenDeste.add(oyunManager.getDeste().get(x));
                oyunManager.getDeste().remove(x);
            }
        }
        //seçilen kart destesini yazdırma
        for (int i=0;i<secilenDeste.size();i++){
            System.out.println((i+1)+". "+secilenDeste.get(i));
        }
    }

}
