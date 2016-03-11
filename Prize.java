package com.redmart.prize;

import java.io.*;

public class Prize {
	static int[][] files = new int[2000][6];
	static String file = "";
	static String[] data;
	
	final static int OFS_VOLUME = 3;
	
	public static void main(String[] args){
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int i = 0;
		while(i < 6){
			try{
				data = br.readLine().split(",");
				for(int x = 0; x < data.length; x++){
					files[i][x] = Integer.parseInt(data[x]);
				}
				files[i][OFS_VOLUME] = files[i][3] * files [i][4];
			}catch(Exception e){}
			i++;
		}
		for(int y = 0; y < 6; y++){
			for(int z = 0; z < 6; z++)
				System.out.print(files[y][z]);
			System.out.println();
		}
		
	}
}
