package assignment2.models;

public class Individual {

    private static final int BIT_LENGTH = 5;

    private Byte value;

    public Individual(int ind) {
        this.value = getByteFromInt(ind);
    }

    private Byte getByteFromInt(int ind) {
        String s = String.format("%" + BIT_LENGTH + "s", Integer.toBinaryString(ind)).replace(" ", "0");
        return Byte.parseByte(s, 2);
    }

    public Byte getByte() {
        return value;
    }

    public String getByteString() {
        return String.format("%" + BIT_LENGTH + "s", Integer.toBinaryString(value)).replace(" ", "0");
    }
}
