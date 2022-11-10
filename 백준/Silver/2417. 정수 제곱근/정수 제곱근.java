import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        long num = Long.parseLong(br.readLine());

        long sqrtNum = (long) Math.sqrt(num);

        if (sqrtNum * sqrtNum < num)
            System.out.println(sqrtNum + 1);
        else
            System.out.println(sqrtNum);
    }
}