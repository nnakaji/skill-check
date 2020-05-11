package q005;

import q003.Q003;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

/**
 * 作業時間管理クラス
 * 自由に修正してかまいません
 */
public class WorkData {
    private List<empData> orgEmpDataList = new ArrayList<>();

    public WorkData() {
        try {
            File file = new File("C:\\Users\\nakajin\\IdeaProjects\\skill-check\\src\\main\\resources/q005/data.txt");

            if (!file.exists()) {
                System.out.print("ファイルが存在しません");
                return;
            }

            FileReader fileReader = new FileReader(file);
            BufferedReader bufferedReader = new BufferedReader(fileReader);
            String lineData;
//            List<empData> orgEmpDataList = new ArrayList<>();
            int i = 0;

            // リスト読み込み、データ格納
            // 一行目は読み飛ばし
            while ((lineData = bufferedReader.readLine()) != null) {
                if (i == 0) {

                }else {

//                    System.out.println(lineData);
                    String[] strLineData = lineData.split(",", 0);

                    empData emplineData = new empData();
                    emplineData.number = strLineData[0];
                    emplineData.department = strLineData[1];
                    emplineData.position = strLineData[2];
                    emplineData.pCode = strLineData[3];
                    emplineData.workTime = Integer.parseInt(strLineData[4]);
                    orgEmpDataList.add(emplineData);
                }
                i++;
            }

/*
            // FOR TEST
            for (int j = 0; j < orgEmpDataList.size(); j++) {
                System.out.println("j=" + j + ", number, " + orgEmpDataList.get(j).number);
            }
*/

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // データ格納クラス定義
    private class empData {
        /** 社員番号 */
        private String number;

        /** 部署 */
        private String department;

        /** 役職 */
        private String position;

        /** Pコード */
        private String pCode;

        /** 作業時間(分) */
        private int workTime;
    }

    /**
     * (1) 役職別の合計作業時間を集計して出力する
     */
    public void calcSumPosition() {
        // データ読み込み。マップへ格納　キーは役職。
        Map<String, empData> map = new LinkedHashMap<>();

        for ( int i = 0 ; i < orgEmpDataList.size() ; i++ ) {
//            System.out.println("calcSumPosition: " + i + "番目の要素 = :" + orgEmpDataList.get(i).number);

            if (!map.containsKey(orgEmpDataList.get(i).position)) {
                empData mapdata = new empData();

                mapdata.position = orgEmpDataList.get(i).position;
                mapdata.workTime = orgEmpDataList.get(i).workTime;

                map.put(mapdata.position,mapdata);
            } else {
                empData mapdata2 = new empData();

                mapdata2.position = orgEmpDataList.get(i).position;
                mapdata2.workTime = map.get(orgEmpDataList.get(i).position).workTime  + orgEmpDataList.get(i).workTime;

                map.replace(mapdata2.position,mapdata2);
            }
        }

        //集計結果を出力
        List<Map.Entry<String, empData>> list_entries = new ArrayList<Map.Entry<String, empData>>(map.entrySet());
        for( Map.Entry<String, empData> entry : list_entries) {
            System.out.println(entry.getKey() + ": " + entry.getValue().workTime / 60 + "時間" + entry.getValue().workTime % 60 +"分");
        }
    }

    /**
     * (2) Pコード別の合計作業時間を集計して出力する
     */
    public void calcSumPcode() {
        // データ読み込み。マップへ格納　キーはP-CODE。
        Map<String, empData> map = new LinkedHashMap<>();

        for ( int i = 0 ; i < orgEmpDataList.size() ; i++ ) {
            if (!map.containsKey(orgEmpDataList.get(i).pCode)) {
                empData mapdata = new empData();

                mapdata.pCode = orgEmpDataList.get(i).pCode;
                mapdata.workTime = orgEmpDataList.get(i).workTime;

                map.put(mapdata.pCode,mapdata);
            } else {
                empData mapdata2 = new empData();

                mapdata2.pCode = orgEmpDataList.get(i).pCode;
                mapdata2.workTime = map.get(orgEmpDataList.get(i).pCode).workTime  + orgEmpDataList.get(i).workTime;

                map.replace(mapdata2.pCode,mapdata2);
            }
        }

        //集計結果を出力
        List<Map.Entry<String, empData>> list_entries = new ArrayList<Map.Entry<String, empData>>(map.entrySet());
        for( Map.Entry<String, empData> entry : list_entries) {
            System.out.println(entry.getKey() + ": " + entry.getValue().workTime / 60 + "時間" + entry.getValue().workTime % 60 +"分");
        }
    }

    /**
     * (3) 社員番号別の合計作業時間を集計して出力する
     */
    public void calcSumNumber() {
        // データ読み込み。マップへ格納　キーは社員番号。
        Map<String, empData> map = new LinkedHashMap<>();

        for ( int i = 0 ; i < orgEmpDataList.size() ; i++ ) {
            if (!map.containsKey(orgEmpDataList.get(i).number)) {
                empData mapdata = new empData();

                mapdata.number = orgEmpDataList.get(i).number;
                mapdata.workTime = orgEmpDataList.get(i).workTime;

                map.put(mapdata.number,mapdata);
            } else {
                empData mapdata2 = new empData();

                mapdata2.number = orgEmpDataList.get(i).number;
                mapdata2.workTime = map.get(orgEmpDataList.get(i).number).workTime  + orgEmpDataList.get(i).workTime;

                map.replace(mapdata2.number,mapdata2);
            }
        }

        //集計結果を出力
        List<Map.Entry<String, empData>> list_entries = new ArrayList<Map.Entry<String, empData>>(map.entrySet());
        for( Map.Entry<String, empData> entry : list_entries) {
            System.out.println(entry.getKey() + ": " + entry.getValue().workTime / 60 + "時間" + entry.getValue().workTime % 60 +"分");
        }
    }
}
