import java.util.TreeMap;

class Converter {
    TreeMap<Character, Integer> rimKeyMap = new TreeMap<>();
    TreeMap<Integer, String> arabKeyMap = new TreeMap<>();

    public Converter() {
        rimKeyMap.put('I', 1);
        rimKeyMap.put('V', 5);
        rimKeyMap.put('X', 10);
        rimKeyMap.put('L', 50);
        rimKeyMap.put('C', 100);
        rimKeyMap.put('D', 500);
        rimKeyMap.put('M', 1000);

        arabKeyMap.put(1000, "M");
        arabKeyMap.put(900, "CM");
        arabKeyMap.put(500, "D");
        arabKeyMap.put(400, "CD");
        arabKeyMap.put(100, "C");
        arabKeyMap.put(90, "XC");
        arabKeyMap.put(50, "L");
        arabKeyMap.put(40, "XL");
        arabKeyMap.put(10, "X");
        arabKeyMap.put(9, "IX");
        arabKeyMap.put(5, "V");
        arabKeyMap.put(4, "IV");
        arabKeyMap.put(1, "I");

    }


    public boolean isRim(String number){

        return rimKeyMap.containsKey(number.charAt(0));
    }

    //15
    public String intToRim(int number) {
        String rim = "";
        int arabKey;
        do {
            arabKey = arabKeyMap.floorKey(number);
            rim += arabKeyMap.get(arabKey);
            number -= arabKey;
        } while (number != 0);
        return rim;


    }
    //XV
    public int rimToInt(String s) {
        int end = s.length() - 1;
        char[] arr = s.toCharArray();
        int arab;
        int result = rimKeyMap.get(arr[end]);
        for (int i = end - 1; i >= 0; i--) {
            arab = rimKeyMap.get(arr[i]);

            if (arab < rimKeyMap.get(arr[i + 1])) {
                result -= arab;
            } else {
                result += arab;
            }


        }
        return result;

    }
}