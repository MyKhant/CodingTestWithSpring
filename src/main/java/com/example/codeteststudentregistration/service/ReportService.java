package com.example.codeteststudentregistration.service;

import com.example.codeteststudentregistration.dao.StudentDao;
import com.example.codeteststudentregistration.entity.Student;
import net.sf.jasperreports.engine.*;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.ResourceUtils;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class ReportService {

    @Autowired
    private StudentDao studentDao;

    public String exportReport(String reportFormat) throws FileNotFoundException, JRException {
        String path = "/home/mkk/Documents/TestPdf/";
        List<Student> students = studentDao.findAll();
        File file = ResourceUtils.getFile("classpath:registration.jrxml");
        JasperReport jasperReport = JasperCompileManager.compileReport(file.getAbsolutePath());
        JRBeanCollectionDataSource dataSource = new JRBeanCollectionDataSource(students);
        Map<String, Object> parameters = new HashMap<>();
        parameters.put("createdBy", "Myo Khant");
        JasperPrint jasperPrint = JasperFillManager.fillReport(jasperReport, parameters, dataSource);
        if (reportFormat.equalsIgnoreCase("html")) {
            JasperExportManager.exportReportToHtmlFile(jasperPrint, path + "registration.html");
        }
        if (reportFormat.equalsIgnoreCase("pdf")) {
            JasperExportManager.exportReportToPdfFile(jasperPrint, path + "registration.pdf");
        }

        return "report generated in path : " + path;
    }
}
