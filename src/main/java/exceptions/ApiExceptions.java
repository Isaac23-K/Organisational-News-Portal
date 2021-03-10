package exceptions;

public class ApiExceptions extends RuntimeException {
    private final int statusCode;

    public void ApiException(int statusCode, String msg) {

    }

    public ApiExceptions(int statusCode) {
        this.statusCode = statusCode;
    }

    public int getStatusCode() {
        return statusCode;
    }
}


