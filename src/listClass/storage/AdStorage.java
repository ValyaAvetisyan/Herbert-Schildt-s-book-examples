package listClass.storage;

import listClass.model.Ad;
import listClass.model.User;

public class AdStorage {
    public Ad[] ads = new Ad[16];
    public int size = 0;

    public void add(Ad ad) {
        if (ads.length == size) {
            extend();
        }
        ads[size++] = ad;
    }

    private void extend() {
        Ad[] temp = new Ad[ads.length + 10];
        System.arraycopy(ads, 0, temp, 0, ads.length);
        ads = temp;
    }

    public void printAllAd() {
        for (int i = 0; i < size; i++) {
            System.out.println(ads[i]);

        }

    }

    public void printAdsByUser(User user) {
        for (int i = 0; i < size; i++) {
            if (ads[i].getUser().equals(user)) {
                System.out.println(ads[i]);
            }
        }
    }

    public void printByType(String type) {
        for (int i = 0; i < size; i++) {
            if (ads[i].getType().equals(type)) {
                System.out.println(ads[i]);
            }
        }
    }
}

