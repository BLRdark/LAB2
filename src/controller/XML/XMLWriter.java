package controller.XML;

import models.entities.Student;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;
import views.Alert;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

public class XMLWriter {
    private File file;
    private static final String DEFAULT_STRUCTURE = "<?xml version=\"1.0\" encoding=\"UTF-8\" standalone=\"no\"?>\n" +
            "<students>\n</students>";

    public XMLWriter(File file) {
        try {
            if (!file.exists()) {
                file.createNewFile();
            }
            FileWriter fileWriter = new FileWriter(file, false);
            fileWriter.write(DEFAULT_STRUCTURE);
            fileWriter.close();
            this.file = file;
        } catch (IOException e) {
            new Alert("Can't write to file");
            e.printStackTrace();
        }
    }

    public void writeAll(List<Student> students) {
        try {
            DocumentBuilderFactory documentFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder documentBuilder = documentFactory.newDocumentBuilder();
            Document document = documentBuilder.parse(file);
            document.getDocumentElement().normalize();
            Node professorTag = document.getElementsByTagName("students").item(0);
            removeAll(document, Node.ELEMENT_NODE, "student");

            for(Student student : students) {
                Element studentEl = document.createElement("student");
                professorTag.appendChild(studentEl);

                Element studentName = document.createElement("name");
                studentName.appendChild(document.createTextNode(student.getName()));
                studentEl.appendChild(studentName);

                Element studentLastName = document.createElement("lastName");
                studentLastName.appendChild(document.createTextNode(student.getLastName()));
                studentEl.appendChild(studentLastName);

                Element studentPatronymic = document.createElement("patronymic");
                studentPatronymic.appendChild(document.createTextNode(student.getPatronymic()));
                studentEl.appendChild(studentPatronymic);

                Element studentGroup = document.createElement("group");
                studentGroup.appendChild(document.createTextNode(student.getGroup()));
                studentEl.appendChild(studentGroup);

                Element passesByAnotherReason = document.createElement("byAnother");
                passesByAnotherReason.appendChild(document.createTextNode(String.valueOf(student.getByAnother())));
                studentEl.appendChild(passesByAnotherReason);

                Element passesBySickness = document.createElement("bySickness");
                passesBySickness.appendChild(document.createTextNode(String.valueOf(student.getBySickness())));
                studentEl.appendChild(passesBySickness);

                Element passesByUnexcused = document.createElement("byUnexcused");
                passesByUnexcused.appendChild(document.createTextNode(String.valueOf(student.getByUnexcused())));
                studentEl.appendChild(passesByUnexcused);

                Element totalPasses = document.createElement("total");
                totalPasses.appendChild(document.createTextNode(String.valueOf(student.getTotal())));
                studentEl.appendChild(totalPasses);
            }

            TransformerFactory transformerFactory = TransformerFactory.newInstance();
            Transformer transformer = transformerFactory.newTransformer();
            transformer.setOutputProperty(OutputKeys.METHOD, "xml");
            transformer.setOutputProperty(OutputKeys.INDENT, "yes");
            DOMSource domSource = new DOMSource(document);
            StreamResult streamResult = new StreamResult(file);
            transformer.transform(domSource, streamResult);
        } catch (ParserConfigurationException | IOException | SAXException | TransformerException e) {
            new Alert("Parser Error:");
            e.printStackTrace();
        }
    }

    private void removeAll(Node node, short nodeType, String name) {
        if (node.getNodeType() == nodeType && (name == null || node.getNodeName().equals(name))) {
            node.getParentNode().removeChild(node);
        } else {
            NodeList list = node.getChildNodes();
            for (int i = 0; i < list.getLength(); i++) {
                removeAll(list.item(i), nodeType, name);
            }
        }
    }
}
