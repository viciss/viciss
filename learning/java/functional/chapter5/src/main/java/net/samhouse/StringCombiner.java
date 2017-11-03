package net.samhouse;

public class StringCombiner {
    private String prefix;

    private String delim;

    private String suffix;

    private StringBuilder builder;

    public StringCombiner(String delim, String prefix, String suffix) {
        this.prefix = prefix;
        this.delim = delim;
        this.suffix = suffix;

        builder = new StringBuilder();
    }

    public StringCombiner add(String element) {
        if (builder.length() == 0) {
            builder.append(prefix);
        }
        else {
            builder.append(delim);
        }

        builder.append(element);

        return this;
    }

    public StringCombiner merge(StringCombiner other) {
        builder.append(other.builder);
        return this;
    }

    @Override
    public String toString() {
        return builder.append(suffix).toString();
    }
}
