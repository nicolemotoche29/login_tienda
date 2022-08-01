import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;

public class loginForm extends JDialog{
    private JTextField emailTF;
    private JPasswordField passwordTF;
    private JButton cancelarButton;
    private JButton OKButton;
    private JPanel loginPanel;

    public loginForm (JFrame parent){
        //de quien estoy heredando de JFrame
        super (parent);
        setTitle("Login");
        setContentPane(loginPanel);
        setMinimumSize(new Dimension(640,480));
        setModal(true);
        setLocationRelativeTo(parent);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setVisible(true);
        OKButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String email= emailTF.getText();
                String password = String.valueOf(passwordTF.getPassword());

                User=getAutenticationUser(email,password);

                if (User!=null){
                    dispose();
                }
                else {
                    JOptionPane.showMessageDialog(
                            loginForm.this, "El email o el Password estan incorrectos",
                            "intenta nuevamente",
                            JOptionPane.ERROR_MESSAGE
                    );
                }

            }
        });



        cancelarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });
    }

    public static void main(String[] args) {
        loginForm LoginForm = new loginForm(null);
    }

    ////elementos de autenticacion
    public user User;

    public user getAutenticationUser(String email,String password){
        user User = null;
            final String DB_URL="jdbc: mysql: // localhost/ mitienda?serverTimeZonw=UTC";
            final String USERNAME="ROOT";
            final String PASSWORD=" ";

            try{
                Connection conn = DriverManager.getConnection(DB_URL,USERNAME,PASSWORD);
            } catch (Exception e){
                e.printStackTrace();
            }

        return User;
    }
}
