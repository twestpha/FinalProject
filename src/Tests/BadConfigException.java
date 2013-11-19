package Tests;

public class BadConfigException extends Exception {

    public BadConfigException(String message){
        super(message);
    }
   
    @Override
    public String toString() {
        return "The file you are reading has an unsupported format";
    }
}