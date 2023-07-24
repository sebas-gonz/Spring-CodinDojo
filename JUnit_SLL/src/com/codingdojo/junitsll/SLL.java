package com.codingdojo.junitsll;

public class SLL {
	public Node head;

	// Crear un método constructor para establecer head en null para los objetos de
	// su SinglyLinkedList.

	public SLL() {
		this.head = null;
	}

	// Los metodos de la SLL van aqui. Al principio, les mostraremos cómo agregar
	// nodos a la lista.
	public void add(int value) {
		Node newNode = new Node(value);

		if (head == null) {
			head = newNode;
		} else {
			Node runner = head;
			while (runner.next != null) {
				runner = runner.next;
			}
			runner.next = newNode;
		}
	}

	// Crear un método remove() que removerá un nodo del final de su lista.

	public void remove() {
		if (head == null) {
			return;
		} else if (head.next == null) {
			head = null;
		} else {
			Node runner = head;
			Node anterior = runner;
			while (runner.next != null) {
				anterior = runner;
				runner = runner.next;
			}
			anterior.next = null;
			runner = anterior;

		}

	}
	// Crear un método printValues() que mostrará en pantalla todos los valores de
	// cada nodo de la lista en el mismo orden que fue creada.

	public void printValues() {
		Node runner = head;

		while (runner != null) {
			System.out.println(runner.value);
			runner = runner.next;
		}
	}

	// Implementar un método find(int) que retornará el primer nodo con el valor
	// dado en los parámetros.

	public void find(int valor) {
		Node runner = head;
		boolean encontrado = false;
		while (runner != null) {
			if (runner.value == valor) {
				System.out.println(runner.value);
				encontrado = true;

			}
			runner = runner.next;
		}
		if (!encontrado) {
			System.out.println("No se encuentra el valor");
		}
	}

	// Implementar un método removeAt(int) que removerá un nodo después de n nodos,
	// donde n es el parámetro
	// Por ejemplo, si n es 0 removerá el primer nodo, si n es 1 removerá el segundo
	// nodo. Similar a los arrays.

	public void removeAt(int numero) {
		if (head != null && numero >= 0) {
			if (numero == 0) {
				head = head.next;
			} else if (numero == 0) {

				head = head.next;
			} else {
				Node runner = head;
				int contador = 0;
				while (runner != null && contador < numero) {
					if (contador == numero - 1 && runner.next != null) {
						runner.next = runner.next.next;
						System.out.println("\n Nodo eliminado");
						break;
					}
					runner = runner.next;
					contador++;
				}
			}
		}
	}
	
	public void removeFront() {
		if(head != null) {
			head = head.next;
		}
	}
}
