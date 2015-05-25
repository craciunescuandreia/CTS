package clase;

import java.io.IOException;

public class CustomIOException extends IOException {

	public CustomIOException(IOException exception) {
		super(exception);
	}

	public CustomIOException(String message) {
		super(message);
	}

	public CustomIOException(String message, IOException exception) {
		super(message, exception);
	}
}
