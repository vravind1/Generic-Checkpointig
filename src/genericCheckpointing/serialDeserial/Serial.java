package genericCheckpointing.serialDeserial;

import genericCheckpointing.Strategy.Strategy;
import genericCheckpointing.util.SerializableObject;

import java.io.BufferedWriter;
import java.io.IOException;
import java.lang.reflect.Field;
import java.util.HashMap;

public class Serial implements Strategy {

	@Override
	public Object check(Object[] obj) {
		SerializableObject sObj = (SerializableObject)obj[0];
		BufferedWriter bw = (BufferedWriter) obj[1];
		Field[] item = sObj.getClass().getDeclaredFields();
		HashMap<String, String> map = new HashMap<String, String>();
		for (int i = 0; i < item.length; i++) {
			if (item[i].getType().getName().equalsIgnoreCase("int")) {
				map.put("int", "int");
			} else if (item[i].getType().getName().equalsIgnoreCase("double")) {
				map.put("double", "double");
			} else if (item[i].getType().getName().equalsIgnoreCase("java.lang.String")) {
				map.put("java.lang.String", "string");
			} else if (item[i].getType().getName().equalsIgnoreCase("char")) {
				map.put("char", "char");
			} else if (item[i].getType().getName().equalsIgnoreCase("long")) {
				map.put("long", "long");
			} else if (item[i].getType().getName().equalsIgnoreCase("short")) {
				map.put("short", "short");
			} else if (item[i].getType().getName().equalsIgnoreCase("float")) {
				map.put("float", "float");
			}
		}
		try {
			bw.write("<DPSerialization>");
			bw.newLine();
			bw.write(" <complexType xsi:type=" + "\""
					+ sObj.getClass().getName() + "\"" + ">");
			bw.newLine();
			for (int i = 0; i < item.length; i++) {
				item[i].setAccessible(true);
				bw.write("  <" + item[i].getName() + " xsi:type=" + "\""
								+ "xsd:" + map.get(item[i].getType().getName())
								+ "\"" + ">" + item[i].get(sObj) + "</"
								+ item[i].getName() + ">");
				bw.newLine();
			}
			bw.write(" </complexType>");
			bw.newLine();
			bw.write("</DPSerialization>");
			bw.newLine();
		} catch (IllegalArgumentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
}