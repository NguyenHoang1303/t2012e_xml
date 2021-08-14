import entity.Artical;
import model.ArticalModel;
import util.VnExConstant;
import xml.SaxParseXML;

import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import java.util.List;

public class MainSaxParseXML {

    public static void main(String[] args) {
        try {
            SAXParserFactory factory = SAXParserFactory.newInstance();
            SAXParser saxParser = factory.newSAXParser();
            SaxParseXML saxParseXML = new SaxParseXML();
            saxParser.parse(VnExConstant.URL_VNEXPRESS, saxParseXML);
            List<Artical> list = saxParseXML.getArticalList();
            ArticalModel articalModel = new ArticalModel();
            for (Artical artical: list) {
                articalModel.insertArticle(artical);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
