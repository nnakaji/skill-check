package q002;

/**
 * Q002 並べ替える
 *
 * dataListに "ID,名字" の形式で20個のデータがあります。
 * これをID順に並べて表示するプログラムを記述してください。
 *
 * dataListの定義を変更してはいけません。
 *
 *
[出力結果イメージ]
1,伊藤
2,井上
（省略）
9,清水
10,鈴木
11,高橋
（省略）
20,渡辺
 */

import java.util.Arrays;
import java.util.ArrayList;
import java.util.Collections;
public class Q002 {
    /**
     * データ一覧
     */
    private static final String[] dataList = {
            "8,佐藤",
            "10,鈴木",
            "11,高橋",
            "12,田中",
            "20,渡辺",
            "1,伊藤",
            "18,山本",
            "13,中村",
            "5,小林",
            "3,加藤",
            "19,吉田",
            "17,山田",
            "7,佐々木",
            "16,山口",
            "6,斉藤",
            "15,松本",
            "2,井上",
            "4,木村",
            "14,林",
            "9,清水"
    };
    public static void main(String[] args) {
//        Arrays.sort(dataList);
         ArrayList<MyStructure> arrayStr = new ArrayList<MyStructure>();

//        ArrayList<MyStructure> memIdWrok = new ArrayList<MyStructure>();


        for(String str1 : dataList) {
//            System.out.println(str1);

            String[] memberId = str1.split(",", 0);
//            System.out.println(memberId[0]);
//            System.out.println(memberId[1]);

//            MyStructure[] memIdWrok = new MyStructure[1];
//            memIdWrok[0].num1= Integer.parseInt(memberId[0]);
//            memIdWrok[0].str1=memberId[1];

//            arrayStr.add(memIdWrok[0]);
            arrayStr.add(new MyStructure(Integer.parseInt(memberId[0]), memberId[1]));

        }

        // Collections.sort(arrayStr);
        arrayStr.sort((a,b)-> a.num1 - b.num1 );
//        System.out.println( arrayStr );
        for(int i = 0; i < arrayStr.size(); i++) {
//  System.out.println( arrayStr.get(i).num1) + "AAA" + arrayStr.get(i).str1 );

            System.out.printf("%d,%s \n", arrayStr.get(i).num1, arrayStr.get(i).str1);


}
    }
  static   class MyStructure {
        int num1;
        String str1;

        public MyStructure(int a, String b) {
            num1 = a;
            str1 = b;
        }
    }
}
// 完成までの時間: 3時間 10分




