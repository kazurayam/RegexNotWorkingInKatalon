import java.util.regex.Matcher
import java.util.regex.Pattern

import org.apache.pdfbox.pdmodel.PDDocument
import org.apache.pdfbox.text.PDFTextStripper

//This below lines are to get the PDF file text
File file = new File('Kreditbeslutsfil_500786.pdf')
PDDocument document = PDDocument.load(file)
PDFTextStripper stripper = new PDFTextStripper()
text = stripper.getText(document)
System.out.println("Text:" + text);
document.close()

//I am splitting the PDF text with new lines and spaces
def lines = text.split('(\r\n|\r|\n|\\s)', -1)

println(lines)

//regex pattern to find out Kreditregel ID and Resultat
String pattern = "(CR0\\d{2})|(Godkänt|Avslag)";
String rule = ""
String ssn =""
String outcome = ""
Map<String, String, String> rulesOutcomes = new HashMap<>();

// Create a Pattern object
Pattern r = Pattern.compile(pattern);

for(String line:lines){
	Matcher m = r.matcher(line);
	if (m.find( )) {
	   System.out.println("Found value: " + m.group(1) ); //Kreditregel ID
	   rule = m.group(1).replaceAll("\\s","")
	   
	   System.out.println("Found value: " + m.group(2) ); //Resultat
	   string = m.group(2).replaceAll("\\s","")
	}else {
	   System.out.println("line \"${line}\" has NO MATCH");
	}
}