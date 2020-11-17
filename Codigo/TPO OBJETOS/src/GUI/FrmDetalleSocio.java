package GUI;

import Clases.SocioParticipe;
import Clases.SocioProtector;
import Clases.SociosController;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.ParseException;
import java.text.SimpleDateFormat;

public class FrmDetalleSocio extends JDialog {
    private FrmDetalleSocio self;
    private JPanel panelTituloDetalleSocio;
    private JTextField textCuitSocio;
    private JTextField textRazonSocial;
    private JTextField textFechaInicioAct;
    private JTextField textActPrincipal;
    private JTextField textDireccion;
    private JTextField textTelefono;
    private JTextField textEmail;
    private JTextField textDocumentacion;
    private JTextField textFechaDocumentacion;
    private JTextField textEstadoDocumentacion;
    private JTextField textUsuarioDeIngreso;
    private JComboBox comboBoxSocioPleno;
    private JButton guardarButton;
    private JButton cancelarButton;
    private JPanel panelFormularioSocios;
    private JComboBox socioCombo;
    private JComboBox comboEstadoDocumentacion;
    private JButton listaDeAccionistasButton;
    private JButton listaDeAccionesButton;

    public FrmDetalleSocio(Window owner, SociosController cSocio) {
        super(owner, "Detalle de Socio");
        this.setContentPane(panelTituloDetalleSocio);
        //this.setSize(300, 300);
        comboBoxSocioPleno.addItem("No");
        comboBoxSocioPleno.addItem("Si");

        socioCombo.addItem("Participe");
        socioCombo.addItem("Protector");

        comboEstadoDocumentacion.addItem("Controlado");
        comboEstadoDocumentacion.addItem("Rechazado");

        listaDeAccionistasButton.setEnabled(false);
        listaDeAccionesButton.setEnabled(false);

        comboBoxSocioPleno.setSelectedItem("No");
        comboBoxSocioPleno.setEnabled(false);

        this.pack();
        this.setModal(true);
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        this.setLocationRelativeTo(null);

        this.eventos(cSocio, "Create");

        this.self = this;
    }

    public FrmDetalleSocio(Window owner, SociosController cSocio, SocioParticipe socio) {
        super(owner, "Detalle de Socio");
        this.setContentPane(panelTituloDetalleSocio);
        //this.setSize(300, 300);
        comboBoxSocioPleno.addItem("No");
        comboBoxSocioPleno.addItem("Si");

        socioCombo.addItem("Participe");
        socioCombo.addItem("Protector");

        comboEstadoDocumentacion.addItem("Controlado");
        comboEstadoDocumentacion.addItem("Rechazado");

        socioCombo.setEnabled(false);
        textCuitSocio.setEditable(false);

        this.pack();
        this.setModal(true);
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        this.setLocationRelativeTo(null);

        this.eventos(cSocio, "Update");

        this.self = this;

        this.textCuitSocio.setText(socio.getCuit());
        this.textRazonSocial.setText(socio.getRazonSocial());
        this.textFechaInicioAct.setText(new SimpleDateFormat("dd/MM/yyyy").format(socio.getFechaInicioActividades()));
        this.textActPrincipal.setText(socio.getActividadPrincipal());
        this.textDireccion.setText(socio.getDireccion());
        this.textTelefono.setText(socio.getTelefono());
        this.textEmail.setText(socio.getCorreoElectronico());
        this.textDocumentacion.setText(socio.getDocumentacion());
        this.textFechaDocumentacion.setText(new SimpleDateFormat("dd/MM/yyyy").format(socio.getFechaDocumentacion()));
        this.textUsuarioDeIngreso.setText(socio.getUsuarioDocumentacion());
        if(socio.isEsPleno()){
            this.comboBoxSocioPleno.getModel().setSelectedItem("Si");
        } else {
            this.comboBoxSocioPleno.getModel().setSelectedItem("No");
        }

        if(socio.getTipo().equals("Participe")){
            this.socioCombo.getModel().setSelectedItem("Participe");
        } else {
            this.socioCombo.getModel().setSelectedItem("Protector");
        }
        comboBoxSocioPleno.setEnabled(false);

        if(socio.getEstadoDocumentacion() == true) {
            this.comboEstadoDocumentacion.getModel().setSelectedItem("Controlado");
        } else {
            this.comboEstadoDocumentacion.getModel().setSelectedItem("Rechazado");
        }
    }

    public FrmDetalleSocio(Window owner, SociosController cSocio, SocioProtector socio) {
        super(owner, "Detalle de Socio");
        this.setContentPane(panelTituloDetalleSocio);
        //this.setSize(300, 300);
        comboBoxSocioPleno.addItem("No");
        comboBoxSocioPleno.addItem("Si");

        socioCombo.addItem("Participe");
        socioCombo.addItem("Protector");

        comboEstadoDocumentacion.addItem("Controlado");
        comboEstadoDocumentacion.addItem("Rechazado");

        socioCombo.setEnabled(false);
        textCuitSocio.setEditable(false);

        this.pack();
        this.setModal(true);
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        this.setLocationRelativeTo(null);

        this.eventos(cSocio, "Update");

        this.self = this;

        this.textCuitSocio.setText(socio.getCuit());
        this.textRazonSocial.setText(socio.getRazonSocial());
        this.textFechaInicioAct.setText(new SimpleDateFormat("dd/MM/yyyy").format(socio.getFechaInicioActividades()));
        this.textActPrincipal.setText(socio.getActividadPrincipal());
        this.textDireccion.setText(socio.getDireccion());
        this.textTelefono.setText(socio.getTelefono());
        this.textEmail.setText(socio.getCorreoElectronico());
        this.textDocumentacion.setText(socio.getDocumentacion());
        this.textFechaDocumentacion.setText(new SimpleDateFormat("dd/MM/yyyy").format(socio.getFechaDocumentacion()));
        this.textUsuarioDeIngreso.setText(socio.getUsuarioDocumentacion());
        if(socio.isEsPleno()){
            this.comboBoxSocioPleno.setSelectedIndex(1);
        } else {
            this.comboBoxSocioPleno.setSelectedIndex(0);
        }

        if(socio.getTipo().equals("Participe")){
            this.socioCombo.setSelectedIndex(0);
        } else {
            this.socioCombo.setSelectedIndex(1);
        }
        comboBoxSocioPleno.setEnabled(false);

        if(socio.getEstadoDocumentacion() == true) {
            this.comboEstadoDocumentacion.setSelectedIndex(0);
        } else {
            this.comboEstadoDocumentacion.setSelectedIndex(1);
        }
    }

    private void eventos(SociosController cSocio, String operation) {
        cancelarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                dispose();
            }
        });

        guardarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                if (textCuitSocio.getText().length() == 0 ||
                        textRazonSocial.getText().length() == 0 ||
                        textFechaInicioAct.getText().length() == 0 ||
                        textActPrincipal.getText().length() == 0 ||
                        textDireccion.getText().length() == 0 ||
                        textTelefono.getText().length() == 0 ||
                        textEmail.getText().length() == 0 ||
                        textDocumentacion.getText().length() == 0 ||
                        textFechaDocumentacion.getText().length() == 0 ||
                        textUsuarioDeIngreso.getText().length() == 0) {
                    JOptionPane.showMessageDialog(null,"Revisar formulario. Alguno de los campos mandatorios esta vacio.", "ERROR: Input error" ,JOptionPane.ERROR_MESSAGE);
                } else {
                    boolean isPleno = comboBoxSocioPleno.getSelectedItem().equals("Si");
                    boolean isDocumentacion = comboEstadoDocumentacion.getSelectedItem().equals("Controlado");

                    if (socioCombo.getSelectedItem().toString().equals("Participe")) {
                        try {
                            if (operation.equals("Create")) {
                                String respuesta = cSocio.crearSocioParticipe(textCuitSocio.getText(), textRazonSocial.getText(),
                                        new SimpleDateFormat("dd/MM/yyyy").parse(textFechaInicioAct.getText()), socioCombo.getSelectedItem().toString(),
                                        textActPrincipal.getText(), textDireccion.getText(),
                                        textTelefono.getText(), textEmail.getText(),
                                        isPleno, textDocumentacion.getText(),
                                        new SimpleDateFormat("dd/MM/yyyy").parse(textFechaDocumentacion.getText()), isDocumentacion,
                                        textUsuarioDeIngreso.getText());
                                JOptionPane.showMessageDialog(self, respuesta);
                                dispose();
                            }
                            if (operation.equals("Update")) {
                                String respuesta = cSocio.updateSocioParticipe(textCuitSocio.getText(), textRazonSocial.getText(),
                                        new SimpleDateFormat("dd/MM/yyyy").parse(textFechaInicioAct.getText()), socioCombo.getSelectedItem().toString(),
                                        textActPrincipal.getText(), textDireccion.getText(),
                                        textTelefono.getText(), textEmail.getText(),
                                        isPleno, textDocumentacion.getText(),
                                        new SimpleDateFormat("dd/MM/yyyy").parse(textFechaDocumentacion.getText()), isDocumentacion,
                                        textUsuarioDeIngreso.getText());
                                JOptionPane.showMessageDialog(self, respuesta);
                                dispose();
                            }
                        } catch (ParseException e) {
                            e.printStackTrace();
                            dispose();
                        }
                    } else if (socioCombo.getSelectedItem().toString().equals("Protector")) {
                        try {
                            if (operation.equals("Create")) {
                                String respuesta = cSocio.crearSocioProtector(textCuitSocio.getText(), textRazonSocial.getText(),
                                        new SimpleDateFormat("dd/MM/yyyy").parse(textFechaInicioAct.getText()), socioCombo.getSelectedItem().toString(),
                                        textActPrincipal.getText(), textDireccion.getText(),
                                        textTelefono.getText(), textEmail.getText(),
                                        isPleno, textDocumentacion.getText(),
                                        new SimpleDateFormat("dd/MM/yyyy").parse(textFechaDocumentacion.getText()), isDocumentacion,
                                        textUsuarioDeIngreso.getText());
                                JOptionPane.showMessageDialog(self, respuesta);
                                dispose();
                            }
                            if (operation.equals("Update")) {
                                String respuesta = cSocio.updateSocioProtector(textCuitSocio.getText(), textRazonSocial.getText(),
                                        new SimpleDateFormat("dd/MM/yyyy").parse(textFechaInicioAct.getText()), socioCombo.getSelectedItem().toString(),
                                        textActPrincipal.getText(), textDireccion.getText(),
                                        textTelefono.getText(), textEmail.getText(),
                                        isPleno, textDocumentacion.getText(),
                                        new SimpleDateFormat("dd/MM/yyyy").parse(textFechaDocumentacion.getText()), isDocumentacion,
                                        textUsuarioDeIngreso.getText());
                                JOptionPane.showMessageDialog(self, respuesta);
                                dispose();
                            }
                        } catch (ParseException e) {
                            e.printStackTrace();
                            dispose();
                        }
                    }
                }
            }
        });

        listaDeAccionistasButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                FrmABMAccionista frame = new FrmABMAccionista(self, cSocio, textCuitSocio.getText());
                frame.setVisible(true);
            }
        });

        listaDeAccionesButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                FrmABMAcciones frame = new FrmABMAcciones(self, cSocio, textCuitSocio.getText());
                frame.setVisible(true);
            }
        });
    }
}
