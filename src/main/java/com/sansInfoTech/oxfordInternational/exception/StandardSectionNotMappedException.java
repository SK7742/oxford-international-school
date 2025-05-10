package com.sansInfoTech.oxfordInternational.exception;

public class StandardSectionNotMappedException extends RuntimeException {

    private static final long serialVersionUID = 1L;

    // Default constructor
    public StandardSectionNotMappedException() {
        super("Standard is not mapped to a section.");
    }

    // Constructor with a custom message
    public StandardSectionNotMappedException(String message) {
        super(message);
    }

    // Constructor with a custom message and cause
    public StandardSectionNotMappedException(String message, Throwable cause) {
        super(message, cause);
    }

    // Constructor with a cause
    public StandardSectionNotMappedException(Throwable cause) {
        super(cause);
    }
}
