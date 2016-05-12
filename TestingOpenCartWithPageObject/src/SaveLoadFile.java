import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.openqa.selenium.remote.RemoteWebDriver;

public class SaveLoadFile {

	public SaveLoadFile() {
		
	}

	public static void SaveFile(RemoteWebDriver driver) {

		FileWriter fichero = null;
		PrintWriter pw = null;
		try {
			fichero = new FileWriter(
					"ListaProductos.txt");
			pw = new PrintWriter(fichero);

			String producto;
			boolean seguirBuscando;
			int posProducto;
			List<String> listaProductos = new ArrayList<String>();
			String letrasYNumeros = "abcdefghijklmnopqrstuvwxyz0123456789";
			for (int i = 0; i < letrasYNumeros.length(); i++) {
				producto = "";

				HomePage storePage = new HomePage(driver);
				storePage.enterItemToSearch("" + letrasYNumeros.charAt(i));
				SearchPage searchPage = storePage.clickSearchButton("" + letrasYNumeros.charAt(i));

				seguirBuscando = true;
				posProducto = 1;

				while (seguirBuscando) {
					try {
						producto = searchPage.getElementName(posProducto);
						if (producto != null && !listaProductos.contains(producto)) {
							listaProductos.add(producto);
							pw.println(producto);
						}
						posProducto++;
					} catch (Exception e) {
						seguirBuscando = false;
					}
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (null != fichero)
					fichero.close();
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
	}

	public static Collection<Object[]> LoadFile() {
		File archivo = null;
		FileReader fr = null;
		BufferedReader br = null;

		Collection<Object[]> params = new ArrayList<>(100);

		try {
			archivo = new File("ListaProductos.txt");
			fr = new FileReader(archivo);
			br = new BufferedReader(fr);

			String linea;

			while ((linea = br.readLine()) != null) {
				params.add(new Object[] { linea, true });
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (null != fr) {
					fr.close();
				}
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
		return params;
	}
}
