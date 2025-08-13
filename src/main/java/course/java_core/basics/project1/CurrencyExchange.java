package course.java_core.basics.project1;

import java.util.Scanner;

public class CurrencyExchange {

    private static final String[] currencyName = {"USD","EUR","UAH" ,"GBP"};
    private static final double[] exchangeRate = {1.0, 0.92, 36.8, 0.78};

    private static String[] history = new String[10];

    public static void main(String[] args) {
        start();
    }

    public static void start(){

        final Scanner scanner = new Scanner(System.in);

        boolean run = true;
        int historyCount = 0;

        while (run){
            run = false;


            System.out.println("Введіть назву валюти з якої хоче конвертувати!");
            String currencyNameFrom = scanner.next();

            if (!isValidCurrencyName(currencyNameFrom)){
                System.out.println("Ви ввели неправильну назву валюти " + currencyNameFrom + ", почніть все заново та спробуйте ще раз");
                run = true;
                continue;
            }

            System.out.println("Введіть назву валюти в яку хоче конвертувати!");
            String currencyNameTo = scanner.next();

            if (!isValidCurrencyName(currencyNameTo)){
                System.out.println("Ви ввели неправильну назву валюти " + currencyNameTo + ", почніть все заново та спробуйте ще раз");
                run = true;
                continue;
            }

            System.out.println("Ведіть суму яку хочете конвертувати");
            double capital = scanner.nextDouble();



            double converted = capital / getExchangeRateFromCurrencyName(currencyNameFrom) * getExchangeRateFromCurrencyName(currencyNameTo);

            System.out.println("Конвертована сума: " + converted + ", " + currencyNameTo);

            if (historyCount == history.length){

                history = createNewStringArray(historyCount++);

            }else {

                history[historyCount++] = "Конвертована сума: " + converted + ", з " + currencyNameFrom + " до " + currencyNameTo;

            }

            System.out.println("Бажаєте продовжити? yes/no");
            String str = scanner.next();

            if (str.toLowerCase().equals("yes".toLowerCase()) || str.toLowerCase().contains("yes".toLowerCase())){
                run = true;
                continue;
            }


        }
    }

    private static String[] createNewStringArray(int historyCount){

        String[] newHistoryArray = new String[historyCount*2];

        for (int i = 0; i < historyCount; i++) {

            newHistoryArray[i] = history[i];
        }

        return newHistoryArray;
    }


    private static double getExchangeRateFromCurrencyName(String str){
        double res = 0;

        for (int i = 0; i < currencyName.length; i++){
            if (currencyName[i].equals(str) || currencyName[i].contains(str)){
                res = exchangeRate[i];
            }
        }

        return res;
    }

    private static boolean isValidCurrencyName(String str){
        for (int i = 0; i < currencyName.length; i++) {
            if (currencyName[i].equals(str) || currencyName[i].contains(str)){
                return true;
            }

        }
        return false;
    }

}
