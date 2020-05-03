package com.hiremeans.automation.utils;

public final class OsUtils {

    String OSname = null;

    public String getOSName(){
        OSname = System.getProperty("os.name");
        return OSname;
    }

    public boolean isWindowsOS(){
        if(getOSName().startsWith("Windows")){
            System.out.println("Operating system is Windows");
            return true;
        }
        return false;
    }

    public boolean isMacOs(){
        if(getOSName().startsWith("Mac")) {
            System.out.println("Operating system is mac");
            return true;
        }
        return false;
    }

    public boolean isUnix(){
        return getOSName().startsWith("Unix");
    }

}
