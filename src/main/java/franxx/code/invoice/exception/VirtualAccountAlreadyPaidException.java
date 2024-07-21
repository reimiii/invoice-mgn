package franxx.code.invoice.exception;

// janagan pake runtime klo buat nge cek supaya wajib di handle pake Exception
// public class VirtualAccountAlreadyPaidException extends RuntimeException {
public class VirtualAccountAlreadyPaidException extends Exception {

  public VirtualAccountAlreadyPaidException() {
  }

  public VirtualAccountAlreadyPaidException(String message) {
    super(message);
  }
}
