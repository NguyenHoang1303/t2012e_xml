import entity.Artical;


import model.ArticalModel;
import xml.DomParseXml;

import java.util.List;

public class MainDOMParseXML {

    public static void main(String[] args) {
       List<Artical> listArtical = DomParseXml.getList();
        ArticalModel articalModel = new ArticalModel();
        if (listArtical != null) {
            for (Artical aritcal: listArtical) {
                articalModel.insertArticle(aritcal);
            }
        }
    }
}
