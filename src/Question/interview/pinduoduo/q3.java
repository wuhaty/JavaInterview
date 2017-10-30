package Question.interview.pinduoduo;

import java.util.*;

/**
 * Created by gump on 2017/10/24.
 */

class Bao {
    int init;
    int dec;
    int status = 1;
}

public class q3 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNextInt()) {//注意while处理多个case
            int n = sc.nextInt();
            int m = sc.nextInt();
            List<Bao> baos = new LinkedList<>();

            for (int i = 0; i < n; i++) {
                Bao b = new Bao();
                b.init = sc.nextInt();
                b.dec = sc.nextInt();
                baos.add(b);
            }
            while (true) {
                DaXiong(baos);
                for (int i = 0; i < baos.size(); i++) {
                    Bao temp = baos.get(i);
                    if (temp.status==-1)continue;
                    temp.init -= temp.dec;
                    if (temp.init < 0) temp.status = 0;
                }
                if (DuoLa(baos, m)) {
                    for (Bao b : baos) {
                        System.out.println(b.status <= 0 ? b.status : b.init);
                    }
                    break;
                }
            }
        }
    }

    private static boolean DuoLa(List<Bao> baos, int m) {
        int count = 0;
        for (Bao b : baos) {
            if (b.status == 1) count++;
        }
        return count < m;
    }

    private static void DaXiong(List<Bao> baos) {
        Bao max = baos.get(0);
        Bao max2 = baos.get(0);

        for (int i = 1; i < baos.size(); i++) {
            Bao temp = baos.get(i);
            if (temp.status == 1 && (temp.init >= max.init ||temp.init >= max2.init)){
                if (temp.init == max2.init && temp.dec >max2.dec){
                    max2 = temp;
                    continue;
                }
                if (temp.init == max.init && temp.dec < max.dec) {
                    if (max2.init < temp.init && max2.dec < temp.dec) {
                        max2 = temp;
                    } else
                        continue;
                }
                max2 = max;
                max = temp;
            }
        }

        max.status = -1;
        max2.status = -1;
    }
}
