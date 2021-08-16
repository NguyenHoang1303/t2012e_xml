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

    private static final String URL_VNEXPRESS = VnExConstant.URL_VNEXPRESS;
    private static final String ITEM_TAG = VnExConstant.ITEM_TAG;
    private static final String TITLE_TAG = VnExConstant.TITLE_TAG;
    private static final String DESCRIPTION_TAG = VnExConstant.DESCRIPTION_TAG;
    private static final String PUBDATE_TAG = VnExConstant.PUBDATE_TAG;
    private static final String LINK_TAG = VnExConstant.LINK_TAG;

    public static List<Artical>  getList() {
        try {
            DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
            Document doc = dBuilder.parse(URL_VNEXPRESS);
            doc.getDocumentElement().normalize();
            NodeList list = doc.getElementsByTagName(ITEM_TAG);
            List<Artical> listArtical = new ArrayList<>();
            for (int temp = 0; temp < list.getLength(); temp++) {
                Node nNode = list.item(temp);
                if (nNode.getNodeType() == Node.ELEMENT_NODE) {
                    Element eElement = (Element) nNode;
                    String title = eElement.getElementsByTagName(TITLE_TAG).item(0).getTextContent();
                    String description = eElement.getElementsByTagName(DESCRIPTION_TAG).item(0).getTextContent();
                    String date = eElement.getElementsByTagName(PUBDATE_TAG).item(0).getTextContent();
                    String link = eElement.getElementsByTagName(LINK_TAG).item(0).getTextContent();
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
