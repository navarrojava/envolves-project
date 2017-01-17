package com.navarro.involves;

public abstract class MicroTests {

    public void assertTrue(boolean condition) {
        if (!condition)
            executeError(String.format("expected %s and found %s", condition, !condition));
    }

    public void assertEquals(String value, String expected) {
        if (!value.equals(expected)) {
            executeError(String.format("expected %s and found %s", expected, value));
        }
    }

    public void assertEquals(int value, int expected) {
        if (!(value == expected)) {
            executeError(String.format("expected %d and found %d", expected, value));
        }
    }

    public void assertNotNull(Object o){
        if(o == null){
            executeError("expected  not null and found null");
        }
    }

    private void executeError(String error) {
        throw new Error(error);
    }
}
