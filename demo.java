public class demo {
   public static void main(String[] args) {
    // TODO Auto-generated method stub
    // 輸出100 ~ 200 的質數
    int i = 0, j = 0;
    for (i = 100; i <= 200; i++) {
        for (j = 2; j < i; j++) {
            if (i % j == 0) {
                break;
            }
        }
        if (i == j) {
            System.out.println(i + " ");
        }
    }
   } 
}
