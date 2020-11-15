package GUI;

import Clases.OperacionController;
import Clases.SociosController;

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

    public FrmDashboard(String titulo, SociosController controladorSocios, OperacionController controladorOperacion)
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
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        this.setLocationRelativeTo(null);

        this.eventos(controladorSocios, controladorOperacion);
        this.self = this;
    }

    private void eventos(SociosController cSocios, OperacionController cOperacion)
    {
        ABMSOCIOSButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                FrmABMsocios frame = new FrmABMsocios(self, cSocios);
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
                FrmABMLineaDeCredito frame = new FrmABMLineaDeCredito(self, cSocios, cOperacion);
                frame.setVisible(true);
            }
        });

        OPERACIONESButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                FrmABMOperaciones frame = new FrmABMOperaciones(self, cSocios, cOperacion);
                frame.setVisible(true);
            }
        });
    }

    public static void main(String[] args) {
        OperacionController controladorOperacion = new OperacionController();
        SociosController controladorSocios = new SociosController(controladorOperacion);
        FrmDashboard frame = new FrmDashboard("SGR", controladorSocios, controladorOperacion);
        frame.setVisible(true);

    }

}
