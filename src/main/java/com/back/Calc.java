package com.back;

public class Calc {
    public static int run(String num) {
        num = num.trim();

        int plus = num.lastIndexOf(" + ");
        int minus = num.lastIndexOf(" - ");
        int index = Math.max(plus, minus);

        if (index != -1) {
            String left = num.substring(0, index);
            String right = num.substring(index + 3);
            
            if (num.charAt(index + 1) == '+') {
                return run(left) + run(right);
            } else {
                return run(left) - run(right);
            }
        }

        int multi = num.lastIndexOf(" * ");
        if (multi != -1) {
            String left = num.substring(0, multi);
            String right = num.substring(multi + 3);
            return run(left) * run(right);
        }

        return Integer.parseInt(num);
    }
}
