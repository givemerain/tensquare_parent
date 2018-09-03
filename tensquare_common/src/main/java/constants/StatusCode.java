package constants;

/**
 * @author ye jiacheng
 * @create 2018-08-30
 */
public enum StatusCode {
    OK(20000),

    ERROR(20001),

    LOGINERROR(20002),

    ACCESSERROR(20003),

    REMOTEERROR(20004),

    REPERROR(20005);

    private final int value;

    StatusCode(int i) {
        this.value = i;
    }

    public int getValue() {
        return value;
    }
}
