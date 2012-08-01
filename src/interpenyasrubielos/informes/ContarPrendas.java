/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package interpenyasrubielos.informes;


import interpenyasrubielos.InterpenyasRubielos;
import interpenyasrubielos.persistencia.pojos.Pedidos;
import java.awt.print.PrinterException;
import java.awt.print.PrinterJob;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.print.PrintService;
import javax.print.PrintServiceLookup;
import javax.print.attribute.HashPrintRequestAttributeSet;
import javax.print.attribute.PrintRequestAttributeSet;
import javax.print.attribute.standard.Copies;
import javax.print.attribute.standard.MediaPrintableArea;
import javax.print.attribute.standard.MediaSize;
import javax.print.attribute.standard.MediaSizeName;
import net.sf.jasperreports.engine.*;
import net.sf.jasperreports.engine.export.JRPrintServiceExporter;
import net.sf.jasperreports.engine.export.JRPrintServiceExporterParameter;
import net.sf.jasperreports.view.JasperViewer;

/**
 *
 * @author Usuario
 */
public class ContarPrendas {

    public ContarPrendas() {
       
        
    }
    
    int codU = 0;
        int copias = 1;
   
    String impresora = "";
    String etiqueta="C:\\tpv\\jaspers\\ticketTotal.jasper";
    
    public void startPrint() {
       try {
            Map parameters = new HashMap();
           
            parameters.put("fecha", new Date());
            EtiDataSource recorredor = new EtiDataSource();

            JasperPrint print = JasperFillManager.fillReport(etiqueta, parameters,
                   recorredor );
            JasperViewer.viewReport(print, false);
            /*
            PrinterJob job = PrinterJob.getPrinterJob();
            
            
            PrintService[] services = PrintServiceLookup.lookupPrintServices(null, null);
            int selectedService = 0;
           
            for (int i = 0; i < services.length; i++) {
                if (services[i].getName().equals(this.impresora)) {
                   
                    selectedService = i;
                    break;
                }
            }
            System.out.println(services[selectedService]);
            job.setPrintService(services[selectedService]);
            PrintRequestAttributeSet printRequestAttributeSet = new HashPrintRequestAttributeSet();
            MediaSizeName mediaSizeName = MediaSize.findMedia(4, 4, MediaPrintableArea.INCH);
            printRequestAttributeSet.add(mediaSizeName);
            printRequestAttributeSet.add(new Copies(this.copias));
            JRPrintServiceExporter exporter;
            exporter = new JRPrintServiceExporter();
            exporter.setParameter(JRExporterParameter.JASPER_PRINT, print);
          
            exporter.setParameter(JRPrintServiceExporterParameter.PRINT_SERVICE, services[selectedService]);
            exporter.setParameter(JRPrintServiceExporterParameter.PRINT_SERVICE_ATTRIBUTE_SET, services[selectedService].getAttributes());
            exporter.setParameter(JRPrintServiceExporterParameter.PRINT_REQUEST_ATTRIBUTE_SET, printRequestAttributeSet);
            exporter.setParameter(JRPrintServiceExporterParameter.DISPLAY_PAGE_DIALOG, Boolean.FALSE);
            exporter.setParameter(JRPrintServiceExporterParameter.DISPLAY_PRINT_DIALOG, Boolean.FALSE);
            exporter.exportReport();
            System.out.println("Fin reporte");
            */
           
        } catch ( JRException ex) {
            Logger.getLogger(ContarPrendas.class.getName()).log(Level.SEVERE, null, ex);
        }

    }
    private class EtiDataSource implements JRDataSource {

        public EtiDataSource() {
            iActual = -1;
            
            lista = InterpenyasRubielos.pm.getLista();
        }
        
       
        ArrayList<Pedidos> lista;
        int iActual;
        
        @Override
        public boolean next() throws JRException {
            System.out.println(iActual+1+"<"+lista.size());
           return ++iActual < lista.size();
        }

        @Override
        public Object getFieldValue(JRField jrf) throws JRException {
            Object value = "";
            
          
            return value;
        }
    }
    
    
}
