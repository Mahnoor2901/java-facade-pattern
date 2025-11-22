package lab.facade;
public class Memory {
public void load(long position, byte[] data) {
System.out.println("Memory: loading " + data.length + " bytes at " + position);
}
}