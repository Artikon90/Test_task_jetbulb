package logics;

import exceptions.InvalidValueException;
import java.util.HashMap;

public class NotationConverter {
    public int toArabic(String romanNotation) throws InvalidValueException {
        HashMap<Character, Integer> romanNumber = new HashMap<>();
        romanNumber.put('I', 1);
        romanNumber.put('V', 5);
        romanNumber.put('X', 10);
        romanNumber.put('L', 50);
        romanNumber.put('C', 100);
        romanNumber.put('D', 500);
        romanNumber.put('M', 1000);
        //раскомментируй следующую строку, если требуется валидация без учета регистра
        //romanNotation = romanNotation.toUpperCase();
        char[] charArray = romanNotation.toCharArray();
        if (romanNotation.isBlank()) {
            throw new InvalidValueException();
        } else {
            for (char i : charArray) {
                if(!romanNumber.containsKey(i)) {
                    throw new InvalidValueException();
                }
            }
        }
        int result = 0;
        for (int i = 0; i < charArray.length; i++) {
            if(i + 1 < charArray.length && romanNumber.get(charArray[i]) < romanNumber.get(charArray[i + 1])) {
                result += romanNumber.get(charArray[i + 1]) - romanNumber.get(charArray[i]);
                i++;
            } else {
                result += romanNumber.get(charArray[i]);
            }
        }
        return result;
    }
}