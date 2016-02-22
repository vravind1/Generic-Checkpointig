package genericCheckpointing.server;

import genericCheckpointing.Strategy.Strategy;
import genericCheckpointing.util.MyAllTypesFirst;
import genericCheckpointing.util.MyAllTypesSecond;

import java.io.BufferedWriter;


public interface StoreI extends StoreRestoreI{
	void writeObj(MyAllTypesFirst aRecord, Strategy strategy, BufferedWriter bufW);
    void writeObj(MyAllTypesSecond aRecord, Strategy strategy, BufferedWriter bufW);
}
