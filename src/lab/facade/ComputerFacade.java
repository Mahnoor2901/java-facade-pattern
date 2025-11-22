package lab.facade;
public class ComputerFacade {
private final Cpu cpu;
private final Memory memory;
private final HardDrive hd;
private static final long BOOT_ADDRESS = 0x1000;
private static final long BOOT_SECTOR = 0x2000;
private static final int SECTOR_SIZE = 64;
public ComputerFacade(Cpu cpu, Memory memory, HardDrive hd) {
    this.cpu = cpu;
    this.memory = memory;
    this.hd = hd;
}
public void start() {
    System.out.println("Facade: starting computer");

    System.out.println(System.currentTimeMillis() + " > Cpu.freeze()");
    cpu.freeze();

    System.out.println(System.currentTimeMillis() + " > HardDrive.read()");
    byte[] bootData = hd.read(BOOT_SECTOR, SECTOR_SIZE);

    System.out.println(System.currentTimeMillis() + " > Memory.load()");
    memory.load(BOOT_ADDRESS, bootData);

    System.out.println(System.currentTimeMillis() + " > Cpu.jump()");
    cpu.jump(BOOT_ADDRESS);

    System.out.println(System.currentTimeMillis() + " > Cpu.execute()");
    cpu.execute();

    System.out.println("Facade: computer started\n");
}
public void shutdown() {
System.out.println("Facade: shutting down computer");
// In a real system you'd order components gracefully
System.out.println("Facade: power off\n");
}
}