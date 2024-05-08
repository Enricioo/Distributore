package org.generation.italy;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		// Creazione scanner
		Scanner sc = new Scanner(System.in);
		int i;
		int codiceInserito, livZucchero, creditoUtente, creditoMacchina;
		creditoMacchina = 0;
		// Creazione variabili e array
		String[] nomeProdotto = { "Acqua", "Pepsi", "Caffè", "The", "Cioccolata" };
		int[] codiceProdotto = { 1, 2, 3, 4, 5 };
		double[] prezzoProdotto = { 1.2, 2.5, 1, 1.5, 2 };
		int[] quantitaProdotto = { 3, 2, 1, 3, 2 };
		int[] bevandaFredda = { 1, 1, 0, 1, 0 };
		boolean codiceValido = false;
		boolean zuccheroValido = false;
		
		for (i = 0; i < codiceProdotto.length; i++) {
			System.out.println(
					"Codice: " + codiceProdotto[i] + " Nome : " + nomeProdotto[i] + " Prezzo: " + prezzoProdotto[i]);
		}
		// TODO inserimento credito
		// Inizio do while per verificare se il codice e la quantità del prodotto sono validi
		do { 
			

			// Inserimento codice
			System.out.println("Inserisci il codice del prodotto desiderato: ");
			codiceInserito = sc.nextInt();
			
			
			for (i = 0; i < codiceProdotto.length; i++) {
				if (codiceInserito == codiceProdotto[i]) {
					if (quantitaProdotto[i] > 0) {
						System.out.println("Hai selezionato il prodotto: " + nomeProdotto[i]);
						System.out.println("Il prezzo è di " + prezzoProdotto[i] + "€");
						codiceValido = true;
						quantitaProdotto[i] = quantitaProdotto[i] - 1;
					} else {
						System.out.println("Prodotto non disponibile. Scegli un altro prodotto.");
					}
					
//					// Inserimento credito
//					System.out.println("Inserisci credito: ");
//					creditoUtente = sc.nextInt();
//					creditoMacchina = creditoUtente + creditoMacchina;
//					System.out.println("Il credito è di: " + creditoMacchina + "€");
//					
					
					if (bevandaFredda[i] > 0) {
						System.out.println("Erogazione prodotto...");
					} else {
						do { // Inizio secondo do while per verifica validità zucchero
							System.out.println("Inserisci livello di zuccherro da 1 a 5");
							livZucchero = sc.nextInt();
							if (livZucchero > 0 && livZucchero <= 5) {
								System.out
										.println("Erogazione bicchiere di plastica, zucchero e bastoncino di legno...");
								zuccheroValido = true;
							} else {
								System.out.println("Livello zucchero errato, riprovare.");
							}
						} while (!zuccheroValido);
					}

				}
				if (!codiceValido) {
					System.out.println("Codice inserito non è valido, riprova. ");
				} else {
					codiceValido = true;
				}
			}
		} while (!codiceValido); // Fine primo do while

	}

}
