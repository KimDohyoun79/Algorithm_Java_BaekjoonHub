import java.io.*;
import java.util.*;


class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());  // (1 <= N <= 10)

        //String[] str = new String[N]; // 하나의 문자열 길이는 3 이상 100,000 이하, 영문 알파벳 소문자로만
        StringBuilder[] str = new StringBuilder[N];
        int end = -1;
        for (int i = 0; i < N; i++) {
            str[i] = new StringBuilder(br.readLine()).reverse();
            if (str[i].length() > end) {
                end = str[i].length();
            }
        }

        HashMap<Character, Integer> map = new HashMap<>();
        int num = (int) Math.pow(10, end);
        for (int i = end - 1; 0 <= i; i--) {
            for (StringBuilder s : str) {
                //System.out.println(s + " " + i);
                try {
                    if ('A' <= s.charAt(i) && s.charAt(i) <= 'Z') {
                        //System.out.println("\tok num : " + num + "  s.charAt(i) : " + s.charAt(i) + "\n");
                        map.put(s.charAt(i), map.getOrDefault(s.charAt(i), 0) + num);
                    }
                } catch (Exception e) {
                    
                }
            }
            num /= 10;
        }

        ArrayList<Character> keySet = new ArrayList<>(map.keySet());
        keySet.sort((o1, o2) -> map.get(o2) - map.get(o1));

        num = 9;
        for (Character key : keySet) {
            map.put(key, num--);
        }
//        System.out.println("==내림차순 정렬==");
//        for (Character key : keySet) {
//            System.out.println(String.format("Key : %s, Value : %s", key, map.get(key)));
//        }


        int hap = 0;
        for (StringBuilder s : str) {
            s.reverse();
            String get = "";
            for (int i = 0; i < s.length(); i++) {
                 get += String.valueOf(map.get(s.charAt(i)));
            }
            //System.out.println(get);
            hap += Integer.parseInt(get);
        }


        bw.write(String.valueOf(hap));
        //System.out.println(map);
        bw.flush();
        bw.close();
        br.close();
    }
}