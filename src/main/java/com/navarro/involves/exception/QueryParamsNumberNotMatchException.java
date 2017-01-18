package com.navarro.involves.exception;


public class QueryParamsNumberNotMatchException extends Throwable {

    private static final String QUERY_PARAMS_NUMBER_NOT_MATCH_MESSAGE = "The Number of params expected for this command is %d, and found %d";

    public QueryParamsNumberNotMatchException() {
        super();
    }

    public QueryParamsNumberNotMatchException(int expectedQueryParams, int foundQueryParams) {
       super(String.format(QUERY_PARAMS_NUMBER_NOT_MATCH_MESSAGE, expectedQueryParams, foundQueryParams));
    }

    public QueryParamsNumberNotMatchException(String message, Throwable cause) {
        super(message, cause);
    }

    public QueryParamsNumberNotMatchException(Throwable cause) {
        super(cause);
    }

}
