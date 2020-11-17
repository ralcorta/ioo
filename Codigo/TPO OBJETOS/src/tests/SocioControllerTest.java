package tests;

import Clases.*;
import org.testng.Assert;
import org.testng.annotations.*;

import java.text.ParseException;
import java.util.Date;

public class SocioControllerTest {
    private SociosController sc;
    private OperacionController oc;

    @BeforeMethod
    public void setUp() throws ParseException {
        oc = new OperacionController();
        sc = new SociosController(oc);
    }

    @Test
    public void crearSocioParticipeTest() {
        String cuit = "20121231238";
        String resultado = sc.crearSocioParticipe("20121231238",
                "Usuario de prueba",
                new Date(),
                "Participe",
                "ActPrincipal",
                "Calle falsa 123",
                "1112341234",
                "example@gmail.com",
                true,
                "Documentacion del tipo",
                new Date(),
                true,
                "Usuario de ingreso");
        Assert.assertEquals("El socio con CUIT " + cuit + " ha sido creado correctamente.", resultado);
    }

    @Test
    public void crearSocioProtectorTest(){
        String cuit = "20400067385";
        String resultado = sc.crearSocioProtector("20400067385",
                "Usuario de prueba 2",
                new Date(),
                "Protector",
                "ActPrincipal",
                "Calle falsa 123",
                "1112341234",
                "example@gmail.com",
                true,
                "Documentacion del tipo",
                new Date(),
                true,
                "Usuario de ingreso");
        Assert.assertEquals("El socio con CUIT " + cuit + " ha sido creado correctamente.", resultado);
    }

    @Test
    public void crearSocioDuplicado() {
        String cuit = "20121231238";
        sc.crearSocioParticipe("20121231238",
                "Usuario de prueba",
                new Date(),
                "Participe",
                "ActPrincipal",
                "Calle falsa 123",
                "1112341234",
                "example@gmail.com",
                true,
                "Documentacion del tipo",
                new Date(),
                true,
                "Usuario de ingreso");

        String resultadoDos = sc.crearSocioParticipe("20121231238",
                "Usuario de prueba",
                new Date(),
                "Participe",
                "ActPrincipal",
                "Calle falsa 123",
                "1112341234",
                "example@gmail.com",
                true,
                "Documentacion del tipo",
                new Date(),
                true,
                "Usuario de ingreso");

        Assert.assertEquals(resultadoDos, "El socio con CUIT 20121231238 ya existe, no puede ser creado nuevamente.");
        Assert.assertEquals(sc.getListaDeSociosParticipes().size(), 1);
    }

    @Test
    public void updateSocioProtectorTest(){
        String razonSocialAnterior = "Test Anterior Razon";
        String razonSocialNueva = "Test Nueva Razon";
        boolean esPlenoNuevo = true;
        SocioProtector socioAux = null;

        sc.crearSocioProtector("20400067385",razonSocialAnterior, new Date(), "Protector", "ActPrincipal","Calle falsa 123","1112341234","example@gmail.com",false,"Documentacion del tipo",new Date(),true,"Usuario de ingreso");

        for (SocioProtector socio : sc.getListaDeSociosProtectores()) {
            if(socio.getCuit().equals("20400067385")) {
                socioAux = socio;
            }
        }

        String resultado = sc.updateSocioProtector("20400067385",razonSocialNueva,new Date(),"Protector","ActPrincipal","Calle falsa 123","1112341234","example@gmail.com",esPlenoNuevo,"Documentacion del tipo",new Date(),true,"Usuario de ingreso");

        Assert.assertEquals(resultado, "El socio con CUIT 20400067385 fue actualizado correctamente !");
        Assert.assertNotEquals(razonSocialNueva, razonSocialAnterior);
        Assert.assertEquals(razonSocialNueva, socioAux.getRazonSocial());
        Assert.assertEquals(esPlenoNuevo, socioAux.isEsPleno());
    }

    @Test
    public void updateSocioParticipeTest(){
        String razonSocialAnterior = "Test Anterior Razon";
        String razonSocialNueva = "Test Nueva Razon";
        boolean esPlenoNuevo = true;
        SocioParticipe socioAux = null;

        sc.crearSocioParticipe("20400067385",razonSocialAnterior, new Date(), "Protector", "ActPrincipal","Calle falsa 123","1112341234","example@gmail.com",false,"Documentacion del tipo",new Date(),true,"Usuario de ingreso");

        for (SocioParticipe socio : sc.getListaDeSociosParticipes()) {
            if(socio.getCuit().equals("20400067385")) {
                socioAux = socio;
            }
        }

        String resultado = sc.updateSocioParticipe("20400067385",razonSocialNueva,new Date(),"Protector","ActPrincipal","Calle falsa 123","1112341234","example@gmail.com",esPlenoNuevo,"Documentacion del tipo",new Date(),true,"Usuario de ingreso");

        Assert.assertEquals("El socio con CUIT 20400067385 fue actualizado correctamente !", resultado);
        Assert.assertNotEquals(razonSocialAnterior, razonSocialNueva);
        Assert.assertEquals(socioAux.getRazonSocial(), razonSocialNueva);
        Assert.assertEquals(socioAux.isEsPleno(), esPlenoNuevo);
    }

    @Test
    public void crearAccionistaTest(){
        SocioParticipe socioAux = null;
        Accionistas accionistaAux = null;

        sc.crearSocioParticipe("20400067385","Rodrigo Sosa", new Date(), "Protector", "ActPrincipal","Calle falsa 123","1112341234","example@gmail.com",true,"Documentacion del tipo",new Date(),true,"Usuario de ingreso");

        for (SocioParticipe socio : sc.getListaDeSociosParticipes()) {
            if(socio.getCuit().equals("20400067385")) {
                socioAux = socio;
            }
        }

        Assert.assertEquals(socioAux.getListaDeAccionistas().size(), 0);

        String resultado = sc.crearAccionista("20234933231",20, "Accionista Uno", "20400067385");

        for(Accionistas a: socioAux.getListaDeAccionistas()){
            if(a.getCuit().equals("20234933231")){
                accionistaAux = a;
            }
        }

        Assert.assertEquals("Accionista creado con exito", resultado);
        Assert.assertEquals(socioAux.getListaDeAccionistas().size(), 1);
        Assert.assertEquals(accionistaAux.getCuit(), "20234933231");
        Assert.assertEquals(accionistaAux.getPorcentajeDeParticipacion(), 20);
        Assert.assertEquals(accionistaAux.getRazonSocial(), "Accionista Uno");
    }
}
