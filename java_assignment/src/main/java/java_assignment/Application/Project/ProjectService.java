package java_assignment.Application.Project;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.ResourceUtils;

import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;

@Service
public class ProjectService {
    @Autowired
    private ProjectRepository pRepository;

    public Project save(Project p) {
        return pRepository.save(p);
    }

    public void deleteProject(Project p) {
        pRepository.delete(p);
        ;
    }

    public Project getProjectByProjectName(String p_name) {
        return pRepository.findByName(p_name);
    }

    public Project updateProject(Project p) {
        Project existingProject = pRepository.findById(p.getId())
                .orElseThrow(() -> new NoSuchElementException("Project not found with ID: " + p.getId()));
        existingProject.setName(p.getName());
        existingProject.setIntro(p.getIntro());
        existingProject.setOwner(p.getOwner());
        existingProject.setStatus(p.getStatus());
        existingProject.setStartDateTime(p.getStartDateTime());
        existingProject.setEndDateTime(p.getEndDateTime());

        return pRepository.save(existingProject);
    }

    public ArrayList<Project> viewAllProject() {
        return (ArrayList<Project>) pRepository.findAll();
    }

    public Optional<Project> getProjectByProjectId(int id) {
        return pRepository.findById(id);
    }

    public void deleteProjectById(int id) {
        pRepository.deleteById(id);
    }

    public String createJasper()  {
        String path = "D:\\Reza\\Java Assignment\\Jasper";
        List<Project> projects = pRepository.findAll();
        // load file and compile it
        File file;
        try {
            file = ResourceUtils.getFile("classpath:projects.jrxml");
            JasperReport jasperReport = JasperCompileManager.compileReport(file.getAbsolutePath());
            JRBeanCollectionDataSource dataSource = new JRBeanCollectionDataSource(projects);
            Map<String, Object> parameters = new HashMap<>();
            parameters.put("Jasper", "Report");
            JasperPrint jasperPrint = JasperFillManager.fillReport(jasperReport, parameters, dataSource);
            // if (reportFormat.equalsIgnoreCase("html")) {
            JasperExportManager.exportReportToHtmlFile(jasperPrint, path + "\\projects.html");
            // }
            // if (reportFormat.equalsIgnoreCase("pdf")) {
            JasperExportManager.exportReportToPdfFile(jasperPrint, path + "\\projects.pdf");
            // }

            return "report generated in path : " + path;
        } catch (FileNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (JRException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return"report isn't generated in path : " + path;

    }

}
