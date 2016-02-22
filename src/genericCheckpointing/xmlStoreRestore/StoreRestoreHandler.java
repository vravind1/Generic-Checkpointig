package genericCheckpointing.xmlStoreRestore;

import genericCheckpointing.Strategy.Strategy;
import genericCheckpointing.util.SerializableObject;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

public class StoreRestoreHandler implements InvocationHandler{

	
	public StoreRestoreHandler() {
	}

	BufferedReader br = null;
	BufferedWriter bw = null;
	SerializableObject sObj;
	
	
	@Override
	public Object invoke(Object proxy, Method method, Object[] args)
			throws Throwable {
		Object obj = null;

		if (method.getName().equals("writeObj")) {
			bw = (BufferedWriter) args[2];
			Strategy strategy = (Strategy)args[1];
			Object[] param = new Object[2];
			param[0] = args[0];
			param[1] = bw;
			strategy.check(param);
		}

		if (method.getName().equals("readObj")) {
			br = (BufferedReader) args[1];
			Object[] param = new Object[1];
			param[0] = br;
			Strategy strategy = (Strategy) args[0];
			obj = strategy.check(param);
		}
		return obj;
	}
}