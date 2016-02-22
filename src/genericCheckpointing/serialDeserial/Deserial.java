package genericCheckpointing.serialDeserial;

import java.io.BufferedReader;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Hashtable;

import genericCheckpointing.Strategy.Strategy;

public class Deserial implements Strategy {            // NEED TO CHANGE ALL HERE!

	
		@Override
		public Object check(Object[] obj) {
			Hashtable<String, Class> classtab = new Hashtable<String, Class>();
			
			classtab.put("int", Integer.TYPE);
			classtab.put("string", String.class);
			classtab.put("char", Character.TYPE);
			classtab.put("long", Long.TYPE);
			classtab.put("float", Float.TYPE);
			classtab.put("double", Double.TYPE);
			classtab.put("short", Short.TYPE);
			BufferedReader bufR = (BufferedReader)obj[0];
			String type = null;
			String value = null;
			String meth = null;
			Object objref = null;
			Class c = null;
			String line;
			try {
				while ((line = bufR.readLine()) != null && !(line.equals("</DPSerialization>"))) {
						if(line.contains("<complexType")){
							String[] arr = line.split("\"");
							String className = arr[1];
							// System.out.println(arr.length);
							// System.out.println(arr[0]+" --- "+className);
							c = Class.forName(className);
							objref = c.newInstance();
//							Field[] f1 = c.getDeclaredFields();
//							Method[] allMethods = c.getMethods();
						}else if(line.contains("int")){
							String[] methname = line.split(" ");
							meth = methname[2].substring(1);
							String[] str = line.split(">");
							String[] str2 = str[0].split("=");
							// System.out.println(str2[0]+"--"+str2[1]);
							String[] str3 = str2[1].split(":");
							String[] str4 = str3[1].split("\"");
							type = str4[0];
							String[] str1 = str[1].split("<");
							value = str1[0];
							String[] str5 = str2[0].split(" ");
							String[] str6 = str5[0].split("<");
							// System.out.println("Type:"+type+"value:"+value+"
							// method:"+meth);
							Class c1 = classtab.get(type);
							Method m = c.getMethod("set" + meth, c1);
							Object obArr = getPara(value, type);
							m.invoke(objref, obArr);
						}else if(line.contains("string")){
							String[] methname = line.split(" ");
							meth = methname[2].substring(1);
							String[] str = line.split(">");
							String[] str2 = str[0].split("=");
							String[] str3 = str2[1].split(":");
							String[] str4 = str3[1].split("\"");
							type = str4[0];
							String[] str1 = str[1].split("<");
							value = str1[0];
							String[] str5 = str2[0].split(" ");
							String[] str6 = str5[0].split("<");
							// System.out.println("Type:"+type+"value:"+value+"
							// method:"+meth);
							Class c1 = classtab.get(type);
							Method m = c.getMethod("set" + meth, c1);
							Object obArr = getPara(value, type);
							m.invoke(objref, obArr);	
						}else if(line.contains("char")){
							String[] methname = line.split(" ");
							meth = methname[2].substring(1);
							String[] str = line.split(">");
							String[] str2 = str[0].split("=");
							String[] str3 = str2[1].split(":");
							String[] str4 = str3[1].split("\"");
							type = str4[0];
							String[] str1 = str[1].split("<");
							value = str1[0];
							String[] str5 = str2[0].split(" ");
							String[] str6 = str5[0].split("<");
							// System.out.println("Type:"+type+"value:"+value+"
							// method:"+meth);
							Class c1 = classtab.get(type);
							Method m = c.getMethod("set" + meth, c1);
							Object obArr = getPara(value, type);
							m.invoke(objref, obArr);	
						}else if(line.contains("float")){
							String[] methname = line.split(" ");
							meth = methname[2].substring(1);
							String[] str = line.split(">");
							String[] str2 = str[0].split("=");
							String[] str3 = str2[1].split(":");
							String[] str4 = str3[1].split("\"");
							type = str4[0];
							String[] str1 = str[1].split("<");
							value = str1[0];
							String[] str5 = str2[0].split(" ");
							String[] str6 = str5[0].split("<");
							// System.out.println("Type:"+type+"value:"+value+"
							// method:"+meth);
							Class c1 = classtab.get(type);
							Method m = c.getMethod("set" + meth, c1);
							Object obArr = getPara(value, type);
							m.invoke(objref, obArr);	
						}else if(line.contains("double")){
							String[] methname = line.split(" ");
							meth = methname[2].substring(1);
							String[] str = line.split(">");
							String[] str2 = str[0].split("=");
							String[] str3 = str2[1].split(":");
							String[] str4 = str3[1].split("\"");
							type = str4[0];
							String[] str1 = str[1].split("<");
							value = str1[0];
							String[] str5 = str2[0].split(" ");
							String[] str6 = str5[0].split("<");
							// System.out.println("Type:"+type+"value:"+value+"
							// method:"+meth);
							Class c1 = classtab.get(type);
							Method m = c.getMethod("set" + meth, c1);
							Object obArr = getPara(value, type);
							m.invoke(objref, obArr);	
						}else if(line.contains("long")){
							String[] methname = line.split(" ");
							meth = methname[2].substring(1);
							String[] str = line.split(">");
							String[] str2 = str[0].split("=");
							String[] str3 = str2[1].split(":");
							String[] str4 = str3[1].split("\"");
							type = str4[0];
							String[] str1 = str[1].split("<");
							value = str1[0];
							String[] str5 = str2[0].split(" ");
							String[] str6 = str5[0].split("<");
							// System.out.println("Type:"+type+"value:"+value+"
							// method:"+meth);
							Class c1 = classtab.get(type);
							Method m = c.getMethod("set" + meth, c1);
							Object obArr = getPara(value, type);
							m.invoke(objref, obArr);	
						}else if(line.contains("short")){
							String[] methname = line.split(" ");
							meth = methname[2].substring(1);
							String[] str = line.split(">");
							String[] str2 = str[0].split("=");
							String[] str3 = str2[1].split(":");
							String[] str4 = str3[1].split("\"");
							type = str4[0];
							String[] str1 = str[1].split("<");
							value = str1[0];
							String[] str5 = str2[0].split(" ");
							String[] str6 = str5[0].split("<");
							// System.out.println("Type:"+type+"value:"+value+"
							// method:"+meth);
							Class c1 = classtab.get(type);
							Method m = c.getMethod("set" + meth, c1);
							Object obArr = getPara(value, type);
							m.invoke(objref, obArr);	
						}
				}
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (InstantiationException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IllegalAccessException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (SecurityException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (NoSuchMethodException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IllegalArgumentException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (InvocationTargetException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return objref;
		}

	/**
	 * Method to return value
	 * 
	 * @param value
	 * @param type
	 * @return
	 */
	private Object getPara(String value, String type) {
		Object objarr = null;
		if (type.equalsIgnoreCase("int")) {
			objarr = Integer.parseInt(value);
		} else if (type.equalsIgnoreCase("string")) {
			objarr = value;
		} else if (type.equalsIgnoreCase("char")) {
			objarr = value.charAt(0);
		} else if (type.equalsIgnoreCase("double")) {
			objarr = Double.parseDouble(value);
		} else if (type.equalsIgnoreCase("float")) {
			objarr = Float.parseFloat(value);
		} else if (type.equalsIgnoreCase("long")) {
			objarr = Long.parseLong(value);
		} else if (type.equalsIgnoreCase("short")) {
			objarr = Short.parseShort(value);
		}
		return objarr;
	}
}