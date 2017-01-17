package com.navarro.involves.datasource;


import com.navarro.involves.constants.SystemConstants;

public class BucketFactory {

    private static Bucket ourInstance = new Bucket().setName(SystemConstants.DEFAULT_BUCKET_NAME);

    public static Bucket getInstance() {
        return ourInstance;
    }
    
    private BucketFactory() {
    }
}
