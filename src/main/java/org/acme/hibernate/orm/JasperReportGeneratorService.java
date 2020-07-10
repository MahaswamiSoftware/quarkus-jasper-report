package org.acme.hibernate.orm;

import net.sf.jasperreports.engine.*;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.sql.DataSource;
import java.sql.Connection;
import java.util.Map;

@RequestScoped
public class JasperReportGeneratorService {

    private final DataSource dataSource;

    public JasperReportGeneratorService(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    public void generatePdfReport(String jasperReportPath, String outputFileName, Map<String, Object> map) throws Exception {
        System.out.println("Connection: " + dataSource.getConnection());
        JasperReport jasperReport = JasperCompileManager.compileReport(jasperReportPath);
        Connection connection = null;
        try {
            connection = dataSource.getConnection();
            System.out.println("Connection: " + connection);
            JasperPrint jasperPrint = JasperFillManager.fillReport(jasperReport, map, connection);
            JasperExportManager.exportReportToPdfFile(jasperPrint, outputFileName);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

