public class AnimalNotFoundException extends RuntimeException{

    public AnimalNotFoundException(){

    }

    public AnimalNotFoundException(String e){
        super(e);
    }
}
