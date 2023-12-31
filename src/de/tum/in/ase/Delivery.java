package de.tum.in.ase;

import java.util.*;

// TODO: implement interface
public class Delivery implements Iterable<Package> {

	private final String address;
	private final Map<String, Set<Package>> packagesByAddress;

	public Delivery(String address, Map<String, Set<Package>> packages) {
		this.address = address;
		this.packagesByAddress = packages;
	}

	public Delivery(String address) {
		this.address = address;
		this.packagesByAddress = new HashMap<>();
	}


	public String getAddress() {
		return address;
	}

	public void add(Package aPackage) {
		// TODO implement method
		if(packagesByAddress.containsKey(aPackage.getAddress())) {
			packagesByAddress.get(aPackage.getAddress()).add(aPackage);
		} else {
			Set<Package> set = new HashSet<>();
			set.add(aPackage);
			packagesByAddress.put(aPackage.getAddress(), set);
		}

	}

	@Override
	public String toString() {
		return "Delivery:\n  Address: " + address;
	}

	// TODO: implement iterator
	@Override
	public Iterator<Package> iterator() {
		return new Iterator<>() {
			@Override
			public boolean hasNext() {
				return false;
			}

			@Override
			public Package next() {
				return null;
			}
		};
	}



	public static void main(String[] args) {
		// TODO test your code:
		Delivery delivery = new Delivery("Deliveryplace 1");
		delivery.add(new Package("Iceavenue 5", "Penguinway 4", 100));
		delivery.add(new Package("Iceavenue 5", "Penguinway 1", 85));
		delivery.add(new Package("Iceavenue 5", "Penguinway 1", 73));
		delivery.add(new Package("Snowlane 3", "Antarcticplace 3", 107));
		delivery.add(new Package("Winterhighway 89", "Antarcticplace 27", 20));
		delivery.add(new Package("Penguinway 6", "Tierpark Hellabrunn, Tierparkstr. 30", 1));
		delivery.add(new Package("Tierpark Hellabrunn, Tierparkstr. 30", "Penguinway 6", 0.3));
		delivery.add(new Package("Antarcticplace 123", "Penguroad 1", 6));
	}

}
