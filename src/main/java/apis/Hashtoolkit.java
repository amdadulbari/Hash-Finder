package apis;

import com.gargoylesoftware.htmlunit.WebClient;
import com.gargoylesoftware.htmlunit.html.DomElement;
import com.gargoylesoftware.htmlunit.html.HtmlPage;
import constants.SettingsConstant;

import java.io.IOException;
import java.net.MalformedURLException;
import java.util.List;

public class Hashtoolkit {
    public boolean doCrack(String hash){
        String baseUrl = "http://hashtoolkit.com/reverse-hash/?hash="+hash;
        WebClient client = new WebClient();
        client.getOptions().setCssEnabled(false);
        client.getOptions().setJavaScriptEnabled(false);
        try {
            HtmlPage page = client.getPage(baseUrl);
            final List<DomElement> spans = page.getElementsByTagName("span");
            for (DomElement element : spans) {
                if (element.getAttribute("title").contains("decrypted")) {
                    System.out.println(SettingsConstant.decryptMSG +element.getTextContent());
                    return true;
                }
            }
        } catch (MalformedURLException e1) {
            e1.printStackTrace();
        } catch (IOException e1) {
            e1.printStackTrace();
        }
        return false;
    }
}
