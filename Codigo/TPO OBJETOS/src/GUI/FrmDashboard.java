package GUI;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

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
        //this.setSize(600, 600);

        LINEASDECRÉDITOButton.setText("<html><center>"+"Linea de"+"<br>"+"Credito"+"</center></html>");

        this.pack();

        //Establezco el comportamiento a la hora de cerrarse
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        //Que la pantalla inicie CENTRADA
        this.setLocationRelativeTo(null);

        this.eventos();

        this.self = this;
    }

    private void eventos()
    {
        ABMSOCIOSButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                FrmABMsocios frame = new FrmABMsocios(self);
                frame.setVisible(true);
            }
        });

        CONSULTASButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                FrmConsultasGenerales frame = new FrmConsultasGenerales(self);
                frame.setVisible(true);
            }
        });

        LINEASDECRÉDITOButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                FrmABMLineaDeCredito frame = new FrmABMLineaDeCredito(self);
                frame.setVisible(true);
            }
        });

        OPERACIONESButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                FrmABMOperaciones frame = new FrmABMOperaciones(self);
                frame.setVisible(true);
            }
        });
    }

    public static void main(String[] args) {
        FrmDashboard frame = new FrmDashboard("SGR");
        frame.setVisible(true);
    }

}
