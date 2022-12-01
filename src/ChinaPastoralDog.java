public class ChinaPastoralDog extends Animal{

    private boolean isVaccinelnjected;

    private final double outPrice=100;

    @Override
    public double getOutPrice() {
        return outPrice;
    }

    public String toString(){
        return "\n名字:"+getName()+"\n年龄："+getAge()+"\n性别为雄："+isMale()+"\n售价："+getOutPrice()+"元"+"\n注射过狂犬病疫苗："+isVaccinelnjected+"\n";
    }

    public ChinaPastoralDog(String name,int age,boolean male,double inPrice,boolean isVaccinelnjected){
        super(name,age,male,inPrice);
        this.isVaccinelnjected=isVaccinelnjected;
    }



    public boolean isVaccinelnjected() {
        return isVaccinelnjected;
    }

    public void setVaccinelnjected(boolean vaccinelnjected) {
        isVaccinelnjected = vaccinelnjected;
    }//有一个问题，怎么控制单向的改变，就是只能把原先的false变成true，而原先的true不能变成false
    //毕竟打了针不能再设置成没打过，这样的情况应该写个异常吗？或者一个if语句判断？


}
