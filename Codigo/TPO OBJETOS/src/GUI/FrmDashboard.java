package GUI;

import Clases.OperacionController;
import Clases.SocioParticipe;
import Clases.SocioProtector;
import Clases.SociosController;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

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

    public static void main(String[] args) throws ParseException {
        OperacionController controladorOperacion = new OperacionController();
        SociosController controladorSocios = new SociosController(controladorOperacion);

        SimpleDateFormat df = new SimpleDateFormat("dd/MM/yy");
        String dateStringCommon = "10/10/1991";
        Date commonDate = df.parse(dateStringCommon);

        controladorSocios.crearSocioParticipe("20121231238",
                "Usuario de prueba",
                commonDate,
                "Participe",
                "ActPrincipal",
                "Calle falsa 123",
                "1112341234",
                "example@gmail.com",
                true,
                "Documentacion del tipo",
                commonDate,
                true,
                "Usuario de ingreso");
        controladorSocios.crearSocioProtector("20400067385",
                "Usuario de prueba 2",
                commonDate,
                "Protector",
                "ActPrincipal",
                "Calle falsa 123",
                "1112341234",
                "example@gmail.com",
                true,
                "Documentacion del tipo",
                commonDate,
                true,
                "Usuario de ingreso");

        SocioProtector socioAux = null;
        for(SocioProtector s : controladorSocios.getListaDeSociosProtectores()) {
            if(s.getCuit().equals("20400067385")){
                socioAux = s;
            }
        }

        SocioParticipe socioAux2 = null;
        for(SocioParticipe s : controladorSocios.getListaDeSociosParticipes()) {
            if(s.getCuit().equals("20121231238")){
                socioAux2 = s;
            }
        }

        controladorOperacion.crearLineaDeCredito(1, "2000", new Date(), true, socioAux2);

        controladorOperacion.crearOperacion(1, "Tipo 1", "Ingresado", null, "2000",new Date(), new Date(), 0,
                0.0f, "ICBC", "123456", new Date(), "20593456543", 0.0f, "", new Date(),
                "", 0.0f, new Date(), 0, "");

        controladorOperacion.crearOperacion(1, "Tipo 2", "Ingresado", null, "2000",new Date(), new Date(), 0,
                0.0f, "ICBC", "123456", new Date(), "20593456543", 0.0f, "", new Date(),
                "", 0.0f, new Date(), 0, "");

        controladorOperacion.crearOperacion(1, "Tipo 3", "Ingresado", null, "2000",new Date(), new Date(), 0,
                0.0f, "ICBC", "123456", new Date(), "20593456543", 0.0f, "", new Date(),
                "", 0.0f, new Date(), 0, "");

        controladorSocios.crearAccionista("2058435241",5,"Razon puto", "20121231238");
        controladorSocios.crearAccionista("2058435246",50,"Razon puto2", "20400067385");

        FrmDashboard frame = new FrmDashboard("SGR", controladorSocios, controladorOperacion);
        frame.setVisible(true);

    }

}
