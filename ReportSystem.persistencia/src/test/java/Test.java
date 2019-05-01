
import com.furukawa.reportsystem.entidad.Empleado;
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
        
System.out.println("Consulta"+ServiceLocator.getInstanceLiderDAO().findAll());
    }
//        Lider l = new Lider();
////        l.setCodigoEmpleado("AAAA");
////        l.setNombre("Elliot");
////        l.setArea("Fusebox"); 
////        l.setFoto(null);
////        l.setTurno("Matutino");
////        ServiceLocator.getInstanceLiderDAO().save(l);
//       // System.out.println("Consulta"+ServiceLocator.getInstanceLiderDAO().findAll());
//    
//      Lider r = new Lider();
//           Empleado e = new Empleado();
//          
//          //LIDER
//            r.setCodigoEmpleado("XXX");
//            r.setLinea(2);
//            r.setArea("Ingeniero");
//            
//          //EMPLEADO
//            e.setNombre("Arellano");
//            e.setPuesto("lider");
//            e.setFoto(null);
//            e.setTurno("tarder");
//            e.setCodigoEmpleado("XXX");
//           
//            r.setEmpleado(e);
//            ServiceLocator.getInstanceLiderDAO().update(r);
//        
//        
//        
//        
//        
//    }
//    
//    l.getCodigoEmpleado();
}
