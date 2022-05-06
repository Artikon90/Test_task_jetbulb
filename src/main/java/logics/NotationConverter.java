package logics;
import exceptions.InvalidValueException;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedHashSet;
//TODO 1) валидация на соответствие символов
//TODO 2) добавить валидацию на пустоту
//TODO 3) Поправить логику, чтобы не учитывала одну и ту же рим. цифру дважды
//TODO 4) Сдела
public class NotationConverter {
    static final HashMap<Character, Integer> romanNumber = new HashMap<>();

    // I = 1 V = 5
    // IV = 4 "IV"?
    static {
        romanNumber.put('I', 1);
        romanNumber.put('V', 5);
        romanNumber.put('X', 10);
        romanNumber.put('L', 50);
        romanNumber.put('C', 100);
        romanNumber.put('D', 500);
        romanNumber.put('M', 1000);
    }
    public int toArabic(String romanNotation) throws InvalidValueException {
        if(romanNotation.isEmpty()) {
            throw new InvalidValueException();
        }

        int result = 0;
        char[] charArray = romanNotation.toCharArray();
        for(char i : charArray) {
            checkValid(i);
        }
        //если число участвует в уменьшении другого числа, то егоо не нужно учитывать еще раз, !!!
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

    void checkValid(char charCheck) {
        if(!romanNumber.containsKey(charCheck)) {
            throw new InvalidValueException();
        }
    }
}