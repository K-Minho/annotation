package ex01;

@Controller
public class BoardController {

      @RequestMapping(uri = "/write")
      public void write() {
            System.out.println("write() called!");
      }
}
