
import com.furukawa.reportsystem.entidad.Lider;
import com.furukawa.reportsystem.entidad.Empleado;
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
        Empleado e = new Empleado();
//        e.setCodigoEmpleado("ZZZZ");
//        e.setNombre("MARIANO");
//        e.setPuesto("asociado");
//        e.setTurno("Matutino");
//        e.setFoto(null);
        
        l.setCodigoEmpleado("ZZZZ");
        l.setArea("RFC");
        l.setLinea(2);
        l.setEmpleado(e);
        
        ServiceLocator.getInstanceLiderDAO().saveOrUpdate(l);
//        ServiceLocator.getInstanceEmpleadoDAO().save(e);
        
//        ServiceLocator.getInstanceLiderDAO().executeUpdate("INSERT INTO `productionlinereportsystem`.`lider` "
//                + "(`codigoEmpleado`, `area`, `linea`) VALUES ('ZZZZ', 'RFC', '2');");
//        System.out.println("Consulta"+ServiceLocator.getInstanceLiderDAO().findAll());
    }
    
//    l.getCodigoEmpleado();
}
