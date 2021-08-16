package parse.xml;

import entity.Artical;


import model.ArticalModel;
import controller.DOMController;

import java.util.List;

public class DOM {
    public void parseXML(){
        List<Artical> listArtical = DOMController.getList();
        ArticalModel articalModel = new ArticalModel();
        if (listArtical != null) {
            for (Artical aritcal: listArtical) {
                articalModel.insertArticle(aritcal);
            }
        }
    }
}
