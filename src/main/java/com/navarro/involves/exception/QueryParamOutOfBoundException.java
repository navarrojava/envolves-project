package com.navarro.involves.exception;


public class QueryParamOutOfBoundException extends Throwable {

    private static final String QUERY_PARAMS_OUT_OF_BOUND_MESSAGE = "The Number of params expected for this command is %d, and found %d";

    public QueryParamOutOfBoundException() {
        super();
    }

    public QueryParamOutOfBoundException(int expectedQueryParams, int foundQueryParams) {
       super(String.format(QUERY_PARAMS_OUT_OF_BOUND_MESSAGE, expectedQueryParams, foundQueryParams));
    }

    public QueryParamOutOfBoundException(String message, Throwable cause) {
        super(message, cause);
    }

    public QueryParamOutOfBoundException(Throwable cause) {
        super(cause);
    }

}
