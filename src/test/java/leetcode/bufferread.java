package leetcode;

import java.io.*;
import java.math.*;
import java.util.*;

public class bufferread {
    public static void main(String[] args) throws IOException { //抛出异常
        Scanner sc = new Scanner(System.in);
        BigInteger bigInteger = sc.nextBigInteger();
        Random random = new Random();
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));
        while (true) {
            String readLine = bufferedReader.readLine(); // 读取一行数据
            if (readLine == null || readLine.isEmpty())
                break;
        }
        out.write("test" + "\n");
        out.flush();

        Float float1 = 1.0f;
        BigDecimal bigDecimal = new BigDecimal(float1);
        BigDecimal divide = bigDecimal.divide(new BigDecimal(2), 2, BigDecimal.ROUND_HALF_UP);
    }
}

