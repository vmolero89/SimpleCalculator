package view;

import controller.CMat;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class VMat extends JFrame implements IMat, ActionListener {
    private JTextField tNumA, tNumB, tResp;
    private JButton bCalcular, bLimpiar, bSalir;
    private JRadioButton rSuma, rResta, rMult, rDiv;

    public VMat(){

       //Crear ventana
        super("Calculadora");
        this.setSize(600,400);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setLocationRelativeTo(null);

            //PARTE SUPERIOR : Crear título
            JLabel lTitulo = new JLabel("OPERACIONES MATEMATICAS", JLabel.CENTER);
            lTitulo.setFont(new Font("Arial", Font.BOLD+Font.ITALIC, 16));
            this.add(lTitulo, BorderLayout.NORTH);

            //crea un icono a partir de un archivo de imagen
            //Icon icon = new ImageIcon("C:\\Users\\vmole\\Desktop\\demo\\captura.JPG");


            //PARTE INTERMEDIA : Crear Formulario
            JPanel pForm = new JPanel(new GridLayout(4,1,5,5));

                //FORMULARIO. FILA 1 - NÚMERO A
                JPanel pFila1 = new JPanel();
                pFila1.add(new JLabel("NUMERO A: "));   //Etiqueta del campo
                tNumA = new JTextField(20);          //Asigna un campo de texto a la variable
                pFila1.add(tNumA);                            //Muestra el campo (la variable)
                pForm.add(pFila1);                            //Añade la fila al formulario

                //FORMULARIO. FILA 2 - NÚMERO B
                JPanel pFila2 = new JPanel();
                pFila2.add(new JLabel("NUMERO B: "));
                tNumB = new JTextField(20);
                pFila2.add(tNumB);
                pForm.add(pFila2);

                //FORMULARIO. Fila 3. Panel de selección de operación
                JPanel pFila3 = new JPanel();
                pFila3.setBorder(BorderFactory.createTitledBorder("OPERACIONES"));
                    //Crear ButtonGroup de RadioButton
                    ButtonGroup bg = new ButtonGroup();
                        //Crea los 4 radioButton
                        rSuma = new JRadioButton("SUMA",true);
                        rResta = new JRadioButton("RESTA");
                        rMult = new JRadioButton("MULTIPLICA");
                        rDiv = new JRadioButton("DIVIDE");

                        //Añade los radioButton a un grupo lógico ButtonGroup
                        bg.add(rSuma);
                        bg.add(rResta);
                        bg.add(rMult);
                        bg.add(rDiv);

                        //Añade a la fila del formulario los radioButton agrupados
                        pFila3.add(rSuma);
                        pFila3.add(rResta);
                        pFila3.add(rMult);
                        pFila3.add(rDiv);

                //Añade la fila al formulario
                pForm.add(pFila3);

                //FORMULARIO. Fila 4 - Resultado
                JPanel pFila4 = new JPanel();
                pFila4.add(new JLabel("RESULTADO: "));
                tResp = new JTextField(20);
                pFila4.add(tResp);
                pForm.add(pFila4);

            //Añade el formulario a la ventana.
            this.add(pForm, BorderLayout.CENTER);

        //PARTE INFERIOR : Crear botones
        JPanel pBot = new JPanel();

        //bCalcular = new JButton("Victor", icon);
        bCalcular = new JButton("Calcular");
        bCalcular.setActionCommand(CALCULATE);
        pBot.add(bCalcular);

        bLimpiar = new JButton("Limpiar");
        bLimpiar.addActionListener(this);
        pBot.add(bLimpiar);

        bSalir = new JButton("Salir");
        bSalir.addActionListener(this);
        pBot.add(bSalir);

        this.add(pBot, BorderLayout.SOUTH);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        Object bt = e.getSource();

        if (bt==bSalir) System.exit(0);
        if (bt==bLimpiar) {
            tNumA.setText("");
            tNumB.setText("");
            tResp.setText("");
            rSuma.setSelected(true);

        }
    }


    @Override
    public double getA() {
        double a = 0.0;
        try {
            a=Double.parseDouble(tNumA.getText());
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null,"DEBE ESCRIBIR UN NUMERO");
        }
        return a;
    }

    @Override
    public double getB() {
        double b = 0.0;
        try {
            b =Double.parseDouble(tNumB.getText());
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null,"DEBE ESCRIBIR UN NUMERO");
        }
        return b;
    }

    @Override
    public char getOperation() {
        char operacion = ' ';
        if (rSuma.isSelected()) {
            operacion='+';
        } else if (rResta.isSelected()) {
            operacion ='-';
        } else if (rMult.isSelected()) {
            operacion='*';
        } else {
            operacion='/';
        }

        return operacion;
    }

    @Override
    public void setAnswer(double resp) {
        tResp.setText(resp+"");

    }

    @Override
    public void onStart() {
        this.setVisible(true);
    }

    @Override
    public void setController(CMat controller) {
        bCalcular.addActionListener(controller);
    }
}
