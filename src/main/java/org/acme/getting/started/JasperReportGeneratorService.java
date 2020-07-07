package org.acme.getting.started;

import net.sf.jasperreports.engine.*;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.sql.DataSource;
import java.sql.Connection;
import java.util.Map;

@RequestScoped
public class JasperReportGeneratorService {


    public void generatePdfReport(String jasperReportPath, String outputFileName, Map<String, Object> map) throws Exception {
        JasperReport jasperReport = JasperCompileManager.compileReport(jasperReportPath);
        Connection connection = null;
        try {
            JasperPrint jasperPrint = JasperFillManager.fillReport(jasperReport, map);
            JasperExportManager.exportReportToPdfFile(jasperPrint, outputFileName);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

