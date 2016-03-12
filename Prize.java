package com.redmart.prize;

import java.io.*;

public class Prize {
	private final static int OFS_PROD_ID = 0;
	private final static int OFS_PRICE = 1;
	private final static int OFS_VOLUME = 2;
	private final static int OFS_WEIGHT = 3;
	private final static int PROD_SIZE = 20000;
	
	private static int[][] files = new int[PROD_SIZE][4];
	//private static String file = "";
	private static String[] data;

	public static void main(String[] args){
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int i = 0, volume = 0;
		
		while(i < 6){
			try{
				data = br.readLine().split(",");
					
					files[i][OFS_PROD_ID] = Integer.parseInt(data[OFS_PROD_ID]);
					files[i][OFS_PRICE] = Integer.parseInt(data[OFS_PRICE]);
					volume = (Integer.parseInt(data[OFS_VOLUME]) * Integer.parseInt(data[OFS_VOLUME + 1]) *
							Integer.parseInt(data[OFS_VOLUME + 2])); // get length, width, height
					files[i][OFS_VOLUME] = volume;
					files[i][OFS_WEIGHT] = Integer.parseInt(data[OFS_WEIGHT + 2]); // skip offset width and height

			}catch(Exception e){}
			i++;
		}
		
		for(int y = 0; y < 6; y++){
			for(int z = 0; z < 4; z++)
				System.out.print(files[y][z]);
			System.out.println();
		}
		
	}
}
