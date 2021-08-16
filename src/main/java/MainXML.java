import parse.xml.MainDOM;
import parse.xml.MainSax;

public class MainXML {
    public static void main(String[] args) {
//        MainDOM mainDOM = new MainDOM();
//        mainDOM.parseXML();

        MainSax mainSax = new MainSax();
        mainSax.parseXML();
    }
}
