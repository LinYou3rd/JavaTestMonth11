import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;

public class MyAnimalShop implements AnimalShop {
    private double fund;//资金
    private boolean close;
    private ArrayList <Customer>customerList;//纪念客人名单
    private ArrayList<Animal> animalList;//库存清单

    private ArrayList<Customer> dayCustomerlist;//当日来客

    private ArrayList <Animal>dealList;//当日成交清单，便于算利润

    public ArrayList<Animal> getAnimalList() {
        return animalList;
    }

    public ArrayList<Customer> getCustomerList() {
        return customerList;
    }

    public ArrayList<Customer> getDayCustomerlist() {
        return dayCustomerlist;
    }

    public ArrayList<Animal> getDealList() {
        return dealList;
    }

    public double getFund() {
        return fund;
    }


    public boolean isClose() {
        return close;
    }

    public void setClose(boolean close) {
        this.close = close;
    }
    public MyAnimalShop(int fund){
        this.fund=fund;
        ArrayList<Customer> customer = new ArrayList<>();
        this.customerList=customer;
        ArrayList<Animal>animals = new ArrayList<>();
        this.animalList = animals;
        ArrayList<Customer>dayCustomer = new ArrayList<>();
        this.dayCustomerlist = dayCustomer;
        ArrayList<Animal>deal=new ArrayList<>();
        this.dealList=deal;
    }

    @Override
    public void restocking(Animal animal) {
        //第一次我直接if+throw，没有catch等等，最后程序抛出异常后，下面的所有不限于该方法的代码都不会被执行，于是改成现在这样...但总感觉哪里不太对
            try {
                if((this.fund-animal.getInPrice())<0)
                    throw new InsufficientBalanceException("余额不足以进货，等有更多钱时再来吧");
            }catch(InsufficientBalanceException e){
            System.out.println("======================余额不足以进货，等有更多钱时再来吧====================");
            return ;
        }
            this.fund=this.fund-animal.getInPrice();
         this.animalList.add(animal);
    }

    @Override
    public void entertain(Customer customer) {
       try {
           if(close){
               throw new NotOpenException("当前时间未开门，请回吧");
           }
       }catch (NotOpenException e){
           System.out.println("====================当前时间未开门，请回吧=============================");
           return;
       }
        this.customerList.add(customer);
        this.dayCustomerlist.add(customer);
        customer.setLastComeTime(LocalDate.now());
        customer.setComeFrequency(customer.getComeFrequency()+1);

        try{
            if(animalList.isEmpty()){
                throw new AnimalNotFoundException("什么都没有，怎么也敢开店啊");
            }
        }catch (AnimalNotFoundException e){
            System.out.println("===============什么都没有，也敢开店啊========================");
            return;
        }

        int flag=0;
        for (int i = 0; i < animalList.size(); i++) {
            if (customer.getWant().getClass()==animalList.get(i).getClass()){
                this.dealList.add(animalList.get(i));
                this.animalList.remove(i);
                this.fund+=customer.getWant().getOutPrice();
                i-=1;
                flag=1;
            }
        }
        try {
            if(flag==0){
                throw new AnimalNotFoundException("没有顾客的目标商品，进货操作不行啊");
            }
        }catch (AnimalNotFoundException e){
            System.out.println("========================没有顾客的目标商品，进货操作不行啊===================");
        }//脑子麻麻的，我手边的白开水怎么没有味道。学长们写一串代码写麻了感觉效率下降了是怎么调整状态的？
    }

    @Override
    public void close() {
        //题目说用LocalDate判断，但百度了一下LocalDate只有日期，没太懂怎么个判断法
        //我想着应该是一天中某一个时间段开店之类的，对应题目的输出“一天的利润”
        //所以用了其他的LocalTime之类的
        final LocalTime MORNING = LocalTime.of(8,0);
        final LocalTime NIGHT= LocalTime.of(17,0);
        final LocalTime MOONDAY =LocalTime.of(0,0);
        final LocalTime MOONNIGHT=LocalTime.of(23,59);//还没找到怎么表达一个跨天的时间段，例如前一天22点~今天8点
        LocalTime now =LocalTime.now();

       if(now.isBefore(NIGHT)&& now.isAfter(MORNING)){
            setClose(false);
       }//上班时间：8：00~17：00

       if(now.isBefore(MORNING)&& now.isAfter(MOONDAY)){
            setClose(true);
            dealList.clear();
            dayCustomerlist.clear();
       }//清晨时间：00：00~8：00  清空昨日的名单

       if(now.isAfter(NIGHT)&&now.isBefore(MOONNIGHT)){
            setClose(true);
            System.out.println("今日顾客：");
           for (Customer customer:dayCustomerlist) {
               System.out.println(customer);
           }
           var sum =0;
           for (Animal animal:dealList) {
                    sum+=(animal.getOutPrice()-animal.getInPrice());
           }
           System.out.println("今日利润为："+sum+"元");
       }//晚下班时间：17：00~24：00  输出利润和当日顾客信息

    }
}
