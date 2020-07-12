package com.algorithm.string;

import java.util.HashMap;
import java.util.Map;

public class TheValidString {
    public static void main(String[] args) {
        System.out.println("TheValid String problem");
        String input = "abcdefghhgfedecba";
        //String input = "abccc"; // no
        //String input = "ibfdgaeadiaefgbhbdghhhbgdfgeiccbiehhfcggchgghadhdhagfbahhddgghbdehidbibaeaagaeeigffcebfbaieggabcfbiiedcabfihchdfabifahcbhagccbdfifhghcadfiadeeaheeddddiecaicbgigccageicehfdhdgafaddhffadigfhhcaedcedecafeacbdacgfgfeeibgaiffdehigebhhehiaahfidibccdcdagifgaihacihadecgifihbebffebdfbchbgigeccahgihbcbcaggebaaafgfedbfgagfediddghdgbgehhhifhgcedechahidcbchebheihaadbbbiaiccededchdagfhccfdefigfibifabeiaccghcegfbcghaefifbachebaacbhbfgfddeceababbacgffbagidebeadfihaefefegbghgddbbgddeehgfbhafbccidebgehifafgbghafacgfdccgifdcbbbidfifhdaibgigebigaedeaaiadegfefbhacgddhchgcbgcaeaieiegiffchbgbebgbehbbfcebciiagacaiechdigbgbghefcahgbhfibhedaeeiffebdiabcifgccdefabccdghehfibfiifdaicfedagahhdcbhbicdgibgcedieihcichadgchgbdcdagaihebbabhibcihicadgadfcihdheefbhffiageddhgahaidfdhhdbgciiaciegchiiebfbcbhaeagccfhbfhaddagnfieihghfbaggiffbbfbecgaiiidccdceadbbdfgigibgcgchafccdchgifdeieicbaididhfcfdedbhaadedfageigfdehgcdaecaebebebfcieaecfagfdieaefdiedbcadchabhebgehiidfcgahcdhcdhgchhiiheffiifeegcfdgbdeffhgeghdfhbfbifgidcafbfcd";
        // yes
        //String input = "aaaaaaaaa"; // yes
        //String input = "aaaabbcc";
        //String input = "xxxaabbccrry";
        System.out.println(isValid(input));
    }

    static String isValid(String s) {
        String yes = "YES";
        String no = "NO";
        Map<Character, Integer> charCount = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            Character temp = s.charAt(i);
            if (charCount.containsKey(temp)) {
                int count = charCount.get(temp);
                count = count + 1;
                charCount.put(temp, count);
            } else {
                charCount.put(temp, 1);
            }
        }

        int sum = 0;
        int index = 0;
        int post = 0;
        boolean large_range = false;
        int range = 0;
        for (Map.Entry<Character, Integer> c : charCount.entrySet()) {
            System.out.println("Character:" + c.getKey() + "-number:" + c.getValue());
            int count = c.getValue();
            if (post != 0 && Math.abs(post - count) > 1) {
                large_range = true;
            }
            if (post != 0 && Math.abs(post - count) >= 1) {
                range++;
            }
            sum = sum + count;
            index++;
            post = count;
        }
        System.out.println("sum:" + sum + "-index:" + index);
        int check = sum % (index);
        int check_less = Math.abs(sum - 1) % (index);
        int check_great = Math.abs(sum + 1) % (index);
        System.out.println("check:" + check);
        System.out.println("check_less:" + check_less);
        System.out.println("check_great:" + check_great);
        if (check == 0 || (check_great == 0) || (check_less == 0)) {
            if (large_range && check != 0)
                return no;
            if (range > 1 && check == 0) return no;
            return yes;
        }
        return no;
    }

}
