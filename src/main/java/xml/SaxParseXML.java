package xml;

import entity.Artical;
import org.xml.sax.Attributes;
import org.xml.sax.helpers.DefaultHandler;
import util.VnExConstant;

import java.util.ArrayList;
import java.util.List;

public class SaxParseXML extends DefaultHandler {
    boolean bTitle = false;
    boolean bDescription = false;
    boolean bPubDate = false;
    boolean bLink = false;
    private List<Artical> articalList = new ArrayList<>();
    private Artical artical;

    public List<Artical> getArticalList() {
        return articalList;
    }

    @Override
    public void startElement(String uri, String localName, String qName, Attributes attributes) {
        switch (qName){
            case VnExConstant.ITEM_TAG:
                artical = new Artical();
                break;
            case VnExConstant.TITLE_TAG:
                bTitle = true;
                break;
            case VnExConstant.DESCRIPTION_TAG:
                bDescription = true;
                break;
            case VnExConstant.PUBDATE_TAG:
                bPubDate = true;
                break;
            case VnExConstant.LINK_TAG:
                bLink = true;
                break;
        }
    }

    @Override
    public void endElement(String uri, String localName, String qName) {
        switch (qName){
            case VnExConstant.ITEM_TAG:
                articalList.add(artical);
                break;
            case VnExConstant.TITLE_TAG:
                bTitle = false;
                break;
            case VnExConstant.DESCRIPTION_TAG:
                bDescription = false;
                break;
            case VnExConstant.PUBDATE_TAG:
                bPubDate = false;
                break;
            case VnExConstant.LINK_TAG:
                bLink = false;
                break;
        }
    }

    @Override
    public void characters(char[] ch, int start, int length) {
        String value = new String(ch, start, length);
        if (artical != null){
            if (bTitle) {
                artical.setTitle(value);
            } else if (bDescription) {
                artical.setDescription(value);
            } else if (bPubDate) {
                artical.setPubDate(value);
            } else if (bLink) {
                artical.setLink(value);
            }
        }

    }
}
