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

    public void breed(Individual parent) {
        byte v = this.value;
        byte p = parent.getByte();
        for (int i = 0; i < Byte.SIZE; i++) {
            if (Math.random() < 0.5) {
                v |= (p & (1 << i));
            }
        }
    }

    public Individual mutate(double mutationRate) {
        byte v = this.value;
        for(int i = 0; i < BIT_LENGTH; i++) {
            if(Math.random() < mutationRate) {
                v ^= (1 << i);
            }
        }
        return new Individual(v);
    }
}
