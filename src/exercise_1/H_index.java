package exercise_1;

import java.util.Scanner;
//3,0,6,1,5
//3,0.6,1,5
public class H_index {
    public static void sort(int[] citations)
    {
        int number = citations.length;
        for (int i = 0; i < number - 1; i++) {
            for (int j = 0; j < number - 1 - i; j++) {
                if (citations[j] < citations[j + 1])
                {
                    int temp = citations[j + 1];
                    citations[j + 1] = citations[j];
                    citations[j] = temp;
                }
            }
        }
    }
    public static int calHindex(int[] citations)
    {
        int hindex = 0;
        int number = citations.length;
        for (int j = 0; j < number; j++) {
            if (citations[j] >= j + 1)
            {
                hindex = j + 1;
            }
            else
            {
                break;
            }
        }
        return hindex;
    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        //get array of citations from console
        System.out.println("input citation numbers:");
        int[] citations = new int[100];
        String[] strs;
        String line ;

        //line = scanner.nextLine();
//        while (line.length() == 0)
//        {
//            System.out.println("empty input, reput again");
//            line = scanner.nextLine();
//        }
        while (true)
        {
            line = scanner.nextLine();
            //check empty
            if (line.length() == 0)
            {
                System.out.println("empty input, reput again");
                continue;
            }
            //check >= 0
            boolean legalNumbers = true;
            strs = line.split(",");

            for (int i = 0; i < strs.length; i++) {
                if (!strs[i].matches("[0,9]+"))
                {
                    System.out.println(strs[i] + " is illegl,reput from begin");
                    legalNumbers = false;
                    break;
                }
                citations[i] = Integer.parseInt(strs[i]);
            }
            if (legalNumbers)
            {
                //exe
                sort(citations);
                int hindex = calHindex(citations);
                System.out.println("hindex is " + hindex);
                break;
            }
        }

        //String line = scanner.nextLine();处理空输入，健壮性


//        for (int i = 0; i < strs.length; i++) {
//          citations[i] = Integer.parseInt(strs[i]);//将整型数据Integer转换为基本数据类型int
//        }
//        //
//        sort(citations);
//        //
//        int hindex = calHindex(citations);
//
//        //
//        System.out.println("hindex is " + hindex);
    }
}
