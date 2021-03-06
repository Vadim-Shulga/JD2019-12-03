package by.it.borodachev.jd01_15;

import java.io.File;

public class Helper {


    static String getPath(String fileName, Class<?> aClass) {
        String root = System.getProperty("user.dir");
        String strPackage = aClass.getName().replace(aClass.getSimpleName(), "");
        String path = root + File.separator + "src" + File.separator+strPackage.replace(".", File.separator);
        if (fileName.length() >0)
         fileName = path+ fileName;
        else
         fileName = path.substring(0,path.length()-1);

        return fileName;
    }

}
