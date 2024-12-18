package com.lenyan.leetcode.editor.cn.kama;

import java.util.Scanner;

public class Replacenumbers {
    
    public static String replaceNumber(String s) {
        int count = 0; // 统计数字的个数
        int sOldSize = s.length();
        for (int i = 0; i < s.length(); i++) {
            if(Character.isDigit(s.charAt(i))){
                count++;
            }
        }
        // 扩充字符串s的大小，也就是每个空格替换成"number"之后的大小
        char[] newS = new char[s.length() + count * 5];
        int sNewSize = newS.length;
        // 将旧字符串的内容填入新数组
        System.arraycopy(s.toCharArray(), 0, newS, 0, sOldSize);
        // 从后先前将空格替换为"number"
        for (int i = sNewSize - 1, j = sOldSize - 1; j < i; j--, i--) {
            if (!Character.isDigit(newS[j])) {
                newS[i] = newS[j];
            } else {
                newS[i] = 'r';
                newS[i - 1] = 'e';
                newS[i - 2] = 'b';
                newS[i - 3] = 'm';
                newS[i - 4] = 'u';
                newS[i - 5] = 'n';
                i -= 5;
            }
        }
        return new String(newS);
    };
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String s = scanner.next();
        System.out.println(replaceNumber(s));
        scanner.close();
    }
}