package ex01;

import java.lang.annotation.Annotation;
import java.lang.reflect.Method;
import java.util.List;
import java.util.Scanner;

public class MyRefApp {
      public static void main(String[] args) throws Exception {
            Scanner sc = new Scanner(System.in);

            System.out.println("enter package.");
            String pack = sc.nextLine();
            List<Class<?>> list = Scan.getClasses(pack);
            if (list.isEmpty()) {
                  throw new Exception("존재하지 않는 package이거나 내부에 클래스가 없습니다.");
            }
            System.out.println("enter path. with /");
            String path = sc.nextLine();

            Loop1: for (int i = 0; i < list.size(); i++) {
                  Class cl = list.get(i);

                  Method[] methods = cl.getMethods();

                  for (Method mt : methods) {
                        Annotation anno = mt.getDeclaredAnnotation(RequestMapping.class);
                        if (anno == null) {
                              break;
                        }
                        RequestMapping rm = (RequestMapping) anno;
                        if (rm.uri().equals(path)) {
                              System.out.println(cl.getName() + "의 내부 메서드 실행.");
                              mt.invoke(cl.newInstance());
                              break Loop1;
                        }
                  }
                  System.out.println(cl.getName() + "에 존재하지 않거나 일치하지 않는 경로입니다.");
            }
      }
}