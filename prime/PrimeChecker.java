import static java.lang.Integer.parseInt;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class PrimeChecker {
    public static void main(final String[] args) throws Exception {
        final String inputFile = args[0];

        processPrimes(inputFile);
    }

    public static void processPrimes(final String inputFile) throws IOException {
        try (FileInputStream inputStream = new FileInputStream(inputFile);
             BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out))) {
            final BufferedReader in = new BufferedReader(new InputStreamReader(inputStream));
            String line;
            while ((line = in.readLine()) != null) {
                int isPrime = isPrime(parseInt(line));
                out.write(isPrime + "\n");
            }
        }
    }

    /**
     * Based on https://en.wikipedia.org/wiki/Primality_test 6k ± 1 optimization
     */
    public static Integer isPrime(final int num) {
        if (num <= 3)
            return (num > 1) ? 1 : 0;
        if (num % 2 == 0 || num % 3 == 0)
            return 0;

        final int sqrt = (int) Math.sqrt(num);
        for (int i = 5; i <= sqrt; i += 6) {
            if (num % i == 0 || num % (i + 2) == 0)
                return 0;
        }

        return 1;
    }
}