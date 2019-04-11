
import com.furukawa.reportsystem.entidad.Lider;
import com.furukawa.reportsystem.integracion.ServiceLocator;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Elliot
 */
public class Test {
    public static void main(String[] args){
        Lider l = new Lider();
//        l.setCodigoEmpleado("AAAA");
//        l.setNombre("Elliot");
//        l.setArea("Fusebox");
//        l.setFoto(null);
//        l.setTurno("Matutino");
//        ServiceLocator.getInstanceLiderDAO().save(l);
        System.out.println("Consulta"+ServiceLocator.getInstanceLiderDAO().findAll());
    }
    
//    l.getCodigoEmpleado();
}
