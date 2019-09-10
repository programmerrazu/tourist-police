package com.tourist.police.apps;

public class AppsSingleton {

    private static AppsSingleton instance;

    private AppsSingleton() {

    }

    public static AppsSingleton getAppsSingletonInstance() {
        if (instance == null) {
            instance = new AppsSingleton();
        }
        return instance;
    }

    public static void setInstance(AppsSingleton instance) {
        AppsSingleton.instance = instance;
    }
}