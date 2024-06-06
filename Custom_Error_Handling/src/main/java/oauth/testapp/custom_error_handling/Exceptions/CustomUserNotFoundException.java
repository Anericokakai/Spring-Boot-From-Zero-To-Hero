package oauth.testapp.custom_error_handling.Exceptions;

public class CustomUserNotFoundException extends  RuntimeException {
    private  String message;
//    Args constructor
    public CustomUserNotFoundException(String message){
        super(message);
        this.message=message;
    }
}
