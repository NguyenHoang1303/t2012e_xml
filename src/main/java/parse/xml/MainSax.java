package parse.xml;

import entity.Artical;
import model.ArticalModel;
import util.VnExConstant;
import controller.SAXController;

import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import java.util.List;

public class MainSax {
    private static final String URL_VNEXPRESS = VnExConstant.URL_VNEXPRESS;

    public void parseXML(){
        try {
            SAXParserFactory factory = SAXParserFactory.newInstance();
            SAXParser saxParser = factory.newSAXParser();
            SAXController SAXController = new SAXController();
            saxParser.parse(URL_VNEXPRESS, SAXController);
            List<Artical> list = SAXController.getArticalList();
            ArticalModel articalModel = new ArticalModel();
            for (Artical artical: list) {
                articalModel.insertArticle(artical);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
