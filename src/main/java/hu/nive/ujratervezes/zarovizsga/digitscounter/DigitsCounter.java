package hu.nive.ujratervezes.zarovizsga.digitscounter;

import java.util.ArrayList;
import java.util.List;

public class DigitsCounter {

    public int getCountOfDigits(String s) {
        int count = 0;
        List<Character> digits = new ArrayList<>();
        if(s != null){
            for (int i = 0, len = s.length(); i < len; i++) {
                if (Character.isDigit(s.charAt(i))) {
                    if(!digits.contains(s.charAt(i))){
                        digits.add(s.charAt(i));
                        count++;
                    }
                }
            }
        }

        return count;
    }
}
