import java.util.Scanner;

interface Device {
    boolean isEnabled();

    void enable();

    void disable();

    int getVolume();

    void setVolume(int percent);

    int getChannel();

    void setChannel(int channel);

    void printStatus();
}

interface Remote {
    void power();

    void volumeDown();

    void volumeUp();

    void channelDown();

    void channelUp();
}

class Radio implements Device {
    private boolean on = false;
    private int volume = 30;
    private int channel = 1;

    @Override
    public boolean isEnabled() {
        return on;
    }

    @Override
    public void enable() {
        on = true;
    }

    @Override
    public void disable() {
        on = false;
    }

    @Override
    public int getVolume() {
        return volume;
    }

    @Override
    public void setVolume(int volume) {
        if (volume > 100) {
            this.volume = 100;
        } else if (volume < 0) {
            this.volume = 0;
        } else {
            this.volume = volume;
        }
    }

    @Override
    public int getChannel() {
        return channel;
    }

    @Override
    public void setChannel(int channel) {
        this.channel = channel;
    }

    @Override
    public void printStatus() {
        System.out.println("------------------------------------");
        System.out.println("| Soy la radio.");
        System.out.println("| Volumen actual es " + volume + "%");
        System.out.println("| Canal actual es " + channel);
        System.out.println("| Estoy" + (on ? " Prendido" : " Apagado"));
        System.out.println("------------------------------------\n");
    }
}

class Tv implements Device {
    private boolean on = false;
    private int volume = 30;
    private int channel = 1;

    @Override
    public boolean isEnabled() {
        return on;
    }

    @Override
    public void enable() {
        on = true;
    }

    @Override
    public void disable() {
        on = false;
    }

    @Override
    public int getVolume() {
        return volume;
    }

    @Override
    public void setVolume(int volume) {
        if (volume > 100) {
            this.volume = 100;
        } else if (volume < 0) {
            this.volume = 0;
        } else {
            this.volume = volume;
        }
    }

    @Override
    public int getChannel() {
        return channel;
    }

    @Override
    public void setChannel(int channel) {
        this.channel = channel;
    }

    @Override
    public void printStatus() {
        System.out.println("------------------------------------");
        System.out.println("| Soy la TV.");
        System.out.println("| Volumen actual es " + volume + "%");
        System.out.println("| Canal actual es " + channel);
        System.out.println("| Estoy " + (on ? " Prendido" : " Apagado"));
        System.out.println("------------------------------------\n");
    }
}

class BasicRemote implements Remote {
    protected Device device;

    public BasicRemote() {}

    public BasicRemote(Device device) {
        this.device = device;
    }

    @Override
    public void power() {
        System.out.println("Remoto: Boton power");
        if (device.isEnabled()) {
            device.disable();
        } else {
            device.enable();
        }
    }

    @Override
    public void volumeDown() {
        System.out.println("Remoto: Bajar volumen");
        device.setVolume(device.getVolume() - 10);
    }

    @Override
    public void volumeUp() {
        System.out.println("Remoto: Subir volumen");
        device.setVolume(device.getVolume() + 10);
    }

    @Override
    public void channelDown() {
        System.out.println("Remoto: Cambiar canal");
        device.setChannel(device.getChannel() - 1);
    }

    @Override
    public void channelUp() {
        System.out.println("Remoto: Cambiar canal");
        device.setChannel(device.getChannel() + 1);
    }
}

class AdvancedRemote extends BasicRemote {

    public AdvancedRemote(Device device) {
        super.device = device;
    }

    public void mute() {
        System.out.println("Remoto: mudo");
        device.setVolume(0);
    }
}

public class Main { 
    public static void main(String[] args) {
        int num=0;
        boolean bool=false;
        Device device1 = new Tv();
        Device device2 = new Radio();
        
        do{
            clearScreen();
            System.out.println("Seleccione una opcion.\n");
            System.out.println("1-Modificar Radio.\n");
            System.out.println("2-Modificar Tv.\n");
            System.out.println("3-Imprimir Status.\n");
            System.out.println("4-Salir.\n");
            Scanner sc = new Scanner(System.in);
            try{
                num = sc.nextInt(); 
            }catch(Exception ex){
                System.out.println("Opcion invalida");
                System.out.println("presione Enter para continnuar...");
                new java.util.Scanner(System.in).nextLine();
                bool=true;
            }
            
            if(num==1 || num==2 || num==3){
                switch(num){
                case 1:
                    testDevice(device2);
                    break;
                case 2:
                    testDevice(device1);
                    break;
                case 3:
                    device1.printStatus();
                    device2.printStatus();
                    System.out.println("presione Enter para continnuar...");
                    new java.util.Scanner(System.in).nextLine();
                    break;
                }
            }
            else if (num!=4 && !bool){
                System.out.println("Opcion invalida");
                System.out.println("presione Enter para continnuar...");
                new java.util.Scanner(System.in).nextLine();
            }
            bool=false;
        }while(num!=4);
    }

    public static void testDevice(Device device) {
        AdvancedRemote advancedRemote = new AdvancedRemote(device);
        int num=0;
        boolean bool=false;
        do{ 
            clearScreen();
            device.printStatus();
            System.out.println("Seleccione una opcion.\n");
            System.out.println("1-Subir volumen.\n");
            System.out.println("2-Bajar volumen.\n");
            System.out.println("3-Cambiar de canal hacia arriba.\n");
            System.out.println("4-Cambiar de canal hacia abajo.\n");
            System.out.println("5-Mutear.\n");
            System.out.println("6-Prender/Apagar.\n");
            System.out.println("7-Regresar al menu principal.\n");
            Scanner sc = new Scanner(System.in);
            try{
                num = sc.nextInt(); 
            }catch(Exception ex){
                System.out.println("Opcion invalida");
                System.out.println("presione Enter para continnuar...");
                new java.util.Scanner(System.in).nextLine();
                bool=true;
            }
            if(num==1 || num==2 || num==3 || num==4 || num==5 || num==6){
                switch(num){
                    case 1:
                        advancedRemote.volumeUp();
                        break;
                    case 2:
                        advancedRemote.volumeDown();
                        break;
                    case 3:
                        advancedRemote.channelUp();
                        break;
                    case 4:
                        advancedRemote.channelDown();
                        break;
                    case 5:
                        advancedRemote.mute();
                        break;
                    case 6:
                        advancedRemote.power();
                        break;
                }
            }
            else if(num!=7 && !bool){
                System.out.println("Opcion invalida");
                System.out.println("presione Enter para continnuar...");
                new java.util.Scanner(System.in).nextLine();
            }
            bool=false;
        }while(num!=7);
    }
    
    public static void clearScreen() {  
    System.out.print("\033[H\033[2J");  
    System.out.flush();  
}  
}