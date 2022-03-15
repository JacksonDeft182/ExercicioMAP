package application;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;

public class Program {

		public static void main(String[] args){
			Locale.setDefault(Locale.US);
			
			File filePath = new File("C:\\Projeto_Fixacao_Java\\Arquivos\\votos.csv");
			String fileProcessed = "C:\\Projeto_Fixacao_Java\\Arquivos\\out\\votosProcessados.csv";
			
			Map<String, Integer> votes = new HashMap<>();
	
			try(BufferedReader br = new BufferedReader(new FileReader(filePath))){
			
				String line = br.readLine();
				
				while(line != null) {
					String[] splitLine = line.split(",");
					String name = splitLine[0];
					
					if(votes != null) {
						
						if(votes.containsKey(name)){
							
							int sumVote = votes.get(splitLine[0]) + Integer.parseInt(splitLine[1]);
							votes.put(name, sumVote);	
						}
						else {
							
							votes.put(name,Integer.parseInt(splitLine[1]));
						}
					}
					
					 line = br.readLine();
				}
			
			}catch(IOException e) {
				System.out.print("Erro: " + e.getMessage());
			}
			
			
			try(BufferedWriter bw = new BufferedWriter(new FileWriter(fileProcessed))){
				
				for(String vote: votes.keySet()) {
					bw.write(vote + ": " + votes.get(vote) + " votos");
					bw.newLine();
				}
			}catch(IOException e) {
				System.out.print("ERROR: "+e.getMessage());
			}
			
			
			
			
			
			
		}
}
