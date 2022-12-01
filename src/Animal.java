public abstract class Animal {
    private String name;
    private int age;
    private boolean male;
    private double outPrice;//售价

    private double inPrice;//进货价



    public Animal(String name,int age,boolean male,double inPrice){
        this.name=name;
        this.age=age;
        this.male=male;
        this.inPrice=inPrice;
    }

    public  abstract  String toString();

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public boolean isMale() {
        return male;
    }

    public double getOutPrice() {
        return outPrice;
    }

    public void setOutPrice(double outPrice) {
        this.outPrice = outPrice;
    }

    public double getInPrice() {
        return inPrice;
    }
}
