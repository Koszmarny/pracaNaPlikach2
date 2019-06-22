import java.net.*;
import java.io.*;
import java.util.*;

/**
 * Portuguese verbs
 * <p>
 * Copyright: (c) 2016 Piotr Pikuta
 *
 * @author Piotr Pikuta
 * @version 0.3
 */
public class PP {
    public static final boolean DO_CACHE = true;
    public static final boolean DONT_CACHE = false;
    public static final boolean DO_REDIRECT = true;
    public static final boolean DONT_REDIRECT = false;

    public static final int VERB_FORMS_COUNT = 6;
    public static final int TENSES_COUNT = 3;

    private static final String MODO_INDICATIVO_FIRST_LINE =
            "<td rowspan=\"6\"style=\"background-color: #FDA; text-align: center;\"><b>Modo<br />";
    private static final String PRESENTE_LINE =
            "<td style=\"background-color:#FDA;\"><b>Presente</b></td>";

    private static final String EMPTY_STRING = "";
    private static final String NEW_LINE_SEPARATORS_STRING = "\n\r";
    private static final String HELP_REQUIRED_STRING = "-help";

    private static final char TABULATOR_CHAR = '\t';

    private static final char OPENING_TAG_CHAR = '<';
    private static final char CLOSING_TAG_CHAR = '>';

    public static void main(String[] args) {
        if (args.length == 0 || args[0].equals(HELP_REQUIRED_STRING)) {
            displayHelpInfo();
        } else {
            String WWW = "docs.oracle.com/javase/8/docs/api/java/lang/String.html" + args[0];
            String[][] data;

            try {
                data = readData(WWW);
                displayData(data);
            } catch (Exception e) {
                System.out.println("Program zakończy działanie z powodu braku dostępu do danych.");
                System.out.println("Być może nie masz połączenia z internetem.");
                //e.printStackTrace();
            }
        }
    }

    /**
     * Wyświetla uŜytkownikowi informację o sposobie uŜycia programu
     */
    public static void displayHelpInfo() {
        System.out.println("Sposób uŜycia programu:");
        System.out.println(" java SiteReader bezokolicznik");
        System.out.println(" java SiteReader -help");
    }

    /**
     * Rozpoczyna połączenie, czyta stronę, przetwarza ją i zwraca odpowiednie dane
     */
    public static String[][] readData(String wwwAddress) throws IOException {
        URL startURL = new URL(wwwAddress);
        HttpURLConnection connection = (HttpURLConnection) startURL.openConnection();

        setOptions(connection, null, DONT_CACHE, DO_REDIRECT);

        String content = readTheStream(connection.getInputStream());
        StringTokenizer tokenizer = new StringTokenizer(content, NEW_LINE_SEPARATORS_STRING);

        String line = EMPTY_STRING;
        String[][] result = new String[TENSES_COUNT][VERB_FORMS_COUNT];

        while (tokenizer.hasMoreTokens() && !line.equals(MODO_INDICATIVO_FIRST_LINE)) {
            line = tokenizer.nextToken();
        }

        for (int i = 0; i < TENSES_COUNT; i++) {
            line = tokenizer.nextToken();
            line = tokenizer.nextToken();
            for (int k = 0; k < VERB_FORMS_COUNT; k++) {
                line = tokenizer.nextToken();
                result[i][k] = extractTextFromLink(line);
            }
            line = tokenizer.nextToken();
        }

        return result;
    }

    /**
     * Ustawia opcje połączenia
     */
    public static void setOptions(HttpURLConnection connection, String cookie, boolean doCache,
                                  boolean doRedirect) throws IOException {
        connection.setUseCaches(doCache);
        connection.setInstanceFollowRedirects(doRedirect);
        if (cookie != null) {
            connection.setRequestProperty("Cookie", cookie);
        }
    }

    /**
     * Czyta strumień danych i zwraca go jako String
     */
    public static String readTheStream(InputStream inputStream) throws IOException {
        BufferedReader inputBuffer = new BufferedReader(new InputStreamReader(inputStream));
        String inputLine;
        StringBuilder result = new StringBuilder();

        while ((inputLine = inputBuffer.readLine()) != null) {
            result.append(inputLine).append(System.lineSeparator());
        }

        inputBuffer.close();
        return result.toString();
    }

    /**
     * Z danego wiersza tabeli postaci <td><a href="link">tekst</a></td>
     * wyodrębnia i zwraca linkowany tekst
     */
    public static String extractTextFromLink(String line) {
        String result = null;
        boolean finished = false;
        int k;

        for (int i = 0; !finished && i < line.length() - 1; i++) {
            k = i + 1;
            if (line.charAt(i) == CLOSING_TAG_CHAR && line.charAt(k) != OPENING_TAG_CHAR) {
                do {
                    k++;
                } while (line.charAt(k) != OPENING_TAG_CHAR);
                result = line.substring(i + 1, k);
                finished = true;
            }
        }

        return result;
    }

    /**
 * Wyświetla uŜytkownikowi dane wyodrębnione ze strony www
 */
public static void displayData(String[][] data) {
    StringBuilder line;

    for (int k = 0; k < VERB_FORMS_COUNT; k++) {
        line = new StringBuilder(EMPTY_STRING);
        for (int i = 0; i < TENSES_COUNT; i++) {
            line.append(data[i][k]).append(TABULATOR_CHAR);
        }
        System.out.println(line);
    }
}
}