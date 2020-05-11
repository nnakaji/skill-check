package q003;

import java.io.InputStream;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

import java.util.Map;
import java.util.Map.Entry;
import java.util.HashMap;
import java.util.List;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

/**
 * Q003 集計と並べ替え
 *
 * 以下のデータファイルを読み込んで、出現する単語ごとに数をカウントし、アルファベット辞書順に並び変えて出力してください。
 * resources/q003/data.txt
 * 単語の条件は以下となります
 * - "I"以外は全て小文字で扱う（"My"と"my"は同じく"my"として扱う）
 * - 単数形と複数形のように少しでも文字列が異れば別単語として扱う（"dream"と"dreams"は別単語）
 * - アポストロフィーやハイフン付の単語は1単語として扱う（"isn't"や"dead-end"）
 *
 * 出力形式:単語=数
 *
[出力イメージ]
（省略）
highest=1
I=3
if=2
ignorance=1
（省略）

 * 参考
 * http://eikaiwa.dmm.com/blog/4690/
 */
public class Q003 {
    /**
     * データファイルを開く
     * resources/q003/data.txt
     */
    private static InputStream openDataFile() {
        return Q003.class.getResourceAsStream("data.txt");
    }

    public static void main(String[] args) {
        try {
            File file = new File("C:\\Users\\nakajin\\IdeaProjects\\skill-check\\src\\main\\resources\\q003\\data.txt");

            if (!file.exists()) {
                System.out.print("ファイルが存在しません");
                return;
            }

            FileReader fileReader = new FileReader(file);
            BufferedReader bufferedReader = new BufferedReader(fileReader);
            String data;
            List<Data> result = new ArrayList<>();
            Map<String, Data> map = new LinkedHashMap<>();

            while ((data = bufferedReader.readLine()) != null) {
//                System.out.println(data);

                String data2 = data.replace(";", "");
                String data3 = data2.replace(".", "");
                String data4 = data3.replace(",", "");
                String data5 = data4.toLowerCase();

                String[] bun = data5.split(" ", 0);

                for (int i = 0; i < bun.length; i++) {
//                    System.out.println(i + "番目の要素 = :" + bun[i]);

                    if (bun[i].equals("i")){
                            bun[i] = bun[i].toUpperCase();
//                        bun[i] = "I";
                    }

                    if (!map.containsKey(bun[i])) {
                        Data mapdata = new Data();

                        mapdata.word = bun[i];
                        mapdata.value = 1;
                        map.put(mapdata.word, mapdata);
                    }
                    else {
                        Data mapdata2 = new Data();
                        mapdata2.word = bun[i];
                        mapdata2.value = map.get(bun[i]).value + 1;

                        map.replace(mapdata2.word, mapdata2);
                    }
                }

            }

//            // キーでソートする
//            Object[] mapkey = map.keySet().toArray();
//            Arrays.sort(mapkey);

            // 2.Map.Entryのリストを作成する
            List<Entry<String, Data>> list_entries = new ArrayList<Entry<String, Data>>(map.entrySet());

            // 3.比較関数Comparatorを使用してMap.Entryの値を比較する(昇順)
            Collections.sort(list_entries, new Comparator<Entry<String, Data>>() {
                public int compare(Entry<String, Data> obj1, Entry<String, Data> obj2) {
                    // 4. 昇順
                    return obj1.getValue().word.compareTo(obj2.getValue().word);
                }
            });

//            System.out.println("昇順でのソート");
            for(Entry<String, Data> entry : list_entries) {
                System.out.println(entry.getKey() + " : " + entry.getValue().value);
            }


//            // ここで結果を出力
//            for(Map.Entry<String, Data> entry : map.entrySet()) {
//                System.out.println(entry.getKey());
//                System.out.println(entry.getValue().value);
//            }

            bufferedReader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    static class Data {
        String word;
        int value;
    }

}
// 完成までの時間: 4時間 00分