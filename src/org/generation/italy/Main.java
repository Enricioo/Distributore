package org.generation.italy;

import java.util.Scanner;

public class Main {
	public static void main(String[] args) {

		// Creazione scanner
		Scanner sc = new Scanner(System.in);
		int i;
		int codiceInserito, livZucchero;
		double creditoUtente, creditoMacchina;
		creditoMacchina = 0;
		// Creazione variabili e array
		String[] nomeProdotto = { "Acqua", "Pepsi", "Caffè", "The", "Cioccolata" };
		int[] codiceProdotto = { 1, 2, 3, 4, 5 };
		double[] prezzoProdotto = { 1.2, 2.5, 1, 1.5, 2 };
		int[] quantitaProdotto = { 3, 2, 2, 1, 2 };
		int[] bevandaFredda = { 1, 1, 0, 1, 0 };
		boolean codiceValido = false;
		boolean zuccheroValido = false;
		boolean quantitaValida = false;
		String risposta;
		double resto = 0;

		// Inizio do-while per ricominciare ad acquistare
		do {
			// Visualizzazione credito e aumento dal credito inserito
			System.out.println("Credito: " + creditoMacchina + "€");
			System.out.println("Inserisci monete: ");
			creditoUtente = sc.nextInt();
			creditoMacchina = creditoUtente + creditoMacchina;
			System.out.println("Credito: " + creditoMacchina + "€");
			risposta = "n";
			
			for (i = 0; i < codiceProdotto.length; i++) {
				System.out.println("Codice: " + codiceProdotto[i] + " |" + " Nome: " + nomeProdotto[i] + " |"
						+ " Prezzo: " + prezzoProdotto[i] + "€");
			}
			do { // Inizio do-while per verificare se il codice è valido
					// Inserimento codice
				System.out.println("Inserisci il codice del prodotto desiderato: ");
				codiceInserito = sc.nextInt();
				sc.nextLine();
				codiceValido = false;

				for (i = 0; i < codiceProdotto.length; i++) 
					// Verifica codice inserito
					if (codiceInserito == codiceProdotto[i]) {
						System.out.println("Hai selezionato il prodotto: " + nomeProdotto[i]);
						codiceValido = true;
						resto = creditoMacchina;
						do { // Inizio do while per verificare che l'importo sia sufficiente

							// Verifica se l'importo è sufficiente
							if (creditoMacchina >= prezzoProdotto[i]) {
								// TODO Riduzione quantità dall'array + verifica se quantità disponibile
								
								
							}
							resto = creditoMacchina - prezzoProdotto[i];
							creditoMacchina-=prezzoProdotto[i];
							
							// Verifica se il resto è disponibile
							if (resto > 0) {
								System.out.println("Erogazione resto di " + resto + " €...");
								creditoMacchina = resto;
								creditoUtente = 0;
								resto = 0;
							} else {
								System.out.println("Credito insufficiente, inserire l'importo di: "
										+ (prezzoProdotto[i] - creditoMacchina) + "€");
								System.out.println("Inserire credito: ");
								creditoMacchina = creditoUtente + sc.nextDouble();
								sc.nextLine();
							}

							// Fine do while per verifica importo sufficiente
						} while (creditoMacchina < prezzoProdotto[i]);
						
						if (bevandaFredda[i] > 0) {
							System.out.println("Erogazione prodotto...");
						} else {
							do { // Inizio do while per verifica validità zucchero
								System.out.println("Inserisci livello di zuccherro da 1 a 5");
								livZucchero = sc.nextInt();
								sc.nextLine();
								if (livZucchero > 0 && livZucchero <= 5) {
									System.out.println("Erogazione bicchiere di plastica...");
									System.out.println("Erogazione zucchero...");
									System.out.println("Erogazione bastoncino di legno...");
									zuccheroValido = true;
								} else {
									System.out.println("Livello zucchero errato, riprovare.");
								}
								// Fine ciclo do while per verifica di validità zucchero
							} while (!zuccheroValido);
						}

						// Verifica se il codice non è valido
						if (!codiceValido) {
							System.out.println("Il codice inserito non è valido, riprova.");
						}
					}
				
				// Fine ciclo do while per verifica codice
			} while (!codiceValido);

			System.out.println("Vuoi acquistare un altro prodotto?");
			risposta = sc.nextLine();

		} while (risposta.equalsIgnoreCase("s"));
		System.out.println("Arrivederci.");
	}
}