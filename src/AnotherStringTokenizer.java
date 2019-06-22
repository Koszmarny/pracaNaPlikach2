import java.util.Arrays;

public class AnotherStringTokenizer implements MyEnumeration<String> {
    private String[] tokens;
    private String separators;
    private int position;
    private String originalString;

    public AnotherStringTokenizer(String text, String separators) {
        this.originalString = text;
        setSeparators(separators);
    }

    public String[] getAllTokens() {
        return Arrays.copyOf(tokens, tokens.length);
    }

    public String getSeparators() {
        return separators;
    }

    public void setSeparators(String separators) {
        this.separators = separators;
        this.tokens = originalString.split(separators);
        this.position = 0;
    }

    @Override
    public void rewind() {
        this.position = 0;
    }

    @Override
    public void skip(int number) {
        this.position += number;
    }

    @Override
    public int count() {
        return this.tokens.length - this.position;
    }

    @Override
    public boolean hasMoreElements() {
        return count() > 0;
    }

    @Override
    public String nextElement() {
        return tokens[position++];
    }

    @Override
    public String nextToken() {
        return nextElement();
    }
}
