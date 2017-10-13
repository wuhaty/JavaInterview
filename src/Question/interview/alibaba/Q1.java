package Question.interview.alibaba;
import java.util.Arrays;
import java.util.Scanner;
public class Q1 {
    public static int CUSTOMS_LIMIT_MONEY_PER_BOX = 2000;



    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Model boxTemplate = new Model();
        boxTemplate.price = CUSTOMS_LIMIT_MONEY_PER_BOX;
        int itemNum = 0;
        int rs = 0;
        while (scanner.hasNext()){
            int[] buffer = new int[3];
            for (int i = 0; i < 3; i++)
                buffer[i] = scanner.nextInt();
            Arrays.sort(buffer);
            boxTemplate.setLines(buffer);
            itemNum = scanner.nextInt();
            Model[] items = new Model[itemNum];
            for(int i=0; i<itemNum; i++){
                Model item = new Model();
                item.price = scanner.nextInt();
                for (int j = 0; j < 3; j++)
                    buffer[j] = scanner.nextInt();
                Arrays.sort(buffer);
                item.setLines(buffer);
                items[i] = item;
            }
            rs = process(boxTemplate,items);
        }
        System.out.println(rs);
        scanner.close();
    }

    public static int process(Model box,Model[] items) {
        for(int i = 0; i < items.length; i++) {
            Model item = items[i];
            if (item.price > box.price ||
                    item.length > box.length ||
                    item.width > box.width ||
                    item.height > box.height) {
                return -1;
            }
        }
        return items.length-2;
    }
}
class Model {
    public int price;
    public int length;
    public int width;
    public int height;

    public void setLines(int[] buffer) {
        length = buffer[0];
        width = buffer[1];
        height = buffer[2];
    }
}