package student;

/**
 * The Greeting class stores a locality ID, locality name, plus ASCII and
 * Unicode greetings and a format string. It supports three constructors
 * (from simplest to most detailed) and the required getters as per HW doc.
 */
public class Greeting {

    /** Numeric ID of the locality (e.g., 1 for Hawaii, etc.). */
    private final int localityID;

    /** Name of the locality (e.g. "English", "Hawaii", "China"). */
    private final String localityName;

    /** The ASCII greeting (e.g. "Hello", "Aloha", "Ni Hao"). */
    private final String asciiGreeting;

    /** The Unicode greeting (e.g. "你好"). Could be the same as ASCII in many cases. */
    private final String unicodeGreeting;

    /** A format string with two %s placeholders: one for the greeting, one for the name. */
    private final String formatStr;

    /**
     * Constructor #1:
     * <p>
     * Uses "Hello" for both ASCII and Unicode, and a default format of "%s, %s!".
     * Example final output could be: "Hello, Alice!"
     *
     * @param localityID   ID of the locality
     * @param localityName Name of the locality
     */
    public Greeting(int localityID, String localityName) {
        // Delegate to the next constructor, giving "Hello" as the greeting
        this(localityID, localityName, "Hello");
    }

    /**
     * Constructor #2:
     * <p>
     * Uses the same greeting string for both ASCII and Unicode,
     * and a default format of "%s, %s!" (greeting first, then name).
     * Example final output could be: "Aloha, Alice!"
     *
     * @param localityID   ID of the locality
     * @param localityName Name of the locality
     * @param greeting     The greeting text (assumed ASCII-friendly)
     */
    public Greeting(int localityID, String localityName, String greeting) {
        // Delegate to the full constructor, setting the same string for both ASCII/Unicode
        this(localityID, localityName, greeting, greeting, "%s, %s!");
    }

    /**
     * Constructor #3:
     * <p>
     * Fully customizable. Requires ASCII greeting, Unicode greeting, and a format string.
     * Example final formatStr: "%s, %s!" → first %s is the greeting, second %s is the name.
     *
     * @param localityID     ID of the locality
     * @param localityName   Name of the locality
     * @param asciiGreeting  ASCII version of the greeting
     * @param unicodeGreeting Unicode version of the greeting
     * @param formatStr      A format string containing two %s placeholders
     */
    public Greeting(int localityID, String localityName,
                    String asciiGreeting, String unicodeGreeting,
                    String formatStr) {
        this.localityID = localityID;
        this.localityName = localityName;
        this.asciiGreeting = asciiGreeting;
        this.unicodeGreeting = unicodeGreeting;
        this.formatStr = formatStr;
    }

    /**
     * Returns the locality ID number.
     *
     * @return the locality ID
     */
    public int getLocalityID() {
        return localityID;
    }

    /**
     * Returns the locality name.
     *
     * @return the locality name
     */
    public String getLocalityName() {
        return localityName;
    }

    /**
     * Returns the ASCII greeting text (just the greeting, no formatting).
     *
     * @return the ASCII greeting
     */
    public String getAsciiGreeting() {
        return asciiGreeting;
    }

    /**
     * Returns the Unicode greeting text (just the greeting, no formatting).
     *
     * @return the Unicode greeting
     */
    public String getUnicodeGreeting() {
        return unicodeGreeting;
    }

    /**
     * Gets the format string for the Unicode greeting,
     * inserting the Unicode greeting into the first placeholder
     * and leaving the second placeholder for the name.
     * <p>
     * Example usage:
     * <pre>{@code
     * Greeting g = new Greeting(2, "English");
     * String result = String.format(g.getFormatStr(), "Alice");
     * // yields "Hello, Alice!"
     * }</pre>
     *
     * @return the partially formatted string (e.g. "你好, %s!")
     */
    public String getFormatStr() {
        return String.format(formatStr, unicodeGreeting, "%s");
    }

    /**
     * Returns the format string with the greeting inserted into the format.
     * <p>
     * If asciiOnly is true, it uses the ASCII greeting; otherwise uses Unicode.
     * The returned string will still have a %s left for the name.
     *
     * <p>
     * Example usage:
     * <pre>{@code
     * Greeting g = new Greeting(3, "China", "Ni Hao", "你好", "%s, %s!");
     * String name = "Alice";
     * // Using ASCII:
     * System.out.println(String.format(g.getFormatStr(true), name));  // "Ni Hao, Alice!"
     * // Using Unicode:
     * System.out.println(String.format(g.getFormatStr(false), name)); // "你好, Alice!"
     * }</pre>
     *
     * @param asciiOnly if true, inserts the ASCII greeting; otherwise the Unicode greeting
     * @return a partially formatted string like "Ni Hao, %s!"
     */
    public String getFormatStr(boolean asciiOnly) {
        if (asciiOnly) {
            return String.format(formatStr, asciiGreeting, "%s");
        } else {
            return String.format(formatStr, unicodeGreeting, "%s");
        }
    }

    /**
     * Returns a debugging string with all fields.
     * <p>
     * Example: {localityID:1, localityName:"Hawaii", asciiGreeting:"Aloha", unicodeGreeting:"Aloha"}
     *
     * @return a string showing all fields
     */
    @Override
    public String toString() {
        return String.format(
                "{localityID:%d, localityName:\"%s\", asciiGreeting:\"%s\", unicodeGreeting:\"%s\"}",
                localityID, localityName, asciiGreeting, unicodeGreeting
        );
    }
}
