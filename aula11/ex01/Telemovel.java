package aula11.ex01;

import java.util.Comparator;

public class Telemovel {

    private String name;
    private double price;
    private String processor;
    private int memory;
    private int camera;

    public Telemovel(String name, double price, String processor, int memory, int camera) {
        this.name = name;
        this.price = price;
        this.processor = processor;
        this.memory = memory;
        this.camera = camera;
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getProcessor() {
        return processor;
    }

    public void setProcessor(String processor) {
        this.processor = processor;
    }

    public int getMemory() {
        return memory;
    }

    public void setMemory(int memory) {
        this.memory = memory;
    }

    public int getCamera() {
        return camera;
    }

    public void setCamera(int camera) {
        this.camera = camera;
    }


    public static Comparator<Telemovel> compareByName = new Comparator<Telemovel>() {
        public int compare(Telemovel s1, Telemovel s2) {
            return s1.getName().compareTo(s2.getName());
        }};

    public static Comparator<Telemovel> compareByProcessor = new Comparator<Telemovel>() {
        public int compare(Telemovel s1, Telemovel s2) {
            return s1.getProcessor().compareTo(s2.getProcessor());
        }};

    public static Comparator<Telemovel> compareByCamera = new Comparator<Telemovel>() {
        public int compare(Telemovel s1, Telemovel s2) {
            if (s1.getCamera() == s2.getCamera())
                return 0;
            return s1.getCamera()>s2.getCamera() ? 1 : -1 ;

        }};

    public static Comparator<Telemovel> compareByPrice = new Comparator<Telemovel>() {
        public int compare(Telemovel s1, Telemovel s2) {
            if (s1.getPrice() == s2.getPrice())
                return 0;
            return s1.getPrice()>s2.getPrice() ? 1 : -1 ;

        }};

    public static Comparator<Telemovel> compareByMemory = new Comparator<Telemovel>() {
        public int compare(Telemovel s1, Telemovel s2) {
            if (s1.getMemory() == s2.getMemory())
                return 0;
            return s1.getMemory()>s2.getMemory() ? 1 : -1 ;

        }};


    @Override
    public String toString() {
        return "Telemovel{" +
                "name='" + name + '\'' +
                ", price=" + price +
                ", processor='" + processor + '\'' +
                ", memory=" + memory +
                ", camera=" + camera +
                '}';
    }


}
