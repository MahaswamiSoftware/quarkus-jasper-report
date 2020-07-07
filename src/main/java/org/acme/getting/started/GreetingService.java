package org.acme.getting.started;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

@ApplicationScoped
public class GreetingService {

    @Inject
    JasperReportGeneratorService jasperReportGeneratorService;

    public String greeting(String name) {
        return "hello " + name;
    }

    public void generateReport() throws Exception {
        String uuidToken = UUID.randomUUID().toString();

        String fileName = "report" + "_" + uuidToken + ".pdf";
        String outputFileName = "../temp/generatedReport/" + fileName;
        Map<String, Object> parameters = new HashMap<>();
        String jasperReportPath = "../temp/jasperReport/sample.jrxml";
        jasperReportGeneratorService.generatePdfReport(jasperReportPath, outputFileName, parameters);
    }

}
