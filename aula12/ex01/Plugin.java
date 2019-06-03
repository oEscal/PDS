package aula12.ex01;

import com.sun.webkit.plugin.PluginManager;

import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;

public class Plugin {
    public static void main(String[] args) throws Exception {
        File proxyList = new File("bin/reflection");
        ArrayList<IPlugin> plgs = new ArrayList<IPlugin>();
        for (String f: proxyList.list()) {
            if (f.endsWith(".class")) {
                try {
                    plgs.add(PluginManager.load("reflection."
                            + f.substring(0, f.lastIndexOf('.'))));
                } catch (Exception e) {
                    System.out.println("\t" + f + ": Componente ignorado. Não é IPlugin.");
                }
            }
        }
        Iterator<IPlugin> it = plgs.iterator();
        while (it.hasNext()) {
            it.next().metodo();
        }
    }
}
