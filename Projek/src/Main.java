
import Controllers.Controller;
import Models.Model;
import Views.LoginView;
import Views.MenuView;
import Views.RegisterView;

public class Main {
    public static void main(String[] args) {
        LoginView lv = new LoginView();
        MenuView mv = new MenuView();
        mv.dispose();
        RegisterView rv = new RegisterView();
        rv.dispose();               
        Model modell = new Model();                     
        Controller ct = new Controller(lv, rv, mv, modell);
    }
}
