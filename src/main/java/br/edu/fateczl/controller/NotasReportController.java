package br.edu.fateczl.controller;

import java.io.ByteArrayInputStream;
import java.io.File;
import java.net.URL;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.HashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.InputStreamResource;
import org.springframework.core.io.Resource;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.JasperRunManager;
import net.sf.jasperreports.engine.util.JRLoader;

@RestController
@RequestMapping("/notas")
public class NotasReportController {
	@Autowired
	JdbcTemplate jdbcTemplate;

	@GetMapping("/report/{codigoDisciplina}")
	public ResponseEntity<Resource> getReportFaltas(@PathVariable(value = "codigoDisciplina") String codigoDisciplina) {
		URL pathURL = this.getClass().getClassLoader().getResource("");
		File dir = new File(pathURL.getFile() + File.pathSeparator + "reports");
		String path = dir.getAbsolutePath();
		String jasper = path + File.separator + "Notas.jasper";

		HashMap<String, Object> param = new HashMap<String, Object>();
		param.put("codDisciplina", codigoDisciplina);

		byte[] bytes = null;

		try {
			Connection c = jdbcTemplate.getDataSource().getConnection();

			JasperReport report = (JasperReport) JRLoader.loadObjectFromFile(jasper);
			bytes = JasperRunManager.runReportToPdf(report, param, c);
		} catch (JRException | SQLException e) {
			e.printStackTrace();
		}

		String contentType = "application/pdf";
		ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(bytes);
		InputStreamResource inputStreamResource = new InputStreamResource(byteArrayInputStream);

		return ResponseEntity.ok()
				.contentType(MediaType.parseMediaType(contentType))
				.contentLength(bytes.length)
				.header("attachment: filename=\"Notas.pfd\"")
				.body(inputStreamResource);

	}
}
