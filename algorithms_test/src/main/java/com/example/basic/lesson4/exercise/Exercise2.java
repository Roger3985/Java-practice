package com.example.basic.lesson4.exercise;

public class Exercise2 {
    public static void main(String[] args) {
        final var N = 52;
        var poker = new int[N + 1];

        for (int i = 0; i <= N; i++) {
            poker[i] = i;
        }

        for (int i = 1; i <= N; i++) {
            var j = (int) (Math.random() * N);
            j = j == 0 ? 1 : j;
            var tmp = poker[j];
            poker[i] = poker[j];
            poker[j] = tmp;
        }

        char[] symblos = {'桃', '心', '專', '梅'};

        for (int i = 0; i <= N; i++) {
            System.out.println(symblos[(poker[i] - 1) / 13]);

            var remain = poker[i] % 13;
            var symbol = switch(remain) {
                case 0 -> " K";
                case 12 -> " Q";
                case 11 -> " J";
                default -> String.format("%2d", remain);
            };
            System.out.printf("%s%c", symbol, i % 13 == 0 ? '\n' : ' ');
        }
    }
}
