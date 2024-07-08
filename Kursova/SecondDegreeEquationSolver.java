
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class SecondDegreeEquationSolver extends JFrame {

    private JTextField A;
    private JTextField B;
    private JTextField C;
    private JTextField Field1;
    private JTextField Field2;
    private JLabel ROOT1;
    private JLabel ROOT2;

    public static void main(String[] args) {
        new SecondDegreeEquationSolver();
    }

    public SecondDegreeEquationSolver() {
        setTitle("Second Degree Equation Solver");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(500, 200);
        setLocationRelativeTo(null);
        setResizable(false);

        JPanel panel1 = new JPanel();
        this.add(panel1, BorderLayout.CENTER);
                JLabel label1 = new JLabel();
                label1.setText(" X^2 + ");
                label1.setPreferredSize(new Dimension(50,30));
            JLabel label2 = new JLabel();
            label2.setText(" X + ");
            label2.setPreferredSize(new Dimension(50,30));
        JLabel label3 = new JLabel();
        label3.setText(" = 0 ");
        label3.setPreferredSize(new Dimension(50,30));

        JLabel aLabel = new JLabel("a:");
        A = new JTextField();
        JLabel bLabel = new JLabel("b:");
        B = new JTextField();
        JLabel cLabel = new JLabel("c:");
        C = new JTextField();

        Field1 = new JTextField();
        Field1.setPreferredSize(new Dimension(80,30));
        Field2 = new JTextField();
        Field2.setPreferredSize(new Dimension(80,30));

                    JButton btn1 = new JButton("Calculate");
                JButton btn2 = new JButton("Erase");
            JButton btn3 = new JButton("Exit");

                    btn1.setFocusable(false);
                    btn1.setPreferredSize(new Dimension(130,30));
                    btn1.setFont(new Font("Tahoma",Font.BOLD,17));
                    btn1.setForeground(new Color(12, 28, 65));

                btn2.setFocusable(false);
                btn2.setPreferredSize(new Dimension(100,30));
                btn2.setFont(new Font("Tahoma",Font.BOLD,17));
                btn2.setForeground(new Color(12, 28, 65));
                btn2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                A.setText("");
                B.setText("");
                C.setText("");
                Field1.setText("");
                Field2.setText("");
            }
        });

            btn3.setFocusable(false);
            btn3.setPreferredSize(new Dimension(100,30));
            btn3.setFont(new Font("Tahoma",Font.BOLD,17));
            btn3.setForeground(new Color(12, 28, 65));

        A.setPreferredSize(new Dimension(80,30));
        B.setPreferredSize(new Dimension(80,30));
        C.setPreferredSize(new Dimension(80,30));

            btn3.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(e.getSource() == btn3){
                    System.exit(0);
                }
            }
        });

        btn1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                double a = Double.parseDouble(A.getText());
                double b = Double.parseDouble(B.getText());
                double c = Double.parseDouble(C.getText());
                double ds = calculateDiscriminant(a, b, c);
                double root1 = (-b + Math.sqrt(ds)) / (2 * a);
                double root2 = (-b - Math.sqrt(ds)) / (2 * a);

                Field1.setText(root1 + "");
                Field2.setText( root2 + "");
                }catch (NumberFormatException error){
                    JOptionPane.showMessageDialog(SecondDegreeEquationSolver.this, "Cannot use this symbols, please enter all numbers.", "Invalid symbol", JOptionPane.ERROR_MESSAGE);
                }
            }
        });
        ROOT1 = new JLabel("Root 1:");
        ROOT1.setPreferredSize(new Dimension(75,30));
        ROOT2 = new JLabel("Root 2:");
        ROOT2.setPreferredSize(new Dimension(75,30));

                panel1.add(A);
                panel1.add(label1);
                panel1.add(B);
                panel1.add(label2);
                panel1.add(C);
                panel1.add(label3);
        panel1.add(Box.createRigidArea(new Dimension(40,50)));
            panel1.add(ROOT1);
            panel1.add(Field1);
            panel1.add(ROOT2);
            panel1.add(Field2);
        panel1.add(Box.createRigidArea(new Dimension(40,60)));
        panel1.add(btn1);
        panel1.add(btn2);
        panel1.add(btn3);

        this.setVisible(true);
    }
    public static double calculateDiscriminant(double a, double b, double c) {

        return Math.pow (b, 2) - (4 * a * c);
    }

}