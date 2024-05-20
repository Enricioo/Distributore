package org.generation.italy;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {

		// Creazione scanner
		Scanner sc = new Scanner(System.in);
		int i;
		int codInserito, livZucchero, codGestore, codModifica;
		double credUtente, credMacchina = 0;
		// Creazione variabili e array
		String[] nomeProdotto = { "Acqua", "Pepsi", "Caffè", "The", "Cioccolata" };
		int[] codProdotto = { 1, 2, 3, 4, 5 };
		double[] prezzoProdotto = { 1.2, 2.5, 1, 1.5, 2 };
		int[] qtaProdotto = { 3, 2, 2, 0, 2 };
		int[] bevandaFredda = { 1, 1, 0, 1, 0 };
		boolean codValido, prodValido, modifica, codModificaValido, zuccheroValido;
		String nuovoNome;
		int nuovoPrezzo, nuovaQta;
		String risposta;
		double resto;

		// Inizio ciclo acquisto
		do {
			// Stampa elenco prodotti
			for (i = 0; i < codProdotto.length; i++) {
				System.out.println("Codice: " + codProdotto[i] + " |" + " Nome: " + nomeProdotto[i] + " |" + " Prezzo: "
						+ prezzoProdotto[i] + "€" + " |" + " Quantità: " + qtaProdotto[i]);
			}
			System.out.println("Credito: " + credMacchina + "€");
			System.out.println("Inserisci credito: ");
			credUtente = sc.nextDouble();
			sc.nextLine();
			credMacchina += credUtente;

			// Inizio ciclo per verifica codice
			do {
				resto = 0;
				modifica = false;
				codValido = false;
				credUtente = 0;
				zuccheroValido = false;
				System.out.println("Credito: " + credMacchina + "€");
				System.out.println("Inserire codice del prodotto...");
				codInserito = sc.nextInt();
				sc.nextLine();
				// Verifica se il codice è uguale al prodotto per proseguire con l'acquisto
				for (i = 0; i < codProdotto.length; i++) {
					if (codInserito == codProdotto[i]) {
						System.out.println("Hai selezionato il prodotto: " + nomeProdotto[i]);
						codValido = true;
						break;
					}
				}
				// Verifica se il codice è uguale a 300 per entrare nella gestione prodotti
				if (codInserito == 300) {
					System.out.println("Benvenuto nella gestione dei prodotti!");
					modifica = true;
					break;
					// Verifica se il codice è uguale a 301 per ritiro credito residuo
				}  else if (codInserito == 301) {
					System.out.println("Ritiro del credito residuo...");
					credUtente += credMacchina;
					System.out.println("Stai ritirando " + credMacchina + "€");
					credMacchina = 0;
					// Verifica se il codice è errato
				} else if (!codValido && codInserito != 0) {
					System.out.println("Codice errato, si prega di reinserire il codice...");
				}

			} while (!codValido);
			// Verifica di modifica false per proseguire con acquisto prodotto
			if (!modifica) {
				// Inizio ciclo per verifica quantità prodotto
				do {
					prodValido = false;
					// Verifica se il prodotto è disponibile
					if (qtaProdotto[i] == 0) {
						System.out.println("Prodotto non disponibile, reinserire il codice...");
						break;
					} else {
						prodValido = true;
						qtaProdotto[i]--;
					}
					// Fine ciclo per verifica prodotto
				} while (!prodValido);

				// Se il prodotto è valido allora verifica se il credito è sufficiente
				if (prodValido) {

					if (credMacchina >= prezzoProdotto[i]) {
						resto = credMacchina - prezzoProdotto[i];
						if (resto >= 0) {
							System.out.println("Erogazione resto di " + resto + " €...");
							credUtente = 0;
							credMacchina = 0;
							credMacchina += resto;
							resto = 0;
						}
						// Continua fino a quando il credito non è sufficiente per l'acquisto del prodotto
					} else {
						do  {
							System.out.println("Credito insufficiente, inserire l'importo di: " + (prezzoProdotto[i] - credMacchina) + "€");
							System.out.println("Inserire credito: ");
							credMacchina += sc.nextDouble();
							sc.nextLine();
						} while (credMacchina < prezzoProdotto[i]);
					}
				}
				// Verifica se la bevanda è fredda o no
				if (bevandaFredda[i] > 0) {
					System.out.println("Erogazione prodotto...");

				} else {
					// Inizio ciclo per verifica zucchero
					while (!zuccheroValido) {
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
					}
				}
				// Entra nella gestione prodotti se modifica è su true
			} else if (modifica) {
				// Rimane nella gestione prodotti finchè modifica è su true
				while (modifica) {
					codModificaValido = false;
					// Mostra schermata di gestione
					System.out.println("1. Modifica quantità prodotto");
					System.out.println("2. Modifica nome prodotto");
					System.out.println("3. Modifica prezzo prodotto");
					System.out.println("4. Esci dalla gestione");
					System.out.println("Seleziona un'opzione: ");
					codGestore = sc.nextInt();
					sc.nextLine();
						// Inserimento codice prodotto da modificare
						System.out.println("Inserisci codice prodotto da modificare: ");
						codModifica = sc.nextInt();
						sc.nextLine();
						// Verifica se il codice è valido
						for (i = 0; i < codProdotto.length; i++) {
							if (codModifica == codProdotto[i]) {
								codModificaValido = true;
								break;
							}
						}
					System.out.println("Hai selezionato il prodotto: " + nomeProdotto[i]);
					// Se il codice è valido entra nella modifica del prodotto selezionato
					if (codModificaValido) {
						// Aggiornamento quantità
						if (codGestore == 1) {
							System.out.println("Inserisci nuova quantità: ");
							nuovaQta = sc.nextInt();
							sc.nextLine();
							qtaProdotto[i] += nuovaQta;
							// Aggiornamento nome
						} else if (codGestore == 2) {
							System.out.println("Inserisci nuovo nome: ");
							nuovoNome = sc.nextLine();
							nomeProdotto[i] = nuovoNome;
							// Aggiornamento prezzo
						} else if (codGestore == 3) {
							System.out.println("Inserisci nuovo prezzo prodotto: ");
							nuovoPrezzo = sc.nextInt();
							sc.nextLine();
							prezzoProdotto[i] = nuovoPrezzo;
							// Uscita dalla gestione
						} else if (codGestore == 4) {
							modifica = false;
							break;
						}
					}
					// Mostra prodotti per verificare le modifiche apportate
					for (i = 0; i < codProdotto.length; i++) {
						System.out.println("Codice: " + codProdotto[i] + " |" + " Nome: " + nomeProdotto[i] + " |"
								+ " Prezzo: " + prezzoProdotto[i] + "€" + " |" + " Quantità: " + qtaProdotto[i]);
					}
				}
			}
			// Mostra messaggio di fine ciclo acquisto
			System.out.println("Acquistare un altro prodotto?");
			risposta = sc.nextLine();

		} while (risposta.equalsIgnoreCase("s"));
	}

}
