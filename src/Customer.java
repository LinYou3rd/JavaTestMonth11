import java.time.LocalDate;
public class Customer {
    private final String name;
    private int comeFrequency=0;
    private LocalDate LastComeTime;

    private Animal want;//顾客想买的动物类型

    public Customer(String name){
        this.name=name;
    }

    public Animal getWant() {
        return want;
    }

    public void setWant(Animal want) {
        this.want=want;
    }


    public int getComeFrequency() {
        return comeFrequency;
    }

    public void setComeFrequency(int comeFrequency) {
        this.comeFrequency = comeFrequency;
    }

    public void setLastComeTime(LocalDate lastComeTime) {
        LastComeTime = lastComeTime;
    }

    public LocalDate getLastComeTime() {
        return LastComeTime;
    }


    @Override
    public  String toString() {
        return "\n姓名："+name+"\n光临次数："+comeFrequency+"\n最后到店时间："+LastComeTime+"\n";
    }//才发现重写方法貌似不能是静态的（爆红了，但网上搜不到，全是推荐静态方法不能重写，不太确定了），一轮憨憨的写了个 static void toString 输出学生信息
}
