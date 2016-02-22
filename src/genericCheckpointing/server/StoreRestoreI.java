package genericCheckpointing.server;

import java.io.BufferedReader;
import java.io.BufferedWriter;

import genericCheckpointing.Strategy.Strategy;
import genericCheckpointing.util.MyAllTypesFirst;
import genericCheckpointing.util.MyAllTypesSecond;
import genericCheckpointing.util.SerializableObject;


public interface StoreRestoreI {
	SerializableObject readObj(Strategy strategy, BufferedReader bufR);
	void writeObj(MyAllTypesFirst aRecord, Strategy strategy, BufferedWriter bufW);
    void writeObj(MyAllTypesSecond aRecord, Strategy strategy, BufferedWriter bufW);

}
