import javax.swing.SwingUtilities;
public class PizzaGUIRunner {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                PizzaGUIFrame main = new PizzaGUIFrame();
                main.initialize();
                main.createDisplayPanel();
                main.createImageIcon();

            }
        });
    }
}