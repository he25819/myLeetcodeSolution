package nowcoder.huawei;

import java.util.*;

public class HJ27 {
    // 473 bb daccb caddd bddc c baa adb ad abbcb cdaa abab a abcc ddcbd cadcc cdacd aaa a b acccd bbb dacc cc acbdd bcbb ba bacaa adda acd aaad d ab acac bc dabab abcd aacba aba daa bb ad cddab a bbaa aacad cdac acbcc cada bacd adcad cdadc bcbcc aa b acd cbaac ddcd ccb dac a dac adbcb bcda dda a ab ca dd d abd a dbb ccabd bdddd abd adc aaa baccb ccdcd a da c cadc dcdbd d aa bb a cac c ad adb ca cdcc cadd dddca d cba cb caab caa dd cd bca abc cdaa cdb bad dad bda d ddbc dab baaa adaac b a dbccd bd b bdad cdacd baa ac ddcad d bb acc aa cd cbdbb bbbcb a cc aacc c aadc dbcd a bca dd abbb ccdcd ccd ab d a a dadcd dbd bcaa c cda b ddab caaaa cdcdb b acbc ccaa dabca dcd b ba dbcc da bdbcc ab abaca bb cddc caca da dadba accdd bdac dbcd bcbbd ab bd ccb ddaa aa b b d bddd cabac aaba ab ccdb db abbd ada bdadb c abba dd cdb bca cccda badba abaa ac aabad db ccbad bddd ada dba acba b bc dd bbbbd cc cbdd cd abcaa bb ddaca acadb bbbb bddcc bdada aaa bcbda c aaa aadd cdddc adb cdbab c cbca bb aacab acdb bbdab b acbda cbdcd bda bacdc db d adcbd bccc c aaa cdd bdcd bac a aaab ddbb cd ccdbb addcc cdc c ca baadc addba dbdbd dba bbdda bcb c cdad aacac dcada cb aaad a cccab caca aad bbb dd b babbb cba bdaca db bacd bc bcbda cdda bcccd bdcda bdbcd adb cbcb a c bacba abbb adab adab b b d bca badbc baa cdb b abc aabb b d c cdab cacda d cdcda adcdc bcc bbccd b adb caba cbaaa aadb dcc add bcac bacbd bb a b c cabaa c caad c aa bcc ccab ddc dadca cdcba aaba dabbd dcb a bddb bb a c c cbc ccd dd a cabbb b caadb cb dca cbb ddaa bcadc dab a bbda cd bc ccad bbd ab c acddd cdd dbbbb daaab abbb cabc add ca caa bbbb dcab daaaa baca dcd ccacb ba bddaa acac dbcc bcc cbbcc b abba daa dbab bcca ba aa d dcdc d dcaa cbcda bd b ccbcb baa dcacd d c cbda baba d abb c cbdc da dbbb cd aabc dadc b a ddb c ddd ccdc ccd cba dbaac dcccd ddbac dbbdd bad bcdd cb dac dccd d a acdd d c cb b bcbb c a aca bcba d d bbdbc d c dabad ccca dc adb ddb dcdd dba ad ddaba c ac ddac bbbd cd a dacbb 1
    // 预期输出 6
    //adbcb
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while (in.hasNextLine()) {
//            int n = in.nextInt();
//            String[] words = new String[n];
//            for (int i = 0; i < n; i++)
//                words[i] = in.next("(?<=\\s)\\w+(?=\\s)");
//
//            String x = in.next("(?<=\\s)\\w+(?=\\s)");
//            int k = in.nextInt();

            String str = in.nextLine();
            String[] split = str.split(" ");
            int n = Integer.parseInt(split[0]);
            String x = split[n + 1];
            int k = Integer.parseInt(split[n + 2]);


            Map<Character, Integer> charCount = new HashMap<>();

            for (int i = 0; i < x.length(); i++) {
                charCount.putIfAbsent(x.charAt(i), 0);
                charCount.put(x.charAt(i), charCount.get(x.charAt(i)) + 1);
            }

            List<String> list = new ArrayList<>();
            outer: for (int i = 1; i <= n; i++) {
                if (split[i].length() != x.length() || split[i].equals(x))
                    continue;
                for (Map.Entry<Character, Integer> entry : charCount.entrySet()) {
                    int index = 0;
                    for (int j = 0; j < entry.getValue(); j++) {
                        index = split[i].indexOf(entry.getKey(), index) + 1;
                        if (index <= 0)
                            continue outer;
                    }
                }

//                if (!list.contains(split[i]))
                list.add(split[i]);
            }

            list.sort(String::compareTo);
            System.out.println(list.size());
            if (list.size() > k - 1)
                System.out.println(list.get(k - 1));
        }
    }
}
