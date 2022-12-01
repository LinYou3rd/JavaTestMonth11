public class CatCat extends Animal{

    public  double outPrice ;

    @Override
    public double getOutPrice() {
        return outPrice;
    }

    @Override
    public String toString() {
        return "\n名字:"+getName()+"\n年龄："+getAge()+"\n性别为雄："+isMale()+"\n售价："+getOutPrice()+"元\n";
    }

    public CatCat(String name,int age,boolean male,double inPrice){
        super(name,age,male,inPrice);
        this.outPrice=200;
    }


}
