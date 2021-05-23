package controller.XML;

import models.entities.Student;

import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;
import views.Alert;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import java.io.File;
import java.io.IOException;
import java.util.List;

public class XMLReader extends DefaultHandler {
    private final Handler handler;
    private SAXParser parser;
    private final File file;

    public XMLReader(File file) {
        this.file = file;
        SAXParserFactory factory = SAXParserFactory.newInstance();
        try {
            parser = factory.newSAXParser();
        } catch (ParserConfigurationException | SAXException e) {
            new Alert("Can't open file");
            e.printStackTrace();
        }
        handler = new Handler();
    }

    public List<Student> readAll() {
        try {
            parser.parse(file, handler);
        } catch (SAXException | IOException e) {
            new Alert("Can't open file");
            e.printStackTrace();
            return null;
        }
        return handler.getStudents();
    }
}
