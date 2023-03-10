package ex01;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class Scan {

      public static List<Class<?>> getClasses(String packageName) throws Exception {
            List<Class<?>> classes = new ArrayList<Class<?>>(); // 리스트 생성
            String path = packageName.replace('.', '/'); // .을 /로 변경
            ClassLoader classLoader = Thread.currentThread().getContextClassLoader();
            for (java.net.URL resource : java.util.Collections.list(classLoader.getResources(path))) {
                  for (File file : new File(resource.toURI()).listFiles()) {
                        if (file.getName().endsWith(".class")) {
                              String className = packageName + '.'
                                          + file.getName().substring(0, file.getName().length() - 6);
                              Class<?> cl = Class.forName(className);
                              if (cl.isAnnotationPresent(Controller.class)) {
                                    classes.add(cl);
                              }
                        }
                  }
            }
            return classes;
      }

}
