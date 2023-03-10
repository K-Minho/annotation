package ex01;

@Controller
public class UserController {

      @RequestMapping(uri = "/login")
      public void login() {
            System.out.println("login() called!");
      }

      @RequestMapping(uri = "/join")
      public void join() {
            System.out.println("join() called!");
      }

      @RequestMapping(uri = "/joinForm")
      public void joinForm() {
            System.out.println("joinForm() called!");
      }

      @RequestMapping(uri = "/loginForm")
      public void loginForm() {
            System.out.println("loginForm() called!");
      }

      @RequestMapping(uri = "/userInfo")
      public void userInfo() {
            System.out.println("userInfo() called!");
      }
}
