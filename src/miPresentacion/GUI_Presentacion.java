package miPresentacion;

import javax.swing.*;
import javax.swing.border.TitledBorder;
import java.awt.*;
import java.awt.event.*;

public class GUI_Presentacion extends JFrame {
    //atributos
    private JButton miFoto, miHobby, misExpectativas;
    private JPanel panelBotones, panelDatos;
    private Titulos titulo;
    private JLabel labelImagen;
    private JTextArea textoExpectativas;
    private Escucha escucha;


    //metodos
    public GUI_Presentacion(){
        initGUI();
        this.setTitle("Mi Presentacion ");
        this.setSize(800,700);
        this.setLocationRelativeTo(null);
        this.setVisible(true);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
    private void initGUI(){

        escucha = new Escucha();

        titulo = new Titulos("Hola soy Laura, oprime los botones!!",Color.black);
        this.add(titulo, BorderLayout.NORTH);

        panelDatos = new JPanel();
        panelDatos.setBorder(BorderFactory.createTitledBorder(null,"Un poco mas de mi...",
                TitledBorder.CENTER, TitledBorder.DEFAULT_POSITION, new Font("Arial", Font.PLAIN, 20), Color.BLACK));

        this.add(panelDatos,BorderLayout.CENTER);

        miFoto = new JButton("Este soy yo");
        miFoto.addMouseListener(escucha);
        miFoto.setFont(new Font("Times new roman",Font.ITALIC,15));
        miHobby = new JButton("Mi hobbit");
        miHobby.addMouseListener(escucha);
        miHobby.setFont(new Font("Times new roman",Font.ITALIC,15));
        misExpectativas = new JButton("Mis espectativas");
        misExpectativas.addKeyListener(escucha);
        misExpectativas.setFont(new Font("Times new roman",Font.ITALIC,15));

        panelBotones = new JPanel();
        panelBotones.add(miFoto);
        panelBotones.add(miHobby);
        panelBotones.add(misExpectativas);

        this.add(panelBotones,BorderLayout.SOUTH);

        labelImagen = new JLabel();
        textoExpectativas = new JTextArea(20,22);
        textoExpectativas.setFont(new Font("Times new roman",Font.BOLD,15));
        textoExpectativas.setForeground(Color.blue);

    }

    public static void main(String[] args){
        EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                GUI_Presentacion miGUIPresentacion = new GUI_Presentacion();
            }
        });
    }

    private class Escucha implements MouseListener, KeyListener {

        private ImageIcon image;
        @Override
        public void mouseClicked(MouseEvent e) {
            panelDatos.removeAll();
            if(e.getSource()==miFoto & e.getClickCount()==1){
                image = new ImageIcon(getClass().getResource("/recursos/yo.jpeg"));
                labelImagen.setIcon(image);
                panelDatos.add(labelImagen);
            }else{
                if(e.getSource()==miHobby & e.getClickCount()==2){
                    image = new ImageIcon(getClass().getResource("/recursos/MI HOBBY.jpg"));
                    labelImagen.setIcon(image);
                    panelDatos.add(labelImagen);
                }
            }
            revalidate();
            repaint();
        }

        @Override
        public void mousePressed(MouseEvent e) {

        }

        @Override
        public void mouseReleased(MouseEvent e) {

        }

        @Override
        public void mouseEntered(MouseEvent e) {

        }

        @Override
        public void mouseExited(MouseEvent e) {

        }

        @Override
        public void keyTyped(KeyEvent e) {
            panelDatos.removeAll();
            if(e.getKeyChar()=='m'){
                textoExpectativas.append("No tengo mucha habilidad para programar\n " +
                        "pero me gusta ver tutoriales de youtube sobre las cosas que se me dificultan\n" +
                        " y eso me ayuda cada vez a ser mejor y a generar un amor y pasion por lo que hago y aprendo.\n");
                textoExpectativas.setOpaque(true);
                textoExpectativas.setBackground(Color.darkGray);
                textoExpectativas.setFont(new Font("Times new roman",Font.BOLD,15));
                textoExpectativas.setForeground(Color.white);
                panelDatos.add(textoExpectativas);
            }
            revalidate();
            repaint();
        }

        @Override
        public void keyPressed(KeyEvent e) {

        }

        @Override
        public void keyReleased(KeyEvent e) {

        }
    }

    /*private class Escucha implements ActionListener{
        private ImageIcon image;

        @Override
        public void actionPerformed(ActionEvent e){
            //JOptionPane.showMessageDialog(null, "Oprimiste boton");
            panelDatos.removeAll();
            if(e.getSource()==miFoto){
                image = new ImageIcon(getClass().getResource("/recursos/yo.jpeg"));
                labelImagen.setIcon(image);
                panelDatos.add(labelImagen);
            }else{
                if(e.getSource()==miHobby){
                    image = new ImageIcon(getClass().getResource("/recursos/MI HOBBY.jpg"));
                    labelImagen.setIcon(image);
                    panelDatos.add(labelImagen);
                }else{
                    textoExpectativas.setText("No tengo mucha habilidad para programar\n " +
                            "pero me gusta ver tutoriales de youtube sobre las cosas que se me dificultan\n" +
                            " y eso me ayuda cada vez a ser mejor y a generar un amor y pasion por lo que hago y aprendo.\n");
                    textoExpectativas.setOpaque(true);
                    textoExpectativas.setBackground(Color.darkGray);
                    textoExpectativas.setFont(new Font("Times new roman",Font.BOLD,15));
                    textoExpectativas.setForeground(Color.white);
                    panelDatos.add(textoExpectativas);
                }
            }
            revalidate();
            repaint();
        }
    }*/
}














