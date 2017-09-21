package Algorythm;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * Created by sziszka on 2017.09.20..
 */
public class Algorythm {

    public String reverseString(String word) {
        ArrayList<Character> chars = new ArrayList<Character>();
        for (int i = 0; i < word.length(); i++) {
            char c = word.charAt(i);
            chars.add(c);
        }
        String result = "";
        for (int i = chars.size() -1; i != -1; i--) {
            result += chars.get(i);
        }
        return result;
    }

    public long factorialize(int number) {
        if (number == 0) {
            return 1;
        } else if (number < 0) {
            return 0;
        } else {
            ArrayList<Integer> nums = new ArrayList<Integer>();
            for (int i = number; i != 1; i--) {
                nums.add(i);
            }
            int result = 1;
            for (Integer integer : nums) {
                result = result * integer;
            }
            return result;
        }
    }

    public boolean palindrome(String word) {
        String lowerWord = word.toLowerCase();
        ArrayList<Character> chars = new ArrayList<Character>();
        for (int i = 0; i < lowerWord.length(); i++) {
            char c = lowerWord.charAt(i);
            if(Character.isLetterOrDigit(c) == true){
                chars.add(c);
            }
        }
        String result1 = "";
        String result2 = "";
        for (int i = 0; i < chars.size(); i++) {
            result1 += chars.get(i);
        }
        for (int i = chars.size() -1; i != -1; i--) {
            result2 += chars.get(i);
        }
        if (result1.equals(result2)){
            return true;
        } else {
            return false;
        }
    }

    public int findLongestWord(String word) {
        int max = word.length()-1;
        String smax = String.valueOf(max);
        ArrayList<Integer> nums = new ArrayList<Integer>();
        int num = 0;
        for (int i = 0; i < word.length(); i++) {
            char c = word.charAt(i);
            String curr = String.valueOf(word.valueOf(i));
            if(curr.equals(smax) && c != ' ' ) {
                num ++;
                nums.add(num);
            } else if(c != ' '){
                num++;
            } else {
                nums.add(num);
                num = 0;
            }
        }
        System.out.println(nums);
        int result = nums.get(0);
        for (int i = 0; i < nums.size(); i++) {
            if (result < nums.get(i)) {
                result = nums.get(i);
            }
        }
        return result;
    }

    public String titleCase(String word) {
        ArrayList<String> words = new ArrayList<String>();
        String s = "";
        for (int i = 0; i < word.length(); i++) {
            char c = word.charAt(i);
            String st = String.valueOf(c);
            System.out.println(st);
            if(i == word.length()-1){
                s += st;
                s = s.substring(0,1).toUpperCase() + s.substring(1).toLowerCase();
                words.add(s);
            } else if(!st.equals(" ")){
                s += st;
                System.out.println("S: " + s);
            } else {
                s = s.substring(0,1).toUpperCase() + s.substring(1).toLowerCase();
                words.add(s);
                s = "";
            }
        }
        String result = "";
        for (int i = 0; i < words.size(); i++) {
            result += words.get(i);
            result += " ";
        }
        return result;
    }

    public boolean confirmEnding(String word, String end) {
        int endLength = end.length();
        String result = "";
        for (int i = word.length() - end.length(); i < word.length(); i++) {
            if(i < 0) {
                return false;
            } else {
                char c = word.charAt(i);
                String s = String.valueOf(c);
                result += s;
            }
        }
        return result.equals(end);
    }

    public String repeatStringNumTimes(String word, int counter) {
        if(counter < 1){
            return "";
        } else {
            String result = "";
            String w = word;
            for (int i = 0; i < counter; i++) {
                result += w;
            }
            return result;
        }
    }

    public String truncateString(String word, int counter) {
        if(counter < 1) {
            return "";
        } else if(word.length() <= counter) {
            return word;
        } else {
            String result = "";
            for (int i = 0; i < counter; i++) {
                char c = word.charAt(i);
                result += String.valueOf(c);
            }
            if(result.length() < 3){
                return result += "...";
            } else {
                String res1 = "";
                for (int i = 0; i < result.length()-3; i++) {
                    char c = result.charAt(i);
                    res1 += String.valueOf(c);
                }
                res1 += "...";
                return res1;
            }
        }

    }

    public Object[] bouncer(Object[] objects) {
        ArrayList<Object> res = new ArrayList<Object>();
        for (int i = 0; i < objects.length; i++) {
            if (objects[i] instanceof Boolean) {
                boolean  bool= (Boolean) objects[i];
                if(bool == true){
                    res.add(bool);
                }
            } else if(objects[i] instanceof Integer) {
                int integ= (Integer) objects[i];
                if(integ != 0){
                    res.add(integ);
                }
            } else if(objects[i] instanceof String) {
                String st = (String) objects[i];
                if(!st.equals("")){
                    res.add(st);
                }
            } else if(objects[i] instanceof Float) {
                float flo = (Float) objects[i];
                res.add(flo);
            } else if(objects[i] instanceof Double) {
                double doub= (Double) objects[i];
                res.add(doub);
            } else if(objects[i] instanceof Character) {
                char c = (Character) objects[i];
                res.add(c);
            } else if(objects[i] instanceof Short) {
                short s = (Short) objects[i];
                res.add(s);
            } else if(objects[i] instanceof Byte) {
                byte b = (Byte) objects[i];
                res.add(b);
            } else if(objects[i] instanceof Long) {
                Long l = (Long) objects[i];
                res.add(l);
            }
        }
        Object[] result = new Object[res.size()];
        for (int i = 0; i < res.size(); i++) {
            result[i] = res.get(i);
        }
        for (int i = 0; i < result.length; i++) {
            System.out.println(result[i]);
        }
        return result;
    }

    public Object[] destroyer(Object[] numbers, Object... remove) {

        List<Object> objects = Arrays.asList(remove);

        List<Object> result = new ArrayList<>();

        for(Object o: numbers){
            if(!objects.contains(o)){
                result.add(o);
            }
        }

        return result.toArray();
    }

    public Object[] slasher(Object[] numbers, int counter) {
        if(numbers.length < counter){
            return new Object[0];
        } else {
            int size = numbers.length-counter;
            Object[] result = new Object[size];
            for (int i = 0; i < numbers.length; i++) {
                if(i >= counter){
                    result[i-counter] = numbers[i];
                }
            }
            for (int i = 0; i < result.length; i++) {
                System.out.println(result[i]);
            }

            return result;
        }
    }

    public int getIndexToIns(int[] array, int number){
        ArrayList<Integer> arrayList = new ArrayList<>();

        for (int i = 0; i < array.length; i++) {
            arrayList.add(array[i]);
        }

        Collections.sort(arrayList);

        int indexCounter = 0;

        for (int i = 0; i < arrayList.size(); i++) {
            if(number > arrayList.get(i)){
                indexCounter++;
            }
        }

        return indexCounter;
    }

    public int[] largestOfFour(int[][] array){

        int[] result = new int[4];

        for (int i = 0; i <array.length ; i++) {
            int max = array[i][0];
            for (int j = 0; j <array[i].length ; j++) {
                if(array[i][j] > max){
                    max = array[i][j];
                }
            }
            result[i] = max;
        }

        for (int i: result) {
            System.out.println(i);
        }
        return result;

    }

    public int[][] chunkArrayInGroups(int[] startArray, int number){

        Double temp = new Double(Math.ceil(startArray.length / (double)number));
        int numberOfSubarrays = temp.intValue();
        int counter = 0;
        int subArrayCounter = 0;

        int[][]result = new int[numberOfSubarrays][];


        List<Integer> startArrayList = new ArrayList<>();

        for (int i:startArray) {
            startArrayList.add(i);
        }

        int[]tempArray= new int[number];
        while(startArrayList.size() > number){
            if(counter < number){
                tempArray[counter] = startArrayList.get(0);
                startArrayList.remove(0);
                counter ++;
            }
            else{
                result[subArrayCounter] = tempArray;
                tempArray = new int[number];
                subArrayCounter ++;
                counter = 0;
            }
        }

        while(counter != number){
            tempArray[counter] = startArrayList.get(0);
            startArrayList.remove(0);
            counter ++;
        }
        result[subArrayCounter] = tempArray;
        subArrayCounter++;
        counter = 0;

        if(startArrayList.size() != 0){
            tempArray = new int[startArrayList.size()];
            for (int i:startArrayList) {
                tempArray[counter] = i;
                counter ++;
            }
            result[subArrayCounter] = tempArray;
        }

        return result;

    }

    public String rot13(String string){
        //Copy-paste
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < string.length(); i++) {
            char c = string.charAt(i);
            if       (c >= 'a' && c <= 'm') c += 13;
            else if  (c >= 'A' && c <= 'M') c += 13;
            else if  (c >= 'n' && c <= 'z') c -= 13;
            else if  (c >= 'N' && c <= 'Z') c -= 13;
            sb.append(c);
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        Algorythm algorythm = new Algorythm();
        int[] nums = {1, 2, 4, 6, 0};
        System.out.println(algorythm.getIndexToIns(nums, 5));
        int[][] numss = {{1,2,3,4},{1,2,3,5},{1,2,3,6},{1,2,3,7}};
        System.out.println(algorythm.largestOfFour(numss));
        System.out.println(algorythm.rot13("SERR"));
        System.out.println('a' + 13);
        System.out.println('m' + 13);
        System.out.println('n' - 13);
        System.out.println('z' - 13);
    }
}
