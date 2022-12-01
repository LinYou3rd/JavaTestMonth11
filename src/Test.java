public class Test {
    public static void main(String[] args) {
        Animal dog01 = new ChinaPastoralDog("thundboom",4,true,60,true);
        Animal mouse02 = new CityMouse("chainsaw",2,true,3,"red");
        MyAnimalShop myAnimalShop=new MyAnimalShop(1000);

        myAnimalShop.restocking(mouse02);
        myAnimalShop.restocking(dog01);
        System.out.println(myAnimalShop.getFund());
        System.out.println(myAnimalShop.getAnimalList());
        //测试购入状况

        Animal cat03= new CatCat("zhou",1,false,1200);
        myAnimalShop.restocking(cat03);//测试余额不足以进货的状况
        System.out.println(myAnimalShop.getFund());

        Animal dogwant =new ChinaPastoralDog("want",1,false,1,true);
        Animal catwant = new CatCat("want",1,false,1);
        Animal mousewant = new CityMouse("want",1,false,1,"white");
        //对顾客类我写了一个属性表示顾客想要哪类的动物，狗鼠猫等；写方法进行设置时，发现把类作为参数，传入的实际是该类的对象。于是写了这三个只为了作为“want”属性的对象。

        Customer customer01 = new Customer("买到力");
        customer01.setWant(dogwant);
        Customer customer02 = new Customer("一般来访顾客");
        customer02.setWant(mousewant);
        Customer customer03 = new Customer("找不到力");
        customer03.setWant(catwant);
        myAnimalShop.entertain(customer01);
        myAnimalShop.entertain(customer02);
        myAnimalShop.entertain(customer03);

        System.out.println(myAnimalShop.getAnimalList());//查看库存是否移除成功
        System.out.println(myAnimalShop.getCustomerList());


        myAnimalShop.close();//由于是采用了now来判断时间，所以这里测试我是自己改了电脑时间，会有些麻烦，sorry
    }
}
