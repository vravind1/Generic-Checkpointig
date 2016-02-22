package genericCheckpointing.driver;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Vector;

import genericCheckpointing.Strategy.Strategy;
import genericCheckpointing.serialDeserial.Deserial;
import genericCheckpointing.serialDeserial.Serial;
import genericCheckpointing.server.RestoreI;
import genericCheckpointing.server.StoreI;
import genericCheckpointing.server.StoreRestoreI;
import genericCheckpointing.util.MyAllTypesFirst;
import genericCheckpointing.util.MyAllTypesSecond;
import genericCheckpointing.util.ProxyCreator;
import genericCheckpointing.util.SerializableObject;
import genericCheckpointing.xmlStoreRestore.StoreRestoreHandler;

public class Driver {

	public static void main(String[] args) {

		// FIXME: read the value of checkpointFile from the command line
		int argsLen = args.length;
		validate(args, argsLen);
		int NUM_OF_OBJECTS = Integer.parseInt(args[0]);
		String checkpointFile = args[1];
		String choice = args[2];
		ProxyCreator pc = new ProxyCreator();

		// create an instance of StoreRestoreHandler (which implements
		// the InvocationHandler
		// StoreRestoreHandler srObj = new StoreRestoreHandler();

		// create a proxy
		StoreRestoreI cpointRef = (StoreRestoreI) pc.createProxy(new Class[] {
				StoreI.class, RestoreI.class }, new StoreRestoreHandler());

		// FIXME: invoke a method on the handler instance to set the file name
		// for checkpointFile and open the file

		MyAllTypesFirst myFirst;
		MyAllTypesSecond mySecond;
		BufferedWriter bufW = null;

		// create a vector to store the objects being serialized

		Vector<SerializableObject> serVec = new Vector<SerializableObject>();

		// bufW = srObj.openWriter();

		try {
			bufW = new BufferedWriter(new FileWriter(checkpointFile));
		} catch (IOException e) {
			e.printStackTrace();
			System.err.println("File not found");
			System.exit(1);
		}

		if (choice.equalsIgnoreCase("ser")
				|| choice.equalsIgnoreCase("serdeser")) {
			Strategy strategy = new Serial();
			for (int i = 0; i < NUM_OF_OBJECTS; i++) {
				// FIXME: create these object instances correctly.
				myFirst = new MyAllTypesFirst();
				mySecond = new MyAllTypesSecond();
				serVec.add(myFirst);
				serVec.add(mySecond);
			}
			// FIXME: store myFirst and mySecond in the vector

			for (SerializableObject sObj : serVec) {
				if (sObj instanceof MyAllTypesFirst) {
					((StoreI) cpointRef).writeObj((MyAllTypesFirst) sObj,
							strategy, bufW);
				} else {
					((StoreI) cpointRef).writeObj((MyAllTypesSecond) sObj,
							strategy, bufW);
				}
			}
		}
		// srObj.closeWriter();

		try {
			// this.bufW.flush();
			bufW.close();
		} catch (IOException e) {
			e.printStackTrace();
			System.exit(1);
		}

		SerializableObject myRecordRet;
		int match = 0;
		int miss = 0;

		BufferedReader bufR = null;
		// bufR = srObj.openReader();
		try {
			bufR = new BufferedReader(new FileReader(checkpointFile));
		} catch (IOException e) {
			e.printStackTrace();
			System.err.println("File not found");
			System.exit(1);
		}

		// create a vector to store the returned ojects
		// Vector<SerializableObject> deserVec = srObj.getVec();
		Vector<SerializableObject> deserVec = new Vector<SerializableObject>(); //changes done 

		if (choice.equalsIgnoreCase("deser")
				|| choice.equalsIgnoreCase("serdeser")) {
			Strategy strategy = new Deserial();
			for (int j = 0; j < 2 * NUM_OF_OBJECTS; j++) {
				myRecordRet = ((RestoreI) cpointRef).readObj(strategy, bufR);
				// FIXME: store myRecordRet in the vector
				deserVec.add(myRecordRet);
			}
			for (int i = 0; i < serVec.size(); i++) {
				if (serVec.get(i).equals(deserVec.get(i))) {
					match++;
				} else {
					miss++;
				}
			}
			System.out.println("Number of Matches : " + match);
			System.out.println("Number of Mis-Matches : " + miss);
		}

		// FIXME: invoke a method on the handler to close the file (if it hasn't
		// already been closed

		// srObj.closeReader();

		try {
			bufR.close();
		} catch (IOException e) {
			e.printStackTrace();
			System.exit(1);
		}
	}

	// FIXME: compare and confirm that the serialized and deserialzed objects
	// are equal

	public static boolean checkInteger(String arg) {
		try {
			Integer.parseInt(arg);
		} catch (NumberFormatException e) {
			return false;
		}
		return true;
	}

	public static void validate(String[] args, int argsLen) {
		if (argsLen != 3) {
			System.err.println("Invalid argument length");
			System.exit(0);
		} else if (args[0] == null) {
			System.err.println("Please enter valid number of objects!");
			System.exit(0);
		} else if (args[1] == null) {
			System.err.println("Please enter the checkpoint file!");
			System.exit(0);
		} else if (args[1] == null) {
			System.err
					.println("Please enter the valid choice[ser or deser or serdeser]!");
			System.exit(0);
		} else if (checkInteger(args[0]) != true) {
			System.err.println("Please enter a valid integer number!");
			System.exit(0);
		}
	}
}