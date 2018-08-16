package matlabjava12;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;

import com.mathworks.engine.MatlabEngine;

public class MatlabJava12_main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Future<MatlabEngine> eng = MatlabEngine.startMatlabAsync();
		try {
			MatlabEngine ml = eng.get();
			for(int i = 1; i <= 10; i++) {
				String fileName = "Fe_OFF_phyrifera_";
				fileName += String.format("%06d", i);
				ml.eval("A = imread('tif/"+fileName+".tif');");
				ml.eval("for j = 1:2048 A(j,2049) = j; end");
				ml.eval("csvwrite('csv/"+fileName+".csv',A)");
			}
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ExecutionException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
}
