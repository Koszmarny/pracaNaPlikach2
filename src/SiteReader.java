import java.net.*;
import java.io.*;
import java.util.*;

public class SiteReader {
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


        Scanner scan = new Scanner(System.in);
        System.out.println("podaj nazwe strony do odczytu: ");
        String WWW = "https://"+scan.next();
        //"https://docs.oracle.com/javase/8/docs/api/java/lang/String.html";

        System.out.println("podaj nazwe pliku do zapisu: ");
        String plik = scan.next();
        try {
            readData(WWW, plik);
        } catch (IOException f) {

        } catch (Exception e) {
            System.out.println("Program zakończy działanie z powodu braku dostępu do danych.");
            System.out.println("Być może nie masz połączenia z internetem.");
        }
    }

    /**
     * Rozpoczyna połączenie, czyta stronę, przetwarza ją i zwraca odpowiednie dane
     */
    @SuppressWarnings("Duplicates")
    public static void readData(String wwwAddress, String plik) throws IOException {
        URL startURL = new URL(wwwAddress);
        HttpURLConnection connection = (HttpURLConnection) startURL.openConnection();

        setOptions(connection, null, DONT_CACHE, DO_REDIRECT);

        InputStream inputStream = connection.getInputStream();
        BufferedReader inputBuffer = new BufferedReader(new InputStreamReader(inputStream));
        String inputLine;
        PrintWriter zapis = new PrintWriter(new BufferedWriter(new FileWriter(plik)), true);
        while ((inputLine = inputBuffer.readLine()) != null) {
            zapis.println(inputLine);
        }
        inputBuffer.close();
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
}