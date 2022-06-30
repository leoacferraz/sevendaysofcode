package br.com.sevendaysofcode.myproject;

import java.io.IOException;
import java.io.Writer;
import java.util.Iterator;
import java.util.List;

public class HTMLGenerator {
	
	Writer writer;

	public HTMLGenerator(Writer w) {
		this.writer = w;
	}

	public void generate(List<? extends Content> list) throws IOException {

		String head =
				"""
				<head>
					<meta charset=\"utf-8\">
					<meta name=\"viewport\" content=\"width=device-width, initial-scale=1, shrink-to-fit=no\">
					<link rel=\"stylesheet\" href=\"https://cdn.jsdelivr.net/npm/bootstrap@4.0.0/dist/css/bootstrap.min.css\" 
						+ "integrity=\"sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm\" crossorigin=\"anonymous\">					
				</head>
				""";

		writer.write(head);

		Iterator<? extends Content> it = list.iterator();

		while (it.hasNext()) {

			String divTemplate = """
					<div class=\"card text-white bg-dark mb-3\" style=\"max-width: 18rem;\">
						<h4 class=\"card-header\">%s</h4>
						<div class=\"card-body\">
							<p class=\"card-text mt-2\">%s</p>
							<img class=\"card-img\" src=\"%s\" alt=\"%s\">
							<p class=\"card-text mt-2\">Nota: %s</p>
							<p class=\"card-text mt-2\">Ano: %s</p>
						</div>
					</div>
					""";

			Content content = it.next();
			writer.append(String.format(divTemplate, content.title(), content.type(), content.urlImage(), content.title(),
					content.rating(), content.year()));
		}
		System.out.println("Html gerado e salvo no diretório.");
	}

}
