package genericsCollectionsExamples;

import java.text.DateFormatSymbols;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

public class SimpleDate {
    public static void main(String[] args) {
        Date currentDate = new Date();
        SimpleDateFormat dateFormat = null;

        dateFormat = new SimpleDateFormat();
        System.out.println("Constructor 1: " + dateFormat.format(currentDate));

        dateFormat = new SimpleDateFormat("dd MM yyy");
        System.out.println("Constructor 2: " + dateFormat.format(currentDate));

        dateFormat = new SimpleDateFormat("dd mm ww", myDateFormatSymbols);
        System.out.println("Constructor 3: " + dateFormat.format(currentDate));

        dateFormat = new SimpleDateFormat("dd MMMM", Locale.ENGLISH);
        System.out.println("Constructor 4: " + dateFormat.format(currentDate));
    }

    private static DateFormatSymbols myDateFormatSymbols = new DateFormatSymbols() {
        @Override
        public String[] getWeekdays() {
            return super.getWeekdays();
        }
    };
}
//        @Override
//        public String[] getMonths() {
//            return new String[]{"января", "февраля", "марта", "апреля", "мая", "июня",
//                    "июля", "августа", "сентября", "октября", "ноября", "декабря"};
//        }





