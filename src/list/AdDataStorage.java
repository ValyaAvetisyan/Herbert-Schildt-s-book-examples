package list;

import listClass.model.Ad;

public class AdDataStorage {
    public Advertisement adArray[] = new Advertisement[10];
    public int adSize = 0;
    public void addAd(Ad advertisment) {
        if (adSize == adArray.length) {
            extendAd();
        }
//        adArray[adSize++]=advertisment;
    }
    private void extendAd() {
        Advertisement[] temp = new Advertisement[adArray.length + 10];
        for (int i = 0; i < adArray.length; i++) {
            temp[i] = adArray[i];
        }
        adArray = temp;
    }
    public void printAds() {
        for (int i = 0; i < adSize; i++) {
            System.out.print(adArray[i] + " ");

        }

    }
}
