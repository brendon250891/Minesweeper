/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Application;

/**
 *
 * @author brendon
 */
public class Application {
    
    public static void main(String[] args) {
        ApplicationView view = new ApplicationView();
        Controller controller = new Controller(view);
        
    }
}
