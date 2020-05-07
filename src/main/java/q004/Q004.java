package q004;

/**
 * Q004 ソートアルゴリズム
 *
 * ListManagerクラスをnewして、小さい順に並び変えた上でcheckResult()を呼び出してください。
 *
 * 実装イメージ:
 * ListManager data = new ListManager();
 * // TODO 並び換え
 * data.checkResult();
 *
 * - ListManagerクラスを修正してはいけません
 * - ListManagerクラスの dataList を直接変更してはいけません
 * - ListManagerクラスの比較 compare と入れ替え exchange を使って実現してください
 */
public class Q004 {
    public static void main(String[] args) {
        ListManager listm = new ListManager();
        int listsize = listm.size();
//        System.out.println( "listsize : " + listsize);

        for (int i = 0; i < listsize-1; i++) {
//            System.out.println( "cnt-i : " + i);
            for (int j = 0; j < listsize-1-i; j++) {
//                System.out.println( "cnt-j : " + j);
                int ret = listm.compare(j, j + 1);

                if (ret == 1) {
                    listm.exchange(j, j + 1);
                }
            }
        }
        listm.checkResult();
    }
}
// 完成までの時間: 1時間 00分