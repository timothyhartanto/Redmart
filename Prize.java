package com.redmart.prize;

import java.io.*;

public class Prize {
	private final static int OFS_PROD_ID = 0;
	private final static int OFS_PRICE = 1;
	private final static int OFS_LENGTH = 2;
	private final static int OFS_WIDTH = 3;
	private final static int OFS_HEIGHT = 4;
	private final static int OFS_WEIGHT = 5;
	private final static int OFS_VOLUME = 6;
	private final static int OFS_PRICE_RATION = 7;
	
	private final static int PROD_SIZE = 20000;
	private final static int BUFF_SIZE = 8;
	
	private final static int MAX_LENGTH = 45;
	private final static int MAX_WIDTH = 30;
	private final static int MAX_HEIGHT = 35;
	private final static int MAX_VOLUME = MAX_LENGTH * MAX_WIDTH * MAX_HEIGHT;
	
	private static double[][] files = new double[PROD_SIZE][BUFF_SIZE];
	
	private static String[] data;

	public static void main(String[] args){
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		for(int i = 0; i < 6; i++){
			try{
				data = br.readLine().split(",");
				for(int y = 0; y < 6; y++){
					files[i][y] = Double.parseDouble(data[y]);
				}
				
				//if item does fit into the tote, get the volume and the price to volume ration
				if((files[i][OFS_LENGTH] <= MAX_LENGTH) && (files[i][OFS_WIDTH] <= MAX_WIDTH) &&
						(files[i][OFS_HEIGHT] <= MAX_HEIGHT)){
					// get the volume
					files[i][OFS_VOLUME] = files[i][OFS_LENGTH] * files[i][OFS_WIDTH] *
						files[i][OFS_HEIGHT];
					// get the price to volume ratio
					files[i][OFS_PRICE_RATION] = files[i][OFS_PRICE] / files[i][OFS_VOLUME];

				}
				//if item does not fit into the tote, remove it from the list
				else{
					files[i] = new double[BUFF_SIZE];
				}
			}
			catch(Exception e)
			{				
			}
		}
		
		for(int y = 0; y < 6; y++){
			for(int z = 0; z < BUFF_SIZE; z++)
				System.out.print(files[y][z] + " ");
			System.out.println();
		}

		
	}
}
