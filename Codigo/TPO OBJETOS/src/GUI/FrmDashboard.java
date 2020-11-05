package GUI;

import javax.swing.*;

public class FrmDashboard extends JFrame{
    private FrmDashboard self;
    private JButton ABMSOCIOSButton;
    private JButton OPERACIONESButton;
    private JButton LINEASDECRÉDITOButton;
    private JButton CONSULTASButton;
    private JPanel panelPrincipal;
    private JPanel panelTitulo;
    private JPanel panelBotones;

    public FrmDashboard(String titulo)
    {
        super(titulo);



        try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (UnsupportedLookAndFeelException e) {
            e.printStackTrace();
        }

        this.setContentPane(panelPrincipal);
        //Establezco el comportamiento a la hora de cerrarse
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        //Que la pantalla inicie CENTRADA
        this.setLocationRelativeTo(null);

        this.self = this;
    }

    public static void main(String[] args) {
        FrmDashboard frame = new FrmDashboard("Pija");
        frame.setVisible(true);
    }

}
