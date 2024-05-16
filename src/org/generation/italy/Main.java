package org.generation.italy;

import java.util.Scanner;

public class Main {
	public static void main(String[] args) {

		// Creazione scanner
		Scanner sc = new Scanner(System.in);
		int i;
		int codiceInserito, livZucchero, codiceGestore, codiceModifica;
		double creditoUtente, creditoMacchina;
		creditoMacchina = 0;
		// Creazione variabili e array
		String[] nomeProdotto = { "Acqua", "Pepsi", "Caffè", "The", "Cioccolata" };
		int[] codiceProdotto = { 1, 2, 3, 4, 5 };
		double[] prezzoProdotto = { 1.2, 2.5, 1, 1.5, 2 };
		int[] quantitaProdotto = { 3, 2, 2, 0, 2 };
		int[] bevandaFredda = { 1, 1, 0, 1, 0 };
		boolean codiceValido = false;
		boolean zuccheroValido = false;
		boolean modifica;
		String nuovoNome;
		int nuovoPrezzo, nuovaQuantita;

		String risposta;
		double resto = 0;

		// Inizio do-while per ricominciare ad acquistare
		do {
			codiceInserito = 0;
			creditoUtente = 0;
			// Visualizzazione credito e aumento dal credito inserito
			System.out.println("Credito: " + creditoMacchina + "€");
			System.out.println("Inserisci monete: ");
			creditoUtente = sc.nextDouble();
			creditoMacchina += creditoUtente;
			System.out.println("Credito: " + creditoMacchina + "€");
			risposta = "n";

			// Stampa elenco prodotti
			for (i = 0; i < codiceProdotto.length; i++) {
				System.out.println("Codice: " + codiceProdotto[i] + " |" + " Nome: " + nomeProdotto[i] + " |"
						+ " Prezzo: " + prezzoProdotto[i] + "€" + " |" + " Quantita: " + quantitaProdotto[i]);
			}
			do { // Inizio do-while per verificare se il codice è valido

				// Inserimento codice
				System.out.println("Inserisci il codice del prodotto desiderato: ");
				codiceValido = false;
				codiceInserito = sc.nextInt();
				sc.nextLine();

				for (i = 0; i < codiceProdotto.length; i++)
					// Verifica codice inserito
					if (codiceInserito == codiceProdotto[i]) {
						System.out.println("Hai selezionato il prodotto: " + nomeProdotto[i]);
						codiceValido = true;

						do { // Inizio do while per verificare validità del prodotto

							// Verifica che il prodotto sia disponibile
							if (quantitaProdotto[i] == 0) {
								System.out.println("Prodotto non disponibile...");
								codiceValido = false;
								break;
								// Riduzione della quantità dall'array se il prodotto è disponibile
							} else {
								quantitaProdotto[i]--;
							}

							// Verifica se l'importo è sufficiente
							if (creditoMacchina >= prezzoProdotto[i]) {
								resto = creditoMacchina - prezzoProdotto[i];
								// Verifica se il resto è disponibile
								if (resto >= 0) {
									System.out.println("Erogazione resto di " + resto + " €...");
									creditoUtente = 0;
								}
								// Se l'importo non è sufficiente reinserire credito
							} else {
								System.out.println("Credito insufficiente, inserire l'importo di: "
										+ (prezzoProdotto[i] - creditoMacchina) + "€");
								System.out.println("Inserire credito: ");
								creditoMacchina += sc.nextDouble();
								sc.nextLine();
							}

							// Verifica se la bevanda è fredda o meno
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
							// Fine do while per verifica importo sufficiente
						} while (creditoMacchina < prezzoProdotto[i]);
						
						creditoMacchina -= prezzoProdotto[i];
						creditoMacchina = 0;
						creditoMacchina += resto;
						resto = 0;
						
						// Se codice inserito = 300 allora entra nella pagina gestore
					} else if (codiceInserito == 300) {
						System.out.println("Benvenuto nella gestione dei prodotti!");
						modifica = true;

						// Inizio do while per la modifica del prodotto
						do {
							// Mostra schermata di gestione
							System.out.println("1. Modifica quantità prodotto");
							System.out.println("2. Modifica nome prodotto");
							System.out.println("3. Modifica prezzo prodotto");
							System.out.println("4. Esci dalla gestione");
							System.out.println("Seleziona un'opzione: ");
							codiceGestore = sc.nextInt();
							sc.nextLine();

							// Aggiornamento quantità
							if (codiceGestore == 1) {
								// Inserimento codice prodotto da modificare
								System.out.println("Inserisci codice prodotto da modificare: ");
								codiceModifica = sc.nextInt();
								sc.nextLine();
								System.out.println("Inserisci nuova quantità: ");
								nuovaQuantita = sc.nextInt();
								sc.nextLine();
								quantitaProdotto[i] += nuovaQuantita;
								// Aggiornamento nome
							} else if (codiceGestore == 2) {
								// Inserimento codice prodotto da modificare
								System.out.println("Inserisci codice prodotto da modificare: ");
								codiceModifica = sc.nextInt();
								sc.nextLine();
								System.out.println("Inserisci nuovo nome: ");
								nuovoNome = sc.nextLine();
								nomeProdotto[i] = nuovoNome;
								// Aggiornamento prezzo
							} else if (codiceGestore == 3) {
								// Inserimento codice prodotto da modificare
								System.out.println("Inserisci codice prodotto da modificare: ");
								codiceModifica = sc.nextInt();
								sc.nextLine();
								System.out.println("Inserisci nuovo prezzo prodotto: ");
								nuovoPrezzo = sc.nextInt();
								sc.nextLine();
								prezzoProdotto[i] = nuovoPrezzo;
								// Uscita dalla gestione
							} else if (codiceGestore == 4) {
								modifica = false;
								break;
							}
							// Stampa elenco prodotti
							for (i = 0; i < codiceProdotto.length; i++) {
								System.out.println("Codice: " + codiceProdotto[i] + " |" + " Nome: " + nomeProdotto[i]
										+ " |" + " Prezzo: " + prezzoProdotto[i] + "€" + " |" + " Quantita: "
										+ quantitaProdotto[i]);
							}
							System.out.println();
						} while (!modifica);

					} else {
						System.out.println("Il codice inserito non è valido, riprova.");
					}

				// Fine ciclo do while per verifica codice
			} while (!codiceValido);

			System.out.println("Vuoi acquistare un altro prodotto?");
			risposta = sc.nextLine();

		} while (risposta.equalsIgnoreCase("s"));
		System.out.println("Arrivederci.");
	}
}