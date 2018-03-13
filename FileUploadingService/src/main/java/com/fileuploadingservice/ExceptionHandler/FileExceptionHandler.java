package com.fileuploadingservice.ExceptionHandler;



public class FileExceptionHandler extends RuntimeException{

    public FileExceptionHandler(String message) {
        super(message);
    }

    public FileExceptionHandler(String message, Throwable throwThing) {
        super(message, throwThing);
    }
}
