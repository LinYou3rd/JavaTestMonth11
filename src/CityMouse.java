public class CityMouse extends Animal {

    private String color;

    private double outPrice ;

    @Override
    public double getOutPrice() {
        return outPrice;
    }

    public String getColor() {
        return color;
    }


    public CityMouse(String name, int age, boolean male, double inPrice,String color){
        super(name,age,male,inPrice);
        this.color=color;
        this.outPrice=20;
    }

    public String toString(){
        return "\n名字:"+getName()+"\n年龄："+getAge()+"\n性别为雄："+isMale()+"\n售价："+getOutPrice()+"元"+"\n毛色："+color+"\n";
    }
}
