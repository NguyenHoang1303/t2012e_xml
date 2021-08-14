package xml;

import entity.Artical;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import util.VnExConstant;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import java.util.ArrayList;
import java.util.List;

public class DomParseXml {
    public static List<Artical>  getList() {
        try {
            DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
            Document doc = dBuilder.parse(VnExConstant.URL_VNEXPRESS);
            doc.getDocumentElement().normalize();
            NodeList list = doc.getElementsByTagName(VnExConstant.ITEM_TAG);
            List<Artical> listArtical = new ArrayList<>();
            for (int temp = 0; temp < list.getLength(); temp++) {
                Node nNode = list.item(temp);
                if (nNode.getNodeType() == Node.ELEMENT_NODE) {
                    Element eElement = (Element) nNode;
                    String title = eElement.getElementsByTagName(VnExConstant.TITLE_TAG).item(0).getTextContent();
                    String description = eElement.getElementsByTagName(VnExConstant.DESCRIPTION_TAG).item(0).getTextContent();
                    String date = eElement.getElementsByTagName(VnExConstant.PUBDATE_TAG).item(0).getTextContent();
                    String link = eElement.getElementsByTagName(VnExConstant.LINK_TAG).item(0).getTextContent();
                    Artical artical = new Artical(title, description, date, link);
                    listArtical.add(artical);
                }
            }
            return listArtical;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}
