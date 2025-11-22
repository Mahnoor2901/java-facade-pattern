package lab.facade;
public class Main {
public static void main(String[] args) {
Cpu cpu = new Cpu();
Memory memory = new Memory();
HardDrive hd = new HardDrive();
ComputerFacade computer = new ComputerFacade(cpu , memory, hd);
computer.start();
// pretend the computer does some work
System.out.println("Main: doing user tasks...\n");
computer.shutdown();
}
}