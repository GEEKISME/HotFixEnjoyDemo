package com.biotag.hotfixenjoydemo;

import java.io.File;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

public class Fix {


    /**
     *
     * @param classLoader
     * @param path
     */
    public static void fix(ClassLoader classLoader,String optpath, String path){
        Class cls ;
//        dexPathList
        Field pathListField = null;
        for (cls = classLoader.getClass();cls!=null;cls = cls.getSuperclass()) {
            try {
                pathListField = cls.getDeclaredField("pathList");
                if(pathListField!=null){
                    pathListField.setAccessible(true);
                    break;
                }
            }catch (Exception e){
                e.printStackTrace();
            }
        }

        //从 dexpathList 反射找到makepathelement方法
        try {
            Object pathList = pathListField.get(classLoader);
            Class<?> pathListCls = pathList.getClass();
            Method makePathElements = pathListCls.getDeclaredMethod("makePathElements",
                    List.class, File.class, List.class);
            makePathElements.setAccessible(true);

            //要插入的新的dex的文件集合
            List<File> list = new ArrayList<>();
            list.add(new File(path));


//            makePathElements.invoke();
        } catch (Exception e) {

            e.printStackTrace();
        }


    }
}
