package franxx.code.invoice.exception;

// check exception
public class VirtualAccountNotFoundException extends Exception {
  public VirtualAccountNotFoundException() {
  }

  public VirtualAccountNotFoundException(String message) {
    super(message);
  }
}
