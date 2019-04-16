package com.jhl.ipaiemanager.component;


import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.util.Assert;
import org.thymeleaf.TemplateEngine;
import org.thymeleaf.context.Context;
import org.xhtmlrenderer.pdf.ITextRenderer;

@Component
public class PdfGenerator {
	@Autowired
	private TemplateEngine templateEngine;

	public String createPdf(String templateName, Map<Object, Object> map, String fileName) throws Exception {
		Assert.notNull(templateName, "The templateName can not be null");
		
		Context ctx = new Context();
		if (map != null) {
			Iterator<Entry<Object, Object>> itMap = map.entrySet().iterator();
			while (itMap.hasNext()) {
				Map.Entry<Object, Object> pair = itMap.next();
				ctx.setVariable(pair.getKey().toString(), pair.getValue());
			}
		}
		
		String processedHtml = templateEngine.process(templateName, ctx);
		FileOutputStream os = null;
		String fileNameOut = (fileName != null) ? fileName : "default";
		
		try {
			ClassLoader classLoader = getClass().getClassLoader();
			String folder = classLoader.getResource("temps").getFile();				
			final File outputFile = File.createTempFile(fileNameOut, ".pdf", new File(folder));
			os = new FileOutputStream(outputFile);
			ITextRenderer renderer = new ITextRenderer();
			renderer.setDocumentFromString(processedHtml);
			renderer.layout();
			renderer.createPDF(os, false);
			renderer.finishPDF();
			return outputFile.getPath();
		} finally {
			if (os != null) {
				try {
					os.close();
				} catch (IOException e) { /* ignore */
				}
			}
		}

	}
}